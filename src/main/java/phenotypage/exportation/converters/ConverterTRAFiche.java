package phenotypage.exportation.converters;

import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import phenotypage.model.fiche.ficheTra.FicheTra;
import phenotypage.model.fiche.ficheTra.FicheTraService;
import phenotypage.model.gestation.tableau_gestation.Tableau_Gestation;
import phenotypage.model.traitementDonneuse.tableau_donneuse.Tableau_Donneuse;
import phenotypage.utils.PoiHelper;

/**
 * Created with magic
 * User: simoe
 * Date: 03/05/2017 23:56
 * Project: appPhenotypage
 */
@Component("Tra")
public class ConverterTRAFiche implements ConverterFiche {

    private final FicheTraService ficheTraService;

    @Autowired
    public ConverterTRAFiche(FicheTraService ficheTraService) {
        this.ficheTraService = ficheTraService;
    }

    @Override
    public XSSFWorkbook toWorkbook(String ficheNom) {

        FicheTra ficheTra = ficheTraService.findByNom(ficheNom);
        XSSFWorkbook workBook = new XSSFWorkbook();
        XSSFSheet sheet = workBook.createSheet(ficheTra != null ? ficheTra.getNom() : "Fiche");
        if (ficheTra != null) {
            writeWorkbook(workBook, sheet, ficheTra);
        }
        return workBook;
    }

