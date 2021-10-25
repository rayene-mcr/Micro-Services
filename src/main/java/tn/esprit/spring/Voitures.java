package tn.esprit.spring;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Voitures implements Serializable {
	private static final long serialVersionUID = 6711457437559348053L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String nom,prenom,adresse,marque,description,carburant;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getMarque() {
		return marque;
	}
	public void setMarque(String marque) {
		this.marque = marque;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getCarburant() {
		return carburant;
	}
	public void setCarburant(String carburant) {
		this.carburant = carburant;
	}
	public Date getAnnee() {
		return annee;
	}
	public void setAnnee(Date annee) {
		this.annee = annee;
	}
	public float getKilometrage() {
		return kilometrage;
	}
	public void setKilometrage(float kilometrage) {
		this.kilometrage = kilometrage;
	}
	public float getCylindree() {
		return cylindree;
	}
	public void setCylindree(float cylindree) {
		this.cylindree = cylindree;
	}
	public int getPuissance() {
		return puissance;
	}
	public void setPuissance(int puissance) {
		this.puissance = puissance;
	}
	public int getImmatriculation() {
		return immatriculation;
	}
	public void setImmatriculation(int immatriculation) {
		this.immatriculation = immatriculation;
	}
	public int getQuantite() {
		return quantite;
	}
	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}
	public float getPrix(){
		return prix;
	}
	public void setPrix(float prix){
		this.prix = prix;
	}
	private Date annee,du,à;
	private float kilometrage,cylindree,prix;
	private int puissance,immatriculation,quantite,age;
	public Voitures() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Voitures(String marque) {
		super();
		this.marque = marque;
	}

	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public Date getDu() {
		return du;
	}
	public void setDu(Date du) {
		this.du = du;
	}
	public Date getÀ() {
		return à;
	}
	public void setÀ(Date à) {
		this.à = à;
	}
	public String getNom(){
		return nom;
	}
	public void setNom(String nom){
		this.nom = nom;
	}

}
