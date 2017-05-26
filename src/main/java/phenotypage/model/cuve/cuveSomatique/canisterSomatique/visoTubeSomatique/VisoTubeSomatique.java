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
//    @Id
//    @GeneratedValue
//    private Long id;

    public VisoTubeSomatique(List<CelluleSomatique> celluleSomatiqueList) {
        this.celluleSomatiqueList = celluleSomatiqueList;
    }

    public List<CelluleSomatique> getCelluleSomatiqueList() {
        return celluleSomatiqueList;
    }

    public void setCelluleSomatiqueList(List<CelluleSomatique> celluleSomatiqueList) {
        this.celluleSomatiqueList = celluleSomatiqueList;
    }

    public CanisterSomatique getCanisterSomatique() {
        return canisterSomatique;
    }

    public void setCanisterSomatique(CanisterSomatique canisterSomatique) {
        this.canisterSomatique = canisterSomatique;
    }

    public VisoTubeSomatique() {
    }

    @OneToMany(mappedBy = "visoTubeSomatique")
    private List<CelluleSomatique> celluleSomatiqueList = new ArrayList<>();

    @ManyToOne
    private CanisterSomatique canisterSomatique;
}