    @SuppressWarnings("Duplicates")
    private void writeWorkbook(XSSFWorkbook workBook, XSSFSheet sheet, FicheTra fiche) {
        int rowNumber = 1;

        /* Column width adjustments */
        sheet.setColumnWidth(0, 12 * 256);
        sheet.setColumnWidth(1, 12 * 256);
        sheet.setColumnWidth(2, 12 * 256);
        sheet.setColumnWidth(3, 17 * 256);
        sheet.setColumnWidth(4, 12 * 256);
        sheet.setColumnWidth(5, 12 * 256);
        sheet.setColumnWidth(6, 13 * 256);
        sheet.setColumnWidth(7, 12 * 256);

        //Title style
        XSSFCellStyle titleStyle = PoiHelper.getTitleStyle(workBook);

        //Table header style
        XSSFCellStyle headerStyle = PoiHelper.getTableHeaderStyle(workBook);

        //Table body style
        XSSFCellStyle bodyStyle = PoiHelper.getTableBodyStyle(workBook);

        /* First row */
        PoiHelper.writeCell(sheet, rowNumber, 0, "Programme:");
        PoiHelper.writeCell(sheet, rowNumber, 1, fiche.getProgramme().getNom());
        PoiHelper.writeCell(sheet, rowNumber, 2, "N° agrément:");
        PoiHelper.writeCell(sheet, rowNumber, 3, fiche.getNumeroAgrement());
        PoiHelper.writeCell(sheet, rowNumber, 4, "Lieu:");
        PoiHelper.writeCell(sheet, rowNumber, 5, fiche.getLieu());
        rowNumber++;

        /* First row */
        //Programme label
        PoiHelper.writeCell(sheet, rowNumber, 0, "Programme:");
        PoiHelper.writeCell(sheet, rowNumber, 1, fiche.getProgramme().getNom());
        //N° agrément:
        PoiHelper.writeCell(sheet, rowNumber, 3, "N° agrément:");
        PoiHelper.writeCell(sheet, rowNumber, 4, fiche.getNumeroAgrement());
        //Date abattoir:
        PoiHelper.writeCell(sheet, rowNumber, 6, "Lieu:");
        PoiHelper.writeCell(sheet, rowNumber, 7, fiche.getLieu());
        rowNumber++;

        //Abbatoir:
        PoiHelper.writeCell(sheet, rowNumber, 0, "Date et heure:");
        PoiHelper.writeCell(sheet, rowNumber, 1, fiche.getDateHeureMinute().toString());
        //Operateur
        PoiHelper.writeCell(sheet, rowNumber, 4, "Opérateur:");
        if (fiche.getOperateur() != null) {
            PoiHelper.writeCell(sheet, rowNumber, 5, fiche.getOperateur().getNom() + " " + fiche.getOperateur().getPrenom());
        }
        rowNumber += 2;

        //IDENTIFICATION RECEVEUSE
        PoiHelper.writeCell(sheet, rowNumber, 0, "IDENTIFICATION RECEVEUSE").setCellStyle(titleStyle);
        rowNumber++;
        PoiHelper.writeCell(sheet, rowNumber, 0, "Propriétaire:");
        PoiHelper.writeCell(sheet, rowNumber, 1, fiche.getVache().getProprietaire());
        rowNumber++;
        PoiHelper.writeCell(sheet, rowNumber, 0, "N° d'élevage:");
        PoiHelper.writeCell(sheet, rowNumber, 1, fiche.getVache().getNum_elevage());
        rowNumber++;
        PoiHelper.writeCell(sheet, rowNumber, 0, "N° d'identification:");
        PoiHelper.writeCell(sheet, rowNumber, 2, fiche.getVache().getNum_identification());
        PoiHelper.writeCell(sheet, rowNumber, 3, "N° de travail:");
        PoiHelper.writeCell(sheet, rowNumber, 5, "Race:");
        PoiHelper.writeCell(sheet, rowNumber, 6, fiche.getVache().getRace() + "");
        rowNumber++;
        PoiHelper.writeCell(sheet, rowNumber, 0, "Parité:");
        PoiHelper.writeCell(sheet, rowNumber, 1, fiche.getVache().getParite());
        rowNumber += 2;

        //TRAITEMENT RECEVEUSE
        PoiHelper.writeCell(sheet, rowNumber, 0, "TRAITEMENT RECEVEUSE").setCellStyle(titleStyle);
        rowNumber++;

        PoiHelper.writeCell(sheet, rowNumber, 0, "Date chaleur de référence:");
        PoiHelper.writeCell(sheet, rowNumber, 2, fiche.getTraitement_donneuse().getDate_ref_chaleur().toString());
        PoiHelper.writeCell(sheet, rowNumber, 3, "Type chaleur de référence:");
        PoiHelper.writeCell(sheet, rowNumber, 5, fiche.getTraitement_donneuse().getTypeChaleur());
        rowNumber++;

        PoiHelper.writeCell(sheet, rowNumber, 0, "Date").setCellStyle(headerStyle);
        PoiHelper.writeCell(sheet, rowNumber, 1, "Produit").setCellStyle(headerStyle);
        PoiHelper.writeCell(sheet, rowNumber, 2, "Quantité").setCellStyle(headerStyle);
        PoiHelper.writeCell(sheet, rowNumber, 3, "Mode").setCellStyle(headerStyle);
        rowNumber++;

        for (Tableau_Donneuse donneuse : fiche.getTraitement_donneuse().getTableauDonneuse()) {
            PoiHelper.writeCell(sheet, rowNumber, 0, donneuse.getDate().toString()).setCellStyle(bodyStyle);
            PoiHelper.writeCell(sheet, rowNumber, 1, donneuse.getProduit().getNom()).setCellStyle(bodyStyle);
            PoiHelper.writeCell(sheet, rowNumber, 2, donneuse.getQuantite() + "").setCellStyle(bodyStyle);
            PoiHelper.writeCell(sheet, rowNumber, 3, donneuse.getMode_traitement()).setCellStyle(bodyStyle);
            rowNumber++;
        }

        //EVALUATION DU CORPS JAUNE
        PoiHelper.writeCell(sheet, rowNumber, 0, "EVALUATION DU CORPS JAUNE").setCellStyle(titleStyle);
        rowNumber++;

        PoiHelper.writeCell(sheet, rowNumber, 0, "Méthode d'évaluation:");
        PoiHelper.writeCell(sheet, rowNumber, 2, fiche.getCorpsJaune().getMode_evaluation());
        rowNumber++;

        PoiHelper.writeCell(sheet, rowNumber, 0, "Image(s) échographe:");
        PoiHelper.writeCell(sheet, rowNumber, 2, fiche.getCorpsJaune().isImageEcho() ? "Oui" : "Non");
        PoiHelper.writeCell(sheet, rowNumber, 3, "Côté du corps jaune:");
        PoiHelper.writeCell(sheet, rowNumber, 5, fiche.getCorpsJaune().getCoteCorpsJaune() == 'G' ? "Gauche" : "Droite");
        rowNumber++;

        PoiHelper.writeCell(sheet, rowNumber, 0, "Qualité selon jugement opérateur:");
        PoiHelper.writeCell(sheet, rowNumber, 2, fiche.getCorpsJaune().getQualite() + "");
        rowNumber++;

        //EMBRYON(S) TRANSFERE(S)
        PoiHelper.writeCell(sheet, rowNumber, 0, "EMBRYON(S) TRANSFERE(S)").setCellStyle(titleStyle);
        rowNumber++;

        PoiHelper.writeCell(sheet, rowNumber, 0, "Référence expérience production d'embryon(s):");
        rowNumber++;

        PoiHelper.writeCell(sheet, rowNumber, 0, "N° embryon:");
        PoiHelper.writeCell(sheet, rowNumber, 1, fiche.getEmbryonsTransferes().getRefEmbryons());
        rowNumber++;

        PoiHelper.writeCell(sheet, rowNumber, 0, "Côté transfert:");
        PoiHelper.writeCell(sheet, rowNumber, 1, fiche.getEmbryonsTransferes().getCote() == 'G' ? "Gauche" : "Droite");
        rowNumber++;

        PoiHelper.writeCell(sheet, rowNumber, 0, "Emplacement dans la corne utérine:");
        PoiHelper.writeCell(sheet, rowNumber, 3, fiche.getEmbryonsTransferes().getEmplacementColUterine());
        rowNumber++;

        PoiHelper.writeCell(sheet, rowNumber, 0, "Facilité de progression:");
        PoiHelper.writeCell(sheet, rowNumber, 2, fiche.getEmbryonsTransferes().getFaciliteprogression() + "");
        rowNumber++;

        //SUIVI DE GESTATION
        PoiHelper.writeCell(sheet, rowNumber, 0, "SUIVI DE GESTATION").setCellStyle(titleStyle);
        rowNumber++;

        PoiHelper.writeCell(sheet, rowNumber, 0, "Date").setCellStyle(headerStyle);
        PoiHelper.writeCell(sheet, rowNumber, 1, "Méthode (palpation, écho, PSPB…)").setCellStyle(headerStyle);
        PoiHelper.writeCell(sheet, rowNumber, 2, "Résultat").setCellStyle(headerStyle);
        rowNumber++;

        for (Tableau_Gestation gestation : fiche.getGestation().getTableauGestationList()) {
            PoiHelper.writeCell(sheet, rowNumber, 0, gestation.getDate().toString()).setCellStyle(bodyStyle);
            PoiHelper.writeCell(sheet, rowNumber, 1, gestation.getMethode()).setCellStyle(bodyStyle);
            PoiHelper.writeCell(sheet, rowNumber, 2, gestation.getResultat()).setCellStyle(bodyStyle);
            rowNumber++;
        }
        rowNumber++;

        PoiHelper.writeCell(sheet, rowNumber, 0, "Remarques:");
        PoiHelper.writeCell(sheet, rowNumber, 1, fiche.getGestation().getRemarques());
        PoiHelper.mergeRowAndColumn(sheet, rowNumber, rowNumber + 3, 1, 7);
    }
}
