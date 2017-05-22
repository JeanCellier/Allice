package phenotypage.model.fiche.ficheTra;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import phenotypage.model.fiche.ficheTra.corpsJaune.CorpsJaune;
import phenotypage.model.fiche.ficheTra.corpsJaune.CorpsJauneService;
import phenotypage.model.fiche.ficheTra.embryonsTransferes.EmbryonsTransferes;
import phenotypage.model.fiche.ficheTra.embryonsTransferes.EmbryonsTransferesService;
import phenotypage.model.gestation.Gestation;
import phenotypage.model.gestation.GestationService;
import phenotypage.model.operateur.Operateur;
import phenotypage.model.programme.Programme;
import phenotypage.model.traitementDonneuse.Traitement_Donneuse;
import phenotypage.model.traitementDonneuse.Traitement_DonneuseService;
import phenotypage.model.vache.Vache;

import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

/**
 * @author fabien
 */

@Component
public class
FicheTraServiceImpl implements FicheTraService {
    /**
     * The repository.
     */
    @Autowired
    private FicheTraRepository repository;

    @Autowired
    private Traitement_DonneuseService traitement_donneuseService;

    @Autowired
    private CorpsJauneService corpsJauneService;

    @Autowired
    private EmbryonsTransferesService embryonsTransferesService;

    @Autowired
    private GestationService gestationService;

    @Override
    public List<FicheTra> findAll() {
        return repository.findAll();
    }

    @Override
    public FicheTra createFicheTra(String nom, Programme programme, Date date, String numAgrement, String lieu,
                                   Operateur operateur, Vache vache, Traitement_Donneuse traitementDonneuse,
                                   CorpsJaune corpsJaune, EmbryonsTransferes embryonsTransferes, Gestation gestation) {

        FicheTra ficheTra = new FicheTra();

        if (traitementDonneuse != null) {
            Traitement_Donneuse traitement = traitement_donneuseService.createTraitement_Donneuse(traitementDonneuse);
            ficheTra.setTraitement_donneuse(traitement);
        }
        if (corpsJaune != null) {
            CorpsJaune corpsJauneSave = corpsJauneService.createCorpsJaune(corpsJaune);
            ficheTra.setCorpsJaune(corpsJauneSave);
        }
        if (embryonsTransferes != null) {
            EmbryonsTransferes embryonSave = embryonsTransferesService.createEmbryonsTransferes(embryonsTransferes);
            ficheTra.setEmbryonsTransferes(embryonSave);
        }
        if (gestation != null) {
            Gestation gestationSave = gestationService.createGestation(gestation);
            ficheTra.setGestation(gestationSave);
        }

        ficheTra.setNom(nom);
        ficheTra.setProgramme(programme);
        ficheTra.setDateHeureMinute(date);
        ficheTra.setNumeroAgrement(numAgrement);
        ficheTra.setLieu(lieu);
        ficheTra.setOperateur(operateur);
        ficheTra.setVache(vache);

        ficheTra.setStatut(determineStatut(ficheTra));

        return save(ficheTra);
    }

    @Override
    public FicheTra findByNom(String nom) {
        return repository.findByNom(nom);
    }

    @Override
    public FicheTra updateFicheTra(FicheTra ficheTraForUpdate, String nom, Programme programme, Date dateFiche,
                                   String numAgrement, String lieu, Operateur operateur, Vache vache,
                                   Traitement_Donneuse traitement_donneuse, CorpsJaune corpsJaune,
                                   EmbryonsTransferes embryonsTransferes, Gestation gestation) {

        if (traitement_donneuse != null) {
            if (ficheTraForUpdate.getTraitement_donneuse() != null) {
                if (!Objects.equals(traitement_donneuse.getId(), ficheTraForUpdate.getTraitement_donneuse().getId())) {
                    Traitement_Donneuse traitementDonneuseToDelete = ficheTraForUpdate.getTraitement_donneuse();
                    ficheTraForUpdate.setTraitement_donneuse(traitement_donneuseService.createTraitement_Donneuse(traitement_donneuse));
                    traitement_donneuseService.delete(traitementDonneuseToDelete);
                }
            } else {
                ficheTraForUpdate.setTraitement_donneuse(traitement_donneuseService.createTraitement_Donneuse(traitement_donneuse));
            }
        }

        if (gestation != null) {
            if (ficheTraForUpdate.getGestation() != null) {
                if (!Objects.equals(gestation.getId(), ficheTraForUpdate.getGestation().getId())) {
                    Gestation gestationToDelete = ficheTraForUpdate.getGestation();
                    ficheTraForUpdate.setGestation(gestationService.createGestation(gestation));
                    gestationService.delete(gestationToDelete);
                }
            } else {
                ficheTraForUpdate.setGestation(gestationService.createGestation(gestation));
            }
        }


        ficheTraForUpdate.setNom(nom);
        ficheTraForUpdate.setProgramme(programme);
        ficheTraForUpdate.setDateHeureMinute(dateFiche);
        ficheTraForUpdate.setNumeroAgrement(numAgrement);
        ficheTraForUpdate.setLieu(lieu);
        ficheTraForUpdate.setOperateur(operateur);
        ficheTraForUpdate.setVache(vache);

        if (embryonsTransferes != null) {
            if (ficheTraForUpdate.getEmbryonsTransferes() != null) {
                ficheTraForUpdate.setEmbryonsTransferes(embryonsTransferesService.update(ficheTraForUpdate.getEmbryonsTransferes(), embryonsTransferes.getRefEmbryons(), embryonsTransferes.getCote(), embryonsTransferes.getEmplacementColUterine(), embryonsTransferes.getFaciliteprogression()));
            } else {
                ficheTraForUpdate.setEmbryonsTransferes(embryonsTransferesService.createEmbryonsTransferes(embryonsTransferes));
            }
        }

        if (corpsJaune != null) {
            if (ficheTraForUpdate.getCorpsJaune() != null) {
                ficheTraForUpdate.setCorpsJaune(corpsJauneService.update(ficheTraForUpdate.getCorpsJaune(), corpsJaune.getMode_evaluation(), corpsJaune.getQualite(), corpsJaune.getCoteCorpsJaune()));
            } else {
                ficheTraForUpdate.setCorpsJaune(corpsJauneService.createCorpsJaune(corpsJaune));
            }
        }

        ficheTraForUpdate.setStatut(determineStatut(ficheTraForUpdate));

        return save(ficheTraForUpdate);
    }

    @Override
    public void delete(FicheTra ficheTra) {
        repository.delete(ficheTra);
    }

    @Override
    public Optional<FicheTra> findOne(long id) {
        return Optional.ofNullable(repository.findOne(id));
    }

    @Override
    public FicheTra save(FicheTra ficheTra) {
        return repository.save(ficheTra);
    }

    @Override
    public FicheTra findTopByOrderByNomDesc() {
        return repository.findTopByOrderByNomDesc();
    }

    @Override
    public int determineStatut(FicheTra ficheTra) {
        if (Objects.equals(ficheTra.getNom(), "") || ficheTra.getDateHeureMinute() == null || ficheTra.getVache() == null) {
            return 2;
        } else if (ficheTra.getProgramme() == null || Objects.equals(ficheTra.getNumeroAgrement(), "") || Objects.equals(ficheTra.getLieu(), "")
                || ficheTra.getOperateur() == null || ficheTra.getTraitement_donneuse() == null || ficheTra.getCorpsJaune() == null
                || ficheTra.getEmbryonsTransferes() == null || ficheTra.getGestation() == null) {
            return 1;
        } else {
            if (ficheTra.getTraitement_donneuse().getDate_ref_chaleur() == null || Objects.equals(ficheTra.getTraitement_donneuse().getTypeChaleur(), "")
                    || ficheTra.getTraitement_donneuse().getTableauDonneuse().size() == 0) {
                return 1;
            }
            if (ficheTra.getCorpsJaune().getCoteCorpsJaune() == ' ' || ficheTra.getCorpsJaune().getQualite() == 0 ||
                    ficheTra.getCorpsJaune().getMode_evaluation() == null) {
                return 1;
            }
            if (Objects.equals(ficheTra.getEmbryonsTransferes().getEmplacementColUterine(), "") || ficheTra.getEmbryonsTransferes().getCote() == ' '
                    || ficheTra.getEmbryonsTransferes().getFaciliteprogression() == 0 || ficheTra.getEmbryonsTransferes().getRefEmbryons() == null) {
                return 1;
            }
            if (ficheTra.getGestation().getRemarques() == null || ficheTra.getGestation().getTableauGestationList().size() == 0) {
                return 1;
            }
        }
        return 0;
    }


}
