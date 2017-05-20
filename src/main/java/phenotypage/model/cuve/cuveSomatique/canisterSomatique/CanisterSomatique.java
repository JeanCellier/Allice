package phenotypage.model.cuve.canister;

import javax.persistence.*;
import java.util.List;

/**
 * Created by nicolas on 19/05/17.
 */
@Entity
public class CanisterSomatique {
    @Id
    @GeneratedValue
    private Long id;

    @Column
    private int numero;

//    @OneToMany
//    private List<VisoTubeSomatique> visoTubeList;
}
