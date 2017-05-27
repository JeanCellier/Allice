package phenotypage.model.cuve.cuveSomatique.canisterSomatique;

import phenotypage.model.cuve.canister.Canister;
import phenotypage.model.cuve.cuveSomatique.CuveSomatique;
import phenotypage.model.cuve.cuveSomatique.canisterSomatique.visoTubeSomatique.VisoTubeSomatique;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by nicolas on 19/05/17.
 */
@Entity
public class CanisterSomatique extends Canister{

//    @Id
//    @GeneratedValue
//    private Long id;


//    public CuveSomatique getCuveSomatique() {
//        return cuveSomatique;
//    }
//
//    public void setCuveSomatique(CuveSomatique cuveSomatique) {
//        this.cuveSomatique = cuveSomatique;
//    }

    @OneToMany
    private List<VisoTubeSomatique> visoTubeList= new ArrayList<>();

//    @ManyToOne
//    private CuveSomatique cuveSomatique;

    public CanisterSomatique(List<VisoTubeSomatique> visoTubeList) {
        this.visoTubeList = visoTubeList;
    }

    public CanisterSomatique() {
    }

    public List<VisoTubeSomatique> getVisoTubeList() {
        return visoTubeList;
    }

    public void setVisoTubeList(List<VisoTubeSomatique> visoTubeList) {
        this.visoTubeList = visoTubeList;
    }
}
