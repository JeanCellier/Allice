package phenotypage.model.fiche.ficheTra;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import phenotypage.model.fiche.ficheAba.FicheAba;

import java.util.List;

/**
 * @author fabien
 */
public interface FicheTraRepository extends JpaRepository<FicheTra, Long>
{
	FicheTra findByNom(String nom);

    FicheTra findTopByOrderByNomDesc();
}
