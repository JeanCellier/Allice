package phenotypage.model.invitro.culture;

import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;

public class CulturePopulator
{
	@Autowired
	private CultureServiceImpl cultureServiceImpl;

	@PostConstruct
	void init()
	{
	}
}
