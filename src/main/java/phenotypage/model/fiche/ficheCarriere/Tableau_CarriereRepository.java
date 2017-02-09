package phenotypage.model.fiche.ficheCarriere;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface Tableau_CarriereRepository extends JpaRepository<Tableau_Carriere, Long>
{
	@Query("select tab_collecte from Tableau_Collecte tab_collecte")
	List<Tableau_Carriere> findAllTableauCarriere();
}
