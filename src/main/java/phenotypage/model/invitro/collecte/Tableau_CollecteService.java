package phenotypage.model.invitro.collecte;

import phenotypage.model.vache.Vache;

import java.sql.Time;
import java.util.List;

public interface Tableau_CollecteService {
    List<Tableau_Collecte> findAllTableauCollecte();

    Tableau_Collecte newTableauCollecte();

    Tableau_Collecte addTableauCollecte(Tableau_Collecte tableauCollecte);

    Tableau_Collecte createTableau_Collecte(String race_Ovaires, int nombre_Ovaires, int nombre_Ovocytes,
                                            float taux_Collecte, Vache vache, Time heureDebutMaturation, Time heureFiv);

    Tableau_Collecte createTableau_Collecte(String race_Ovaires, int nombre_Ovaires, int nombre_Ovocytes,
                                            float taux_Collecte, Time heureDebutMaturation, Time heureFiv);
}
