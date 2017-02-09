package phenotypage.model.pharmacie.produit;

import java.util.Date;
import java.util.List;

/**
 * @author fabien
 */
public interface ProduitService
{
	Produit createProduit(String nom, Date date_delivrance, String fournisseur, String projet, String responsable,
	                      float qte_entrante, float qte_restante, String num_lot, Date date_peremption, String indication);

	Produit addProduit(Produit produit);

	List<Produit> findAllProduit();

	Produit findProduitByNom(String nom);

	void updateProduit(Produit produit);

	Produit newProduit();

	Produit findProduitById(Long id);
}
