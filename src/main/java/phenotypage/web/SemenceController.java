package phenotypage.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import phenotypage.model.cuve.cuveSemence.canisterSemence.visoTubeSemence.semence.SemenceService;

import java.util.List;

/**
 * Created by nicolas on 21/05/17.
 */
@Controller
@RequestMapping("/semence")
public class SemenceController {
    @Autowired
    private SemenceService semenceService;

    /** AUTOCOMPLETE **/
    @ResponseBody
    @RequestMapping(value="/get/taureau", method = RequestMethod.GET)
    public List<String> getNumTaureauByNumTaureauLastCharacters(@RequestParam("term") String tag){
        List<String> listNumTravail = semenceService.findNumTaureauByNumTaureauLastCharacters(tag);
        return listNumTravail;
    }
}
