package phenotypage.model.vache;

import phenotypage.model.Destinataire.Destinataire;
import phenotypage.model.fiche.ficheTra.FicheTra;
import phenotypage.model.programme.Programme;

import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * @author fabien
 */
public interface VacheService
{
	List<Vache> findAll();

	Vache createVache(boolean present, String proprietaire, String num_elevage, String num_identificaction, int race, Date dateNaissance,
					  Date entreeQuarantine, Date derniereMiseRepro, Date sortiePension, Date entreeStation, Date sortieStation, String EMCO, String EMVI,
					  String numPere, String numMere, String venduA, String modeRproduction, char DG01, Programme programme,
					  String remarques, Destinataire destinataire);

	Vache updateVache(Vache vacheToUpdate, boolean present, String proprietaire, String num_elevage, String num_identificaction, int race, Date dateNaissance,
					  Date entreeQuarantine, Date derniereMiseRepro, Date sortiePension, Date entreeStation, Date sortieStation, String EMCO, String EMVI,
					  String numPere, String numMere, String venduA, String modeRproduction, char DG01, Programme programme,
					  String remarques, Destinataire destinataire);

	Vache save(Vache vache);

	Vache addVache(Vache vache);

	Optional<Vache> findOne(long id);

	Vache newVache();

	void delete(Vache vache);

	Optional<Vache> findByNum_identification(String num_identification);

    List<String> findNumIdByNumTravail(String tag);
}
