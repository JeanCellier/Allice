package phenotypage.web.acteTechnique;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import phenotypage.model.cuve.cuveSemence.canisterSemence.visoTubeSemence.semence.Semence;
import phenotypage.model.cuve.cuveSemence.canisterSemence.visoTubeSemence.semence.SemenceService;
import phenotypage.model.jsonResponse.JsonResponse;
import phenotypage.model.fiche.ficheCol.FicheCol;
import phenotypage.model.fiche.ficheCol.FicheColService;
import phenotypage.model.fiche.ficheIa.FicheIa;
import phenotypage.model.fiche.ficheIa.FicheIaService;
import phenotypage.model.fiche.ficheIa.insemination.Insemination;
import phenotypage.model.operateur.Operateur;
import phenotypage.model.operateur.OperateurService;
import phenotypage.model.programme.Programme;
import phenotypage.model.programme.ProgrammeService;
import phenotypage.model.gestation.Gestation;
import phenotypage.model.gestation.tableau_gestation.Tableau_Gestation;
import phenotypage.model.pharmacie.produit.Produit;
import phenotypage.model.pharmacie.produit.ProduitService;
import phenotypage.model.traitementDonneuse.acteDonneuse.ActeDonneuse;
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
@RequestMapping("/acteTechnique/ia")
public class IaController {
    @Autowired
    private ProgrammeService programmeService;

    @Autowired
    private OperateurService operateurService;

    @Autowired
    private VacheService vacheService;

    @Autowired
    private ProduitService produitService;

    @Autowired
    private FicheIaService ficheIaService;

    @Autowired
    private SemenceService semenceService;

    @Autowired
    private TraitementActeService traitementService;

    @RequestMapping(value = "/ia", method = RequestMethod.GET)
    public String fichesIa(Model model)
    {
        model.addAttribute("programmesList", programmeService.findAll());
        model.addAttribute("operateursList", operateurService.findAll());
        model.addAttribute("traitementsList", traitementService.findAll());
        model.addAttribute("produitsList", produitService.findAll());
        model.addAttribute("fichesIaList", ficheIaService.findAll());
        return "acteTechnique/ia/ia_consult";
    }

