package phenotypage.web.acteTechnique;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import phenotypage.model.fiche.ficheCol.FicheCol;
import phenotypage.model.fiche.ficheCol.FicheColService;
import phenotypage.model.jsonResponse.JsonResponse;
import phenotypage.model.operateur.Operateur;
import phenotypage.model.operateur.OperateurService;
import phenotypage.model.pharmacie.produit.ProduitService;
import phenotypage.model.programme.Programme;
import phenotypage.model.programme.ProgrammeService;
import phenotypage.model.traitement_acte.TraitementActeService;
import phenotypage.model.vache.Vache;
import phenotypage.model.vache.VacheService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Optional;


/**
 * Created by nicolas on 18/05/17.
 */
@Controller
@RequestMapping("/acteTechnique/col")
public class ColController {
    @Autowired
    private ProgrammeService programmeService;

    @Autowired
    private OperateurService operateurService;

    @Autowired
    private ProduitService produitService;

    @Autowired
    private TraitementActeService traitementService;

    @Autowired
    FicheColService ficheColService;

    @Autowired
    VacheService vacheService;

    @RequestMapping(value = "/col", method = RequestMethod.GET)
    public String fichesCol(Model model)
    {
        model.addAttribute("programmesList", programmeService.findAll());
        model.addAttribute("operateursList", operateurService.findAll());
        model.addAttribute("traitementsList", traitementService.findAll());
        model.addAttribute("produitsList", produitService.findAvalaibleProduct());
        model.addAttribute("fichesColList", ficheColService.findAll());
        return "acteTechnique/col/col_consult";
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

                FicheCol ficheCol = ficheColService.createFicheCol(nom, programme, dateFiche, numAgrement, lieu, operateur, vache.get(),
                null, null, null,null,null,null,
                        false,false,false);
                jsonResponse.setObjet(ficheCol);
                jsonResponse.setMessage("1ère étape enregistrée");
            } catch (ParseException e) {
                FicheCol ficheCol = ficheColService.createFicheCol(nom, programme, null, numAgrement, lieu, operateur, vache.get(),
                        null, null, null,null,null,null,
                        false,false,false);
                jsonResponse.setObjet(ficheCol);
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
    public JsonResponse updatePart1(@PathVariable("id") FicheCol ficheColToUpdate, @RequestParam("nom") String nom, @RequestParam(value="programme", required = false) Programme programme,
                                    @RequestParam(value="numAgrement", required=false) String numAgrement, @RequestParam(value="lieu", required=false) String lieu, @RequestParam(value="date", required = false) String date,
                                    @RequestParam(value="operateur", required = false) Operateur operateur, @RequestParam("vache") String numIdvache){

        JsonResponse jsonResponse = new JsonResponse();

        SimpleDateFormat formatterDateTime = new SimpleDateFormat("dd/MM/yyyy hh:mm");

        Optional<Vache> vache = vacheService.findByNum_identification(numIdvache);

        if(vache.isPresent()) {
            try {
                Date dateFiche = formatterDateTime.parse(date);

                FicheCol ficheCol = ficheColService.updateFicheCol(ficheColToUpdate, nom, programme, dateFiche, numAgrement, lieu, operateur, vache.get(),
                        null, null, null,null,null,null,
                        false,false,false);
                jsonResponse.setObjet(ficheCol);
            } catch (ParseException e) {
                FicheCol ficheCol = ficheColService.updateFicheCol(ficheColToUpdate, nom, programme, null, numAgrement, lieu, operateur, vache.get(),
                        null, null, null,null,null,null,
                        false,false,false);
                jsonResponse.setObjet(ficheCol);
            }

            jsonResponse.setSucces(true);
            jsonResponse.setMessage("1ère étape validée");
        }else{
            jsonResponse.setSucces(false);
            jsonResponse.setMessage("Le numéro d'identification de ne correspond à aucune vache");
        }
        return jsonResponse;
    }


    /** Get One by numId vache **/
    @ResponseBody
    @RequestMapping(value="/get/vache/{numId}", method = RequestMethod.GET)
    public JsonResponse getByNumIdVache(@PathVariable("numId") String numIdVache){
        JsonResponse response = new JsonResponse();
        Optional<Vache> vache = vacheService.findByNum_identification(numIdVache);

        if(vache.isPresent()){
            List<FicheCol> listFiche = ficheColService.findByVache(vache.get());
            if(listFiche.size() > 0){
                response.setObjet(listFiche);
                response.setSucces(true);
            }else{
                response.setMessage("Aucune fiche de collecte trouvée pour cette vache");
                response.setSucces(false);
            }
        }else{
            response.setMessage("La vache n\'existe pas");
            response.setSucces(false);
        }

        return response;
    }

    /** AUTOCOMPLETE **/
    @ResponseBody
    @RequestMapping(value="/get/lastName", method = RequestMethod.GET)
    public String getLastId(){
        String nom = ficheColService.findTopByOrderByNomDesc().getNom();
        if(!Objects.equals(nom, "")){
            return nom;
        }else{
            return "";
        }
    }
}
