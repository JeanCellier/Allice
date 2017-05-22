package phenotypage.model.fiche.ficheAba;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author fabien
 */

@Component
public class
FicheAbaServiceImpl implements FicheAbaService {
    @Autowired
    private FicheAbaRepository ficheAbaRepository;

    @Override
    public List<FicheAba> findAllFicheAba() {
        return ficheAbaRepository.findAll();
    }

    @Override
    public FicheAba createFichieAba(String nom) {
        return ficheAbaRepository.save(new FicheAba());
    }

    @Override
    public FicheAba addFicheAba(FicheAba ficheAba) {
        return ficheAbaRepository.save(ficheAba);
    }

    @Override
    public FicheAba newFicheAba() {
        return new FicheAba();
    }

    @Override
    public FicheAba findByNom(String nom) {
        return ficheAbaRepository.findByNom(nom);
    }

    @Override
    public long countFicheAba() {
        return ficheAbaRepository.count();
    }
}
