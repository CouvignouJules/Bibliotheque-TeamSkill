package fr.ynov.biblioskill.metier.entities;
import java.io.Serializable;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
/**
 * 
 * @author TeamSkill
 * Définit les attributs et les méthodes d'un objet Personne 
 */

@Entity
@Table(name ="personne")
@NamedQuery(name="lirePersonnes",query="SELECT p FROM Personne p")
@XmlRootElement
public class Personne implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String nom;
	private String prenom;
	private String sexe;
	private String photo;
	private String email;
	@Temporal(TemporalType.DATE)
	private GregorianCalendar dateDeNaissance;
	
	public Personne() {
		// TODO Auto-generated constructor stub
	}

	public Personne(Long id, String nom, String prenom, String sexe, String photo, String email, GregorianCalendar dateDeNaissance) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.sexe = sexe;
		this.photo = photo;
		this.email = email;
		this.dateDeNaissance = dateDeNaissance;
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getSexe() {
		return sexe;
	}

	public void setSexe(String sexe) {
		this.sexe = sexe;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public GregorianCalendar getDateDeNaissance() {
		return dateDeNaissance;
	}

	public void setDateDeNaissance(GregorianCalendar dateDeNaissance) {
		this.dateDeNaissance = dateDeNaissance;
	}

	
	
}
