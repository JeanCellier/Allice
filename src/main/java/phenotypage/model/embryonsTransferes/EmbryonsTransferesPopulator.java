package phenotypage.model.embryonsTransferes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @author fabien
 */

@Component
public class EmbryonsTransferesPopulator
{
	@Autowired
	private EmbryonsTransferesService embryonsTransferesService;

	@PostConstruct
	void init()
	{
		embryonsTransferesService.createEmbryonsTransferes();
	}
}
