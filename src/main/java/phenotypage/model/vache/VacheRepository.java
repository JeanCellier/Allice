package phenotypage.model.vache;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @author fabien
 */

public interface VacheRepository extends JpaRepository<Vache, Long>
{
	@Query("select t from Vache t where t.num_identification = ?1")
	Vache findBynum_identification(String num_identification);

	@Query(value = "select num_identification from vache where right(num_identification, 4) = ?1", nativeQuery = true)
    List<String> findNumIdByNumTravail(String tag);
}
