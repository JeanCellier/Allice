package phenotypage.model.gestation.tableau_gestation;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Tableau_Gestation
{
	@Id
	@GeneratedValue
	private Long id;

	@Column
	private Date date;

	@Column
	private String methode;
	
	@Column
	private String resultat;

	public Tableau_Gestation() {}

	public Long getId()
	{
		return id;
	}

	public void setId(Long id)
	{
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
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
}
