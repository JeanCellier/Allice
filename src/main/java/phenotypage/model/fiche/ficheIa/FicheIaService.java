package phenotypage.model.fiche.ficheIa;

import java.util.List;

/**
 * @author fabien
 */
public interface FicheIaService
{
	List<FicheIa> findAllFicheIa();

	FicheIa createFichieIa(String nom);

	FicheIa addFicheIa(FicheIa fichieIa);

	FicheIa newFicheIa();

	FicheIa findByNom(String nom);

	long countFicheIa();
}
