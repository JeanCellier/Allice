package phenotypage.model.informationsPIV;

import phenotypage.model.donneesExistantes.fiv.FIV;
import phenotypage.model.donneesExistantes.operateur.Operateur;
import phenotypage.model.donneesExistantes.typeCulture.TypeCulture;
import phenotypage.model.milieuMaturation.MilieuMaturation;

import java.util.List;


public interface Informations_PIVService {

    List<Informations_PIV> findAllInformations_PIV();

    Informations_PIV addInformation_PIV(Informations_PIV informations_piv);

    Informations_PIV createInformation_PIV(Operateur operateur, MilieuMaturation milieuMaturation, FIV fiv, TypeCulture typeCulture);

    Informations_PIV newInfoPIV();

    void delete(Informations_PIV informations_piv);
}
