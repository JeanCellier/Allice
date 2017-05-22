package phenotypage.model.fiche.ficheTra.embryonsTransferes;

import phenotypage.model.vache.Vache;

/**
 * @author fabien
 */
public interface EmbryonsTransferesService
{
	EmbryonsTransferes createEmbryonsTransferes(String refEmbryons, char cote, String emplacementColUterine, int faciliteProgression);

	EmbryonsTransferes createEmbryonsTransferes(EmbryonsTransferes embryonsTransferes);

	void delete(EmbryonsTransferes embryonsTransferesToDelete);

	EmbryonsTransferes save(EmbryonsTransferes embryonsTransferes);

	EmbryonsTransferes update(EmbryonsTransferes embryonsTransferes, String refEmbryons, char cote, String emplacementColUterine, int faciliteprogression);
}
