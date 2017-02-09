package phenotypage.model.fiche.ficheOpu;

import java.util.List;

/**
 * @author fabien
 */
public interface FicheOpuService
{
	List<FicheOpu> findAllFicheOpu();

	FicheOpu createFichieOpu(String nom);

	FicheOpu addFicheOpu(FicheOpu fichieOpu);

	FicheOpu newFicheOpu();

	FicheOpu findByNom(String nom);

	long countFicheOpu();

	List<FicheOpu> findFicheOpuSNIG();
}
