package phenotypage.model.traitementDonneuse.tableauPharmacie;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @author fabien
 */
@Component
public class Tableau_PharmaciePopulator
{
	@Autowired
	private Tableau_PharmacieService tableau_pharmacieService;

	@PostConstruct
	void init()
	{
		tableau_pharmacieService.createTableau_Pharmacie();
	}
}
