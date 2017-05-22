package phenotypage.model.traitement_acte.tableau_traitement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import phenotypage.model.pharmacie.produit.Produit;


/**
 * @author fabien
 */

@Component
public class Tableau_TraitementActeServiceImpl implements Tableau_Traitement_ActeService
{
	@Autowired
	private Tableau_Traitement_ActeRepository repository;

	@Override
	public Tableau_Traitement_Acte createTableauTraitement(int decalageJour, float decalageHeure, Produit produit, int quantite, String mode_traitement) {
		Tableau_Traitement_Acte tableauTraitement = new Tableau_Traitement_Acte();
		tableauTraitement.setDecalageJour(decalageJour);
		tableauTraitement.setDecalageHeure(decalageHeure);
		tableauTraitement.setProduit(produit);
		tableauTraitement.setQuantite(quantite);
		tableauTraitement.setMode_traitement(mode_traitement);

		return save(tableauTraitement);
	}

	@Override
	public Tableau_Traitement_Acte save(Tableau_Traitement_Acte tableau_TraitementActe) {
		return repository.save(tableau_TraitementActe);
	}

	@Override
	public void delete(Tableau_Traitement_Acte tableau_traitement_acte) {
		repository.delete(tableau_traitement_acte);
	}
}
