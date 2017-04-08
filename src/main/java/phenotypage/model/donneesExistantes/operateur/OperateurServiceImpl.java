package phenotypage.model.donneesExistantes.operateur;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import phenotypage.model.informationsPIV.Informations_PIV;

import java.util.List;

/**
 * @author fabien
 */

@Component
public class OperateurServiceImpl implements OperateurService
{
	@Autowired
	private OperateurRepository operateurRepository;

	@Override
	public Operateur createOperateur(String nom, String prenom)
	{
		Operateur operateur = new Operateur();
		operateur.setNom(nom);
		operateur.setPrenom(prenom);

		return operateurRepository.save(operateur);
	}

	@Override
	public Operateur addOperateur(Operateur operateur)
	{
		return operateurRepository.save(operateur);
	}

	public List<Operateur> findAllOperateur()
	{
		return operateurRepository.findAll();
	}

	@Override
	public Operateur findOperateurByNom(String nom)
	{
		return operateurRepository.findOperateurByNom(nom);
	}

	@Override
	public Operateur findOperateurByPrenom(String prenom)
	{
		return operateurRepository.findOperateurByPrenom(prenom);
	}

	@Override
	public Operateur newOperateur()
	{
		return new Operateur();
	}

	@Override
	public void addInformationsPIV(Informations_PIV informations_piv)
	{

	}
}
