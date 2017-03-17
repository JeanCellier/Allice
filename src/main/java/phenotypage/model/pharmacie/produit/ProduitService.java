package phenotypage.model.pharmacie.produit;

import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * @author fabien
 */
public interface ProduitService
{
	Produit createProduit(String nom, Date dateDel, String fournisseur, String projet, String respo, float qteEntr, String numLot, Date datePer);

	Produit save(Produit produit);

	List<Produit> findAllProduit();

	Produit findProduitByNom(String nom);

	void updateProduit(Produit produit);

	Produit newProduit();

	Produit findProduitById(Long id);

	List<Produit> findAllByOrderByDateDelivranceDesc();

    void delete(Produit produit);

	Optional<Produit> findOne(long id);

	void update(Produit produit, String nom, Date dateDeliv, String fournisseur, String projet, String respo, float qteEntrante, float qteRestante, String numLot, Date datePeremp);
}
