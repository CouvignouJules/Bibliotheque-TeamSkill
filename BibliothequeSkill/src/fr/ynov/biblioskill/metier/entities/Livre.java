package fr.ynov.biblioskill.metier.entities;
import java.io.Serializable;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name ="livre")
@NamedQuery(name="lireLivres",query="SELECT l FROM Livre l")
public class Livre implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)	
	private Long id;
	private String titre;
	private String resume;
	private int quantite;
	private String isbn;
	private String photo;
	@Temporal(TemporalType.DATE)
	private GregorianCalendar datePublication;
	@ManyToOne
	@JoinColumn(name="idCategorie",referencedColumnName="idCategorie",updatable=false,insertable=false) 
	private Categorie categorie;
	@ManyToOne
	@JoinColumn(name="idAuteur",referencedColumnName="idAuteur",updatable=false,insertable=false) 
	private Auteur auteur;

	public Livre() {
		// TODO Auto-generated constructor stub
	}

	public Livre(Long id, String titre, String resume, int quantite, String isbn, String photo, GregorianCalendar datePublication) {
		super();
		this.id = id;
		this.titre = titre;
		this.resume = resume;
		this.quantite = quantite;
		this.isbn = isbn;
		this.photo = photo;
		this.datePublication = datePublication;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public String getResume() {
		return resume;
	}

	public void setResume(String resume) {
		this.resume = resume;
	}

	public int getQuantite() {
		return quantite;
	}

	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public GregorianCalendar getDatePublication() {
		return datePublication;
	}

	public void setDatePublication(GregorianCalendar datePublication) {
		this.datePublication = datePublication;
	}

	public Categorie getCategorie() {
		return categorie;
	}

	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}

	public Auteur getAuteur() {
		return auteur;
	}

	public void setAuteur(Auteur auteur) {
		this.auteur = auteur;
	}

}
