package phenotypage.model.fiche.ficheAba.abattoir;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

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
		return abattoirRepository.save(new Abattoir());
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
	public Optional<Abattoir> findByNom(String nomAbattoir)
	{
		return Optional.ofNullable(abattoirRepository.findByNom(nomAbattoir));
	}
}
