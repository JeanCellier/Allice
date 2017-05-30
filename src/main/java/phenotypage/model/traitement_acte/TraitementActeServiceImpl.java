package phenotypage.model.traitement_acte;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import phenotypage.model.traitement_acte.acteTraitement.ActeTraitement;
import phenotypage.model.traitement_acte.acteTraitement.ActeTraitementService;
import phenotypage.model.traitement_acte.tableau_traitement.Tableau_Traitement_Acte;
import phenotypage.model.traitement_acte.tableau_traitement.Tableau_Traitement_ActeService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Created by nicolas on 29/04/17.
 */
@Component
public class TraitementActeServiceImpl implements TraitementActeService {
    @Autowired
    private TraitementActeRepository repository;

    @Autowired
    private Tableau_Traitement_ActeService tableau_TraitementService;

    @Autowired
    private ActeTraitementService acteTraitementService;

    @Override
    public List<TraitementActe> findAll() {
        return repository.findAll();
    }

    @Override
    public TraitementActe createTraitement(String nom, List<Tableau_Traitement_Acte> tableau_traitementActe, List<ActeTraitement> acteTraitements) {
        TraitementActe traitementActe = new TraitementActe();

        traitementActe.setNom(nom);

        List<Tableau_Traitement_Acte> tableau_traitementActeSave = new ArrayList<>();
        List<ActeTraitement> acteTraitementsSave = new ArrayList<>();

        for (Tableau_Traitement_Acte tableauTraitement: tableau_traitementActe) {
            tableau_traitementActeSave.add(tableau_TraitementService.createTableauTraitement(tableauTraitement.getDecalageJour(), tableauTraitement.getDecalageHeure(), tableauTraitement.getProduit(), tableauTraitement.getQuantite(), tableauTraitement.getMode_traitement()));
        }

        for (ActeTraitement acteTraitement : acteTraitements) {
            acteTraitementsSave.add(acteTraitementService.createTraitement(acteTraitement.getDecalageJour(), acteTraitement.getDecalageHeure(), acteTraitement.getActe()));
        }

        traitementActe.setTableauTraitement(tableau_traitementActeSave);
        traitementActe.setActeTraitements(acteTraitementsSave);

        return save(traitementActe);
    }

    @Override
    public TraitementActe createTraitement(TraitementActe traitementActe) {
        List<Tableau_Traitement_Acte> tableau_traitementActeSave = new ArrayList<>();
        List<ActeTraitement> acteTraitementsSave = new ArrayList<>();

        for (Tableau_Traitement_Acte tableau_traitementActe : traitementActe.getTableauTraitement()) {
            tableau_traitementActeSave.add(tableau_TraitementService.createTableauTraitement(tableau_traitementActe.getDecalageJour(), tableau_traitementActe.getDecalageHeure(), tableau_traitementActe.getProduit(), tableau_traitementActe.getQuantite(), tableau_traitementActe.getMode_traitement()));
        }
        for (ActeTraitement acteTraitement : traitementActe.getActeTraitements()) {
            acteTraitementsSave.add(acteTraitementService.createTraitement(acteTraitement.getDecalageJour(), acteTraitement.getDecalageHeure(), acteTraitement.getActe()));
        }

        traitementActe.setActeTraitements(acteTraitementsSave);
        traitementActe.setTableauTraitement(tableau_traitementActeSave);

        return save(traitementActe);
    }

    @Override
    public TraitementActe save(TraitementActe traitementActe) {
        return repository.save(traitementActe);
    }

    @Override
    public void delete(TraitementActe traitementActe) {
        repository.delete(traitementActe);
    }

    @Override
    public Optional<TraitementActe> findOne(long id) {
        return Optional.ofNullable(repository.findOne(id));
    }

    @Override
    public TraitementActe updateTraitement(TraitementActe traitementActe, String nom, List<Tableau_Traitement_Acte> tableau_traitement_acte,
            List<ActeTraitement> acteTraitements) {

        List<Tableau_Traitement_Acte> tableauTraitementToDelete = traitementActe.getTableauTraitement();
        List<Tableau_Traitement_Acte> newTableauTraitement = new ArrayList<>();

        for(Tableau_Traitement_Acte tableau_traitement_acteToAdd: tableau_traitement_acte){
            newTableauTraitement.add(tableau_TraitementService.createTableauTraitement(tableau_traitement_acteToAdd.getDecalageJour(),
                    tableau_traitement_acteToAdd.getDecalageHeure(), tableau_traitement_acteToAdd.getProduit(), tableau_traitement_acteToAdd.getQuantite(), tableau_traitement_acteToAdd.getMode_traitement()));
        }

        traitementActe.setTableauTraitement(newTableauTraitement);

        for(Tableau_Traitement_Acte tableau_traitement_acteToDelete: tableauTraitementToDelete){
            tableau_TraitementService.delete(tableau_traitement_acteToDelete);
        }

        List<ActeTraitement> acteTraitementToDelete = traitementActe.getActeTraitements();
        List<ActeTraitement> newTableauActe = new ArrayList<>();

        for(ActeTraitement acteTraitementToAdd: acteTraitements){
            newTableauActe.add(acteTraitementService.createTraitement(acteTraitementToAdd.getDecalageJour(), acteTraitementToAdd.getDecalageHeure(),
                    acteTraitementToAdd.getActe()));
        }

        traitementActe.setActeTraitements(newTableauActe);

        for(ActeTraitement acteToDelete: acteTraitementToDelete){
            acteTraitementService.delete(acteToDelete);
        }

        traitementActe.setNom(nom);

        return save(traitementActe);
    }
}
