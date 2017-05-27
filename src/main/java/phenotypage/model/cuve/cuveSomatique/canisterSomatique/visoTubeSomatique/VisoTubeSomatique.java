package phenotypage.model.cuve.cuveSomatique.canisterSomatique.visoTubeSomatique;

import phenotypage.model.cuve.canister.visoTube.VisoTube;
import phenotypage.model.cuve.cuveSomatique.canisterSomatique.CanisterSomatique;
import phenotypage.model.cuve.cuveSomatique.canisterSomatique.visoTubeSomatique.celluleSomatique.CelluleSomatique;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by nicolas on 20/05/17.
 */
@Entity
public class VisoTubeSomatique extends VisoTube {

    public VisoTubeSomatique(CelluleSomatique celluleSomatique) {
        this.celluleSomatique = celluleSomatique;
    }

//    public List<CelluleSomatique> getCelluleSomatiqueList() {
//        return celluleSomatiqueList;
//    }

//    public void setCelluleSomatiqueList(CelluleSomatique celluleSomatique) {
//        this.celluleSomatique = celluleSomatique;
//    }

//    public CanisterSomatique getCanisterSomatique() {
//        return canisterSomatique;
//    }
//
//    public void setCanisterSomatique(CanisterSomatique canisterSomatique) {
//        this.canisterSomatique = canisterSomatique;
//    }

    public CelluleSomatique getCelluleSomatique() {
        return celluleSomatique;
    }

    public void setCelluleSomatique(CelluleSomatique celluleSomatique) {
        this.celluleSomatique = celluleSomatique;
    }

    public VisoTubeSomatique() {

    }

//    @OneToMany(mappedBy = "visoTubeSomatique")
//    private List<CelluleSomatique> celluleSomatiqueList = new ArrayList<>();

    @OneToOne
    private CelluleSomatique celluleSomatique;

//    @ManyToOne
//    private CanisterSomatique canisterSomatique;
}
