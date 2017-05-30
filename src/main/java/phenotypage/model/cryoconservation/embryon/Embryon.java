package phenotypage.model.cryoconservation.embryon;
import phenotypage.model.fiche.ficheAba.FicheAba;
import phenotypage.model.fiche.ficheCol.FicheCol;
import phenotypage.model.fiche.ficheOpu.FicheOpu;

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
	private String ficheCol;

	@Column
	private String ficheOpu;

	@Column
	private String ficheAba;

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
	private String referenceTransfert;

	@Column
	private boolean detruit;

	@Column
	private String remarque;

	public Embryon() {}

	public Long getId()
	{
		return id;
	}

	public void setId(Long id)
	{
		this.id = id;
	}

	public String getFicheCol() {
		return ficheCol;
	}

	public void setFicheCol(String ficheCol) {
		this.ficheCol = ficheCol;
	}

	public String getFicheOpu() {
		return ficheOpu;
	}

	public void setFicheOpu(String ficheOpu) {
		this.ficheOpu = ficheOpu;
	}

	public String getFicheAba() {
		return ficheAba;
	}

	public void setFicheAba(String ficheAba) {
		this.ficheAba = ficheAba;
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

	public boolean isDetruit() {
		return detruit;
	}

	public void setDetruit(boolean detruit) {
		this.detruit = detruit;
	}
}
