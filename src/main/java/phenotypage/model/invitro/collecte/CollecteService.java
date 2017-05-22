package phenotypage.model.invitro.collecte;

import java.util.List;

public interface CollecteService {
    List<Collecte> findAllCollecte();

    Collecte newCollecte();

    Collecte addCollecte(Collecte collecte);

    void delete(Collecte collecte);
}