package phenotypage.model.cuve;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

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
	public void delete(Cuve cuve) {
		cuveRepository.delete(cuve);
	}

	@Override
	public Cuve newCuve()
	{
		return new Cuve();
	}

	@Override
	public Optional<Cuve> findOne(long id) {
		return Optional.ofNullable(cuveRepository.findOne(id));
	}

	@Override
	public void update(Cuve cuve, String nom, String designation) {
		cuve.setNom(nom);
		cuve.setDesignation(designation);

		save(cuve);
	}

	@Override
	public Cuve save(Cuve cuve) {
		return cuveRepository.save(cuve);
	}

	@Override
	public List<String> findDistinctDesignation(String tag) {
		return cuveRepository.findDistinctDestignation(tag);
	}

	@Override
	public List<String> findDistinctName(String tag) {
		return cuveRepository.findDistinctNames(tag);
	}
}
