package phenotypage.model.fiche.ficheIa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import phenotypage.model.fiche.ficheAba.FicheAba;

import java.util.List;

/**
 * @author fabien
 */
public interface FicheIaRepository extends JpaRepository<FicheIa, Long>
{
	FicheIa findByNom(String nom);

    FicheIa findTopByOrderByNomDesc();
}
