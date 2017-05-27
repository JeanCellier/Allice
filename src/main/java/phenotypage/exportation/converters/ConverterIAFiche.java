package phenotypage.exportation.converters;

import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import phenotypage.model.fiche.ficheIa.FicheIa;
import phenotypage.model.fiche.ficheIa.FicheIaService;
import phenotypage.model.gestation.tableau_gestation.Tableau_Gestation;
import phenotypage.model.traitementDonneuse.tableau_donneuse.Tableau_Donneuse;
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
        if (fiche.getDateHeureMinute() != null) {
            PoiHelper.writeCell(sheet, rowNumber, 1, fiche.getDateHeureMinute().toString());
        }
        PoiHelper.writeCell(sheet, rowNumber, 6, "Lieu:");
        PoiHelper.writeCell(sheet, rowNumber, 7, fiche.getLieu());
        rowNumber++;

        /* Second row */
        PoiHelper.writeCell(sheet, rowNumber, 0, "Programme:");
        if (fiche.getProgramme() != null) {
            PoiHelper.writeCell(sheet, rowNumber, 1, fiche.getProgramme().getNom());
        }
        PoiHelper.writeCell(sheet, rowNumber, 3, "N° IPE:");
        PoiHelper.writeCell(sheet, rowNumber, 4, fiche.getNumIpe());
        PoiHelper.writeCell(sheet, rowNumber, 5, "N° dépôt semence:");
        PoiHelper.writeCell(sheet, rowNumber, 7, fiche.getNumDepotSemence());
        rowNumber += 2;

        //IDENTIFICATION FEMELLE
        PoiHelper.writeCell(sheet, rowNumber, 0, "IDENTIFICATION FEMELLE").setCellStyle(titleStyle);
        rowNumber++;
        PoiHelper.writeCell(sheet, rowNumber, 0, "Propriétaire:");
        if (fiche.getVache() != null) {
            PoiHelper.writeCell(sheet, rowNumber, 1, fiche.getVache().getProprietaire());
        }
        rowNumber++;
        PoiHelper.writeCell(sheet, rowNumber, 0, "N° d'élevage:");
        if (fiche.getVache() != null) {
            PoiHelper.writeCell(sheet, rowNumber, 1, fiche.getVache().getNum_elevage());
        }
        rowNumber++;
        PoiHelper.writeCell(sheet, rowNumber, 0, "N° d'identification:");
        if (fiche.getVache() != null) {
            PoiHelper.writeCell(sheet, rowNumber, 2, fiche.getVache().getNum_identification());
        }
        PoiHelper.writeCell(sheet, rowNumber, 3, "N° de travail:");
        if (fiche.getVache() != null) {
            PoiHelper.writeCell(sheet, rowNumber, 2, fiche.getVache().getNum_travail());
        }
        PoiHelper.writeCell(sheet, rowNumber, 5, "Race:");
        if (fiche.getVache() != null) {
            PoiHelper.writeCell(sheet, rowNumber, 6, fiche.getVache().getRace() + "");
        }
        rowNumber++;
        PoiHelper.writeCell(sheet, rowNumber, 0, "Parité:");
        if (fiche.getVache() != null) {
            PoiHelper.writeCell(sheet, rowNumber, 1, fiche.getVache().getParite());
        }
        rowNumber += 2;

        //INSEMINATION
        PoiHelper.writeCell(sheet, rowNumber, 0, "INSEMINATION").setCellStyle(titleStyle);
        rowNumber++;
        PoiHelper.writeCell(sheet, rowNumber, 0, "Opérateur IA:");
        if (fiche.getInsemination() != null && fiche.getInsemination().getOperateur() != null) {
            PoiHelper.writeCell(sheet, rowNumber, 1, fiche.getInsemination().getOperateur().getNom() + " " + fiche.getInsemination().getOperateur().getPrenom());
        }
        PoiHelper.writeCell(sheet, rowNumber, 3, "Semence sexée:");
        if (fiche.getInsemination() != null) {
            PoiHelper.writeCell(sheet, rowNumber, 5, fiche.getInsemination().isSemenceSexee() ? "Oui" : "Non");
        }

        rowNumber++;
        PoiHelper.writeCell(sheet, rowNumber, 0, "Nom taureau:");
        PoiHelper.writeCell(sheet, rowNumber, 3, "Race taureau:");
        PoiHelper.writeCell(sheet, rowNumber, 5, "N° taureau:");
        if (fiche.getInsemination() != null && fiche.getInsemination().getTaureau() != null) {
            PoiHelper.writeCell(sheet, rowNumber, 1, fiche.getInsemination().getTaureau().getNomTaureau());
            PoiHelper.writeCell(sheet, rowNumber, 4, fiche.getInsemination().getTaureau().getRaceTaureau());
            PoiHelper.writeCell(sheet, rowNumber, 6, fiche.getInsemination().getTaureau().getNumTaureau());
        }
        rowNumber += 2;

        PoiHelper.writeCell(sheet, rowNumber, 0, "IA réalisée dans le cadre d'une collecte:");
        if (fiche.getInsemination() != null) {
            PoiHelper.writeCell(sheet, rowNumber, 3, fiche.getInsemination().getCollecte());
        }
        rowNumber += 2;

        PoiHelper.writeCell(sheet, rowNumber, 0, "Lieu de dépôt de la semence:");
        if (fiche.getInsemination() != null) {
            PoiHelper.writeCell(sheet, rowNumber, 3, fiche.getInsemination().getLieuDepot());
        }
        rowNumber++;
        PoiHelper.writeCell(sheet, rowNumber, 0, "Facilité de progression:");
        if (fiche.getInsemination() != null) {
            PoiHelper.writeCell(sheet, rowNumber, 3, fiche.getInsemination().getProgression());
        }
        rowNumber += 2;

        //TRAITEMENT FEMELLE
        PoiHelper.writeCell(sheet, rowNumber, 0, "TRAITEMENT FEMELLE (si IA réalisée hors collecte d'embryons)").setCellStyle(titleStyle);
        rowNumber++;

        PoiHelper.writeCell(sheet, rowNumber, 0, "Type chaleur :");
        if (fiche.getTraitement_donneuse() != null) {
            PoiHelper.writeCell(sheet, rowNumber, 3, fiche.getTraitement_donneuse().getTypeChaleur());
        }
        rowNumber++;

        PoiHelper.writeCell(sheet, rowNumber, 0, "Date").setCellStyle(headerStyle);
        PoiHelper.writeCell(sheet, rowNumber, 1, "Produit").setCellStyle(headerStyle);
        PoiHelper.writeCell(sheet, rowNumber, 2, "Quantité").setCellStyle(headerStyle);
        PoiHelper.writeCell(sheet, rowNumber, 3, "Mode").setCellStyle(headerStyle);
        rowNumber++;
        if (fiche.getTraitement_donneuse() != null) {
            for (Tableau_Donneuse donneuse : fiche.getTraitement_donneuse().getTableauDonneuse()) {
                PoiHelper.writeCell(sheet, rowNumber, 0, donneuse.getDate().toString()).setCellStyle(bodyStyle);
                PoiHelper.writeCell(sheet, rowNumber, 1, donneuse.getProduit().getNom()).setCellStyle(bodyStyle);
                PoiHelper.writeCell(sheet, rowNumber, 2, donneuse.getQuantite() + "").setCellStyle(bodyStyle);
                PoiHelper.writeCell(sheet, rowNumber, 3, donneuse.getMode_traitement()).setCellStyle(bodyStyle);
                rowNumber++;
            }
        }
        rowNumber++;

        //SUIVI DE GESTATION
        PoiHelper.writeCell(sheet, rowNumber, 0, "SUIVI DE GESTATION(si IA réalisée hors collecte d 'embryons)").setCellStyle(titleStyle);
        rowNumber += 2;

        PoiHelper.writeCell(sheet, rowNumber, 0, "Date").setCellStyle(headerStyle);
        PoiHelper.writeCell(sheet, rowNumber, 1, "Méthode (palpation, écho, PSPB…)").setCellStyle(headerStyle);
        PoiHelper.writeCell(sheet, rowNumber, 2, "Résultat").setCellStyle(headerStyle);
        rowNumber++;
        if (fiche.getGestation() != null) {
            for (Tableau_Gestation gestation : fiche.getGestation().getTableauGestationList()) {
                if (gestation.getDate() != null) {
                    PoiHelper.writeCell(sheet, rowNumber, 0, gestation.getDate().toString()).setCellStyle(bodyStyle);
                }
                PoiHelper.writeCell(sheet, rowNumber, 1, gestation.getMethode()).setCellStyle(bodyStyle);
                PoiHelper.writeCell(sheet, rowNumber, 2, gestation.getResultat()).setCellStyle(bodyStyle);
                rowNumber++;
            }
        }
        rowNumber++;

        PoiHelper.writeCell(sheet, rowNumber, 0, "Remarques:");
        if (fiche.getGestation() != null) {
            PoiHelper.writeCell(sheet, rowNumber, 1, fiche.getGestation().getRemarques());
        }
        PoiHelper.mergeRowAndColumn(sheet, rowNumber, rowNumber + 3, 1, 7);
    }

}
