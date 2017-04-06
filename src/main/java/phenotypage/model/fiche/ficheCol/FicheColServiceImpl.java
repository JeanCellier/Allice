package phenotypage.model.fiche.ficheCol;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author fabien
 */

@Component
public class
FicheColServiceImpl implements FicheColService
{
	@Autowired
	private FicheColRepository ficheColRepository;

	@Override
	public List<FicheCol> findAllFicheCol()
	{
		return ficheColRepository.findAll();
	}

	@Override
	public FicheCol createFicheCol(String nom)
	{
		return ficheColRepository.save(new FicheCol());
	}

	@Override
	public FicheCol addFicheCol(FicheCol FicheCol)
	{
		return ficheColRepository.save(FicheCol);
	}

	@Override
	public FicheCol newFicheCol()
	{
		return new FicheCol();
	}

	@Override
	public FicheCol findByNom(String nom)
	{
		return ficheColRepository.findByNom(nom);
	}

	@Override
	public long countFicheCol()
	{
		return ficheColRepository.count();
	}
}
