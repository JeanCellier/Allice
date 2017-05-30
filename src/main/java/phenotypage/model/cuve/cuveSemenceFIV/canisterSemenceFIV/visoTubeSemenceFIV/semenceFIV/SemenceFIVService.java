package phenotypage.model.cuve.cuveSemenceFIV.canisterSemenceFIV.visoTubeSemenceFIV.semenceFIV;

import java.util.List;
import java.util.Optional;

/**
 * Created by Loick on 27/05/2017.
 */
public interface SemenceFIVService {

    List<String> findNumTaureauByNumTaureauLastCharacters(String lastCharacters);

    SemenceFIV createSemence(String raceTaureau, String numTaureau, String nomTaureau, int nbPaillettes, String couleurPaillette, boolean sexee, String remarques);

    SemenceFIV addSemence(SemenceFIV semence);

    SemenceFIV save(SemenceFIV semence);

    Optional<SemenceFIV> findByNumTaureau(String taureau);

    void delete(SemenceFIV semence);
}
