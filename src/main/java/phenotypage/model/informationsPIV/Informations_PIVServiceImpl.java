package phenotypage.model.informationsPIV;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Informations_PIVServiceImpl implements Informations_PIVService {
    @Autowired
    private Informations_PIVRepository informations_PIVRepository;

    public Informations_PIV createInformations_PIV() {
        return informations_PIVRepository.save(new Informations_PIV());
    }

    public List<Informations_PIV> findAllInformations_PIV() {
        return informations_PIVRepository.findAllInformations_PIV();
    }

    @Override
    public Informations_PIV addInformation_PIV(Informations_PIV informations_piv) {
        return informations_PIVRepository.save(informations_piv);
    }

    @Override
    public Informations_PIV newInfoPIV() {
        return new Informations_PIV();
    }

    @Override
    public void delete(Informations_PIV informations_piv) {
        informations_PIVRepository.delete(informations_piv.getId());
    }

}