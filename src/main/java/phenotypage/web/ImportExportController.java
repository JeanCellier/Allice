package phenotypage.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by simoe on 16/03/2017.
 */
@Controller
public class ImportExportController {

    @RequestMapping(value = "/importexport", method = RequestMethod.GET)
    public String importexport(Model model) {
        return "importexport";
    }

}
