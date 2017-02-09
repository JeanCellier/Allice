package phenotypage.model.donneExistante.cuve.canister;

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
