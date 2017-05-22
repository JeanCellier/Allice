package phenotypage.model.fiche.ficheAba.abattoir;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author fabien
 */
public interface AbattoirRepository extends JpaRepository<Abattoir, Long>
{
	Abattoir findByNom(String nomAbattoir);
}
