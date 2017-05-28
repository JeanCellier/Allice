package phenotypage.model.cuve.cuveSemenceFIV.canisterSemenceFIV;

import phenotypage.model.cuve.canister.Canister;
import phenotypage.model.cuve.cuveSemenceFIV.canisterSemenceFIV.visoTubeSemenceFIV.VisoTubeSemenceFIV;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Loick on 27/05/2017.
 */
@Entity
public class CanisterSemenceFIV extends Canister{

    @OneToMany
    private List<VisoTubeSemenceFIV> visoTubeList= new ArrayList<>();

    public List<VisoTubeSemenceFIV> getVisoTubeList() {
        return visoTubeList;
    }

    public CanisterSemenceFIV() {
    }

    public CanisterSemenceFIV(List<VisoTubeSemenceFIV> visoTubeList) {

        this.visoTubeList = visoTubeList;
    }

    public void setVisoTubeList(List<VisoTubeSemenceFIV> visoTubeList) {
        this.visoTubeList = visoTubeList;
    }

}
