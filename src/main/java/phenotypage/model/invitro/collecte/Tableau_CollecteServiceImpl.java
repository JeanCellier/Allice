package phenotypage.model.invitro.collecte;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import phenotypage.model.vache.Vache;

import java.sql.Time;
import java.util.List;

@Component
public class Tableau_CollecteServiceImpl implements Tableau_CollecteService {
    @Autowired
    private Tableau_CollecteRepository tableau_collecteRepository;

    public List<Tableau_Collecte> findAllTableauCollecte() {
        return tableau_collecteRepository.findAllTableauCollecte();
    }

    @Override
    public Tableau_Collecte newTableauCollecte() {
        return tableau_collecteRepository.save(new Tableau_Collecte());
    }

    @Override
    public Tableau_Collecte addTableauCollecte(Tableau_Collecte tableauCollecte) {
        return tableau_collecteRepository.save(tableauCollecte);
    }

    @Override
    public Tableau_Collecte createTableau_Collecte(String race_Ovaires, int nombre_Ovaires, int nombre_Ovocytes, float taux_Collecte, Vache vache, Time heureDebutMaturation, Time heureFiv) {
        Tableau_Collecte tableauCollecte = new Tableau_Collecte();
        tableauCollecte.setRace_Ovaires(race_Ovaires);
        tableauCollecte.setNombre_Ovaires(nombre_Ovaires);
        tableauCollecte.setNombre_Ovocytes(nombre_Ovocytes);
        tableauCollecte.setTaux_Collecte(taux_Collecte);
        if (vache == null) {
            tableauCollecte.setPool(true);
        } else {
            tableauCollecte.setVache(vache);
            tableauCollecte.setPool(false);
        }
        tableauCollecte.setHeureDebutMaturation(heureDebutMaturation);
        tableauCollecte.setHeureFiv(heureFiv);
        return tableau_collecteRepository.save(tableauCollecte);
    }

    @Override
    public Tableau_Collecte createTableau_Collecte(String race_Ovaires, int nombre_Ovaires, int nombre_Ovocytes, float taux_Collecte, Time heureDebutMaturation, Time heureFiv) {
        return createTableau_Collecte(race_Ovaires, nombre_Ovaires, nombre_Ovocytes, taux_Collecte, null, heureDebutMaturation, heureFiv);
    }

}
