package phenotypage.exportation.converters;

import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import phenotypage.model.cryoconservation.TableauDetail;
import phenotypage.model.donneesExistantes.sanitaire.Sanitaire;
import phenotypage.model.fiche.ficheAba.FicheAba;
import phenotypage.model.fiche.ficheAba.FicheAbaService;
import phenotypage.model.invitro.collecte.Tableau_Collecte;
import phenotypage.model.invitro.collecte.Tableau_Maturation;
import phenotypage.model.invitro.culture.TableauCulture;
import phenotypage.model.invitro.fecondation.TableauSemence;
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
            writeWorkbook(workBook, sheet, ficheAba);
        }
        return workBook;
    }

    private void writeWorkbook(XSSFWorkbook workBook, XSSFSheet sheet, FicheAba ficheAba) {
        int rowNumber = 1;
        if (ficheAba == null)
            return;

        /* Styling */
        sheet.setColumnWidth(0, 12 * 256);
        sheet.setColumnWidth(1, 12 * 256);
        sheet.setColumnWidth(2, 12 * 256);
        sheet.setColumnWidth(3, 17 * 256);
        sheet.setColumnWidth(4, 12 * 256);
        sheet.setColumnWidth(5, 12 * 256);
        sheet.setColumnWidth(6, 13 * 256);
        sheet.setColumnWidth(7, 12 * 256);

        //Title style
        XSSFFont boldUnderlinedFont = workBook.createFont();
        boldUnderlinedFont.setBold(true);
        boldUnderlinedFont.setUnderline(XSSFFont.U_SINGLE);

        XSSFCellStyle titleStyle = workBook.createCellStyle();
        titleStyle.setFont(boldUnderlinedFont);

        //Table header style
        XSSFFont boldFont = workBook.createFont();
        boldUnderlinedFont.setBold(true);

        XSSFCellStyle headerStyle = workBook.createCellStyle();
        headerStyle.setFont(boldFont);
        headerStyle.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.getIndex());
        headerStyle.setFillPattern(CellStyle.SOLID_FOREGROUND);
        headerStyle.setAlignment(CellStyle.ALIGN_CENTER);
        headerStyle.setBorderBottom(BorderStyle.THIN);
        headerStyle.setBorderLeft(BorderStyle.THIN);
        headerStyle.setBorderRight(BorderStyle.THIN);
        headerStyle.setBorderTop(BorderStyle.THIN);

        //Table body style
        XSSFCellStyle bodyStyle = workBook.createCellStyle();
        bodyStyle.setAlignment(CellStyle.ALIGN_CENTER);
        bodyStyle.setBorderBottom(BorderStyle.THIN);
        bodyStyle.setBorderLeft(BorderStyle.THIN);
        bodyStyle.setBorderRight(BorderStyle.THIN);
        bodyStyle.setBorderTop(BorderStyle.THIN);

        /*Styling end*/

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
        XSSFCell pivCell = PoiHelper.writeCell(sheet, rowNumber, 0, "INFORMATIONS GENERALES PIV");
        pivCell.setCellStyle(titleStyle);
        rowNumber++;

        //Operateur PIV
        PoiHelper.writeCell(sheet, rowNumber, 0, "Opérateur:");
        if (ficheAba.getInformations_piv() != null && ficheAba.getInformations_piv().getOperateur() != null) {
            PoiHelper.writeCell(sheet, rowNumber, 1, ficheAba.getInformations_piv().getOperateur().getNom() + " " + ficheAba.getInformations_piv().getOperateur().getPrenom());
        }
        rowNumber += 2;

        //Maturation
        PoiHelper.writeCell(sheet, rowNumber, 0, "Maturation").setCellStyle(headerStyle);
        if (ficheAba.getInformations_piv() != null && ficheAba.getInformations_piv().getMilieuMaturation() != null) {
            PoiHelper.writeCell(sheet, rowNumber, 1, ficheAba.getInformations_piv().getMilieuMaturation().getNom()).setCellStyle(bodyStyle);
            PoiHelper.writeCell(sheet, rowNumber, 2, ficheAba.getInformations_piv().getMilieuMaturation().getNumeroLot()).setCellStyle(bodyStyle);
        }
        rowNumber++;

        //FIV
        PoiHelper.writeCell(sheet, rowNumber, 0, "FIV").setCellStyle(headerStyle);
        if (ficheAba.getInformations_piv() != null && ficheAba.getInformations_piv().getFiv() != null) {
            PoiHelper.writeCell(sheet, rowNumber, 1, ficheAba.getInformations_piv().getFiv().getNom()).setCellStyle(bodyStyle);
            PoiHelper.writeCell(sheet, rowNumber, 2, ficheAba.getInformations_piv().getFiv().getNumeroLot()).setCellStyle(bodyStyle);
        }
        rowNumber++;

        //Culture
        PoiHelper.writeCell(sheet, rowNumber, 0, "Culture").setCellStyle(headerStyle);
        if (ficheAba.getInformations_piv() != null && ficheAba.getInformations_piv().getTypeCulture() != null) {
            PoiHelper.writeCell(sheet, rowNumber, 1, ficheAba.getInformations_piv().getTypeCulture().getNom()).setCellStyle(bodyStyle);
            PoiHelper.writeCell(sheet, rowNumber, 2, ficheAba.getInformations_piv().getTypeCulture().getNumeroLot()).setCellStyle(bodyStyle);
        }
        rowNumber += 3;

        //COLLECTE & MATURATION IN VITRO
        PoiHelper.writeCell(sheet, rowNumber, 0, "COLLECTE & MATURATION IN VITRO").setCellStyle(titleStyle);
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
        PoiHelper.writeCell(sheet, rowNumber, 0, "Race ovaires").setCellStyle(headerStyle);
        PoiHelper.writeCell(sheet, rowNumber, 1, "N° femelle ou pool").setCellStyle(headerStyle);
        PoiHelper.writeCell(sheet, rowNumber, 2, "Nb ovaires").setCellStyle(headerStyle);
        PoiHelper.writeCell(sheet, rowNumber, 3, "Nb ovocytes").setCellStyle(headerStyle);
        PoiHelper.writeCell(sheet, rowNumber, 4, "Taux collecte").setCellStyle(headerStyle);
        PoiHelper.writeCell(sheet, rowNumber, 5, "Heure début maturation").setCellStyle(headerStyle);
        PoiHelper.writeCell(sheet, rowNumber, 6, "Heure FIV").setCellStyle(headerStyle);
        rowNumber++;

        //Tableau body
        if (ficheAba.getCollecte() != null) {
            for (Tableau_Collecte collecte : ficheAba.getCollecte().getTableauCollecteList()) {
                PoiHelper.writeCell(sheet, rowNumber, 0, collecte.getRace_Ovaires()).setCellStyle(bodyStyle);
                if (collecte.isPool()) {
                    PoiHelper.writeCell(sheet, rowNumber, 1, "pool").setCellStyle(bodyStyle);
                } else if (collecte.getVache() != null) {
                    PoiHelper.writeCell(sheet, rowNumber, 1, collecte.getVache().getNum_identification()).setCellStyle(bodyStyle);
                }
                PoiHelper.writeCell(sheet, rowNumber, 2, collecte.getNombre_Ovaires() + "").setCellStyle(bodyStyle);
                PoiHelper.writeCell(sheet, rowNumber, 3, collecte.getNombre_Ovocytes() + "").setCellStyle(bodyStyle);
                PoiHelper.writeCell(sheet, rowNumber, 4, collecte.getTaux_Collecte() + "").setCellStyle(bodyStyle);
                PoiHelper.writeCell(sheet, rowNumber, 5, collecte.getHeureDebutMaturation().toString()).setCellStyle(bodyStyle);
                PoiHelper.writeCell(sheet, rowNumber, 6, collecte.getHeureFiv().toString()).setCellStyle(bodyStyle);
                rowNumber++;
            }
        }
        rowNumber++;

        //MIV Tableau header
        PoiHelper.writeCell(sheet, rowNumber, 0, "Groupes expérimentaux MIV").setCellStyle(headerStyle);
        PoiHelper.writeCell(sheet, rowNumber, 1, "Nb d'ovocytes").setCellStyle(headerStyle);
        rowNumber++;

        //MIV Tableau body
        if (ficheAba.getCollecte() != null) {
            for (Tableau_Maturation maturation : ficheAba.getCollecte().getTableauMaturationList()) {
                PoiHelper.writeCell(sheet, rowNumber, 0, maturation.getGroupeExperimentauxMIV()).setCellStyle(bodyStyle);
                PoiHelper.writeCell(sheet, rowNumber, 1, maturation.getNbOvocyte() + "").setCellStyle(bodyStyle);
                rowNumber++;
            }
        }
        rowNumber++;

        //FECONDATION IN VITRO
        PoiHelper.writeCell(sheet, rowNumber, 0, "FECONDATION IN VITRO").setCellStyle(titleStyle);
        rowNumber++;

        PoiHelper.writeCell(sheet, rowNumber, 0, "Date:");
        PoiHelper.writeCell(sheet, rowNumber, 1, ficheAba.getFecondation().getDate().toString());
        PoiHelper.writeCell(sheet, rowNumber, 4, "Sanitaires:");
        int column = 5;
        for (Sanitaire sanitaire : ficheAba.getFecondation().getSanitaireList()) {
            PoiHelper.writeCell(sheet, rowNumber, column, sanitaire.getNom());
            column++;
        }
        rowNumber++;

        //Tableau header
        PoiHelper.writeCell(sheet, rowNumber, 0, "Taureau").setCellStyle(headerStyle);
        PoiHelper.writeCell(sheet, rowNumber, 1, "Race").setCellStyle(headerStyle);
        PoiHelper.writeCell(sheet, rowNumber, 2, "N° éjaculat").setCellStyle(headerStyle);
        PoiHelper.writeCell(sheet, rowNumber, 3, "Etat frais avant FIV").setCellStyle(headerStyle);
        PoiHelper.writeCell(sheet, rowNumber, 4, "Vol. FIV (µl)").setCellStyle(headerStyle);
        PoiHelper.writeCell(sheet, rowNumber, 5, "n° N").setCellStyle(headerStyle);
        rowNumber++;

        //Tableau body
        for (TableauSemence semence : ficheAba.getFecondation().getTableau_semences()) {
            if (semence.getTaureau() != null) {
                PoiHelper.writeCell(sheet, rowNumber, 0, semence.getTaureau().getNom()).setCellStyle(bodyStyle);
                PoiHelper.writeCell(sheet, rowNumber, 1, semence.getTaureau().getRace() + "").setCellStyle(bodyStyle);
                PoiHelper.writeCell(sheet, rowNumber, 5, semence.getTaureau().getNum_identification()).setCellStyle(bodyStyle);
            }
            PoiHelper.writeCell(sheet, rowNumber, 2, semence.getNumeroEjaculation()).setCellStyle(bodyStyle);
            PoiHelper.writeCell(sheet, rowNumber, 3, semence.getEtatFrais() + "%").setCellStyle(bodyStyle);
            PoiHelper.writeCell(sheet, rowNumber, 4, semence.getVolume() + "").setCellStyle(bodyStyle);
            rowNumber++;
        }
        PoiHelper.writeCell(sheet, rowNumber, 0, "Remarques:");
        PoiHelper.mergeRowAndColumn(sheet, rowNumber, rowNumber + 3, 1, 7);
        rowNumber += 3;

        //CULTURE IN VITRO
        PoiHelper.writeCell(sheet, rowNumber, 0, "CULTURE IN VITRO").setCellStyle(titleStyle);
        rowNumber++;

        PoiHelper.writeCell(sheet, rowNumber, 0, "Date:");
        if (ficheAba.getCulture() != null) {
            PoiHelper.writeCell(sheet, rowNumber, 1, ficheAba.getCulture().getDate().toString());
        }

        PoiHelper.writeCell(sheet, rowNumber, 4, "Sanitaires:");
        column = 5;
        for (Sanitaire sanitaire : ficheAba.getCulture().getSanitaireList()) {
            PoiHelper.writeCell(sheet, rowNumber, column, sanitaire.getNom());
            column++;
        }
        rowNumber += 2;

        //Tableau header
        PoiHelper.writeCell(sheet, rowNumber, 0, "Groupe").setCellStyle(headerStyle);
        PoiHelper.writeCell(sheet, rowNumber, 1, "Nb d'ovo inséminés").setCellStyle(headerStyle);
        PoiHelper.writeCell(sheet, rowNumber, 2, "Heure de mise en culture").setCellStyle(headerStyle);
        PoiHelper.writeCell(sheet, rowNumber, 3, "Nb segmentés").setCellStyle(headerStyle);
        PoiHelper.writeCell(sheet, rowNumber, 4, "% seg").setCellStyle(headerStyle);
        PoiHelper.writeCell(sheet, rowNumber, 5, "J5 Morula").setCellStyle(headerStyle);
        rowNumber++;

        //Tableau body
        for (TableauCulture culture : ficheAba.getCulture().getTableauCultureList()) {
            PoiHelper.writeCell(sheet, rowNumber, 0, culture.getGroupe()).setCellStyle(bodyStyle);
            PoiHelper.writeCell(sheet, rowNumber, 1, culture.getNbInsemine() + "").setCellStyle(bodyStyle);
            PoiHelper.writeCell(sheet, rowNumber, 2, culture.getHeureCulture() + "").setCellStyle(bodyStyle);
            PoiHelper.writeCell(sheet, rowNumber, 3, culture.getNbSegmente() + "").setCellStyle(bodyStyle);
            PoiHelper.writeCell(sheet, rowNumber, 4, culture.getSegment() + "%").setCellStyle(bodyStyle);
            PoiHelper.writeCell(sheet, rowNumber, 5, culture.getJ5JM() + "").setCellStyle(bodyStyle);
            rowNumber++;
        }
        rowNumber++;

        //Tableau header
        PoiHelper.writeCell(sheet, rowNumber, 0, "Groupe").setCellStyle(headerStyle);
        PoiHelper.writeCell(sheet, rowNumber, 1, "J7 mo").setCellStyle(headerStyle);
        PoiHelper.writeCell(sheet, rowNumber, 2, "J7 BL").setCellStyle(headerStyle);
        PoiHelper.writeCell(sheet, rowNumber, 3, "J7 BE").setCellStyle(headerStyle);
        PoiHelper.writeCell(sheet, rowNumber, 4, "J7 Q1").setCellStyle(headerStyle);
        PoiHelper.writeCell(sheet, rowNumber, 5, "J7 Nb total").setCellStyle(headerStyle);
        rowNumber++;

        //Tableau body
        for (TableauCulture culture : ficheAba.getCulture().getTableauCultureList()) {
            PoiHelper.writeCell(sheet, rowNumber, 0, culture.getGroupe()).setCellStyle(bodyStyle);
            PoiHelper.writeCell(sheet, rowNumber, 1, culture.getMo() + "").setCellStyle(bodyStyle);
            PoiHelper.writeCell(sheet, rowNumber, 2, culture.getBl() + "").setCellStyle(bodyStyle);
            PoiHelper.writeCell(sheet, rowNumber, 3, culture.getBe() + "").setCellStyle(bodyStyle);
            PoiHelper.writeCell(sheet, rowNumber, 4, culture.getQ1() + "").setCellStyle(bodyStyle);
            PoiHelper.writeCell(sheet, rowNumber, 5, culture.getNbTotal() + "").setCellStyle(bodyStyle);
            rowNumber++;
        }
        rowNumber++;

        //Tableau header
        PoiHelper.writeCell(sheet, rowNumber, 0, "Groupe").setCellStyle(headerStyle);
        PoiHelper.writeCell(sheet, rowNumber, 1, "%J7").setCellStyle(headerStyle);
        PoiHelper.writeCell(sheet, rowNumber, 2, "%BEJ7").setCellStyle(headerStyle);
        PoiHelper.writeCell(sheet, rowNumber, 3, "%Q1J7").setCellStyle(headerStyle);
        PoiHelper.writeCell(sheet, rowNumber, 4, "J8 Nb").setCellStyle(headerStyle);
        PoiHelper.writeCell(sheet, rowNumber, 5, "%J8").setCellStyle(headerStyle);
        PoiHelper.writeCell(sheet, rowNumber, 6, "Destination (détruits/cryo)").setCellStyle(headerStyle);
        rowNumber++;

        //Tableau body
        for (TableauCulture culture : ficheAba.getCulture().getTableauCultureList()) {
            PoiHelper.writeCell(sheet, rowNumber, 0, culture.getGroupe()).setCellStyle(bodyStyle);
            PoiHelper.writeCell(sheet, rowNumber, 1, culture.getPourJ7() + "%").setCellStyle(bodyStyle);
            PoiHelper.writeCell(sheet, rowNumber, 2, culture.getPourBEJ7() + "%").setCellStyle(bodyStyle);
            PoiHelper.writeCell(sheet, rowNumber, 3, culture.getPourQ1J7() + "%").setCellStyle(bodyStyle);
            PoiHelper.writeCell(sheet, rowNumber, 4, culture.getJ8parNb() + "").setCellStyle(bodyStyle);
            PoiHelper.writeCell(sheet, rowNumber, 5, culture.getPourJ8() + "%").setCellStyle(bodyStyle);
            PoiHelper.writeCell(sheet, rowNumber, 6, culture.getDestination()).setCellStyle(bodyStyle);
            rowNumber++;
        }
        rowNumber++;

        //Remarques
        PoiHelper.writeCell(sheet, rowNumber, 0, "Remarques:");
        PoiHelper.mergeRowAndColumn(sheet, rowNumber, rowNumber + 3, 1, 7);
        rowNumber += 3;

        //INFORMATIONS SI CRYOCONSERVATION
        PoiHelper.writeCell(sheet, rowNumber, 0, "INFORMATIONS SI CRYOCONSERVATION").setCellStyle(titleStyle);
        rowNumber++;

        //ref et heure congélation
        PoiHelper.writeCell(sheet, rowNumber, 0, "Référence congélation :");
        PoiHelper.writeCell(sheet, rowNumber, 4, "Heure de congélation :");

        if (ficheAba.getCryoconservation() != null) {
            PoiHelper.writeCell(sheet, rowNumber, 1, ficheAba.getCryoconservation().getRef());
            PoiHelper.writeCell(sheet, rowNumber, 5, ficheAba.getCryoconservation().getHeureMinute().toString());
        }
        rowNumber++;

        //Méthode de congélation
        PoiHelper.writeCell(sheet, rowNumber, 0, "Méthode de congélation :");
        if (ficheAba.getCryoconservation() != null) {
            PoiHelper.writeCell(sheet, rowNumber, 1, ficheAba.getCryoconservation().getMethodeCongelation().getNom());
        }
        rowNumber++;

        //Congélateur
        PoiHelper.writeCell(sheet, rowNumber, 0, "Congélateur utilisé : ");
        if (ficheAba.getCryoconservation() != null) {
            PoiHelper.writeCell(sheet, rowNumber, 1, ficheAba.getCryoconservation().getCongelateur().getNom());
        }
        rowNumber++;

        //Opérateur congélation
        PoiHelper.writeCell(sheet, rowNumber, 0, "Opérateur congélation : ");
        if (ficheAba.getCryoconservation() != null) {
            PoiHelper.writeCell(sheet, rowNumber, 1, ficheAba.getCryoconservation().getOperateur().getNom() + " " + ficheAba.getCryoconservation().getOperateur().getPrenom());
        }
        rowNumber++;

        //Description méthode
        PoiHelper.writeCell(sheet, rowNumber, 0, "Description méthode (nom programme, cinétique, seeding…) :");
        rowNumber++;

        if (ficheAba.getCryoconservation() != null) {
            PoiHelper.writeCell(sheet, rowNumber, 0, ficheAba.getCryoconservation().getDescMethode());
            PoiHelper.mergeRowAndColumn(sheet, rowNumber, rowNumber + 3, 0, 7);
        }
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
        for (TableauDetail detail : ficheAba.getTableauDetails()) {
            PoiHelper.writeCell(sheet, rowNumber, 0, detail.getNumeroEmbryon() + "").setCellStyle(bodyStyle);
            PoiHelper.writeCell(sheet, rowNumber, 1, detail.getStade().getNom()).setCellStyle(bodyStyle);
            PoiHelper.writeCell(sheet, rowNumber, 2, detail.getQualite().getNumero() + "").setCellStyle(bodyStyle);
            PoiHelper.writeCell(sheet, rowNumber, 3, detail.isCryoconserve() ? "X" : "").setCellStyle(bodyStyle);
            PoiHelper.writeCell(sheet, rowNumber, 4, detail.getCuve().getNom()).setCellStyle(bodyStyle);
            PoiHelper.writeCell(sheet, rowNumber, 5, detail.getCanister().getNumero() + "").setCellStyle(bodyStyle);
            PoiHelper.writeCell(sheet, rowNumber, 6, detail.getVisoTube().getCouleur()).setCellStyle(bodyStyle);
            PoiHelper.writeCell(sheet, rowNumber, 7, detail.getJonc()).setCellStyle(bodyStyle);
        }

        //Tableau header
        PoiHelper.writeCell(sheet, rowNumber, 0, "N°embryon").setCellStyle(headerStyle);
        PoiHelper.writeCell(sheet, rowNumber, 1, "Frais (cocher)").setCellStyle(headerStyle);
        PoiHelper.writeCell(sheet, rowNumber, 2, "N° receveuse").setCellStyle(headerStyle);
        PoiHelper.writeCell(sheet, rowNumber, 3, "Référence transfert").setCellStyle(headerStyle);
        PoiHelper.writeCell(sheet, rowNumber, 4, "Détruit (cocher)").setCellStyle(headerStyle);
        PoiHelper.writeCell(sheet, rowNumber, 5, "Remarques").setCellStyle(headerStyle);

        //Tableau body
        for (TableauDetail detail : ficheAba.getTableauDetails()) {
            PoiHelper.writeCell(sheet, rowNumber, 0, detail.getNumeroEmbryon() + "").setCellStyle(bodyStyle);
            PoiHelper.writeCell(sheet, rowNumber, 1, detail.isFrais() ? "X" : "").setCellStyle(bodyStyle);
            PoiHelper.writeCell(sheet, rowNumber, 2, detail.getNumeroReceveuse()).setCellStyle(bodyStyle);
            PoiHelper.writeCell(sheet, rowNumber, 3, detail.getReferenceTransfert()).setCellStyle(bodyStyle);
            PoiHelper.writeCell(sheet, rowNumber, 4, detail.isDetruit() ? "X" : "").setCellStyle(bodyStyle);
            PoiHelper.writeCell(sheet, rowNumber, 5, detail.getRemarque()).setCellStyle(bodyStyle);
        }

    }
}