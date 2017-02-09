package phenotypage.model.fiche.ficheCarriere;

import java.util.List;

/**
 * @author fabien
 */
public interface FicheCarriereService
{
	List<FicheCarriere> findAllFicheCarriere();

	FicheCarriere createFichieAba(String nom);

	FicheCarriere addFicheCarriere(FicheCarriere ficheCarriere);

	FicheCarriere newFicheCarriere();

	FicheCarriere findByNom(String nom);

	long countFicheCarriere();
}
