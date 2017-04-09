package phenotypage.model.cryoconservation;

import phenotypage.model.cryoconservation.congelateur.Congelateur;
import phenotypage.model.operateur.Operateur;
import phenotypage.model.cryoconservation.methodeCongelation.MethodeCongelation;
import javax.persistence.*;
import java.sql.Time;

@Entity
public class Cryoconservation
{
	@Id
	@GeneratedValue
	private Long id;

	@Column
	private String ref;

	@Column
	private Time heureMinute;

	@Column
	private String descMethode;

	@ManyToOne
	private Congelateur congelateur;

	@ManyToOne
	private Operateur operateur;

	@ManyToOne
	private MethodeCongelation methodeCongelation;

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

	public MethodeCongelation getMethodeCongelation()
	{
		return methodeCongelation;
	}

	public void setMethodeCongelation(MethodeCongelation methodeCongelation) { this.methodeCongelation = methodeCongelation; }

	public String getRef() {
		return ref;
	}

	public void setRef(String ref) {
		this.ref = ref;
	}

	public Time getHeureMinute() {
		return heureMinute;
	}

	public void setHeureMinute(Time heureMinute) {
		this.heureMinute = heureMinute;
	}
}
