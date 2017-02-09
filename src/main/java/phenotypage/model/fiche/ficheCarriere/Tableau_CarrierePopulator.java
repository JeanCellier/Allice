package phenotypage.model.fiche.ficheCarriere;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

public class Tableau_CarrierePopulator
{

	@Autowired
	private Tableau_CarriereService tableau_collecteService;

	@PostConstruct
	void init()
	{
		tableau_collecteService.newTableauCarriere();
		tableau_collecteService.newTableauCarriere();
	}
}
