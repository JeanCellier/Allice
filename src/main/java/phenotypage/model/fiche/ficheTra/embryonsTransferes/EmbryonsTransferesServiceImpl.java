package phenotypage.model.fiche.ficheTra.embryonsTransferes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import phenotypage.model.vache.Vache;

/**
 * @author fabien
 */

@Component
public class EmbryonsTransferesServiceImpl implements EmbryonsTransferesService
{
	@Autowired
	private EmbryonsTransferesRepository repository;


	@Override
	public EmbryonsTransferes createEmbryonsTransferes(boolean semenceSexee, String refExperience, String refEmbryons, Vache taureau, char cote, String emplacementColUterine, String faciliteProgression) {
		EmbryonsTransferes embryonsTransferes = new EmbryonsTransferes();
		embryonsTransferes.setRefEmbryons(refEmbryons);
		embryonsTransferes.setCote(cote);
		embryonsTransferes.setEmplacementColUterine(emplacementColUterine);

		return save(embryonsTransferes);
	}

	@Override
	public EmbryonsTransferes createEmbryonsTransferes(EmbryonsTransferes embryonsTransferes) {
		return save(embryonsTransferes);
	}

	@Override
	public void delete(EmbryonsTransferes embryonsTransferesToDelete)
	{
		repository.delete(embryonsTransferesToDelete);
	}

	@Override
	public EmbryonsTransferes save(EmbryonsTransferes embryonsTransferes) {
		return repository.save(embryonsTransferes);
	}

	@Override
	public EmbryonsTransferes update(EmbryonsTransferes embryonsTransferes, boolean semenceSexee, String refExperience, String refEmbryons, Vache taureau, char cote, String emplacementColUterine, String faciliteprogression) {
		embryonsTransferes.setRefEmbryons(refEmbryons);
		embryonsTransferes.setCote(cote);
		embryonsTransferes.setEmplacementColUterine(emplacementColUterine);

		return save(embryonsTransferes);
	}
}
