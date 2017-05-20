package phenotypage.model.cuve.canister.visoTube;

import phenotypage.model.cuve.canister.visoTube.contenuVisoTube.contenuVIsoTubeSomatique.ContenuVisoTubeSomatique;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.List;

/**
 * Created by nicolas on 19/05/17.
 */
@Entity
public class VisoTubeSomatique {
    @Id
    @GeneratedValue
    private Long id;

//    @Column
//    private List<ContenuVisoTubeSomatique> contenuVisoTube;
}
