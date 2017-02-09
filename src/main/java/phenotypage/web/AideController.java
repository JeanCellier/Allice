package phenotypage.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import phenotypage.model.donneExistante.destionationCulture.DestinationCulture;
import phenotypage.model.donneExistante.destionationCulture.DestinationCultureService;
import phenotypage.model.donneExistante.abattoir.Abattoir;
import phenotypage.model.donneExistante.abattoir.AbattoirService;
import phenotypage.model.donneExistante.congelateur.Congelateur;
import phenotypage.model.donneExistante.congelateur.CongelateurService;
import phenotypage.model.donneExistante.cuve.Cuve;
import phenotypage.model.donneExistante.cuve.CuveService;
import phenotypage.model.donneExistante.cuve.canister.Canister;
import phenotypage.model.donneExistante.cuve.canister.CanisterService;
import phenotypage.model.donneExistante.cuve.visoTube.VisoTube;
import phenotypage.model.donneExistante.cuve.visoTube.VisoTubeService;
import phenotypage.model.donneExistante.fiv.FIV;
import phenotypage.model.donneExistante.fiv.FIVService;
import phenotypage.model.milieuMaturation.MilieuMaturation;
import phenotypage.model.milieuMaturation.MilieuMaturationService;
import phenotypage.model.donneExistante.operateur.Operateur;
import phenotypage.model.donneExistante.operateur.OperateurService;
import phenotypage.model.donneExistante.programme.Programme;
import phenotypage.model.donneExistante.programme.ProgrammeService;
import phenotypage.model.donneExistante.qualite.Qualite;
import phenotypage.model.donneExistante.qualite.QualiteService;
import phenotypage.model.donneExistante.sanitaire.Sanitaire;
import phenotypage.model.donneExistante.sanitaire.SanitaireService;
import phenotypage.model.donneExistante.stade.Stade;
import phenotypage.model.donneExistante.stade.StadeService;
import phenotypage.model.donneExistante.typeCulture.TypeCulture;
import phenotypage.model.donneExistante.typeCulture.TypeCultureService;

import javax.validation.Valid;

@Controller
@RequestMapping("/aide")
public class AideController
{
	@Autowired
	private CongelateurService congelateurService;

	@Autowired
	private OperateurService operateurService;

	@Autowired
	private ProgrammeService programmeService;

	@Autowired
	private TypeCultureService typeCultureService;

	@Autowired
	private AbattoirService abattoirService;

	@Autowired
	private SanitaireService sanitaireService;

	@Autowired
	private FIVService fivService;

	@Autowired
	private MilieuMaturationService milieuMaturationService;

	@Autowired
	private StadeService stadeService;

	@Autowired
	private QualiteService qualiteService;

	@Autowired
	private CuveService cuveService;

	@Autowired
	private CanisterService canisterService;

	@Autowired
	private VisoTubeService visoTubeService;

	@Autowired
	private DestinationCultureService destinationCultureService;

	@RequestMapping(value = "/accueil", method = RequestMethod.GET)
	public String aide()
	{
		return "aide/accueil";
	}

	@RequestMapping(value = "/ajoutCongelateur", method = RequestMethod.GET)
	public String ajoutCongelateur(Model model)
	{
		model.addAttribute("congelateurList", congelateurService.findAllCongelateur());
		model.addAttribute("congelateur", congelateurService.newCongelateur());
		return "aide/ajoutCongelateur";
	}

	@RequestMapping(value = "/ajoutCongelateur", method = RequestMethod.POST)
	public String ajoutCongelateur(@Valid Congelateur congelateur, Errors errors, Model model)
	{
		if (errors.hasErrors())
		{
			model.addAttribute("congelateur", congelateur);
			return "aide/ajoutCongelateur";
		}
		congelateurService.addCongelateur(congelateur);
		return "aide/accueil";
	}

	@RequestMapping(value = "/ajoutProgramme", method = RequestMethod.GET)
	public String ajoutProgramme(Model model)
	{
		model.addAttribute("programmeList", programmeService.findAllProgramme());
		model.addAttribute("programme", programmeService.newProgramme());
		return "aide/ajoutProgramme";
	}

	@RequestMapping(value = "/ajoutProgramme", method = RequestMethod.POST)
	public String ajoutProgramme(@Valid Programme programme, Errors errors, Model model)
	{
		if (errors.hasErrors())
		{
			model.addAttribute("programme", programme);
			return "aide/ajoutProgramme";
		}
		programmeService.addProgramme(programme);
		return "aide/accueil";
	}

