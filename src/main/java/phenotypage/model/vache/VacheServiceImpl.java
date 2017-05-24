package phenotypage.model.vache;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import phenotypage.model.Destinataire.Destinataire;
import phenotypage.model.Destinataire.DestinataireRepository;
import phenotypage.model.Destinataire.DestinataireService;
import phenotypage.model.fiche.ficheTra.FicheTra;
import phenotypage.model.programme.Programme;

import java.time.Instant;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Objects;

/**
 * @author fabien
 */

@Component
public class VacheServiceImpl implements VacheService
{
	@Autowired
	private VacheRepository vacheRepository;

	@Autowired
	private DestinataireService destinataireService;

	@Override
	public List<Vache> findAll()
	{
		return vacheRepository.findAll();
	}

	@Override
	public Vache createVache(boolean present, String proprietaire, String num_elevage, String num_identificaction, int race,
							 Date dateNaissance, Date entreeQuarantine, Date derniereMiseRepro, Date sortiePension, Date entreeStation, Date sortieStation,
							 String EMCO, String EMVI, String numPere, String numMere, String venduA, String modeRproduction, char DG01, Programme programme,
							 String remarques, Destinataire destinataire) {
		Vache vache = new Vache();
		vache.setPresent(present);
		vache.setProprietaire(proprietaire);
		vache.setNum_elevage(num_elevage);
		vache.setNum_identification(num_identificaction);
		vache.setNum_travail(num_identificaction.substring(8,11));
		vache.setRace(race);
		vache.setSexe(new Character('F'));
		vache.setDateNaissance(dateNaissance);
		long diffDates = dateNaissance.getTime() - Date.from(Instant.now()).getTime();
		vache.setAgeMois((float)diffDates/1000/60/60/24/30);
		vache.setNumPere(numPere);
		vache.setNumMere(numMere);
		if(destinataire != null){
			Destinataire dest = destinataireService.createDestinataire(destinataire.getNom(), destinataire.getTypeDestination(), destinataire.getAdresse());
			vache.setDestinataire(dest);
		}
		vache.setEntreeQuarantaine(entreeQuarantine);
		vache.setDateDerniereMiseRepro(derniereMiseRepro);
		vache.setSortiePension(sortiePension);
		vache.setSortieStation(sortieStation);
		vache.setEntreeStation(entreeStation);
		vache.setEMCO(EMCO);
		vache.setEMVI(EMVI);
		vache.setVenduA(venduA);
		vache.setModeReproduction(modeRproduction);
		vache.setDG01(DG01);
		vache.setProgramme(programme);
		vache.setRemarques(remarques);

		return save(vache);
	}

	@Override
	public Vache updateVache(Vache vacheToUpdate, boolean present, String proprietaire, String num_elevage, String num_identificaction, int race,
							 Date dateNaissance, Date entreeQuarantine, Date derniereMiseRepro, Date sortiePension,
							 Date entreeStation, Date sortieStation, String EMCO, String EMVI, String numPere, String numMere, String venduA, String modeRproduction,
							 char DG01, Programme programme, String remarques, Destinataire destinataire) {

		if(destinataire != null){
			if(vacheToUpdate.getDestinataire() != null) {
				if (!Objects.equals(destinataire.getId(), vacheToUpdate.getDestinataire().getId())) {
					Destinataire destinataireToDelete = vacheToUpdate.getDestinataire();
					vacheToUpdate.setDestinataire(destinataireService.createDestinataire(destinataire.getNom(), destinataire.getTypeDestination(), destinataire.getAdresse()));
					destinataireService.delete(destinataireToDelete);
				}
			}else{
				vacheToUpdate.setDestinataire(destinataireService.createDestinataire(destinataire.getNom(), destinataire.getTypeDestination(), destinataire.getAdresse()));
			}
		}

		vacheToUpdate.setPresent(present);
		vacheToUpdate.setProprietaire(proprietaire);
		vacheToUpdate.setNum_elevage(num_elevage);
		vacheToUpdate.setNum_identification(num_identificaction);
		vacheToUpdate.setNum_travail(num_identificaction.substring(8,11));
		vacheToUpdate.setRace(race);
		vacheToUpdate.setSexe(new Character('F'));
		vacheToUpdate.setDateNaissance(dateNaissance);
		long diffDates = dateNaissance.getTime() - Date.from(Instant.now()).getTime();
		vacheToUpdate.setAgeMois((float)diffDates/1000/60/60/24/30);
		vacheToUpdate.setNumPere(numPere);
		vacheToUpdate.setNumMere(numMere);
		vacheToUpdate.setEntreeQuarantaine(entreeQuarantine);
		vacheToUpdate.setDateDerniereMiseRepro(derniereMiseRepro);
		vacheToUpdate.setSortiePension(sortiePension);
		vacheToUpdate.setSortieStation(sortieStation);
		vacheToUpdate.setEntreeStation(entreeStation);
		vacheToUpdate.setEMCO(EMCO);
		vacheToUpdate.setEMVI(EMVI);
		vacheToUpdate.setVenduA(venduA);
		vacheToUpdate.setModeReproduction(modeRproduction);
		vacheToUpdate.setDG01(DG01);
		vacheToUpdate.setProgramme(programme);
		vacheToUpdate.setRemarques(remarques);

		return save(vacheToUpdate);
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

	@Override
	public void delete(Vache vache) {
		vacheRepository.delete(vache);
	}

	@Override
	public Optional<Vache> findOne(long id) {
		return Optional.ofNullable(vacheRepository.findOne(id));
	}

}
