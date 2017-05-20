package phenotypage.model.invitro.fecondation;

import phenotypage.model.invitro.fecondation.tableauSemence.TableauSemence;

import java.util.Date;
import java.util.List;
import javax.persistence.*;

@Entity
public class Fecondation
{
	@Id
	@GeneratedValue
	private Long id;

	@Column
	private Date date;

	@Column
	private String remarque;

	@Column
	private String sanitaire;

	@OneToMany
	private List<TableauSemence> tableau_semences;

	public Fecondation() {	}

	public Long getId()
	{
		return id;
	}

	public void setId(Long id)
	{
		this.id = id;
	}

	public Date getDate()
	{
		return date;
	}

	public void setDate(Date date)
	{
		this.date = date;
	}

	public String getSanitaireList()
	{
		return sanitaire;
	}

	public void setSanitaireList(String sanitaire)
	{
		this.sanitaire = sanitaire;
	}

	public String getRemarque()
	{
		return remarque;
	}

	public void setRemarque(String remarque)
	{
		this.remarque = remarque;
	}

	public List<TableauSemence> getTableau_semences()
	{
		return tableau_semences;
	}

	public void setTableau_semences(List<TableauSemence> tableau_semences)
	{
		this.tableau_semences = tableau_semences;
	}

}
