package phenotypage.model.invitro.collecte;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created with magic
 * User: simoe
 * Date: 21/04/2017 23:37
 * Project: appPhenotypage
 */

@Entity
public class Tableau_Maturation {

    @Id
    @GeneratedValue
    private Long id;

    @Column
    private int nbOvocyte;

    @Column
    private String groupeExperimentauxMIV;

    public Tableau_Maturation() {
    }

    public int getNbOvocyte() {
        return nbOvocyte;
    }

    public void setNbOvocyte(int nbOvocyte) {
        this.nbOvocyte = nbOvocyte;
    }

    public String getGroupeExperimentauxMIV() {
        return groupeExperimentauxMIV;
    }

    public void setGroupeExperimentauxMIV(String groupeExperimentauxMIV) {
        this.groupeExperimentauxMIV = groupeExperimentauxMIV;
    }
}
