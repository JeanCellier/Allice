package phenotypage.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import phenotypage.model.jsonResponse.JsonResponse;
import phenotypage.model.pharmacie.produit.Produit;
import phenotypage.model.pharmacie.produit.ProduitService;
import phenotypage.model.traitement_acte.TraitementActe;
import phenotypage.model.traitement_acte.TraitementActeService;
import phenotypage.model.traitement_acte.tableau_traitement.Tableau_Traitement_Acte;
import phenotypage.model.traitement_acte.tableau_traitement.Tableau_Traitement_ActeService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Created by nicolas on 29/04/17.
 */
@Controller
@RequestMapping("/traitement")
public class TraitementController {

    @Autowired
    private TraitementActeService traitementActeService;

    @Autowired
    private ProduitService produitService;

    @Autowired
    private Tableau_Traitement_ActeService tableau_traitement_acteService;

    /** ACCUEIL TRAITEMENT **/
    @RequestMapping(value = "/traitement", method = RequestMethod.GET)
    public String traitement(Model model)
    {
        model.addAttribute("produitsList", produitService.findAll());
        model.addAttribute("traitementList", traitementActeService.findAll());
        return "traitement/traitement";
    }

    /** AJOUTER TRAITEMENT **/
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String add( @RequestParam("nom") String nom, @RequestParam(value="jour[]")  int[] jour,
                       @RequestParam(value="heure[]")  int[] heure,
                       @RequestParam(value="produit[]")  Produit[] produit, @RequestParam(value="quantite[]")  int[] quantite,
                       @RequestParam(value="modeTraitement[]")  String[] modeTrait){
        List<Tableau_Traitement_Acte> tableau_traitement_acte = new ArrayList<>();
        for(int iLigneTraitement = 0; iLigneTraitement < jour.length; iLigneTraitement++){
            Tableau_Traitement_Acte tableauTraitement = new Tableau_Traitement_Acte();

            tableauTraitement.setDecalageJour(jour[iLigneTraitement]);
            tableauTraitement.setDecalageHeure(heure[iLigneTraitement]);
            tableauTraitement.setProduit(produit[iLigneTraitement]);
            tableauTraitement.setQuantite(quantite[iLigneTraitement]);
            tableauTraitement.setMode_traitement(modeTrait[iLigneTraitement]);

            tableau_traitement_acte.add(tableauTraitement);
        }

        TraitementActe traitementActe = traitementActeService.createTraitement(nom, tableau_traitement_acte);

        return "redirect:/traitement/traitement";
    }

    /** MODIFIER TRAITEMENT **/
    @RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
    public String edit( @PathVariable("id") TraitementActe traitementActe, @RequestParam("nom") String nom,
                        @RequestParam(value="jour[]")  int[] jour, @RequestParam(value="heure[]")  int[] heure,
                        @RequestParam(value="produit[]")  Produit[] produit,
                        @RequestParam(value="quantite[]")  int[] quantite, @RequestParam(value="modeTraitement[]")  String[] modeTrait){

        List<Tableau_Traitement_Acte> tableau_traitement_acte = new ArrayList<>();

        for(int iLigneTraitement = 0; iLigneTraitement < jour.length; iLigneTraitement++){
            Tableau_Traitement_Acte tableauTraitement = new Tableau_Traitement_Acte();

            tableauTraitement.setDecalageJour(jour[iLigneTraitement]);
            tableauTraitement.setDecalageHeure(heure[iLigneTraitement]);
            tableauTraitement.setProduit(produit[iLigneTraitement]);
            tableauTraitement.setQuantite(quantite[iLigneTraitement]);
            tableauTraitement.setMode_traitement(modeTrait[iLigneTraitement]);

            tableau_traitement_acte.add(tableauTraitement);
        }

        TraitementActe traitementActeUpdate = traitementActeService.updateTraitement(traitementActe, nom, tableau_traitement_acte);

        return "redirect:/traitement/traitement";
    }

    /******************** DELETE FICHE ********************/
    @ResponseBody
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public JsonResponse delete(@PathVariable("id") TraitementActe traitementActe){
        JsonResponse response = new JsonResponse();
        traitementActeService.delete(traitementActe);
        response.setSucces(true);
        response.setMessage("Traitement supprimé");
        return response;
    }

    /******************** GET ONE  ********************/
    @ResponseBody
    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
    public JsonResponse getOne(@PathVariable("id") long id){
        JsonResponse response = new JsonResponse();
        Optional<TraitementActe> traitementActe = traitementActeService.findOne(id);

        if(traitementActe.isPresent()){
            response.setSucces(true);
            response.setObjet(traitementActe.get());
        }else{
            response.setSucces(false);
            response.setMessage("Une erreur s\'est produite");
        }

        return response;
    }
}
