package phenotypage.model.fiche.ficheTra;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import phenotypage.model.corpsJaune.CorpsJaune;
import phenotypage.model.donneesExistantes.operateur.Operateur;
import phenotypage.model.donneesExistantes.programme.Programme;
import phenotypage.model.embryonsTransferes.EmbryonsTransferes;
import phenotypage.model.gestation.Gestation;
import phenotypage.model.traitementDonneuse.Traitement_Donneuse;
import phenotypage.model.vache.Vache;

import java.util.Date;
import java.util.List;

/**
 * @author fabien
 */

@Component
public class
FicheTraServiceImpl implements FicheTraService
{
	/** The repository. */
	@Autowired
	private FicheTraRepository repository;

	@Autowired
	private FicheTraRepository ficheTraRepository;

	@Override
	public List<FicheTra> findAllFicheTra()
	{
		return ficheTraRepository.findAll();
	}

	@Override
	public void createFicheTra(String nom, Programme programme, Date date, String numAgrement, String lieu,
							   Operateur operateur, Vache vache, Traitement_Donneuse traitementDonneuse,
							   CorpsJaune corpsJaune, EmbryonsTransferes embryonsTransferes, Gestation gestation) {

		FicheTra ficheTra = newFicheTra();
		ficheTra.setNom(nom);
		ficheTra.setProgramme(programme);
		ficheTra.setDateHeureMinute(date);
		ficheTra.setNumeroAgrement(numAgrement);
		ficheTra.setLieu(lieu);
		ficheTra.setOperateur(operateur);
		ficheTra.setVache(vache);
		ficheTra.setTraitement_donneuse(traitementDonneuse);
		ficheTra.setCorpsJaune(corpsJaune);
		ficheTra.setEmbryonsTransferes(embryonsTransferes);
		ficheTra.setGestation(gestation);

		save(ficheTra);
	}


	@Override
	public FicheTra addFicheTra(FicheTra fichieTra)
	{
		return ficheTraRepository.save(fichieTra);
	}

	@Override
	public FicheTra newFicheTra()
	{
		return new FicheTra();
	}

	@Override
	public FicheTra findByNom(String nom)
	{
		return ficheTraRepository.findByNom(nom);
	}

	@Override
	public long countFicheTra()
	{
		return ficheTraRepository.count();
	}

	@Override
	public void save(FicheTra ficheTra) {
		repository.save(ficheTra);
	}
}
