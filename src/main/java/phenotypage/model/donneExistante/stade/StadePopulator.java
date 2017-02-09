package phenotypage.model.donneExistante.stade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @author fabien
 */

@Component
public class StadePopulator
{
	@Autowired
	private StadeService stadeService;

	@PostConstruct
	void init()
	{
		stadeService.createStade("non fécondé", 1);
		stadeService.createStade("2 à 12 cellules", 2);
		stadeService.createStade("jeune morula", 3);
		stadeService.createStade("morula", 4);
		stadeService.createStade("jeune blastocyste", 5);
		stadeService.createStade("blastocyste", 6);
		stadeService.createStade("blastocyste en pleine expansion", 7);
		stadeService.createStade("blastocyste éclos", 8);
		stadeService.createStade("blastocyste éclos en pleine expansion", 9);
	}
}
