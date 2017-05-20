package phenotypage.model.cuve.canister.visoTube.contenuVisoTube.contenuVIsoTubeSomatique;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

/**
 * Created by nicolas on 19/05/17.
 */
@Entity
public class ContenuVisoTubeSomatique {

    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String type;

    @Column
    private Date dateCong;

    @Column
    private int nbPaillette;

    @Column
    private String couleur;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Date getDateCong() {
        return dateCong;
    }

    public void setDateCong(Date dateCong) {
        this.dateCong = dateCong;
    }

    public int getNbPaillette() {
        return nbPaillette;
    }

    public void setNbPaillette(int nbPaillette) {
        this.nbPaillette = nbPaillette;
    }

    public String getCouleur() {
        return couleur;
    }

    public void setCouleur(String couleur) {
        this.couleur = couleur;
    }
}
