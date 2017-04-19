package phenotypage.model.donneesExistantes.sanitaire;

import java.util.List;

/**
 * @author fabien
 */
public interface SanitaireService
{
	List<Sanitaire> findAllSanitaire();

	Sanitaire createSanitaire(String nom);

	Sanitaire addSanitaire(Sanitaire sanitaire);

	Sanitaire newSanitaire();
}