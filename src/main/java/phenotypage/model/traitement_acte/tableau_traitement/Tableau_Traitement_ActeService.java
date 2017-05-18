package phenotypage.model.traitement_acte.tableau_traitement;

import phenotypage.model.pharmacie.produit.Produit;

/**
 * @author fabien
 */
public interface Tableau_Traitement_ActeService
{
	Tableau_Traitement_Acte createTableauTraitement(int decalageJour, int decalageHeure, Produit produit, int quantite, String mode_traitement);

	Tableau_Traitement_Acte save(Tableau_Traitement_Acte tableau_TraitementActe);

	void delete(Tableau_Traitement_Acte tableau_traitement_acte);
}
