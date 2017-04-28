package phenotypage.model.donneesExistantes.stade;

import javax.persistence.*;

/**
 * @author fabien
 */

@Entity
public class Stade
{
	@Id
	@GeneratedValue
	private Long id;

	@Column
	private int numero;

	@Column
	private String nom;

	public Stade() {}

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

	public int getNumero()
	{
		return numero;
	}

	public void setNumero(int numero)
	{
		this.numero = numero;
	}
}
