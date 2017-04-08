package phenotypage.model.traitementDonneuse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.util.List;

/**
 * @author fabien
 */

@Component
public class Traitement_DonneuseServiceImpl implements Traitement_DonneuseService
{
	@Autowired
	private Traitement_DonneuseRepository repository;

	@Override
	public Traitement_Donneuse createTraitement_Donneuse(Date dateRef, List<Tableau_Donneuse> tableau_donneuses, boolean naturel,
									 boolean ponctionFollicule, int nbFollicules, int nbDroite, int nbGauche,
									 boolean imageEcho, boolean superovulation, String typeFsh, float pourcDose){

		return save(new Traitement_Donneuse());
	}

	@Override
	public Traitement_Donneuse addTraitement_Donneuse(Traitement_Donneuse traitement_donneuse)
	{
		return repository.save(traitement_donneuse);
	}

	public List<Traitement_Donneuse> findAllTraitement_Donneuse()
	{
		return repository.findAll();
	}

	@Override
	public Traitement_Donneuse findTraitement_DonneuseById(long id)
	{
		return repository.findTraitement_DonneuseById(id);
	}

	@Override
	public Traitement_Donneuse newTraitementDonneuse()
	{
		return new Traitement_Donneuse();
	}

	@Override
	public void delete(Traitement_Donneuse traitement_donneuse)
	{
		repository.delete(traitement_donneuse);
	}

	@Override
	public Traitement_Donneuse save(Traitement_Donneuse traitement_donneuse) {
		return repository.save(traitement_donneuse);
	}
}
