package phenotypage.model.cuve.cuveInVivo.canisterInVivo.visoTubeInVivo;

import org.springframework.data.jpa.repository.JpaRepository;
import phenotypage.model.cuve.cuveInVivo.canisterInVivo.visoTubeInVivo.embryonsInVivo.EmbryonsInVivo;

/**
 * Created by Loick on 22/05/2017.
 */
public interface VisoTubeInVivoRepository extends JpaRepository<VisoTubeInVivo, Long> {
    VisoTubeInVivo findByEmbryonsInVivo(EmbryonsInVivo embryonsInVivo);
}
