package phenotypage.model.fiche.ficheCol;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import phenotypage.model.cryoconservation.Cryoconservation;
import phenotypage.model.cryoconservation.CryoconservationService;
import phenotypage.model.cryoconservation.embryon.Embryon;
import phenotypage.model.cryoconservation.embryon.EmbryonService;
import phenotypage.model.infoTraitementDonneuse.InfoTraitementDonneuse;
import phenotypage.model.infoTraitementDonneuse.InfoTraitementDonneuseService;
import phenotypage.model.invitro.collecte.resultat.Resultat;
import phenotypage.model.invitro.collecte.resultat.ResultatService;
import phenotypage.model.operateur.Operateur;
import phenotypage.model.programme.Programme;
import phenotypage.model.tableauTraitement.TableauTraitement;
import phenotypage.model.traitementDonneuse.Traitement_Donneuse;
import phenotypage.model.traitementDonneuse.Traitement_DonneuseService;
import phenotypage.model.traitementDonneuse.tableau_donneuse.Tableau_Donneuse;
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
FicheColServiceImpl implements FicheColService {
    @Autowired
    private FicheColRepository repository;

    @Autowired
    private CryoconservationService cryoconservationService;

    @Autowired
    private Traitement_DonneuseService traitement_donneuseService;

    @Autowired
    private ResultatService resultatService;

    @Autowired
    private InfoTraitementDonneuseService infoTraitementDonneuseService;

    @Autowired
    private EmbryonService embryonService;

    @Override
    public List<FicheCol> findAll() {
        return repository.findAll();
    }

    @Override
    public FicheCol createFicheCol(String nom, Programme programme, Date date, String numAgrement, String lieu, Operateur operateur, Vache vache,
                                   Traitement_Donneuse traitementDonneuse, Resultat resultatCollecte,
                                   Cryoconservation cryoconservation, Traitement_Donneuse tableauSuperOv,
                                   InfoTraitementDonneuse infoTraitementDonneuse, List<Embryon> detailsEmbryonsViables,
                                   boolean LC, boolean LL, boolean ED) {

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
        ficheCol.setTableauSuperOv(tableauSuperOv);
        ficheCol.setDetailsEmbryonsViables(detailsEmbryonsViables);
        ficheCol.setLC(LC);
        ficheCol.setLL(LL);
        ficheCol.setED(ED);

        ficheCol.setStatut(determineStatut(ficheCol));
        return save(ficheCol);
    }

    @Override
    public FicheCol updateFicheCol(FicheCol ficheColToUpdate, String nom, Programme programme, Date date, String numAgrement,
                                   String lieu, Operateur operateur, Vache vache, Traitement_Donneuse traitementDonneuse,
                                   Resultat resultatCollecte, Cryoconservation cryoconservation, Traitement_Donneuse tableauSuperOv,
                                   InfoTraitementDonneuse infoTraitementDonneuse, List<Embryon> detailsEmbryonsViables,
                                   boolean LC, boolean LL, boolean ED) {

        if (traitementDonneuse != null) {
            if (ficheColToUpdate.getTraitement_donneuse() != null) {
                if (!Objects.equals(traitementDonneuse.getId(), ficheColToUpdate.getTraitement_donneuse().getId())) {
                    Traitement_Donneuse traitementDonneuseToDelete = ficheColToUpdate.getTraitement_donneuse();
                    ficheColToUpdate.setTraitement_donneuse(traitement_donneuseService.createTraitement_Donneuse(traitementDonneuse));
                    traitement_donneuseService.delete(traitementDonneuseToDelete);
                }
            } else {
                ficheColToUpdate.setTraitement_donneuse(traitement_donneuseService.createTraitement_Donneuse(traitementDonneuse));
            }
        }

        if (tableauSuperOv != null) {
            if (ficheColToUpdate.getTraitement_donneuse() != null) {
                if (!Objects.equals(tableauSuperOv.getId(), ficheColToUpdate.getTraitement_donneuse().getId())) {
                    Traitement_Donneuse traitementDonneuseToDelete = ficheColToUpdate.getTraitement_donneuse();
                    ficheColToUpdate.setTraitement_donneuse(traitement_donneuseService.createTraitement_Donneuse(tableauSuperOv));
                    traitement_donneuseService.delete(traitementDonneuseToDelete);
                }
            } else {
                ficheColToUpdate.setTraitement_donneuse(traitement_donneuseService.createTraitement_Donneuse(tableauSuperOv));
            }
        }

        if (resultatCollecte != null) {
            if (ficheColToUpdate.getResultat_collecte() != null) {
                ficheColToUpdate.setResultat_collecte(resultatService.update(ficheColToUpdate.getResultat_collecte(),
                resultatCollecte.getNombre_Embryons_Viables(), resultatCollecte.getNombre_Embryons_Degeneres(),
                resultatCollecte.getNombre_Embryons_NonFecondes(), resultatCollecte.getNombre_Embryons_Total(),
                resultatCollecte.getNombre_CorpsJ_droite(), resultatCollecte.getNombre_CorpsJ_gauche(),
                resultatCollecte.getNombre_CorpsJ_total(), resultatCollecte.getTaux_de_collecte(), resultatCollecte.getRemarques()));
            } else {
                ficheColToUpdate.setResultat_collecte(resultatService.createResultatCollecte(resultatCollecte));
            }
        }

        if(infoTraitementDonneuse != null){
            if(ficheColToUpdate.getInfoTraitementDonneuse() != null){
                ficheColToUpdate.setInfoTraitementDonneuse(infoTraitementDonneuseService.update(ficheColToUpdate.getInfoTraitementDonneuse(),
                        infoTraitementDonneuse.getNb_follicules(), infoTraitementDonneuse.getNb_droite(), infoTraitementDonneuse.getNb_gauche(),
                        infoTraitementDonneuse.getPourc_dose(), infoTraitementDonneuse.isImage_echo()));
            }else{
                ficheColToUpdate.setInfoTraitementDonneuse(infoTraitementDonneuseService.create(infoTraitementDonneuse));
            }
        }

        if(cryoconservation != null){
            if(ficheColToUpdate.getCryoconservation() != null){
                ficheColToUpdate.setCryoconservation(cryoconservationService.update(ficheColToUpdate.getCryoconservation(),
                        cryoconservation.getRef(), cryoconservation.getHeureMinute(), cryoconservation.getMethodeCongelation(),
                        cryoconservation.getCongelateur(), cryoconservation.getOperateur(), cryoconservation.getDescMethode(),
                        cryoconservation.getType()));
            }else{
                ficheColToUpdate.setCryoconservation(cryoconservationService.createCryoconservation(cryoconservation));
            }
        }

        if(detailsEmbryonsViables != null){
            if(ficheColToUpdate.getDetailsEmbryonsViables() != null){
                for(int iEmbryons = 0; iEmbryons < ficheColToUpdate.getDetailsEmbryonsViables().size(); iEmbryons++){
                    embryonService.delete(ficheColToUpdate.getDetailsEmbryonsViables().get(iEmbryons));
                }
                for(int iEmbryons = 0; iEmbryons < ficheColToUpdate.getDetailsEmbryonsViables().size(); iEmbryons++){
                    ficheColToUpdate.getDetailsEmbryonsViables().add(embryonService.create(detailsEmbryonsViables.get(iEmbryons)));
                }
            }else{
                for(int iEmbryons = 0; iEmbryons < ficheColToUpdate.getDetailsEmbryonsViables().size(); iEmbryons++){
                    ficheColToUpdate.getDetailsEmbryonsViables().add(embryonService.create(detailsEmbryonsViables.get(iEmbryons)));
                }
            }
        }

        ficheColToUpdate.setNom(nom);
        ficheColToUpdate.setProgramme(programme);
        ficheColToUpdate.setDateHeureMinute(date);
        ficheColToUpdate.setNumeroAgrement(numAgrement);
        ficheColToUpdate.setLieu(lieu);
        ficheColToUpdate.setOperateur(operateur);
        ficheColToUpdate.setVache(vache);
        ficheColToUpdate.setLC(LC);
        ficheColToUpdate.setLL(LL);
        ficheColToUpdate.setED(ED);

        return save(ficheColToUpdate);
    }

    private int determineStatut(FicheCol ficheCol) {
        if (Objects.equals(ficheCol.getNom(), "") || ficheCol.getDateHeureMinute() == null || ficheCol.getVache() == null) {
            return 2;
        } else if (ficheCol.getProgramme() == null || Objects.equals(ficheCol.getNumeroAgrement(), "") || Objects.equals(ficheCol.getLieu(), "")
                || ficheCol.getCryoconservation() == null || ficheCol.getInfoTraitementDonneuse() == null
                || ficheCol.getDetailsEmbryonsViables().size() == 0 || ficheCol.getResultat_collecte() == null
                || ficheCol.getTableauSuperOv() == null || ficheCol.getTraitement_donneuse() == null) {
            return 1;
        } else {
            if(cryoconservationService.determineStatut(ficheCol.getCryoconservation()) == 1
                    || traitement_donneuseService.determineStatut(ficheCol.getTraitement_donneuse()) == 1 ||
                    traitement_donneuseService.determineStatut(ficheCol.getTableauSuperOv()) == 1
                    || cryoconservationService.determineStatut(ficheCol.getCryoconservation()) == 1){

                return 1;
            }
        }
        return 0;
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

    @Override
    public FicheCol findTopByOrderByNomDesc() {
        return repository.findTopByOrderByNomDesc();
    }
}
