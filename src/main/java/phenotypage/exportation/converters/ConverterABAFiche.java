package phenotypage.exportation.converters;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import phenotypage.model.fiche.ficheAba.FicheAba;
import phenotypage.model.fiche.ficheAba.FicheAbaService;
import phenotypage.model.invitro.collecte.Tableau_Collecte;
import phenotypage.model.invitro.collecte.Tableau_Maturation;
import phenotypage.utils.PoiHelper;

/**
 * Created with magic
 * User: simoe
 * Date: 03/05/2017 22:46
 * Project: appPhenotypage
 */
@Component("Aba")
public class ConverterABAFiche implements ConverterFiche {

    private final FicheAbaService ficheAbaService;

    @Autowired
    public ConverterABAFiche(FicheAbaService ficheAbaService) {
        this.ficheAbaService = ficheAbaService;
    }

    @Override
    public XSSFWorkbook toWorkbook(String ficheNom) {
        FicheAba ficheAba = ficheAbaService.findByNom(ficheNom);
        XSSFWorkbook workBook = new XSSFWorkbook();
        XSSFSheet sheet = workBook.createSheet(ficheAba != null ? ficheAba.getNom() : "Fiche");
        if (ficheAba != null) {
            insertPIV(sheet, ficheAba);
        }
        return workBook;
    }

