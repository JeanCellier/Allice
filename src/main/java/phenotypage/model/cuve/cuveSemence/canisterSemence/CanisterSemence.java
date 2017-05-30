package phenotypage.model.cuve.cuveSemence.canisterSemence;

import phenotypage.model.cuve.canister.Canister;
import phenotypage.model.cuve.cuveSemence.canisterSemence.visoTubeSemence.VisoTubeSemence;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by nicolas on 19/05/17.
 */
@Entity
public class CanisterSemence extends Canister{

    @OneToMany
    private List<VisoTubeSemence> visoTubeList= new ArrayList<>();

    public List<VisoTubeSemence> getVisoTubeList() {
        return visoTubeList;
    }

    public CanisterSemence() {
    }

    public CanisterSemence(List<VisoTubeSemence> visoTubeList) {

        this.visoTubeList = visoTubeList;
    }

    public void setVisoTubeList(List<VisoTubeSemence> visoTubeList) {
        this.visoTubeList = visoTubeList;
    }
}
