package phenotypage.model.invitro.collecte.resultat;

import java.util.List;

public interface ResultatService
{
	Resultat createResultatCollecte(Resultat resultatCollecte);

	Resultat update(Resultat resultatCollecte, int nbViables, int nbDegen, int nbNonFec,
					int nbTot, int nbCorpsDroit, int nbCorpsGauche, int nbCorpsTot,
					float tauxCollecte, String remarques);

	Resultat save(Resultat resultat);

	List<Resultat> findAll();
}
