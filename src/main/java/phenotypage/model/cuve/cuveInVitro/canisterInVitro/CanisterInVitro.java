package phenotypage.model.cuve.cuveInVitro.canisterInVitro;

import phenotypage.model.cuve.canister.Canister;
import phenotypage.model.cuve.cuveInVitro.canisterInVitro.visoTubeInVitro.VisoTubeInVitro;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

/**
 * Created by nicolas on 19/05/17.
 */
@Entity
public class CanisterInVitro extends Canister{
    @OneToMany
    private List<VisoTubeInVitro> visoTubeList;

    public List<VisoTubeInVitro> getVisoTubeList() {
        return visoTubeList;
    }

    public CanisterInVitro(List<VisoTubeInVitro> visoTubeList) {
        this.visoTubeList = visoTubeList;
    }

    public CanisterInVitro() {
    }

    public void setVisoTubeList(List<VisoTubeInVitro> visoTubeList) {
        this.visoTubeList = visoTubeList;
    }
}
