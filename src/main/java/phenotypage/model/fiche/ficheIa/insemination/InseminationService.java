package phenotypage.model.fiche.ficheIa.insemination;

import phenotypage.model.traitementDonneuse.Traitement_Donneuse;

/**
 * @author fabien
 */
public interface InseminationService
{
	Insemination createInsemination(Insemination insemination);

	void delete(Insemination inseminationToDelete);

	Insemination save(Insemination insemination);

    Insemination updateInsemination(Insemination insemination);

	int determineStatut(Insemination insemination);
}
