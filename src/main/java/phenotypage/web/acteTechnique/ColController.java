package phenotypage.web.acteTechnique;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import phenotypage.model.fiche.ficheCol.FicheCol;
import phenotypage.model.fiche.ficheCol.FicheColService;
import phenotypage.model.jsonResponse.JsonResponse;
import phenotypage.model.vache.Vache;
import phenotypage.model.vache.VacheService;

import java.util.List;
import java.util.Optional;


/**
 * Created by nicolas on 18/05/17.
 */
@Controller
@RequestMapping("/acteTechnique/col")
public class ColController {
    @Autowired
    FicheColService ficheColService;

    @Autowired
    VacheService vacheService;

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
}
