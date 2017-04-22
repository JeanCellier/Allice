package phenotypage.model.invitro.collecte;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created with magic
 * User: simoe
 * Date: 22/04/2017 00:12
 * Project: appPhenotypage
 */
@Service
public class Tableau_MaturationServiceImpl implements Tableau_MaturationService {

    private final Tableau_MaturationRepository repository;

    @Autowired
    public Tableau_MaturationServiceImpl(Tableau_MaturationRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Tableau_Maturation> findAllTableauMaturation() {
        return repository.findAll();
    }

    @Override
    public Tableau_Maturation createTableau_Mturation(String groupeExperimentauxMIV, int nbOvocyte) {
        Tableau_Maturation tableauMaturation = new Tableau_Maturation();
        tableauMaturation.setNbOvocyte(nbOvocyte);
        tableauMaturation.setGroupeExperimentauxMIV(groupeExperimentauxMIV);
        return repository.save(tableauMaturation);
    }
}
