package phenotypage.model.gestation;

import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;

public class Tableau_GestationPopulator
{

	@Autowired
	private Tableau_GestationService tableau_collecteService;

	@PostConstruct
	void init()
	{

	}
}
