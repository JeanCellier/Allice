package phenotypage.model.cryoconservation.congelateur;

import java.util.List;

/**
 * @author fabien
 */
public interface CongelateurService
{
	List<Congelateur> findAllCongelateur();

	Congelateur createCongelateur(String nom);

	Congelateur addCongelateur(Congelateur congelateur);

	Congelateur newCongelateur();
}
