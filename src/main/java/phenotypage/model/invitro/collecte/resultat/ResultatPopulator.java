package phenotypage.model.invitro.collecte.resultat;

import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;

public class ResultatPopulator
{
	@Autowired
	private ResultatServiceImpl resultatServiceImpl;

	@PostConstruct
	void init()
	{
	}
}
