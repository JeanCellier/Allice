package phenotypage.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import phenotypage.model.JsonResponse.JsonResponse;
import phenotypage.model.pharmacie.produit.Produit;
import phenotypage.model.pharmacie.produit.ProduitService;
import phenotypage.model.vache.VacheService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;


@Controller
@RequestMapping("/animaux")
public class VacheController
{
    @Autowired
    private VacheService vacheService;

    /** ACCUEIL VACHE **/
    @RequestMapping(value = "/animaux", method = RequestMethod.GET)
    public String vache(Model model)
    {
        model.addAttribute("vacheList", vacheService.findAllVache());
        return "animaux/animaux";
    }

}
