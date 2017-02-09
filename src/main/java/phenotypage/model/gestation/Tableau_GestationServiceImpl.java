package phenotypage.model.gestation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Tableau_GestationServiceImpl implements Tableau_GestationService
{
	@Autowired
	private Tableau_GestationRepository tableau_collecteRepository;

	public List<Tableau_Gestation> findAllTableauGestation()
	{
		return tableau_collecteRepository.findAllTableauGestation();
	}

	@Override
	public Tableau_Gestation newTableauGestation()
	{
		return tableau_collecteRepository.save(new Tableau_Gestation());
	}

	@Override
	public Tableau_Gestation addTableauGestation(Tableau_Gestation tableau_gestation)
	{
		return tableau_collecteRepository.save(tableau_gestation);
	}

}
