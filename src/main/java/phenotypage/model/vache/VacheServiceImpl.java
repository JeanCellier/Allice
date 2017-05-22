package phenotypage.model.vache;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.Instant;
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
	public List<Vache> findAll()
	{
		return vacheRepository.findAll();
	}

	@Override
	public Vache createVache(boolean present, String proprietaire, String nom, String num_elevage, String num_identitifaction, int race, char sexe, Date dateNaissance, String parite, String numPere, String numMere)
	{
		Vache vache = new Vache();
		vache.setPresent(present);
		vache.setProprietaire(proprietaire);
		vache.setNom(nom);
		vache.setNum_elevage(num_elevage);
		vache.setNum_identification(num_identitifaction);
		vache.setNum_travail(num_identitifaction.substring(8,11));
		vache.setRace(race);
		vache.setSexe(sexe);
		vache.setDateNaissance(dateNaissance);
		vache.setParite(parite);
		long diffDates = dateNaissance.getTime() - Date.from(Instant.now()).getTime();
		vache.setAgeMois((float)diffDates/1000/60/60/24/30);
		vache.setNumPere(numPere);
		vache.setNumMere(numMere);

		return save(vache);
	}

	@Override
	public Vache save(Vache vache) {
		return  vacheRepository.save(vache);
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
	public Optional<Vache> findByNum_identification(String num_identification)
	{
		return Optional.ofNullable(vacheRepository.findBynum_identification(num_identification));
	}

	@Override
	public List<String> findNumIdByNumTravail(String tag) {
		return vacheRepository.findNumIdByNumTravail(tag);
	}
}
