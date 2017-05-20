package phenotypage.model.destionationCulture;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author fabien
 */

public interface DestinationCultureRepository extends JpaRepository<DestinationCulture, Long>
{
	DestinationCulture findByNom(String destination);
}
