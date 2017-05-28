package phenotypage.web.cuves;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import phenotypage.model.cuve.cuveSemenceFIV.canisterSemenceFIV.CanisterSemenceFIV;
import phenotypage.model.cuve.cuveSemenceFIV.canisterSemenceFIV.CanisterSemenceFIVService;
import phenotypage.model.cuve.cuveSemenceFIV.canisterSemenceFIV.visoTubeSemenceFIV.VisoTubeSemenceFIV;
import phenotypage.model.cuve.cuveSemenceFIV.canisterSemenceFIV.visoTubeSemenceFIV.VisoTubeSemenceFIVService;
import phenotypage.model.cuve.cuveSemenceFIV.canisterSemenceFIV.visoTubeSemenceFIV.semenceFIV.SemenceFIV;
import phenotypage.model.cuve.cuveSemenceFIV.canisterSemenceFIV.visoTubeSemenceFIV.semenceFIV.SemenceFIVService;
import phenotypage.model.jsonResponse.JsonResponse;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Created by Loick on 27/05/2017.
 */
@Controller
@RequestMapping("/cuves/cuve_semences_fiv")
public class CuveSemencesFivController {

    @Autowired
    private CanisterSemenceFIVService canisterSemenceService;

    @Autowired
    private VisoTubeSemenceFIVService visoTubeSemenceService;

    @Autowired
    private SemenceFIVService semenceService;

    //TODO Corriger bug ligne modale ajout
    //TODO Corriger bug detail
    //TODO Corriger bug radio button non sauvé

    /** ACCUEIL CUVE SEMENCES ELEVAGE **/
    @RequestMapping(value = "/semences_fiv", method = RequestMethod.GET)
    public String semences_elevage(Model model)
    {
        model.addAttribute("canisterList", canisterSemenceService.findAllCanisterSemence());
        model.addAttribute("visoTubeList", visoTubeSemenceService.findAllVisoTubeSemence());

        return "cuves/cuve_semences_fiv/semences_fiv";
    }

    /** AJOUTER CANISTER **/
    @RequestMapping(value = "/semences_fiv/add", method = RequestMethod.POST)
    public String add(@RequestParam("nom") String nom, @RequestParam(value="numero")  int numero, @RequestParam("couleur[]") String[] couleur,
                      @RequestParam(value="raceTaureau[]")  String[] raceTaureau, @RequestParam(value="numTaureau[]")  String[] numTaureau, @RequestParam(value="nomTaureau[]")  String[] nomTaureau,
                      @RequestParam(value="nbpaillette[]")  int[] nbPaillettes, @RequestParam(value="couleurpaillette[]")  String[] couleurPaillette,
                      /*@RequestParam(value="sexee[]")  boolean[] sexee,*/ @RequestParam(value="remarques[]")  String[] remarques){

        List<VisoTubeSemenceFIV> visoTubeSemenceList = new ArrayList<>();

        CanisterSemenceFIV canisterSemence = new CanisterSemenceFIV();

        canisterSemence.setNom(nom);
        canisterSemence.setNumero(numero);

        for(int iLigneVisoTube = 0; iLigneVisoTube < couleur.length; iLigneVisoTube++){
            VisoTubeSemenceFIV visoTubeSemence = new VisoTubeSemenceFIV();
            SemenceFIV semence = new SemenceFIV();

            visoTubeSemence.setCouleur(couleur[iLigneVisoTube]);
            semence.setCouleurPaillette(couleurPaillette[iLigneVisoTube]);
            semence.setNbPaillettes(nbPaillettes[iLigneVisoTube]);
            semence.setNomTaureau(nomTaureau[iLigneVisoTube]);
            semence.setRemarques(remarques[iLigneVisoTube]);
            semence.setNumTaureau(numTaureau[iLigneVisoTube]);
            semence.setRaceTaureau(raceTaureau[iLigneVisoTube]);
//            semence.setSexee(sexee[iLigneVisoTube]);

            visoTubeSemence.setSemence(semence);

            visoTubeSemenceList.add(visoTubeSemence);

            semenceService.addSemence(semence);
            visoTubeSemenceService.addVisoTubeSemence(visoTubeSemence);

        }

        canisterSemence.setVisoTubeList(visoTubeSemenceList);

        canisterSemenceService.addCanisterSemence(canisterSemence);

        return "redirect:/cuves/cuve_semences_fiv/semences_fiv";
    }


