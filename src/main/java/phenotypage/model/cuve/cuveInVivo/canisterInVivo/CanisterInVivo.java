package phenotypage.model.cuve.cuveInVivo.canisterInVivo;

import phenotypage.model.cuve.canister.Canister;
import phenotypage.model.cuve.cuveInVivo.canisterInVivo.visoTubeInVivo.VisoTubeInVivo;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by nicolas on 19/05/17.
 */
@Entity
public class CanisterInVivo extends Canister{
    @OneToMany
    private List<VisoTubeInVivo> visoTubeList;

    public List<VisoTubeInVivo> getVisoTubeList() {
        return visoTubeList;
    }

    public CanisterInVivo() {

    }

    public void setVisoTubeList(List<VisoTubeInVivo> visoTubeList) {
        this.visoTubeList = visoTubeList;
    }
}
