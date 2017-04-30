package phenotypage.model.vache;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Vache
{
	@Id
	@GeneratedValue
	private Long id;

	@Column
	private Boolean present;

	@Column
	private String proprietaire;

	@Column
	private String nom;

	@Column
	private String num_elevage; // == provenance

	@Column(unique = true)
	private String num_identification; // == num national

	@Column
	private Integer race;

	@Column
	private Character sexe; //F = femelle M = male

	@Column
	private Date dateNaissance;

	@Column
	private String parite;

	@Column
	private Float ageMois;

	@Column
	private String numPere;

	@Column
	private String numMere;

	public Vache() {}

	public Long getId()
	{
		return id;
	}

	public void setId(Long id)
	{
		this.id = id;
	}

	public String getProprietaire()
	{
		return proprietaire;
	}

	public void setProprietaire(String proprietaire)
	{
		this.proprietaire = proprietaire;
	}

	public String getNum_elevage()
	{
		return num_elevage;
	}

	public void setNum_elevage(String num_elevage)
	{
		this.num_elevage = num_elevage;
	}

	public String getNum_identification()
	{
		return num_identification;
	}

	public void setNum_identification(String num_identification)
	{
		this.num_identification = num_identification;
	}

	public int getRace()
	{
		return race;
	}

	public void setRace(int race)
	{
		this.race = race;
	}

	public boolean isPresent() {
		return present;
	}

	public void setPresent(boolean present) {
		this.present = present;
	}

	public char getSexe() {
		return sexe;
	}

	public void setSexe(char sexe) {
		this.sexe = sexe;
	}

	public Date getDateNaissance() {
		return dateNaissance;
	}

	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	public float getAgeMois() {
		return ageMois;
	}

	public void setAgeMois(float ageMois) {
		this.ageMois = ageMois;
	}

	public String getNumPere() {
		return numPere;
	}

	public void setNumPere(String numPere) {
		this.numPere = numPere;
	}

	public String getNumMere() {
		return numMere;
	}

	public void setNumMere(String numMere) {
		this.numMere = numMere;
	}

	public String getNom()
	{
		return nom;
	}

	public void setNom(String nom)
	{
		this.nom = nom;
	}

	public String getParite()
	{
		return parite;
	}

	public void setParite(String parite)
	{
		this.parite = parite;
	}
}