	@RequestMapping(value = "/ajoutAbattoir", method = RequestMethod.GET)
	public String ajoutAbattoir(Model model)
	{
		model.addAttribute("abattoirList", abattoirService.findAllAbattoir());
		model.addAttribute("abattoir", abattoirService.newAbattoir());
		return "aide/ajoutAbattoir";
	}

	@RequestMapping(value = "/ajoutAbattoir", method = RequestMethod.POST)
	public String ajoutProgramme(@Valid Abattoir abattoir, Errors errors, Model model)
	{
		if (errors.hasErrors())
		{
			model.addAttribute("abattoir", abattoir);
			return "aide/ajoutAbattoir";
		}
		abattoirService.addAbattoir(abattoir);
		return "aide/accueil";
	}

	@RequestMapping(value = "/ajoutOperateur", method = RequestMethod.GET)
	public String ajoutOperateur(Model model)
	{
		model.addAttribute("operateurList", operateurService.findAllOperateur());
		model.addAttribute("operateur", operateurService.newOperateur());
		return "aide/ajoutOperateur";
	}

	@RequestMapping(value = "/ajoutOperateur", method = RequestMethod.POST)
	public String ajoutOperateur(@Valid Operateur operateur, Errors errors, Model model)
	{
		if (errors.hasErrors())
		{
			model.addAttribute("operateur", operateur);
			return "aide/ajoutOperateur";
		}
		operateurService.addOperateur(operateur);
		return "aide/accueil";
	}

	@RequestMapping(value = "/ajoutSanitaire", method = RequestMethod.GET)
	public String ajoutSanitaire(Model model)
	{
		model.addAttribute("sanitaireList", sanitaireService.findAllSanitaire());
		model.addAttribute("sanitaire", sanitaireService.newSanitaire());
		return "aide/ajoutSanitaire";
	}

	@RequestMapping(value = "/ajoutSanitaire", method = RequestMethod.POST)
	public String ajoutSanitaire(@Valid Sanitaire sanitaire, Errors errors, Model model)
	{
		if (errors.hasErrors())
		{
			model.addAttribute("sanitaire", sanitaire);
			return "aide/ajoutSanitaire";
		}
		sanitaireService.addSanitaire(sanitaire);
		return "aide/accueil";
	}

	@RequestMapping(value = "/ajoutTypeCulture", method = RequestMethod.GET)
	public String ajoutTypeCulture(Model model)
	{
		model.addAttribute("typeCulturelist", typeCultureService.findAllTypeCulture());
		model.addAttribute("typeCulture", typeCultureService.newTypeCulture());
		return "aide/ajoutTypeCulture";
	}

	@RequestMapping(value = "/ajoutTypeCulture", method = RequestMethod.POST)
	public String ajoutTypeCulture(@Valid TypeCulture typeCulture, Errors errors, Model model)
	{
		if (errors.hasErrors())
		{
			model.addAttribute("typeCulture", typeCulture);
			return "aide/ajoutTypeCulture";
		}
		typeCultureService.addTypeCulture(typeCulture);
		return "aide/accueil";
	}

	@RequestMapping(value = "/ajoutFIV", method = RequestMethod.GET)
	public String ajoutFIV(Model model)
	{
		model.addAttribute("fivList", fivService.findAllFIV());
		model.addAttribute("fiv", fivService.newFIV());
		return "aide/ajoutFIV";
	}

	@RequestMapping(value = "/ajoutFIV", method = RequestMethod.POST)
	public String ajoutFIV(@Valid FIV fiv, Errors errors, Model model)
	{
		if (errors.hasErrors())
		{
			model.addAttribute("fiv", fiv);
			return "aide/ajoutFIV";
		}
		fivService.addFIV(fiv);
		return "aide/accueil";
	}

	@RequestMapping(value = "/ajoutMilieuMaturation", method = RequestMethod.GET)
	public String ajoutMilieuMaturation(Model model)
	{
		model.addAttribute("milieuMaturationList", milieuMaturationService.findAllMilieuMaturation());
		model.addAttribute("milieuMaturation", milieuMaturationService.newMilieuMaturation());
		return "aide/ajoutMilieuMaturation";
	}

	@RequestMapping(value = "/ajoutMilieuMaturation", method = RequestMethod.POST)
	public String ajoutMilieuMaturation(@Valid MilieuMaturation milieuMaturation, Errors errors, Model model)
	{
		if (errors.hasErrors())
		{
			model.addAttribute("milieuMaturation", milieuMaturation);
			return "aide/ajoutMilieuMaturation";
		}
		milieuMaturationService.addMilieuMaturation(milieuMaturation);
		return "aide/accueil";
	}

