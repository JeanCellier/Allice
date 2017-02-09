package phenotypage.model.invitro.fecondation;

import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;

public class FecondationPopulator
{
	@Autowired
	private FecondationServiceImpl fecondationServiceImpl;

	@PostConstruct
	void init()
	{
	}

}
