package phenotypage.model.traitementDonneuse.tableauPharmacie;

import org.springframework.format.annotation.DateTimeFormat;
import phenotypage.model.pharmacie.produit.Produit;
import phenotypage.model.traitementDonneuse.Traitement_Donneuse;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

/**
 * @author fabien
 */

@Entity
public class Tableau_Pharmacie implements Serializable
{
	@Id
	@GeneratedValue
	private Long id;
	
	@OneToOne
	private Produit produit;
	
	@Column
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	private Date date;
	
	@Column
	private int quantite;
	
	@Column
	private String mode;

	@Column
	private String matin;

	@Column
	private String apresMidi;
	
	@ManyToOne
    @JoinColumn(name = "idTabPharm", referencedColumnName = "id")
    private Traitement_Donneuse traitement_donneuse;
	
	@ManyToOne
	@JoinColumn(name = "idTabPharmSuper", referencedColumnName = "id")
	private Traitement_Donneuse traitement_donneuseSuper;

	public Tableau_Pharmacie()
	{
		date = Calendar.getInstance().getTime();
	}

	public Tableau_Pharmacie(Produit produit, Date date, int quantite, String mode)
	{
		super();
		this.produit = produit;
		this.date = date;
		this.quantite = quantite;
		this.mode = mode;
	}

	public Produit getProduit()
	{
		return produit;
	}

	public void setProduit(Produit produit)
	{
		this.produit = produit;
	}

	public Date getDate()
	{
		return date;
	}

	public void setDate(Date date)
	{
		this.date = date;
	}

	public int getQuantite()
	{
		return quantite;
	}

	public void setQuantite(int quantite)
	{
		this.quantite = quantite;
	}

	public String getMode()
	{
		return mode;
	}

	public void setMode(String mode)
	{
		this.mode = mode;
	}

	public Long getId()
	{
		return id;
	}

	public void setId(Long id)
	{
		this.id = id;
	}

	public String getMatin()
	{
		return matin;
	}

	public void setMatin(String matin)
	{
		this.matin = matin;
	}

	public String getApresMidi()
	{
		return apresMidi;
	}

	public void setApresMidi(String apresMidi)
	{
		this.apresMidi = apresMidi;
	}

	public Traitement_Donneuse getTraitement_donneuse()
	{
		return traitement_donneuse;
	}

	public void setTraitement_donneuse(Traitement_Donneuse traitement_donneuse)
	{
		this.traitement_donneuse = traitement_donneuse;
	}

	public Traitement_Donneuse getTraitement_donneuseSuper()
	{
		return traitement_donneuseSuper;
	}

	public void setTraitement_donneuseSuper(Traitement_Donneuse traitement_donneuseSuper)
	{
		this.traitement_donneuseSuper = traitement_donneuseSuper;
	}
}
