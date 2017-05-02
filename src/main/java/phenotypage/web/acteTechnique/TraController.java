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
import phenotypage.model.traitement_acte.TraitementActeService;
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

    @Autowired
    private TraitementActeService traitementService;

    @RequestMapping(value = "/tra", method = RequestMethod.GET)
    public String fichesTra(Model model)
    {
        model.addAttribute("programmesList", programmeService.findAll());
        model.addAttribute("operateursList", operateurService.findAll());
        model.addAttribute("traitementsList", traitementService.findAll());
        model.addAttribute("vachesList", vacheService.findAll());
        model.addAttribute("produitsList", produitService.findAll());
        model.addAttribute("fichesTraList", ficheTraService.findAll());
        return "acteTechnique/tra/tra_consult";
    }

    /******************** ADD OR UPDATE FICHE ********************/
    @ResponseBody
    @RequestMapping(value = "/addOrUpdatePart1", method = RequestMethod.POST)
    public JsonResponse addPart1(@RequestParam("nom") String nom, @RequestParam(value="programme", required = false) Programme programme,
                                 @RequestParam("numAgrement") String numAgrement, @RequestParam(value="lieu", required = false) String lieu,
                                 @RequestParam(value="date", required = false) String date,
                                 @RequestParam(value="operateur", required = false) Operateur operateur, @RequestParam("vache") String numIdvache){

        JsonResponse jsonResponse = new JsonResponse();

        SimpleDateFormat formatterDateTime = new SimpleDateFormat("dd/MM/yyyy hh:mm");

        Optional<Vache> vache = vacheService.findByNum_identification(numIdvache);

        if(vache.isPresent()) {
            try {
                Date dateFiche = formatterDateTime.parse(date);

                FicheTra ficheTra = ficheTraService.createFicheTra(nom, programme, dateFiche, numAgrement, lieu, operateur, vache.get(), null, null, null, null);
                jsonResponse.setObjet(ficheTra);
                jsonResponse.setMessage("1ère étape enregistrée");
            } catch (ParseException e) {
                FicheTra ficheTra = ficheTraService.createFicheTra(nom, programme, null, numAgrement, lieu, operateur, vache.get(), null, null, null, null);
                jsonResponse.setObjet(ficheTra);
                jsonResponse.setMessage("1ère étape enregistrée - erreur dans la date");
            }

            jsonResponse.setSucces(true);

        }else{
            jsonResponse.setSucces(false);
            jsonResponse.setMessage("Le numéro d'identification de ne correspond à aucune vache");
        }
        return jsonResponse;
    }

    @ResponseBody
    @RequestMapping(value = "/addOrUpdatePart1/{id}", method = RequestMethod.POST)
    public JsonResponse updatePart1(@PathVariable("id") FicheTra ficheTraToUpdate, @RequestParam("nom") String nom, @RequestParam(value="programme", required = false) Programme programme,
                                         @RequestParam(value="numAgrement", required=false) String numAgrement, @RequestParam(value="lieu", required=false) String lieu, @RequestParam(value="date", required = false) String date,
                                         @RequestParam(value="operateur", required = false) Operateur operateur, @RequestParam("vache") String numIdvache){

        JsonResponse jsonResponse = new JsonResponse();

        SimpleDateFormat formatterDateTime = new SimpleDateFormat("dd/MM/yyyy hh:mm");

        Optional<Vache> vache = vacheService.findByNum_identification(numIdvache);

        if(vache.isPresent()) {
            try {
                Date dateFiche = formatterDateTime.parse(date);

                FicheTra ficheTra = ficheTraService.updateFicheTra(ficheTraToUpdate, nom, programme,
                        dateFiche, numAgrement, lieu, operateur, vache.get(), ficheTraToUpdate.getTraitement_donneuse(),
                        ficheTraToUpdate.getCorpsJaune(), ficheTraToUpdate.getEmbryonsTransferes(),
                        ficheTraToUpdate.getGestation());
                jsonResponse.setObjet(ficheTra);
            } catch (ParseException e) {
                FicheTra ficheTra = ficheTraService.updateFicheTra(ficheTraToUpdate, nom, programme,
                        null, numAgrement, lieu, operateur, vache.get(), ficheTraToUpdate.getTraitement_donneuse(),
                        ficheTraToUpdate.getCorpsJaune(), ficheTraToUpdate.getEmbryonsTransferes(),
                        ficheTraToUpdate.getGestation());
                jsonResponse.setObjet(ficheTra);
            }

            jsonResponse.setSucces(true);
            jsonResponse.setMessage("1ère étape validée");
        }else{
            jsonResponse.setSucces(false);
            jsonResponse.setMessage("Le numéro d'identification de ne correspond à aucune vache");
        }
        return jsonResponse;
    }

    @ResponseBody
    @RequestMapping(value = "/addOrUpdatePart2/{id}", method = RequestMethod.POST)
    public JsonResponse addOrUpdatePart2(@PathVariable("id") FicheTra ficheTra, @RequestParam(value="dateChaleur", required=false) String dateChaleur,
                                         @RequestParam(value="typeChaleur", required=false) String typeChaleur, @RequestParam(value="dateTraitement[]", required=false)  String[] dateTraitement,
                                         @RequestParam(value="produit[]", required=false)  Produit[] produit, @RequestParam(value="quantite[]", required=false)  String[] quantite,
                                         @RequestParam(value="modeTraitement[]", required=false)  String[] modeTraitement){

        JsonResponse jsonResponse = new JsonResponse();

        SimpleDateFormat formatterDate = new SimpleDateFormat("dd/MM/yyyy");

        List<Tableau_Donneuse> tableauTraitement = new ArrayList<>();

        if(produit != null) {
            for (int iLigneTraitement = 0; iLigneTraitement < produit.length; iLigneTraitement++) {
                Tableau_Donneuse tableauDonneuse = new Tableau_Donneuse();

                try {
                    Date dateTraitementParsee = formatterDate.parse(dateTraitement[iLigneTraitement]);

                    tableauDonneuse.setDate(dateTraitementParsee);
                } catch (ParseException e) {
                    jsonResponse.setSucces(false);
                    jsonResponse.setMessage("Une ou plusieurs dates concernant le traitement_acte sont invalides");
                }

                tableauDonneuse.setProduit(produit[iLigneTraitement]);
                if (quantite[iLigneTraitement] != null) {
                    tableauDonneuse.setQuantite(Integer.parseInt(quantite[iLigneTraitement]));
                } else {
                    tableauDonneuse.setQuantite(0);
                }

                tableauDonneuse.setMode_traitement(modeTraitement[iLigneTraitement]);

                tableauTraitement.add(tableauDonneuse);
            }
        }

        try {
            Traitement_Donneuse traitement_donneuse = new Traitement_Donneuse();
            if(!Objects.equals(dateChaleur, "")) {
                Date dateChaleurParse = formatterDate.parse(dateChaleur);
                traitement_donneuse.setDate_ref_chaleur(dateChaleurParse);
            }

            traitement_donneuse.setTableauDonneuse(tableauTraitement);
            traitement_donneuse.setTypeChaleur(typeChaleur);

            FicheTra ficheTraUpdate = ficheTraService.updateFicheTra(ficheTra, ficheTra.getNom(), ficheTra.getProgramme(),
                    ficheTra.getDateHeureMinute(), ficheTra.getNumeroAgrement(), ficheTra.getLieu(), ficheTra.getOperateur(),
                    ficheTra.getVache(), traitement_donneuse, ficheTra.getCorpsJaune(), ficheTra.getEmbryonsTransferes(),
                    ficheTra.getGestation());

            jsonResponse.setMessage("2ème étape validée");
            jsonResponse.setObjet(ficheTraUpdate);
            jsonResponse.setSucces(true);

        }catch (ParseException e) {
            jsonResponse.setSucces(false);
            jsonResponse.setMessage("Une ou plusieurs dates sont invalides");
        }

        return jsonResponse;
    }

    @ResponseBody
    @RequestMapping(value = "/addOrUpdatePart3/{id}", method = RequestMethod.POST)
    public JsonResponse addOrUpdatePart3(@PathVariable("id") FicheTra ficheTra, @RequestParam(value="methodeEvaluation", required=false) String methodeEvaluation,
                                         @RequestParam(value="optradioEcho", required=false) String optradioEcho,
                                         @RequestParam(value="optradioCote", required=false) String optradioCote, @RequestParam(value="qualite", required=false) String qualite){

        JsonResponse jsonResponse = new JsonResponse();

        CorpsJaune corpsJaune = new CorpsJaune();
        corpsJaune.setMode_evaluation(methodeEvaluation);
        if(Objects.equals(optradioEcho, "oui")){
            corpsJaune.setImageEcho(true);
        }
        if(Objects.equals(optradioEcho, "non")){
            corpsJaune.setImageEcho(false);
        }

        if(Objects.equals(optradioCote, "droit")){
            corpsJaune.setCoteCorpsJaune('D');
        }
        if(Objects.equals(optradioCote, "gauche")){
            corpsJaune.setCoteCorpsJaune('G');
        }

        if(!Objects.equals(qualite, null)) {
            corpsJaune.setQualite(Integer.parseInt(qualite));
        }else{
            corpsJaune.setQualite(0);
        }

        FicheTra ficheTraUpdate = ficheTraService.updateFicheTra(ficheTra, ficheTra.getNom(), ficheTra.getProgramme(),
                ficheTra.getDateHeureMinute(), ficheTra.getNumeroAgrement(), ficheTra.getLieu(), ficheTra.getOperateur(),
                ficheTra.getVache(), ficheTra.getTraitement_donneuse(), corpsJaune, ficheTra.getEmbryonsTransferes(),
                ficheTra.getGestation());

        jsonResponse.setMessage("3ème étape validée");
        jsonResponse.setObjet(ficheTraUpdate);
        jsonResponse.setSucces(true);

        return jsonResponse;
    }

    @ResponseBody
    @RequestMapping(value = "/addOrUpdatePart4/{id}", method = RequestMethod.POST)
    public JsonResponse addOrUpdatePart4(@PathVariable("id") FicheTra ficheTra, @RequestParam("numEmbryon") String numEmbryon,
                                         @RequestParam(value="optradioCoteTransf",required=false) String optradioCoteTransf,
                                         @RequestParam(value="emplacementCorne", required=false) String emplacementCorne,
                                         @RequestParam(value="faciliteProgression", required=false) String faciliteProgression){

        JsonResponse jsonResponse = new JsonResponse();

        EmbryonsTransferes embryonsTransferes = new EmbryonsTransferes();
        embryonsTransferes.setRefEmbryons(numEmbryon);

        if(Objects.equals(optradioCoteTransf, "droit")){
            embryonsTransferes.setCote('D');
        }
        if(Objects.equals(optradioCoteTransf, "gauche")){
            embryonsTransferes.setCote('G');
        }

        embryonsTransferes.setEmplacementColUterine(emplacementCorne);

        if(faciliteProgression != null){
            embryonsTransferes.setFaciliteprogression(Integer.parseInt(faciliteProgression));
        }else{
            embryonsTransferes.setFaciliteprogression(0);
        }

        FicheTra ficheTraUpdate = ficheTraService.updateFicheTra(ficheTra, ficheTra.getNom(), ficheTra.getProgramme(),
                ficheTra.getDateHeureMinute(), ficheTra.getNumeroAgrement(), ficheTra.getLieu(), ficheTra.getOperateur(),
                ficheTra.getVache(), ficheTra.getTraitement_donneuse(), ficheTra.getCorpsJaune(), embryonsTransferes,
                ficheTra.getGestation());

        jsonResponse.setMessage("4ème étape validée");
        jsonResponse.setObjet(ficheTraUpdate);
        jsonResponse.setSucces(true);

        return jsonResponse;
    }

    @ResponseBody
    @RequestMapping(value = "/addOrUpdatePart5/{id}", method = RequestMethod.POST)
    public JsonResponse addOrUpdatePart5(@PathVariable("id") FicheTra ficheTra, @RequestParam(value="dateMethode[]", required=false) String[] dateMethode,
                                         @RequestParam(value="methode[]", required=false)  String[] methode,
                                         @RequestParam(value="resultat[]", required=false)  String[] resultat,
                                         @RequestParam(value="remarques", required=false) String remarques){

        JsonResponse jsonResponse = new JsonResponse();

        SimpleDateFormat formatterDate = new SimpleDateFormat("dd/MM/yyyy");

        Gestation gestation = new Gestation();

        List<Tableau_Gestation> tableauGestationList = new ArrayList<>();

        for(int iLigneGestation = 0; iLigneGestation < dateMethode.length; iLigneGestation++){
            Tableau_Gestation tableau_Gestation = new Tableau_Gestation();
            try {
                Date dateGestationParsee = formatterDate.parse(dateMethode[iLigneGestation]);

                tableau_Gestation.setDate(dateGestationParsee);
            }catch (ParseException e) {
                jsonResponse.setSucces(false);
                jsonResponse.setMessage("Une ou plusieurs dates concernant la gestation sont invalides");
            }

            tableau_Gestation.setMethode(methode[iLigneGestation]);
            tableau_Gestation.setResultat(resultat[iLigneGestation]);

            tableauGestationList.add(tableau_Gestation);
        }
        gestation.setTableauGestationList(tableauGestationList);
        gestation.setRemarques(remarques);

        FicheTra ficheTraUpdate = ficheTraService.updateFicheTra(ficheTra, ficheTra.getNom(), ficheTra.getProgramme(),
                ficheTra.getDateHeureMinute(), ficheTra.getNumeroAgrement(), ficheTra.getLieu(), ficheTra.getOperateur(),
                ficheTra.getVache(), ficheTra.getTraitement_donneuse(), ficheTra.getCorpsJaune(), ficheTra.getEmbryonsTransferes(),
                gestation);

        jsonResponse.setMessage("Fiche enregistrée");
        jsonResponse.setObjet(ficheTraUpdate);
        jsonResponse.setSucces(true);

        return jsonResponse;
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


    /** AUTOCOMPLETE **/
    @ResponseBody
    @RequestMapping(value="/get/lastName", method = RequestMethod.GET)
    public String getLastId(){
        String nom = ficheTraService.findTopByOrderByNomDesc().getNom();
        if(nom != ""){
            return nom;
        }else{
            return "";
        }
    }
}
