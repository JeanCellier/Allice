package phenotypage.web.acteTechnique;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import phenotypage.model.cryoconservation.Cryoconservation;
import phenotypage.model.cryoconservation.embryon.Embryon;
import phenotypage.model.cryoconservation.embryon.EmbryonService;
import phenotypage.model.cuve.cuveInVivo.canisterInVivo.CanisterInVivoService;
import phenotypage.model.cuve.cuveInVivo.canisterInVivo.visoTubeInVivo.VisoTubeInVivo;
import phenotypage.model.cuve.cuveInVivo.canisterInVivo.visoTubeInVivo.VisoTubeInVivoService;
import phenotypage.model.cuve.cuveInVivo.canisterInVivo.visoTubeInVivo.embryonsInVivo.EmbryonsInVivo;
import phenotypage.model.cuve.cuveInVivo.canisterInVivo.visoTubeInVivo.embryonsInVivo.EmbryonsInVivoService;
import phenotypage.model.fiche.ficheCol.FicheCol;
import phenotypage.model.fiche.ficheCol.FicheColService;
import phenotypage.model.fiche.ficheTra.FicheTra;
import phenotypage.model.infoTraitementDonneuse.InfoTraitementDonneuse;
import phenotypage.model.invitro.collecte.resultat.Resultat;
import phenotypage.model.jsonResponse.JsonResponse;
import phenotypage.model.operateur.Operateur;
import phenotypage.model.operateur.OperateurService;
import phenotypage.model.pharmacie.produit.Produit;
import phenotypage.model.pharmacie.produit.ProduitService;
import phenotypage.model.programme.Programme;
import phenotypage.model.programme.ProgrammeService;
import phenotypage.model.traitementDonneuse.Traitement_Donneuse;
import phenotypage.model.traitementDonneuse.acteDonneuse.ActeDonneuse;
import phenotypage.model.traitementDonneuse.tableau_donneuse.Tableau_Donneuse;
import phenotypage.model.traitement_acte.TraitementActeService;
import phenotypage.model.vache.Vache;
import phenotypage.model.vache.VacheService;

