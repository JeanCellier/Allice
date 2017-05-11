package phenotypage.exportation.converters;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
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
        rowNumber++;

        //FECONDATION IN VITRO
        PoiHelper.writeCell(sheet, rowNumber, 0, "FECONDATION IN VITRO");
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
        PoiHelper.writeCell(sheet, rowNumber, 0, "Taureau");
        PoiHelper.writeCell(sheet, rowNumber, 1, "Race");
        PoiHelper.writeCell(sheet, rowNumber, 2, "N° éjaculat");
        PoiHelper.writeCell(sheet, rowNumber, 3, "Etat frais avant FIV");
        PoiHelper.writeCell(sheet, rowNumber, 4, "Vol. FIV (µl)");
        PoiHelper.writeCell(sheet, rowNumber, 5, "n° N");
        rowNumber++;

        //Tableau body
        for (TableauSemence semence : ficheAba.getFecondation().getTableau_semences()) {
            if (semence.getTaureau() != null) {
                PoiHelper.writeCell(sheet, rowNumber, 0, semence.getTaureau().getNom());
                PoiHelper.writeCell(sheet, rowNumber, 1, semence.getTaureau().getRace() + "");
                PoiHelper.writeCell(sheet, rowNumber, 5, semence.getTaureau().getNum_identification());
            }
            PoiHelper.writeCell(sheet, rowNumber, 2, semence.getNumeroEjaculation());
            PoiHelper.writeCell(sheet, rowNumber, 3, semence.getEtatFrais() + "%");
            PoiHelper.writeCell(sheet, rowNumber, 4, semence.getVolume() + "");
            rowNumber++;
        }
        PoiHelper.writeCell(sheet, rowNumber, 0, "Remarques:");
        rowNumber += 3;

        //CULTURE IN VITRO
        PoiHelper.writeCell(sheet, rowNumber, 0, "CULTURE IN VITRO");
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
        PoiHelper.writeCell(sheet, rowNumber, 0, "Groupe");
        PoiHelper.writeCell(sheet, rowNumber, 1, "Nb d'ovo inséminés");
        PoiHelper.writeCell(sheet, rowNumber, 2, "Heure de mise en culture");
        PoiHelper.writeCell(sheet, rowNumber, 3, "Nb segmentés");
        PoiHelper.writeCell(sheet, rowNumber, 4, "% seg");
        PoiHelper.writeCell(sheet, rowNumber, 5, "J5 Morula");
        rowNumber++;

        //Tableau body
        for (TableauCulture culture : ficheAba.getCulture().getTableauCultureList()) {
            PoiHelper.writeCell(sheet, rowNumber, 0, culture.getGroupe());
            PoiHelper.writeCell(sheet, rowNumber, 1, culture.getNbInsemine() + "");
            PoiHelper.writeCell(sheet, rowNumber, 2, culture.getHeureCulture() + "");
            PoiHelper.writeCell(sheet, rowNumber, 3, culture.getNbSegmente() + "");
            PoiHelper.writeCell(sheet, rowNumber, 4, culture.getSegment() + "%");
            PoiHelper.writeCell(sheet, rowNumber, 5, culture.getJ5JM() + "");
            rowNumber++;
        }
        rowNumber++;

        //Tableau header
        PoiHelper.writeCell(sheet, rowNumber, 0, "Groupe");
        PoiHelper.writeCell(sheet, rowNumber, 1, "J7 mo");
        PoiHelper.writeCell(sheet, rowNumber, 2, "J7 BL");
        PoiHelper.writeCell(sheet, rowNumber, 3, "J7 BE");
        PoiHelper.writeCell(sheet, rowNumber, 4, "J7 Q1");
        PoiHelper.writeCell(sheet, rowNumber, 5, "J7 Nb total");
        rowNumber++;

        //Tableau body
        for (TableauCulture culture : ficheAba.getCulture().getTableauCultureList()) {
            PoiHelper.writeCell(sheet, rowNumber, 0, culture.getGroupe());
            PoiHelper.writeCell(sheet, rowNumber, 1, culture.getMo() + "");
            PoiHelper.writeCell(sheet, rowNumber, 2, culture.getBl() + "");
            PoiHelper.writeCell(sheet, rowNumber, 3, culture.getBe() + "");
            PoiHelper.writeCell(sheet, rowNumber, 4, culture.getQ1() + "");
            PoiHelper.writeCell(sheet, rowNumber, 5, culture.getNbTotal() + "");
            rowNumber++;
        }
        rowNumber++;

        //Tableau header
        PoiHelper.writeCell(sheet, rowNumber, 0, "Groupe");
        PoiHelper.writeCell(sheet, rowNumber, 1, "%J7");
        PoiHelper.writeCell(sheet, rowNumber, 2, "%BEJ7");
        PoiHelper.writeCell(sheet, rowNumber, 3, "%Q1J7");
        PoiHelper.writeCell(sheet, rowNumber, 4, "J8 Nb");
        PoiHelper.writeCell(sheet, rowNumber, 5, "%J8");
        PoiHelper.writeCell(sheet, rowNumber, 6, "Destination (détruits/cryo)");
        rowNumber++;

        //Tableau body
        for (TableauCulture culture : ficheAba.getCulture().getTableauCultureList()) {
            PoiHelper.writeCell(sheet, rowNumber, 0, culture.getGroupe());
            PoiHelper.writeCell(sheet, rowNumber, 1, culture.getPourJ7() + "%");
            PoiHelper.writeCell(sheet, rowNumber, 2, culture.getPourBEJ7() + "%");
            PoiHelper.writeCell(sheet, rowNumber, 3, culture.getPourQ1J7() + "%");
            PoiHelper.writeCell(sheet, rowNumber, 4, culture.getJ8parNb() + "");
            PoiHelper.writeCell(sheet, rowNumber, 5, culture.getPourJ8() + "%");
            PoiHelper.writeCell(sheet, rowNumber, 6, culture.getDestination());
            rowNumber++;
        }
        rowNumber++;

        //Remarques
        PoiHelper.writeCell(sheet, rowNumber, 0, "Remarques:");
        rowNumber += 3;

        //INFORMATIONS SI CRYOCONSERVATION
        PoiHelper.writeCell(sheet, rowNumber, 0, "INFORMATIONS SI CRYOCONSERVATION");
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
        }
        rowNumber += 3;

        //DETAILS EMBRYONS VIABLES
        PoiHelper.writeCell(sheet, rowNumber, 0, "DETAILS EMBRYONS VIABLES");
        rowNumber++;

        //Tableau header
        PoiHelper.writeCell(sheet, rowNumber, 0, "N°embryon");
        PoiHelper.writeCell(sheet, rowNumber, 1, "Stade");
        PoiHelper.writeCell(sheet, rowNumber, 2, "Qualité\n(1 à 4)");
        PoiHelper.writeCell(sheet, rowNumber, 3, "Cryoconservé (cocher)");
        PoiHelper.writeCell(sheet, rowNumber, 4, "Cuve stockage");
        PoiHelper.writeCell(sheet, rowNumber, 5, "Canister stockage");
        PoiHelper.writeCell(sheet, rowNumber, 6, "Visotube stockage");
        PoiHelper.writeCell(sheet, rowNumber, 7, "Jonc");

        //Tableau body
        for (TableauDetail detail : ficheAba.getTableauDetails()) {
            PoiHelper.writeCell(sheet, rowNumber, 0, detail.getNumeroEmbryon() + "");
            PoiHelper.writeCell(sheet, rowNumber, 1, detail.getStade().getNom());
            PoiHelper.writeCell(sheet, rowNumber, 2, detail.getQualite().getNumero() + "");
            PoiHelper.writeCell(sheet, rowNumber, 3, detail.isCryoconserve() ? "X" : "");
            PoiHelper.writeCell(sheet, rowNumber, 4, detail.getCuve().getNom());
            PoiHelper.writeCell(sheet, rowNumber, 5, detail.getCanister().getNumero() + "");
            PoiHelper.writeCell(sheet, rowNumber, 6, detail.getVisoTube().getCouleur());
            PoiHelper.writeCell(sheet, rowNumber, 7, detail.getJonc());
        }

        //Tableau header
        PoiHelper.writeCell(sheet, rowNumber, 0, "N°embryon");
        PoiHelper.writeCell(sheet, rowNumber, 1, "Frais (cocher)");
        PoiHelper.writeCell(sheet, rowNumber, 2, "N° receveuse");
        PoiHelper.writeCell(sheet, rowNumber, 3, "Référence transfert");
        PoiHelper.writeCell(sheet, rowNumber, 4, "Détruit (cocher)");
        PoiHelper.writeCell(sheet, rowNumber, 5, "Remarques");

        //Tableau body
        for (TableauDetail detail : ficheAba.getTableauDetails()) {
            PoiHelper.writeCell(sheet, rowNumber, 0, detail.getNumeroEmbryon() + "");
            PoiHelper.writeCell(sheet, rowNumber, 1, detail.isFrais() ? "X" : "");
            PoiHelper.writeCell(sheet, rowNumber, 2, detail.getNumeroReceveuse());
            PoiHelper.writeCell(sheet, rowNumber, 3, detail.getReferenceTransfert());
            PoiHelper.writeCell(sheet, rowNumber, 4, detail.isDetruit() ? "X" : "");
            PoiHelper.writeCell(sheet, rowNumber, 5, detail.getRemarque());
        }
    }
}