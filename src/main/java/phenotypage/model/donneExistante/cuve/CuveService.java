package phenotypage.model.donneExistante.cuve;

import java.util.List;

/**
 * @author fabien
 */

public interface CuveService
{
	List<Cuve> findAllCuve();

	Cuve createCuve(String nom, String numeroLot);

	Cuve addCuve(Cuve cuve);

	Cuve newCuve();
}
