package phenotypage.model.informationsPIV;

import phenotypage.model.fiche.ficheAba.FicheAba;
import phenotypage.model.fiche.ficheOpu.FicheOpu;
import phenotypage.model.donneExistante.fiv.FIV;
import phenotypage.model.milieuMaturation.MilieuMaturation;
import phenotypage.model.donneExistante.operateur.Operateur;
import phenotypage.model.donneExistante.typeCulture.TypeCulture;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

@Entity
public class Informations_PIV implements Serializable
{
	@Id
	@GeneratedValue
	private Long id;

	@ManyToMany(mappedBy = "informations_pivList", cascade = CascadeType.REMOVE)
	private List<Operateur> operateurList;

	@ManyToOne
	@JoinColumn(name = "idMilieuMaturation", referencedColumnName = "id")
	private MilieuMaturation milieuMaturation;

	@ManyToOne
	@JoinColumn(name = "idFIV", referencedColumnName = "id")
	private FIV fiv;

	@ManyToOne
	@JoinColumn(name = "idTypeCulture", referencedColumnName = "id")
	private TypeCulture typeCulture;

	@OneToOne
	@JoinColumn(name = "idFicheAba", referencedColumnName = "id", unique = true)
	private FicheAba ficheAba;

	@OneToOne
	@JoinColumn(name = "idFicheOpu", referencedColumnName = "id", unique = true)
	private FicheOpu ficheOpu;

	public Informations_PIV()
	{
	}

	public Informations_PIV(List<Operateur> operateurList, MilieuMaturation milieuMaturation, FIV fiv, TypeCulture typeCulture)
	{
		this.operateurList = operateurList;
		this.milieuMaturation = milieuMaturation;
		this.fiv = fiv;
		this.typeCulture = typeCulture;
	}

	public Long getId()
	{
		return id;
	}

	public void setId(Long id)
	{
		this.id = id;
	}

	public MilieuMaturation getMilieuMaturation()
	{
		return milieuMaturation;
	}

	public void setMilieuMaturation(MilieuMaturation milieuMaturation)
	{
		this.milieuMaturation = milieuMaturation;
	}

	public FIV getFiv()
	{
		return fiv;
	}

	public void setFiv(FIV fiv)
	{
		this.fiv = fiv;
	}

	public TypeCulture getTypeCulture()
	{
		return typeCulture;
	}

	public void setTypeCulture(TypeCulture typeCulture)
	{
		this.typeCulture = typeCulture;
	}

	public List<Operateur> getOperateurList()
	{
		return operateurList;
	}

	public void setOperateurList(List<Operateur> operateurList)
	{
		this.operateurList = operateurList;
	}

	public FicheAba getFicheAba()
	{
		return ficheAba;
	}

	public void setFicheAba(FicheAba ficheAba)
	{
		this.ficheAba = ficheAba;
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
