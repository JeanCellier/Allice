package phenotypage.model.traitement_acte.tableau_traitement;

import phenotypage.model.pharmacie.produit.Produit;

import javax.persistence.*;

/**
 * Created by nicolas on 05/04/17.
 */
@Entity
public class Tableau_Traitement_Acte {
    @Id
    @GeneratedValue
    private Long id;

    @Column
    private int decalage;

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

    public int getDecalage() {
        return decalage;
    }

    public void setDecalage(int decalage) {
        this.decalage = decalage;
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
