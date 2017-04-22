package phenotypage.model.invitro.fecondation;

import phenotypage.model.vache.Vache;

import java.util.List;

/**
 * @author fabien
 */
public interface TableauSemenceService {
    List<TableauSemence> findAllTableauSemence();

    TableauSemence createTableauSemence(Vache nomTaureau, String numeroEjaculation, float volume, int etatFrais);

    TableauSemence addTableauSemence(TableauSemence tableauSemence);
}
