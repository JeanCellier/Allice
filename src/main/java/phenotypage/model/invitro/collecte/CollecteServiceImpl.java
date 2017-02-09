package phenotypage.model.invitro.collecte;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CollecteServiceImpl implements CollecteService
{

	@Autowired
	private CollecteRepository collecteRepository;

	public Collecte createExemple(String name)
	{
		return collecteRepository.save(new Collecte());
	}

	public List<Collecte> findAllCollecte()
	{
		return collecteRepository.findAllCollecte();
	}

	@Override
	public Collecte newCollecte()
	{
		return new Collecte();
	}

	@Override
	public Collecte addCollecte(Collecte collecte)
	{
		return collecteRepository.save(collecte);
	}

	@Override
	public void delete(Collecte collecte)
	{
		collecteRepository.delete(collecte);
	}

}
