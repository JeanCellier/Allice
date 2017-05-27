package phenotypage.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import phenotypage.model.cuve.Cuve;
import phenotypage.model.cuve.canister.visoTube.VisoTube;
import phenotypage.model.cuve.cuveSomatique.CuveSomatiqueService;
import phenotypage.model.cuve.cuveSomatique.canisterSomatique.CanisterSomatique;
import phenotypage.model.cuve.cuveSomatique.canisterSomatique.CanisterSomatiqueService;
import phenotypage.model.cuve.cuveSomatique.canisterSomatique.visoTubeSomatique.VisoTubeSomatique;
import phenotypage.model.cuve.cuveSomatique.canisterSomatique.visoTubeSomatique.VisoTubeSomatiqueService;
import phenotypage.model.cuve.cuveSomatique.canisterSomatique.visoTubeSomatique.celluleSomatique.CelluleSomatique;
import phenotypage.model.cuve.cuveSomatique.canisterSomatique.visoTubeSomatique.celluleSomatique.CelluleSomatiqueService;
import phenotypage.model.jsonResponse.JsonResponse;
import phenotypage.model.pharmacie.produit.Produit;
import phenotypage.model.traitement_acte.TraitementActe;
import phenotypage.model.traitement_acte.tableau_traitement.Tableau_Traitement_Acte;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;


@Controller
@RequestMapping("/cuves")
public class CuveSomatiquesController {

    @Autowired
    private CuveSomatiqueService cuveSomatiqueService;

    @Autowired
    private CanisterSomatiqueService canisterSomatiqueService;

    @Autowired
    private VisoTubeSomatiqueService visoTubeSomatiqueService;

    @Autowired
    private CelluleSomatiqueService celluleSomatiqueService;

    /** ACCUEIL CUVE SOMATIQUE **/
    @RequestMapping(value = "/cellulesSomatiques", method = RequestMethod.GET)
    public String cellules_comatiques(Model model)
    {
        model.addAttribute("canisterList", canisterSomatiqueService.findAllCanisterSomatique());
        model.addAttribute("visoTubeList", visoTubeSomatiqueService.findAllVisoTubeSomatique());

        return "cuves/cellulesSomatiques";
    }

    /** AJOUTER CANISTER **/
    @RequestMapping(value = "/cellulesSomatiques/add", method = RequestMethod.POST)
    public String add(@RequestParam("nom") String nom, @RequestParam(value="numero")  int numero, @RequestParam("couleur[]") String[] couleur,
                      @RequestParam(value="type[]")  String[] type, @RequestParam(value="couleurpaillette[]")  String[] couleurPaillette,
                      @RequestParam(value="nbpaillette[]")  int[] nbPaillettes, @RequestParam(value="date[]")  Date[] date, @RequestParam(value="remarques[]")  String[] remarques){

        List<VisoTubeSomatique> visoTubeSomatiqueList = new ArrayList<>();

        CanisterSomatique canisterSomatique = new CanisterSomatique();

        canisterSomatique.setNom(nom);
        canisterSomatique.setNumero(numero);

        for(int iLigneVisoTube = 0; iLigneVisoTube < couleur.length; iLigneVisoTube++){
            VisoTubeSomatique visoTubeSomatique = new VisoTubeSomatique();
            CelluleSomatique celluleSomatique = new CelluleSomatique();

            visoTubeSomatique.setCouleur(couleur[iLigneVisoTube]);
            celluleSomatique.setCouleurPaillette(couleurPaillette[iLigneVisoTube]);
            celluleSomatique.setNbPaillettes(nbPaillettes[iLigneVisoTube]);
            celluleSomatique.setTypeCellulaire(type[iLigneVisoTube]);
            celluleSomatique.setRemarques(remarques[iLigneVisoTube]);
            celluleSomatique.setDateCongelation(date[iLigneVisoTube]);

            visoTubeSomatique.setCelluleSomatique(celluleSomatique);

            visoTubeSomatiqueList.add(visoTubeSomatique);

            celluleSomatiqueService.addCelluleSomatique(celluleSomatique);
            visoTubeSomatiqueService.addVisoTubeSomatique(visoTubeSomatique);

        }

        canisterSomatique.setVisoTubeList(visoTubeSomatiqueList);

        canisterSomatiqueService.addCanisterSomatique(canisterSomatique);

        return "redirect:/cuves/cellulesSomatiques";
    }


