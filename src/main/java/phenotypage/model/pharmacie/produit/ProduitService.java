package phenotypage.model.pharmacie.produit;

import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * @author fabien
 */
public interface ProduitService
{
	List<Produit> findAll();

	Produit createProduit(String nom, Date dateDel, String fournisseur, String projet, String respo, float qteEntr, String numLot, Date datePer, String indication);

	void update(Produit produit, String nom, Date dateDeliv, String fournisseur, String projet, String respo, float qteEntrante, float qteRestante, String numLot, Date datePeremp, String indication);

	Produit save(Produit produit);

	void delete(Produit produit);

	Optional<Produit> findOne(long id);

	List<Produit> findAvalaibleProduct();

	List<Produit> findOutOfStockProduct();

	List<String> findDistinctNames(String tag);

	List<String> findDistinctFournisseurs(String tag);

	List<String> findDistinctProjets(String tag);

	List<String> findDistinctResponsables(String tag);
}
