package phenotypage.model.invitro.collecte;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Time;
import java.util.Date;
import java.util.List;

@Component
public class CollecteServiceImpl implements CollecteService {

    @Autowired
    private CollecteRepository collecteRepository;

    public Collecte createExemple(String name) {
        return collecteRepository.save(new Collecte());
    }

    public List<Collecte> findAllCollecte() {
        return collecteRepository.findAllCollecte();
    }

    @Override
    public Collecte newCollecte() {
        return new Collecte();
    }

    @Override
    public Collecte addCollecte(Collecte collecte) {
        return collecteRepository.save(collecte);
    }

    @Override
    public Collecte createCollecte(Time heureCollecte, Date date, List<Tableau_Collecte> tableauCollecteList, List<Tableau_Maturation> tableauMaturationList) {
        Collecte collecte = new Collecte();
        collecte.setHeureCollecte(heureCollecte);
        collecte.setDate(date);
        collecte.setTableauCollecteList(tableauCollecteList);
        collecte.setTableauMaturationList(tableauMaturationList);
        return collecteRepository.save(collecte);
    }

    @Override
    public void delete(Collecte collecte) {
        collecteRepository.delete(collecte);
    }

}
