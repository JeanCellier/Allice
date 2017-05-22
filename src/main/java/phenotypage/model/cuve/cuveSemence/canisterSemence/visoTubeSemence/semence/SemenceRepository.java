package phenotypage.model.cuve.cuveSemence.canisterSemence.visoTubeSemence.semence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;
import java.util.Optional;

/**
 * Created by nicolas on 21/05/17.
 */
public interface SemenceRepository extends JpaRepository<Semence, Long> {
    @Query(value = "select num_taureau from semence where right(num_taureau, 4) = ?1", nativeQuery = true)
    List<String> findNumTaureauByNumTaureauLastCharacters(String tag);

    Optional<Semence> findByNumTaureau(String num_identification);
}
