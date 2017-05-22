package phenotypage.model.cuve.cuveInVitro.canisterInVitro.visoTubeInVitro.embryonsInVitro;

import phenotypage.model.cryoconservation.embryon.Embryon;
import phenotypage.model.cuve.cuveSemence.canisterSemence.visoTubeSemence.semence.Semence;
import phenotypage.model.fiche.Fiche;
import phenotypage.model.fiche.ficheCol.FicheCol;

import javax.persistence.*;

/**
 * Created by nicolas on 20/05/17.
 */
@Entity
public class EmbryonsInVitro {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    private Embryon embryon;

    @Column
    private String couleur;

    @ManyToOne
    private Semence semence;

    @Column
    private int nbPaillettes;

    @Column
    private String remarques;

    public EmbryonsInVitro() {    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Embryon getEmbryon() {
        return embryon;
    }

    public void setEmbryon(Embryon embryon) {
        this.embryon = embryon;
    }

    public String getCouleur() {
        return couleur;
    }

    public void setCouleur(String couleur) {
        this.couleur = couleur;
    }

    public Semence getSemence() {
        return semence;
    }

    public void setSemence(Semence semence) {
        this.semence = semence;
    }

    public int getNbPaillettes() {
        return nbPaillettes;
    }

    public void setNbPaillettes(int nbPaillettes) {
        this.nbPaillettes = nbPaillettes;
    }

    public String getRemarques() {
        return remarques;
    }

    public void setRemarques(String remarques) {
        this.remarques = remarques;
    }
}
