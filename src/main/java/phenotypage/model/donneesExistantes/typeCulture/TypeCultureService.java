package phenotypage.model.donneesExistantes.typeCulture;

import java.util.List;

/**
 * @author fabien
 */
public interface TypeCultureService
{
	List<TypeCulture> findAllTypeCulture();

	TypeCulture createTypeCulture(String nom, String numeroLot);

	TypeCulture addTypeCulture(TypeCulture typeCulture);

	TypeCulture newTypeCulture();

	TypeCulture findByNom(String nomTypeCulture);
}
