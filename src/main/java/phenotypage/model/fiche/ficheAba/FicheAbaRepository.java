package phenotypage.model.fiche.ficheAba;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @author fabien
 */
public interface FicheAbaRepository extends JpaRepository<FicheAba, Long>
{
	FicheAba findByNom(String nom);
}
