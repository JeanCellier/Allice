package phenotypage.model.fiche;

import org.hibernate.validator.constraints.NotEmpty;
import phenotypage.model.programme.Programme;
import javax.persistence.*;
import java.util.Date;

@MappedSuperclass
public abstract class Fiche
{
	@Id
	@GeneratedValue
	private Long id;

	@Column(unique = true)
	@NotEmpty
	private String nom;

	@ManyToOne
	private Programme programme;

	@Column
	private Date dateHeureMinute;

	public Fiche() {}

	public Long getId()
	{
		return id;
	}

	public void setId(Long id)
	{
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Date getDateHeureMinute() {
		return dateHeureMinute;
	}

	public void setDateHeureMinute(Date dateHeureMinute) {
		this.dateHeureMinute = dateHeureMinute;
	}

	public Programme getProgramme()
	{
		return programme;
	}

	public void setProgramme(Programme programme)
	{
		this.programme = programme;
	}
}
