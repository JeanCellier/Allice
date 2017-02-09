package phenotypage.model.fiche.ficheCarriere;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author fabien
 */

@Component
public class
FicheCarriereServiceImpl implements FicheCarriereService
{
	@Autowired
	private FicheCarriereRepository ficheCarriereRepository;

	@Override
	public List<FicheCarriere> findAllFicheCarriere()
	{
		return ficheCarriereRepository.findAll();
	}

	@Override
	public FicheCarriere createFichieAba(String nom)
	{
		return ficheCarriereRepository.save(new FicheCarriere(nom));
	}

	@Override
	public FicheCarriere addFicheCarriere(FicheCarriere ficheCarriere)
	{
		return ficheCarriereRepository.save(ficheCarriere);
	}

	@Override
	public FicheCarriere newFicheCarriere()
	{
		return new FicheCarriere();
	}

	@Override
	public FicheCarriere findByNom(String nom)
	{
		return ficheCarriereRepository.findByNom(nom);
	}

	@Override
	public long countFicheCarriere()
	{
		return ficheCarriereRepository.count();
	}
}
