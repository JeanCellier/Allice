package phenotypage.model.cuve.cuveInVitro;

import phenotypage.model.cuve.Cuve;
import phenotypage.model.cuve.cuveInVitro.canisterInVivo.CanisterInVivo;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

/**
 * Created by nicolas on 19/05/17.
 */
@Entity
public class CuveInVivo extends Cuve {
    @OneToMany
    private List<CanisterInVivo> canisterList;

    public CuveInVivo() {
        super();
    }

    public List<CanisterInVivo> getCanisterList() {
        return canisterList;
    }

    public void setCanisterList(List<CanisterInVivo> canisterList) {
        this.canisterList = canisterList;
    }
}
