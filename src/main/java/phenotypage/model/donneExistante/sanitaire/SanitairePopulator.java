package phenotypage.model.donneExistante.sanitaire;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @author fabien
 */

@Component
public class SanitairePopulator
{
	@Autowired
	private SanitaireService sanitaireService;

	@PostConstruct
	void init()
	{
		sanitaireService.createSanitaire("LM");
		sanitaireService.createSanitaire("LL");
		sanitaireService.createSanitaire("ED");
	}
}
