package phenotypage.model.cuve.cuveSemenceFIV.canisterSemenceFIV.visoTubeSemenceFIV.semenceFIV;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

/**
 * Created by Loick on 27/05/2017.
 */
public interface SemenceFIVRepository extends JpaRepository<SemenceFIV, Long>  {

    @Query(value = "select num_taureau from semence where right(num_taureau, 4) = ?1", nativeQuery = true)
    List<String> findNumTaureauByNumTaureauLastCharacters(String tag);

    Optional<SemenceFIV> findByNumTaureau(String num_identification);
}
