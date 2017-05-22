package phenotypage.model.cuve.cuveInVitro;

import phenotypage.model.cuve.Cuve;
import phenotypage.model.cuve.cuveInVitro.canisterInVitro.CanisterInVitro;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

/**
 * Created by nicolas on 19/05/17.
 */
@Entity
public class CuveInVitro extends Cuve {
    @OneToMany
    private List<CanisterInVitro> canisterList;

    public CuveInVitro() {
        super();
    }

    public List<CanisterInVitro> getCanisterList() {
        return canisterList;
    }

    public void setCanisterList(List<CanisterInVitro> canisterList) {
        this.canisterList = canisterList;
    }
}
