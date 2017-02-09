package phenotypage.model.fiche.ficheCol;

import java.util.List;

/**
 * @author fabien
 */
public interface FicheColService
{
	List<FicheCol> findAllFicheCol();

	FicheCol createFicheCol(String nom);

	FicheCol addFicheCol(FicheCol FicheCol);

	FicheCol newFicheCol();

	FicheCol findByNom(String nom);

	long countFicheCol();

	List<FicheCol> findFicheColSNIG();
}
