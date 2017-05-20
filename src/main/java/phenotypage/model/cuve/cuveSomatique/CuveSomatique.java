package phenotypage.model.cuve;

import phenotypage.model.cuve.canister.CanisterSomatique;

import javax.persistence.*;
import java.util.List;

/**
 * Created by nicolas on 19/05/17.
 */
@Entity
public class CuveSomatique extends Cuve{
    @OneToMany
    private List<CanisterSomatique> canisterList;

    public List<CanisterSomatique> getCanisterList() {
        return canisterList;
    }

    public void setCanisterList(List<CanisterSomatique> canisterList) {
        this.canisterList = canisterList;
    }
}
