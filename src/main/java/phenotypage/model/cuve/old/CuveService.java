package phenotypage.model.cuve.old;

import phenotypage.model.cuve.canister.old.Canister;

import java.util.List;

/**
 * @author fabien
 */

public interface CuveService
{
	List<Cuve> findAllCuve();

	Cuve createCuve(String nom, List<Canister> canisterList);

	Cuve save(Cuve cuve);
}
