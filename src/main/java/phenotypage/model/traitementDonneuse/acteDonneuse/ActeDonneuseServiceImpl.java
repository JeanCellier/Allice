package phenotypage.model.traitementDonneuse.acteDonneuse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by nicolas on 29/04/17.
 */
@Component
public class ActeTraitementServiceImpl implements ActeTraitementService {
    @Autowired
    private ActeTraitementRepository repository;

    @Override
    public ActeDonneuse createTraitement(int decalageJour, float decalageHeure, String acte) {
        ActeDonneuse acteDonneuse = new ActeDonneuse();
        acteDonneuse.setActe(acte);
        acteDonneuse.setDecalageHeure(decalageHeure);
        acteDonneuse.setDecalageJour(decalageJour);
        return save(acteDonneuse);
    }

    @Override
    public ActeDonneuse save(ActeDonneuse acteDonneuse) {
        return repository.save(acteDonneuse);
    }

    @Override
    public void delete(ActeDonneuse acteDonneuse) {
        repository.delete(acteDonneuse);
    }

    @Override
    public ActeDonneuse updateTraitement(ActeDonneuse acteDonneuse, int decalageJour, float decalageHeure, String acte) {
        acteDonneuse.setDecalageJour(decalageJour);
        acteDonneuse.setDecalageHeure(decalageHeure);
        acteDonneuse.setActe(acte);
        return save(acteDonneuse);
    }
}
