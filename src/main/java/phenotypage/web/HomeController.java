package phenotypage.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by fabien on 01/04/16.
 */

@Controller
public class HomeController
{
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index()
	{
		return "index";
	}
}
