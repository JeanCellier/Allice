package phenotypage.model.donneesExistantes.fiv;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @author fabien
 */

@Component
public class FIVPopulator
{
	@Autowired
	private FIVService fivService;

	@PostConstruct
	void init()
	{
		fivService.createFIV("Fert TALP labo", "07/03/16");
		fivService.createFIV("Fert TALP Métamorphe", "16-042");
	}
}
