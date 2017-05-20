package phenotypage.model.cuve.canister.old;

import phenotypage.model.cuve.canister.visoTube.old.VisoTube;
import javax.persistence.*;
import java.util.List;

/**
 * @author fabien
 */

@Entity
public class Canister
{
	@Id
	@GeneratedValue
	private Long id;

	@Column
	private int numero;

	@OneToMany
	private List<VisoTube> visoTubeList;

	public Canister() {}

	public Long getId()
	{
		return id;
	}

	public void setId(Long id)
	{
		this.id = id;
	}

	public int getNumero()
	{
		return numero;
	}

	public void setNumero(int numero)
	{
		this.numero = numero;
	}

	public List<VisoTube> getVisoTubeList() {
		return visoTubeList;
	}

	public void setVisoTubeList(List<VisoTube> visoTubeList) {
		this.visoTubeList = visoTubeList;
	}
}
