package phenotypage.exportation.converters;

import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import phenotypage.model.cryoconservation.embryon.Embryon;
import phenotypage.model.fiche.ficheOpu.FicheOpu;
import phenotypage.model.fiche.ficheOpu.FicheOpuService;
import phenotypage.model.fiche.ficheOpu.ovocytesCollecte.tableauOvocytesCollectes.TableauOvocytesCollectes;
import phenotypage.model.invitro.culture.tableauCulture.TableauCulture;
import phenotypage.model.invitro.fecondation.tableauSemence.TableauSemence;
import phenotypage.model.tableauTraitement.TableauTraitement;
import phenotypage.model.traitementDonneuse.tableau_donneuse.Tableau_Donneuse;
import phenotypage.utils.PoiHelper;

/**
 * Created with magic
 * User: simoe
 * Date: 03/05/2017 23:56
 * Project: appPhenotypage
 */
@Component("Opu")
public class ConverterOPUFiche implements ConverterFiche {

    private final FicheOpuService ficheOpuService;

    @Autowired
    public ConverterOPUFiche(FicheOpuService ficheOpuService) {
        this.ficheOpuService = ficheOpuService;
    }

    @Override
    public XSSFWorkbook toWorkbook(String ficheNom) {
        FicheOpu ficheOpu = ficheOpuService.findByNom(ficheNom);
        XSSFWorkbook workBook = new XSSFWorkbook();
        XSSFSheet sheet = workBook.createSheet(ficheOpu != null ? ficheOpu.getNom() : "Fiche");
        if (ficheOpu != null) {
            writeWorkbook(workBook, sheet, ficheOpu);
        }
        return workBook;
    }

