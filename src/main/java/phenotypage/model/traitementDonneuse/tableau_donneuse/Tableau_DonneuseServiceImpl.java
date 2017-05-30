package phenotypage.model.traitementDonneuse.tableau_donneuse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import phenotypage.model.pharmacie.produit.Produit;
import java.util.Date;


/**
 * @author fabien
 */

@Component
public class Tableau_DonneuseServiceImpl implements Tableau_DonneuseService
{
	@Autowired
	private Tableau_DonneuseRepository repository;

	@Override
	public Tableau_Donneuse createTableauDonneuse(Date date, Produit produit, float quantite, String mode_traitement) {
		Tableau_Donneuse tableauDonneuse = new Tableau_Donneuse();
		tableauDonneuse.setDate(date);
		tableauDonneuse.setProduit(produit);
		tableauDonneuse.setQuantite(quantite);
		tableauDonneuse.setMode_traitement(mode_traitement);

		return save(tableauDonneuse);
	}

	@Override
	public Tableau_Donneuse save(Tableau_Donneuse tableau_Donneuse) {
		return repository.save(tableau_Donneuse);
	}
}
