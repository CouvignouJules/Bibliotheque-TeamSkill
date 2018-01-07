package fr.ynov.biblioskill.controleur;

import java.util.List;
import java.util.Vector;

import fr.ynov.biblioskill.metier.entities.Auteur;
import fr.ynov.biblioskill.metier.entities.Categorie;
import fr.ynov.biblioskill.metier.entities.Livre;
import fr.ynov.biblioskill.metier.entities.Personne;
import fr.ynov.biblioskill.metier.entities.Pret;
import fr.ynov.biblioskill.metier.entities.Utilisateur;
import fr.ynov.biblioskill.modele.technique.DaoException;
import fr.ynov.biblioskill.service.DaoFactory;
import fr.ynov.biblioskill.utilitaire.DaoEnum;

/**
 * 
 * @author TeamSkill
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
		
		// Fait
		init();
	}
	
	/**
	 * Récupère toutes les informations à envoyer à la vue grâce aux Dao
	 */
	private void init() {
		List<Auteur> tmp_auteurs = null;
		List<Categorie> tmp_categories = null;
		List<Livre> tmp_livres = null;
		List<Personne> tmp_personnes = null;
		List<Pret> tmp_prets = null;
		List<Utilisateur> tmp_utilisateurs = null;
		
		
		try {
			// Thomas => Je suis obligé de caster ici apparemment, sinon erreur car la liste est initialisée dans l'interface DAO comme un type générique (<T>)
			tmp_auteurs = (List<Auteur>) DaoFactory.getInstance().getDao(DaoEnum.AUTEUR).lireTous();
			tmp_categories = (List<Categorie>) DaoFactory.getInstance().getDao(DaoEnum.CATEGORIE).lireTous();
			tmp_livres = (List<Livre>) DaoFactory.getInstance().getDao(DaoEnum.LIVRE).lireTous();
			tmp_personnes = (List<Personne>) DaoFactory.getInstance().getDao(DaoEnum.PERSONNE).lireTous();
			tmp_prets = (List<Pret>) DaoFactory.getInstance().getDao(DaoEnum.PRET).lireTous();
			tmp_utilisateurs = (List<Utilisateur>) DaoFactory.getInstance().getDao(DaoEnum.UTILISATEUR).lireTous();
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for(Auteur a : tmp_auteurs) {
			auteurs.add(new Auteur(a.getId(), a.getaProposDe(), a.getNationalite(), a.getType()));
		}
		
		for(Categorie c : tmp_categories) {
			categories.add(new Categorie(c.getId(), c.getNom(), c.getDescription()));
		}
		
		for(Livre l : tmp_livres) {
			livres.add(new Livre(l.getId(), l.getTitre(), l.getResume(), l.getQuantite(), l.getIsbn(), l.getPhoto(), l.getDatePublication()));
		}
		
		for(Personne p : tmp_personnes) {
			personnes.add(new Personne(p.getId(), p.getNom(), p.getPrenom(), p.getSexe(), p.getPhoto(), p.getEmail(), p.getDateDeNaissance()));
		}
		
		for(Pret p : tmp_prets) {
			prets.add(new Pret(p.getId(), p.getDateDebut(), p.getDuree()));
		}
		
		for(Utilisateur u : tmp_utilisateurs) {
			utilisateurs.add(new Utilisateur(u.getId(), u.getNomUtilisateur(), u.getMotDePasse(), u.getStatutCompte(), u.getDerniereConnexion()));
		}
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
