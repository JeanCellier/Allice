package phenotypage.model.cuve.cuveSemenceFIV.canisterSemenceFIV.visoTubeSemenceFIV.semenceFIV;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

/**
 * Created by Loick on 27/05/2017.
 */
@Component
public class SemenceFIVServiceImpl implements SemenceFIVService {

    @Autowired
    private SemenceFIVRepository repository;

    @Override
    public List<String> findNumTaureauByNumTaureauLastCharacters(String lastCharacters) {
        return repository.findNumTaureauByNumTaureauLastCharacters(lastCharacters);
    }

    @Override
    public SemenceFIV createSemence(String raceTaureau, String numTaureau, String nomTaureau, int nbPaillettes, String couleurPaillette, boolean sexee, String remarques) {
        SemenceFIV semence = new SemenceFIV();
        semence.setRaceTaureau(raceTaureau);
        semence.setNumTaureau(numTaureau);
        semence.setNomTaureau(nomTaureau);
        semence.setNbPaillettes(nbPaillettes);
        semence.setCouleurPaillette(couleurPaillette);
        semence.setSexee(sexee);
        semence.setRemarques(remarques);
        return save(semence);
    }

    @Override
    public SemenceFIV addSemence(SemenceFIV semence) {
        return repository.save(semence);
    }

    @Override
    public SemenceFIV save(SemenceFIV semence) {
        return repository.save(semence);
    }

    @Override
    public Optional<SemenceFIV> findByNumTaureau(String taureau) {
        return repository.findByNumTaureau(taureau);
    }

    @Override
    public void delete(SemenceFIV semence) {
        repository.delete(semence);
    }
}
