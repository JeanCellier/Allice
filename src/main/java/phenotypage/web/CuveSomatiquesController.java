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
import phenotypage.model.cuve.cuveSomatique.canisterSomatique.visoTubeSomatique.VisoTubeSomatiqueService;
import phenotypage.model.cuve.cuveSomatique.canisterSomatique.visoTubeSomatique.celluleSomatique.CelluleSomatique;
import phenotypage.model.cuve.cuveSomatique.canisterSomatique.visoTubeSomatique.celluleSomatique.CelluleSomatiqueService;
import phenotypage.model.jsonResponse.JsonResponse;
import phenotypage.model.pharmacie.produit.Produit;
import phenotypage.model.traitement_acte.TraitementActe;
import phenotypage.model.traitement_acte.tableau_traitement.Tableau_Traitement_Acte;

import java.util.ArrayList;
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
        model.addAttribute("canisterList", cuveSomatiqueService.findAllCuveSomatique().get(0).getCanisterList());
        //TODO gérer avec l'id
        model.addAttribute("visoTubeList", visoTubeSomatiqueService.findAllVisoTubeSomatique());
        //TODO gérer avec l'id
        model.addAttribute("cellulesSomatiqueList", celluleSomatiqueService.findAllCelluleSomatique());
//        model.addAttribute("cellulesSomatique", celluleSomatiqueService.findAllCelluleSomatique());
        return "cuves/cellulesSomatiques";
    }

    /** AJOUTER CANISTER **/
    @RequestMapping(value = "/cellulesSomatiques/add", method = RequestMethod.POST)
    public String add(@RequestParam("nom") String nom, @RequestParam(value="numero")  int numero){
        List<CanisterSomatique> canisterSomatiqueList = new ArrayList<>();

        CanisterSomatique canisterSomatique = new CanisterSomatique();

        canisterSomatique.setNom(nom);
        canisterSomatique.setNumero(numero);
        canisterSomatique.setCuveSomatique(cuveSomatiqueService.findAllCuveSomatique().get(0));

        canisterSomatiqueService.addCanisterSomatique(canisterSomatique);
        cuveSomatiqueService.findAllCuveSomatique().get(0).getCanisterList().add(canisterSomatique);
        return "redirect:/cuves/cellulesSomatiques";
    }

//    /** MODIFIER TRAITEMENT **/
//    @RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
//    public String edit( @PathVariable("id") TraitementActe traitementActe, @RequestParam("nom") String nom,
//                        @RequestParam(value="jour[]")  int[] jour, @RequestParam(value="heure[]")  String[] heure,
//                        @RequestParam(value="produit[]")  Produit[] produit,
//                        @RequestParam(value="quantite[]")  int[] quantite, @RequestParam(value="modeTraitement[]")  String[] modeTrait){
//
//        List<Tableau_Traitement_Acte> tableau_traitement_acte = new ArrayList<>();
//
//        for(int iLigneTraitement = 0; iLigneTraitement < jour.length; iLigneTraitement++){
//            Tableau_Traitement_Acte tableauTraitement = new Tableau_Traitement_Acte();
//
//            tableauTraitement.setDecalageJour(jour[iLigneTraitement]);
//            tableauTraitement.setDecalageHeure(Float.parseFloat(heure[iLigneTraitement]));
//            tableauTraitement.setProduit(produit[iLigneTraitement]);
//            tableauTraitement.setQuantite(quantite[iLigneTraitement]);
//            tableauTraitement.setMode_traitement(modeTrait[iLigneTraitement]);
//
//            tableau_traitement_acte.add(tableauTraitement);
//        }
//
//        TraitementActe traitementActeUpdate = traitementActeService.updateTraitement(traitementActe, nom, tableau_traitement_acte);
//
//        return "redirect:/traitement/traitement";
//    }

    /******************** DELETE FICHE ********************/
    @ResponseBody
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public JsonResponse delete(@PathVariable("id") CelluleSomatique celluleSomatique){
        JsonResponse response = new JsonResponse();
        celluleSomatiqueService.delete(celluleSomatique);
        response.setSucces(true);
        response.setMessage("Cellule Somatique supprimé");
        return response;
    }

    /******************** GET ONE  ********************/
    @ResponseBody
    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
    public JsonResponse getOne(@PathVariable("id") long id){
        JsonResponse response = new JsonResponse();
        //TODO Vérifier type cf appel
        Optional<CelluleSomatique> celluleSomatique = canisterSomatiqueService.findOne(id);

        if(celluleSomatique.isPresent()){
            response.setSucces(true);
            response.setObjet(celluleSomatique.get());
        }else{
            response.setSucces(false);
            response.setMessage("Une erreur s\'est produite");
        }

        return response;
    }

}
