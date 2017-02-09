package phenotypage.web.acteTechnique;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/acteTechnique")
public class ActeTechniqueController
{
	@RequestMapping(value = "/abaaccueil", method = RequestMethod.GET)
	public String acteTechniqueABA()
	{
		return "acteTechnique/aba/abaaccueil";
	}

	@RequestMapping(value = "/opuaccueil", method = RequestMethod.GET)
	public String acteTechniqueOPU()
	{
		return "acteTechnique/opu/opuaccueil";
	}

	@RequestMapping(value = "/traaccueil", method = RequestMethod.GET)
	public String acteTechniqueTRA()
	{
		return "acteTechnique/tra/traaccueil";
	}

	@RequestMapping(value = "/iaaccueil", method = RequestMethod.GET)
	public String acteTechniqueIA()
	{
		return "acteTechnique/ia/iaaccueil";
	}

	@RequestMapping(value = "/colaccueil", method = RequestMethod.GET)
	public String acteTechniqueCOL()
	{
		return "acteTechnique/col/colaccueil";
	}

	@RequestMapping(value = "/accueil", method = RequestMethod.GET)
	public String acteTechnique()
	{
		return "acteTechnique/accueil";
	}
}
