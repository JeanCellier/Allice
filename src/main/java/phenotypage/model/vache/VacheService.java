package phenotypage.model.vache;

import phenotypage.model.pharmacie.produit.Produit;

import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * @author fabien
 */
public interface VacheService
{
	List<Vache> findAllVache();

	Vache createVache(String proprietaire, String num_elevage, String num_identification, long num_travail, int race, Date date_arrivee);

	Vache addVache(Vache vache);

	Vache newVache();

	void delete(Vache vache);

	List<Vache> findAllTaureau();

	Vache findByNum_identification(String num_identification);

	Vache addTaureau(Vache taureau);

	Optional<Vache> findOne(long id);

}
