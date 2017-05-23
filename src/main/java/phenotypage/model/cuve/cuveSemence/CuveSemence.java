package phenotypage.model.cuve.cuveSemence;

import phenotypage.model.cuve.Cuve;
import phenotypage.model.cuve.cuveSemence.canisterSemence.CanisterSemence;

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

    public CuveSemence(List<CanisterSemence> canisterList) {
        this.canisterList = canisterList;
    }

    public List<CanisterSemence> getCanisterList() {
        return canisterList;
    }

    public void setCanisterList(List<CanisterSemence> canisterList) {
        this.canisterList = canisterList;
    }
}