    /** MODIFIER CANISTER SOMATIQUE **/
    @RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
    public String edit(@PathVariable("id") CanisterSemenceFIV canisterSemenceId, @RequestParam("nom") String nom, @RequestParam(value="numero")  int numero, @RequestParam("couleur[]") String[] couleur,
                       @RequestParam(value="raceTaureau[]")  String[] raceTaureau, @RequestParam(value="numTaureau[]")  String[] numTaureau, @RequestParam(value="nomTaureau[]")  String[] nomTaureau,
                       @RequestParam(value="nbpaillette[]")  int[] nbPaillettes, @RequestParam(value="couleurpaillette[]")  String[] couleurPaillette,
                       /*@RequestParam(value="sexee[]")  boolean[] sexee,*/ @RequestParam(value="remarques[]")  String[] remarques){

        List<VisoTubeSemenceFIV> visoTubeSemenceList = new ArrayList<>();

        CanisterSemenceFIV canisterSemence = new CanisterSemenceFIV();

        canisterSemence.setNom(nom);
        canisterSemence.setNumero(numero);

        for(int iLigneVisoTube = 0; iLigneVisoTube < couleur.length; iLigneVisoTube++){
            VisoTubeSemenceFIV visoTubeSemence = new VisoTubeSemenceFIV();
            SemenceFIV semence = new SemenceFIV();

            visoTubeSemence.setCouleur(couleur[iLigneVisoTube]);
            semence.setCouleurPaillette(couleurPaillette[iLigneVisoTube]);
            semence.setNbPaillettes(nbPaillettes[iLigneVisoTube]);
            semence.setNomTaureau(nomTaureau[iLigneVisoTube]);
            semence.setRemarques(remarques[iLigneVisoTube]);
            semence.setNumTaureau(numTaureau[iLigneVisoTube]);
            semence.setRaceTaureau(raceTaureau[iLigneVisoTube]);
//            semence.setSexee(sexee[iLigneVisoTube]);

            visoTubeSemence.setSemence(semence);

            visoTubeSemenceList.add(visoTubeSemence);

            semenceService.addSemence(semence);
            visoTubeSemenceService.addVisoTubeSemence(visoTubeSemence);

        }

        canisterSemence.setVisoTubeList(visoTubeSemenceList);

        canisterSemenceService.addCanisterSemence(canisterSemence);


        for (VisoTubeSemenceFIV visoTubeSemence : canisterSemenceId.getVisoTubeList())
        {
            semenceService.delete(visoTubeSemence.getSemence());
            visoTubeSemenceService.delete(visoTubeSemence);
        }

        canisterSemenceService.delete(canisterSemenceId);

        return "redirect:/cuves/cuve_semences_fiv/semences_fiv";

    }

    /******************** DELETE CANISTER ********************/
    @ResponseBody
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public JsonResponse delete(@PathVariable("id") CanisterSemenceFIV canisterSemence){
        JsonResponse response = new JsonResponse();

        for (VisoTubeSemenceFIV visoTubeSemence : canisterSemence.getVisoTubeList())
        {
            semenceService.delete(visoTubeSemence.getSemence());
            visoTubeSemenceService.delete(visoTubeSemence);
        }

        canisterSemenceService.delete(canisterSemence);
        response.setSucces(true);
        response.setMessage("Canister Somatique supprimé");
        return response;
    }

    /******************** DELETE VISO TUBE ********************/
    @ResponseBody
    @RequestMapping(value = "/deleteviso/{id}", method = RequestMethod.GET)
    public JsonResponse deleteviso(@PathVariable("id") VisoTubeSemenceFIV visoTubeSemence){
        JsonResponse response = new JsonResponse();


        semenceService.delete(visoTubeSemence.getSemence());
        visoTubeSemenceService.delete(visoTubeSemence);



        response.setSucces(true);
        response.setMessage("Viso Tube Somatique supprimé");
        return response;
    }

    /******************** GET ONE  ********************/
    @ResponseBody
    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
    public JsonResponse getOne(@PathVariable("id") long id){
        JsonResponse response = new JsonResponse();
        Optional<CanisterSemenceFIV> canisterSemence = canisterSemenceService.findOne(id);
        if(canisterSemence.isPresent()){
            response.setSucces(true);
            response.setObjet(canisterSemence.get());

        }else{
            response.setSucces(false);
            response.setMessage("Une erreur s\'est produite");
        }

        return response;
    }
}
