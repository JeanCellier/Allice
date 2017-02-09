package phenotypage.model.traitementDonneuse;

import java.util.List;

/**
 * @author fabien
 */
public interface Traitement_DonneuseService
{
	Traitement_Donneuse createTraitement_Donneuse();

	Traitement_Donneuse addTraitement_Donneuse(Traitement_Donneuse traitement_donneuse);

	List<Traitement_Donneuse> findAllTraitement_Donneuse();

	Traitement_Donneuse findTraitement_DonneuseById(long id);

	Traitement_Donneuse newTraitementDonneuse();

	void delete(Traitement_Donneuse traitement_donneuse);
}
