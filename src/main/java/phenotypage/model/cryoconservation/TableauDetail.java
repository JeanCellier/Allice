package phenotypage.model.cryoconservation;

import phenotypage.model.donneExistante.cuve.Cuve;
import phenotypage.model.donneExistante.cuve.canister.Canister;
import phenotypage.model.donneExistante.cuve.visoTube.VisoTube;
import phenotypage.model.donneExistante.qualite.Qualite;
import phenotypage.model.donneExistante.stade.Stade;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author fabien
 */

@Entity
public class TableauDetail implements Serializable
{
	@Id
	@GeneratedValue
	private Long id;

	@Column
	private int numeroEmbryon;

	@Column
	private int groupe;

	@ManyToOne
	@JoinColumn(name = "idStade", referencedColumnName = "id")
	private Stade stade;

	@ManyToOne
	@JoinColumn(name = "idQualite", referencedColumnName = "id")
	private Qualite qualite;

	@ManyToOne
	@JoinColumn(name = "idCuve", referencedColumnName = "id")
	private Cuve cuve;

	@ManyToOne
	@JoinColumn(name = "idCanister", referencedColumnName = "id")
	private Canister canister;

	@ManyToOne
	@JoinColumn(name = "idVisoTube", referencedColumnName = "id")
	private VisoTube visoTube;

	@Column
	private String jonc;

	@Column
	private String numeroReceveuse;

	@Column
	private String referenceTransfert;

	@Column
	private String remarque;

	@ManyToOne
	@JoinColumn(name = "idCryoconservation", referencedColumnName = "id")
	private Cryoconservation cryoconservation;

	public TableauDetail()
	{
	}

	public TableauDetail(int numeroEmbryon, int groupe, Stade stade, String referenceTransfert, String remarque)
	{
		this.numeroEmbryon = numeroEmbryon;
		this.groupe = groupe;
		this.stade = stade;
		this.referenceTransfert = referenceTransfert;
		this.remarque = remarque;
	}

	public Long getId()
	{
		return id;
	}

	public void setId(Long id)
	{
		this.id = id;
	}

	public int getNumeroEmbryon()
	{
		return numeroEmbryon;
	}

	public void setNumeroEmbryon(int numeroEmbryon)
	{
		this.numeroEmbryon = numeroEmbryon;
	}

	public int getGroupe()
	{
		return groupe;
	}

	public void setGroupe(int groupe)
	{
		this.groupe = groupe;
	}

	public Stade getStade()
	{
		return stade;
	}

	public void setStade(Stade stade)
	{
		this.stade = stade;
	}

	public String getReferenceTransfert()
	{
		return referenceTransfert;
	}

	public void setReferenceTransfert(String referenceTransfert)
	{
		this.referenceTransfert = referenceTransfert;
	}

	public String getRemarque()
	{
		return remarque;
	}

	public void setRemarque(String remarque)
	{
		this.remarque = remarque;
	}

	public Cryoconservation getCryoconservation()
	{
		return cryoconservation;
	}

	public void setCryoconservation(Cryoconservation cryoconservation)
	{
		this.cryoconservation = cryoconservation;
	}

	public Qualite getQualite()
	{
		return qualite;
	}

	public void setQualite(Qualite qualite)
	{
		this.qualite = qualite;
	}

	public Cuve getCuve()
	{
		return cuve;
	}

	public void setCuve(Cuve cuve)
	{
		this.cuve = cuve;
	}

	public Canister getCanister()
	{
		return canister;
	}

	public void setCanister(Canister canister)
	{
		this.canister = canister;
	}

	public VisoTube getVisoTube()
	{
		return visoTube;
	}

	public void setVisoTube(VisoTube visoTube)
	{
		this.visoTube = visoTube;
	}

	public String getJonc()
	{
		return jonc;
	}

	public void setJonc(String jonc)
	{
		this.jonc = jonc;
	}

	public String getNumeroReceveuse()
	{
		return numeroReceveuse;
	}

	public void setNumeroReceveuse(String numeroReceveuse)
	{
		this.numeroReceveuse = numeroReceveuse;
	}
}
