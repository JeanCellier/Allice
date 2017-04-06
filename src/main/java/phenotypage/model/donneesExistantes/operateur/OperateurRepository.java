package phenotypage.model.donneesExistantes.operateur;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author fabien
 */
public interface OperateurRepository extends JpaRepository<Operateur, Long>
{
	Operateur findOperateurByNom(String nom);

	Operateur findOperateurByPrenom(String prenom);
}
