package phenotypage.model.pharmacie.produit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Calendar;

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
		produitService.createProduit("1", Calendar.getInstance().getTime(), "1", "1", "1", 5, 5, "1", Calendar.getInstance().getTime(), "1");
		produitService.createProduit("2", Calendar.getInstance().getTime(), "1", "1", "1", 5, 5, "1", Calendar.getInstance().getTime(), "1");
		produitService.createProduit("3", Calendar.getInstance().getTime(), "1", "1", "1", 5, 5, "1", Calendar.getInstance().getTime(), "1");
		produitService.createProduit("4", Calendar.getInstance().getTime(), "1", "1", "1", 5, 5, "1", Calendar.getInstance().getTime(), "1");
	}
}
