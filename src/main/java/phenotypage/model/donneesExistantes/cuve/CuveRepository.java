package phenotypage.model.donneesExistantes.cuve;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @author fabien
 */
public interface CuveRepository extends JpaRepository<Cuve, Long>
{
    @Query(value = "SELECT distinct designation FROM cuve where designation like CONCAT(?1, '%')", nativeQuery = true)
    List<String> findDistinctDestignation(String tag);

    @Query(value = "SELECT distinct nom FROM cuve where nom like CONCAT(?1, '%')", nativeQuery = true)
    List<String> findDistinctNames(String tag);
}
