package phenotypage.model.cuve.cuveInVivo.canisterInVivo.visoTubeInVivo;

import phenotypage.model.cuve.canister.visoTube.VisoTube;
import phenotypage.model.cuve.cuveInVivo.canisterInVivo.visoTubeInVivo.embryonsInVivo.EmbryonsInVivo;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

/**
 * Created by nicolas on 20/05/17.
 */
@Entity
public class VisoTubeInVivo extends VisoTube {
    @OneToMany
    List<EmbryonsInVivo> embryonsInVivoList;
}
