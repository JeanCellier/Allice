package phenotypage.model.invitro.collecte;

import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;

public class CollectePopulator
{
	@Autowired
	private CollecteServiceImpl collecteServiceImpl;

	@PostConstruct
	void init()
	{
	}
}
