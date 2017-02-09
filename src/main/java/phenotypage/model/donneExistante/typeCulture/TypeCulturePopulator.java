package phenotypage.model.donneExistante.typeCulture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @author fabien
 */

@Component
public class TypeCulturePopulator
{
	@Autowired
	private TypeCultureService typeCultureService;

	@PostConstruct
	void init()
	{
		typeCultureService.createTypeCulture("SOF complet", "803306067");
		typeCultureService.createTypeCulture("SOF Métamorphe", "15-344");
		typeCultureService.createTypeCulture("SOF Stem-Alpha", "R9011");
	}
}
