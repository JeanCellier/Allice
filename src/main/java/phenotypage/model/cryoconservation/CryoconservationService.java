package phenotypage.model.cryoconservation;

import java.util.List;


public interface CryoconservationService
{

	List<Cryoconservation> findAllCryoconservation();

	Cryoconservation addCryoconservation(Cryoconservation cryoconservation);

	Cryoconservation newCryoconservation();

	void delete(Cryoconservation cryoconservation);
}
