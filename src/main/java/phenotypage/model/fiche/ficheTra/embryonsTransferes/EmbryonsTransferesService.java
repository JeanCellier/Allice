package phenotypage.model.fiche.ficheTra.embryonsTransferes;

import phenotypage.model.vache.Vache;

/**
 * @author fabien
 */
public interface EmbryonsTransferesService
{
	EmbryonsTransferes createEmbryonsTransferes(boolean semenSexee, String refExperience, String refEmbryons, Vache taureau, char cote, String emplacementColUterine, String faciliteProgression);

	EmbryonsTransferes createEmbryonsTransferes(EmbryonsTransferes embryonsTransferes);

	void delete(EmbryonsTransferes embryonsTransferesToDelete);

	EmbryonsTransferes save(EmbryonsTransferes embryonsTransferes);
}
