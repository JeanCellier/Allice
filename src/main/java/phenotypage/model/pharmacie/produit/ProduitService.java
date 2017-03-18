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

	void update(Produit produit, String nom, Date dateDeliv, String fournisseur, String projet, String respo, float qteEntrante, float qteRestante, String numLot, Date datePeremp);

	void updateProduit(Produit produit);

	Produit save(Produit produit);

	void delete(Produit produit);

	List<Produit> findAllProduit();

	Optional<Produit> findOne(long id);

	List<String> findDistinctNames(String tag);

	List<String> findDistinctFournisseurs(String tag);

	List<String> findDistinctProjets(String tag);

	List<String> findDistinctResponsables(String tag);
}
