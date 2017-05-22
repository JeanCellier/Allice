package phenotypage.model.pharmacie.produit;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @author fabien
 */

public interface ProduitRepository extends JpaRepository<Produit, Long>
{
	@Query(value = "SELECT distinct nom FROM produit where nom like CONCAT(?1, '%')", nativeQuery = true)
	List<String> findDistinctNames(String tag);

	@Query(value = "SELECT distinct fournisseur FROM produit where fournisseur like CONCAT(?1, '%')", nativeQuery = true)
	List<String> findDistinctFournisseurs(String tag);

	@Query(value = "SELECT distinct projet FROM produit where projet like CONCAT(?1, '%')", nativeQuery = true)
	List<String> findDistinctProjets(String tag);

	@Query(value = "SELECT distinct responsable FROM produit where responsable like CONCAT(?1, '%')", nativeQuery = true)
	List<String> findDistinctResponsables(String tag);

	List<Produit> findByQteRestanteGreaterThan(float i);

	List<Produit> findByQteRestanteEquals(float i);
}
