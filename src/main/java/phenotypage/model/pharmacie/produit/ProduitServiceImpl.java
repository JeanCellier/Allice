package phenotypage.model.pharmacie.produit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

/**
 * @author fabien
 */

@Component
public class ProduitServiceImpl implements ProduitService
{
	@Autowired
	private ProduitRepository produitRepository;

	@Override
	public Produit createProduit(String nom, Date date_delivrance, String fournisseur, String projet, String responsable,
	                             float qte_entrante, float qte_restante, String num_lot, Date date_peremption, String indication)
	{
		return produitRepository.save(new Produit(nom, date_delivrance, fournisseur, projet, responsable, qte_entrante, qte_restante, num_lot, date_peremption, indication));
	}

	@Override
	public Produit addProduit(Produit produit)
	{
		return produitRepository.save(produit);
	}

	public List<Produit> findAllProduit()
	{
		return produitRepository.findAll();
	}

	@Override
	public Produit findProduitByNom(String nom)
	{
		return produitRepository.findProduitByNom(nom);
	}

	@Override
	public void updateProduit(Produit produit)
	{
		produitRepository.saveAndFlush(produit);
	}

	@Override
	public Produit newProduit()
	{
		return new Produit();
	}

	@Override
	public Produit findProduitById(Long id)
	{
		return produitRepository.findProduitById(id);
	}
}
