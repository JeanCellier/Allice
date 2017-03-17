package phenotypage.model.pharmacie.produit;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author fabien
 */

public interface ProduitRepository extends JpaRepository<Produit, Long>
{
	Produit findProduitByNom(String nom);

	Produit findProduitById(Long id);

	List<Produit> findAllByOrderByDateDelivranceDesc();
}
