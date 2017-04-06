package phenotypage.model.imageEcho;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


/**
 * @author fabien
 */

@Entity
public class Echo
{
	@Id
	@GeneratedValue
	private Long id;

	@Column
	private int nb_ovaire_denombre_droitInf8;
	
	@Column
	private int nb_ovaire_aspire_droitInf8;
	
	@Column
	private int nb_ovaire_denombre_gaucheInf8;
	
	@Column
	private int nb_ovaire_aspire_gaucheInf8;

	@Column
	private int nb_ovaire_denombre_droitSup8;

	@Column
	private int nb_ovaire_aspire_droitSup8;

	@Column
	private int nb_ovaire_denombre_gaucheSup8;

	@Column
	private int nb_ovaire_aspire_gaucheSup8;

	@Column
	private int nb_ovaire_denombre_droitSup15;

	@Column
	private int nb_ovaire_aspire_droitSup15;

	@Column
	private int nb_ovaire_denombre_gaucheSup15;

	@Column
	private int nb_ovaire_aspire_gaucheSup15;

	@Column
	private int nb_cocs;
	
	@Column
	private float taux_collecte;
	
	@Column
	private String remarques;

	public Echo() {}

	public int getNb_ovaire_denombre_droitInf8() {
		return nb_ovaire_denombre_droitInf8;
	}

	public void setNb_ovaire_denombre_droitInf8(int nb_ovaire_denombre_droitInf8) {
		this.nb_ovaire_denombre_droitInf8 = nb_ovaire_denombre_droitInf8;
	}

	public int getNb_ovaire_aspire_droitInf8() {
		return nb_ovaire_aspire_droitInf8;
	}

	public void setNb_ovaire_aspire_droitInf8(int nb_ovaire_aspire_droitInf8) {
		this.nb_ovaire_aspire_droitInf8 = nb_ovaire_aspire_droitInf8;
	}

	public int getNb_ovaire_denombre_gaucheInf8() {
		return nb_ovaire_denombre_gaucheInf8;
	}

	public void setNb_ovaire_denombre_gaucheInf8(int nb_ovaire_denombre_gaucheInf8) {
		this.nb_ovaire_denombre_gaucheInf8 = nb_ovaire_denombre_gaucheInf8;
	}

	public int getNb_ovaire_aspire_gaucheInf8() {
		return nb_ovaire_aspire_gaucheInf8;
	}

	public void setNb_ovaire_aspire_gaucheInf8(int nb_ovaire_aspire_gaucheInf8) {
		this.nb_ovaire_aspire_gaucheInf8 = nb_ovaire_aspire_gaucheInf8;
	}

	public int getNb_ovaire_denombre_droitSup8() {
		return nb_ovaire_denombre_droitSup8;
	}

	public void setNb_ovaire_denombre_droitSup8(int nb_ovaire_denombre_droitSup8) {
		this.nb_ovaire_denombre_droitSup8 = nb_ovaire_denombre_droitSup8;
	}

	public int getNb_ovaire_aspire_droitSup8() {
		return nb_ovaire_aspire_droitSup8;
	}

	public void setNb_ovaire_aspire_droitSup8(int nb_ovaire_aspire_droitSup8) {
		this.nb_ovaire_aspire_droitSup8 = nb_ovaire_aspire_droitSup8;
	}

	public int getNb_ovaire_denombre_gaucheSup8() {
		return nb_ovaire_denombre_gaucheSup8;
	}

	public void setNb_ovaire_denombre_gaucheSup8(int nb_ovaire_denombre_gaucheSup8) {
		this.nb_ovaire_denombre_gaucheSup8 = nb_ovaire_denombre_gaucheSup8;
	}

	public int getNb_ovaire_aspire_gaucheSup8() {
		return nb_ovaire_aspire_gaucheSup8;
	}

	public void setNb_ovaire_aspire_gaucheSup8(int nb_ovaire_aspire_gaucheSup8) {
		this.nb_ovaire_aspire_gaucheSup8 = nb_ovaire_aspire_gaucheSup8;
	}

	public int getNb_ovaire_denombre_droitSup15() {
		return nb_ovaire_denombre_droitSup15;
	}

	public void setNb_ovaire_denombre_droitSup15(int nb_ovaire_denombre_droitSup15) {
		this.nb_ovaire_denombre_droitSup15 = nb_ovaire_denombre_droitSup15;
	}

	public int getNb_ovaire_aspire_droitSup15() {
		return nb_ovaire_aspire_droitSup15;
	}

	public void setNb_ovaire_aspire_droitSup15(int nb_ovaire_aspire_droitSup15) {
		this.nb_ovaire_aspire_droitSup15 = nb_ovaire_aspire_droitSup15;
	}

	public int getNb_ovaire_denombre_gaucheSup15() {
		return nb_ovaire_denombre_gaucheSup15;
	}

	public void setNb_ovaire_denombre_gaucheSup15(int nb_ovaire_denombre_gaucheSup15) {
		this.nb_ovaire_denombre_gaucheSup15 = nb_ovaire_denombre_gaucheSup15;
	}

	public int getNb_ovaire_aspire_gaucheSup15() {
		return nb_ovaire_aspire_gaucheSup15;
	}

	public void setNb_ovaire_aspire_gaucheSup15(int nb_ovaire_aspire_gaucheSup15) {
		this.nb_ovaire_aspire_gaucheSup15 = nb_ovaire_aspire_gaucheSup15;
	}

	public int getNb_cocs()
	{
		return nb_cocs;
	}

	public void setNb_cocs(int nb_cocs)
	{
		this.nb_cocs = nb_cocs;
	}

	public float getTaux_collecte()
	{
		return taux_collecte;
	}

	public void setTaux_collecte(float taux_collecte)
	{
		this.taux_collecte = taux_collecte;
	}

	public String getRemarques()
	{
		return remarques;
	}

	public void setRemarques(String remarques)
	{
		this.remarques = remarques;
	}

	public Long getId()
	{
		return id;
	}

	public void setId(Long id)
	{
		this.id = id;
	}
}
