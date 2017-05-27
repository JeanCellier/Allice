package phenotypage.model.cuve.cuveSomatique.canisterSomatique;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import phenotypage.model.cuve.cuveSomatique.canisterSomatique.visoTubeSomatique.VisoTubeSomatique;
import phenotypage.model.cuve.cuveSomatique.canisterSomatique.visoTubeSomatique.VisoTubeSomatiqueService;
import phenotypage.model.cuve.cuveSomatique.canisterSomatique.visoTubeSomatique.celluleSomatique.CelluleSomatiqueService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Created by Loick on 23/05/2017.
 */
@Component
public class CanisterSomatiqueServiceImpl implements CanisterSomatiqueService {

    @Autowired
    private CanisterSomatiqueRepository canisterSomatiqueRepository;

    @Autowired
    private VisoTubeSomatiqueService visoTubeSomatiqueService;

    @Autowired
    private CelluleSomatiqueService celluleSomatiqueService;

    @Override
    public List<CanisterSomatique> findAllCanisterSomatique() {
        return canisterSomatiqueRepository.findAll();
    }

    @Override
    public CanisterSomatique createCanisterSomatique(List<VisoTubeSomatique> visoTubeSomatiquesList) {
        return canisterSomatiqueRepository.save(new CanisterSomatique(visoTubeSomatiquesList));
    }

    @Override
    public CanisterSomatique addCanisterSomatique(CanisterSomatique canisterSomatique) {
        return canisterSomatiqueRepository.save(canisterSomatique);
    }

    @Override
    public CanisterSomatique newCanisterSomatique() {
        return new CanisterSomatique();
    }

    @Override
    public void delete(CanisterSomatique canisterSomatique) {
        canisterSomatiqueRepository.delete(canisterSomatique);
    }

    @Override
    public Optional<CanisterSomatique> findOne(long id) {
        return Optional.ofNullable(canisterSomatiqueRepository.findOne(id));
    }

    @Override
    public CanisterSomatique updateCanisterSomatique(CanisterSomatique canisterSomatique, String nom, int numero, List<VisoTubeSomatique> visoTubeSomatiqueList) {

        CanisterSomatique newCanisterSomatique = new CanisterSomatique();

        List<VisoTubeSomatique> visoTubeSomatiqueToDelete = canisterSomatique.getVisoTubeList();
        List<VisoTubeSomatique> newVisoTubeSomatique = new ArrayList<>();

        canisterSomatiqueRepository.delete(canisterSomatique);

        for(VisoTubeSomatique viso_tube_somatique_ToAdd: visoTubeSomatiqueList){
                newVisoTubeSomatique.add(visoTubeSomatiqueService.addVisoTubeSomatique(viso_tube_somatique_ToAdd));
        }



//        for(VisoTubeSomatique viso_tube_somatique_ToDelete: visoTubeSomatiqueToDelete){
//            visoTubeSomatiqueService.delete(viso_tube_somatique_ToDelete);
//            celluleSomatiqueService.delete(viso_tube_somatique_ToDelete.getCelluleSomatique());
//        }



        newCanisterSomatique.setVisoTubeList(newVisoTubeSomatique);
        newCanisterSomatique.setNom(nom);
        newCanisterSomatique.setNumero(numero);

        return canisterSomatiqueRepository.save(newCanisterSomatique);
    }
}
