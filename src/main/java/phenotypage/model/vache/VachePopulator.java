package phenotypage.model.vache;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Date;

/**
 * @author fabien
 */

@Component
public class VachePopulator
{
	@Autowired
	private VacheService vacheService;

	@PostConstruct
	void init()
	{
//		vacheService.createVache(true, "proprio", "nom", "numElevage", "numIdent", 62, 'F', new Date(), "parite", 20.3F, "numPere", "numMere");
//		vacheService.createVache(true, "proprio", "nom", "numElevage", "numIdent2", 62, 'F', new Date(), "parite", 20.3F, "numPere", "numMere");
	}
}
