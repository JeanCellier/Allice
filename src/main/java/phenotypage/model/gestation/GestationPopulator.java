package phenotypage.model.gestation;

import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;

public class GestationPopulator
{
	@Autowired
	private GestationServiceImpl gestationServiceImpl;

	@PostConstruct
	void init()
	{
	}
}
