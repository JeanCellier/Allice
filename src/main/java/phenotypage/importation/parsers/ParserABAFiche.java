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
import phenotypage.model.invitro.collecte.*;
import phenotypage.model.invitro.culture.Culture;
import phenotypage.model.invitro.culture.CultureService;
import phenotypage.model.invitro.culture.TableauCulture;
import phenotypage.model.invitro.culture.TableauCultureService;
import phenotypage.model.invitro.fecondation.Fecondation;
import phenotypage.model.invitro.fecondation.FecondationService;
import phenotypage.model.invitro.fecondation.TableauSemence;
import phenotypage.model.invitro.fecondation.TableauSemenceService;
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
import java.util.Iterator;
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

    @Autowired
    private Tableau_MaturationService tableauMaturationService;

    @Autowired
    private Tableau_CollecteService tableauCollecteService;

    @Autowired
    private TableauSemenceService tableauSemenceService;

    @Autowired
    private CollecteService collecteService;

    @Autowired
    private TableauCultureService tableauCultureService;

    @Override
    public List<Fiche> parse(File file) {
        FileInputStream excelFile = null;
        List<Fiche> fiches = new ArrayList<>();
        try {
            excelFile = new FileInputStream(file);
            Workbook workbook = new XSSFWorkbook(excelFile);
            Sheet sheet;
            Iterator<Sheet> sheetIterator = workbook.sheetIterator();
            while (sheetIterator.hasNext()) {
                sheet = sheetIterator.next();
                //Handle nom
                String nomFiche = sheet.getSheetName();
                System.out.println("Parsing : " + nomFiche);

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
//                    throw new ParserException("L'opérateur dans la feuille " + sheet.getSheetName() + ", " +
//                            "la ligne: " + opRow + " et la colonne: " + opCol +
//                            " n'est pas disponible dans la base de données, " +
//                            "il doit être enregistré avant d'importer le fichier");
                }

                String numeroAgrement = PoiHelper.readCell(sheet, 3, 4);
                if (numeroAgrement == null || numeroAgrement.isEmpty()) {
                    //TODO: exception
                }

                String temp = PoiHelper.readCell(sheet, 4, 6);
                float temperatureArrivee = Float.parseFloat((temp != null && !temp.isEmpty()) ? temp : "0");

                String date = PoiHelper.readCell(sheet, 3, 7);
                Date dateFiche;
                try {
                    dateFiche = DateFormat.getDateInstance().parse(date);
                } catch (ParseException e) {
                    e.printStackTrace();
                    dateFiche = new Date();
                }

                fiches.add(ficheAbaService.createFicheAba(nomFiche, dateFiche, programme, numeroAgrement, abattoir, operateur,
                        temperatureArrivee, extractPIV(sheet), extractCollecte(sheet), extractFecondation(sheet),
                        extractCulture(sheet), extractCryoconservation(sheet), extractTableauDetails(sheet)));
            }
        } catch (IOException e) {
            e.printStackTrace();
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
//            throw new ParserException("L'opérateur dans la feuille " + sheet.getSheetName() + ", " +
//                    "la ligne: " + opRow + " et la colonne: " + opCol +
//                    " n'est pas disponible dans la base de données, " +
//                    "il doit être enregistré avant d'importer le fichier");
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
            int nombre_Ovaires = Integer.parseInt((nbOva != null && !nbOva.isEmpty()) ? nbOva : "0");

            //Nb ovocytes
            String nbOvo = PoiHelper.readCell(sheet, collecteRow, 3);
            int nombre_Ovocytes = Integer.parseInt((nbOvo != null && !nbOvo.isEmpty()) ? nbOvo : "0");

            //Taux collecte
            String taux = PoiHelper.readCell(sheet, collecteRow, 4);
            float taux_Collecte = Float.parseFloat((taux != null && !taux.isEmpty()) ? taux : "0");

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

            tableauCollectes.add(tableauCollecteService.createTableau_Collecte(race_Ovaires, nombre_Ovaires, nombre_Ovocytes, taux_Collecte, vache, heureDebutMaturation, heureFiv));
            //Next row
            collecteRow++;
        }

        //Handle maturation table
        int maturationRow = 25;
        List<Tableau_Maturation> tableauMaturations = new ArrayList<>();
        while (true) {
            //Groupes expérimentaux MIV
            String groupeExperimentauxMIV = PoiHelper.readCell(sheet, maturationRow, 0);
            if (groupeExperimentauxMIV != null && groupeExperimentauxMIV.isEmpty()) {
                break;
            }

            //Nb d'ovocytes
            String nbO = PoiHelper.readCell(sheet, maturationRow, 1);
            int nbOvocyte = Integer.parseInt((nbO != null && !nbO.isEmpty()) ? nbO : "0");

            tableauMaturations.add(tableauMaturationService.createTableau_Mturation(groupeExperimentauxMIV, nbOvocyte));
            maturationRow++;
        }
        return collecteService.createCollecte(collecteTime, collecteDate, tableauCollectes, tableauMaturations);
    }

    private Fecondation extractFecondation(Sheet sheet) {
        String dateFec = PoiHelper.readCell(sheet, 32, 1);
        Date date;
        try {
            date = DateFormat.getDateInstance().parse(dateFec);
        } catch (ParseException e) {
            e.printStackTrace();
            date = new Date();
        }
        //TODO: read Sanitaires checkboxes
        List<TableauSemence> tableauSemenceList = new ArrayList<>();
        int semenceRow = 35;
        while (true) {
            String taureauId = PoiHelper.readCell(sheet, semenceRow, 1);
            if (taureauId != null && taureauId.isEmpty()) {
                break;
            }
            Vache taureau = vacheService.findByNum_identification(taureauId);

            //N ejaculation
            String numeroEjaculation = PoiHelper.readCell(sheet, semenceRow, 3);

            //etat frais
            String etatFr = PoiHelper.readCell(sheet, semenceRow, 4);
            int etatFrais = Integer.parseInt(etatFr != null ? etatFr.substring(0, 2) : "0");

            //volume
            String vol = PoiHelper.readCell(sheet, semenceRow, 5);
            float volume = Float.parseFloat(vol != null ? vol : "0");

            tableauSemenceList.add(tableauSemenceService.createTableauSemence(taureau, numeroEjaculation, volume, etatFrais));
            semenceRow++;
        }
        return fecondationService.createFecondation(date, null, null, tableauSemenceList);
    }

    private Culture extractCulture(Sheet sheet) {
        String dateCult = PoiHelper.readCell(sheet, 48, 1);
        Date date;
        try {
            date = DateFormat.getDateInstance().parse(dateCult);
        } catch (ParseException e) {
            date = new Date();
        }

        //TODO: read sanitaires checkboxes
        int cultureRow = 52;
        List<TableauCulture> tableauCultureList = new ArrayList<>();
        while (true) {
            //groupe
            String groupe = PoiHelper.readCell(sheet, cultureRow, 0);
            System.out.println(groupe);
            if (groupe == null || groupe.isEmpty()) {
                break;
            }
            //Nb d'ovo inséminés
            String nbInse = PoiHelper.readCell(sheet, cultureRow, 2);
            int nbInsemine = Integer.parseInt((nbInse != null && !nbInse.isEmpty()) ? nbInse : "0");
            //Heure de mise en culture
            String HMCulture = PoiHelper.readCell(sheet, cultureRow, 3);
            int heureCulture = 0;
            int minuteCulture = 0;
            if (HMCulture != null && !HMCulture.isEmpty()) {
                heureCulture = Integer.parseInt(HMCulture.substring(0, 2));
                //minuteCulture = Integer.parseInt(HMCulture.substring(3));
            }
            //Nb segmentés
            String nbSeg = PoiHelper.readCell(sheet, cultureRow, 4);
            int nbSegmente = Integer.parseInt((nbSeg != null && !nbSeg.isEmpty()) ? nbSeg : "0");
            //% seg
            String seg = PoiHelper.readCell(sheet, cultureRow, 5);
            float segment = Float.parseFloat((seg != null && !seg.isEmpty()) ? seg.substring(0, 4) : "0");
            //J5 - Morula
            String j5 = PoiHelper.readCell(sheet, cultureRow, 6);
            int j5JM = Integer.parseInt((j5 != null && !j5.isEmpty()) ? j5 : "0");
            //mo
            String moCol = PoiHelper.readCell(sheet, cultureRow + 9, 2);
            System.out.println("culture row : " + (cultureRow + 12) + " col : " + moCol);
            int mo = Integer.parseInt((moCol != null && !moCol.isEmpty()) ? moCol : "0");
            //BL
            String blCol = PoiHelper.readCell(sheet, cultureRow + 9, 3);
            int bl = Integer.parseInt((blCol != null && !blCol.isEmpty()) ? blCol : "0");
            //BE
            String beCol = PoiHelper.readCell(sheet, cultureRow + 9, 4);
            int be = Integer.parseInt((beCol != null && !beCol.isEmpty()) ? beCol : "0");
            //Q1
            String q1Col = PoiHelper.readCell(sheet, cultureRow + 9, 5);
            int q1 = Integer.parseInt((q1Col != null && !q1Col.isEmpty()) ? q1Col : "0");
            //Nb Total
            String nbTotalCol = PoiHelper.readCell(sheet, cultureRow + 9, 6);
            int nbTotal = Integer.parseInt((nbTotalCol != null && !nbTotalCol.isEmpty()) ? nbTotalCol : "0");
            //%J7
            String pourJ7Col = PoiHelper.readCell(sheet, cultureRow + 18, 2);
            float pourJ7 = Float.parseFloat((pourJ7Col != null && !pourJ7Col.isEmpty()) ? pourJ7Col.substring(0, pourJ7Col.length() - 1) : "0");
            //%BEJ7
            String pourBEJ7Col = PoiHelper.readCell(sheet, cultureRow + 18, 3);
            float pourBEJ7 = Float.parseFloat((pourBEJ7Col != null && !pourBEJ7Col.isEmpty()) ? pourBEJ7Col.substring(0, pourBEJ7Col.length() - 1) : "0");
            //%Q1J7
            String pourQ1J7Col = PoiHelper.readCell(sheet, cultureRow + 18, 4);
            float pourQ1J7 = Float.parseFloat((pourQ1J7Col != null && !pourQ1J7Col.isEmpty()) ? pourQ1J7Col.substring(0, pourQ1J7Col.length() - 1) : "0");
            //J8 Nb
            String J8parNbCol = PoiHelper.readCell(sheet, cultureRow + 18, 5);
            int J8parNb = Integer.parseInt((J8parNbCol != null && !J8parNbCol.isEmpty()) ? J8parNbCol : "0");
            //%J8
            String pourJ8Col = PoiHelper.readCell(sheet, cultureRow + 18, 6);
            float pourJ8 = Float.parseFloat((pourJ8Col != null && !pourJ8Col.isEmpty()) ? pourJ8Col.substring(0, pourJ8Col.length() - 1) : "0");
            //Destination
            String destination = PoiHelper.readCell(sheet, cultureRow + 18, 7);

            tableauCultureList.add(tableauCultureService.createTableauCulture(groupe, nbInsemine,
                    heureCulture, minuteCulture, nbSegmente, segment, j5JM, mo, bl, be, q1, nbTotal,
                    pourJ7, pourBEJ7, pourQ1J7, J8parNb, pourJ8, destination));
            cultureRow++;
        }
        return cultureService.createCulture(date, null, null, tableauCultureList);
    }

    private Cryoconservation extractCryoconservation(Sheet sheet) {

        return null;
    }

    private List<TableauDetail> extractTableauDetails(Sheet sheet) {
        return null;
    }

}
