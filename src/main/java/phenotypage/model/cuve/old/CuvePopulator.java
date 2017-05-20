package phenotypage.model.cuve.old;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;

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
		cuveService.createCuve("Embryons vitro", new ArrayList<>());
		cuveService.createCuve("Embryons vivo", new ArrayList<>());
		cuveService.createCuve("Cellules somatiques", new ArrayList<>());
		cuveService.createCuve("Semences élevage", new ArrayList<>());
		cuveService.createCuve("Semences FIV", new ArrayList<>());
	}
}
