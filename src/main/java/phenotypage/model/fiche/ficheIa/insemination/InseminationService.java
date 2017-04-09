package phenotypage.model.fiche.ficheIa.insemination;

import java.util.List;

/**
 * @author fabien
 */
public interface InseminationService
{
	List<Insemination> findAllInsemination();

	Insemination createInsemination();

	Insemination addInsemination(Insemination insemination);

	Insemination newInsemination();

	void delete(Insemination inseminationToDelete);
}
