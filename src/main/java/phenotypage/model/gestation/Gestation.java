package phenotypage.model.gestation;

import org.springframework.format.annotation.DateTimeFormat;
import phenotypage.model.fiche.ficheAba.FicheAba;
import phenotypage.model.fiche.ficheIa.FicheIa;
import phenotypage.model.fiche.ficheTra.FicheTra;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

@Entity
public class Gestation implements Serializable
{
	@Id
	@GeneratedValue
	private Long id;

	@Column
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	private Calendar date;

	@OneToMany(mappedBy = "gestation", cascade = CascadeType.REMOVE)
	private List<Tableau_Gestation> tableauGestationList;

	@OneToOne
	@JoinColumn(name = "idFicheTra", referencedColumnName = "id", unique = true)
	private FicheTra ficheTra;

	@OneToOne
	@JoinColumn(name = "idFicheIa", referencedColumnName = "id", unique = true)
	private FicheIa ficheIa;


	public Gestation()
	{
		date = Calendar.getInstance();
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


	public List<Tableau_Gestation> getTableauGestationList()
	{
		return tableauGestationList;
	}


	public void setTableauGestationList(List<Tableau_Gestation> tableauGestationList)
	{
		this.tableauGestationList = tableauGestationList;
	}


	public Gestation(Calendar date, List<Tableau_Gestation> tableauGestationList)
	{
		super();
		this.date = date;
		this.tableauGestationList = tableauGestationList;
	}

	public FicheTra getFicheTra()
	{
		return ficheTra;
	}

	public void setFicheTra(FicheTra ficheTra)
	{
		this.ficheTra = ficheTra;
	}

	public FicheIa getFicheIa()
	{
		return ficheIa;
	}

	public void setFicheIa(FicheIa ficheIa)
	{
		this.ficheIa = ficheIa;
	}

}

