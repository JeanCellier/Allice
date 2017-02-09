package phenotypage.model.gestation;

import java.util.List;

public interface GestationService
{
	List<Gestation> findAllGestation();

	Gestation newGestation();

	Gestation addGestation(Gestation gestation);

	void delete(Gestation gestationToDelete);
}
