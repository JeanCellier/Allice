package phenotypage.model.invitro.collecte;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Tableau_CollecteServiceImpl implements Tableau_CollecteService
{
	@Autowired
	private Tableau_CollecteRepository tableau_collecteRepository;

	public List<Tableau_Collecte> findAllTableauCollecte()
	{
		return tableau_collecteRepository.findAllTableauCollecte();
	}

	@Override
	public Tableau_Collecte newTableauCollecte()
	{
		return tableau_collecteRepository.save(new Tableau_Collecte());
	}

	@Override
	public Tableau_Collecte addTableauCollecte(Tableau_Collecte tableauCollecte)
	{
		return tableau_collecteRepository.save(tableauCollecte);
	}

}