import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;


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
    private FicheColService ficheColService;

    @Autowired
    private VacheService vacheService;

    @Autowired
    private CanisterInVivoService canisterInVivoService;

    @Autowired
    private EmbryonsInVivoService embryonsInVivoService;

    @Autowired
    private VisoTubeInVivoService visoTubeInVivoService;

    @RequestMapping(value = "/col", method = RequestMethod.GET)
    public String fichesCol(Model model)
    {
        model.addAttribute("programmesList", programmeService.findAll());
        model.addAttribute("operateursList", operateurService.findAll());
        model.addAttribute("traitementsList", traitementService.findAll());
        model.addAttribute("produitsList", produitService.findAvalaibleProduct());
        model.addAttribute("fichesColList", ficheColService.findAll());
        model.addAttribute("canistersList", canisterInVivoService.findAllCanisterInVivo());
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

    @ResponseBody
    @RequestMapping(value = "/addOrUpdatePart2/{id}", method = RequestMethod.POST)
    public JsonResponse addOrUpdatePart2(@PathVariable("id") FicheCol ficheCol, @RequestParam(value="dateChaleur", required=false) String dateChaleur,
                                         @RequestParam(value="typeChaleur", required=false) String typeChaleur, @RequestParam(value="dateTraitement[]", required=false)  String[] dateTraitement,
                                         @RequestParam(value="produit[]", required=false)  Produit[] produit, @RequestParam(value="quantite[]", required=false)  String[] quantite,
                                         @RequestParam(value="modeTraitement[]", required=false)  String[] modeTraitement, @RequestParam(value="acte[]", required=false) String[] acte,
                                         @RequestParam(value="nbFolDroite", required = false) String nbFolDroite, @RequestParam(value="nbFolGauche", required=false) String nbFolGauche,
                                         @RequestParam(value="nbFolliculeAspi", required = false) String nbFolAspi, @RequestParam(value="imageEcho", required = false) String imageEcho,
                                         @RequestParam(value="pourDoseFSH", required=false) String pourDoseFSH, @RequestParam(value="dateTraitementSuperOv[]", required=false)  String[] dateTraitementSuperOv,
                                         @RequestParam(value="produitSuperOv[]", required=false)  Produit[] produitSuperOv, @RequestParam(value="quantiteSuperOv[]", required=false)  String[] quantiteSuperOv,
                                         @RequestParam(value="modeTraitementSuperOv[]", required=false)  String[] modeTraitementSuperOv, @RequestParam(value="acteSuperOv[]", required=false) String[] acteSuperOv){

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


            List<Tableau_Donneuse> tableauSuperOv = new ArrayList<>();
            List<ActeDonneuse> tableauActeSuperOv = new ArrayList<>();
            SimpleDateFormat formatterDateSuperOv = new SimpleDateFormat("dd/MM/yyyy hh:mm");

            for (int iLigneTraitement = 0; iLigneTraitement < dateTraitementSuperOv.length; iLigneTraitement++) {
                if (quantiteSuperOv.length > 0 && !Objects.equals(quantiteSuperOv[iLigneTraitement], "")) {
                    Tableau_Donneuse tableauDonneuse = new Tableau_Donneuse();

                    try {
                        Date dateTraitementParsee = formatterDateSuperOv.parse(dateTraitementSuperOv[iLigneTraitement]);

                        tableauDonneuse.setDate(dateTraitementParsee);
                    } catch (ParseException e) {
                        jsonResponse.setSucces(false);
                        jsonResponse.setMessage("Une ou plusieurs dates concernant le traitement Super ovulation sont invalides");
                    }

                    tableauDonneuse.setProduit(produitSuperOv[iLigneTraitement]);
                    tableauDonneuse.setQuantite(Float.parseFloat(quantiteSuperOv[iLigneTraitement]));
                    tableauDonneuse.setMode_traitement(modeTraitementSuperOv[iLigneTraitement]);

                    tableauSuperOv.add(tableauDonneuse);
                } else {
                    ActeDonneuse acteDonneuse = new ActeDonneuse();

                    try {
                        Date dateTraitementParsee = formatterDateSuperOv.parse(dateTraitementSuperOv[iLigneTraitement]);

                        acteDonneuse.setDate(dateTraitementParsee);
                    } catch (ParseException e) {
                        jsonResponse.setSucces(false);
                        jsonResponse.setMessage("Une ou plusieurs dates concernant le traitement Super ovulation sont invalides");
                    }

                    acteDonneuse.setActe(acteSuperOv[iLigneTraitement]);

                    tableauActeSuperOv.add(acteDonneuse);
                }
            }

            Traitement_Donneuse traitementSuperOv = new Traitement_Donneuse();
            traitementSuperOv.setTableauDonneuse(tableauSuperOv);
            traitementSuperOv.setTableauActe(tableauActeSuperOv);


            InfoTraitementDonneuse infoTraitementDonneuse = new InfoTraitementDonneuse();
            if (Objects.equals(imageEcho, "oui")) {
                infoTraitementDonneuse.setImage_echo(true);
            }
            if (Objects.equals(imageEcho, "non")) {
                infoTraitementDonneuse.setImage_echo(false);
            }
            if(!Objects.equals(nbFolDroite, "")){
                infoTraitementDonneuse.setNb_droite(Integer.parseInt(nbFolDroite));
            }else{
                infoTraitementDonneuse.setNb_droite(-1);
            }
            if(!Objects.equals(nbFolGauche, "")){
                infoTraitementDonneuse.setNb_gauche(Integer.parseInt(nbFolGauche));
            }else{
                infoTraitementDonneuse.setNb_gauche(-1);
            }
            if(!Objects.equals(nbFolAspi, "")){
                infoTraitementDonneuse.setNb_follicules(Integer.parseInt(nbFolAspi));
            }else{
                infoTraitementDonneuse.setNb_follicules(-1);
            }
            if(!Objects.equals(pourDoseFSH, "")){
                infoTraitementDonneuse.setPourc_dose(Float.parseFloat(pourDoseFSH));
            }else{
                infoTraitementDonneuse.setPourc_dose(-1);
            }

            FicheCol ficheColUpdate = ficheColService.updateFicheCol(ficheCol, ficheCol.getNom(), ficheCol.getProgramme(),
                    ficheCol.getDateHeureMinute(), ficheCol.getNumeroAgrement(), ficheCol.getLieu(), ficheCol.getOperateur(),
                    ficheCol.getVache(), traitement_donneuse, ficheCol.getResultat_collecte(), ficheCol.getCryoconservation(),
                    traitementSuperOv, infoTraitementDonneuse, ficheCol.getDetailsEmbryonsViables(), ficheCol.isLC(),
                    ficheCol.isLL(), ficheCol.isED());

            jsonResponse.setMessage("2ème étape validée");
            jsonResponse.setObjet(ficheColUpdate);
            jsonResponse.setSucces(true);

        }catch (ParseException e) {
            jsonResponse.setSucces(false);
            jsonResponse.setMessage("Une ou plusieurs dates sont invalides");
        }

        return jsonResponse;
    }

    @ResponseBody
    @RequestMapping(value = "/addOrUpdatePart3/{id}", method = RequestMethod.POST)
    public JsonResponse updatePart3(@PathVariable("id") FicheCol ficheColToUpdate, @RequestParam(value = "nbEmbryonViables", required = false) String nbEmbryonViables,
                                    @RequestParam(value="nbEmbryonDegeneres", required = false) String nbDegen, @RequestParam(value="nbEmbryonNonFecondes", required = false) String nbNonFeconde,
                                    @RequestParam(value="nbEmbryonTotal", required = false) String nbTotal, @RequestParam(value="nbCorpsJauneDroite", required = false) String nbCorpsDroite,
                                    @RequestParam(value="nbCorpsJauneGauche", required = false) String nbCorpsGauche, @RequestParam(value="nbCorpsJaune", required = false) String nbCorpsTot,
                                    @RequestParam(value="tauxCollecte", required = false) String tauxCollecte, @RequestParam(value="remarques", required = false) String remarques){
        JsonResponse response = new JsonResponse();

        Resultat resultat;

        if(ficheColToUpdate.getResultat_collecte() != null) {
            resultat = ficheColToUpdate.getResultat_collecte();
        }else{
            resultat = new Resultat();
        }

        if(Objects.equals(nbEmbryonViables, "")){
            resultat.setNombre_Embryons_Viables(0);
        }else{
            resultat.setNombre_Embryons_Viables(Integer.parseInt(nbEmbryonViables));
        }

        if(Objects.equals(nbDegen, "")){
            resultat.setNombre_Embryons_Degeneres(0);
        }else{
            resultat.setNombre_Embryons_Degeneres(Integer.parseInt(nbDegen));
        }

        if(Objects.equals(nbNonFeconde, "")){
            resultat.setNombre_Embryons_NonFecondes(0);
        }else{
            resultat.setNombre_Embryons_NonFecondes(Integer.parseInt(nbNonFeconde));
        }

        if(Objects.equals(nbTotal, "")){
            resultat.setNombre_Embryons_Total(0);
        }else{
            resultat.setNombre_Embryons_Total(Integer.parseInt(nbTotal));
        }

        if(Objects.equals(nbCorpsDroite, "")){
            resultat.setNombre_CorpsJ_droite(0);
        }else{
            resultat.setNombre_CorpsJ_droite(Integer.parseInt(nbCorpsDroite));
        }

        if(Objects.equals(nbCorpsGauche, "")){
            resultat.setNombre_CorpsJ_gauche(0);
        }else{
            resultat.setNombre_CorpsJ_gauche(Integer.parseInt(nbCorpsGauche));
        }

        if(Objects.equals(nbCorpsTot, "")){
            resultat.setNombre_CorpsJ_total(0);
        }else{
            resultat.setNombre_CorpsJ_total(Integer.parseInt(nbCorpsTot));
        }

        if(Objects.equals(tauxCollecte, "")){
            resultat.setTaux_de_collecte(0);
        }else{
            resultat.setTaux_de_collecte(Float.parseFloat(tauxCollecte));
        }

        resultat.setRemarques(remarques);

        FicheCol ficheColUpdate = ficheColService.updateFicheCol(ficheColToUpdate, ficheColToUpdate.getNom(), ficheColToUpdate.getProgramme(),
                ficheColToUpdate.getDateHeureMinute(), ficheColToUpdate.getNumeroAgrement(), ficheColToUpdate.getLieu(), ficheColToUpdate.getOperateur(),
                ficheColToUpdate.getVache(), ficheColToUpdate.getTraitement_donneuse(), resultat, ficheColToUpdate.getCryoconservation(),
                ficheColToUpdate.getTableauSuperOv(), ficheColToUpdate.getInfoTraitementDonneuse(),
                ficheColToUpdate.getDetailsEmbryonsViables(), ficheColToUpdate.isLC(), ficheColToUpdate.isLL(), ficheColToUpdate.isED());

        response.setMessage("3ème étape validée");
        response.setObjet(ficheColUpdate);
        response.setSucces(true);

        return response;

    }

    @ResponseBody
    @RequestMapping(value = "/addOrUpdatePart4/{id}", method = RequestMethod.POST)
    public JsonResponse updatePart4(@PathVariable("id") FicheCol ficheColToUpdate, @RequestParam(value="stade[]", required = false) String[] stade,
                                    @RequestParam(value="qualite[]", required = false) String[] qualite, @RequestParam(value="canister[]", required = false) String[] canister,
                                    @RequestParam(value="visotube[]", required = false) String[] visotube, @RequestParam(value="jonc[]", required = false) String[] jonc,
                                    @RequestParam(value="refVache[]", required = false) String[] refVache, @RequestParam(value="refTransfert[]", required = false) String[] refTransfert,
                                    @RequestParam(value="remarques[]", required = false) String[] remarques){
        JsonResponse response = new JsonResponse();
        List<Embryon> listEmbryons = new ArrayList<>();
        if(stade != null) {
            for (int iEmbryons = 0; iEmbryons < stade.length; iEmbryons++) {
                Embryon embryon = new Embryon();

                embryon.setNumeroEmbryon(iEmbryons + 1);
                embryon.setFicheCol(ficheColToUpdate.getNom());
                embryon.setStade(Integer.parseInt(stade[iEmbryons]));

                if (remarques.length <= iEmbryons || Objects.equals(remarques[iEmbryons], "")) {
                    embryon.setRemarque("");
                } else {
                    embryon.setRemarque(remarques[iEmbryons]);
                }

                if (refTransfert.length <= iEmbryons || Objects.equals(refTransfert[iEmbryons], "")) {
                    embryon.setReferenceTransfert("");
                } else {
                    embryon.setReferenceTransfert(refTransfert[iEmbryons]);
                }

                if (refVache.length <= iEmbryons || Objects.equals(refVache[iEmbryons], "")) {
                    embryon.setNumeroReceveuse("");
                } else {
                    embryon.setNumeroReceveuse(refVache[iEmbryons]);
                }

                embryon.setQualite(Integer.parseInt(qualite[iEmbryons]));

                if (visotube != null && visotube.length >= iEmbryons && !Objects.equals(visotube[iEmbryons], "")) {
                    embryon.setCryoconserve(true);
                }

                if((visotube == null || visotube.length <= iEmbryons || Objects.equals(visotube[iEmbryons], "")) &&
                        (refTransfert == null || refTransfert.length <= iEmbryons || Objects.equals(refTransfert[iEmbryons], "")) ) {
                    embryon.setDetruit(true);
                }

                listEmbryons.add(embryon);
            }

            FicheCol ficheColUpdate = ficheColService.updateFicheCol(ficheColToUpdate, ficheColToUpdate.getNom(), ficheColToUpdate.getProgramme(),
                    ficheColToUpdate.getDateHeureMinute(), ficheColToUpdate.getNumeroAgrement(), ficheColToUpdate.getLieu(), ficheColToUpdate.getOperateur(),
                    ficheColToUpdate.getVache(), ficheColToUpdate.getTraitement_donneuse(), ficheColToUpdate.getResultat_collecte(),
                    ficheColToUpdate.getCryoconservation(), ficheColToUpdate.getTableauSuperOv(), ficheColToUpdate.getInfoTraitementDonneuse(),
                    listEmbryons, ficheColToUpdate.isLC(), ficheColToUpdate.isLL(), ficheColToUpdate.isED());

            for (int iEmbryons = 0; iEmbryons < ficheColToUpdate.getDetailsEmbryonsViables().size(); iEmbryons++) {
                if (ficheColToUpdate.getDetailsEmbryonsViables().get(iEmbryons).isCryoconserve()) {
                    List<EmbryonsInVivo> embryonsInVivos;
                    Optional<VisoTubeInVivo> visoTubeInVivo = visoTubeInVivoService.findOne(Integer.parseInt(visotube[iEmbryons]));

                    if (visoTubeInVivo.isPresent()) {
                        if (visoTubeInVivo.get().getEmbryonsInVivo() != null) {
                            embryonsInVivos = new ArrayList<>();
                        } else {
                            embryonsInVivos = visoTubeInVivo.get().getEmbryonsInVivo();
                        }

                        String remarque = "";

                        if (remarques.length > iEmbryons && !Objects.equals(remarques[iEmbryons], "")) {
                            remarque = remarques[iEmbryons];
                        }

                        embryonsInVivos.add(embryonsInVivoService.create(ficheColToUpdate.getDetailsEmbryonsViables().get(iEmbryons),
                                jonc[iEmbryons], null, "", remarque));

                        visoTubeInVivoService.update(visoTubeInVivo.get(), visoTubeInVivo.get().getCouleur(), embryonsInVivos);
                    }
                }
            }
            response.setObjet(ficheColUpdate);
        }else{
            response.setObjet(ficheColToUpdate);
        }

        response.setSucces(true);
        response.setMessage("4ème étape validée");

        return response;
    }

    @ResponseBody
    @RequestMapping(value = "/addOrUpdatePart5/{id}", method = RequestMethod.POST)
    public JsonResponse updatePart5(@PathVariable("id") FicheCol ficheColToUpdate, @RequestParam(value="refCong", required = false) String refCong,
                                    @RequestParam(value="heureCong", required = false) String heureCong,@RequestParam(value="methodeCongelation", required = false) String methodeCongelation,
                                    @RequestParam(value="congelateur", required = false) String congelateur, @RequestParam(value="operateurCong", required = false) Operateur operateur,
                                    @RequestParam(value="description", required = false) String description, @RequestParam(value="lc", required = false) String lc,
                                    @RequestParam(value="ll", required = false) String ll, @RequestParam(value="ed", required = false) String ed){
        JsonResponse response = new JsonResponse();

        Cryoconservation cryoconservation;

        if(ficheColToUpdate.getCryoconservation() != null){
            cryoconservation = ficheColToUpdate.getCryoconservation();
        }else{
            cryoconservation = new Cryoconservation();
        }

        boolean llBool = false;
        boolean lcBool = false;
        boolean edBool = false;

        if(Objects.equals(ll, "ll")){
            llBool=true;
        }
        if(Objects.equals(lc, "lc")){
            lcBool=true;
        }
        if(Objects.equals(ed, "ed")){
            edBool=true;
        }

        cryoconservation.setRef(refCong);

        cryoconservation.setMethodeCongelation(methodeCongelation);
        cryoconservation.setCongelateur(congelateur);
        cryoconservation.setOperateur(operateur);
        cryoconservation.setDescMethode(description);

        DateFormat formatter = new SimpleDateFormat("hh:mm");
        try {
            Date date = formatter.parse(heureCong);
            cryoconservation.setHeureMinute(date);

            FicheCol ficheColUpdate = ficheColService.updateFicheCol(ficheColToUpdate, ficheColToUpdate.getNom(), ficheColToUpdate.getProgramme(),
                    ficheColToUpdate.getDateHeureMinute(), ficheColToUpdate.getNumeroAgrement(), ficheColToUpdate.getLieu(), ficheColToUpdate.getOperateur(),
                    ficheColToUpdate.getVache(), ficheColToUpdate.getTraitement_donneuse(), ficheColToUpdate.getResultat_collecte(),
                    cryoconservation, ficheColToUpdate.getTableauSuperOv(), ficheColToUpdate.getInfoTraitementDonneuse(),
                    ficheColToUpdate.getDetailsEmbryonsViables(), llBool, lcBool, edBool);

            response.setMessage("5ème étape validée");
        } catch (ParseException e) {
            FicheCol ficheColUpdate = ficheColService.updateFicheCol(ficheColToUpdate, ficheColToUpdate.getNom(), ficheColToUpdate.getProgramme(),
                    ficheColToUpdate.getDateHeureMinute(), ficheColToUpdate.getNumeroAgrement(), ficheColToUpdate.getLieu(), ficheColToUpdate.getOperateur(),
                    ficheColToUpdate.getVache(), ficheColToUpdate.getTraitement_donneuse(), ficheColToUpdate.getResultat_collecte(),
                    cryoconservation, ficheColToUpdate.getTableauSuperOv(), ficheColToUpdate.getInfoTraitementDonneuse(),
                    ficheColToUpdate.getDetailsEmbryonsViables(), llBool, lcBool, edBool);

            response.setMessage("5ème étape validée - erreur dans l'heure de congélation");
        }

        response.setObjet(ficheColToUpdate);
        response.setSucces(true);
        return response;
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

    /******************** DELETE FICHE ********************/
    @ResponseBody
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public JsonResponse delete(@PathVariable("id") FicheCol ficheCol){
        JsonResponse response = new JsonResponse();
        ficheColService.delete(ficheCol);
        response.setSucces(true);
        response.setMessage("Fiche supprimée");
        return response;
    }

    /******************** GET ONE  ********************/
    @ResponseBody
    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
    public JsonResponse getOne(@PathVariable("id") long id){
        JsonResponse response = new JsonResponse();
        Optional<FicheCol> ficheCol = ficheColService.findOne(id);

        if(ficheCol.isPresent()){
            response.setSucces(true);
            response.setObjet(ficheCol.get());
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
        String nom = ficheColService.findTopByOrderByNomDesc().getNom();
        if(!Objects.equals(nom, "")){
            return nom;
        }else{
            return "";
        }
    }
}
