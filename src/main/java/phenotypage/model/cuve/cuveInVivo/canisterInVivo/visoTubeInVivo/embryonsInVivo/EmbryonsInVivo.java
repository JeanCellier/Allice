package phenotypage.model.cuve.cuveInVivo.canisterSemence.visoTubeSemence.semence;

import phenotypage.model.cryoconservation.embryon.Embryon;
import phenotypage.model.cuve.cuveSemence.canisterSemence.visoTubeSemence.semence.Semence;
import phenotypage.model.fiche.ficheCol.FicheCol;
import javax.persistence.*;

/**
 * Created by nicolas on 20/05/17.
 */
@Entity
public class EmbryonsInVivo {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    private FicheCol ficheCol;

    @ManyToOne
    private Embryon embryon;

    @Column
    private String couleur;

    @ManyToOne
    private Semence semence;

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

    public FicheCol getFicheCol() {
        return ficheCol;
    }

    public void setFicheCol(FicheCol ficheCol) {
        this.ficheCol = ficheCol;
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
