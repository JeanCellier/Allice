package phenotypage.model.Destinataire;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * Created by Jean on 11/05/2017.
 */
@Component
public class DestinatairePopulator
{
    @Autowired
    private DestinataireService destinataireService;

    @PostConstruct
    void init()
    {
        destinataireService.createDestinataire("Aba Vendôme", "Boucherie", "");
        destinataireService.createDestinataire("Earl des Ruches", "Pension", "");
        destinataireService.createDestinataire("SECANIM","Equarissage", "");
    }
}
