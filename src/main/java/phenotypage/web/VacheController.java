package phenotypage.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import phenotypage.model.jsonResponse.JsonResponse;
import phenotypage.model.vache.Vache;
import phenotypage.model.vache.VacheService;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;


@Controller
@RequestMapping("/animaux")
public class VacheController
{
    @Autowired
    private VacheService vacheService;

    /** ACCUEIL VACHE **/
    @RequestMapping(value = "/animaux", method = RequestMethod.GET)
    public String vache(Model model)
    {
        model.addAttribute("vacheList", vacheService.findAll());
        return "animaux/animaux";
    }

    /** ADD **/
    @ResponseBody
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public JsonResponse add(@RequestParam("proprietaire") String proprietaire, @RequestParam("num_elevage") String num_elevage,
                            @RequestParam("num_identification") String num_identification, @RequestParam("num_travail") String num_travail,
                            @RequestParam("race") String race, @RequestParam("date_arrivee") String date_arrivee){

        JsonResponse response = new JsonResponse();
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

        try {
            Date dateArrivee = formatter.parse(date_arrivee);
            Long numeroTravail = Long.parseLong(num_travail);
            int raceInt = Integer.parseInt(race);

            try {
//                    Vache vache = vacheService.createVache(proprietaire, num_elevage, num_identification, numeroTravail, raceInt, dateArrivee);

                    response.setSucces(true);
                    response.setMessage("Ajout effectué");
//                    response.setObjet(vache);

            }catch (NumberFormatException e){
            }
        } catch (ParseException e) {
        }

        return response;
    }

    /** GET ONE */
    @ResponseBody
    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
    public JsonResponse delete(@PathVariable("id") long id){
        JsonResponse response = new JsonResponse();
//        Optional<Vache> vache = vacheService.findOne(id);
//
//        if(vache.isPresent()){
//            response.setSucces(true);
//            response.setObjet(vache.get());
//        }else{
//            response.setSucces(false);
//            response.setMessage("Une erreur s\'est produite");
//        }

        return response;
    }

    /** EDIT **/
    @ResponseBody
    @RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
    public JsonResponse edit(@PathVariable("id")  Vache vache, @RequestParam("proprietaire") String proprietaire,
                             @RequestParam("num_elevage") String num_elevage, @RequestParam("num_identification") String num_identification,
                             @RequestParam("num_travail") String num_travail, @RequestParam("race") String race,
                             @RequestParam("date_arrivee") String date_arrivee){
        JsonResponse response = new JsonResponse();

        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

        try {
            Date dateArrivee = formatter.parse(date_arrivee);
            Long numeroTravail = Long.parseLong(num_travail);
            int raceInt = Integer.parseInt(race);

//                    vacheService.update(vache, proprietaire, num_elevage, num_identification, numeroTravail, raceInt, dateArrivee);
//                    response.setSucces(true);
//                    response.setMessage("Animal modifié");
//                    response.setObjet(vache);

            }catch (NumberFormatException e){
            }
        catch (ParseException e) {
        }

        return response;
    }

    /** DELETE **/
    @ResponseBody
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public JsonResponse delete(@PathVariable("id")  Vache vache){
        JsonResponse response = new JsonResponse();
//        vacheService.delete(vache);
        response.setSucces(true);
        response.setMessage("Animal supprimé");
        return response;
    }


    /** AUTOCOMPLETE **/
    @ResponseBody
    @RequestMapping(value="/get/vache", method = RequestMethod.GET)
    public List<String> getNumIdByNumTravail(@RequestParam("term") String tag){
        List<String> lol = vacheService.findNumIdByNumTravail(tag);
        System.out.println(lol.size());
        return lol;
    }
//
//    /** AUTOCOMPLETE **/
//    @ResponseBody
//    @RequestMapping(value="/get/names", method = RequestMethod.GET)
//    public List<String> getNames(@RequestParam("term") String tag){
//        return produitService.findDistinctNames(tag);
//    }
//
//    @ResponseBody
//    @RequestMapping(value="/get/fournisseurs", method = RequestMethod.GET)
//    public List<String> getFournisseurs(@RequestParam("term") String tag){
//        return produitService.findDistinctFournisseurs(tag);
//    }
//
//    @ResponseBody
//    @RequestMapping(value="/get/projets", method = RequestMethod.GET)
//    public List<String> getProjets(@RequestParam("term") String tag){
//        return produitService.findDistinctProjets(tag);
//    }
//
//    @ResponseBody
//    @RequestMapping(value="/get/responsables", method = RequestMethod.GET)
//    public List<String> getResponsables(@RequestParam("term") String tag){
//        return produitService.findDistinctResponsables(tag);
//    }

}
