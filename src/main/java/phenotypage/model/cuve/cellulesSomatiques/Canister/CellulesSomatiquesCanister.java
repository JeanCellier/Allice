package phenotypage.model.cuve.cellulesSomatiques.Canister;

import phenotypage.model.cuve.Cuve;
import phenotypage.model.cuve.canister.Canister;
import phenotypage.model.cuve.visoTube.VisoTube;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import java.util.Date;

/**
 * Created by Loick on 18/05/2017.
 */
@Entity
public class CellulesSomatiquesCanister extends Canister {
    @Column
    private String typeCellulaire;

    @Column
    private String couleurPaillette;

    @Column
    private int nbPaillettes;

    @Column
    private Date dateCongelation;

//    @ManyToOne
//    private VisoTube visuoTube;

    public CellulesSomatiquesCanister() {
        super();
    }

    @Column
    private String remarques;

    public String getTypeCellulaire() {
        return typeCellulaire;
    }

    public void setTypeCellulaire(String typeCellulaire) {
        this.typeCellulaire = typeCellulaire;
    }

    public String getCouleurPaillette() {
        return couleurPaillette;
    }

    public void setCouleurPaillette(String couleurPaillette) {
        this.couleurPaillette = couleurPaillette;
    }

    public int getNbPaillettes() {
        return nbPaillettes;
    }

    public void setNbPaillettes(int nbPaillettes) {
        this.nbPaillettes = nbPaillettes;
    }

    public Date getDateCongelation() {
        return dateCongelation;
    }

    public void setDateCongelation(Date dateCongelation) {
        this.dateCongelation = dateCongelation;
    }

//    public VisoTube getVisuoTube() {
//        return visuoTube;
//    }
//
//    public void setVisuoTube(VisoTube visuoTube) {
//        this.visuoTube = visuoTube;
//    }

    public String getRemarques() {
        return remarques;
    }

    public void setRemarques(String remarques) {
        this.remarques = remarques;
    }
}
