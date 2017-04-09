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
	private boolean semenceSexee;

	@Column
	private String refExperience;

	@Column
	private String refEmbryons;

	@ManyToOne
	private Vache taureau;
	
	@Column
	private char cote;
	//G = gauche D = droit

	@Column
	private String emplacementColUterine;

	@Column
	private String faciliteprogression;


	public EmbryonsTransferes() {}

	public Long getId()
	{
		return id;
	}

	public void setId(Long id)
	{
		this.id = id;
	}

	public String getRefExperience()
	{
		return refExperience;
	}

	public void setRefExperience(String refExperience)
	{
		this.refExperience = refExperience;
	}

	public Vache getTaureau()
	{
		return taureau;
	}

	public void setTaureau(Vache taureau)
	{
		this.taureau = taureau;
	}

	public boolean isSemenceSexee() {
		return semenceSexee;
	}

	public void setSemenceSexee(boolean semenceSexee) {
		this.semenceSexee = semenceSexee;
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

	public String getFaciliteprogression()
	{
		return faciliteprogression;
	}

	public void setFaciliteprogression(String faciliteprogression)
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
