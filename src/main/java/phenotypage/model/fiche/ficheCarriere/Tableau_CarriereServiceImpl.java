package phenotypage.model.fiche.ficheCarriere;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Tableau_CarriereServiceImpl implements Tableau_CarriereService
{
	@Autowired
	private Tableau_CarriereRepository tableau_collecteRepository;

	public List<Tableau_Carriere> findAllTableauCarriere()
	{
		return tableau_collecteRepository.findAllTableauCarriere();
	}

	@Override
	public Tableau_Carriere newTableauCarriere()
	{
		return tableau_collecteRepository.save(new Tableau_Carriere());
	}

	@Override
	public Tableau_Carriere addTableauCarriere(Tableau_Carriere TableauCarriere)
	{
		return tableau_collecteRepository.save(TableauCarriere);
	}

}
