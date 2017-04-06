package phenotypage.model.informationsPIV;

import phenotypage.model.donneesExistantes.fiv.FIV;
import phenotypage.model.milieuMaturation.MilieuMaturation;
import phenotypage.model.donneesExistantes.operateur.Operateur;
import phenotypage.model.donneesExistantes.typeCulture.TypeCulture;
import java.util.List;
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
