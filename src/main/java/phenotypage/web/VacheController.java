package phenotypage.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import phenotypage.model.Destinataire.Destinataire;
import phenotypage.model.fiche.ficheTra.FicheTra;
import phenotypage.model.fiche.ficheTra.FicheTraService;
import phenotypage.model.fiche.ficheTra.corpsJaune.CorpsJaune;
import phenotypage.model.fiche.ficheTra.embryonsTransferes.EmbryonsTransferes;
import phenotypage.model.gestation.Gestation;
import phenotypage.model.gestation.tableau_gestation.Tableau_Gestation;
import phenotypage.model.jsonResponse.JsonResponse;
import phenotypage.model.operateur.Operateur;
import phenotypage.model.operateur.OperateurService;
import phenotypage.model.pharmacie.produit.Produit;
import phenotypage.model.pharmacie.produit.ProduitService;
import phenotypage.model.programme.Programme;
import phenotypage.model.programme.ProgrammeService;
import phenotypage.model.traitementDonneuse.Traitement_Donneuse;
import phenotypage.model.traitementDonneuse.tableau_donneuse.Tableau_Donneuse;
import phenotypage.model.traitement_acte.TraitementActeService;
import phenotypage.model.vache.Vache;
import phenotypage.model.vache.VacheService;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;


@Controller
@RequestMapping("/animaux")
public class VacheController
{
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

    /** ACCUEIL VACHE **/
    @RequestMapping(value = "/animaux", method = RequestMethod.GET)
    public String animaux(Model model)
    {
        model.addAttribute("programmesList", programmeService.findAll());
        model.addAttribute("operateursList", operateurService.findAll());
        model.addAttribute("traitementsList", traitementService.findAll());
        model.addAttribute("vacheList", vacheService.findAll());
        model.addAttribute("produitsList", produitService.findAvalaibleProduct());
        model.addAttribute("fichesTraList", ficheTraService.findAll());        return "animaux/animaux";
    }

    /******************** ADD OR UPDATE VACHE ********************/
    @ResponseBody
    @RequestMapping(value = "/addOrUpdatePart1", method = RequestMethod.POST)
    public JsonResponse addPart1(@RequestParam("numeroIdentification") String numeroIdentification, @RequestParam(value="programme", required = false) Programme programme,
                                 @RequestParam("race") String race, @RequestParam("dateNaissance") String dateNaissance,
                                 @RequestParam(value="present", required = false) String present){

        JsonResponse jsonResponse = new JsonResponse();

        SimpleDateFormat formatterDateTime = new SimpleDateFormat("dd/MM/yyyy hh:mm");
        int intRace = Integer.parseInt(race);
        boolean boolPresent = true;

        if(present.equals("oui")){
            boolPresent = true;
        }else if(present.equals("non")){
            boolPresent = false;
        }

            try {
                Date dateN = formatterDateTime.parse(dateNaissance);

                Vache vache = vacheService.createVache(boolPresent,null,null,numeroIdentification,intRace,dateN, null,null,
                        null,null,null, null, null, null,null,null,null,'0',programme,
                        null,null);
                jsonResponse.setObjet(vache);
                jsonResponse.setMessage("1ère étape enregistrée");
            } catch (ParseException e) {
                Vache vache = vacheService.createVache(boolPresent,null,null,numeroIdentification,intRace,null, null,null,
                        null,null,null, null, null, null,null,null,null,'0',programme,
                        null,null);
                jsonResponse.setObjet(vache);
                jsonResponse.setMessage("1ère étape enregistrée - erreur dans la date");
            }

            jsonResponse.setSucces(true);

        return jsonResponse;
    }

