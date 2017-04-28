package phenotypage.model.gestation;

import phenotypage.model.typeMethode.TypeMethode;
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

	@ManyToOne
	private TypeMethode methode;
	
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

	public TypeMethode getMethode()
	{
		return methode;
	}

	public void setMethode(TypeMethode methode)
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
