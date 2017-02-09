package phenotypage.model.pharmacie.produit;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author fabien
 */

public interface ProduitRepository extends JpaRepository<Produit, Long>
{
	Produit findProduitByNom(String nom);

	Produit findProduitById(Long id);
}
