package phenotypage.model.cuve.cuveSomatique.canisterSomatique.visoTubeSomatique.celluleSomatique;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

/**
 * Created by nicolas on 20/05/17.
 */
@Entity
public class CelluleSomatique {
    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String typeCellulaire;

    @Column
    private String couleurPaillette;

    @Column
    private int nbPaillettes;

    @Column
    private Date dateCongelation;

    @Column
    private String remarques;

    public CelluleSomatique() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public String getRemarques() {
        return remarques;
    }

    public void setRemarques(String remarques) {
        this.remarques = remarques;
    }
}
