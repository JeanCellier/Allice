package phenotypage.model.donneExistante.cuve;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @author fabien
 */

@Component
public class CuvePopulator
{
	@Autowired
	private CuveService cuveService;

	@PostConstruct
	void inti()
	{
		cuveService.createCuve("Embryons vitro", "labo");
		cuveService.createCuve("Embryons vivo", "élevage");
		cuveService.createCuve("Cellules somatiques", "labo");
		cuveService.createCuve("Semences élevage", "élevage");
		cuveService.createCuve("Semences FIV", "labo");
	}
}
