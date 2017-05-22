package phenotypage.model.informationsPIV;

import java.util.List;


public interface Informations_PIVService {

    List<Informations_PIV> findAllInformations_PIV();

    Informations_PIV addInformation_PIV(Informations_PIV informations_piv);

    Informations_PIV newInfoPIV();

    void delete(Informations_PIV informations_piv);
}