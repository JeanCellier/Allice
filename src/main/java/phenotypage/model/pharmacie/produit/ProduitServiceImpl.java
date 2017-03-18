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

	@Override
	public void updateProduit(Produit produit)
	{
		produitRepository.saveAndFlush(produit);
	}

	public Produit save(Produit produit) {
		return produitRepository.save(produit);
	}

	@Override
	public void delete(Produit produit) {
		produitRepository.delete(produit);
	}

	public List<Produit> findAllProduit()
	{
		return produitRepository.findAll();
	}

	@Override
	public Optional<Produit> findOne(long id) {
		return Optional.ofNullable(produitRepository.findOne(id));
	}

    @Override
    public List<String> findDistinctNames(String tag) {
        return produitRepository.findDistinctNames(tag);
    }

	@Override
	public List<String> findDistinctFournisseurs(String tag) {
		return produitRepository.findDistinctFournisseurs(tag);
	}

	@Override
	public List<String> findDistinctProjets(String tag) {
		return produitRepository.findDistinctProjets(tag);
	}

	@Override
	public List<String> findDistinctResponsables(String tag) {
		return produitRepository.findDistinctResponsables(tag);
	}
}
