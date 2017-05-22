package phenotypage.model.cuve.cuveSomatique;

import phenotypage.model.cuve.Cuve;
import phenotypage.model.cuve.cuveSomatique.canisterSomatique.CanisterSomatique;

import javax.persistence.*;
import java.util.List;

/**
 * Created by nicolas on 19/05/17.
 */
@Entity
public class CuveSomatique extends Cuve {
    @OneToMany
    private List<CanisterSomatique> canisterList;

    public CuveSomatique() {
        super();
    }

    public List<CanisterSomatique> getCanisterList() {
        return canisterList;
    }

    public void setCanisterList(List<CanisterSomatique> canisterList) {
        this.canisterList = canisterList;
    }
}
