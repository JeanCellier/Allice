package phenotypage.model.donneExistante.qualite;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @author fabien
 */

@Component
public class QualitePopulator
{
	@Autowired
	private QualiteService qualiteService;

	@PostConstruct
	void init()
	{
		qualiteService.createQualite("excellent ou bon", 1);
		qualiteService.createQualite("moyen", 2);
		qualiteService.createQualite("pauvre", 3);
		qualiteService.createQualite("mort ou dégénéré", 4);
	}
}
