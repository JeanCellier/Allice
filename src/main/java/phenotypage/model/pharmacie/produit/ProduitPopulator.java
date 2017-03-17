package phenotypage.model.pharmacie.produit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Calendar;

/**
 * @author fabien
 */
@Component
public class ProduitPopulator
{
	@Autowired
	private ProduitService produitService;

	@PostConstruct
	void init()
	{
		/*Produit produit = new Produit();
		produit.setNom("lol");
		produit.setDateDelivrance(Calendar.getInstance().getTime());
		produit.setFournisseur("xd");
		produit.setProjet("peoeo");
		produit.setResponsable("eeree");
		produit.setQteEntrante(5);
		produit.setNumLot("erere");
		produit.setDatePeremption(Calendar.getInstance().getTime());

		produitService.createProduit(produit);*/
	}
}
