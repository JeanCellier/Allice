package phenotypage.model.cryoconservation;

import phenotypage.model.operateur.Operateur;
import javax.persistence.*;
import java.sql.Time;
import java.util.Date;

@Entity
public class Cryoconservation
{
	@Id
	@GeneratedValue
	private Long id;

	@Column
	private String ref;

	@Column
	private Date heureMinute;

	@Column
	private String methodeCongelation;

	@Column
	private String congelateur;

	@ManyToOne
	private Operateur operateur;

	@Column
	private String descMethode;

	public Cryoconservation() {}

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
		return ref;
	}

	public void setType(String ref)
	{
		this.ref = ref;
	}

	public String getCongelateur()
	{
		return congelateur;
	}

	public void setCongelateur(String congelateur)
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

	public String getMethodeCongelation()
	{
		return methodeCongelation;
	}

	public void setMethodeCongelation(String methodeCongelation) { this.methodeCongelation = methodeCongelation; }

	public String getRef() {
		return ref;
	}

	public void setRef(String ref) {
		this.ref = ref;
	}

	public Date getHeureMinute() {
		return heureMinute;
	}

	public void setHeureMinute(Date heureMinute) {
		this.heureMinute = heureMinute;
	}
}
