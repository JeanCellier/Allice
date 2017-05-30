package phenotypage.model.Destinataire;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;

/**
 * Created by Jean on 11/05/2017.
 */

@Component

public class DestinataireServiceImpl implements DestinataireService{

    @Autowired
    private DestinataireRepository destinataireRepository;

    @Override
    public List<Destinataire> findAllDestinataire()
    {
        return destinataireRepository.findAll();
    }

    @Override
    public Destinataire createDestinataire(String nom, String typeDestinataire, String adresse)
    {
        return destinataireRepository.save(new Destinataire(nom, typeDestinataire, adresse));
    }

    @Override
    public Destinataire findByNom(String nom)
    {
        return destinataireRepository.findByNom(nom);
    }

    @Override
    public Destinataire save(Destinataire destinataire){
        return destinataireRepository.save(destinataire);
    }

    @Override
    public void delete(Destinataire destinataire) {
        destinataireRepository.delete(destinataire);
    }
}
