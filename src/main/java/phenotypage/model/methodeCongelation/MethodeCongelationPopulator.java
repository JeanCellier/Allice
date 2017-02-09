package phenotypage.model.methodeCongelation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @author fabien
 */

@Component
public class MethodeCongelationPopulator
{
	@Autowired
	private MethodeCongelationService methodeCongelationService;

	@PostConstruct
	void init()
	{
		methodeCongelationService.createMethodeCongelation("Congelation");
		methodeCongelationService.createMethodeCongelation("Vitrification");
	}
}
