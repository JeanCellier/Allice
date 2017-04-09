package phenotypage.model.traitementDonneuse.tableau_donneuse;

import phenotypage.model.pharmacie.produit.Produit;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by nicolas on 05/04/17.
 */
@Entity
public class Tableau_Donneuse {
    @Id
    @GeneratedValue
    private Long id;

    @Column
    private Date date;

    @ManyToOne
    private Produit produit;

    @Column
    private int quantite;

    @Column
    private String mode_traitement;

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

    public Produit getProduit() {
        return produit;
    }

    public void setProduit(Produit produit) {
        this.produit = produit;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public String getMode_traitement() {
        return mode_traitement;
    }

    public void setMode_traitement(String mode_traitement) {
        this.mode_traitement = mode_traitement;
    }
}
