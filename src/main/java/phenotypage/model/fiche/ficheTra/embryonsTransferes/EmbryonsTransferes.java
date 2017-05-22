package phenotypage.model.fiche.ficheTra.embryonsTransferes;

import javax.persistence.*;
import phenotypage.model.vache.Vache;

/**
 * @author fabien
 */

@Entity
public class EmbryonsTransferes
{
	@Id
	@GeneratedValue
	private Long id;

	@Column
	private String refEmbryons;
	
	@Column
	private char cote;
	//G = gauche D = droit

	@Column
	private String emplacementColUterine;

	@Column
	private int faciliteprogression;

	public EmbryonsTransferes() {}

	public Long getId()
	{
		return id;
	}

	public void setId(Long id)
	{
		this.id = id;
	}

	public char getCote() {
		return cote;
	}

	public void setCote(char cote) {
		this.cote = cote;
	}

	public String getEmplacementColUterine() {
		return emplacementColUterine;
	}

	public void setEmplacementColUterine(String emplacementColUterine) {
		this.emplacementColUterine = emplacementColUterine;
	}

	public int getFaciliteprogression()
	{
		return faciliteprogression;
	}

	public void setFaciliteprogression(int faciliteprogression)
	{
		this.faciliteprogression = faciliteprogression;
	}

	public String getRefEmbryons()
	{
		return refEmbryons;
	}

	public void setRefEmbryons(String refEmbryons)
	{
		this.refEmbryons = refEmbryons;
	}
}
