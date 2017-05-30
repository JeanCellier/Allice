package phenotypage.model.invitro.collecte.resultat;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ResultatServiceImpl implements ResultatService
{

	@Autowired
	private ResultatRepository resultatRepository;

	public List<Resultat> findAll()
	{
		return resultatRepository.findAll();
	}

	@Override
	public Resultat createResultatCollecte(Resultat resultatCollecte) {
		Resultat resultat = new Resultat();
		resultat.setNombre_CorpsJ_droite(resultatCollecte.getNombre_CorpsJ_droite());
		resultat.setNombre_CorpsJ_gauche(resultatCollecte.getNombre_CorpsJ_gauche());
		resultat.setNombre_CorpsJ_total(resultatCollecte.getNombre_CorpsJ_total());
		resultat.setNombre_Embryons_Degeneres(resultatCollecte.getNombre_Embryons_Degeneres());
		resultat.setNombre_Embryons_NonFecondes(resultatCollecte.getNombre_Embryons_NonFecondes());
		resultat.setNombre_Embryons_Total(resultatCollecte.getNombre_Embryons_Total());
		resultat.setNombre_Embryons_Viables(resultatCollecte.getNombre_Embryons_Viables());
		resultat.setRemarques(resultatCollecte.getRemarques());
		resultat.setTaux_de_collecte(resultatCollecte.getTaux_de_collecte());
		return save(resultat);
	}

	@Override
	public Resultat update(Resultat resultatCollecte, int nbViables, int nbDegen, int nbNonFec, int nbTot, int nbCorpsDroit,
						   int nbCorpsGauche, int nbCorpsTot, float tauxCollecte, String remarques) {
		resultatCollecte.setNombre_CorpsJ_droite(nbCorpsDroit);
		resultatCollecte.setNombre_CorpsJ_gauche(nbCorpsGauche);
		resultatCollecte.setNombre_CorpsJ_total(nbCorpsTot);
		resultatCollecte.setNombre_Embryons_Degeneres(nbDegen);
		resultatCollecte.setNombre_Embryons_NonFecondes(nbNonFec);
		resultatCollecte.setNombre_Embryons_Total(nbTot);
		resultatCollecte.setNombre_Embryons_Viables(nbViables);
		resultatCollecte.setRemarques(remarques);
		resultatCollecte.setTaux_de_collecte(tauxCollecte);
		return save(resultatCollecte);
	}

	@Override
	public Resultat save(Resultat resultat)
	{
		return resultatRepository.save(resultat);
	}

}
