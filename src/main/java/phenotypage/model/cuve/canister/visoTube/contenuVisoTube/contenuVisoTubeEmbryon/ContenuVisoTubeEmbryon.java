package phenotypage.model.cuve.canister.visoTube.contenuVisoTube.contenuVisoTubeEmbryon;

import phenotypage.model.fiche.Fiche;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.List;

/**
 * Created by nicolas on 19/05/17.
 */

@Entity
public class ContenuVisoTubeEmbryon {

    @Id
    @GeneratedValue
    private Long id;

//    @Column
//    List<Fiche> manipList;

    @Column
    String remarques;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

//    public List<Fiche> getManipList() {
//        return manipList;
//    }
//
//    public void setManipList(List<Fiche> manipList) {
//        this.manipList = manipList;
//    }

    public String getRemarques() {
        return remarques;
    }

    public void setRemarques(String remarques) {
        this.remarques = remarques;
    }
}
