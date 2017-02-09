package phenotypage.model.donneExistante.programme;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @author fabien
 */

@Component
public class ProgrammePopulator
{
	@Autowired
	private ProgrammeService programmeService;

	@PostConstruct
	void init()
	{
		programmeService.createProgramme("BOVANO");
		programmeService.createProgramme("BOVOMEGA 3");
		programmeService.createProgramme("EMBRYOMIMETISME");
		programmeService.createProgramme("FECUND");
		programmeService.createProgramme("FSHr");
		programmeService.createProgramme("MAXY puberté");
		programmeService.createProgramme("METAMORPHE");
		programmeService.createProgramme("PROLIFIC");
		programmeService.createProgramme("SPERMATER");
		programmeService.createProgramme("VALOPROT");
	}
}
