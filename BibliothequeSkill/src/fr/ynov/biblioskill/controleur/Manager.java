package fr.ynov.biblioskill.controleur;

import java.util.Vector;

import fr.ynov.biblioskill.metier.entities.Auteur;
import fr.ynov.biblioskill.metier.entities.Categorie;
import fr.ynov.biblioskill.metier.entities.Livre;
import fr.ynov.biblioskill.metier.entities.Personne;
import fr.ynov.biblioskill.metier.entities.Pret;
import fr.ynov.biblioskill.metier.entities.Utilisateur;

/**
 * 
 * @author adrien
 * Singleton
 * Manager
 */
public final class Manager {
	private static Manager instance = null;

	private Vector<Auteur> auteurs;
	private Vector<Categorie> categories;
	private Vector<Livre> livres;
	private Vector<Personne> personnes;
	private Vector<Pret> prets;
	private Vector<Utilisateur> utilisateurs;
	
	/**
	 * ctor privé
	 */
	private Manager() {
		auteurs = new Vector<>();
		categories = new Vector<>();
		livres = new Vector<>();
		personnes = new Vector<>();
		prets = new Vector<>();
		utilisateurs = new Vector<>();
		
		//TODO: Alors, ce qu'il reste à faire ici les zigotos c'est tout le bordel avec les Dao pour remplir toutes les listes
		//		ainsi que pour récupérer les informations nécessaires pour la vue (c'est à dire pour les JSP quand on en aura :D).
		//		Inspirez vous de YnovM
		//		Have Fun!
	}

	/**
	 * 
	 * @return l'instance
	 */
	public static Manager getInstance() {
		if (instance == null) {
			instance = new Manager();
		}
		return instance;
	}

	public Vector<Auteur> getAuteurs() {
		return auteurs;
	}

	public void setAuteurs(Vector<Auteur> auteurs) {
		this.auteurs = auteurs;
	}

	public Vector<Categorie> getCategories() {
		return categories;
	}

	public void setCategories(Vector<Categorie> categories) {
		this.categories = categories;
	}

	public Vector<Livre> getLivres() {
		return livres;
	}

	public void setLivres(Vector<Livre> livres) {
		this.livres = livres;
	}

	public Vector<Personne> getPersonnes() {
		return personnes;
	}

	public void setPersonnes(Vector<Personne> personnes) {
		this.personnes = personnes;
	}

	public Vector<Pret> getPrets() {
		return prets;
	}

	public void setPrets(Vector<Pret> prets) {
		this.prets = prets;
	}

	public Vector<Utilisateur> getUtilisateurs() {
		return utilisateurs;
	}

	public void setUtilisateurs(Vector<Utilisateur> utilisateurs) {
		this.utilisateurs = utilisateurs;
	}
}
