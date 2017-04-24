package phenotypage.model.typeMethode;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by nicolas on 30/03/17.
 */
@Entity
public class TypeMethode {
    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String nom;

    public TypeMethode() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
}
