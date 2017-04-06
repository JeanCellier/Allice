package phenotypage.model.maturationInVitro;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.sql.Date;
import java.sql.Time;

/**
 * Created by nicolas on 05/04/17.
 */
@Entity
public class MaturationInVitro {
    @Id
    @GeneratedValue
    private Long id;

    @Column
    private Date dateMaturation;

    @Column
    private int nbCocsMaturation;

    @Column
    private Time heureDebutMaturation;

    @Column
    private Time heureFinMaturation;

    @Column
    private int nbCocsMature;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDateMaturation() {
        return dateMaturation;
    }

    public void setDateMaturation(Date dateMaturation) {
        this.dateMaturation = dateMaturation;
    }

    public int getNbCocsMaturation() {
        return nbCocsMaturation;
    }

    public void setNbCocsMaturation(int nbCocsMaturation) {
        this.nbCocsMaturation = nbCocsMaturation;
    }

    public Time getHeureDebutMaturation() {
        return heureDebutMaturation;
    }

    public void setHeureDebutMaturation(Time heureDebutMaturation) {
        this.heureDebutMaturation = heureDebutMaturation;
    }

    public Time getHeureFinMaturation() {
        return heureFinMaturation;
    }

    public void setHeureFinMaturation(Time heureFinMaturation) {
        this.heureFinMaturation = heureFinMaturation;
    }

    public int getNbCocsMature() {
        return nbCocsMature;
    }

    public void setNbCocsMature(int nbCocsMature) {
        this.nbCocsMature = nbCocsMature;
    }
}
