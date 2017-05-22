package phenotypage.model.cuve.cuveInVitro.canisterInVitro.visoTubeInVitro;

import phenotypage.model.cuve.canister.visoTube.VisoTube;
import phenotypage.model.cuve.cuveInVitro.canisterInVitro.visoTubeInVitro.embryonsInVitro.EmbryonsInVitro;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

/**
 * Created by nicolas on 20/05/17.
 */
@Entity
public class VisoTubeInVitro extends VisoTube {
    @OneToMany
    List<EmbryonsInVitro> embryonsInVitroList;

    public VisoTubeInVitro(List<EmbryonsInVitro> embryonsInVitroList) {
        this.embryonsInVitroList = embryonsInVitroList;
    }

    public VisoTubeInVitro() {

    }
}
