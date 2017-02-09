package phenotypage.model.donneExistante.cuve;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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
	public Cuve createCuve(String nom, String numeroLot)
	{
		return cuveRepository.save(new Cuve(nom, numeroLot));
	}

	@Override
	public Cuve addCuve(Cuve cuve)
	{
		return cuveRepository.save(cuve);
	}

	@Override
	public Cuve newCuve()
	{
		return new Cuve();
	}
}
