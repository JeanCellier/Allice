package phenotypage.model.pharmacie.produit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Calendar;
import java.util.Date;

/**
 * @author fabien
 */
@Component
public class ProduitPopulator
{
	@Autowired
	private ProduitService produitService;

	@PostConstruct
	void init()
	{
//		produitService.createProduit("lol", new Date(), "xd", "projet", "respo", 5, "numlot", new Date(), "indic");
	}
}
