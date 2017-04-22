package phenotypage.model.invitro.collecte;

import java.sql.Time;
import java.util.Date;
import java.util.List;

public interface CollecteService {
    List<Collecte> findAllCollecte();

    Collecte newCollecte();

    Collecte addCollecte(Collecte collecte);

    Collecte createCollecte(Time heureCollecte, Date date, List<Tableau_Collecte> tableauCollecteList, List<Tableau_Maturation> tableauMaturationList);

    void delete(Collecte collecte);
}