    /** MODIFIER CANISTER SOMATIQUE **/
    @RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
    public String edit( @PathVariable("id") CanisterSomatique canisterSomatique, @RequestParam("nom") String nom, @RequestParam(value="numero")  int numero, @RequestParam("couleur[]") String[] couleur,
                        @RequestParam(value="type[]")  String[] type, @RequestParam(value="couleurpaillette[]")  String[] couleurPaillette,
                        @RequestParam(value="nbpaillette[]")  int[] nbPaillettes, @RequestParam(value="date[]")  Date[] date, @RequestParam(value="remarques[]")  String[] remarques){


        List<VisoTubeSomatique> visoTubeSomatiqueList = new ArrayList<>();

        CanisterSomatique newcanisterSomatique = new CanisterSomatique();

        newcanisterSomatique.setNom(nom);
        newcanisterSomatique.setNumero(numero);

        for(int iLigneVisoTube = 0; iLigneVisoTube < couleur.length; iLigneVisoTube++){
            VisoTubeSomatique newvisoTubeSomatique = new VisoTubeSomatique();
            CelluleSomatique newcelluleSomatique = new CelluleSomatique();

            newvisoTubeSomatique.setCouleur(couleur[iLigneVisoTube]);
            newcelluleSomatique.setCouleurPaillette(couleurPaillette[iLigneVisoTube]);
            newcelluleSomatique.setNbPaillettes(nbPaillettes[iLigneVisoTube]);
            newcelluleSomatique.setTypeCellulaire(type[iLigneVisoTube]);
            newcelluleSomatique.setRemarques(remarques[iLigneVisoTube]);
            newcelluleSomatique.setDateCongelation(date[iLigneVisoTube]);

            newvisoTubeSomatique.setCelluleSomatique(newcelluleSomatique);

            visoTubeSomatiqueList.add(newvisoTubeSomatique);

            celluleSomatiqueService.addCelluleSomatique(newcelluleSomatique);
            visoTubeSomatiqueService.addVisoTubeSomatique(newvisoTubeSomatique);

        }

        newcanisterSomatique.setVisoTubeList(visoTubeSomatiqueList);

        canisterSomatiqueService.addCanisterSomatique(newcanisterSomatique);

        System.err.println("hello");
        for (VisoTubeSomatique visoTubeSomatique : canisterSomatique.getVisoTubeList())
        {
            celluleSomatiqueService.delete(visoTubeSomatique.getCelluleSomatique());
            visoTubeSomatiqueService.delete(visoTubeSomatique);
        }

        canisterSomatiqueService.delete(canisterSomatique);


        return "redirect:/cuves/cellulesSomatiques";
    }

    /******************** DELETE CANISTER ********************/
    @ResponseBody
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public JsonResponse delete(@PathVariable("id") CanisterSomatique canisterSomatique){
        JsonResponse response = new JsonResponse();

        for (VisoTubeSomatique visoTubeSomatique : canisterSomatique.getVisoTubeList())
        {
            celluleSomatiqueService.delete(visoTubeSomatique.getCelluleSomatique());
            visoTubeSomatiqueService.delete(visoTubeSomatique);
        }

        canisterSomatiqueService.delete(canisterSomatique);
        response.setSucces(true);
        response.setMessage("Canister Somatique supprimé");
        return response;
    }

    /******************** DELETE VISO TUBE ********************/
    @ResponseBody
    @RequestMapping(value = "/deleteviso/{id}", method = RequestMethod.GET)
    public JsonResponse deleteviso(@PathVariable("id") VisoTubeSomatique visoTubeSomatique){
        JsonResponse response = new JsonResponse();


            celluleSomatiqueService.delete(visoTubeSomatique.getCelluleSomatique());
            visoTubeSomatiqueService.delete(visoTubeSomatique);



        response.setSucces(true);
        response.setMessage("Viso Tube Somatique supprimé");
        return response;
    }

    /******************** GET ONE  ********************/
    @ResponseBody
    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
    public JsonResponse getOne(@PathVariable("id") long id){
        JsonResponse response = new JsonResponse();
        //TODO Vérifier type cf appel
        Optional<CanisterSomatique> canisterSomatique = canisterSomatiqueService.findOne(id);
        if(canisterSomatique.isPresent()){
            response.setSucces(true);
            response.setObjet(canisterSomatique.get());

        }else{
            response.setSucces(false);
            response.setMessage("Une erreur s\'est produite");
        }

        return response;
    }

}
