package phenotypage.model.vache;

import java.util.List;

/**
 * @author fabien
 */
public interface VacheService
{
	List<Vache> findAllVache();

	Vache createVache(String proprietaire, String num_elevage, String num_identification, long num_travail, int race);

	Vache addVache(Vache vache);

	Vache newVache();

	List<Vache> findAllTaureau();

	Vache findByNum_identification(String num_identification);

	Vache addTaureau(Vache taureau);
}
