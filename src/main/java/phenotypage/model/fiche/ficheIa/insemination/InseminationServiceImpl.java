package phenotypage.model.fiche.ficheIa.insemination;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author fabien
 */

@Component
public class InseminationServiceImpl implements InseminationService
{
	@Autowired
	private InseminationRepository repository;

	@Override
	public Insemination createInsemination(Insemination insemination) {
		return save(insemination);
	}

	@Override
	public void delete(Insemination inseminationToDelete)
	{
		repository.delete(inseminationToDelete);
	}

	@Override
	public Insemination save(Insemination insemination) {
		return repository.save(insemination);
	}

	@Override
	public Insemination updateInsemination(Insemination insemination) {
		return save(insemination);
	}
}
