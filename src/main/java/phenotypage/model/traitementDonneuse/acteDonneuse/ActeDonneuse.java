package phenotypage.model.traitementDonneuse.acteDonneuse;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

/**
 * Created by nicolas on 24/05/17.
 */
@Entity
public class ActeDonneuse {
    @Id
    @GeneratedValue
    private Long id;

    @Column
    private Date date;

    @Column
    private String acte;

    public ActeDonneuse() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getActe() {
        return acte;
    }

    public void setActe(String acte) {
        this.acte = acte;
    }
}
