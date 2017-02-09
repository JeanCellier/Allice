package phenotypage.model.donneExistante.operateur;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @author fabien
 */
@Component
public class OperateurPopulator
{
	@Autowired
	private OperateurService operateurService;

	@PostConstruct
	void init()
	{
		operateurService.createOperateur("Salvetti", "Pascal");
		operateurService.createOperateur("Le Bourhis", "Daniel");
		operateurService.createOperateur("Desnoes", "Olivier");
		operateurService.createOperateur("Le Berre", "Laurène");
		operateurService.createOperateur("Gatien", "Julie");
	}
}
