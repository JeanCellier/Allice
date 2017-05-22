package phenotypage.model.informationsPIV.milieuMaturation;

import javax.persistence.*;


/**
 * @author fabien
 */

@Entity
public class MilieuMaturation
{
	@Id
	@GeneratedValue
	private Long id;

	@Column
	private String nom;

	@Column
	private String numeroLot;

	public MilieuMaturation(){}

	public Long getId()
	{
		return id;
	}

	public void setId(Long id)
	{
		this.id = id;
	}

	public String getNom()
	{
		return nom;
	}

	public void setNom(String nom)
	{
		this.nom = nom;
	}

	public String getNumeroLot()
	{
		return numeroLot;
	}

	public void setNumeroLot(String numeroLot)
	{
		this.numeroLot = numeroLot;
	}
}
