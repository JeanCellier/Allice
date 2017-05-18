package phenotypage.model.cryoconservation.stade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author fabien
 */

@Component
public class StadeServiceImpl implements StadeService
{
	@Autowired
	private StadeRepository stadeRepository;

	@Override
	public List<Stade> findAllStade()
	{
		return stadeRepository.findAll();
	}

	@Override
	public Stade createStade(String nom, int numero)
	{
		return stadeRepository.save(new Stade());
	}

	@Override
	public Stade addStade(Stade stade)
	{
		return stadeRepository.save(stade);
	}

	@Override
	public Stade newStade()
	{
		return new Stade();
	}
}
