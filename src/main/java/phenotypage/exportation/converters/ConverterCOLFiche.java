package phenotypage.exportation.converters;

import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import phenotypage.model.cryoconservation.embryon.Embryon;
import phenotypage.model.fiche.ficheCol.FicheCol;
import phenotypage.model.fiche.ficheCol.FicheColService;
import phenotypage.model.tableauTraitement.TableauTraitement;
import phenotypage.model.traitementDonneuse.tableau_donneuse.Tableau_Donneuse;
import phenotypage.utils.PoiHelper;

/**
 * Created with magic
 * User: simoe
 * Date: 03/05/2017 23:55
 * Project: appPhenotypage
 */
@Component
public class ConverterCOLFiche implements ConverterFiche {
    @Autowired
    private FicheColService ficheColService;

    @Override
    public XSSFWorkbook toWorkbook(String ficheNom) {
        FicheCol ficheCol = ficheColService.findByNom(ficheNom);
        XSSFWorkbook workBook = new XSSFWorkbook();
        XSSFSheet sheet = workBook.createSheet(ficheCol != null ? ficheCol.getNom() : "Fiche");
        if (ficheCol != null) {
            writeWorkbook(workBook, sheet, ficheCol);
        }
        return workBook;
    }

    @SuppressWarnings("Duplicates")
    private void writeWorkbook(XSSFWorkbook workBook, XSSFSheet sheet, FicheCol fiche) {
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

        //IDENTIFICATION DONNEUSE
        PoiHelper.writeCell(sheet, rowNumber, 0, "IDENTIFICATION DONNEUSE").setCellStyle(titleStyle);
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

        //TRAITEMENT DONNEUSE
        PoiHelper.writeCell(sheet, rowNumber, 0, "TRAITEMENT DONNEUSE").setCellStyle(titleStyle);
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

        PoiHelper.writeCell(sheet, rowNumber, 0, "Ponction du ou des follicules dominants (> 8 mm):");
        //PoiHelper.writeCell(sheet, rowNumber, 4, fiche.getInfoTraitementDonneuse().isPonctionFollicule() ? "oui" : "non");
        rowNumber++;

        PoiHelper.writeCell(sheet, rowNumber, 0, "Nb de follicules aspirés:");
        PoiHelper.writeCell(sheet, rowNumber, 2, fiche.getInfoTraitementDonneuse().getNb_follicules() + "");
        PoiHelper.writeCell(sheet, rowNumber, 3, "Droite:");
        PoiHelper.writeCell(sheet, rowNumber, 4, fiche.getInfoTraitementDonneuse().getNb_droite() + "");
        PoiHelper.writeCell(sheet, rowNumber, 5, "Gauche:");
        PoiHelper.writeCell(sheet, rowNumber, 6, fiche.getInfoTraitementDonneuse().getNb_gauche() + "");
        rowNumber++;

        PoiHelper.writeCell(sheet, rowNumber, 0, "Image(s) échographe:");
        PoiHelper.writeCell(sheet, rowNumber, 2, fiche.getInfoTraitementDonneuse().isImage_echo() ? "oui" : "non");
        rowNumber++;

        PoiHelper.writeCell(sheet, rowNumber, 0, "Traitement superovulation:");
        //PoiHelper.writeCell(sheet, rowNumber, 2, fiche.getInfoTraitementDonneuse().isSuperovulation() ? "oui" : "non");
        rowNumber++;

        PoiHelper.writeCell(sheet, rowNumber, 0, "Type FSH:");
        //PoiHelper.writeCell(sheet, rowNumber, 2, fiche.getInfoTraitementDonneuse().getTypeFSH());
        rowNumber++;

        PoiHelper.writeCell(sheet, rowNumber, 0, "% de la dose totale FSH:");
        PoiHelper.writeCell(sheet, rowNumber, 2, fiche.getInfoTraitementDonneuse().getPourc_dose() + "%");
        rowNumber++;

        PoiHelper.writeCell(sheet, rowNumber, 0, "Date").setCellStyle(headerStyle);
        PoiHelper.writeCell(sheet, rowNumber, 1, "Matin (7h30)").setCellStyle(headerStyle);
        PoiHelper.writeCell(sheet, rowNumber, 2, "Après-midi (19h30)").setCellStyle(headerStyle);
        rowNumber++;

//        for (TableauTraitement traitement : fiche.getTableauTraitements()) {
//            PoiHelper.writeCell(sheet, rowNumber, 0, traitement.getDate().toString()).setCellStyle(bodyStyle);
//            PoiHelper.writeCell(sheet, rowNumber, 1, traitement.getMatin()).setCellStyle(bodyStyle);
//            PoiHelper.writeCell(sheet, rowNumber, 2, traitement.getApresMidi()).setCellStyle(bodyStyle);
//            rowNumber++;
//        }

        //
        PoiHelper.writeCell(sheet, rowNumber, 0, "Opérateur IA:");
        PoiHelper.writeCell(sheet, rowNumber, 1, fiche.getOperateur().getNom() + " " + fiche.getOperateur().getPrenom());
        rowNumber++;

        PoiHelper.writeCell(sheet, rowNumber, 0, "Nom taureau:");
        PoiHelper.writeCell(sheet, rowNumber, 1, fiche.getVache().getNum_identification());
        PoiHelper.writeCell(sheet, rowNumber, 3, "Race taureau:");
        PoiHelper.writeCell(sheet, rowNumber, 4, fiche.getVache().getRace() + "");
        PoiHelper.writeCell(sheet, rowNumber, 6, "N° taureau:");
        PoiHelper.writeCell(sheet, rowNumber, 7, fiche.getVache().getNum_identification());
        rowNumber++;

        PoiHelper.writeCell(sheet, rowNumber, 0, "RESULTATS COLLECTE").setCellStyle(titleStyle);
        rowNumber++;

        PoiHelper.writeCell(sheet, rowNumber, 1, "Viables").setCellStyle(headerStyle);
        PoiHelper.writeCell(sheet, rowNumber, 2, "Dégénérés").setCellStyle(headerStyle);
        PoiHelper.writeCell(sheet, rowNumber, 3, "Non Fécondés").setCellStyle(headerStyle);
        PoiHelper.writeCell(sheet, rowNumber, 4, "Total collectés").setCellStyle(headerStyle);
        rowNumber++;

        PoiHelper.writeCell(sheet, rowNumber, 0, "Nb d’embryons").setCellStyle(headerStyle);
        PoiHelper.writeCell(sheet, rowNumber, 1, fiche.getResultat_collecte().getNombre_Embryons_Viables() + "").setCellStyle(bodyStyle);
        PoiHelper.writeCell(sheet, rowNumber, 2, fiche.getResultat_collecte().getNombre_Embryons_Degeneres() + "").setCellStyle(bodyStyle);
        PoiHelper.writeCell(sheet, rowNumber, 3, fiche.getResultat_collecte().getNombre_Embryons_NonFecondes() + "").setCellStyle(bodyStyle);
        PoiHelper.writeCell(sheet, rowNumber, 4, fiche.getResultat_collecte().getNombre_Embryons_Total() + "").setCellStyle(bodyStyle);
        rowNumber++;

        PoiHelper.writeCell(sheet, rowNumber, 0, "Nb de corps jaunes dénombrés:");
        PoiHelper.writeCell(sheet, rowNumber, 3, "Droite:");
        PoiHelper.writeCell(sheet, rowNumber, 4, fiche.getResultat_collecte().getNombre_CorpsJ_droite() + "");
        PoiHelper.writeCell(sheet, rowNumber, 5, "Gauche:");
        PoiHelper.writeCell(sheet, rowNumber, 6, fiche.getResultat_collecte().getNombre_CorpsJ_gauche() + "");
        rowNumber++;

        PoiHelper.writeCell(sheet, rowNumber, 0, "Taux de collecte estimé:");
        PoiHelper.writeCell(sheet, rowNumber, 2, fiche.getResultat_collecte().getTaux_de_collecte() + "");
        PoiHelper.writeCell(sheet, rowNumber, 4, "Sanitaires:");
        //PoiHelper.writeCell(sheet, rowNumber, 5, fiche.getResultat_collecte().getSanitaire());
        rowNumber++;

        PoiHelper.writeCell(sheet, rowNumber, 0, "Remarques:");
        PoiHelper.writeCell(sheet, rowNumber, 1, fiche.getResultat_collecte().getRemarques());
        PoiHelper.mergeRowAndColumn(sheet, rowNumber, rowNumber + 3, 1, 7);
        rowNumber += 3;

        PoiHelper.writeCell(sheet, rowNumber, 0, "DETAILS EMBRYONS VIABLES");
        rowNumber++;

        //Tableau header
        PoiHelper.writeCell(sheet, rowNumber, 0, "N°embryon").setCellStyle(headerStyle);
        PoiHelper.writeCell(sheet, rowNumber, 1, "Stade").setCellStyle(headerStyle);
        PoiHelper.writeCell(sheet, rowNumber, 2, "Qualité\n(1 à 4)").setCellStyle(headerStyle);
        PoiHelper.writeCell(sheet, rowNumber, 3, "Cryoconservé (cocher)").setCellStyle(headerStyle);
        PoiHelper.writeCell(sheet, rowNumber, 4, "Cuve stockage").setCellStyle(headerStyle);
        PoiHelper.writeCell(sheet, rowNumber, 5, "Canister stockage").setCellStyle(headerStyle);
        PoiHelper.writeCell(sheet, rowNumber, 6, "Visotube stockage").setCellStyle(headerStyle);
        PoiHelper.writeCell(sheet, rowNumber, 7, "Jonc").setCellStyle(headerStyle);
        rowNumber++;

        //Tableau body
        for (Embryon detail : fiche.getDetailsEmbryonsViables()) {
            PoiHelper.writeCell(sheet, rowNumber, 0, detail.getNumeroEmbryon() + "").setCellStyle(bodyStyle);
            PoiHelper.writeCell(sheet, rowNumber, 1, detail.getStade() + "").setCellStyle(bodyStyle);
            PoiHelper.writeCell(sheet, rowNumber, 2, detail.getQualite() + "").setCellStyle(bodyStyle);
            PoiHelper.writeCell(sheet, rowNumber, 3, detail.isCryoconserve() ? "X" : "").setCellStyle(bodyStyle);
            rowNumber++;
        }
        rowNumber++;

        //Tableau header
        PoiHelper.writeCell(sheet, rowNumber, 0, "N°embryon").setCellStyle(headerStyle);
        PoiHelper.writeCell(sheet, rowNumber, 1, "Frais (cocher)").setCellStyle(headerStyle);
        PoiHelper.writeCell(sheet, rowNumber, 2, "N° receveuse").setCellStyle(headerStyle);
        PoiHelper.writeCell(sheet, rowNumber, 3, "Référence transfert").setCellStyle(headerStyle);
        PoiHelper.writeCell(sheet, rowNumber, 4, "Détruit (cocher)").setCellStyle(headerStyle);
        PoiHelper.writeCell(sheet, rowNumber, 5, "Remarques").setCellStyle(headerStyle);
        rowNumber++;

        //Tableau body
        for (Embryon detail : fiche.getDetailsEmbryonsViables()) {
            PoiHelper.writeCell(sheet, rowNumber, 0, detail.getNumeroEmbryon() + "").setCellStyle(bodyStyle);
            //PoiHelper.writeCell(sheet, rowNumber, 1, detail.isFrais() ? "X" : "").setCellStyle(bodyStyle);
            PoiHelper.writeCell(sheet, rowNumber, 2, detail.getNumeroReceveuse()).setCellStyle(bodyStyle);
            PoiHelper.writeCell(sheet, rowNumber, 3, detail.getReferenceTransfert()).setCellStyle(bodyStyle);
            PoiHelper.writeCell(sheet, rowNumber, 4, detail.isDetruit() ? "X" : "").setCellStyle(bodyStyle);
            PoiHelper.writeCell(sheet, rowNumber, 5, detail.getRemarque()).setCellStyle(bodyStyle);
            rowNumber++;
        }
    }
}
