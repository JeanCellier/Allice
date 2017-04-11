package phenotypage.model.fiche.ficheIa.insemination;

/**
 * @author fabien
 */
public interface InseminationService
{
	Insemination createInsemination(Insemination insemination);

	void delete(Insemination inseminationToDelete);

	Insemination save(Insemination insemination);

    Insemination updateInsemination(Insemination insemination);
}
