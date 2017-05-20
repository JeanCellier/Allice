package phenotypage.model.cuve;

import javax.persistence.*;

/**
 * Created by nicolas on 19/05/17.
 */
@Entity
public class CuveInVivo {
    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String nom;
//
//    @OneToMany
//    private List<CanisterInVivo> canisterList;
}
