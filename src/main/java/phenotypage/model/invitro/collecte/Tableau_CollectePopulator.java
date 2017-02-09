package phenotypage.model.invitro.collecte;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

public class Tableau_CollectePopulator
{

	@Autowired
	private Tableau_CollecteService tableau_collecteService;

	@PostConstruct
	void init()
	{
		tableau_collecteService.newTableauCollecte();
		tableau_collecteService.newTableauCollecte();
	}
}
