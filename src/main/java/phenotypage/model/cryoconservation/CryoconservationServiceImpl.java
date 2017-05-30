package phenotypage.model.cryoconservation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import phenotypage.model.operateur.Operateur;

import java.sql.Time;
import java.util.List;
import java.util.Objects;

@Component
public class CryoconservationServiceImpl implements CryoconservationService
{

	@Autowired
	private CryoconservationRepository cryoconservationRepository;

	@Override
	public Cryoconservation createCryoconservation(Cryoconservation cryoconservation) {
		Cryoconservation cryoconservationNew = new Cryoconservation();
		cryoconservationNew.setCongelateur(cryoconservation.getCongelateur());
		cryoconservationNew.setDescMethode(cryoconservation.getDescMethode());
		cryoconservationNew.setHeureMinute(cryoconservation.getHeureMinute());
		cryoconservationNew.setMethodeCongelation(cryoconservation.getMethodeCongelation());
		cryoconservationNew.setOperateur(cryoconservation.getOperateur());
		cryoconservationNew.setRef(cryoconservation.getRef());
		cryoconservationNew.setType(cryoconservation.getType());
		return save(cryoconservationNew);
	}

	@Override
	public Cryoconservation update(Cryoconservation cryoconservation, String ref, Time heureMinute, String methodeCongelation,
								   String congelateur, Operateur operateur, String descMethode, String type) {

		cryoconservation.setCongelateur(congelateur);
		cryoconservation.setDescMethode(descMethode);
		cryoconservation.setHeureMinute(heureMinute);
		cryoconservation.setMethodeCongelation(methodeCongelation);
		cryoconservation.setOperateur(operateur);
		cryoconservation.setRef(ref);
		cryoconservation.setType(type);
		return save(cryoconservation);
	}

	@Override
	public Cryoconservation save(Cryoconservation cryoconservation) {
		return cryoconservationRepository.save(cryoconservation);
	}

	@Override
	public List<Cryoconservation> findAll() {
		return cryoconservationRepository.findAll();
	}

	@Override
	public void delete(Cryoconservation cryoconservation)
	{
		cryoconservationRepository.delete(cryoconservation);
	}

	@Override
	public int determineStatut(Cryoconservation cryoconservation) {
		if(Objects.equals(cryoconservation.getCongelateur(), "") || Objects.equals(cryoconservation.getDescMethode(), "")
				|| cryoconservation.getHeureMinute() == null || Objects.equals(cryoconservation.getMethodeCongelation(), "")
				|| cryoconservation.getOperateur() == null || Objects.equals(cryoconservation.getRef(), "")
				|| Objects.equals(cryoconservation.getType(), "")){
			return 1;
		}
		return 0;
	}

}
