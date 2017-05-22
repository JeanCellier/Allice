package phenotypage.model.invitro.fecondation.tableauSemence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import phenotypage.model.vache.Vache;

import java.util.List;

/**
 * @author fabien
 */

@Component
public class TableauSemenceServiceImpl implements TableauSemenceService {
    @Autowired
    private TableauSemenceRepository tableauSemenceRepository;

    @Override
    public List<TableauSemence> findAllTableauSemence() {
        return tableauSemenceRepository.findAll();
    }

    @Override
    public TableauSemence createTableauSemence(Vache nomTaureau, String numeroEjaculation, float volume, int etatFrais) {
        TableauSemence tableauSemence = new TableauSemence();
        tableauSemence.setTaureau(nomTaureau);
        tableauSemence.setNumeroEjaculation(numeroEjaculation);
        tableauSemence.setVolume(volume);
        tableauSemence.setEtatFrais(etatFrais);
        return tableauSemenceRepository.save(tableauSemence);
    }


    @Override
    public TableauSemence addTableauSemence(TableauSemence tableauSemence) {
        return tableauSemenceRepository.save(tableauSemence);
    }
}
