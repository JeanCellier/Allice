package phenotypage.model.fiche.ficheCarriere;

import javax.persistence.*;
import phenotypage.model.donneesExistantes.operateur.Operateur;
import phenotypage.model.pharmacie.produit.Produit;
import java.util.Date;

@Entity
public class Tableau_Carriere
{
	@Id
	@GeneratedValue
	private Long id;

	@Column
	private Date date_debut;
	
	@Column
	private Date date_fin;
	
	@Column
	private String nature_ou_ref;
	
	@Column
	private String num_ordonnance;
	
	@Column
	private Produit produit;
	
	@Column
	private String voie;
	
	@Column
	private float dose;
	
	@Column
	private String rythme;
	
	@Column
	private String remarques;
	
	@OneToOne
	private Operateur operateur;
	
	@Column
	private int delai;	

	public Tableau_Carriere(Date date_debut, Date date_fin, String nature_ou_ref, String num_ordonnance,
			Produit produit, String voie, float dose, String rythme, String remarques, Operateur operateur, int delai,
			FicheCarriere fichecarriere)
	{
		super();
		this.date_debut = date_debut;
		this.date_fin = date_fin;
		this.nature_ou_ref = nature_ou_ref;
		this.num_ordonnance = num_ordonnance;
		this.produit = produit;
		this.voie = voie;
		this.dose = dose;
		this.rythme = rythme;
		this.remarques = remarques;
		this.operateur = operateur;
		this.delai = delai;
		this.fichecarriere = fichecarriere;
	}

	public Long getId()
	{
		return id;
	}

	public void setId(Long id)
	{
		this.id = id;
	}

	public Date getDate_debut()
	{
		return date_debut;
	}

	public void setDate_debut(Date date_debut)
	{
		this.date_debut = date_debut;
	}

	public Date getDate_fin()
	{
		return date_fin;
	}

	public void setDate_fin(Date date_fin)
	{
		this.date_fin = date_fin;
	}

	public String getNature_ou_ref()
	{
		return nature_ou_ref;
	}

	public void setNature_ou_ref(String nature_ou_ref)
	{
		this.nature_ou_ref = nature_ou_ref;
	}

	public String getNum_ordonnance()
	{
		return num_ordonnance;
	}

	public void setNum_ordonnance(String num_ordonnance)
	{
		this.num_ordonnance = num_ordonnance;
	}

	public Produit getProduit()
	{
		return produit;
	}

	public void setProduit(Produit produit)
	{
		this.produit = produit;
	}

	public String getVoie()
	{
		return voie;
	}

	public void setVoie(String voie)
	{
		this.voie = voie;
	}

	public float getDose()
	{
		return dose;
	}

	public void setDose(float dose)
	{
		this.dose = dose;
	}

	public String getRythme()
	{
		return rythme;
	}

	public void setRythme(String rythme)
	{
		this.rythme = rythme;
	}

	public String getRemarques()
	{
		return remarques;
	}

	public void setRemarques(String remarques)
	{
		this.remarques = remarques;
	}

	public Operateur getOperateur()
	{
		return operateur;
	}

	public void setOperateur(Operateur operateur)
	{
		this.operateur = operateur;
	}

	public int getDelai()
	{
		return delai;
	}

	public void setDelai(int delai)
	{
		this.delai = delai;
	}

	public FicheCarriere getFichecarriere()
	{
		return fichecarriere;
	}

	public void setFichecarriere(FicheCarriere fichecarriere)
	{
		this.fichecarriere = fichecarriere;
	}

	@ManyToOne
	@JoinColumn(name = "id_Carriere", referencedColumnName = "id")
	private FicheCarriere fichecarriere;

	public Tableau_Carriere()
	{
	}

}
