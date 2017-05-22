package phenotypage.model.fiche.ficheAba.abattoir;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * @author fabien
 */
public interface AbattoirRepository extends JpaRepository<Abattoir, Long>
{
	@Query("select t from Abattoir t where t.nom = ?2")
	Abattoir findByNom(String nomAbattoir);
}
