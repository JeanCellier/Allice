package phenotypage.model.cuve.canister.visoTube.old;

import javax.persistence.*;


/**
 * @author fabien
 */

@Entity
public class VisoTube
{
	@Id
	@GeneratedValue
	private Long id;

	@Column
	private int numero;

	@Column
	private String couleur;

//	@OneToMany
//	private List<ContenuVisotube> contenu;

	public VisoTube() {}

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

	public String getCouleur()
	{
		return couleur;
	}

	public void setCouleur(String couleur)
	{
		this.couleur = couleur;
	}

}
