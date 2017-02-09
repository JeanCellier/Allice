package phenotypage.model.milieuMaturation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @author fabien
 */

@Component
public class MilieuMaturationPopulator
{
	@Autowired
	private MilieuMaturationService milieuMaturationService;

	@PostConstruct
	void inti()
	{
		milieuMaturationService.createMilieuMaturation("TCM 199", "RNBD9932");
		milieuMaturationService.createMilieuMaturation("TCM 199 Hepes", "RNBF0713");
		milieuMaturationService.createMilieuMaturation("Stem Alpha Hepes", "R1991");
	}
}
