package phenotypage.model.donneesExistantes.cuve;

import java.util.List;
import java.util.Optional;

/**
 * @author fabien
 */

public interface CuveService
{
	List<Cuve> findAllCuve();

	Cuve createCuve(String nom, String numeroLot);

	Cuve addCuve(Cuve cuve);

	void delete(Cuve cuve);

	Cuve newCuve();

	Optional<Cuve> findOne(long id);

	void update(Cuve cuve, String nom, String designation);

	Cuve save(Cuve cuve);

	List<String> findDistinctDesignation(String tag);

	List<String> findDistinctName(String tag);
}
