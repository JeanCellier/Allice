package phenotypage.model.traitement_acte.acteTraitement;

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
    public ActeTraitement createTraitement(int decalageJour, float decalageHeure, String acte) {
        ActeTraitement acteTraitement = new ActeTraitement();
        acteTraitement.setActe(acte);
        acteTraitement.setDecalageHeure(decalageHeure);
        acteTraitement.setDecalageJour(decalageJour);
        return save(acteTraitement);
    }

    @Override
    public ActeTraitement save(ActeTraitement acteTraitement) {
        return repository.save(acteTraitement);
    }

    @Override
    public void delete(ActeTraitement acteTraitement) {
        repository.delete(acteTraitement);
    }

    @Override
    public ActeTraitement updateTraitement(ActeTraitement acteTraitement, int decalageJour, float decalageHeure, String acte) {
        acteTraitement.setDecalageJour(decalageJour);
        acteTraitement.setDecalageHeure(decalageHeure);
        acteTraitement.setActe(acte);
        return save(acteTraitement);
    }
}
