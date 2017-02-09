package phenotypage.model.pharmacie;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class PharmaciePopulator
{
	@Autowired
	private PharmacieService pharmacieService;

	@PostConstruct
	void init()
	{
		pharmacieService.createPharmacie("Principale");
	}
}
