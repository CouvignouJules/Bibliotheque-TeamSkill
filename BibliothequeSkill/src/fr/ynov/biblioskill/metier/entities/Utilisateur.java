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

import fr.ynov.biblioskill.utilitaire.AccountType;
@Entity
@Table(name ="utilisateur")
@NamedQuery(name="lireUtilisateurs",query="SELECT u FROM Utilisateur u")
public class Utilisateur implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String nomUtilisateur;
	private String motDePasse;
	private AccountType statutCompte;
	@Temporal(TemporalType.DATE)
	private GregorianCalendar derniereConnexion;

	public Utilisateur() {
		// TODO Auto-generated constructor stub
	}

	public Utilisateur(Long id, String nomUtilisateur, String motDePasse, AccountType statutCompte,
			Date derniereConnexion) {
		super();
		this.id = id;
		this.nomUtilisateur = nomUtilisateur;
		this.motDePasse = motDePasse;
		this.statutCompte = statutCompte;
		this.derniereConnexion = derniereConnexion;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNomUtilisateur() {
		return nomUtilisateur;
	}

	public void setNomUtilisateur(String nomUtilisateur) {
		this.nomUtilisateur = nomUtilisateur;
	}

	public String getMotDePasse() {
		return motDePasse;
	}

	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}

	public AccountType getStatutCompte() {
		return statutCompte;
	}

	public void setStatutCompte(AccountType statutCompte) {
		this.statutCompte = statutCompte;
	}

	public Date getDerniereConnexion() {
		return derniereConnexion;
	}

	public void setDerniereConnexion(Date derniereConnexion) {
		this.derniereConnexion = derniereConnexion;
	}

}
