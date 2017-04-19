package phenotypage.model.informationsPIV;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import phenotypage.model.donneesExistantes.fiv.FIV;
import phenotypage.model.donneesExistantes.operateur.Operateur;
import phenotypage.model.donneesExistantes.typeCulture.TypeCulture;
import phenotypage.model.milieuMaturation.MilieuMaturation;

import java.util.List;

@Component
public class Informations_PIVServiceImpl implements Informations_PIVService {
    @Autowired
    private Informations_PIVRepository informations_PIVRepository;

    @Override
    public List<Informations_PIV> findAllInformations_PIV() {
        return informations_PIVRepository.findAllInformations_PIV();
    }

    @Override
    public Informations_PIV addInformation_PIV(Informations_PIV informations_piv) {
        return informations_PIVRepository.save(informations_piv);
    }

    @Override
    public Informations_PIV createInformation_PIV(Operateur operateur, MilieuMaturation milieuMaturation, FIV fiv, TypeCulture typeCulture) {
        Informations_PIV informations_piv = new Informations_PIV();
        informations_piv.setOperateur(operateur);
        informations_piv.setMilieuMaturation(milieuMaturation);
        informations_piv.setFiv(fiv);
        informations_piv.setTypeCulture(typeCulture);
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
