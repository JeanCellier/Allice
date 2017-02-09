package phenotypage.model.insemination;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @author fabien
 */

@Component
public class InseminationPopulator
{
	@Autowired
	private InseminationService inseminationService;

	@PostConstruct
	void init()
	{
	}
}
