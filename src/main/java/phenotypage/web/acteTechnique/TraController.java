package phenotypage.web.acteTechnique;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import phenotypage.model.fiche.ficheTra.FicheTraService;

/**
 * Created by nicolas on 30/03/17.
 */
@Controller
@RequestMapping("/acteTechnique/tra")
public class TraController {

    @Autowired
    private FicheTraService ficheTraService;

    @RequestMapping(value = "/tra", method = RequestMethod.GET)
    public String fichesTra(Model model)
    {
        model.addAttribute("fichesTraList", ficheTraService.findAllFicheTra());
        return "acteTechnique/tra/tra_consult";
    }
}
