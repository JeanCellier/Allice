package phenotypage.model.pharmacie;

import phenotypage.model.pharmacie.produit.Produit;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * @author fabien
 */

@Entity
public class Pharmacie implements Serializable
{
	@Id
	@GeneratedValue
	private Long id;
	
	@Column
	private String nom;

	@OneToMany(mappedBy = "pharmacie")
	private List<Produit> stock_produit;

	public Pharmacie()
	{
	}

	public Pharmacie(String nom, List<Produit> stock_produit)
	{
		super();
		this.nom = nom;
		this.stock_produit = stock_produit;
	}
	
	public Pharmacie(String nom)
	{
		super();
		this.nom = nom;
	}

	public Pharmacie(List<Produit> stock_produit)
	{
		super();
		this.stock_produit = stock_produit;
	}

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

	public List<Produit> getStock_produit()
	{
		return stock_produit;
	}

	public void setStock_produit(List<Produit> stock_produit)
	{
		this.stock_produit = stock_produit;
	}
}
