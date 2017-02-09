package phenotypage.model.invitro.collecte;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface CollecteRepository extends JpaRepository<Collecte, Long>
{
	@Query("select collecte from Collecte collecte")
	List<Collecte> findAllCollecte();
}
