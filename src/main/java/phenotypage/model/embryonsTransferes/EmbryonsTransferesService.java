package phenotypage.model.embryonsTransferes;

import java.util.List;

/**
 * @author fabien
 */
public interface EmbryonsTransferesService
{
	List<EmbryonsTransferes> findAllEmbryonsTransferes();

	EmbryonsTransferes createEmbryonsTransferes();

	EmbryonsTransferes addEmbryonsTransferes(EmbryonsTransferes embryonsTransferes);

	EmbryonsTransferes newEmbryonsTransferes();

	void delete(EmbryonsTransferes embryonsTransferesToDelete);
}
