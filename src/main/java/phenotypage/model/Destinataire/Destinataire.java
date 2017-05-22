package phenotypage.model.Destinataire;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by Jean on 11/05/2017.
 */
@Entity
public class Destinataire {
    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String nom;

    @Column
    private String typeDestination; // pension,boucherie,autre

    @Column
    private String adresse;

    public Destinataire(){};

    public Destinataire(String nom, String typeDestination, String adresse){
        this.nom = nom;
        this.typeDestination = typeDestination;
        this.adresse = adresse;
    }

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

    public String getTypeDestination() {
        return typeDestination;
    }

    public void setTypeDestination(String typeDestination) {
        this.typeDestination = typeDestination;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }
}
