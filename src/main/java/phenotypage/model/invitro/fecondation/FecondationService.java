package phenotypage.model.invitro.fecondation;

import java.util.List;

public interface FecondationService
{
	List<Fecondation> findAllFecondation();

	Fecondation newFecondation();

	Fecondation addFecondation(Fecondation fecondation);

	void delete(Fecondation fecondation);
}
