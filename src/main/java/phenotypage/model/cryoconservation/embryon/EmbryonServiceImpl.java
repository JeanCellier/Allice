package phenotypage.model.cryoconservation.embryon;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author fabien
 */

@Component
public class EmbryonServiceImpl implements EmbryonService
{
	@Autowired
	private EmbryonRepository embryonRepository;

	@Override
	public List<Embryon> findAll()
	{
		return embryonRepository.findAll();
	}

	@Override
	public Embryon save(Embryon tableauDetail)
	{
		return embryonRepository.save(tableauDetail);
	}

	@Override
	public void delete(Embryon embryon) {

	}

	@Override
	public Embryon create(Embryon embryon) {
		Embryon embryonNew = new Embryon();
		embryonNew.setCryoconserve(embryon.isCryoconserve());
		embryonNew.setDetruit(embryon.isDetruit());
		embryonNew.setFicheAba(embryon.getFicheAba());
		embryonNew.setFicheCol(embryon.getFicheCol());
		embryonNew.setFicheOpu(embryon.getFicheOpu());
		embryonNew.setNumeroEmbryon(embryon.getNumeroEmbryon());
		embryonNew.setNumeroReceveuse(embryon.getNumeroReceveuse());
		embryonNew.setQualite(embryon.getQualite());
		embryonNew.setReferenceTransfert(embryon.getReferenceTransfert());
		embryonNew.setRemarque(embryon.getRemarque());
		embryonNew.setStade(embryon.getStade());
		return save(embryonNew);
	}
}
