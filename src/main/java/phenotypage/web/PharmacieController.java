package phenotypage.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import phenotypage.model.pharmacie.PharmacieService;
import phenotypage.model.pharmacie.produit.Produit;
import phenotypage.model.pharmacie.produit.ProduitService;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/pharmacie")
public class PharmacieController
{

	@Autowired
	private PharmacieService pharmacieService;
	
	@Autowired
	private ProduitService produitService;
	
	@RequestMapping(value = "/pharmacie", method = RequestMethod.GET)
	public String pharmacie(Model model)
	{
		model.addAttribute("produitList", produitService.findAllProduit());
		model.addAttribute("produit", produitService.newProduit());
		return "pharmacie/pharmacie";
	}

	@RequestMapping(value = "/pharmacie", method = RequestMethod.POST)
	public String pharmacie(@Valid Produit produit, Errors errors, Model model)
	{
		/*if (errors.hasErrors())
		{
			model.addAttribute("produit", produitService.newProduit());
			return "pharmacie/pharmacie";
		}*/
		produitService.addProduit(produit);
		return "redirect:/pharmacie/pharmacie";
	}
	
	@RequestMapping(value = "/pharmacie/{id}", method = RequestMethod.GET)
	public String pharmacieID(@PathVariable Long id, Model model)
	{
		Produit prod = produitService.findProduitById(id);
		model.addAttribute("produitList", produitService.findAllProduit());
		model.addAttribute("produit", prod);
		return "pharmacie/pharmacie";
	}
	
	@RequestMapping(value = "/pharmacie/{id}", method = RequestMethod.POST)
	public String pharmacieID(@PathVariable Long id, @Valid Produit produit, Errors errors, Model model)
	{
		/*if (errors.hasErrors())
		{
			model.addAttribute("produit", produitService.newProduit());
			return "pharmacie/pharmacie";
		}*/
		produit.setId(id);
		produitService.addProduit(produit);

		return "redirect:/pharmacie/pharmacie";
	}
	
	@RequestMapping(value = "/consultation", method = RequestMethod.GET)
	public String consultation(Model model)
	{
		model.addAttribute("produit", produitService.newProduit());
		model.addAttribute("produitList", produitService.findAllProduit());
		return "pharmacie/consultation";
	}
	
}