    @ResponseBody
    @RequestMapping(value = "/addOrUpdatePart1/{id}", method = RequestMethod.POST)
    public JsonResponse updatePart1(@PathVariable("id") Vache vacheToUpdate, @RequestParam("numeroIdentification") String numeroIdentification, @RequestParam(value="programme", required = false) Programme programme,
                                    @RequestParam("race") String race, @RequestParam("dateNaissance") String dateNaissance,
                                    @RequestParam(value="present", required = false) String present){

        JsonResponse jsonResponse = new JsonResponse();

        SimpleDateFormat formatterDateTime = new SimpleDateFormat("dd/MM/yyyy hh:mm");
        int intRace = Integer.parseInt(race);
        boolean boolPresent = true;

        if(present.equals("oui")){
            boolPresent = true;
        }else if(present.equals("non")){
            boolPresent = false;
        }

        try {
            Date dateN = formatterDateTime.parse(dateNaissance);

            Vache vache = vacheService.updateVache(vacheToUpdate, boolPresent,null,null,numeroIdentification,intRace,dateN, null,null,
                    null,null,null, null, null, null,null,null,null,'0',programme,
                    null,null);
            jsonResponse.setObjet(vache);
        } catch (ParseException e) {
            Vache vache = vacheService.updateVache(vacheToUpdate, boolPresent,null,null,numeroIdentification,intRace,null, null,null,
                    null,null,null, null, null, null,null,null,null,'0',programme,
                    null,null);
            jsonResponse.setObjet(vache);
        }

            jsonResponse.setSucces(true);
            jsonResponse.setMessage("1ère étape validée");

        return jsonResponse;
    }

    @ResponseBody
    @RequestMapping(value = "/addOrUpdatePart2/{id}", method = RequestMethod.POST)
    public JsonResponse addOrUpdatePart2(@PathVariable("id") Vache vache, @RequestParam(value="num_pere", required=false) String num_pere,
                                         @RequestParam(value="num_mere", required=false) String num_mere, @RequestParam(value="provenance", required=false)  String provenance){

        JsonResponse jsonResponse = new JsonResponse();

        Vache vacheToUpdate = vacheService.updateVache(vache, vache.getPresent(),vache.getProprietaire(),provenance,vache.getNum_identification(),vache.getRace(),
                vache.getDateNaissance(), vache.getEntreeQuarantaine(),vache.getDateDerniereMiseRepro(), vache.getSortiePension(),vache.getEntreeStation(),
                vache.getSortieStation(), vache.getEMCO(), vache.getEMVI(), num_pere, num_mere,vache.getVenduA(),vache.getModeReproduction(),vache.getDG01(),vache.getProgramme(),
                vache.getRemarques(),vache.getDestinataire());

        jsonResponse.setMessage("2ème étape validée");
        jsonResponse.setObjet(vacheToUpdate);
        jsonResponse.setSucces(true);

        return jsonResponse;
    }

    @ResponseBody
    @RequestMapping(value = "/addOrUpdatePart3/{id}", method = RequestMethod.POST)
    public JsonResponse addOrUpdatePart3(@PathVariable("id") Vache vache, @RequestParam(value="entreeQuarantaine", required=false) String entreeQuarantaine,
                                         @RequestParam(value="entreeStation", required=false) String entreeStation,
                                         @RequestParam(value="derniereMiseRepro", required=false) String derniereMiseRepro,
                                         @RequestParam(value="modeReproduction", required=false) String modeReproduction, @RequestParam(value="dg", required=false)String dg){

        JsonResponse jsonResponse = new JsonResponse();
        SimpleDateFormat formatterDateTime = new SimpleDateFormat("dd/MM/yyyy hh:mm");

        if(dg.equals("0")){
            vache.setDG01('0');
        }else if(dg.equals("1")){
            vache.setDG01('1');
        }

        try {

            Date dateEntreeQ = formatterDateTime.parse(entreeQuarantaine);
            Date dateEntreeS = formatterDateTime.parse(entreeStation);
            Date dateDerniere = formatterDateTime.parse(derniereMiseRepro);

            Vache vacheToUpdate = vacheService.updateVache(vache, vache.getPresent(),vache.getProprietaire(),vache.getNum_elevage(),vache.getNum_identification(),vache.getRace(),
                    vache.getDateNaissance(), dateEntreeQ, dateDerniere, vache.getSortiePension(),dateEntreeS, vache.getSortieStation(), vache.getEMCO(), vache.getEMVI(),
                    vache.getNumPere(), vache.getNumMere(),vache.getVenduA(),modeReproduction, vache.getDG01(),vache.getProgramme(), vache.getRemarques(),vache.getDestinataire());

            jsonResponse.setMessage("3ème étape validée");
            jsonResponse.setObjet(vacheToUpdate);
            jsonResponse.setSucces(true);

        }catch (ParseException e) {
            jsonResponse.setSucces(false);
            jsonResponse.setMessage("Une ou plusieurs dates sont invalides");
        }

        return jsonResponse;
    }

