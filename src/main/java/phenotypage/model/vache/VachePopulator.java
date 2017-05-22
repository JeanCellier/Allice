package phenotypage.model.vache;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import phenotypage.model.programme.ProgrammeService;

import javax.annotation.PostConstruct;
import java.time.Instant;
import java.util.Date;

/**
 * @author fabien
 */

@Component
public class VachePopulator
{
	@Autowired
	private VacheService vacheService;

	@Autowired
	private ProgrammeService programmeService;

	@PostConstruct
	void init()
	{
		//vacheService.createVache("FR24444444", "4444", 5, new Date(Instant.now()), programmeService.findByNom("Bovomega3"));
	}
}
