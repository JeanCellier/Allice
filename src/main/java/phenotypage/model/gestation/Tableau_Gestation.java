package phenotypage.model.gestation;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

@Entity
public class Tableau_Gestation implements Serializable
{
	@Id
	@GeneratedValue
	private Long id;

	@Column
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	private Calendar date;
	
	@Column
	private String methode;
	
	@Column
	private String resultat;

	@ManyToOne
	@JoinColumn(name = "id_Gestation", referencedColumnName = "id")
	private Gestation gestation;

	public Tableau_Gestation()
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

	public Calendar getDate()
	{
		return date;
	}

	public void setDate(Calendar date)
	{
		this.date = date;
	}

	public String getMethode()
	{
		return methode;
	}

	public void setMethode(String methode)
	{
		this.methode = methode;
	}

	public String getResultat()
	{
		return resultat;
	}

	public void setResultat(String resultat)
	{
		this.resultat = resultat;
	}

	public Tableau_Gestation(Calendar date, String methode, String resultat)
	{
		super();
		this.date = date;
		this.methode = methode;
		this.resultat = resultat;
	}

	public Gestation getGestation()
	{
		return gestation;
	}

	public void setGestation(Gestation gestation)
	{
		this.gestation = gestation;
	}
}
