package phenotypage.model.gestation;

import java.util.Date;
import java.util.List;
import javax.persistence.*;

@Entity
public class Gestation
{
	@Id
	@GeneratedValue
	private Long id;

	@Column
	private Date date;

	@OneToMany
	private List<Tableau_Gestation> tableauGestationList;

	@Column
	private String remarques;

	public Gestation() {}

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

	public List<Tableau_Gestation> getTableauGestationList()
	{
		return tableauGestationList;
	}

	public void setTableauGestationList(List<Tableau_Gestation> tableauGestationList) {this.tableauGestationList = tableauGestationList;}

	public String getRemarques() {
		return remarques;
	}

	public void setRemarques(String remarques) {
		this.remarques = remarques;
	}
}

