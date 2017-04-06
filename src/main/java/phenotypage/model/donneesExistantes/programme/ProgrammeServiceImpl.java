package phenotypage.model.donneesExistantes.programme;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author fabien
 */

@Component
public class ProgrammeServiceImpl implements ProgrammeService
{
	@Autowired
	private ProgrammeRepository programmeRepository;

	@Override
	public List<Programme> findAllProgramme()
	{
		return programmeRepository.findAll();
	}

	@Override
	public Programme createProgramme(String nom)
	{
		return programmeRepository.save(new Programme());
	}

	@Override
	public Programme addProgramme(Programme programme)
	{
		return programmeRepository.save(programme);
	}

	@Override
	public Programme newProgramme()
	{
		return new Programme();
	}

	@Override
	public Programme findByNom(String s)
	{
		return programmeRepository.findByNom(s);
	}
}
