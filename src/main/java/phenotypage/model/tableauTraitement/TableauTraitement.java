package phenotypage.model.tableauTraitement;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

/**
 * Created by nicolas on 05/04/17.
 */
@Entity
public class TableauTraitement {
    @Id
    @GeneratedValue
    private Long id;

    @Column
    private Date date;

    @Column
    private String matin;

    @Column
    private String apresMidi;

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

    public String getMatin() {
        return matin;
    }

    public void setMatin(String matin) {
        this.matin = matin;
    }

    public String getApresMidi() {
        return apresMidi;
    }

    public void setApresMidi(String apresMidi) {
        this.apresMidi = apresMidi;
    }
}
