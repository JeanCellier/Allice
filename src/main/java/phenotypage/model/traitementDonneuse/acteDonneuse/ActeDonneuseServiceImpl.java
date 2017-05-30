package phenotypage.model.traitementDonneuse.acteDonneuse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * Created by nicolas on 29/04/17.
 */
@Component
public class ActeDonneuseServiceImpl implements ActeDonneuseService {
    @Autowired
    private ActeDonneuseRepository repository;

    @Override
    public ActeDonneuse createTraitement(Date date, String acte) {
        ActeDonneuse acteDonneuse = new ActeDonneuse();
        acteDonneuse.setActe(acte);
        acteDonneuse.setDate(date);
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
    public ActeDonneuse updateTraitement(ActeDonneuse acteDonneuse, Date date, String acte) {
        acteDonneuse.setDate(date);
        acteDonneuse.setActe(acte);
        return save(acteDonneuse);
    }
}
