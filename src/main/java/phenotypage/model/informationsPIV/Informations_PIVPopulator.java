package phenotypage.model.informationsPIV;

import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;


public class  Informations_PIVPopulator {

	@Autowired
	private Informations_PIVServiceImpl informations_PIVServiceImpl;
	
	@PostConstruct
	void init()	{
		informations_PIVServiceImpl.createInformations_PIV();
	}
}
