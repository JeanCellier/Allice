package phenotypage.model.invitro.collecte.tableau_collecte;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface Tableau_CollecteRepository extends JpaRepository<Tableau_Collecte, Long> {
    @Query("select tab_collecte from Tableau_Collecte tab_collecte")
    List<Tableau_Collecte> findAllTableauCollecte();
}
