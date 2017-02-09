package phenotypage.model.donneExistante.qualite;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author fabien
 */

@Component
public class QualiteServiceImpl implements QualiteService
{
	@Autowired
	private QualiteRepository qualiteRepository;

	@Override
	public List<Qualite> findAllQualite()
	{
		return qualiteRepository.findAll();
	}

	@Override
	public Qualite createQualite(String nom, int numero)
	{
		return qualiteRepository.save(new Qualite(nom, numero));
	}

	@Override
	public Qualite addQualite(Qualite qualite)
	{
		return qualiteRepository.save(qualite);
	}

	@Override
	public Qualite newQualite()
	{
		return new Qualite();
	}
}
