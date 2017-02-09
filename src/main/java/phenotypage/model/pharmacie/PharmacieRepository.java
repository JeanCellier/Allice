package phenotypage.model.pharmacie;

import org.springframework.data.jpa.repository.JpaRepository;


public interface PharmacieRepository extends JpaRepository<Pharmacie, Long>
{
	Pharmacie findPharmacieByNom(String nom);
	
}
