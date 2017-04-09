package phenotypage.model.invitro.culture.tableauCulture;

import javax.persistence.*;

/**
 * @author fabien
 */

@Entity
public class TableauCulture
{
	@Id
	@GeneratedValue
	private Long id;

	@Column
	private String groupe;

	@Column
	private int nbInsemine;

	@Column
	private int heureCulture;

	@Column
	private int minuteCulture;

	@Column
	private int nbSegmente;

	@Column
	private float segment;

	@Column
	private int j5JM;

	@Column
	private int j6;

	@Column
	private int JB;

	@Column
	private int mo;

	@Column
	private int bl;

	@Column
	private int be;

	@Column
	private int q1;

	@Column
	private int nbTotal;

	@Column
	private float pourJ7;

	@Column
	private float pourBEJ7;

	@Column
	private float pourQ1J7;

	@Column
	private int J8parNb;

	@Column
	private float pourJ8;
	
	@Column
	private boolean siCryo;

	private String destination;

	public TableauCulture() {}

	public Long getId()
	{
		return id;
	}

	public void setId(Long id)
	{
		this.id = id;
	}

	public String getGroupe()
	{
		return groupe;
	}

	public void setGroupe(String groupe)
	{
		this.groupe = groupe;
	}

	public int getNbInsemine()
	{
		return nbInsemine;
	}

	public void setNbInsemine(int nbInsemine)
	{
		this.nbInsemine = nbInsemine;
	}

	public int getHeureCulture()
	{
		return heureCulture;
	}

	public void setHeureCulture(int heureCulture)
	{
		this.heureCulture = heureCulture;
	}

	public int getNbSegmente()
	{
		return nbSegmente;
	}

	public void setNbSegmente(int nbSegmente)
	{
		this.nbSegmente = nbSegmente;
	}

	public float getSegment()
	{
		return segment;
	}

	public void setSegment(float segment)
	{
		this.segment = segment;
	}

	public int getJ5JM()
	{
		return j5JM;
	}

	public void setJ5JM(int j5JM)
	{
		this.j5JM = j5JM;
	}

	public int getMo()
	{
		return mo;
	}

	public void setMo(int mo)
	{
		this.mo = mo;
	}

	public int getBl()
	{
		return bl;
	}

	public void setBl(int bl)
	{
		this.bl = bl;
	}

	public int getBe()
	{
		return be;
	}

	public void setBe(int be)
	{
		this.be = be;
	}

	public int getQ1()
	{
		return q1;
	}

	public void setQ1(int q1)
	{
		this.q1 = q1;
	}

	public int getNbTotal()
	{
		return nbTotal;
	}

	public void setNbTotal(int nbTotal)
	{
		this.nbTotal = nbTotal;
	}

	public float getPourJ7()
	{
		return pourJ7;
	}

	public void setPourJ7(float pourJ7)
	{
		this.pourJ7 = pourJ7;
	}

	public float getPourBEJ7()
	{
		return pourBEJ7;
	}

	public void setPourBEJ7(float pourBEJ7)
	{
		this.pourBEJ7 = pourBEJ7;
	}

	public float getPourQ1J7()
	{
		return pourQ1J7;
	}

	public void setPourQ1J7(float pourQ1J7)
	{
		this.pourQ1J7 = pourQ1J7;
	}

	public int getJ8parNb()
	{
		return J8parNb;
	}

	public void setJ8parNb(int j8parNb)
	{
		J8parNb = j8parNb;
	}

	public int getMinuteCulture()
	{
		return minuteCulture;
	}

	public void setMinuteCulture(int minuteCulture)
	{
		this.minuteCulture = minuteCulture;
	}

	public boolean isSiCryo()
	{
		return siCryo;
	}

	public void setSiCryo(boolean siCryo)
	{
		this.siCryo = siCryo;
	}

	public float getPourJ8()
	{
		return pourJ8;
	}

	public void setPourJ8(float pourJ8)
	{
		this.pourJ8 = pourJ8;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public int getJ6() {
		return j6;
	}

	public void setJ6(int j6) {
		this.j6 = j6;
	}

	public int getJB() {
		return JB;
	}

	public void setJB(int JB) {
		this.JB = JB;
	}
}
