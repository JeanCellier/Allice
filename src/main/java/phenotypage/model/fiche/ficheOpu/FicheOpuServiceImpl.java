package phenotypage.model.fiche.ficheOpu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author fabien
 */

@Component
public class
FicheOpuServiceImpl implements FicheOpuService
{
	@Autowired
	private FicheOpuRepository ficheOpuRepository;

	@Override
	public List<FicheOpu> findAllFicheOpu()
	{
		return ficheOpuRepository.findAll();
	}

	@Override
	public FicheOpu createFichieOpu(String nom)
	{
		return ficheOpuRepository.save(new FicheOpu(nom));
	}

	@Override
	public FicheOpu addFicheOpu(FicheOpu fichieOpu)
	{
		return ficheOpuRepository.save(fichieOpu);
	}

	@Override
	public FicheOpu newFicheOpu()
	{
		return new FicheOpu();
	}

	@Override
	public FicheOpu findByNom(String nom)
	{
		return ficheOpuRepository.findByNom(nom);
	}

	@Override
	public long countFicheOpu()
	{
		return ficheOpuRepository.count();
	}

	@Override
	public List<FicheOpu> findFicheOpuSNIG()
	{
		return ficheOpuRepository.findFicheOpuSNIG();
	}
}
