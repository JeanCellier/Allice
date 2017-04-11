package phenotypage.web.acteTechnique;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import phenotypage.model.JsonResponse.JsonResponse;
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
    private FicheColService ficheColService;

    @RequestMapping(value = "/ia", method = RequestMethod.GET)
    public String fichesIa(Model model)
    {
        model.addAttribute("programmesList", programmeService.findAll());
        model.addAttribute("operateursList", operateurService.findAll());
        model.addAttribute("vachesList", vacheService.findAll());
        model.addAttribute("produitsList", produitService.findAll());
        model.addAttribute("fichesColList", ficheColService.findAll());
        model.addAttribute("fichesIaList", ficheIaService.findAll());
        return "acteTechnique/ia/ia_consult";
    }

    /******************** ADD OR UPDATE FICHE ********************/
    @ResponseBody
    @RequestMapping(value = "/addOrUpdate", method = RequestMethod.POST)
    public JsonResponse addOrUpdate(@RequestParam(value="id", required = false) FicheIa ficheIaForUpdate, @RequestParam("nom") String nom,
                                    @RequestParam("date") String date, @RequestParam("lieu") String lieu,
                                    @RequestParam("programme") Programme programme, @RequestParam("numIPE") String numIpe,
                                    @RequestParam("numSemence") String numSemence, @RequestParam("vache") Vache vache,
                                    @RequestParam("operateur") Operateur operateur, @RequestParam("optradioSexee") String optradioSexee,
                                    @RequestParam("taureau") Vache taureau, @RequestParam("collecte") FicheCol collecte,
                                    @RequestParam("lieuSemence") String lieuSemence, @RequestParam("facilite") String faciliteProgression,
                                    @RequestParam("typeChaleur") String typeChaleur, @RequestParam(value="dateTraitement[]")  String[] dateTraitement,
                                    @RequestParam(value="produit[]")  Produit[] produit, @RequestParam(value="quantite[]")  String[] quantite,
                                    @RequestParam(value="modeTraitement[]")  String[] modeTraitement, @RequestParam(value="dateMethode[]") String[] dateMethode,
                                    @RequestParam(value="methode[]")  String[] methode, @RequestParam(value="resultat[]")  String[] resultat,
                                    @RequestParam("remarques") String remarques){

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
                response.setMessage("Une ou plusieurs dates concernant le traitement sont invalides");
            }

            tableauDonneuse.setProduit(produit[iLigneTraitement]);
            tableauDonneuse.setQuantite(Integer.parseInt(quantite[iLigneTraitement]));
            tableauDonneuse.setMode_traitement(modeTraitement[iLigneTraitement]);

            tableauTraitement.add(tableauDonneuse);
        }


        /****** CREATION INSEMINATION ******/
        Insemination insemination = new Insemination();
        insemination.setOperateur(operateur);
        if(Objects.equals(optradioSexee, "oui")){
            insemination.setSemenceSexee(true);
        }else{
            insemination.setSemenceSexee(false);
        }
        insemination.setTaureau(taureau);
        insemination.setCollecte(collecte);
        insemination.setLieuDepot(lieuSemence);
        insemination.setProgression(faciliteProgression);

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

        /****** CREATE FICHE IA ******/
        try {
            Date dateFiche = formatterDateTime.parse(date);

            Traitement_Donneuse traitement_donneuse = new Traitement_Donneuse();
            traitement_donneuse.setTableauDonneuse(tableauTraitement);
            traitement_donneuse.setTypeChaleur(typeChaleur);

            if(ficheIaForUpdate == null) {
                FicheIa ficheIa = ficheIaService.createFicheIa(nom, dateFiche, lieu, programme, numIpe, numSemence, vache, insemination, traitement_donneuse, gestation);
                response.setMessage("Ajout effectué");
                response.setObjet(ficheIa);
            }else{
                FicheIa ficheIa = ficheIaService.updateFicheIa(ficheIaForUpdate, nom, dateFiche, lieu, programme, numIpe, numSemence, vache, insemination, traitement_donneuse, gestation);
                response.setMessage("Modification(s) effectuée(s)");
                response.setObjet(ficheIa);
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
}
