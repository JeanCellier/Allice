package phenotypage.model.cuve.cuveInVitro.canisterInVitro.visoTubeInVitro;

import phenotypage.model.cuve.canister.visoTube.VisoTube;
import phenotypage.model.cuve.cuveInVitro.canisterInVitro.visoTubeInVitro.embryonsInVitro.EmbryonsInVitro;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.util.List;

/**
 * Created by nicolas on 20/05/17.
 */
@Entity
public class VisoTubeInVitro extends VisoTube {
    @OneToOne
    EmbryonsInVitro embryonsInVitro;

    public EmbryonsInVitro getEmbryonsInVitro() {
        return embryonsInVitro;
    }

    public void setEmbryonsInVitro(EmbryonsInVitro embryonsInVitro) {
        this.embryonsInVitro = embryonsInVitro;
    }

    public VisoTubeInVitro(EmbryonsInVitro embryonsInVitro) {

        this.embryonsInVitro = embryonsInVitro;
    }

    public VisoTubeInVitro() {

    }
}
