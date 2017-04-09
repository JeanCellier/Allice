package phenotypage.model.informationsPIV;

import phenotypage.model.informationsPIV.fiv.FIV;
import phenotypage.model.informationsPIV.milieuMaturation.MilieuMaturation;
import phenotypage.model.operateur.Operateur;
import phenotypage.model.informationsPIV.typeCulture.TypeCulture;

import javax.persistence.*;

@Entity
public class Informations_PIV
{
	@Id
	@GeneratedValue
	private Long id;

	@ManyToOne
	private Operateur operateur;

	@ManyToOne
	private MilieuMaturation milieuMaturation;

	@ManyToOne
	private FIV fiv;

	@ManyToOne
	private TypeCulture typeCulture;

	public Informations_PIV() {}

	public Long getId()
	{
		return id;
	}

	public void setId(Long id)
	{
		this.id = id;
	}

	public MilieuMaturation getMilieuMaturation()
	{
		return milieuMaturation;
	}

	public void setMilieuMaturation(MilieuMaturation milieuMaturation)
	{
		this.milieuMaturation = milieuMaturation;
	}

	public FIV getFiv()
	{
		return fiv;
	}

	public void setFiv(FIV fiv)
	{
		this.fiv = fiv;
	}

	public TypeCulture getTypeCulture()
	{
		return typeCulture;
	}

	public void setTypeCulture(TypeCulture typeCulture)
	{
		this.typeCulture = typeCulture;
	}

	public Operateur getOperateur() {
		return operateur;
	}

	public void setOperateur(Operateur operateur) {
		this.operateur = operateur;
	}
}
