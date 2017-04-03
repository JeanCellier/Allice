package phenotypage.model.vache;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import phenotypage.model.pharmacie.produit.Produit;

import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * @author fabien
 */

@Component
public class VacheServiceImpl implements VacheService
{
	@Autowired
	private VacheRepository vacheRepository;

	@Override
	public List<Vache> findAllVache()
	{
		return vacheRepository.findAll();
	}

	@Override
	public Vache createVache(String proprietaire, String num_elevage, String num_identification, long num_travail, int race, Date date_arrivee)
	{
		return vacheRepository.save(new Vache(proprietaire, num_elevage, num_identification, num_travail, race, date_arrivee));
	}

	@Override
	public Vache addVache(Vache vache)
	{
		return vacheRepository.save(vache);
	}

	@Override
	public Vache newVache()
	{
		return new Vache();
	}

	@Override
	public List<Vache> findAllTaureau()
	{
		return vacheRepository.findAllTaureau();
	}

	@Override
	public Vache findByNum_identification(String num_identification)
	{
		return vacheRepository.findBynum_identification(num_identification);
	}

	@Override
	public Optional<Vache> findOne(long id) {
		return Optional.ofNullable(vacheRepository.findOne(id));
	}

	@Override
	public Vache addTaureau(Vache taureau)
	{
		taureau.setMale(true);
		return addVache(taureau);
	}

	@Override
	public Vache save(Vache vache) {
		return vacheRepository.save(vache);
	}


	@Override
	public void delete(Vache vache) {
		vacheRepository.delete(vache);
	}

	@Override
	public void update(Vache vache, String proprietaire, String num_elevage, String num_identification, Long numeroTravail, int race, Date date_arrivee){
		vache.setProprietaire(proprietaire);
		vache.setNum_elevage(num_elevage);
		vache.setNum_identification(num_identification);
		vache.setNum_travail(numeroTravail);
		vache.setRace(race);
		vache.setDate_arrivee(date_arrivee);

		save(vache);
	}
}
