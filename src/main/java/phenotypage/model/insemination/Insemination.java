package phenotypage.model.insemination;

import javax.persistence.*;
import phenotypage.model.donneesExistantes.operateur.Operateur;
import phenotypage.model.vache.Vache;

/**
 * @author fabien
 */

@Entity
public class Insemination
{
	@Id
	@GeneratedValue
	private Long id;

	@Column
	private boolean semenceSexee;

	@ManyToOne
	private Operateur operateur;

	@ManyToOne
	private Vache taureau;
	
	@Column
	private boolean collecte;
	//true si cadre collecte

	@Column
	private String lieuDepot;

	@Column
	private String progression;

	public Long getId()
	{
		return id;
	}

	public void setId(Long id)
	{
		this.id = id;
	}

	public Operateur getOperateur()
	{
		return operateur;
	}

	public void setOperateur(Operateur operateur)
	{
		this.operateur = operateur;
	}

	public Vache getTaureau()
	{
		return taureau;
	}

	public void setTaureau(Vache taureau)
	{
		this.taureau = taureau;
	}

	public boolean isCollecte()
	{
		return collecte;
	}

	public void setCollecte(boolean collecte)
	{
		this.collecte = collecte;
	}

	public boolean isSemenceSexee() {
		return semenceSexee;
	}

	public void setSemenceSexee(boolean semenceSexee) {
		this.semenceSexee = semenceSexee;
	}

	public String getLieuDepot() {
		return lieuDepot;
	}

	public void setLieuDepot(String lieuDepot) {
		this.lieuDepot = lieuDepot;
	}

	public String getProgression()
	{
		return progression;
	}

	public void setProgression(String progression)
	{
		this.progression = progression;
	}

	public Insemination() {}
}
