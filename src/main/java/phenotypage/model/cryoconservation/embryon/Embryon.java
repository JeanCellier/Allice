package phenotypage.model.cryoconservation.tableauDetail;
import javax.persistence.*;

/**
 * @author fabien
 */

@Entity
public class Embryon
{
	@Id
	@GeneratedValue
	private Long id;

	@Column
	private int numeroEmbryon;

	@Column
	private int stade;

	@Column
	private int qualite;

	@Column
	private boolean cryoconserve;

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

	public int getStade()
	{
		return stade;
	}

	public void setStade(int stade)
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

	public int getQualite()
	{
		return qualite;
	}

	public void setQualite(int qualite)
	{
		this.qualite = qualite;
	}

	public boolean isCryoconserve() {
		return cryoconserve;
	}

	public void setCryoconserve(boolean cryoconserve) {
		this.cryoconserve = cryoconserve;
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
