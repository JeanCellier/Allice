package phenotypage.model.traitementDonneuse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @author fabien
 */
@Component
public class Traitement_DonneusePopulator
{
	@Autowired
	private Traitement_DonneuseService traitement_donneuseService;

	@PostConstruct
	void init()
	{
//		traitement_donneuseService.createTraitement_Donneuse();
	}
}
