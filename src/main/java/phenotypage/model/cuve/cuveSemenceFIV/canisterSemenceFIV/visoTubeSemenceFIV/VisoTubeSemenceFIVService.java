package phenotypage.model.cuve.cuveSemenceFIV.canisterSemenceFIV.visoTubeSemenceFIV;

import phenotypage.model.cuve.cuveSemenceFIV.canisterSemenceFIV.visoTubeSemenceFIV.semenceFIV.SemenceFIV;

import java.util.List;

/**
 * Created by Loick on 27/05/2017.
 */
public interface VisoTubeSemenceFIVService {
    List<VisoTubeSemenceFIV> findAllVisoTubeSemence();

    VisoTubeSemenceFIV createVisoTubeSemence(SemenceFIV Semence);

    VisoTubeSemenceFIV addVisoTubeSemence(VisoTubeSemenceFIV visoTubeSemance);

    VisoTubeSemenceFIV newVisoTubeSemence();

    void delete(VisoTubeSemenceFIV visoTubeSemence);

}
