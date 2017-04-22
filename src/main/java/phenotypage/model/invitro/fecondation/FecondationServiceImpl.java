package phenotypage.model.invitro.fecondation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import phenotypage.model.donneesExistantes.sanitaire.Sanitaire;

import java.util.Date;
import java.util.List;

@Component
public class FecondationServiceImpl implements FecondationService {
    @Autowired
    private FecondationRepository fecondationRepository;

    @Override
    public Fecondation newFecondation() {
        return new Fecondation();
    }

    @Override
    public Fecondation createFecondation(Date date, String remarque, List<Sanitaire> sanitaireList, List<TableauSemence> tableau_semences) {
        Fecondation fecondation = new Fecondation();
        fecondation.setDate(date);
        fecondation.setRemarque(remarque);
        fecondation.setSanitaireList(sanitaireList);
        fecondation.setTableau_semences(tableau_semences);
        return fecondationRepository.save(fecondation);
    }

    @Override
    public Fecondation addFecondation(Fecondation fecondation) {
        return fecondationRepository.save(fecondation);
    }

    @Override
    public void delete(Fecondation fecondation) {
        fecondationRepository.delete(fecondation);
    }

    public List<Fecondation> findAllFecondation() {
        return fecondationRepository.findAllFecondation();
    }
}
