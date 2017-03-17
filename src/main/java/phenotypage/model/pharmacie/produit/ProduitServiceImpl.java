package phenotypage.model.pharmacie.produit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * @author fabien
 */

@Component
public class ProduitServiceImpl implements ProduitService
{
	@Autowired
	private ProduitRepository produitRepository;

	@Override
	public Produit createProduit(String nom, Date dateDel, String fournisseur, String projet, String respo, float qteEntr, String numLot, Date datePer)
	{
		Produit produit = new Produit();
		produit.setNom(nom);
		produit.setDateDelivrance(dateDel);
		produit.setFournisseur(fournisseur);
		produit.setProjet(projet);
		produit.setResponsable(respo);
		produit.setQteEntrante(qteEntr);
		produit.setQteRestante(qteEntr);
		produit.setNumLot(numLot);
		produit.setDatePeremption(datePer);

		save(produit);

		return produit;
	}

	public Produit save(Produit produit) {
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

	@Override
	public List<Produit> findAllByOrderByDateDelivranceDesc() {
		return produitRepository.findAllByOrderByDateDelivranceDesc();
	}

	@Override
	public void delete(Produit produit) {
		produitRepository.delete(produit);
	}

	@Override
	public Optional<Produit> findOne(long id) {
		return Optional.ofNullable(produitRepository.findOne(id));
	}

	@Override
	public void update(Produit produit, String nom, Date dateDeliv, String fournisseur, String projet, String respo, float qteEntrante, float qteRestante, String numLot, Date datePeremp) {
		produit.setNom(nom);
		produit.setDateDelivrance(dateDeliv);
		produit.setFournisseur(fournisseur);
		produit.setProjet(projet);
		produit.setResponsable(respo);
		produit.setQteEntrante(qteEntrante);
		produit.setQteRestante(qteRestante);
		produit.setNumLot(numLot);
		produit.setDatePeremption(datePeremp);

		save(produit);
	}
}
