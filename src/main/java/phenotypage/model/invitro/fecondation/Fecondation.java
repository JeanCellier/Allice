package phenotypage.model.invitro.fecondation;

import org.springframework.format.annotation.DateTimeFormat;
import phenotypage.model.fiche.ficheAba.FicheAba;
import phenotypage.model.fiche.ficheOpu.FicheOpu;
import phenotypage.model.donneExistante.sanitaire.Sanitaire;

import java.io.Serializable;
import java.util.Date;
import java.util.Calendar;
import java.util.List;

import javax.persistence.*;

@Entity
public class Fecondation implements Serializable
{
	@Id
	@GeneratedValue
	private Long id;

	@Column
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	private Date date;

	@Column
	private int heure;

	@Column
	private int minute;


	@Column
	private String remarque;

	@ManyToMany(mappedBy = "fecondationList")
	private List<Sanitaire> sanitaireList;

	@OneToMany(mappedBy = "fecondation", cascade = CascadeType.REMOVE)
	private List<TableauSemence> tableau_semences;

	@OneToOne
	@JoinColumn(name = "idFicheAba", referencedColumnName = "id", unique = true)
	private FicheAba ficheAba;

	@OneToOne
	@JoinColumn(name = "idFicheOpu", referencedColumnName = "id", unique = true)
	private FicheOpu ficheOpu;

	public Fecondation()
	{
		date = Calendar.getInstance().getTime();
	}

	public Fecondation(Date date, String remarque, List<Sanitaire> sanitaireList)
	{
		super();
		this.date = date;
		this.remarque = remarque;
		this.sanitaireList = sanitaireList;
	}

	public Long getId()
	{
		return id;
	}

	public void setId(Long id)
	{
		this.id = id;
	}

	public Date getDate()
	{
		return date;
	}

	public void setDate(Date date)
	{
		this.date = date;
	}

	public List<Sanitaire> getSanitaireList()
	{
		return sanitaireList;
	}

	public void setSanitaireList(List<Sanitaire> sanitaireList)
	{
		this.sanitaireList = sanitaireList;
	}

	public String getRemarque()
	{
		return remarque;
	}

	public void setRemarque(String remarque)
	{
		this.remarque = remarque;
	}

	public List<TableauSemence> getTableau_semences()
	{
		return tableau_semences;
	}

	public void setTableau_semences(List<TableauSemence> tableau_semences)
	{
		this.tableau_semences = tableau_semences;
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
