package phenotypage.model.invitro.culture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author fabien
 */

@Component
public class TableauCultureServiceImpl implements TableauCultureService {
    @Autowired
    private TableauCultureRepository tableauCultureRepository;

    @Override
    public List<TableauCulture> findAllTableauCulture() {
        return tableauCultureRepository.findAll();
    }

    @Override
    public TableauCulture createTableauCulture(String groupe, int nbInsemine, int heureCulture, int minuteCulture,
                                               int nbSegmente, float segment, int j5JM, int mo, int bl, int be,
                                               int q1, int nbTotal, float pourJ7, float pourBEJ7, float pourQ1J7,
                                               int j8parNb, float j8PourJ8, String destination) {
        TableauCulture tableauCulture = new TableauCulture();
        tableauCulture.setGroupe(groupe);
        tableauCulture.setNbInsemine(nbInsemine);
        tableauCulture.setHeureCulture(heureCulture);
        tableauCulture.setMinuteCulture(minuteCulture);
        tableauCulture.setNbSegmente(nbSegmente);
        tableauCulture.setSegment(segment);
        tableauCulture.setJ5JM(j5JM);
        tableauCulture.setMo(mo);
        tableauCulture.setBl(bl);
        tableauCulture.setBe(be);
        tableauCulture.setQ1(q1);
        tableauCulture.setNbTotal(nbTotal);
        tableauCulture.setPourJ7(pourJ7);
        tableauCulture.setPourBEJ7(pourBEJ7);
        tableauCulture.setPourQ1J7(pourQ1J7);
        tableauCulture.setJ8parNb(j8parNb);
        tableauCulture.setPourJ8(j8PourJ8);
        if (destination.equals("cryo")) {
            tableauCulture.setSiCryo(true);
        }
        tableauCulture.setDestination(destination);
        return tableauCultureRepository.save(tableauCulture);
    }

    @Override
    public TableauCulture newTableauCulture() {
        return new TableauCulture();
    }

    @Override
    public TableauCulture addTableauCulture(TableauCulture tableauCulture) {
        return tableauCultureRepository.save(tableauCulture);
    }

}