	@RequestMapping(value = "/ajoutStade", method = RequestMethod.GET)
	public String ajoutStade(Model model)
	{
		model.addAttribute("stadeList", stadeService.findAllStade());
		model.addAttribute("stade", stadeService.newStade());
		return "aide/ajoutStade";
	}

	@RequestMapping(value = "/ajoutStade", method = RequestMethod.POST)
	public String ajoutStade(@Valid Stade stade, Errors errors, Model model)
	{
		if (errors.hasErrors())
		{
			model.addAttribute("stade", stade);
			return "aide/ajoutStade";
		}
		stadeService.addStade(stade);
		return "aide/accueil";
	}

	@RequestMapping(value = "/ajoutQualite", method = RequestMethod.GET)
	public String ajoutQualite(Model model)
	{
		model.addAttribute("qualiteList", qualiteService.findAllQualite());
		model.addAttribute("qualite", qualiteService.newQualite());
		return "aide/ajoutQualite";
	}

	@RequestMapping(value = "/ajoutQualite", method = RequestMethod.POST)
	public String ajoutQualite(@Valid Qualite qualite, Errors errors, Model model)
	{
		if (errors.hasErrors())
		{
			model.addAttribute("qualite", qualite);
			return "aide/ajoutQualite";
		}
		qualiteService.addQualite(qualite);
		return "aide/accueil";
	}

	@RequestMapping(value = "/ajoutCuve", method = RequestMethod.GET)
	public String ajoutCuve(Model model)
	{
		model.addAttribute("cuveList", cuveService.findAllCuve());
		model.addAttribute("cuve", cuveService.newCuve());
		return "aide/ajoutCuve";
	}

	@RequestMapping(value = "/ajoutCuve", method = RequestMethod.POST)
	public String ajoutCuve(@Valid Cuve cuve, Errors errors, Model model)
	{
		if (errors.hasErrors())
		{
			model.addAttribute("cuve", cuve);
			return "aide/ajoutCuve";
		}
		cuveService.addCuve(cuve);
		return "aide/accueil";
	}

	@RequestMapping(value = "/ajoutCanister", method = RequestMethod.GET)
	public String ajoutCanister(Model model)
	{
		model.addAttribute("canisterList", canisterService.findAllCanister());
		model.addAttribute("canister", canisterService.newCanister());
		return "aide/ajoutCanister";
	}

	@RequestMapping(value = "/ajoutCanister", method = RequestMethod.POST)
	public String ajoutCanister(@Valid Canister canister, Errors errors, Model model)
	{
		if (errors.hasErrors())
		{
			model.addAttribute("canister", canister);
			return "aide/ajoutCanister";
		}
		canisterService.addCanister(canister);
		return "aide/accueil";
	}

	@RequestMapping(value = "/ajoutVisoTube", method = RequestMethod.GET)
	public String ajoutVisoTube(Model model)
	{
		model.addAttribute("visoTubeList", visoTubeService.findAllVisoTube());
		model.addAttribute("visoTube", visoTubeService.newVisoTube());
		return "aide/ajoutVisoTube";
	}

	@RequestMapping(value = "/ajoutVisoTube", method = RequestMethod.POST)
	public String ajoutVisoTube(@Valid VisoTube visoTube, Errors errors, Model model)
	{
		if (errors.hasErrors())
		{
			model.addAttribute("visoTube", visoTube);
			return "aide/ajoutCuve";
		}
		visoTubeService.addVisoTube(visoTube);
		return "aide/accueil";
	}

	@RequestMapping(value = "/ajoutDestinationCulture", method = RequestMethod.GET)
	public String ajoutDestinationCulture(Model model)
	{
		model.addAttribute("destinationCultureList", destinationCultureService.findAllDestinationCulture());
		model.addAttribute("destinationCulture",  destinationCultureService.newDestinationCulture());
		return "aide/ajoutDestinationCulture";
	}

	@RequestMapping(value = "/ajoutDestinationCulture", method = RequestMethod.POST)
	public String ajoutDestinationCulture(@Valid DestinationCulture destinationCulture, Errors errors, Model model)
	{
		if (errors.hasErrors())
		{
			model.addAttribute("destinationCulture", destinationCulture);
			return "aide/ajoutDestinationCulture";
		}
		destinationCultureService.addDestinationCulture(destinationCulture);
		return "aide/accueil";
	}
}