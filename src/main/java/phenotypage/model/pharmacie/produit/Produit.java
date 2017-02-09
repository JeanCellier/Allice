package phenotypage.model.pharmacie.produit;

import phenotypage.model.pharmacie.Pharmacie;
import phenotypage.model.traitementDonneuse.tableauPharmacie.Tableau_Pharmacie;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @author fabien
 */

@Entity
public class Produit implements Serializable
{
	@Id
	@GeneratedValue
	private Long id;

	@Column
	private String nom;
	
	@Column
	private Date date_delivrance;
	
	@Column
	private String fournisseur;
	
	@Column
	private String projet;
	
	@Column
	private String responsable;
	
	@Column
	private float qte_entrante;
	
	@Column
	private float qte_restante;
	
	@Column
	private String num_lot;
	
	@Column
	private Date date_peremption;
	
	@ManyToOne
    @JoinColumn(name = "idPharmacie", referencedColumnName = "id")
    private Pharmacie pharmacie;
	
	@OneToOne
	@JoinColumn(name = "idTabPharmacie", referencedColumnName = "id")
	private Tableau_Pharmacie tableau_pharmacie;

	@Column
	private String indication;
	
	public Produit()
	{
	}

	public Produit(String nom, Date date_delivrance, String fournisseur, String projet, String responsable,
			float qte_entrante, float qte_restante, String num_lot, Date date_peremption, String indication)
	{
		super();
		this.nom = nom;
		this.date_delivrance = date_delivrance;
		this.fournisseur = fournisseur;
		this.projet = projet;
		this.responsable = responsable;
		this.qte_entrante = qte_entrante;
		this.qte_restante = qte_restante;
		this.num_lot = num_lot;
		this.date_peremption = date_peremption;
		this.indication = indication;
	}

	public Produit(int i)
	{
		qte_restante = i;
	}

	public String getNom()
	{
		return nom;
	}

	public void setNom(String nom)
	{
		this.nom = nom;
	}

	public Date getDate_delivrance()
	{
		return date_delivrance;
	}

	public void setDate_delivrance(Date date_delivrance)
	{
		this.date_delivrance = date_delivrance;
	}

	public String getFournisseur()
	{
		return fournisseur;
	}

	public void setFournisseur(String fournisseur)
	{
		this.fournisseur = fournisseur;
	}

	public String getProjet()
	{
		return projet;
	}

	public void setProjet(String projet)
	{
		this.projet = projet;
	}

	public String getResponsable()
	{
		return responsable;
	}

	public void setResponsable(String responsable)
	{
		this.responsable = responsable;
	}

	public float getQte_entrante()
	{
		return qte_entrante;
	}

	public void setQte_entrante(float qte_entrante)
	{
		this.qte_entrante = qte_entrante;
	}

	public float getQte_restante()
	{
		return qte_restante;
	}

	public void setQte_restante(float qte_restante)
	{
		this.qte_restante = qte_restante;
	}

	public String getNum_lot()
	{
		return num_lot;
	}

	public void setNum_lot(String num_lot)
	{
		this.num_lot = num_lot;
	}

	public Date getDate_peremption()
	{
		return date_peremption;
	}

	public void setDate_peremption(Date date_peremption)
	{
		this.date_peremption = date_peremption;
	}

	public String getIndication()
	{
		return indication;
	}

	public void setIndication(String indication)
	{
		this.indication = indication;
	}


	public Long getId()
	{
		return id;
	}

	public void setId(Long id)
	{
		this.id = id;
	}

	public Pharmacie getPharmacie()
	{
		return pharmacie;
	}

	public void setPharmacie(Pharmacie pharmacie)
	{
		this.pharmacie = pharmacie;
	}

	public Tableau_Pharmacie getTableau_pharmacie()
	{
		return tableau_pharmacie;
	}

	public void setTableau_pharmacie(Tableau_Pharmacie tableau_pharmacie)
	{
		this.tableau_pharmacie = tableau_pharmacie;
	}
}
