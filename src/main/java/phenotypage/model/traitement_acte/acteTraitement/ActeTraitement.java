package phenotypage.model.traitement_acte.acteTraitement;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by nicolas on 24/05/17.
 */
@Entity
public class ActeTraitement {
    @Id
    @GeneratedValue
    private Long id;

    @Column
    private int decalageJour;

    @Column
    private float decalageHeure;

    @Column
    private String acte;

    public ActeTraitement() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getDecalageJour() {
        return decalageJour;
    }

    public void setDecalageJour(int decalageJour) {
        this.decalageJour = decalageJour;
    }

    public float getDecalageHeure() {
        return decalageHeure;
    }

    public void setDecalageHeure(float decalageHeure) {
        this.decalageHeure = decalageHeure;
    }

    public String getActe() {
        return acte;
    }

    public void setActe(String acte) {
        this.acte = acte;
    }
}
