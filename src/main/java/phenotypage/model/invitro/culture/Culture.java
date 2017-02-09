package phenotypage.model.invitro.culture;

import org.springframework.format.annotation.DateTimeFormat;
import phenotypage.model.fiche.ficheAba.FicheAba;
import phenotypage.model.fiche.ficheOpu.FicheOpu;
import phenotypage.model.donneExistante.sanitaire.Sanitaire;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

@Entity
public class Culture implements Serializable
{
	@Id
	@GeneratedValue
	private Long id;

	@Column
	private String saisie;

	@Column
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	private Date date;

	@Column
	private String remarques;

	@ManyToMany(mappedBy = "cultureList")
	private List<Sanitaire> sanitaireList;

	@OneToMany(mappedBy = "culture", cascade = CascadeType.REMOVE)
	private List<TableauCulture> tableauCultureList;

	@OneToOne
	@JoinColumn(name = "idFicheAba", referencedColumnName = "id", unique = true)
	private FicheAba ficheAba;

	@OneToOne
	@JoinColumn(name = "idFicheOpu", referencedColumnName = "id", unique = true)
	private FicheOpu ficheOpu;

	public Culture()
	{
		date = Calendar.getInstance().getTime();
	}

	public Culture(Long id, String saisie, Date date, String remarques, List<TableauCulture> tableauCultureList, List<Sanitaire> sanitaireList)
	{
		this.id = id;
		this.saisie = saisie;
		this.date = date;
		this.remarques = remarques;
		this.sanitaireList = sanitaireList;
		this.tableauCultureList = tableauCultureList;
	}

	public Long getId()
	{
		return id;
	}

	public void setId(Long id)
	{
		this.id = id;
	}

	public String getSaisie()
	{
		return saisie;
	}

	public void setSaisie(String saisie)
	{
		this.saisie = saisie;
	}

	public Date getDate()
	{
		return date;
	}

	public void setDate(Date date)
	{
		this.date = date;
	}

	public String getRemarques()
	{
		return remarques;
	}

	public void setRemarques(String remarques)
	{
		this.remarques = remarques;
	}

	public List<Sanitaire> getSanitaireList()
	{
		return sanitaireList;
	}

	public void setSanitaireList(List<Sanitaire> sanitaireList)
	{
		this.sanitaireList = sanitaireList;
	}

	public List<TableauCulture> getTableauCultureList()
	{
		return tableauCultureList;
	}

	public void setTableauCultureList(List<TableauCulture> tableauCultureList)
	{
		this.tableauCultureList = tableauCultureList;
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