    @SuppressWarnings("Duplicates")
    private void writeWorkbook(XSSFWorkbook workBook, XSSFSheet sheet, FicheOpu fiche) {
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
        if (fiche.getProgramme() != null) {
            PoiHelper.writeCell(sheet, rowNumber, 1, fiche.getProgramme().getNom());
        }
        PoiHelper.writeCell(sheet, rowNumber, 2, "N° agrément:");
        PoiHelper.writeCell(sheet, rowNumber, 3, fiche.getNumeroAgrement());
        PoiHelper.writeCell(sheet, rowNumber, 4, "Lieu:");
        PoiHelper.writeCell(sheet, rowNumber, 5, fiche.getLieu());
        rowNumber++;

        /* Second row */
        PoiHelper.writeCell(sheet, rowNumber, 0, "Date:");
        if (fiche.getDateHeureMinute() != null) {
            PoiHelper.writeCell(sheet, rowNumber, 1, fiche.getDateHeureMinute().toString());
        }
        PoiHelper.writeCell(sheet, rowNumber, 4, "Opérateur(s) OPU:");
        if (fiche.getOperateur() != null) {
            PoiHelper.writeCell(sheet, rowNumber, 6, fiche.getOperateur().getNom() + " " + fiche.getOperateur().getPrenom());
        }
        rowNumber++;
        PoiHelper.writeCell(sheet, rowNumber, 4, "Type OPU:");
        if (fiche.getTypeOpu() != null) {
            PoiHelper.writeCell(sheet, rowNumber, 5, fiche.getTypeOpu().getNom());
        }
        rowNumber += 2;

        //IDENTIFICATION DONNEUSE
        PoiHelper.writeCell(sheet, rowNumber, 0, "IDENTIFICATION DONNEUSE").setCellStyle(titleStyle);
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

        //TRAITEMENT DONNEUSE
        PoiHelper.writeCell(sheet, rowNumber, 0, "TRAITEMENT DONNEUSE").setCellStyle(titleStyle);
        rowNumber++;
        PoiHelper.writeCell(sheet, rowNumber, 0, "Date chaleur de référence:");
        if (fiche.getTraitement_donneuse() != null && fiche.getTraitement_donneuse().getDate_ref_chaleur() != null) {
            PoiHelper.writeCell(sheet, rowNumber, 2, fiche.getTraitement_donneuse().getDate_ref_chaleur().toString());
        }
        PoiHelper.writeCell(sheet, rowNumber, 3, "Type chaleur de référence:");
        if (fiche.getTraitement_donneuse() != null) {
            PoiHelper.writeCell(sheet, rowNumber, 5, fiche.getTraitement_donneuse().getTypeChaleur());
        }
        rowNumber++;

        PoiHelper.writeCell(sheet, rowNumber, 0, "Date").setCellStyle(headerStyle);
        PoiHelper.writeCell(sheet, rowNumber, 1, "Produit").setCellStyle(headerStyle);
        PoiHelper.writeCell(sheet, rowNumber, 2, "Quantité").setCellStyle(headerStyle);
        PoiHelper.writeCell(sheet, rowNumber, 3, "Mode").setCellStyle(headerStyle);
        rowNumber++;

        if (fiche.getTraitement_donneuse() != null) {
            for (Tableau_Donneuse donneuse : fiche.getTraitement_donneuse().getTableauDonneuse()) {
                if (donneuse.getDate() != null) {
                    PoiHelper.writeCell(sheet, rowNumber, 0, donneuse.getDate().toString()).setCellStyle(bodyStyle);
                }
                if (donneuse.getProduit() != null) {
                    PoiHelper.writeCell(sheet, rowNumber, 1, donneuse.getProduit().getNom()).setCellStyle(bodyStyle);
                }
                PoiHelper.writeCell(sheet, rowNumber, 2, donneuse.getQuantite() + "").setCellStyle(bodyStyle);
                PoiHelper.writeCell(sheet, rowNumber, 3, donneuse.getMode_traitement()).setCellStyle(bodyStyle);
                rowNumber++;
            }
        }
        rowNumber++;

        PoiHelper.writeCell(sheet, rowNumber, 0, "Ponction du ou des follicules dominants (> 8 mm):");
        if (fiche.getInfoTraitementDonneuse() != null) {
            //PoiHelper.writeCell(sheet, rowNumber, 4, fiche.getInfoTraitementDonneuse().isPonctionFollicule() ? "oui" : "non");
        }
        rowNumber++;

        PoiHelper.writeCell(sheet, rowNumber, 0, "Nb de follicules aspirés:");
        PoiHelper.writeCell(sheet, rowNumber, 3, "Droite:");
        PoiHelper.writeCell(sheet, rowNumber, 5, "Gauche:");
        if (fiche.getInfoTraitementDonneuse() != null) {
            PoiHelper.writeCell(sheet, rowNumber, 2, fiche.getInfoTraitementDonneuse().getNb_follicules() + "");
            PoiHelper.writeCell(sheet, rowNumber, 4, fiche.getInfoTraitementDonneuse().getNb_droite() + "");
            PoiHelper.writeCell(sheet, rowNumber, 6, fiche.getInfoTraitementDonneuse().getNb_gauche() + "");
        }
        rowNumber++;

        PoiHelper.writeCell(sheet, rowNumber, 0, "Image(s) échographe:");
        if (fiche.getInfoTraitementDonneuse() != null) {
            PoiHelper.writeCell(sheet, rowNumber, 2, fiche.getInfoTraitementDonneuse().isImage_echo() ? "oui" : "non");
        }
        rowNumber++;

        PoiHelper.writeCell(sheet, rowNumber, 0, "Traitement superovulation:");
        if (fiche.getInfoTraitementDonneuse() != null) {
           // PoiHelper.writeCell(sheet, rowNumber, 2, fiche.getInfoTraitementDonneuse().isSuperovulation() ? "oui" : "non");
        }
        rowNumber++;

        PoiHelper.writeCell(sheet, rowNumber, 0, "Type FSH:");
        if (fiche.getInfoTraitementDonneuse() != null) {
         //   PoiHelper.writeCell(sheet, rowNumber, 2, fiche.getInfoTraitementDonneuse().getTypeFSH());
        }
        rowNumber++;

        PoiHelper.writeCell(sheet, rowNumber, 0, "% de la dose totale FSH:");
        if (fiche.getInfoTraitementDonneuse() != null) {
            PoiHelper.writeCell(sheet, rowNumber, 2, fiche.getInfoTraitementDonneuse().getPourc_dose() + "%");
        }
        rowNumber++;

        PoiHelper.writeCell(sheet, rowNumber, 0, "Date").setCellStyle(headerStyle);
        PoiHelper.writeCell(sheet, rowNumber, 1, "Matin (7h30)").setCellStyle(headerStyle);
        PoiHelper.writeCell(sheet, rowNumber, 2, "Après-midi (19h30)").setCellStyle(headerStyle);
        rowNumber++;

        for (TableauTraitement traitement : fiche.getTableauTraitements()) {
            if (traitement.getDate() != null) {
                PoiHelper.writeCell(sheet, rowNumber, 0, traitement.getDate().toString()).setCellStyle(bodyStyle);
            }
            PoiHelper.writeCell(sheet, rowNumber, 1, traitement.getMatin()).setCellStyle(bodyStyle);
            PoiHelper.writeCell(sheet, rowNumber, 2, traitement.getApresMidi()).setCellStyle(bodyStyle);
            rowNumber++;
        }
        rowNumber++;

        //TRAITEMENT DONNEUSE 2
        PoiHelper.writeCell(sheet, rowNumber, 0, "TRAITEMENT DONNEUSE").setCellStyle(titleStyle);
        rowNumber++;
        PoiHelper.writeCell(sheet, rowNumber, 0, "Image(s) échographe:");
        if (fiche.getInfoTraitementDonneuse() != null) {
            PoiHelper.writeCell(sheet, rowNumber, 2, fiche.getInfoTraitementDonneuse().isImage_echo() ? "oui" : "non");
        }
        rowNumber++;

        PoiHelper.writeCell(sheet, rowNumber, 1, "< 8 mm (Nb)");
        PoiHelper.mergeColumn(sheet, rowNumber, 1, 2);
        PoiHelper.writeCell(sheet, rowNumber, 3, "8-15 mm");
        PoiHelper.mergeColumn(sheet, rowNumber, 3, 4);
        PoiHelper.writeCell(sheet, rowNumber, 5, "> 15 mm");
        PoiHelper.mergeColumn(sheet, rowNumber, 5, 6);
        rowNumber++;

        PoiHelper.writeCell(sheet, rowNumber, 0, "Ovaires").setCellStyle(headerStyle);
        PoiHelper.writeCell(sheet, rowNumber, 1, "Dénombrés").setCellStyle(headerStyle);
        PoiHelper.writeCell(sheet, rowNumber, 2, "Aspirés").setCellStyle(headerStyle);
        PoiHelper.writeCell(sheet, rowNumber, 3, "Dénombrés").setCellStyle(headerStyle);
        PoiHelper.writeCell(sheet, rowNumber, 4, "Aspirés").setCellStyle(headerStyle);
        PoiHelper.writeCell(sheet, rowNumber, 5, "Dénombrés").setCellStyle(headerStyle);
        PoiHelper.writeCell(sheet, rowNumber, 6, "Aspirés").setCellStyle(headerStyle);
        rowNumber++;

        PoiHelper.writeCell(sheet, rowNumber, 0, "Droit").setCellStyle(headerStyle);
        if (fiche.getImageEcho() != null) {
            PoiHelper.writeCell(sheet, rowNumber, 1, fiche.getImageEcho().getNb_ovaire_denombre_droitInf8() + "").setCellStyle(bodyStyle);
            PoiHelper.writeCell(sheet, rowNumber, 2, fiche.getImageEcho().getNb_ovaire_aspire_droitInf8() + "").setCellStyle(bodyStyle);
            PoiHelper.writeCell(sheet, rowNumber, 3, fiche.getImageEcho().getNb_ovaire_denombre_droitSup8() + "").setCellStyle(bodyStyle);
            PoiHelper.writeCell(sheet, rowNumber, 4, fiche.getImageEcho().getNb_ovaire_aspire_droitSup8() + "").setCellStyle(bodyStyle);
            PoiHelper.writeCell(sheet, rowNumber, 5, fiche.getImageEcho().getNb_ovaire_denombre_droitSup15() + "").setCellStyle(bodyStyle);
            PoiHelper.writeCell(sheet, rowNumber, 6, fiche.getImageEcho().getNb_ovaire_aspire_droitSup15() + "").setCellStyle(bodyStyle);
        }
        rowNumber++;

        PoiHelper.writeCell(sheet, rowNumber, 0, "Gauche").setCellStyle(headerStyle);
        if (fiche.getImageEcho() != null) {
            PoiHelper.writeCell(sheet, rowNumber, 1, fiche.getImageEcho().getNb_ovaire_denombre_gaucheInf8() + "").setCellStyle(bodyStyle);
            PoiHelper.writeCell(sheet, rowNumber, 2, fiche.getImageEcho().getNb_ovaire_aspire_gaucheInf8() + "").setCellStyle(bodyStyle);
            PoiHelper.writeCell(sheet, rowNumber, 3, fiche.getImageEcho().getNb_ovaire_denombre_gaucheSup8() + "").setCellStyle(bodyStyle);
            PoiHelper.writeCell(sheet, rowNumber, 4, fiche.getImageEcho().getNb_ovaire_aspire_gaucheSup8() + "").setCellStyle(bodyStyle);
            PoiHelper.writeCell(sheet, rowNumber, 5, fiche.getImageEcho().getNb_ovaire_denombre_gaucheSup15() + "").setCellStyle(bodyStyle);
            PoiHelper.writeCell(sheet, rowNumber, 6, fiche.getImageEcho().getNb_ovaire_aspire_gaucheSup15() + "").setCellStyle(bodyStyle);
        }
        rowNumber++;

        PoiHelper.writeCell(sheet, rowNumber, 0, "Nb de COCs retrouvés:");
        PoiHelper.writeCell(sheet, rowNumber, 3, "Taux de collecte:");
        if (fiche.getImageEcho() != null) {
            PoiHelper.writeCell(sheet, rowNumber, 2, fiche.getImageEcho().getNb_cocs() + "");
            PoiHelper.writeCell(sheet, rowNumber, 5, fiche.getImageEcho().getTaux_collecte() + "%");
        }
        rowNumber += 2;

        PoiHelper.writeCell(sheet, rowNumber, 0, "Remarques:");
        if (fiche.getImageEcho() != null) {
            PoiHelper.writeCell(sheet, rowNumber, 1, fiche.getImageEcho().getRemarques());
        }
        PoiHelper.mergeRowAndColumn(sheet, rowNumber, rowNumber + 3, 1, 7);
        rowNumber += 3;

        //TRAITEMENT DONNEUSE 2
        PoiHelper.writeCell(sheet, rowNumber, 0, "DETAILS COMPLEXE OVOCYTES-CUMULUS (COCs) COLLECTES").setCellStyle(titleStyle);
        rowNumber++;

        PoiHelper.writeCell(sheet, rowNumber, 0, "Nb de COCs").setCellStyle(headerStyle);
        PoiHelper.writeCell(sheet, rowNumber, 1, "Mature (M) - Immature (I)").setCellStyle(headerStyle);
        PoiHelper.writeCell(sheet, rowNumber, 2, "Qualité (1 à 4)").setCellStyle(headerStyle);
        PoiHelper.writeCell(sheet, rowNumber, 3, "FIV (cocher)").setCellStyle(headerStyle);
        PoiHelper.writeCell(sheet, rowNumber, 4, "Détruit (cocher)").setCellStyle(headerStyle);
        PoiHelper.writeCell(sheet, rowNumber, 5, "Autre utilisation (préciser)").setCellStyle(headerStyle);
        rowNumber++;
        if (fiche.getOvocytesCollectes() != null) {
            for (TableauOvocytesCollectes collectes : fiche.getOvocytesCollectes().getTableauOvocytes_collectesList()) {
                PoiHelper.writeCell(sheet, rowNumber, 0, collectes.getNb_cocs() + "").setCellStyle(bodyStyle);
                PoiHelper.writeCell(sheet, rowNumber, 1, collectes.isMature() ? "M" : "I").setCellStyle(bodyStyle);
                PoiHelper.writeCell(sheet, rowNumber, 2, collectes.getQualite() + "").setCellStyle(bodyStyle);
                PoiHelper.writeCell(sheet, rowNumber, 3, collectes.isFiv() ? "X" : "").setCellStyle(bodyStyle);
                PoiHelper.writeCell(sheet, rowNumber, 4, "").setCellStyle(bodyStyle);
                PoiHelper.writeCell(sheet, rowNumber, 5, collectes.getUtilisation()).setCellStyle(bodyStyle);
                rowNumber++;
            }
        }
        rowNumber++;

        PoiHelper.writeCell(sheet, rowNumber, 0, "Sanitaires:");
        if (fiche.getOvocytesCollectes() != null) {
            PoiHelper.writeCell(sheet, rowNumber, 1, fiche.getOvocytesCollectes().getSanitaire());
        }
        rowNumber += 2;

        PoiHelper.writeCell(sheet, rowNumber, 0, "Remarques:");
        if (fiche.getOvocytesCollectes() != null) {
            PoiHelper.writeCell(sheet, rowNumber, 1, fiche.getOvocytesCollectes().getRemarques());
        }
        PoiHelper.mergeRowAndColumn(sheet, rowNumber, rowNumber + 3, 1, 7);
        rowNumber += 3;

        //INFORMATIONS PIV
        PoiHelper.writeCell(sheet, rowNumber, 0, "INFORMATIONS PIV").setCellStyle(titleStyle);
        rowNumber++;

        PoiHelper.writeCell(sheet, rowNumber, 0, "Opérateur:");
        if (fiche.getInformations_piv() != null && fiche.getInformations_piv().getOperateur() != null) {
            PoiHelper.writeCell(sheet, rowNumber, 1, fiche.getInformations_piv().getOperateur().getNom() + " " + fiche.getInformations_piv().getOperateur().getPrenom());
        }
        rowNumber += 2;

        PoiHelper.writeCell(sheet, rowNumber, 0, "Maturation").setCellStyle(headerStyle);
        if (fiche.getInformations_piv() != null && fiche.getInformations_piv().getMilieuMaturation() != null) {
            PoiHelper.writeCell(sheet, rowNumber, 1, fiche.getInformations_piv().getMilieuMaturation().getNom()).setCellStyle(bodyStyle);
            PoiHelper.writeCell(sheet, rowNumber, 2, fiche.getInformations_piv().getMilieuMaturation().getNumeroLot()).setCellStyle(bodyStyle);
        }
        rowNumber++;

        PoiHelper.writeCell(sheet, rowNumber, 0, "FIV").setCellStyle(headerStyle);
        if (fiche.getInformations_piv() != null && fiche.getInformations_piv().getFiv() != null) {
            PoiHelper.writeCell(sheet, rowNumber, 1, fiche.getInformations_piv().getFiv().getNom()).setCellStyle(bodyStyle);
            PoiHelper.writeCell(sheet, rowNumber, 2, fiche.getInformations_piv().getFiv().getNumeroLot()).setCellStyle(bodyStyle);
        }
        rowNumber++;

        PoiHelper.writeCell(sheet, rowNumber, 0, "Culture").setCellStyle(headerStyle);
        if (fiche.getInformations_piv() != null && fiche.getInformations_piv().getTypeCulture() != null) {
            PoiHelper.writeCell(sheet, rowNumber, 1, fiche.getInformations_piv().getTypeCulture().getNom()).setCellStyle(bodyStyle);
            PoiHelper.writeCell(sheet, rowNumber, 2, fiche.getInformations_piv().getTypeCulture().getNumeroLot()).setCellStyle(bodyStyle);
        }
        rowNumber += 3;

        //MATURATION IN VITRO
        PoiHelper.writeCell(sheet, rowNumber, 0, "MATURATION IN VITRO").setCellStyle(titleStyle);
        rowNumber++;

        PoiHelper.writeCell(sheet, rowNumber, 0, "Date:");
        if (fiche.getMaturationInVitro() != null && fiche.getMaturationInVitro().getDateMaturation() != null) {
            PoiHelper.writeCell(sheet, rowNumber, 1, fiche.getMaturationInVitro().getDateMaturation().toString());
        }
        rowNumber++;

        PoiHelper.writeCell(sheet, rowNumber, 0, "Nb COCs mis en maturation").setCellStyle(headerStyle);
        PoiHelper.writeCell(sheet, rowNumber, 1, "Heure début maturation").setCellStyle(headerStyle);
        PoiHelper.writeCell(sheet, rowNumber, 2, "Heure fin maturation").setCellStyle(headerStyle);
        PoiHelper.writeCell(sheet, rowNumber, 3, "Nb COCs matures").setCellStyle(headerStyle);
        rowNumber++;


        if (fiche.getMaturationInVitro() != null) {
            PoiHelper.writeCell(sheet, rowNumber, 0, fiche.getMaturationInVitro().getNbCocsMaturation() + "").setCellStyle(bodyStyle);
            PoiHelper.writeCell(sheet, rowNumber, 1, fiche.getMaturationInVitro().getHeureDebutMaturation().toString()).setCellStyle(bodyStyle);
            PoiHelper.writeCell(sheet, rowNumber, 2, fiche.getMaturationInVitro().getHeureFinMaturation().toString()).setCellStyle(bodyStyle);
            PoiHelper.writeCell(sheet, rowNumber, 3, fiche.getMaturationInVitro().getNbCocsMature() + "").setCellStyle(bodyStyle);
        }
        rowNumber += 2;

        //FECONDATION IN VITRO
        PoiHelper.writeCell(sheet, rowNumber, 0, "FECONDATION IN VITRO").setCellStyle(titleStyle);
        rowNumber++;

        PoiHelper.writeCell(sheet, rowNumber, 0, "Date:");
        if (fiche.getFecondation() != null && fiche.getFecondation().getDate() != null) {
            PoiHelper.writeCell(sheet, rowNumber, 1, fiche.getFecondation().getDate().toString());
        }
        PoiHelper.writeCell(sheet, rowNumber, 4, "Sanitaires:");
        if (fiche.getFecondation() != null) {
            PoiHelper.writeCell(sheet, rowNumber, 5, fiche.getFecondation().getSanitaireList());
        }
        rowNumber++;

        PoiHelper.writeCell(sheet, rowNumber, 0, "Taureau").setCellStyle(headerStyle);
        PoiHelper.writeCell(sheet, rowNumber, 1, "Race").setCellStyle(headerStyle);
        PoiHelper.writeCell(sheet, rowNumber, 2, "N° éjaculat").setCellStyle(headerStyle);
        PoiHelper.writeCell(sheet, rowNumber, 3, "Etat frais avant FIV").setCellStyle(headerStyle);
        PoiHelper.writeCell(sheet, rowNumber, 4, "Vol. FIV (µl)").setCellStyle(headerStyle);
        PoiHelper.writeCell(sheet, rowNumber, 5, "n° N").setCellStyle(headerStyle);
        rowNumber++;

        if (fiche.getFecondation() != null) {
            for (TableauSemence semence : fiche.getFecondation().getTableau_semences()) {
                if (semence.getTaureau() != null) {
                    PoiHelper.writeCell(sheet, rowNumber, 0, semence.getTaureau().getNum_identification()).setCellStyle(bodyStyle);
                    PoiHelper.writeCell(sheet, rowNumber, 1, semence.getTaureau().getRace() + "").setCellStyle(bodyStyle);
                    PoiHelper.writeCell(sheet, rowNumber, 5, semence.getTaureau().getNum_identification()).setCellStyle(bodyStyle);
                }
                PoiHelper.writeCell(sheet, rowNumber, 2, semence.getNumeroEjaculation()).setCellStyle(bodyStyle);
                PoiHelper.writeCell(sheet, rowNumber, 3, semence.getEtatFrais() + "%").setCellStyle(bodyStyle);
                PoiHelper.writeCell(sheet, rowNumber, 4, semence.getVolume() + "").setCellStyle(bodyStyle);
                rowNumber++;
            }
        }
        rowNumber++;

        //CULTURE IN VITRO
        PoiHelper.writeCell(sheet, rowNumber, 0, "CULTURE IN VITRO").setCellStyle(titleStyle);
        rowNumber++;

        PoiHelper.writeCell(sheet, rowNumber, 0, "Date:");
        if (fiche.getCulture() != null && fiche.getCulture().getDate() != null) {
            PoiHelper.writeCell(sheet, rowNumber, 1, fiche.getCulture().getDate().toString());
        }

        PoiHelper.writeCell(sheet, rowNumber, 4, "Sanitaires:");
        if (fiche.getCulture() != null) {
            PoiHelper.writeCell(sheet, rowNumber, 5, fiche.getCulture().getSanitaireList());
        }
        rowNumber += 2;

        PoiHelper.writeCell(sheet, rowNumber, 0, "Groupe").setCellStyle(headerStyle);
        PoiHelper.writeCell(sheet, rowNumber, 1, "Nb d'ovo inséminés").setCellStyle(headerStyle);
        PoiHelper.writeCell(sheet, rowNumber, 2, "Heure de mise en culture").setCellStyle(headerStyle);
        PoiHelper.writeCell(sheet, rowNumber, 3, "Nb segmentés").setCellStyle(headerStyle);
        PoiHelper.writeCell(sheet, rowNumber, 4, "% seg").setCellStyle(headerStyle);
        PoiHelper.writeCell(sheet, rowNumber, 5, "J5 Morula").setCellStyle(headerStyle);
        rowNumber++;

        if (fiche.getCulture() != null) {
            for (TableauCulture culture : fiche.getCulture().getTableauCultureList()) {
                PoiHelper.writeCell(sheet, rowNumber, 0, culture.getGroupe()).setCellStyle(bodyStyle);
                PoiHelper.writeCell(sheet, rowNumber, 1, culture.getNbInsemine() + "").setCellStyle(bodyStyle);
                PoiHelper.writeCell(sheet, rowNumber, 2, culture.getHeureCulture() + "").setCellStyle(bodyStyle);
                PoiHelper.writeCell(sheet, rowNumber, 3, culture.getNbSegmente() + "").setCellStyle(bodyStyle);
                PoiHelper.writeCell(sheet, rowNumber, 4, culture.getSegment() + "%").setCellStyle(bodyStyle);
                PoiHelper.writeCell(sheet, rowNumber, 5, culture.getJ5JM() + "").setCellStyle(bodyStyle);
                rowNumber++;
            }
        }
        rowNumber++;

        PoiHelper.writeCell(sheet, rowNumber, 0, "Groupe").setCellStyle(headerStyle);
        PoiHelper.writeCell(sheet, rowNumber, 1, "J7 mo").setCellStyle(headerStyle);
        PoiHelper.writeCell(sheet, rowNumber, 2, "J7 BL").setCellStyle(headerStyle);
        PoiHelper.writeCell(sheet, rowNumber, 3, "J7 BE").setCellStyle(headerStyle);
        PoiHelper.writeCell(sheet, rowNumber, 4, "J7 Q1").setCellStyle(headerStyle);
        PoiHelper.writeCell(sheet, rowNumber, 5, "J7 Nb total").setCellStyle(headerStyle);
        rowNumber++;

        if (fiche.getCulture() != null) {
            for (TableauCulture culture : fiche.getCulture().getTableauCultureList()) {
                PoiHelper.writeCell(sheet, rowNumber, 0, culture.getGroupe()).setCellStyle(bodyStyle);
                PoiHelper.writeCell(sheet, rowNumber, 1, culture.getMo() + "").setCellStyle(bodyStyle);
                PoiHelper.writeCell(sheet, rowNumber, 2, culture.getBl() + "").setCellStyle(bodyStyle);
                PoiHelper.writeCell(sheet, rowNumber, 3, culture.getBe() + "").setCellStyle(bodyStyle);
                PoiHelper.writeCell(sheet, rowNumber, 4, culture.getQ1() + "").setCellStyle(bodyStyle);
                PoiHelper.writeCell(sheet, rowNumber, 5, culture.getNbTotal() + "").setCellStyle(bodyStyle);
                rowNumber++;
            }
        }
        rowNumber++;

        PoiHelper.writeCell(sheet, rowNumber, 0, "Groupe").setCellStyle(headerStyle);
        PoiHelper.writeCell(sheet, rowNumber, 1, "%J7").setCellStyle(headerStyle);
        PoiHelper.writeCell(sheet, rowNumber, 2, "%BEJ7").setCellStyle(headerStyle);
        PoiHelper.writeCell(sheet, rowNumber, 3, "%Q1J7").setCellStyle(headerStyle);
        PoiHelper.writeCell(sheet, rowNumber, 4, "J8 Nb").setCellStyle(headerStyle);
        PoiHelper.writeCell(sheet, rowNumber, 5, "%J8").setCellStyle(headerStyle);
        PoiHelper.writeCell(sheet, rowNumber, 6, "Destination (détruits/cryo)").setCellStyle(headerStyle);
        rowNumber++;

        if (fiche.getCulture() != null) {
            for (TableauCulture culture : fiche.getCulture().getTableauCultureList()) {
                PoiHelper.writeCell(sheet, rowNumber, 0, culture.getGroupe()).setCellStyle(bodyStyle);
                PoiHelper.writeCell(sheet, rowNumber, 1, culture.getPourJ7() + "%").setCellStyle(bodyStyle);
                PoiHelper.writeCell(sheet, rowNumber, 2, culture.getPourBEJ7() + "%").setCellStyle(bodyStyle);
                PoiHelper.writeCell(sheet, rowNumber, 3, culture.getPourQ1J7() + "%").setCellStyle(bodyStyle);
                PoiHelper.writeCell(sheet, rowNumber, 4, culture.getJ8parNb() + "").setCellStyle(bodyStyle);
                PoiHelper.writeCell(sheet, rowNumber, 5, culture.getPourJ8() + "%").setCellStyle(bodyStyle);
                PoiHelper.writeCell(sheet, rowNumber, 6, culture.getDestination()).setCellStyle(bodyStyle);
                rowNumber++;
            }
        }
        rowNumber++;

        PoiHelper.writeCell(sheet, rowNumber, 0, "Remarques:");
        PoiHelper.mergeRowAndColumn(sheet, rowNumber, rowNumber + 3, 1, 7);
        rowNumber += 3;

        //DETAILS EMBRYONS VIABLES
        PoiHelper.writeCell(sheet, rowNumber, 0, "DETAILS EMBRYONS VIABLES").setCellStyle(titleStyle);
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

        //Tableau body
        for (Embryon detail : fiche.getTableauDetails()) {
            PoiHelper.writeCell(sheet, rowNumber, 0, detail.getNumeroEmbryon() + "").setCellStyle(bodyStyle);
            PoiHelper.writeCell(sheet, rowNumber, 1, detail.getStade() + "").setCellStyle(bodyStyle);
            PoiHelper.writeCell(sheet, rowNumber, 2, detail.getQualite() + "").setCellStyle(bodyStyle);
            PoiHelper.writeCell(sheet, rowNumber, 3, detail.isCryoconserve() ? "X" : "").setCellStyle(bodyStyle);
        }

        //Tableau header
        PoiHelper.writeCell(sheet, rowNumber, 0, "N°embryon").setCellStyle(headerStyle);
        PoiHelper.writeCell(sheet, rowNumber, 1, "Frais (cocher)").setCellStyle(headerStyle);
        PoiHelper.writeCell(sheet, rowNumber, 2, "N° receveuse").setCellStyle(headerStyle);
        PoiHelper.writeCell(sheet, rowNumber, 3, "Référence transfert").setCellStyle(headerStyle);
        PoiHelper.writeCell(sheet, rowNumber, 4, "Détruit (cocher)").setCellStyle(headerStyle);
        PoiHelper.writeCell(sheet, rowNumber, 5, "Remarques").setCellStyle(headerStyle);

        //Tableau body
        for (Embryon detail : fiche.getTableauDetails()) {
            PoiHelper.writeCell(sheet, rowNumber, 0, detail.getNumeroEmbryon() + "").setCellStyle(bodyStyle);
            //PoiHelper.writeCell(sheet, rowNumber, 1, detail.isFrais() ? "X" : "").setCellStyle(bodyStyle);
            PoiHelper.writeCell(sheet, rowNumber, 2, detail.getNumeroReceveuse()).setCellStyle(bodyStyle);
            PoiHelper.writeCell(sheet, rowNumber, 3, detail.getReferenceTransfert()).setCellStyle(bodyStyle);
            PoiHelper.writeCell(sheet, rowNumber, 4, detail.isDetruit() ? "X" : "").setCellStyle(bodyStyle);
            PoiHelper.writeCell(sheet, rowNumber, 5, detail.getRemarque()).setCellStyle(bodyStyle);
        }

        //INFORMATIONS SI CRYOCONSERVATION
        PoiHelper.writeCell(sheet, rowNumber, 0, "INFORMATIONS SI CRYOCONSERVATION").setCellStyle(titleStyle);
        rowNumber++;

        PoiHelper.writeCell(sheet, rowNumber, 0, "Référence congélation :");
        PoiHelper.writeCell(sheet, rowNumber, 4, "Heure de congélation :");

        if (fiche.getCryoconservation() != null) {
            PoiHelper.writeCell(sheet, rowNumber, 1, fiche.getCryoconservation().getRef());
            PoiHelper.writeCell(sheet, rowNumber, 5, fiche.getCryoconservation().getHeureMinute().toString());
        }
        rowNumber++;

        PoiHelper.writeCell(sheet, rowNumber, 0, "Méthode de congélation :");
        if (fiche.getCryoconservation() != null) {
            PoiHelper.writeCell(sheet, rowNumber, 1, fiche.getCryoconservation().getMethodeCongelation());
        }
        rowNumber++;

        PoiHelper.writeCell(sheet, rowNumber, 0, "Congélateur utilisé : ");
        if (fiche.getCryoconservation() != null) {
            PoiHelper.writeCell(sheet, rowNumber, 1, fiche.getCryoconservation().getCongelateur());
        }
        rowNumber++;

        PoiHelper.writeCell(sheet, rowNumber, 0, "Opérateur congélation : ");
        if (fiche.getCryoconservation() != null) {
            PoiHelper.writeCell(sheet, rowNumber, 1, fiche.getCryoconservation().getOperateur().getNom() + " " + fiche.getCryoconservation().getOperateur().getPrenom());
        }
        rowNumber++;

        PoiHelper.writeCell(sheet, rowNumber, 0, "Description méthode (nom programme, cinétique, seeding…) :");
        rowNumber++;

        if (fiche.getCryoconservation() != null) {
            PoiHelper.writeCell(sheet, rowNumber, 0, fiche.getCryoconservation().getDescMethode());
            PoiHelper.mergeRowAndColumn(sheet, rowNumber, rowNumber + 3, 0, 7);
        }
    }
}
