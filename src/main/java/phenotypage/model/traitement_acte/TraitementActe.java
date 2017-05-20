package phenotypage.model.traitement_acte;

import phenotypage.model.traitement_acte.tableau_traitement.Tableau_Traitement_Acte;

import javax.persistence.*;
import java.util.List;

/**
 * Created by nicolas on 29/04/17.
 */
@Entity
public class TraitementActe {
    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String nom;

    @OneToMany
    private List<Tableau_Traitement_Acte> tableauTraitement;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public List<Tableau_Traitement_Acte> getTableauTraitement() {
        return tableauTraitement;
    }

    public void setTableauTraitement(List<Tableau_Traitement_Acte> tableauTraitement) {
        this.tableauTraitement = tableauTraitement;
    }
}
