package phenotypage.model.fiche.ficheCol;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import phenotypage.model.cryoconservation.Cryoconservation;
import phenotypage.model.infoTraitementDonneuse.InfoTraitementDonneuse;
import phenotypage.model.invitro.collecte.resultat.Resultat;
import phenotypage.model.operateur.Operateur;
import phenotypage.model.programme.Programme;
import phenotypage.model.tableauTraitement.TableauTraitement;
import phenotypage.model.traitementDonneuse.Traitement_Donneuse;
import phenotypage.model.traitementDonneuse.tableau_donneuse.Tableau_Donneuse;
import phenotypage.model.vache.Vache;

import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * @author fabien
 */

@Component
public class
FicheColServiceImpl implements FicheColService {
    @Autowired
    private FicheColRepository repository;

    @Override
    public List<FicheCol> findAll() {
        return repository.findAll();
    }

    @Override
    public FicheCol createFicheCol(String nom, Programme programme, Date date, String numAgrement, String lieu, Operateur operateur, Vache vache,
                                   Traitement_Donneuse traitementDonneuse, Resultat resultatCollecte,
                                   Cryoconservation cryoconservation, List<TableauTraitement> traitements,
                                   InfoTraitementDonneuse infoTraitementDonneuse, List<Tableau_Donneuse> tableauDonneuse) {
        FicheCol ficheCol = new FicheCol();
        ficheCol.setNom(nom);
        ficheCol.setProgramme(programme);
        ficheCol.setDateHeureMinute(date);
        ficheCol.setNumeroAgrement(numAgrement);
        ficheCol.setLieu(lieu);
        ficheCol.setOperateur(operateur);
        ficheCol.setVache(vache);
        ficheCol.setTraitement_donneuse(traitementDonneuse);
        ficheCol.setResultat_collecte(resultatCollecte);
        ficheCol.setCryoconservation(cryoconservation);
        ficheCol.setInfoTraitementDonneuse(infoTraitementDonneuse);
        ficheCol.setTableauSuperOv(tableauDonneuse);

        return save(ficheCol);
    }

    @Override
    public List<FicheCol> findByVache(Vache vache) {
        return repository.findByVache(vache);
    }

    @Override
    public FicheCol findByNom(String nom) {
        return repository.findByNom(nom);
    }

    @Override
    public void delete(FicheCol ficheCol) {
        repository.delete(ficheCol);
    }

    @Override
    public Optional<FicheCol> findOne(long id) {
        return Optional.ofNullable(repository.findOne(id));
    }

    @Override
    public FicheCol save(FicheCol ficheCol) {
        return repository.save(ficheCol);
    }

    @Override
    public List<FicheCol> findAllFicheCol() {
        return repository.findAll();
    }
}
