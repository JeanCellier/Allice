package phenotypage.model.fiches.traitement.header;

import org.springframework.format.annotation.DateTimeFormat;
import phenotypage.model.donneExistante.abattoir.Abattoir;
import phenotypage.model.fiche.ficheAba.FicheAba;
import phenotypage.model.fiche.ficheCol.FicheCol;
import phenotypage.model.fiche.ficheIa.FicheIa;
import phenotypage.model.fiche.ficheOpu.FicheOpu;
import phenotypage.model.donneExistante.operateur.Operateur;
import phenotypage.model.donneExistante.programme.Programme;
import phenotypage.model.fiche.ficheTra.FicheTra;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Calendar;

@Entity
public class Header implements Serializable
{
	@Id
	@GeneratedValue
	private Long id;

	@Column
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	private Calendar date;

	@Column
	private boolean snig;

	@ManyToOne
	@JoinColumn(name = "idOperateur", referencedColumnName = "id")
	private Operateur operateur;

	@ManyToOne
	@JoinColumn(name = "idProgramme", referencedColumnName = "id")
	private Programme programme;

	@Column
	private String numeroAgrement;

	@Column
	private String lieu;

	@Column
	private String ipe;

	@Column
	private String depotSemence;

	@ManyToOne
	@JoinColumn(name = "idAbattoir", referencedColumnName = "id")
	private Abattoir abattoir;

	@Column
	private int temperatureArrivee;

	@Column
	private int heure;

	@Column
	private int minute;

	@OneToOne
	@JoinColumn(name = "idFicheAba", referencedColumnName = "id", unique = true)
	private FicheAba ficheAba;

	@OneToOne
	@JoinColumn(name = "idFicheOpu", referencedColumnName = "id", unique = true)
	private FicheOpu ficheOpu;

	@OneToOne
	@JoinColumn(name = "idFicheCol", referencedColumnName = "id", unique = true)
	private FicheCol ficheCol;

	@OneToOne
	@JoinColumn(name = "idFicheTra", referencedColumnName = "id", unique = true)
	private FicheTra ficheTra;

	@OneToOne
	@JoinColumn(name = "idFicheIa", referencedColumnName = "id", unique = true)
	private FicheIa ficheIa;


	public Header()
	{
		date = Calendar.getInstance();
		lieu = "Allice Nouzilly";
	}

	public Header(Operateur operateur, Programme programme, String numeroAgrement, Abattoir abattoir)
	{
		this.operateur = operateur;
		this.programme = programme;
		this.numeroAgrement = numeroAgrement;
		this.abattoir = abattoir;
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

	public Operateur getOperateur()
	{
		return operateur;
	}

	public void setOperateur(Operateur operateur)
	{
		this.operateur = operateur;
	}

	public Programme getProgramme()
	{
		return programme;
	}

	public void setProgramme(Programme programme)
	{
		this.programme = programme;
	}

	public String getNumeroAgrement()
	{
		return numeroAgrement;
	}

	public void setNumeroAgrement(String numeroAgrement)
	{
		this.numeroAgrement = numeroAgrement;
	}

	public Abattoir getAbattoir()
	{
		return abattoir;
	}

	public void setAbattoir(Abattoir abattoir)
	{
		this.abattoir = abattoir;
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

	public int getTemperatureArrivee()
	{
		return temperatureArrivee;
	}

	public void setTemperatureArrivee(int temperatureArrivee)
	{
		this.temperatureArrivee = temperatureArrivee;
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

	public int getMinute()
	{
		return minute;
	}

	public void setMinute(int minute)
	{
		this.minute = minute;
	}

	public int getHeure()
	{

		return heure;
	}

	public void setHeure(int heure)
	{
		this.heure = heure;
	}

	public String getLieu()
	{
		return lieu;
	}

	public void setLieu(String lieu)
	{
		this.lieu = lieu;
	}

	public String getIpe()
	{
		return ipe;
	}

	public void setIpe(String ipe)
	{
		this.ipe = ipe;
	}

	public String getDepotSemence()
	{
		return depotSemence;
	}

	public void setDepotSemence(String depotSemence)
	{
		this.depotSemence = depotSemence;
	}

	public boolean isSnig()
	{
		return snig;
	}

	public void setSnig(boolean snig)
	{
		this.snig = snig;
	}
}
