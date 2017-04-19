package phenotypage.model.donneesExistantes.cuve.canister;

import java.util.List;

/**
 * @author fabien
 */

public interface CanisterService
{
	List<Canister> findAllCanister();

	Canister createCanister(int numero);

	Canister addCanister(Canister canister);

	Canister newCanister();
}