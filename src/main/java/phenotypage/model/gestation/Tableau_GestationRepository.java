package phenotypage.model.gestation;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface Tableau_GestationRepository extends JpaRepository<Tableau_Gestation, Long>
{
	@Query("select tab_collecte from Tableau_Collecte tab_collecte")
	List<Tableau_Gestation> findAllTableauGestation();
}
