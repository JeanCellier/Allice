package phenotypage.model.fiche.ficheCol;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import phenotypage.model.fiche.ficheAba.FicheAba;

import java.util.List;

/**
 * @author fabien
 */
public interface FicheColRepository extends JpaRepository<FicheCol, Long>
{
	FicheCol findByNom(String nom);

	@Query("select f from FicheCol f where f.snig = true")
	List<FicheCol> findFicheColSNIG();
}
