package phenotypage.model.cuve.old;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import phenotypage.model.cuve.canister.old.Canister;

import java.util.List;

/**
 * @author fabien
 */

@Component
public class CuveServiceImpl implements CuveService
{
	@Autowired
	private CuveRepository cuveRepository;

	@Override
	public List<Cuve> findAllCuve()
	{
		return cuveRepository.findAll();
	}

	@Override
	public Cuve createCuve(String nom, List<Canister> canisterList)
	{
		Cuve cuve = new Cuve();
		cuve.setNom(nom);
		cuve.setCanisterList(canisterList);

		return save(cuve);
	}

	@Override
	public Cuve save(Cuve cuve)
	{
		return cuveRepository.save(cuve);
	}
}
