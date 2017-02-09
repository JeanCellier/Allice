package phenotypage.model.fiche.ficheIa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author fabien
 */

@Component
public class
FicheIaServiceImpl implements FicheIaService
{
	@Autowired
	private FicheIaRepository ficheIaRepository;

	@Override
	public List<FicheIa> findAllFicheIa()
	{
		return ficheIaRepository.findAll();
	}

	@Override
	public FicheIa createFichieIa(String nom)
	{
		return ficheIaRepository.save(new FicheIa(nom));
	}

	@Override
	public FicheIa addFicheIa(FicheIa fichieIa)
	{
		return ficheIaRepository.save(fichieIa);
	}

	@Override
	public FicheIa newFicheIa()
	{
		return new FicheIa();
	}

	@Override
	public FicheIa findByNom(String nom)
	{
		return ficheIaRepository.findByNom(nom);
	}

	@Override
	public long countFicheIa()
	{
		return ficheIaRepository.count();
	}

	@Override
	public List<FicheIa> findFicheIaSNIG()
	{
		return ficheIaRepository.findFicheIaSNIG();
	}
}
