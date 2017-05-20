package phenotypage.model.cuve.canister.old;

import phenotypage.model.cuve.canister.visoTube.old.VisoTube;

import java.util.List;

/**
 * @author fabien
 */

public interface CanisterService
{
	List<Canister> findAllCanister();

	Canister createCanister(int numero, List<VisoTube> visoTubeList);

	Canister save(Canister canister);
}
