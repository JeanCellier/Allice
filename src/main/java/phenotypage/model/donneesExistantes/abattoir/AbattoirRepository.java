package phenotypage.model.donneesExistantes.abattoir;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author fabien
 */
public interface AbattoirRepository extends JpaRepository<Abattoir, Long>
{
	Abattoir findByNom(String nomAbattoir);
}
