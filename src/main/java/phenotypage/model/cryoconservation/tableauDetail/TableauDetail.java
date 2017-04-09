package phenotypage.model.cryoconservation.tableauDetail;

import phenotypage.model.cuve.Cuve;
import phenotypage.model.cuve.canister.Canister;
import phenotypage.model.cuve.visoTube.VisoTube;
import phenotypage.model.qualite.Qualite;
import phenotypage.model.cryoconservation.stade.Stade;

import javax.persistence.*;

/**
 * @author fabien
 */

@Entity
public class TableauDetail
{
	@Id
	@GeneratedValue
	private Long id;

	@Column
	private int numeroEmbryon;

	@ManyToOne
	private Stade stade;

	@ManyToOne
	private Qualite qualite;

	@Column
	private boolean cryoconserve;

	@ManyToOne
	private Cuve cuve;

	@ManyToOne
	private Canister canister;

	@ManyToOne
	private VisoTube visoTube;

	@Column
	private String jonc;

	@Column
	private String numeroReceveuse;

	@Column
	private boolean frais;

	@Column
	private boolean detruit;

	@Column
	private String referenceTransfert;

	@Column
	private String remarque;

	public TableauDetail() {}

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

	public Qualite getQualite()
	{
		return qualite;
	}

	public void setQualite(Qualite qualite)
	{
		this.qualite = qualite;
	}

	public boolean isCryoconserve() {
		return cryoconserve;
	}

	public void setCryoconserve(boolean cryoconserve) {
		this.cryoconserve = cryoconserve;
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

	public boolean isFrais() {
		return frais;
	}

	public void setFrais(boolean frais) {
		this.frais = frais;
	}

	public boolean isDetruit() {
		return detruit;
	}

	public void setDetruit(boolean detruit) {
		this.detruit = detruit;
	}
}
