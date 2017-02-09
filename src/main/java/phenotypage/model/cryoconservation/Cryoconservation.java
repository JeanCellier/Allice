package phenotypage.model.cryoconservation;

import phenotypage.model.donneExistante.congelateur.Congelateur;
import phenotypage.model.donneExistante.operateur.Operateur;
import phenotypage.model.fiche.ficheAba.FicheAba;
import phenotypage.model.fiche.ficheCol.FicheCol;
import phenotypage.model.fiche.ficheOpu.FicheOpu;
import phenotypage.model.methodeCongelation.MethodeCongelation;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
public class Cryoconservation implements Serializable
{
	@Id
	@GeneratedValue
	private Long id;

	@Column
	private String type;

	@Column
	private int heure;

	@Column
	private int minute;

	@Column
	private String descMethode;

	@ManyToOne
	@JoinColumn(name = "idCongelateur", referencedColumnName = "id")
	private Congelateur congelateur;

	@ManyToOne
	@JoinColumn(name = "idOperateur", referencedColumnName = "id")
	private Operateur operateur;

	@ManyToOne
	@JoinColumn(name = "idMethodeCongelation", referencedColumnName = "id")
	private MethodeCongelation methodeCongelation;

	@OneToMany(mappedBy = "cryoconservation", cascade = CascadeType.REMOVE)
	private List<TableauDetail> tableauDetailList;

	@OneToOne
	@JoinColumn(name = "idFicheAba", referencedColumnName = "id", unique = true)
	private FicheAba ficheAba;

	@OneToOne
	@JoinColumn(name = "idFicheOpu", referencedColumnName = "id", unique = true)
	private FicheOpu ficheOpu;

	@OneToOne
	@JoinColumn(name = "idFicheCol", referencedColumnName = "id", unique = true)
	private FicheCol ficheCol;

	public Cryoconservation()
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

	public String getType()
	{
		return type;
	}

	public void setType(String type)
	{
		this.type = type;
	}

	public Congelateur getCongelateur()
	{
		return congelateur;
	}

	public void setCongelateur(Congelateur congelateur)
	{
		this.congelateur = congelateur;
	}

	public Operateur getOperateur()
	{
		return operateur;
	}

	public void setOperateur(Operateur operateur)
	{
		this.operateur = operateur;
	}

	public String getDescMethode()
	{
		return descMethode;
	}

	public void setDescMethode(String descMethode)
	{
		this.descMethode = descMethode;
	}

	public List<TableauDetail> getTableauDetailList()
	{
		return tableauDetailList;
	}

	public void setTableauDetailList(List<TableauDetail> tableauDetailList)
	{
		this.tableauDetailList = tableauDetailList;
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

	public FicheCol getFicheCol()
	{
		return ficheCol;
	}

	public void setFicheCol(FicheCol ficheCol)
	{
		this.ficheCol = ficheCol;
	}

	public MethodeCongelation getMethodeCongelation()
	{
		return methodeCongelation;
	}

	public void setMethodeCongelation(MethodeCongelation methodeCongelation)
	{
		this.methodeCongelation = methodeCongelation;
	}

	public int getHeure()
	{
		return heure;
	}

	public void setHeure(int heure)
	{
		this.heure = heure;
	}

	public int getMinute()
	{
		return minute;
	}

	public void setMinute(int minute)
	{
		this.minute = minute;
	}
}
