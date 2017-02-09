package phenotypage.model.fiche.ficheOpu;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import phenotypage.model.fiche.ficheAba.FicheAba;

import java.util.List;

/**
 * @author fabien
 */
public interface FicheOpuRepository extends JpaRepository<FicheOpu, Long>
{
	FicheOpu findByNom(String nom);

	@Query("select f from FicheOpu f where f.snig = true")
	List<FicheOpu> findFicheOpuSNIG();
}
