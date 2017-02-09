package phenotypage.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import phenotypage.model.fiche.ficheAba.FicheAbaService;
import phenotypage.model.fiche.ficheCol.FicheColService;
import phenotypage.model.fiche.ficheIa.FicheIaService;
import phenotypage.model.fiche.ficheOpu.FicheOpuService;
import phenotypage.model.fiche.ficheTra.FicheTraService;

import java.io.File;
import java.io.IOException;

/**
 * @author fabien
 */

@Controller
@RequestMapping("/requete")
public class Requete
{
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

	@RequestMapping(value = "/accueil", method = RequestMethod.GET)
	String accueil()
	{
		return "requete/accueil";
	}

	@RequestMapping(value = "/aba", method = RequestMethod.GET)
	String aba(Model model)
	{
		model.addAttribute("ficheList", ficheAbaService.findFicheAbaSNIG());
		return "requete/requeteResultatAba";
	}

	@RequestMapping(value = "/col", method = RequestMethod.GET)
	String col(Model model)
	{
		model.addAttribute("ficheList", ficheColService.findFicheColSNIG());
		return "requete/requeteResultatCol";
	}

	@RequestMapping(value = "/ia", method = RequestMethod.GET)
	String ia(Model model)
	{
		model.addAttribute("ficheList", ficheIaService.findFicheIaSNIG());
		return "requete/requeteResultatIa";
	}

	@RequestMapping(value = "/opu", method = RequestMethod.GET)
	String opu(Model model)
	{
		model.addAttribute("ficheList", ficheOpuService.findFicheOpuSNIG());
		return "requete/requeteResultatOpu";
	}

	@RequestMapping(value = "/tra", method = RequestMethod.GET)
	String tra(Model model) throws IOException
	{
		model.addAttribute("ficheList", ficheTraService.findFicheTraSNIG());
		/*String path = new File(".").getCanonicalPath();
		File file = new File(path+"/src/main/resources/static/pdf/file.txt");
		file.renameTo(new File("."));
		model.addAttribute("file",file);*/
		return "requete/requeteResultatTra";
	}
}
