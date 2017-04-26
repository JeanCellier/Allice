package phenotypage.model.programme;

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
	public List<Programme> findAll()
	{
		return programmeRepository.findAll();
	}

	@Override
	public Programme createProgramme(String nom)
	{
		Programme programme = new Programme();
		programme.setNom(nom);
		return programmeRepository.save(programme);
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