package phenotypage.model.invitro.collecte;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface Tableau_CollecteRepository extends JpaRepository<Tableau_Collecte, Long>
{
	@Query("select tab_collecte from Tableau_Collecte tab_collecte")
	List<Tableau_Collecte> findAllTableauCollecte();
}
