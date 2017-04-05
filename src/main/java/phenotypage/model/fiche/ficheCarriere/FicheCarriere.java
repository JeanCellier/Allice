package phenotypage.model.fiche.ficheCarriere;

import phenotypage.model.fiche.Fiche;
import phenotypage.model.vache.Vache;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.util.List;

/**
 * @author fabien
 */

@Entity
public class FicheCarriere extends Fiche {

    @OneToOne
    private Vache vache;

    @OneToMany(mappedBy = "fichecarriere")
    private List<Tableau_Carriere> tableauCarriereList;

    public FicheCarriere() {
    }

    public FicheCarriere(String nom) {
        super(nom);
    }

    public Vache getVache() {
        return vache;
    }

    public void setVache(Vache vache) {
        this.vache = vache;
    }

    public List<Tableau_Carriere> getTableauCarriereList() {
        return tableauCarriereList;
    }

    public void setTableauCarriereList(List<Tableau_Carriere> tableauCarriereList) {
        this.tableauCarriereList = tableauCarriereList;
    }
}