    @ResponseBody
    @RequestMapping(value = "/addOrUpdatePart4/{id}", method = RequestMethod.POST)
    public JsonResponse addOrUpdatePart4(@PathVariable("id") Vache vache, @RequestParam("sortieStation") String sortieStation,
                                         @RequestParam(value="destinaton",required=false) String destination,
                                         @RequestParam(value="destinataire", required=false) Destinataire destinataire,
                                         @RequestParam(value="sortiePension", required=false) String sortiePension,
                                         @RequestParam(value="venduA", required=false) String venduA){

        JsonResponse jsonResponse = new JsonResponse();
        SimpleDateFormat formatterDateTime = new SimpleDateFormat("dd/MM/yyyy hh:mm");

        try {

            Date dateSortieS = formatterDateTime.parse(sortieStation);
            Date dateSortieP = formatterDateTime.parse(sortiePension);
            if(destinataire != null){
                destinataire.setTypeDestination(destination);
            }
            Vache vacheToUpdate = vacheService.updateVache(vache, vache.getPresent(),vache.getProprietaire(),vache.getNum_elevage(),vache.getNum_identification(),vache.getRace(),
                    vache.getDateNaissance(), vache.getEntreeQuarantaine(), vache.getDateDerniereMiseRepro(), dateSortieP,vache.getEntreeStation(), dateSortieS, vache.getEMCO(), vache.getEMVI(),
                    vache.getNumPere(), vache.getNumMere(),venduA,vache.getModeReproduction(), vache.getDG01(),vache.getProgramme(), vache.getRemarques(), vache.getDestinataire());

            jsonResponse.setMessage("4ème étape validée");
            jsonResponse.setObjet(vacheToUpdate);
            jsonResponse.setSucces(true);

        }catch (ParseException e) {
            jsonResponse.setSucces(false);
            jsonResponse.setMessage("Une ou plusieurs dates sont invalides");
        }

        return jsonResponse;
    }

    @ResponseBody
    @RequestMapping(value = "/addOrUpdatePart5/{id}", method = RequestMethod.POST)
    public JsonResponse addOrUpdatePart5(@PathVariable("id") Vache vache, @RequestParam(value="remarques", required=false) String remarques,
                                         @RequestParam(value="EMCO", required=false)  String EMCO,
                                         @RequestParam(value="EMVI", required=false)  String EMVI){

        JsonResponse jsonResponse = new JsonResponse();

        /*Float emco = Float.parseFloat(EMCO);
        Float emvi = Float.parseFloat(EMVI);*/

        Vache vacheToUpdate = vacheService.updateVache(vache, vache.getPresent(),vache.getProprietaire(),vache.getNum_elevage(),vache.getNum_identification(),vache.getRace(),
                vache.getDateNaissance(), vache.getEntreeQuarantaine(), vache.getDateDerniereMiseRepro(), vache.getSortiePension(),vache.getEntreeStation(),
                vache.getSortieStation(), EMCO, EMVI, vache.getNumPere(), vache.getNumMere(),vache.getVenduA(),vache.getModeReproduction(),
                vache.getDG01(),vache.getProgramme(), remarques, vache.getDestinataire());

        jsonResponse.setMessage("Vache enregistrée");
        jsonResponse.setObjet(vacheToUpdate);
        jsonResponse.setSucces(true);

        return jsonResponse;
    }

    /******************** DELETE VACHE ********************/
    @ResponseBody
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public JsonResponse delete(@PathVariable("id") Vache vache){
        JsonResponse response = new JsonResponse();
        vacheService.delete(vache);
        response.setSucces(true);
        response.setMessage("Vache supprimée");
        return response;
    }

    /******************** GET ONE  ********************/
    @ResponseBody
    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
    public JsonResponse getOne(@PathVariable("id") long id){
        JsonResponse response = new JsonResponse();
        Optional<Vache> vache = vacheService.findOne(id);

        if(vache.isPresent()){
            response.setSucces(true);
            response.setObjet(vache.get());
        }else{
            response.setSucces(false);
            response.setMessage("Une erreur s\'est produite");
        }

        return response;
    }


    /** AUTOCOMPLETE **/
//    @ResponseBody
//    @RequestMapping(value="/get/lastName", method = RequestMethod.GET)
//    public String getLastId(){
//        String nom = ficheTraService.findTopByOrderByNomDesc().getNom();
//        if(nom != ""){
//            return nom;
//        }else{
//            return "";
//        }
//    }
}
