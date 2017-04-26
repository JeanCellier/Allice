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
//		vacheService.createVache(true, "proprétaireTest", "vache1", "FR37134303", "FR4482231256", 66, 'F', new Date(), "parite", 49.5F, "US000068656236", "FR4482232911");
//		vacheService.createVache(true, "proprétaireTest", "vache2", "FR37134303", "FR2247872784", 66, 'F', new Date(), "parite", 49.2F, "US000140175899", "FR2247872601");
	}
}
