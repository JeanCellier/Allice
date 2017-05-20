package phenotypage.exportation.converters;

import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import phenotypage.model.fiche.ficheIa.FicheIa;
import phenotypage.model.fiche.ficheIa.FicheIaService;
import phenotypage.model.gestation.Tableau_Gestation;
import phenotypage.model.traitementDonneuse.Tableau_Donneuse;
import phenotypage.utils.PoiHelper;

/**
 * Created with magic
 * User: simoe
 * Date: 03/05/2017 23:56
 * Project: appPhenotypage
 */
@Component("Ia")
public class ConverterIAFiche implements ConverterFiche {

    private final FicheIaService ficheIaService;

    @Autowired
    public ConverterIAFiche(FicheIaService ficheIaService) {
        this.ficheIaService = ficheIaService;
    }

    @Override
    public XSSFWorkbook toWorkbook(String ficheNom) {
        FicheIa ficheIa = ficheIaService.findByNom(ficheNom);
        XSSFWorkbook workBook = new XSSFWorkbook();
        XSSFSheet sheet = workBook.createSheet(ficheIa != null ? ficheIa.getNom() : "Fiche");
        if (ficheIa != null) {
            writeWorkbook(workBook, sheet, ficheIa);
        }
        return workBook;
    }

    @SuppressWarnings("Duplicates")
    private void writeWorkbook(XSSFWorkbook workBook, XSSFSheet sheet, FicheIa fiche) {
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
        PoiHelper.writeCell(sheet, rowNumber, 0, "Date:");
        PoiHelper.writeCell(sheet, rowNumber, 1, fiche.getDateHeureMinute().toString());
        PoiHelper.writeCell(sheet, rowNumber, 6, "Lieu:");
        PoiHelper.writeCell(sheet, rowNumber, 7, fiche.getLieu());
        rowNumber++;

        /* Second row */
        PoiHelper.writeCell(sheet, rowNumber, 0, "Programme:");
        PoiHelper.writeCell(sheet, rowNumber, 1, fiche.getProgramme().getNom());
        PoiHelper.writeCell(sheet, rowNumber, 3, "N° IPE:");
        PoiHelper.writeCell(sheet, rowNumber, 4, fiche.getNumIpe());
        PoiHelper.writeCell(sheet, rowNumber, 5, "N° dépôt semence:");
        PoiHelper.writeCell(sheet, rowNumber, 7, fiche.getNumDepotSemence());
        rowNumber += 2;

        //IDENTIFICATION FEMELLE
        PoiHelper.writeCell(sheet, rowNumber, 0, "IDENTIFICATION FEMELLE").setCellStyle(titleStyle);
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


        //INSEMINATION
        PoiHelper.writeCell(sheet, rowNumber, 0, "INSEMINATION").setCellStyle(titleStyle);
        rowNumber++;
        PoiHelper.writeCell(sheet, rowNumber, 0, "Opérateur IA:");
        PoiHelper.writeCell(sheet, rowNumber, 1, fiche.getInsemination().getOperateur().getNom() + " " + fiche.getInsemination().getOperateur().getPrenom());
        PoiHelper.writeCell(sheet, rowNumber, 3, "Semence sexée:");
        PoiHelper.writeCell(sheet, rowNumber, 5, fiche.getInsemination().isSemenceSexee() ? "Oui" : "Non");

        rowNumber++;
        PoiHelper.writeCell(sheet, rowNumber, 0, "Nom taureau:");
        PoiHelper.writeCell(sheet, rowNumber, 1, fiche.getInsemination().getTaureau().getNom());
        PoiHelper.writeCell(sheet, rowNumber, 3, "Race taureau:");
        PoiHelper.writeCell(sheet, rowNumber, 4, fiche.getInsemination().getTaureau().getRace() + "");
        PoiHelper.writeCell(sheet, rowNumber, 5, "N° taureau:");
        PoiHelper.writeCell(sheet, rowNumber, 6, fiche.getInsemination().getTaureau().getNum_identification());
        rowNumber += 2;

        PoiHelper.writeCell(sheet, rowNumber, 0, "IA réalisée dans le cadre d'une collecte:");
        PoiHelper.writeCell(sheet, rowNumber, 3, fiche.getInsemination().isCollecte() ? "Oui" : "Non");
        rowNumber += 2;

        PoiHelper.writeCell(sheet, rowNumber, 0, "Lieu de dépôt de la semence:");
        PoiHelper.writeCell(sheet, rowNumber, 3, fiche.getInsemination().getLieuDepot());
        rowNumber++;
        PoiHelper.writeCell(sheet, rowNumber, 0, "Facilité de progression:");
        PoiHelper.writeCell(sheet, rowNumber, 3, fiche.getInsemination().getProgression());
        rowNumber += 2;

        //TRAITEMENT FEMELLE
        PoiHelper.writeCell(sheet, rowNumber, 0, "TRAITEMENT FEMELLE (si IA réalisée hors collecte d'embryons)").setCellStyle(titleStyle);
        rowNumber++;

        PoiHelper.writeCell(sheet, rowNumber, 0, "Type chaleur :");
        PoiHelper.writeCell(sheet, rowNumber, 3, fiche.getTraitement_donneuse().isNaturel() ? "naturelle" : "induite");
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

        //SUIVI DE GESTATION
        PoiHelper.writeCell(sheet, rowNumber, 0, "SUIVI DE GESTATION(si IA réalisée hors collecte d 'embryons)").setCellStyle(titleStyle);
        rowNumber += 2;

        PoiHelper.writeCell(sheet, rowNumber, 0, "Date").setCellStyle(headerStyle);
        PoiHelper.writeCell(sheet, rowNumber, 1, "Méthode (palpation, écho, PSPB…)").setCellStyle(headerStyle);
        PoiHelper.writeCell(sheet, rowNumber, 2, "Résultat").setCellStyle(headerStyle);
        rowNumber++;
        for (Tableau_Gestation gestation : fiche.getGestation().getTableauGestationList()) {
            PoiHelper.writeCell(sheet, rowNumber, 0, gestation.getDate().toString()).setCellStyle(bodyStyle);
            PoiHelper.writeCell(sheet, rowNumber, 1, gestation.getMethode().getNom()).setCellStyle(bodyStyle);
            PoiHelper.writeCell(sheet, rowNumber, 2, gestation.getResultat()).setCellStyle(bodyStyle);
            rowNumber++;
        }
        rowNumber++;

        PoiHelper.writeCell(sheet, rowNumber, 0, "Remarques:");
        PoiHelper.writeCell(sheet, rowNumber, 1, fiche.getGestation().getRemarques());
        PoiHelper.mergeRowAndColumn(sheet, rowNumber, rowNumber + 3, 1, 7);
    }

}
