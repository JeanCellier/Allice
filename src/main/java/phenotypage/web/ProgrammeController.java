package phenotypage.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import phenotypage.model.jsonResponse.JsonResponse;
import phenotypage.model.programme.Programme;
import phenotypage.model.programme.ProgrammeService;

/**
 * Created by nicolas on 08/04/17.
 */
@Controller
@RequestMapping("/programme")
public class ProgrammeController {
    @Autowired
    private ProgrammeService programmeService;

    @ResponseBody
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public JsonResponse add(@RequestParam("nomProgramme") String nom){
        JsonResponse response = new JsonResponse();

        Programme programme = programmeService.createProgramme(nom);

        response.setSucces(true);
        response.setObjet(programme);

        return response;
    }
}
