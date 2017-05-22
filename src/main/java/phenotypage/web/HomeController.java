package phenotypage.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import phenotypage.model.vache.VacheService;

/**
 * Created by fabien on 01/04/16.
 */

@Controller
public class HomeController
{
	@Autowired
	private VacheService vacheService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index(Model model)
	{
		model.addAttribute("vacheList", vacheService.findAll());
		return "animaux/animaux";
	}
}
