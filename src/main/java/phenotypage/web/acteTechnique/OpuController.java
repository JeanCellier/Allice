package phenotypage.web.acteTechnique;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import phenotypage.model.fiche.ficheOpu.FicheOpu;
import phenotypage.model.fiche.ficheOpu.FicheOpuService;
import phenotypage.model.fiche.ficheOpu.typeOpu.TypeOpu;
//import phenotypage.model.fiche.ficheOpu.typeOpu.TypeOpuService;
import phenotypage.model.jsonResponse.JsonResponse;
import phenotypage.model.operateur.Operateur;
import phenotypage.model.operateur.OperateurService;
import phenotypage.model.pharmacie.produit.ProduitService;
import phenotypage.model.programme.Programme;
import phenotypage.model.programme.ProgrammeService;
import phenotypage.model.vache.Vache;
import phenotypage.model.vache.VacheService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;

/**
 * Created by Boyang Wang on 2017/5/20.
 */
@Controller
@RequestMapping("/acteTechnique/opu")
public class OpuController {

    @Autowired
    public FicheOpuService ficheOpuService;

    @Autowired
    public ProgrammeService programmeService;

    @Autowired
    public OperateurService operateurService;

    @Autowired
    public VacheService vacheService;

    @Autowired
    public ProduitService produitService;

    /*@Autowired
    public TypeOpuService typeOpuService;*/

    @RequestMapping(value="/opu", method = RequestMethod.GET)
    public String opuConsult(Model model){
        model.addAttribute("ficheOpuList", ficheOpuService.findAllFicheOpu());
        model.addAttribute("produitList", produitService.findAll());
        model.addAttribute("programmeList", programmeService.findAll());
        model.addAttribute("operateurList", operateurService.findAll());
        model.addAttribute("vacheList", vacheService.findAll());
        //model.addAttribute("typeOpuList", typeOpuService.findAll());
        return "acteTechnique/opu/opu_consult";
    }

    /******************** ADD OR UPDATE FICHE ********************/
    @ResponseBody
    @RequestMapping(value = "/addOrUpdatePart1", method = RequestMethod.POST)
    public JsonResponse addPart1(@RequestParam("nom") String nom, @RequestParam(value="programme", required = false) Programme programme,
                                 @RequestParam("numAgrement") String numAgrement, @RequestParam(value="lieu", required = false) String lieu,
                                 @RequestParam(value="date", required = false) String date, @RequestParam(value = "typeOpu", required = false) TypeOpu typeOpu,
                                 @RequestParam(value="operateur", required = false) Operateur operateur, @RequestParam("vache") String numIdvache){

        JsonResponse jsonResponse = new JsonResponse();
        jsonResponse.setSucces(true);
        return jsonResponse;
    }

    @ResponseBody
    @RequestMapping(value = "/addOrUpdatePart2", method = RequestMethod.POST)
    public JsonResponse addOrUpdatePart2(){
        JsonResponse jsonResponse = new JsonResponse();
        jsonResponse.setSucces(true);
        return jsonResponse;
    }

    @ResponseBody
    @RequestMapping(value = "/addOrUpdatePart3", method = RequestMethod.POST)
    public JsonResponse addOrUpdatePart3(){
        JsonResponse jsonResponse = new JsonResponse();
        jsonResponse.setSucces(true);
        return jsonResponse;
    }

    @ResponseBody
    @RequestMapping(value = "/addOrUpdatePart4", method = RequestMethod.POST)
    public JsonResponse addOrUpdatePart4(){
        JsonResponse jsonResponse = new JsonResponse();
        jsonResponse.setSucces(true);
        return jsonResponse;
    }

    @ResponseBody
    @RequestMapping(value = "/addOrUpdatePart5", method = RequestMethod.POST)
    public JsonResponse addOrUpdatePart5(){
        JsonResponse jsonResponse = new JsonResponse();
        jsonResponse.setSucces(true);
        return jsonResponse;
    }
}
