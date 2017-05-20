package phenotypage.model.cuve.cuveInVivo;

import phenotypage.model.cuve.Cuve;
import phenotypage.model.cuve.cuveInVivo.canisterSemence.CanisterSemence;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

/**
 * Created by nicolas on 19/05/17.
 */
@Entity
public class CuveSemence extends Cuve {
    @OneToMany
    private List<CanisterSemence> canisterList;

    public CuveSemence() {
        super();
    }

    public List<CanisterSemence> getCanisterList() {
        return canisterList;
    }

    public void setCanisterList(List<CanisterSemence> canisterList) {
        this.canisterList = canisterList;
    }
}
