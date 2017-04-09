package phenotypage.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import phenotypage.model.JsonResponse.JsonResponse;
import phenotypage.model.operateur.Operateur;
import phenotypage.model.operateur.OperateurService;

/**
 * Created by nicolas on 08/04/17.
 */
@Controller
@RequestMapping("/operateur")
public class OperateurController {
    @Autowired
    private OperateurService operateurService;

    @ResponseBody
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public JsonResponse add(@RequestParam("nomOperateur") String nom, @RequestParam("prenomOperateur") String prenom){
        JsonResponse response = new JsonResponse();

        Operateur operateur = operateurService.createOperateur(nom, prenom);

        response.setSucces(true);
        response.setObjet(operateur);

        return response;
    }
}
