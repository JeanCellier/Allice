package phenotypage.model.cuve.cuveInVivo.canisterInVivo.visoTubeInVivo.embryonsInVivo;

import phenotypage.model.cryoconservation.embryon.Embryon;
import phenotypage.model.cuve.cuveSemence.canisterSemence.visoTubeSemence.semence.Semence;
import javax.persistence.*;

/**
 * Created by nicolas on 20/05/17.
 */
@Entity
public class EmbryonsInVivo {
    @Id
    @GeneratedValue
    private Long id;

    @OneToOne
    private Embryon embryon;

    @Column
    private String couleur;

    @ManyToOne
    private Semence semence;

    public EmbryonsInVivo(Embryon embryon, String couleur, Semence semence, String biopsie, String remarques) {
        this.embryon = embryon;
        this.couleur = couleur;
        this.semence = semence;
        this.biopsie = biopsie;
        this.remarques = remarques;
    }

    @Column

    private String biopsie;

    @Column
    private String remarques;

    public EmbryonsInVivo() {    }

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

    public String getBiopsie() {
        return biopsie;
    }

    public void setBiopsie(String biopsie) {
        this.biopsie = biopsie;
    }

    public String getRemarques() {
        return remarques;
    }

    public void setRemarques(String remarques) {
        this.remarques = remarques;
    }
}
