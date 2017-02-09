package phenotypage.model.imageEcho;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import phenotypage.model.fiche.ficheOpu.FicheOpu;

import java.io.Serializable;

/**
 * @author fabien
 */

@Entity
public class Echo implements Serializable
{
	@Id
	@GeneratedValue
	private Long id;

	@Column
	private int nb_ovaire_denombre_droit;
	
	@Column
	private int nb_ovaire_aspire_droit;
	
	@Column
	private int nb_ovaire_denombre_gauche;
	
	@Column
	private int nb_ovaire_aspire_gauche;
	
	@Column
	private int nb_cocs;
	
	@Column
	private float taux_collecte;
	
	@Column
	private String remarques;

	@OneToOne
	@JoinColumn(name = "idFicheOpu", referencedColumnName = "id", unique = true)
	private FicheOpu ficheOpu;

	public Echo(int nb_ovaire_denombre_droit, int nb_ovaire_aspire_droit, int nb_ovaire_denombre_gauche,
			int nb_ovaire_aspire_gauche, int nb_cocs, float taux_collecte, String remarques)
	{
		super();
		this.nb_ovaire_denombre_droit = nb_ovaire_denombre_droit;
		this.nb_ovaire_aspire_droit = nb_ovaire_aspire_droit;
		this.nb_ovaire_denombre_gauche = nb_ovaire_denombre_gauche;
		this.nb_ovaire_aspire_gauche = nb_ovaire_aspire_gauche;
		this.nb_cocs = nb_cocs;
		this.taux_collecte = taux_collecte;
		this.remarques = remarques;
	}

	public int getNb_ovaire_denombre_droit()
	{
		return nb_ovaire_denombre_droit;
	}

	public void setNb_ovaire_denombre_droit(int nb_ovaire_denombre_droit)
	{
		this.nb_ovaire_denombre_droit = nb_ovaire_denombre_droit;
	}

	public int getNb_ovaire_aspire_droit()
	{
		return nb_ovaire_aspire_droit;
	}

	public void setNb_ovaire_aspire_droit(int nb_ovaire_aspire_droit)
	{
		this.nb_ovaire_aspire_droit = nb_ovaire_aspire_droit;
	}

	public int getNb_ovaire_denombre_gauche()
	{
		return nb_ovaire_denombre_gauche;
	}

	public void setNb_ovaire_denombre_gauche(int nb_ovaire_denombre_gauche)
	{
		this.nb_ovaire_denombre_gauche = nb_ovaire_denombre_gauche;
	}

	public int getNb_ovaire_aspire_gauche()
	{
		return nb_ovaire_aspire_gauche;
	}

	public void setNb_ovaire_aspire_gauche(int nb_ovaire_aspire_gauche)
	{
		this.nb_ovaire_aspire_gauche = nb_ovaire_aspire_gauche;
	}

	public int getNb_cocs()
	{
		return nb_cocs;
	}

	public void setNb_cocs(int nb_cocs)
	{
		this.nb_cocs = nb_cocs;
	}

	public float getTaux_collecte()
	{
		return taux_collecte;
	}

	public void setTaux_collecte(float taux_collecte)
	{
		this.taux_collecte = taux_collecte;
	}

	public String getRemarques()
	{
		return remarques;
	}

	public void setRemarques(String remarques)
	{
		this.remarques = remarques;
	}

	public Echo()
	{
	}

	public Long getId()
	{
		return id;
	}

	public void setId(Long id)
	{
		this.id = id;
	}

	public FicheOpu getFicheOpu()
	{
		return ficheOpu;
	}

	public void setFicheOpu(FicheOpu ficheOpu)
	{
		this.ficheOpu = ficheOpu;
	}
}
