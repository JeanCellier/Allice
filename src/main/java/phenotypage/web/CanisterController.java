package phenotypage.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import phenotypage.model.cuve.Cuve;
import phenotypage.model.cuve.CuveService;
import phenotypage.model.jsonResponse.JsonResponse;

import java.util.List;
import java.util.Optional;
import phenotypage.model.cuve.canister.CanisterService;

@Controller
@RequestMapping("/cuves")
public class CanisterController {

    @Autowired
    private CanisterService canisterService;

    /** ACCUEIL CANISTERS **/
    @RequestMapping(value = "/canister", method = RequestMethod.GET)
    public String canister(Model model)
    {
        model.addAttribute("canisterList", canisterService.findAllCanister());
        return "cuves/canister";
    }

//    /** ADD **/
//    @ResponseBody
//    @RequestMapping(value = "/add", method = RequestMethod.POST)
//    public JsonResponse add(@RequestParam("nom") String nom, @RequestParam("designation") String designation ){
//
//        JsonResponse response = new JsonResponse();
//
//        Cuve cuve = cuveService.createCuve(nom, designation);
//
//        response.setSucces(true);
//        response.setMessage("Ajout effectué");
//        response.setObjet(cuve);
//
//
//        return response;
//    }
//
//    /** GET ONE */
//    @ResponseBody
//    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
//    public JsonResponse delete(@PathVariable("id") long id){
//        JsonResponse response = new JsonResponse();
//        Optional<Cuve> cuve = cuveService.findOne(id);
//
//        if(cuve.isPresent()){
//            response.setSucces(true);
//            response.setObjet(cuve.get());
//        }else{
//            response.setSucces(false);
//            response.setMessage("Une erreur s\'est produite");
//        }
//
//        return response;
//    }
//
//    /** EDIT **/
//    @ResponseBody
//    @RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
//    public JsonResponse edit(@PathVariable("id")  Cuve cuve, @RequestParam("nom") String nom,
//                             @RequestParam("designation") String designation){
//        JsonResponse response = new JsonResponse();
//
//        cuveService.update( cuve, nom, designation);
//        response.setSucces(true);
//        response.setMessage("Cuve modifiée");
//        response.setObjet(cuve);
//
//
//        return response;
//    }
//
//    /** DELETE **/
//    @ResponseBody
//    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
//    public JsonResponse delete(@PathVariable("id")  Cuve cuve){
//        JsonResponse response = new JsonResponse();
//        cuveService.delete(cuve);
//        response.setSucces(true);
//        response.setMessage("Produit supprimé");
//        return response;
//    }
//
//    /** AUTOCOMPLETE **/
//    @ResponseBody
//    @RequestMapping(value="/get/name", method = RequestMethod.GET)
//    public List<String> getNames(@RequestParam("term") String tag){
//        return cuveService.findDistinctName(tag);
//    }
//
//    @ResponseBody
//    @RequestMapping(value="/get/designation", method = RequestMethod.GET)
//    public List<String> getFournisseurs(@RequestParam("term") String tag){
//        return cuveService.findDistinctDesignation(tag);
//    }
}
