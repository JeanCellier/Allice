package phenotypage.model.invitro.collecte.resultat;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ResultatServiceImpl implements ResultatService
{

	@Autowired
	private ResultatRepository resultatRepository;

	public Resultat createResultat(String name)
	{
		return resultatRepository.save(new Resultat());
	}

	public List<Resultat> findAllResultat()
	{
		return resultatRepository.findAll();
	}

	@Override
	public Resultat newResultat()
	{
		return new Resultat();
	}

	@Override
	public Resultat addResultat(Resultat resultat)
	{
		return resultatRepository.save(resultat);
	}

}
