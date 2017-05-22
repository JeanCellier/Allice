package phenotypage.model.fiche.ficheIa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import phenotypage.model.fiche.ficheIa.insemination.Insemination;
import phenotypage.model.fiche.ficheIa.insemination.InseminationService;
import phenotypage.model.gestation.Gestation;
import phenotypage.model.gestation.GestationService;
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
FicheIaServiceImpl implements FicheIaService {
    @Autowired
    private FicheIaRepository repository;

    @Autowired
    private InseminationService inseminationService;

    @Autowired
    private Traitement_DonneuseService traitement_donneuseService;

    @Autowired
    private GestationService gestationService;

    @Override
    public List<FicheIa> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<FicheIa> findOne(long id) {
        return Optional.ofNullable(repository.findOne(id));
    }

    @Override
    public FicheIa findTopByOrderByNomDesc() {
        return repository.findTopByOrderByNomDesc();
    }

    @Override
    public FicheIa save(FicheIa ficheIa) {
        return repository.save(ficheIa);
    }

    @Override
    public void delete(FicheIa ficheIa) {
        repository.delete(ficheIa);
    }

    @Override
    public FicheIa createFicheIa(String nom, Date dateFiche, String lieu, Programme programme, String numIpe, String numSemence, Vache vache, Insemination insemination, Traitement_Donneuse traitement_donneuse, Gestation gestation) {

        FicheIa ficheIa = new FicheIa();

        if (insemination != null) {
            Insemination inseminationSave = inseminationService.createInsemination(insemination);
            ficheIa.setInsemination(inseminationSave);
        }

        if (traitement_donneuse != null) {
            Traitement_Donneuse traitement = traitement_donneuseService.createTraitement_Donneuse(traitement_donneuse);
            ficheIa.setTraitement_donneuse(traitement);
        }
        if (gestation != null) {
            Gestation gestationSave = gestationService.createGestation(gestation);
            ficheIa.setGestation(gestationSave);
        }

        ficheIa.setNom(nom);
        ficheIa.setDateHeureMinute(dateFiche);
        ficheIa.setLieu(lieu);
        ficheIa.setProgramme(programme);
        ficheIa.setNumIpe(numIpe);
        ficheIa.setNumDepotSemence(numSemence);
        ficheIa.setVache(vache);

        ficheIa.setStatut(determineStatut(ficheIa));

        return save(ficheIa);
    }

    @Override
    public FicheIa updateFicheIa(FicheIa ficheIaForUpdate, String nom, Date dateFiche, String lieu, Programme programme, String numIpe, String numSemence, Vache vache, Insemination insemination, Traitement_Donneuse traitement_donneuse, Gestation gestation) {
        if (traitement_donneuse != null) {
            if (ficheIaForUpdate.getTraitement_donneuse() != null) {
                if (!Objects.equals(traitement_donneuse.getId(), ficheIaForUpdate.getTraitement_donneuse().getId())) {
                    Traitement_Donneuse traitementDonneuseToDelete = ficheIaForUpdate.getTraitement_donneuse();
                    ficheIaForUpdate.setTraitement_donneuse(traitement_donneuseService.createTraitement_Donneuse(traitement_donneuse));
                    traitement_donneuseService.delete(traitementDonneuseToDelete);
                }
            } else {
                ficheIaForUpdate.setTraitement_donneuse(traitement_donneuseService.createTraitement_Donneuse(traitement_donneuse));
            }
        }

        if (gestation != null) {
            if (ficheIaForUpdate.getGestation() != null) {
                if (!Objects.equals(gestation.getId(), ficheIaForUpdate.getGestation().getId())) {
                    Gestation gestationToDelete = ficheIaForUpdate.getGestation();
                    ficheIaForUpdate.setGestation(gestationService.createGestation(gestation));
                    gestationService.delete(gestationToDelete);
                }
            } else {
                ficheIaForUpdate.setGestation(gestationService.createGestation(gestation));
            }
        }

        if (insemination != null) {
            if (ficheIaForUpdate.getInsemination() != null) {
                if (!Objects.equals(insemination.getId(), ficheIaForUpdate.getInsemination().getId())) {
                    Insemination inseminationToDelete = ficheIaForUpdate.getInsemination();
                    ficheIaForUpdate.setInsemination(inseminationService.createInsemination(insemination));
                    inseminationService.delete(inseminationToDelete);
                }
            } else {
                ficheIaForUpdate.setInsemination(inseminationService.createInsemination(insemination));
            }
        }


        ficheIaForUpdate.setNom(nom);
        ficheIaForUpdate.setProgramme(programme);
        ficheIaForUpdate.setDateHeureMinute(dateFiche);
        ficheIaForUpdate.setNumIpe(numIpe);
        ficheIaForUpdate.setNumDepotSemence(numSemence);
        ficheIaForUpdate.setLieu(lieu);
        ficheIaForUpdate.setVache(vache);

        ficheIaForUpdate.setStatut(determineStatut(ficheIaForUpdate));

        return save(ficheIaForUpdate);
    }

    @Override
    public int determineStatut(FicheIa ficheIa) {
        if (Objects.equals(ficheIa.getNom(), "") || ficheIa.getDateHeureMinute() == null || ficheIa.getVache() == null) {
            return 2;
        } else if (ficheIa.getProgramme() == null || Objects.equals(ficheIa.getNumIpe(), "") || Objects.equals(ficheIa.getLieu(), "")
                || ficheIa.getTraitement_donneuse() == null || ficheIa.getInsemination() == null
                || Objects.equals(ficheIa.getNumDepotSemence(), "") || ficheIa.getGestation() == null) {
            return 1;
        } else {
            if (inseminationService.determineStatut(ficheIa.getInsemination()) == 1) {
                return 1;
            }
            if (traitement_donneuseService.determineStatut(ficheIa.getTraitement_donneuse()) == 1) {
                return 1;
            }
            if (gestationService.determineStatut(ficheIa.getGestation()) == 1) {
                return 1;
            }
        }
        return 0;
    }

    @Override
    public List<FicheIa> findAllFicheIa() {
        return repository.findAll();
    }

    @Override
    public FicheIa findByNom(String nom) {
        return repository.findByNom(nom);
    }
}
