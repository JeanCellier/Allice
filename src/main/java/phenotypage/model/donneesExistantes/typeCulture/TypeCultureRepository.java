package phenotypage.model.donneesExistantes.typeCulture;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author fabien
 */
public interface TypeCultureRepository extends JpaRepository<TypeCulture, Long>
{
	TypeCulture findByNom(String nomTypeCulture);
}
