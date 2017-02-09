package phenotypage.model.donneExistante.abattoir;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author fabien
 */

@Component
public class AbattoirServiceImpl implements AbattoirService
{
	@Autowired
	private AbattoirRepository abattoirRepository;

	@Override
	public List<Abattoir> findAllAbattoir()
	{
		return abattoirRepository.findAll();
	}

	@Override
	public Abattoir createAbattoir(String nom)
	{
		return abattoirRepository.save(new Abattoir(nom));
	}

	@Override
	public Abattoir addAbattoir(Abattoir abattoir)
	{
		return abattoirRepository.save(abattoir);
	}

	@Override
	public Abattoir newAbattoir()
	{
		return new Abattoir();
	}

	@Override
	public Abattoir findByNom(String nomAbattoir)
	{
		return abattoirRepository.findByNom(nomAbattoir);
	}
}
