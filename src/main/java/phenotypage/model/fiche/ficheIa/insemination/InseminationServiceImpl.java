package phenotypage.model.fiche.ficheIa.insemination;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import phenotypage.model.traitementDonneuse.Traitement_Donneuse;

import java.util.Objects;

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

	@Override
	public int determineStatut(Insemination insemination) {
		if(Objects.equals(insemination.getLieuDepot(), "") || insemination.getOperateur() == null || Objects.equals(insemination.getProgression(), "") ||
				insemination.getTaureau() == null || Objects.equals(insemination.getLieuDepot(), "") || Objects.equals(insemination.getCollecte(), "")){
			return 1;
		}

		return 0;
	}
}
