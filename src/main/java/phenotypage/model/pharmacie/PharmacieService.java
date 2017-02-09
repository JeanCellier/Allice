package phenotypage.model.pharmacie;

import java.util.List;

/**
 * @author fabien
 */
public interface PharmacieService
{
	Pharmacie createPharmacie();
	
	Pharmacie createPharmacie(String nom);

	Pharmacie addPharmacie(Pharmacie pharmacie);

	List<Pharmacie> findAllPharmacie();

	Pharmacie findPharmacieByNom(String nom);
}
