package phenotypage.model.invitro.fecondation;

import phenotypage.model.donneesExistantes.sanitaire.Sanitaire;

import java.util.Date;
import java.util.List;

public interface FecondationService {
    List<Fecondation> findAllFecondation();

    Fecondation newFecondation();

    Fecondation createFecondation(Date date, String remarque, List<Sanitaire> sanitaireList, List<TableauSemence> tableau_semences);

    Fecondation addFecondation(Fecondation fecondation);

    void delete(Fecondation fecondation);
}
