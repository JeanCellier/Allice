package phenotypage.model.invitro.collecte;

import java.sql.Time;
import java.util.Date;
import java.util.List;
import javax.persistence.*;

@Entity
public class Collecte
{
	@Id
	@GeneratedValue
	private Long id;

	@Column
	private Time heureCollecte;

	@Column
	private Date date;

	@OneToMany
	private List<Tableau_Collecte> tableauCollecteList;

	public Collecte(){	}

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

	public List<Tableau_Collecte> getTableauCollecteList()
	{
		return tableauCollecteList;
	}

	public void setTableauCollecteList(List<Tableau_Collecte> tableauCollecteList) { this.tableauCollecteList = tableauCollecteList; }

	public Time getHeureCollecte() {
		return heureCollecte;
	}

	public void setHeureCollecte(Time heureCollecte) {
		this.heureCollecte = heureCollecte;
	}
}
