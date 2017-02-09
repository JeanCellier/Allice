package phenotypage.model.fiche.ficheCarriere;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * @author fabien
 */
public interface FicheCarriereRepository extends JpaRepository<FicheCarriere, Long>
{
	FicheCarriere findByNom(String nom);
}
