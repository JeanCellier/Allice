package phenotypage.model.fiche.ficheAba;

import java.util.List;

/**
 * @author fabien
 */
public interface FicheAbaService {
    List<FicheAba> findAllFicheAba();

    FicheAba createFichieAba(String nom);

    FicheAba addFicheAba(FicheAba ficheAba);

    FicheAba newFicheAba();

    FicheAba findByNom(String nom);

    long countFicheAba();
}
