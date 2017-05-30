package phenotypage.model.infoTraitementDonneuse;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by nicolas on 07/04/17.
 */
@Entity
public class InfoTraitementDonneuse {
    @Id
    @GeneratedValue
    private Long id;

    @Column
    private int nb_follicules;

    @Column
    private int nb_droite;

    @Column
    private int nb_gauche;

    @Column
    private boolean image_echo;

    @Column
    private float pourc_dose;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getNb_follicules() {
        return nb_follicules;
    }

    public void setNb_follicules(int nb_follicules) {
        this.nb_follicules = nb_follicules;
    }

    public int getNb_droite() {
        return nb_droite;
    }

    public void setNb_droite(int nb_droite) {
        this.nb_droite = nb_droite;
    }

    public int getNb_gauche() {
        return nb_gauche;
    }

    public void setNb_gauche(int nb_gauche) {
        this.nb_gauche = nb_gauche;
    }

    public boolean isImage_echo() {
        return image_echo;
    }

    public void setImage_echo(boolean image_echo) {
        this.image_echo = image_echo;
    }

    public float getPourc_dose() {
        return pourc_dose;
    }

    public void setPourc_dose(float pourc_dose) {
        this.pourc_dose = pourc_dose;
    }
}
