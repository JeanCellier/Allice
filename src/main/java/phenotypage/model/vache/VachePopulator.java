package phenotypage.model.vache;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

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
		/*Vache v = new Vache();
		v.setRace(1);
		v.setNum_identification("r");
		vacheService.addVache(v);
		Vache vv = new Vache();
		vv.setMale(true);
		vv.setNum_identification("t");
		vv.setRace(2);
		vacheService.addVache(vv);*/
	}
}
