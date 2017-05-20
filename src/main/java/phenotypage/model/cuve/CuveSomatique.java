package phenotypage.model.cuve;

import javax.persistence.*;
import java.util.List;

/**
 * Created by nicolas on 19/05/17.
 */
@Entity
public class CuveSomatique {
    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String nom;

//    @OneToMany
//    private List<CanisterSomatique> canisterList;
}
