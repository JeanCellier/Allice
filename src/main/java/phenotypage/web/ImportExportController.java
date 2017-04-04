package phenotypage.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import phenotypage.model.fiche.ficheAba.FicheAbaService;
import phenotypage.model.fiche.ficheCarriere.FicheCarriereService;
import phenotypage.model.fiche.ficheCol.FicheColService;
import phenotypage.model.fiche.ficheIa.FicheIaService;
import phenotypage.model.fiche.ficheOpu.FicheOpuService;
import phenotypage.model.fiche.ficheTra.FicheTraService;

/**
 * Created by simoe on 16/03/2017.
 */
@Controller
public class ImportExportController {

    @Autowired
    private FicheAbaService ficheAbaService;

    @Autowired
    private FicheColService ficheColService;

    @Autowired
    private FicheIaService ficheIaService;

    @Autowired
    private FicheOpuService ficheOpuService;

    @Autowired
    private FicheTraService ficheTraService;

    @Autowired
    private FicheCarriereService ficheCarriereService;

    @RequestMapping(value = "/importexport", method = RequestMethod.GET)
    public String importexport(Model model) {

        return "importexport";
    }

}
