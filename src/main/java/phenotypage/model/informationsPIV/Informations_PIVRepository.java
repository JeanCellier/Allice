package phenotypage.model.informationsPIV;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface Informations_PIVRepository extends JpaRepository<Informations_PIV, Long>
{
	@Query("select info from Informations_PIV info")
	List<Informations_PIV> findAllInformations_PIV();
}
