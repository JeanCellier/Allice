package phenotypage.model.donneExistante.typeCulture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author fabien
 */

@Component
public class TypeCultureServiceImpl implements TypeCultureService
{
	@Autowired
	private TypeCultureRepository typeCultureRepository;

	@Override
	public List<TypeCulture> findAllTypeCulture()
	{
		return typeCultureRepository.findAll();
	}

	@Override
	public TypeCulture createTypeCulture(String nom, String numeroLot)
	{
		return typeCultureRepository.save(new TypeCulture(nom, numeroLot));
	}

	@Override
	public TypeCulture addTypeCulture(TypeCulture typeCulture)
	{
		return typeCultureRepository.save(typeCulture);
	}

	@Override
	public TypeCulture newTypeCulture()
	{
		return new TypeCulture();
	}

	@Override
	public TypeCulture findByNom(String nomTypeCulture)
	{
		return typeCultureRepository.findByNom(nomTypeCulture);
	}
}
