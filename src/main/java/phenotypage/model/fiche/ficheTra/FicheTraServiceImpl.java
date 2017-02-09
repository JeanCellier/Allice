package phenotypage.model.fiche.ficheTra;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author fabien
 */

@Component
public class
FicheTraServiceImpl implements FicheTraService
{
	@Autowired
	private FicheTraRepository ficheTraRepository;

	@Override
	public List<FicheTra> findAllFicheTra()
	{
		return ficheTraRepository.findAll();
	}

	@Override
	public FicheTra createFichieTra(String nom)
	{
		return ficheTraRepository.save(new FicheTra(nom));
	}

	@Override
	public FicheTra addFicheTra(FicheTra fichieTra)
	{
		return ficheTraRepository.save(fichieTra);
	}

	@Override
	public FicheTra newFicheTra()
	{
		return new FicheTra();
	}

	@Override
	public FicheTra findByNom(String nom)
	{
		return ficheTraRepository.findByNom(nom);
	}

	@Override
	public long countFicheTra()
	{
		return ficheTraRepository.count();
	}

	@Override
	public List<FicheTra> findFicheTraSNIG()
	{
		return ficheTraRepository.findFicheTraSNIG();
	}
}