    private void insertPIV(XSSFSheet sheet, FicheAba ficheAba) {
        int rowNumber = 1;
        if (ficheAba == null)
            return;

        /* First row */
        //Programme label
        PoiHelper.writeCell(sheet, rowNumber, 0, "Programme:");
        PoiHelper.writeCell(sheet, rowNumber, 1, ficheAba.getProgramme().getNom());
        //N° agrément:
        PoiHelper.writeCell(sheet, rowNumber, 3, "N° agrément:");
        PoiHelper.writeCell(sheet, rowNumber, 4, ficheAba.getNumeroAgrement());
        //Date abattoir:
        PoiHelper.writeCell(sheet, rowNumber, 6, "Date abattoir:");
        PoiHelper.writeCell(sheet, rowNumber, 7, ficheAba.getDateHeureMinute().toString());
        rowNumber++;

        //Abbatoir:
        PoiHelper.writeCell(sheet, rowNumber, 0, "Abbatoir:");
        PoiHelper.writeCell(sheet, rowNumber, 1, ficheAba.getAbattoir().getNom());
        //Operateur
        PoiHelper.writeCell(sheet, rowNumber, 2, "Opérateur:");
        if (ficheAba.getOperateur() != null) {
            PoiHelper.writeCell(sheet, rowNumber, 3, ficheAba.getOperateur().getNom() + " " + ficheAba.getOperateur().getPrenom());
        }
        //T° arrivée:
        PoiHelper.writeCell(sheet, rowNumber, 5, "T° arrivée:");
        PoiHelper.writeCell(sheet, rowNumber, 6, ficheAba.getTemperatureArrivee() + "");
        rowNumber += 2;

        //INFORMATIONS GENERALES PIV
        PoiHelper.writeCell(sheet, rowNumber, 0, "INFORMATIONS GENERALES PIV");
        rowNumber++;

        //Operateur PIV
        PoiHelper.writeCell(sheet, rowNumber, 0, "Opérateur:");
        if (ficheAba.getInformations_piv() != null && ficheAba.getInformations_piv().getOperateur() != null) {
            PoiHelper.writeCell(sheet, rowNumber, 1, ficheAba.getInformations_piv().getOperateur().getNom() + " " + ficheAba.getInformations_piv().getOperateur().getPrenom());
        }
        rowNumber += 2;

        //Maturation
        PoiHelper.writeCell(sheet, rowNumber, 0, "Maturation");
        if (ficheAba.getInformations_piv() != null && ficheAba.getInformations_piv().getMilieuMaturation() != null) {
            PoiHelper.writeCell(sheet, rowNumber, 1, ficheAba.getInformations_piv().getMilieuMaturation().getNom());
            PoiHelper.writeCell(sheet, rowNumber, 4, ficheAba.getInformations_piv().getMilieuMaturation().getNumeroLot());
        }
        rowNumber++;

        //FIV
        PoiHelper.writeCell(sheet, rowNumber, 0, "FIV");
        if (ficheAba.getInformations_piv() != null && ficheAba.getInformations_piv().getFiv() != null) {
            PoiHelper.writeCell(sheet, rowNumber, 1, ficheAba.getInformations_piv().getFiv().getNom());
            PoiHelper.writeCell(sheet, rowNumber, 4, ficheAba.getInformations_piv().getFiv().getNumeroLot());
        }
        rowNumber++;

        //Culture
        PoiHelper.writeCell(sheet, rowNumber, 0, "Culture");
        if (ficheAba.getInformations_piv() != null && ficheAba.getInformations_piv().getTypeCulture() != null) {
            PoiHelper.writeCell(sheet, rowNumber, 1, ficheAba.getInformations_piv().getTypeCulture().getNom());
            PoiHelper.writeCell(sheet, rowNumber, 4, ficheAba.getInformations_piv().getTypeCulture().getNumeroLot());
        }
        rowNumber += 3;

        //COLLECTE & MATURATION IN VITRO
        PoiHelper.writeCell(sheet, rowNumber, 0, "COLLECTE & MATURATION IN VITRO");
        rowNumber++;

        //Date & Heure
        PoiHelper.writeCell(sheet, rowNumber, 0, "Date:");
        PoiHelper.writeCell(sheet, rowNumber, 2, "Heure:");
        if (ficheAba.getCollecte() != null) {
            PoiHelper.writeCell(sheet, rowNumber, 1, ficheAba.getCollecte().getDate().toString());
            PoiHelper.writeCell(sheet, rowNumber, 3, ficheAba.getCollecte().getHeureCollecte().toString());
        }
        rowNumber += 2;

        //Tableau header
        PoiHelper.writeCell(sheet, rowNumber, 0, "Race ovaires");
        PoiHelper.writeCell(sheet, rowNumber, 1, "N° femelle ou pool");
        PoiHelper.writeCell(sheet, rowNumber, 2, "Nb ovaires");
        PoiHelper.writeCell(sheet, rowNumber, 3, "Nb ovocytes");
        PoiHelper.writeCell(sheet, rowNumber, 4, "Taux collecte");
        PoiHelper.writeCell(sheet, rowNumber, 5, "Heure début maturation");
        PoiHelper.writeCell(sheet, rowNumber, 6, "Heure FIV");
        rowNumber++;

        //Tableau body
        if (ficheAba.getCollecte() != null) {
            for (Tableau_Collecte collecte : ficheAba.getCollecte().getTableauCollecteList()) {
                PoiHelper.writeCell(sheet, rowNumber, 0, collecte.getRace_Ovaires());
                if (collecte.isPool()) {
                    PoiHelper.writeCell(sheet, rowNumber, 1, "pool");
                } else if (collecte.getVache() != null) {
                    PoiHelper.writeCell(sheet, rowNumber, 1, collecte.getVache().getNum_identification());
                }
                PoiHelper.writeCell(sheet, rowNumber, 2, collecte.getNombre_Ovaires() + "");
                PoiHelper.writeCell(sheet, rowNumber, 3, collecte.getNombre_Ovocytes() + "");
                PoiHelper.writeCell(sheet, rowNumber, 4, collecte.getTaux_Collecte() + "");
                PoiHelper.writeCell(sheet, rowNumber, 5, collecte.getHeureDebutMaturation().toString());
                PoiHelper.writeCell(sheet, rowNumber, 6, collecte.getHeureFiv().toString());
                rowNumber++;
            }
        }

        //MIV Tableau header
        PoiHelper.writeCell(sheet, rowNumber, 0, "Groupes expérimentaux MIV");
        PoiHelper.writeCell(sheet, rowNumber, 1, "Nb d'ovocytes");
        rowNumber++;

        //MIV Tableau body
        if (ficheAba.getCollecte() != null) {
            for (Tableau_Maturation maturation : ficheAba.getCollecte().getTableauMaturationList()) {
                PoiHelper.writeCell(sheet, rowNumber, 0, maturation.getGroupeExperimentauxMIV());
                PoiHelper.writeCell(sheet, rowNumber, 1, maturation.getNbOvocyte() + "");
                rowNumber++;
            }
        }
    }
}