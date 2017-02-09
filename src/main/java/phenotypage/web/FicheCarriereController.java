package phenotypage.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/ficheCarriere")
public class FicheCarriereController {
	
	@RequestMapping(value = "/accueil", method = RequestMethod.GET)
	public String ficheCarriere()
	{
		return "ficheCarriere/accueil";
	}

}
