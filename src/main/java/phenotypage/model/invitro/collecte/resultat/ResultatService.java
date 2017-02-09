package phenotypage.model.invitro.collecte.resultat;

import java.util.List;

public interface ResultatService
{
	List<Resultat> findAllResultat();

	Resultat newResultat();

	Resultat addResultat(Resultat resultat);
}
