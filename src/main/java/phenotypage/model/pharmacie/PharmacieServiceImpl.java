package phenotypage.model.pharmacie;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author fabien
 */

@Component
public class PharmacieServiceImpl implements PharmacieService
{
	@Autowired
	private PharmacieRepository pharmacieRepository;

	@Override
	public Pharmacie createPharmacie()
	{
		return pharmacieRepository.save(new Pharmacie());
	}

	@Override
	public Pharmacie addPharmacie(Pharmacie pharmacie)
	{
		return pharmacieRepository.save(pharmacie);
	}

	@Override
	public List<Pharmacie> findAllPharmacie()
	{
		return pharmacieRepository.findAll();
	}

	@Override
	public Pharmacie findPharmacieByNom(String nom)
	{
		return pharmacieRepository.findPharmacieByNom(nom);
	}

	@Override
	public Pharmacie createPharmacie(String nom)
	{
		return pharmacieRepository.save(new Pharmacie(nom));
	}
}
