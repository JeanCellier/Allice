package phenotypage.model.vache;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @author fabien
 */

public interface VacheRepository extends JpaRepository<Vache, Long>
{
	@Query("select t from Vache t where t.male = true")
	List<Vache> findAllTaureau();

	@Query("select t from Vache t where t.num_identification = ?1")
	Vache findBynum_identification(String num_identification);
}
