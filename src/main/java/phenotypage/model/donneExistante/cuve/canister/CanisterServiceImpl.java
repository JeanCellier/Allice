package phenotypage.model.donneExistante.cuve.canister;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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
	public Canister createCanister(int numero)
	{
		return canisterRepository.save(new Canister(numero));
	}

	@Override
	public Canister addCanister(Canister canister)
	{
		return canisterRepository.save(canister);
	}

	@Override
	public Canister newCanister()
	{
		return new Canister();
	}
}
