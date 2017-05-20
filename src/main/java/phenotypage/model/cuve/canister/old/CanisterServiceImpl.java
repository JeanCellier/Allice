package phenotypage.model.cuve.canister.old;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import phenotypage.model.cuve.canister.visoTube.old.VisoTube;

import java.util.List;

/**
 * @author fabien
 */

@Component
public class CanisterServiceImpl implements CanisterService
{
	@Autowired
	private CanisterRepository canisterRepository;

	@Override
	public List<Canister> findAllCanister()
	{
		return canisterRepository.findAll();
	}

	@Override
	public Canister createCanister(int numero, List<VisoTube> visoTubeList)
	{
		Canister canister = new Canister();
		canister.setNumero(numero);
		canister.setVisoTubeList(visoTubeList);
		return save(canister);
	}

	@Override
	public Canister save(Canister canister)
	{
		return canisterRepository.save(canister);
	}
}