    /******************** ADD OR UPDATE FICHE ********************/
    @ResponseBody
    @RequestMapping(value = "/addOrUpdatePart1", method = RequestMethod.POST)
    public JsonResponse addPart1(@RequestParam("nom") String nom, @RequestParam(value="programme", required = false) Programme programme,
                                 @RequestParam("numIPE") String numIPE, @RequestParam("numSemence") String numSemence,
                                 @RequestParam(value="lieu", required = false) String lieu, @RequestParam(value="date", required = false) String date,
                                 @RequestParam("vache") String numIdvache){

        JsonResponse jsonResponse = new JsonResponse();

        SimpleDateFormat formatterDateTime = new SimpleDateFormat("dd/MM/yyyy hh:mm");

        Optional<Vache> vache = vacheService.findByNum_identification(numIdvache);

        if(vache.isPresent()) {
            try {
                Date dateFiche = formatterDateTime.parse(date);

                FicheIa ficheIa = ficheIaService.createFicheIa(nom, dateFiche, lieu, programme, numIPE, numSemence, vache.get(),null, null, null);
                jsonResponse.setObjet(ficheIa);
                jsonResponse.setMessage("1ère étape enregistrée");
            } catch (ParseException e) {
                FicheIa ficheIa = ficheIaService.createFicheIa(nom, null, lieu, programme, numIPE, numSemence, vache.get(),null, null, null);
                jsonResponse.setObjet(ficheIa);
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
    public JsonResponse updatePart1(@PathVariable("id") FicheIa ficheIaToUpdate, @RequestParam("nom") String nom, @RequestParam(value="programme", required = false) Programme programme,
                                    @RequestParam("numIPE") String numIPE, @RequestParam("numSemence") String numSemence,
                                    @RequestParam(value="lieu", required = false) String lieu, @RequestParam(value="date", required = false) String date,
                                    @RequestParam("vache") String numIdvache){

        JsonResponse jsonResponse = new JsonResponse();

        SimpleDateFormat formatterDateTime = new SimpleDateFormat("dd/MM/yyyy hh:mm");

        Optional<Vache> vache = vacheService.findByNum_identification(numIdvache);

        if(vache.isPresent()) {
            try {
                Date dateFiche = formatterDateTime.parse(date);

                FicheIa ficheIa = ficheIaService.updateFicheIa(ficheIaToUpdate, nom, dateFiche, lieu, programme, numIPE,
                        numSemence, vache.get(), ficheIaToUpdate.getInsemination(), ficheIaToUpdate.getTraitement_donneuse(),
                        ficheIaToUpdate.getGestation());

                jsonResponse.setObjet(ficheIa);
            } catch (ParseException e) {
                FicheIa ficheIa = ficheIaService.updateFicheIa(ficheIaToUpdate, nom, null, lieu, programme, numIPE,
                        numSemence, vache.get(), ficheIaToUpdate.getInsemination(), ficheIaToUpdate.getTraitement_donneuse(),
                        ficheIaToUpdate.getGestation());

                jsonResponse.setObjet(ficheIa);
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
    public JsonResponse addOrUpdatePart2(@PathVariable("id") FicheIa ficheIaToUpdate,
                                         @RequestParam(value="operateur", required=false) Operateur operateur,
                                         @RequestParam(value="optradioSexee", required = false) String optradioSexee,
                                         @RequestParam(value="taureau", required=false) String taureau,
                                         @RequestParam(value="collecte", required = false) FicheCol collecte,
                                         @RequestParam(value="lieuSemence", required=false) String lieuSemence,
                                         @RequestParam(value="facilite", required=false) String faciliteProgression) {
        JsonResponse jsonResponse = new JsonResponse();
        if(collecte != null){
            Insemination insemination;

            if(ficheIaToUpdate.getInsemination() == null){
                insemination = new Insemination();
            }else {
                insemination = ficheIaToUpdate.getInsemination();
            }

            insemination.setOperateur(operateur);

            if(optradioSexee == "oui") {
                insemination.setSemenceSexee(true);
            }
            if(optradioSexee == "non") {
                insemination.setSemenceSexee(false);
            }

            Optional<Semence> semence = semenceService.findByNumTaureau(taureau);

            if(semence.isPresent()) {
                insemination.setTaureau(semence.get());
                insemination.setCollecte(collecte.getNom());
                insemination.setLieuDepot(lieuSemence);
                insemination.setProgression(faciliteProgression);

                ficheIaService.updateFicheIa(ficheIaToUpdate, ficheIaToUpdate.getNom(), ficheIaToUpdate.getDateHeureMinute(),
                        ficheIaToUpdate.getLieu(), ficheIaToUpdate.getProgramme(), ficheIaToUpdate.getNumIpe(),
                        ficheIaToUpdate.getNumDepotSemence(), ficheIaToUpdate.getVache(), insemination,
                        ficheIaToUpdate.getTraitement_donneuse(), ficheIaToUpdate.getGestation());

                jsonResponse.setMessage("2ème étape validée");
                jsonResponse.setObjet(ficheIaToUpdate);
                jsonResponse.setSucces(true);
            }else{
                jsonResponse.setMessage("Le numéro d'identification du taureau est invalide");
                jsonResponse.setSucces(false);
            }
        }else{
            jsonResponse.setSucces(false);
            jsonResponse.setMessage("Fiche collecte non valide");
        }


        return jsonResponse;
    }

    @ResponseBody
    @RequestMapping(value = "/addOrUpdatePart3/{id}", method = RequestMethod.POST)
    public JsonResponse addOrUpdatePart3(@PathVariable("id") FicheIa ficheIaToUpdate, @RequestParam(value="dateChaleur", required=false) String dateChaleur,
            @RequestParam(value="typeChaleur", required=false) String typeChaleur, @RequestParam(value="dateTraitement[]", required=false)  String[] dateTraitement,
            @RequestParam(value="produit[]", required=false)  Produit[] produit, @RequestParam(value="quantite[]", required=false)  String[] quantite,
            @RequestParam(value="modeTraitement[]", required=false)  String[] modeTraitement, @RequestParam(value="acte[]", required=false) String[] acte){

        JsonResponse jsonResponse = new JsonResponse();

        SimpleDateFormat formatterDate = new SimpleDateFormat("dd/MM/yyyy");

        List<Tableau_Donneuse> tableauTraitement = new ArrayList<>();
        List<ActeDonneuse> tableauActe = new ArrayList<>();

        for (int iLigneTraitement = 0; iLigneTraitement < dateTraitement.length; iLigneTraitement++) {
            if (quantite.length > 0 && !Objects.equals(quantite[iLigneTraitement], "")) {
                Tableau_Donneuse tableauDonneuse = new Tableau_Donneuse();

                try {
                    Date dateTraitementParsee = formatterDate.parse(dateTraitement[iLigneTraitement]);

                    tableauDonneuse.setDate(dateTraitementParsee);
                } catch (ParseException e) {
                    jsonResponse.setSucces(false);
                    jsonResponse.setMessage("Une ou plusieurs dates concernant le traitement sont invalides");
                }

                tableauDonneuse.setProduit(produit[iLigneTraitement]);
                tableauDonneuse.setQuantite(Float.parseFloat(quantite[iLigneTraitement]));
                tableauDonneuse.setMode_traitement(modeTraitement[iLigneTraitement]);

                tableauTraitement.add(tableauDonneuse);
            } else {
                ActeDonneuse acteDonneuse = new ActeDonneuse();

                try {
                    Date dateTraitementParsee = formatterDate.parse(dateTraitement[iLigneTraitement]);

                    acteDonneuse.setDate(dateTraitementParsee);
                } catch (ParseException e) {
                    jsonResponse.setSucces(false);
                    jsonResponse.setMessage("Une ou plusieurs dates concernant le traitement sont invalides");
                }

                acteDonneuse.setActe(acte[iLigneTraitement]);

                tableauActe.add(acteDonneuse);
            }
        }

        try {
            Traitement_Donneuse traitement_donneuse = new Traitement_Donneuse();
            if(!Objects.equals(dateChaleur, "")) {
                Date dateChaleurParse = formatterDate.parse(dateChaleur);
                traitement_donneuse.setDate_ref_chaleur(dateChaleurParse);
            }

            traitement_donneuse.setTableauDonneuse(tableauTraitement);
            traitement_donneuse.setTableauActe(tableauActe);
            traitement_donneuse.setTypeChaleur(typeChaleur);

            FicheIa ficheIaUpdate = ficheIaService.updateFicheIa(ficheIaToUpdate, ficheIaToUpdate.getNom(), ficheIaToUpdate.getDateHeureMinute(),
            ficheIaToUpdate.getLieu(), ficheIaToUpdate.getProgramme(), ficheIaToUpdate.getNumIpe(), ficheIaToUpdate.getNumDepotSemence(),
            ficheIaToUpdate.getVache(), ficheIaToUpdate.getInsemination(), traitement_donneuse, ficheIaToUpdate.getGestation());

            jsonResponse.setMessage("3ème étape validée");
            jsonResponse.setObjet(ficheIaUpdate);
            jsonResponse.setSucces(true);

        }catch (ParseException e) {
            jsonResponse.setSucces(false);
            jsonResponse.setMessage("Une ou plusieurs dates sont invalides");
        }

        return jsonResponse;
    }

    @ResponseBody
    @RequestMapping(value = "/addOrUpdatePart4/{id}", method = RequestMethod.POST)
    public JsonResponse addOrUpdatePart4(@PathVariable("id") FicheIa ficheIa, @RequestParam(value="dateMethode[]", required=false) String[] dateMethode,
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

        FicheIa ficheIaUpdate = ficheIaService.updateFicheIa(ficheIa, ficheIa.getNom(), ficheIa.getDateHeureMinute(),
                ficheIa.getLieu(), ficheIa.getProgramme(), ficheIa.getNumIpe(), ficheIa.getNumDepotSemence(),
                ficheIa.getVache(), ficheIa.getInsemination(), ficheIa.getTraitement_donneuse(), gestation);

        jsonResponse.setMessage("Fiche enregistrée");
        jsonResponse.setObjet(ficheIaUpdate);
        jsonResponse.setSucces(true);

        return jsonResponse;
    }

    /******************** DELETE FICHE ********************/
    @ResponseBody
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public JsonResponse delete(@PathVariable("id") FicheIa ficheIa){
        JsonResponse response = new JsonResponse();
        ficheIaService.delete(ficheIa);
        response.setSucces(true);
        response.setMessage("Fiche supprimé");
        return response;
    }

    /******************** GET ONE  ********************/
    @ResponseBody
    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
    public JsonResponse getOne(@PathVariable("id") long id){
        JsonResponse response = new JsonResponse();
        Optional<FicheIa> ficheIa = ficheIaService.findOne(id);

        if(ficheIa.isPresent()){
            response.setSucces(true);
            response.setObjet(ficheIa.get());
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
        String nom = ficheIaService.findTopByOrderByNomDesc().getNom();
        if(!Objects.equals(nom, "")){
            return nom;
        }else{
            return "";
        }
    }
}
