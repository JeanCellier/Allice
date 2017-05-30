package phenotypage.model.traitementDonneuse.acteDonneuse;

import java.util.Date;

/**
 * Created by nicolas on 29/04/17.
 */
public interface ActeDonneuseService {
    ActeDonneuse createTraitement(Date date, String acte);

    ActeDonneuse save(ActeDonneuse acteDonneuse);

    void delete(ActeDonneuse acteDonneuse);

    ActeDonneuse updateTraitement(ActeDonneuse acteDonneuse, Date date, String acte);
}
