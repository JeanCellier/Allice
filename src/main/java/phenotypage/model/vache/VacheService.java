package phenotypage.model.vache;

import java.util.Date;
import java.util.List;

/**
 * @author fabien
 */
public interface VacheService
{
	List<Vache> findAll();

	Vache createVache(boolean present, String proprietaire, String nom, String num_elevage, String num_identitifaction, int race, char sexe, Date dateNaissance, String parite, String numPere, String numMere);

	Vache save(Vache vache);

	Vache addVache(Vache vache);

	Vache newVache();

	Vache findByNum_identification(String num_identification);
}
