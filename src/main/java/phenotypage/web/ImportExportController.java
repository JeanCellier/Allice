package phenotypage.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import phenotypage.importation.ImportService;
import phenotypage.model.fiche.Fiche;
import phenotypage.model.fiche.ficheAba.FicheAba;
import phenotypage.model.fiche.ficheAba.FicheAbaService;
import phenotypage.model.fiche.ficheCol.FicheCol;
import phenotypage.model.fiche.ficheCol.FicheColService;
import phenotypage.model.fiche.ficheIa.FicheIa;
import phenotypage.model.fiche.ficheIa.FicheIaService;
import phenotypage.model.fiche.ficheOpu.FicheOpu;
import phenotypage.model.fiche.ficheOpu.FicheOpuService;
import phenotypage.model.fiche.ficheTra.FicheTra;
import phenotypage.model.fiche.ficheTra.FicheTraService;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by simoe on 16/03/2017.
 */
@Controller
public class ImportExportController {

    @Autowired
    private ImportService importService;

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

    @RequestMapping(value = "/importexport", method = RequestMethod.GET)
    public String importexport(Model model) {
        List<FicheAba> ficheAbaList = ficheAbaService.findAllFicheAba();
        List<FicheCol> ficheColList = ficheColService.findAllFicheCol();
        List<FicheIa> ficheIaList = ficheIaService.findAllFicheIa();
        List<FicheOpu> ficheOpuList = ficheOpuService.findAllFicheOpu();
        List<FicheTra> ficheTraList = ficheTraService.findAllFicheTra();

        List<Fiche> ficheList = new ArrayList<>();
        ficheList.addAll(ficheAbaList);
        ficheList.addAll(ficheColList);
        ficheList.addAll(ficheIaList);
        ficheList.addAll(ficheOpuList);
        ficheList.addAll(ficheTraList);
        model.addAttribute("ficheList", ficheList);
        return "importexport";
    }

    @RequestMapping(value = "/importexport/import", method = RequestMethod.POST)
    public String importFiche(@RequestParam("file") MultipartFile file, @RequestParam("type") String type) {
        //Stores the file
        importService.store(file);
        //Loads the stored file
        File ficheFile = importService.load(file.getOriginalFilename());
        //Parses the file
        importService.parse(ficheFile, type);

        return "redirect:/importexport";
    }
}
