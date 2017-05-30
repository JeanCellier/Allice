package phenotypage.model.cuve.cuveSemence.canisterSemence.visoTubeSemence;

import java.util.List;
import phenotypage.model.cuve.cuveSemence.canisterSemence.visoTubeSemence.VisoTubeSemence;
import phenotypage.model.cuve.cuveSemence.canisterSemence.visoTubeSemence.semence.Semence;


/**
 * Created by Loick on 23/05/2017.
 */
public interface VisoTubeSemenceService {
    List<VisoTubeSemence> findAllVisoTubeSemence();

    VisoTubeSemence createVisoTubeSemence(Semence Semance);

    VisoTubeSemence addVisoTubeSemence(VisoTubeSemence visoTubeSemance);

    VisoTubeSemence newVisoTubeSemence();

    void delete(VisoTubeSemence visoTubeSemence);

}
