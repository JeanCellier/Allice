package phenotypage.model.invitro.culture;

import phenotypage.model.donneesExistantes.sanitaire.Sanitaire;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class Culture {
    @Id
    @GeneratedValue
    private Long id;

    @Column
    private Date date;

    @Column
    private String remarques;

    @ManyToMany(cascade = CascadeType.ALL)
    private List<Sanitaire> sanitaireList;

    @OneToMany(cascade = CascadeType.ALL)
    private List<TableauCulture> tableauCultureList;

    public Culture() {
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

    public String getRemarques() {
        return remarques;
    }

    public void setRemarques(String remarques) {
        this.remarques = remarques;
    }

    public List<Sanitaire> getSanitaireList() {
        return sanitaireList;
    }

    public void setSanitaireList(List<Sanitaire> sanitaireList) {
        this.sanitaireList = sanitaireList;
    }

    public List<TableauCulture> getTableauCultureList() {
        return tableauCultureList;
    }

    public void setTableauCultureList(List<TableauCulture> tableauCultureList) {
        this.tableauCultureList = tableauCultureList;
    }
}
