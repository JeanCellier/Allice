package phenotypage.web.acteTechnique;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import phenotypage.model.jsonResponse.JsonResponse;
import phenotypage.model.fiche.ficheTra.corpsJaune.CorpsJaune;
import phenotypage.model.operateur.Operateur;
import phenotypage.model.operateur.OperateurService;
import phenotypage.model.programme.Programme;
import phenotypage.model.programme.ProgrammeService;
import phenotypage.model.fiche.ficheTra.embryonsTransferes.EmbryonsTransferes;
import phenotypage.model.fiche.ficheTra.FicheTra;
import phenotypage.model.fiche.ficheTra.FicheTraService;
import phenotypage.model.gestation.Gestation;
import phenotypage.model.gestation.tableau_gestation.Tableau_Gestation;
import phenotypage.model.pharmacie.produit.Produit;
import phenotypage.model.pharmacie.produit.ProduitService;
import phenotypage.model.traitementDonneuse.tableau_donneuse.Tableau_Donneuse;
import phenotypage.model.traitementDonneuse.Traitement_Donneuse;
import phenotypage.model.vache.Vache;
import phenotypage.model.vache.VacheService;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by nicolas on 30/03/17.
 */
@Controller
@RequestMapping("/acteTechnique/tra")
public class TraController {
    @Autowired
    private ProgrammeService programmeService;

    @Autowired
    private OperateurService operateurService;

    @Autowired
    private VacheService vacheService;

    @Autowired
    private ProduitService produitService;

    @Autowired
    private FicheTraService ficheTraService;

    @RequestMapping(value = "/tra", method = RequestMethod.GET)
    public String fichesTra(Model model)
    {
        model.addAttribute("programmesList", programmeService.findAll());
        model.addAttribute("operateursList", operateurService.findAll());
        model.addAttribute("vachesList", vacheService.findAll());
        model.addAttribute("produitsList", produitService.findAll());
        model.addAttribute("fichesTraList", ficheTraService.findAll());
        return "acteTechnique/tra/tra_consult";
    }

    /******************** ADD OR UPDATE FICHE ********************/
    @RequestMapping(value = "/addOrUpdatePart1", method = RequestMethod.POST)
    public void addOrUpdatePart1(@RequestParam("nom") String nom, @RequestParam(value="programme", required = false) Programme programme,
                                 @RequestParam("numAgrement") String numAgrement, @RequestParam("lieu") String lieu, @RequestParam(value="date", required = false) String date,
                                 @RequestParam(value="operateur", required = false) Operateur operateur, @RequestParam("vache") Vache vache){

        SimpleDateFormat formatterDateTime = new SimpleDateFormat("dd/MM/yyyy hh:mm");

        try {
            Date dateFiche = formatterDateTime.parse(date);
            ficheTraService.createFicheTra(nom, programme, dateFiche, numAgrement, lieu, operateur, vache, null, null, null, null);
        }catch (ParseException e) {
            ficheTraService.createFicheTra(nom, programme, null, numAgrement, lieu, operateur, vache, null, null, null, null);
        }
    }


