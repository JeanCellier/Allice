package phenotypage.model.fiches.traitement.header;

import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;

public class HeaderPopulator
{

	@Autowired
	private HeaderServiceImpl headerServiceImpl;

	@PostConstruct
	void init()
	{
	}
}
