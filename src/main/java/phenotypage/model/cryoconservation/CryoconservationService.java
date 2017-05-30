package phenotypage.model.cryoconservation;

import phenotypage.model.operateur.Operateur;

import java.sql.Time;
import java.util.List;


public interface CryoconservationService
{

	Cryoconservation createCryoconservation(Cryoconservation cryoconservation);

	Cryoconservation update(Cryoconservation cryoconservation, String ref, Time heureMinute, String methodeCongelation,
							String congelateur, Operateur operateur, String descMethode, String type);

	Cryoconservation save(Cryoconservation cryoconservation);

	List<Cryoconservation> findAll();

	void delete(Cryoconservation cryoconservation);

	int determineStatut(Cryoconservation cryoconservation);
}
