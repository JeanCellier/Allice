package phenotypage.model.corpsJaune;

import phenotypage.model.donneExistante.qualite.Qualite;
import phenotypage.model.fiche.ficheTra.FicheTra;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author fabien
 */

@Entity
public class CorpsJaune implements Serializable
{
	@Id
	@GeneratedValue
	private Long id;

	@Column
	private boolean palpation;
	//else echographie
	
	@Column
	private String mode_evaluation;
	
	@Column
	private boolean imageEcho;
	//Yes/No
	
	@Column
	private boolean coteCorpsJaune;
	//true cote droit//false cote gauche
	
	@OneToOne
	private Qualite qualite;

	@OneToOne
	@JoinColumn(name = "idFicheTra", referencedColumnName = "id", unique = true)
	private FicheTra ficheTra;

	public CorpsJaune()
	{
	}

	public CorpsJaune(boolean palpation, String mode_evaluation, boolean imageEcho, boolean coteCorpsJaune, Qualite qualite)
	{
		super();
		this.palpation = palpation;
		this.mode_evaluation = mode_evaluation;
		this.imageEcho = imageEcho;
		this.coteCorpsJaune = coteCorpsJaune;
		this.qualite = qualite;
	}

	public Long getId()
	{
		return id;
	}

	public void setId(Long id)
	{
		this.id = id;
	}

	public boolean isPalpation()
	{
		return palpation;
	}

	public void setPalpation(boolean palpation)
	{
		this.palpation = palpation;
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

	public boolean isCoteCorpsJaune()
	{
		return coteCorpsJaune;
	}

	public void setCoteCorpsJaune(boolean coteCorpsJaune)
	{
		this.coteCorpsJaune = coteCorpsJaune;
	}

	public Qualite getQualite()
	{
		return qualite;
	}

	public void setQualite(Qualite qualite)
	{
		this.qualite = qualite;
	}

	public FicheTra getFicheTra()
	{
		return ficheTra;
	}

	public void setFicheTra(FicheTra ficheTra)
	{
		this.ficheTra = ficheTra;
	}
}
