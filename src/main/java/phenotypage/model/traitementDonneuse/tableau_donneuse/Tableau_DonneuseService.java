package phenotypage.model.traitementDonneuse.tableau_donneuse;

import phenotypage.model.pharmacie.produit.Produit;

import java.util.Date;

/**
 * @author fabien
 */
public interface Tableau_DonneuseService
{
	Tableau_Donneuse createTableauDOnneuse(Date date, Produit produit, int quantite, String mode_traitement);

	Tableau_Donneuse save(Tableau_Donneuse tableau_Donneuse);
}
