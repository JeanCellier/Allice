package phenotypage.model.donneesExistantes.destionationCulture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @author fabien
 */

@Component
public class DestinationCulturePopulator
{
	@Autowired
	private DestinationCultureService destinationCultureService;

	@PostConstruct
	void init()
	{
		destinationCultureService.createDestinationCulture("Frais");
		destinationCultureService.createDestinationCulture("Detruit");
		destinationCultureService.createDestinationCulture("Cryo");
	}
}
