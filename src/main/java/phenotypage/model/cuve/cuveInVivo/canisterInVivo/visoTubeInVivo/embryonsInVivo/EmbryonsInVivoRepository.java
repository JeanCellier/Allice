package phenotypage.model.cuve.cuveInVivo.canisterInVivo.visoTubeInVivo.embryonsInVivo;

import org.springframework.data.jpa.repository.JpaRepository;
import phenotypage.model.cryoconservation.embryon.Embryon;

import java.util.Optional;

/**
 * Created by Loick on 22/05/2017.
 */
public interface EmbryonsInVivoRepository extends JpaRepository<EmbryonsInVivo, Long> {
    Optional<EmbryonsInVivo> findByEmbryon(Embryon embryon);
}
