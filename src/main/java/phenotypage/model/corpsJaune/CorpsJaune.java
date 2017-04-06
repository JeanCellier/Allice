package phenotypage.model.corpsJaune;

import phenotypage.model.donneesExistantes.qualite.Qualite;
import javax.persistence.*;

/**
 * @author fabien
 */

@Entity
public class CorpsJaune
{
	@Id
	@GeneratedValue
	private Long id;
	
	@Column
	private String mode_evaluation;
	
	@Column
	private boolean imageEcho;
	//Yes/No
	
	@Column
	private char coteCorpsJaune;
	//G = gauche; D = droit

	@OneToOne
	private Qualite qualite;

	public CorpsJaune() {}

	public Long getId()
	{
		return id;
	}

	public void setId(Long id)
	{
		this.id = id;
	}

	public String getMode_evaluation()
	{
		return mode_evaluation;
	}

	public void setMode_evaluation(String mode_evaluation)
	{
		this.mode_evaluation = mode_evaluation;
	}

	public boolean isImageEcho()
	{
		return imageEcho;
	}

	public void setImageEcho(boolean imageEcho)
	{
		this.imageEcho = imageEcho;
	}

	public char getCoteCorpsJaune() { return coteCorpsJaune; }

	public void setCoteCorpsJaune(char coteCorpsJaune) { this.coteCorpsJaune = coteCorpsJaune;	}

	public Qualite getQualite()
	{
		return qualite;
	}

	public void setQualite(Qualite qualite)
	{
		this.qualite = qualite;
	}
}
