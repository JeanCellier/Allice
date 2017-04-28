package phenotypage.model.pharmacie.produit;

import javax.persistence.*;
import java.util.Date;

/**
 * @author fabien
 */

@Entity
public class Produit
{
	@Id
	@GeneratedValue
	private Long id;

	@Column
	private String nom;
	
	@Column
	private Date dateDelivrance;
	
	@Column
	private String fournisseur;
	
	@Column
	private String projet;
	
	@Column
	private String responsable;
	
	@Column
	private float qteEntrante;
	
	@Column
	private float qteRestante;
	
	@Column
	private String numLot;
	
	@Column
	private Date datePeremption;

	@Column
	private String indication;
	
	public Produit()
	{
	}

	public Produit(String nom, Date dateDelivrance, String fournisseur, String projet, String responsable,
				   float qteEntrante, float qteRestante, String numLot, Date datePeremption, String indication)
	{
		super();
		this.nom = nom;
		this.dateDelivrance = dateDelivrance;
		this.fournisseur = fournisseur;
		this.projet = projet;
		this.responsable = responsable;
		this.qteEntrante = qteEntrante;
		this.qteRestante = qteRestante;
		this.numLot = numLot;
		this.datePeremption = datePeremption;
		this.indication = indication;
	}

	public Produit(int i)
	{
		qteRestante = i;
	}

	public String getNom()
	{
		return nom;
	}

	public void setNom(String nom)
	{
		this.nom = nom;
	}

	public Date getDateDelivrance()
	{
		return dateDelivrance;
	}

	public void setDateDelivrance(Date dateDelivrance)
	{
		this.dateDelivrance = dateDelivrance;
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

	public float getQteEntrante()
	{
		return qteEntrante;
	}

	public void setQteEntrante(float qteEntrante)
	{
		this.qteEntrante = qteEntrante;
	}

	public float getQteRestante()
	{
		return qteRestante;
	}

	public void setQteRestante(float qteRestante)
	{
		this.qteRestante = qteRestante;
	}

	public String getNumLot()
	{
		return numLot;
	}

	public void setNumLot(String numLot)
	{
		this.numLot = numLot;
	}

	public Date getDatePeremption()
	{
		return datePeremption;
	}

	public void setDatePeremption(Date datePeremption)
	{
		this.datePeremption = datePeremption;
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
}
