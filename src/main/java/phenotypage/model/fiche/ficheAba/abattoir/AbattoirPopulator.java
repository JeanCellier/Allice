package phenotypage.model.fiche.ficheAba.abattoir;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @author fabien
 */

@Component
public class AbattoirPopulator
{
	@Autowired
	private AbattoirService abattoirService;

	@PostConstruct
	void init()
	{
		abattoirService.createAbattoir("Abattoir1");
		abattoirService.createAbattoir("Abattoir2");
		abattoirService.createAbattoir("Abattoir3");
	}
}
