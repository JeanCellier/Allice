package phenotypage.model.cuve.old;

import phenotypage.model.cuve.canister.old.Canister;

import javax.persistence.*;
import java.util.List;

/**
 * @author fabien
 */

@Entity
public class Cuve
{
	@Id
	@GeneratedValue
	private Long id;

	@Column
	private String nom;

	@OneToMany
	private List<Canister> canisterList;

	public Cuve() {}

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

	public List<Canister> getCanisterList() {
		return canisterList;
	}

	public void setCanisterList(List<Canister> canisterList) {
		this.canisterList = canisterList;
	}
}
