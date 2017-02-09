package phenotypage.model.corpsJaune;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @author fabien
 */

public class CorpsJaunePopulator
{
	@Autowired
	private CorpsJauneService corpsJauneService;

	@PostConstruct
	void init()
	{
	}
}
