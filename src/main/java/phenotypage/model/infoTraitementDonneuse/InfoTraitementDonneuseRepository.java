package phenotypage.model.infoTraitementDonneuse;

import org.springframework.data.jpa.repository.JpaRepository;
import phenotypage.model.invitro.collecte.resultat.Resultat;

import java.util.List;

public interface InfoTraitementDonneuseRepository extends JpaRepository<InfoTraitementDonneuse, Long>
{

}
