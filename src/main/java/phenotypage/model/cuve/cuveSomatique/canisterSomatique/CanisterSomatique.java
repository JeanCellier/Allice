package phenotypage.model.cuve.cuveSomatique.canisterSomatique;

import phenotypage.model.cuve.canister.Canister;
import phenotypage.model.cuve.cuveSomatique.canisterSomatique.visoTubeSomatique.VisoTubeSomatique;

import javax.persistence.*;
import java.util.List;

/**
 * Created by nicolas on 19/05/17.
 */
@Entity
public class CanisterSomatique extends Canister{
    @OneToMany
    private List<VisoTubeSomatique> visoTubeList;

    public CanisterSomatique(List<VisoTubeSomatique> visoTubeList) {
        this.visoTubeList = visoTubeList;
    }

    public CanisterSomatique() {
    }

    public List<VisoTubeSomatique> getVisoTubeList() {
        return visoTubeList;
    }

    public void setVisoTubeList(List<VisoTubeSomatique> visoTubeList) {
        this.visoTubeList = visoTubeList;
    }
}
