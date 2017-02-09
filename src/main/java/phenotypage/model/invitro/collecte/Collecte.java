package phenotypage.model.invitro.collecte;

import org.springframework.format.annotation.DateTimeFormat;
import phenotypage.model.fiche.ficheAba.FicheAba;
import phenotypage.model.fiche.ficheOpu.FicheOpu;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

@Entity
public class Collecte implements Serializable
{
	@Id
	@GeneratedValue
	private Long id;

	@Column
	private int heure;

	@Column
	private int minute;

	@Column
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	private Calendar date;

	@OneToMany(mappedBy = "collecte", cascade = CascadeType.REMOVE)
	private List<Tableau_Collecte> tableauCollecteList;

	@OneToOne
	@JoinColumn(name = "idFicheAba", referencedColumnName = "id", unique = true)
	private FicheAba ficheAba;

	@OneToOne
	@JoinColumn(name = "idFicheOpu", referencedColumnName = "id", unique = true)
	private FicheOpu ficheOpu;


	public Collecte()
	{
		date = Calendar.getInstance();
	}

	public Collecte(Calendar date, List<Tableau_Collecte> tableauCollecteList)
	{
		this.date = date;
		this.tableauCollecteList = tableauCollecteList;
	}

	public Long getId()
	{
		return id;
	}

	public void setId(Long id)
	{
		this.id = id;
	}

	public Calendar getDate()
	{
		return date;
	}

	public void setDate(Calendar date)
	{
		this.date = date;
	}

	public List<Tableau_Collecte> getTableauCollecteList()
	{
		return tableauCollecteList;
	}

	public void setTableauCollecteList(List<Tableau_Collecte> tableauCollecteList)
	{
		this.tableauCollecteList = tableauCollecteList;
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
