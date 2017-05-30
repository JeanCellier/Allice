package phenotypage.model.cuve.cuveSemence.canisterSemence.visoTubeSemence.semence;

import java.util.List;
import java.util.Optional;

/**
 * Created by nicolas on 21/05/17.
 */
public interface SemenceService {
    List<String> findNumTaureauByNumTaureauLastCharacters(String lastCharacters);

    Semence createSemence(String raceTaureau, String numTaureau, String nomTaureau, int nbPaillettes, String couleurPaillette, boolean sexee, String remarques, boolean FIV);

    Semence save(Semence semence);

    Semence addSemence(Semence semence);

    Optional<Semence> findByNumTaureau(String taureau);

    void delete(Semence semence);
}
