package phenotypage.model.informationsPIV.fiv;

import java.util.List;

/**
 * @author fabien
 */
public interface FIVService
{
	List<FIV> findAllFIV();

	FIV createFIV(String nom, String numeroLot);

	FIV addFIV(FIV fiv);

	FIV newFIV();

	FIV findByNom(String nomFIV);
}
