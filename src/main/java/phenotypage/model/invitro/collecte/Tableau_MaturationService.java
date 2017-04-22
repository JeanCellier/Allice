package phenotypage.model.invitro.collecte;

import java.util.List;

/**
 * Created with magic
 * User: simoe
 * Date: 22/04/2017 00:04
 * Project: appPhenotypage
 */
public interface Tableau_MaturationService {

    List<Tableau_Maturation> findAllTableauMaturation();

    Tableau_Maturation createTableau_Mturation(String groupeExperimentauxMIV, int nbOvocyte);
}
