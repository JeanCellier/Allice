package phenotypage.model.gestation;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import phenotypage.model.gestation.tableau_gestation.Tableau_Gestation;
import phenotypage.model.gestation.tableau_gestation.Tableau_GestationService;

@Component
public class GestationServiceImpl implements GestationService
{
	@Autowired
	private GestationRepository repository;

	@Autowired
	private Tableau_GestationService tableau_GestationService;

	@Override
	public Gestation createGestation(List<Tableau_Gestation> tableauGestations, String remarques) {
		Gestation gestation = new Gestation();
		gestation.setRemarques(remarques);
		List<Tableau_Gestation> tableau_gestationSave = new ArrayList<>();

		for(Tableau_Gestation tableau_gestation: tableauGestations){
			tableau_gestationSave.add(tableau_GestationService.createTableauGestation(tableau_gestation));
		}

		gestation.setTableauGestationList(tableau_gestationSave);

		return save(gestation);
	}

	@Override
	public Gestation createGestation(Gestation gestation) {
		List<Tableau_Gestation> tableau_gestationSave = new ArrayList<>();

		for(Tableau_Gestation tableau_gestation: gestation.getTableauGestationList()){
			tableau_gestationSave.add(tableau_GestationService.createTableauGestation(tableau_gestation));
		}

		gestation.setTableauGestationList(tableau_gestationSave);

		return save(gestation);
	}

	@Override
	public void delete(Gestation gestationToDelete)
	{
		repository.delete(gestationToDelete);
	}

	@Override
	public Gestation save(Gestation gestation) {
		return repository.save(gestation);
	}

}
