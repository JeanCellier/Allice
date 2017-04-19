package phenotypage.importation.parser;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import phenotypage.model.cryoconservation.Cryoconservation;
import phenotypage.model.cryoconservation.CryoconservationService;
import phenotypage.model.cryoconservation.TableauDetail;
import phenotypage.model.donneesExistantes.abattoir.Abattoir;
import phenotypage.model.donneesExistantes.abattoir.AbattoirService;
import phenotypage.model.donneesExistantes.fiv.FIV;
import phenotypage.model.donneesExistantes.fiv.FIVService;
import phenotypage.model.donneesExistantes.operateur.Operateur;
import phenotypage.model.donneesExistantes.operateur.OperateurService;
import phenotypage.model.donneesExistantes.programme.Programme;
import phenotypage.model.donneesExistantes.programme.ProgrammeService;
import phenotypage.model.donneesExistantes.typeCulture.TypeCulture;
import phenotypage.model.donneesExistantes.typeCulture.TypeCultureService;
import phenotypage.model.fiche.Fiche;
import phenotypage.model.fiche.ficheAba.FicheAbaService;
import phenotypage.model.informationsPIV.Informations_PIV;
import phenotypage.model.informationsPIV.Informations_PIVService;
import phenotypage.model.invitro.collecte.Collecte;
import phenotypage.model.invitro.collecte.Tableau_Collecte;
import phenotypage.model.invitro.culture.Culture;
import phenotypage.model.invitro.culture.CultureService;
import phenotypage.model.invitro.fecondation.Fecondation;
import phenotypage.model.invitro.fecondation.FecondationService;
import phenotypage.model.milieuMaturation.MilieuMaturation;
import phenotypage.model.milieuMaturation.MilieuMaturationService;
import phenotypage.model.vache.Vache;
import phenotypage.model.vache.VacheService;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created with magic
 * User: simoe
 * Date: 18/04/2017 20:32
 * Project: appPhenotypage
 */
@Component("ABA")
public class ParserABAFiche implements ParserFiche {

    @Autowired
    private OperateurService operateurService;

    @Autowired
    private ProgrammeService programmeService;

    @Autowired
    private AbattoirService abattoirService;

    @Autowired
    private MilieuMaturationService milieuMaturationService;

    @Autowired
    private FIVService fivService;

    @Autowired
    private TypeCultureService typeCultureService;

    @Autowired
    private CultureService cultureService;

    @Autowired
    private Informations_PIVService informations_pivService;

    @Autowired
    private FicheAbaService ficheAbaService;

    @Autowired
    private CryoconservationService cryoconservationService;

    @Autowired
    private FecondationService fecondationService;

    @Autowired
    private VacheService vacheService;

    @Override
    public List<Fiche> parse(File file) {
        FileInputStream excelFile = null;
        List<Fiche> fiches = new ArrayList<>();
        try {
            excelFile = new FileInputStream(file);
            Workbook workbook = new XSSFWorkbook(excelFile);
            Sheet sheet;
            while (workbook.sheetIterator().hasNext()) {
                sheet = workbook.sheetIterator().next();
                //Handle nom
                String nomFiche = sheet.getSheetName();

                //Handle programme
                String nomProgramme = PoiHelper.readCell(sheet, 3, 1);
                Programme programme = programmeService.findByNom(nomProgramme);
                if (programme == null) {
                    programme = programmeService.createProgramme(nomProgramme);
                }

                //Handle abattoir
                String nomAbattoir = PoiHelper.readCell(sheet, 4, 1);
                Abattoir abattoir = abattoirService.findByNom(nomAbattoir);
                if (abattoir == null) {
                    //TODO: abattoir needs a date from the file
                    abattoir = abattoirService.createAbattoir(nomAbattoir);
                }

                //Handle opérateur
                int opRow = 4, opCol = 3;
                String nomOperateur = PoiHelper.readCell(sheet, opRow, opCol);
                Operateur operateur = operateurService.findOperateurByNom(nomOperateur);
                if (operateur == null) {
                    throw new ParserException("L'opérateur dans la feuille " + sheet.getSheetName() + ", " +
                            "la ligne: " + opRow + " et la colonne: " + opCol +
                            " n'est pas disponible dans la base de données, " +
                            "il doit être enregistré avant d'importer le fichier");
                }

                String numeroAgrement = PoiHelper.readCell(sheet, 3, 4);
                if (numeroAgrement == null || numeroAgrement.isEmpty()) {
                    //TODO: exception
                }

                String temp = PoiHelper.readCell(sheet, 4, 6);
                float temperatureArrivee = Float.parseFloat(temp != null ? temp : "-1");

                String date = PoiHelper.readCell(sheet, 3, 7);
                Date dateFiche = DateFormat.getDateInstance().parse(date);

                fiches.add(ficheAbaService.createFicheAba(nomFiche, dateFiche, programme, numeroAgrement, abattoir, operateur,
                        temperatureArrivee, extractPIV(sheet), extractCollecte(sheet), extractFecondation(sheet),
                        extractCulture(sheet), extractCryoconservation(sheet), extractTableauDetails(sheet)));
            }
        } catch (IOException | ParseException e) {
            throw new ParserException("N'a pas pu parser ce fichier.", e);
        }

        return fiches;
    }

