package phenotypage.model.fiche.ficheTra;

import java.util.List;

/**
 * @author fabien
 */
public interface FicheTraService
{
	List<FicheTra> findAllFicheTra();

	FicheTra createFichieTra(String nom);

	FicheTra addFicheTra(FicheTra fichieTra);

	FicheTra newFicheTra();

	FicheTra findByNom(String nom);

	long countFicheTra();
}
