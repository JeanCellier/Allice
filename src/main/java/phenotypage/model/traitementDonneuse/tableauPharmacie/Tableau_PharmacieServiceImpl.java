package phenotypage.model.traitementDonneuse.tableauPharmacie;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author fabien
 */

@Component
public class Tableau_PharmacieServiceImpl implements Tableau_PharmacieService
{
	@Autowired
	private Tableau_PharmacieRepository tableau_pharmacieRepository;

	@Override
	public Tableau_Pharmacie createTableau_Pharmacie()
	{
		return tableau_pharmacieRepository.save(new Tableau_Pharmacie());
	}

	@Override
	public Tableau_Pharmacie addTableau_Pharmacie(Tableau_Pharmacie tableau_pharmacie)
	{
		return tableau_pharmacieRepository.save(tableau_pharmacie);
	}

	public List<Tableau_Pharmacie> findAllTableau_Pharmacie()
	{
		return tableau_pharmacieRepository.findAll();
	}

	@Override
	public Tableau_Pharmacie findTableau_PharmacieById(long id)
	{
		return tableau_pharmacieRepository.findTableau_PharmacieById(id);
	}
}