    @ResponseBody
    @RequestMapping(value = "/addOrUpdate", method = RequestMethod.POST)
    public JsonResponse addOrUpdate(@RequestParam(value="id", required = false) FicheTra ficheTraForUpdate, @RequestParam("nom") String nom, @RequestParam("programme") Programme programme,
                            @RequestParam("numAgrement") String numAgrement, @RequestParam("lieu") String lieu, @RequestParam("date") String date,
                            @RequestParam("operateur") Operateur operateur, @RequestParam("vache") Vache vache,
                            @RequestParam("dateChaleur") String dateChaleur, @RequestParam("typeChaleur") String typeChaleur,
                            @RequestParam(value="dateTraitement[]")  String[] dateTraitement, @RequestParam(value="produit[]")  Produit[] produit,
                            @RequestParam(value="quantite[]")  String[] quantite, @RequestParam(value="modeTraitement[]")  String[] modeTraitement,
                            @RequestParam("methodeEvaluation") String methodeEvaluation, @RequestParam("optradioEcho") String optradioEcho,
                            @RequestParam("optradioCote") String optradioCote, @RequestParam("qualite") String qualite,
                            @RequestParam("referenceExperience") String referenceExperience, @RequestParam("optradioSexee") String optradioSexee,
                            @RequestParam("numEmbryon") String numEmbryon, @RequestParam("vacheEmbryon") Vache vacheEmbryon,
                            @RequestParam("optradioCoteTransf") String optradioCoteTransf, @RequestParam("emplacementCorne") String emplacementCorne,
                            @RequestParam("faciliteProgression") String faciliteProgression, @RequestParam(value="dateMethode[]") String[] dateMethode,
                            @RequestParam(value="methode[]")  String[] methode, @RequestParam(value="resultat[]")  String[] resultat, @RequestParam("remarques") String remarques){

        JsonResponse response = new JsonResponse();

        SimpleDateFormat formatterDateTime = new SimpleDateFormat("dd/MM/yyyy hh:mm");
        SimpleDateFormat formatterDate = new SimpleDateFormat("dd/MM/yyyy");

        /****** CREATION LIGNE TABLEAU TRAITEMENT ******/
        List<Tableau_Donneuse> tableauTraitement = new ArrayList<>();
        for(int iLigneTraitement = 0; iLigneTraitement < dateTraitement.length; iLigneTraitement++){
            Tableau_Donneuse tableauDonneuse = new Tableau_Donneuse();

            try {
                Date dateTraitementParsee = formatterDate.parse(dateTraitement[iLigneTraitement]);

                tableauDonneuse.setDate(dateTraitementParsee);
            }catch (ParseException e) {
                response.setSucces(false);
                response.setMessage("Une ou plusieurs dates concernant le traitement_acte sont invalides");
            }

            tableauDonneuse.setProduit(produit[iLigneTraitement]);
            tableauDonneuse.setQuantite(Integer.parseInt(quantite[iLigneTraitement]));
            tableauDonneuse.setMode_traitement(modeTraitement[iLigneTraitement]);

            tableauTraitement.add(tableauDonneuse);
        }

        /****** CREATION CORPS JAUNE ******/
        CorpsJaune corpsJaune = new CorpsJaune();
        corpsJaune.setMode_evaluation(methodeEvaluation);
        if(Objects.equals(optradioEcho, "oui")){
            corpsJaune.setImageEcho(true);
        }else{
            corpsJaune.setImageEcho(false);
        }

        if(Objects.equals(optradioCote, "droit")){
            corpsJaune.setCoteCorpsJaune('D');
        }else{
            corpsJaune.setCoteCorpsJaune('G');
        }
        corpsJaune.setQualite(Integer.parseInt(qualite));


        /****** CREATION EMBRYONS TRANSFERES ******/
        EmbryonsTransferes embryonsTransferes = new EmbryonsTransferes();
//        embryonsTransferes.setRefExperience(referenceExperience);
//        if(Objects.equals(optradioSexee, "oui")){
//            embryonsTransferes.setSemenceSexee(true);
//        }else{
//            embryonsTransferes.setSemenceSexee(false);
//        }
//        embryonsTransferes.setRefEmbryons(numEmbryon);
//        embryonsTransferes.setTaureau(vacheEmbryon);
        if(Objects.equals(optradioCoteTransf, "droit")){
            embryonsTransferes.setCote('D');
        }else{
            embryonsTransferes.setCote('G');
        }
        embryonsTransferes.setEmplacementColUterine(emplacementCorne);
//        embryonsTransferes.setFaciliteprogression(faciliteProgression);


        /****** CREATION GESTATION ******/
        Gestation gestation = new Gestation();

        List<Tableau_Gestation> tableauGestationList = new ArrayList<>();
        for(int iLigneGestation = 0; iLigneGestation < dateMethode.length; iLigneGestation++){
            Tableau_Gestation tableau_Gestation = new Tableau_Gestation();

            try {
                Date dateGestationParsee = formatterDate.parse(dateMethode[iLigneGestation]);

                tableau_Gestation.setDate(dateGestationParsee);
            }catch (ParseException e) {
                response.setSucces(false);
                response.setMessage("Une ou plusieurs dates concernant la gestation sont invalides");
            }

            tableau_Gestation.setMethode(methode[iLigneGestation]);
            tableau_Gestation.setResultat(resultat[iLigneGestation]);

            tableauGestationList.add(tableau_Gestation);
        }
        gestation.setTableauGestationList(tableauGestationList);
        gestation.setRemarques(remarques);

        /****** CREATE FICHE TRA ******/
        try {
            Date dateFiche = formatterDateTime.parse(date);
            Date dateChaleurParse = formatterDate.parse(dateChaleur);

            Traitement_Donneuse traitement_donneuse = new Traitement_Donneuse();
            traitement_donneuse.setTableauDonneuse(tableauTraitement);
            traitement_donneuse.setTypeChaleur(typeChaleur);
            traitement_donneuse.setDate_ref_chaleur(dateChaleurParse);

            if(ficheTraForUpdate == null) {
                FicheTra ficheTra = ficheTraService.createFicheTra(nom, programme, dateFiche, numAgrement, lieu, operateur, vache, traitement_donneuse, corpsJaune, embryonsTransferes, gestation);
                response.setMessage("Ajout effectué");
                response.setObjet(ficheTra);
            }else{
                FicheTra ficheTra = ficheTraService.updateFicheTra(ficheTraForUpdate, nom, programme, dateFiche, numAgrement, lieu, operateur, vache, traitement_donneuse, corpsJaune, embryonsTransferes, gestation);
                response.setMessage("Modification(s) effectuée(s)");
                response.setObjet(ficheTra);
            }
            response.setSucces(true);


        }catch (ParseException e) {
            response.setSucces(false);
            response.setMessage("Une ou plusieurs dates sont invalides");
        }

        return response;
    }

    /******************** DELETE FICHE ********************/
    @ResponseBody
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public JsonResponse delete(@PathVariable("id") FicheTra ficheTra){
        JsonResponse response = new JsonResponse();
        ficheTraService.delete(ficheTra);
        response.setSucces(true);
        response.setMessage("Fiche supprimé");
        return response;
    }

    /******************** GET ONE  ********************/
    @ResponseBody
    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
    public JsonResponse getOne(@PathVariable("id") long id){
        JsonResponse response = new JsonResponse();
        Optional<FicheTra> ficheTra = ficheTraService.findOne(id);

        if(ficheTra.isPresent()){
            response.setSucces(true);
            response.setObjet(ficheTra.get());
        }else{
            response.setSucces(false);
            response.setMessage("Une erreur s\'est produite");
        }

        return response;
    }
}
