package phenotypage.model.cuve.cuveSemence.canisterSemence.visoTubeSemence.semence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by nicolas on 21/05/17.
 */
@Component
public class SemenceServiceImpl implements SemenceService {
    @Autowired
    private SemenceRepository repository;

    @Override
    public List<String> findNumTaureauByNumTaureauLastCharacters(String lastCharacters) {
        return repository.findNumTaureauByNumTaureauLastCharacters(lastCharacters);
    }

    @Override
    public Semence createSemence(String raceTaureau, String numTaureau, int nbPaillettes, String couleurPaillette, boolean sexee, String remarques, boolean FIV) {
        Semence semence = new Semence();
        semence.setRaceTaureau(raceTaureau);
        semence.setNumTaureau(numTaureau);
        semence.setNbPaillettes(nbPaillettes);
        semence.setCouleurPaillette(couleurPaillette);
        semence.setSexee(sexee);
        semence.setRemarques(remarques);
        semence.setFIV(FIV);
        return save(semence);
    }

    @Override
    public Semence save(Semence semence) {
        return repository.save(semence);
    }
}