    private Informations_PIV extractPIV(Sheet sheet) {
        //Handle operateur
        int opRow = 7, opCol = 1;
        String nomOperateur = PoiHelper.readCell(sheet, opRow, opCol);
        Operateur operateur = operateurService.findOperateurByNom(nomOperateur);
        if (operateur == null) {
            throw new ParserException("L'opérateur dans la feuille " + sheet.getSheetName() + ", " +
                    "la ligne: " + opRow + " et la colonne: " + opCol +
                    " n'est pas disponible dans la base de données, " +
                    "il doit être enregistré avant d'importer le fichier");
        }

        //Handle maturation
        String nomMilieuMaturation = PoiHelper.readCell(sheet, 9, 1);
        String lotMilieuMaturation = PoiHelper.readCell(sheet, 9, 2);
        MilieuMaturation maturation = milieuMaturationService.finByNom(nomMilieuMaturation);
        if (maturation == null) {
            maturation = milieuMaturationService.createMilieuMaturation(nomMilieuMaturation, lotMilieuMaturation);
        }

        //Handle FIV
        String nomFIV = PoiHelper.readCell(sheet, 10, 1);
        String lotFIV = PoiHelper.readCell(sheet, 10, 2);
        FIV fiv = fivService.findByNom(nomFIV);
        if (fiv == null) {
            fiv = fivService.createFIV(nomFIV, lotFIV);
        }

        //Handle Culture
        String nomTypeCulture = PoiHelper.readCell(sheet, 11, 1);
        String lotCulture = PoiHelper.readCell(sheet, 11, 2);
        TypeCulture typeCulture = typeCultureService.findByNom(nomTypeCulture);
        if (typeCulture == null) {
            typeCulture = typeCultureService.createTypeCulture(nomTypeCulture, lotCulture);
        }

        return informations_pivService.createInformation_PIV(operateur, maturation, fiv, typeCulture);
    }

    private Collecte extractCollecte(Sheet sheet) {
        //Handle date and heure
        String date = PoiHelper.readCell(sheet, 15, 1);
        String time = PoiHelper.readCell(sheet, 15, 3);
        Date collecteDate;
        Time collecteTime;
        try {
            collecteDate = DateFormat.getDateInstance().parse(date);
            collecteTime = new Time(DateFormat.getTimeInstance().parse(time).getTime());
        } catch (ParseException e) {
            e.printStackTrace();
            collecteDate = new Date();
            collecteTime = new Time(collecteDate.getTime());
        }

        //Handle collecte table
        List<Tableau_Collecte> tableauCollectes = new ArrayList<>();
        int collecteRow = 18;
        while (true) {
            //race ovaires
            String race_Ovaires = PoiHelper.readCell(sheet, collecteRow, 0);

            //femelle
            String femelle = PoiHelper.readCell(sheet, collecteRow, 1);
            if (femelle == null || femelle.isEmpty()) {
                break;
            }
            Vache vache = null;
            if (!femelle.equals("pool")) {
                vache = vacheService.findByNum_identification(femelle);
            }

            //Nb ovaires
            String nbOva = PoiHelper.readCell(sheet, collecteRow, 2);
            int nombre_Ovaires = Integer.parseInt(nbOva != null ? nbOva : "-1");

            //Nb ovocytes
            String nbOvo = PoiHelper.readCell(sheet, collecteRow, 3);
            int nombre_Ovocytes = Integer.parseInt(nbOvo != null ? nbOvo : "-1");

            //Taux collecte
            String taux = PoiHelper.readCell(sheet, collecteRow, 4);
            float taux_Collecte = Float.parseFloat(taux != null ? taux : "-1");

            //Heure début maturation
            String heure = PoiHelper.readCell(sheet, collecteRow, 5);
            Time heureDebutMaturation;
            try {
                heureDebutMaturation = new Time(DateFormat.getTimeInstance().parse(heure).getTime());
            } catch (ParseException e) {
                e.printStackTrace();
                heureDebutMaturation = new Time(0);
            }

            //Heure FIV
            String heureF = PoiHelper.readCell(sheet, collecteRow, 6);
            Time heureFiv;
            try {
                heureFiv = new Time(DateFormat.getTimeInstance().parse(heureF).getTime());
            } catch (ParseException e) {
                e.printStackTrace();
                heureFiv = new Time(0);
            }
            //TODO: save tableau collecte and then add it to the list - good night
            //tableauCollectes.add();
            //Next row
            collecteRow++;
        }
        return null;
    }

    private Fecondation extractFecondation(Sheet sheet) {
        return null;
    }

    private Culture extractCulture(Sheet sheet) {
        return null;
    }

    private Cryoconservation extractCryoconservation(Sheet sheet) {
        return null;
    }

    private List<TableauDetail> extractTableauDetails(Sheet sheet) {
        return null;
    }

}
