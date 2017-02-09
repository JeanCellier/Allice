package phenotypage.model.donneExistante.congelateur;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @author fabien
 */

@Component
public class CongelateurPopulator
{
	@Autowired
	private CongelateurService congelateurService;

	@PostConstruct
	void init()
	{
		congelateurService.createCongelateur("MS21");
		congelateurService.createCongelateur("Cryologic CL3300");
	}
}
