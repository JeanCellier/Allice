package phenotypage.model.fiche.ficheIa.insemination;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author fabien
 */

@Component
public class InseminationServiceImpl implements InseminationService
{
	@Autowired
	private InseminationRepository inseminationRepository;

	@Override
	public List<Insemination> findAllInsemination()
	{
		return inseminationRepository.findAll();
	}

	@Override
	public Insemination createInsemination()
	{
		return inseminationRepository.save(new Insemination());
	}

	@Override
	public Insemination addInsemination(Insemination insemination)
	{
		return inseminationRepository.save(insemination);
	}

	@Override
	public Insemination newInsemination()
	{
		return new Insemination();
	}

	@Override
	public void delete(Insemination inseminationToDelete)
	{
		inseminationRepository.delete(inseminationToDelete);
	}
}
