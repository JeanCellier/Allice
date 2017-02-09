package phenotypage.model.cryoconservation;

import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;

public class CryoconservationPopulator
{
	@Autowired
	private CryoconservationService cryoconservationService;

	@PostConstruct
	void init()
	{
	}
}
