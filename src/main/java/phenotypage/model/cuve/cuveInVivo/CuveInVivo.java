package phenotypage.model.cuve.cuveInVivo;

import phenotypage.model.cuve.Cuve;
import phenotypage.model.cuve.cuveInVivo.canisterInVivo.CanisterInVivo;

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

    public CuveInVivo(List<CanisterInVivo> canisterList) {
        this.canisterList = canisterList;
    }

    public List<CanisterInVivo> getCanisterList() {
        return canisterList;
    }

    public void setCanisterList(List<CanisterInVivo> canisterList) {
        this.canisterList = canisterList;
    }
}
