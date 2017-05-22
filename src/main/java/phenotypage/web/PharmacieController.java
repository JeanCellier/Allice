package phenotypage.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import phenotypage.model.jsonResponse.JsonResponse;
import phenotypage.model.pharmacie.produit.Produit;
import phenotypage.model.pharmacie.produit.ProduitService;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;


@Controller
@RequestMapping("/pharmacie")
public class PharmacieController
{
	@Autowired
	private ProduitService produitService;

	/** ACCUEIL PHARMACIE **/
	@RequestMapping(value = "/pharmacie", method = RequestMethod.GET)
	public String pharmacie(Model model)
	{
		model.addAttribute("produitList", produitService.findAvalaibleProduct());
		return "pharmacie/pharmacie";
	}

	/** ADD **/
	@ResponseBody
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public JsonResponse add(@RequestParam("nom") String nom, @RequestParam("dateDelivrance") String dateDeliv,
					 @RequestParam("fournisseur") String fournisseur, @RequestParam("projet") String projet,
					 @RequestParam("responsable") String respo, @RequestParam("qteEntrante") String qteEntrante,
					 @RequestParam("numLot") String numLot, @RequestParam("datePeremption") String datePeremp,
					 @RequestParam("indication") String indication){

		JsonResponse response = new JsonResponse();
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

		try {
			Date dateDel = formatter.parse(dateDeliv);
			Date datePer = formatter.parse(datePeremp);

			try {
				Float qteEntr = Float.parseFloat(qteEntrante);

				if(dateDel.after(datePer)){
					response.setSucces(false);
					response.setMessage("La date de péremption est inférieure à la date de délivrance");
				}else if(qteEntr <= 0){
					response.setSucces(false);
					response.setMessage("La quantité entrante ne peut être inférieure ou égale à 0");
				}else{
					Produit produit = produitService.createProduit(nom, dateDel, fournisseur, projet, respo, qteEntr, numLot, datePer, indication);

					response.setSucces(true);
					response.setMessage("Ajout effectué");
					response.setObjet(produit);
				}
			}catch (NumberFormatException e){
				response.setSucces(false);
				response.setMessage("La quantité entrante n'est pas un chiffre valide");
			}
		} catch (ParseException e) {
			response.setSucces(false);
			response.setMessage("Une ou plusieurs dates sont invalides");
		}

		return response;
	}

	/** GET ONE */
	@ResponseBody
	@RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
	public JsonResponse getOne(@PathVariable("id") long id){
		JsonResponse response = new JsonResponse();
		Optional<Produit> produit = produitService.findOne(id);

		if(produit.isPresent()){
			response.setSucces(true);
			response.setObjet(produit.get());
		}else{
			response.setSucces(false);
			response.setMessage("Une erreur s\'est produite");
		}

		return response;
	}

	/** GET OUT OF STOCK */
	@ResponseBody
	@RequestMapping(value = "/get/OutOfStock", method = RequestMethod.GET)
	public List<Produit> getOutOfStock(){
		List<Produit> produits = produitService.findOutOfStockProduct();

		return produits;
	}

	/** EDIT **/
	@ResponseBody
	@RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
	public JsonResponse edit(@PathVariable("id")  Produit produit, @RequestParam("nom") String nom,
							 @RequestParam("dateDelivrance") String dateDeliv, @RequestParam("fournisseur") String fournisseur,
							 @RequestParam("projet") String projet, @RequestParam("responsable") String respo,
							 @RequestParam("qteEntrante") String qteEntrante, @RequestParam("qteRestante") String qteRestante,
							 @RequestParam("numLot") String numLot, @RequestParam("datePeremption") String datePeremp,
							 @RequestParam("indication") String indication){
		JsonResponse response = new JsonResponse();

		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

		try {
			Date dateDel = formatter.parse(dateDeliv);
			Date datePer = formatter.parse(datePeremp);

			try {
				Float qteEntr = Float.parseFloat(qteEntrante);
				Float qteRest = Float.parseFloat(qteRestante);

				if(dateDel.after(datePer)){
					response.setSucces(false);
					response.setMessage("La date de péremption est inférieure à la date de délivrance");
				}else if(qteEntr <= 0 || qteRest < 0){
					response.setSucces(false);
					response.setMessage("La quantité entrante ne peut être inférieure ou égale à 0");
				}else{
					produitService.update(produit, nom, dateDel, fournisseur, projet, respo, qteEntr, qteRest, numLot, datePer, indication);
					response.setSucces(true);
					response.setMessage("Produit modifié");
					response.setObjet(produit);
				}
			}catch (NumberFormatException e){
				response.setSucces(false);
				response.setMessage("La quantité entrante n'est pas un chiffre valide");
			}
		} catch (ParseException e) {
			response.setSucces(false);
			response.setMessage("Une ou plusieurs dates sont invalides");
		}

		return response;
	}

	/** DELETE **/
	@ResponseBody
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public JsonResponse delete(@PathVariable("id")  Produit produit){
		JsonResponse response = new JsonResponse();
		produitService.delete(produit);
		response.setSucces(true);
		response.setMessage("Produit supprimé");
		return response;
	}

	/** AUTOCOMPLETE **/
	@ResponseBody
	@RequestMapping(value="/get/names", method = RequestMethod.GET)
	public List<String> getNames(@RequestParam("term") String tag){
		return produitService.findDistinctNames(tag);
	}

	@ResponseBody
	@RequestMapping(value="/get/fournisseurs", method = RequestMethod.GET)
	public List<String> getFournisseurs(@RequestParam("term") String tag){
		return produitService.findDistinctFournisseurs(tag);
	}

	@ResponseBody
	@RequestMapping(value="/get/projets", method = RequestMethod.GET)
	public List<String> getProjets(@RequestParam("term") String tag){
		return produitService.findDistinctProjets(tag);
	}

	@ResponseBody
	@RequestMapping(value="/get/responsables", method = RequestMethod.GET)
	public List<String> getResponsables(@RequestParam("term") String tag){
		return produitService.findDistinctResponsables(tag);
	}
}
