package fr.ynov.biblioskill.metier;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import fr.ynov.biblioskill.controleur.Manager;
import fr.ynov.biblioskill.metier.entities.Auteur;
import fr.ynov.biblioskill.metier.entities.Categorie;
import fr.ynov.biblioskill.metier.entities.Livre;
import fr.ynov.biblioskill.metier.entities.Personne;
import fr.ynov.biblioskill.metier.entities.Pret;
import fr.ynov.biblioskill.metier.entities.Utilisateur;

/**
 * 
 * @author TeamSkill
 *	regroupe toute les action possible sur les diferentes entities metier
 */
public class CatalogueMetierImpl implements ICatalogueMetier{
	private Map<Long, Auteur> auteurs = new HashMap<Long, Auteur>();
	private Map<Long, Categorie> categories = new HashMap<Long, Categorie>();
	private Map<Long, Livre> livres = new HashMap<Long, Livre>();
	private Map<Long, Personne> personnes = new HashMap<Long, Personne>();
	private Map<Long, Pret> prets = new HashMap<Long, Pret>();
	private Map<Long, Utilisateur> utilisateurs = new HashMap<Long, Utilisateur>();
	
	/************************************** Auteurs ******************************************/
	
	@Override
	public Auteur addAuteur(Auteur a) {
		auteurs.put(a.getId(), a);		
		return a;
	}

	@Override
	public List<Auteur> listAuteurs() {
		return new ArrayList<Auteur>(auteurs.values());
	}

	@Override
	public Auteur getAuteur(Long idAuteur) {
		return auteurs.get(idAuteur);
	}

	@Override
	public Auteur updateAuteur(Auteur a) {
		auteurs.put(a.getId(), a);
		return a;
	}

	@Override
	public boolean deleteAuteur(Long idAuteur) {
		if(auteurs.get(idAuteur)!=null){
			auteurs.remove(idAuteur);
			return true;
		}
		else throw new RuntimeException("Auteur inconnu");
	}
	
	/************************************** Catégories ******************************************/
	
	@Override
	public Categorie addCategorie(Categorie c) {
		categories.put(c.getId(), c);		
		return c;
	}
	
	@Override
	public List<Categorie> listCategories() {
		return new ArrayList<Categorie>(categories.values());
	}
	
	@Override
	public Categorie getCategorie(Long idCategorie) {
		return categories.get(idCategorie);
	}
	
	@Override
	public Categorie updateCategorie(Categorie c) {
		categories.put(c.getId(), c);
		return c;
	}
	
	@Override
	public boolean deleteCategorie(Long idCategorie) {
		if(categories.get(idCategorie)!=null){
			categories.remove(idCategorie);
			return true;
		}
		else throw new RuntimeException("Catégorie inexistante");
	}
	
	/************************************** Livres ******************************************/

	@Override
	public Livre addLivre(Livre l) {
		l.setCategorie(getCategorie(l.getCategorie().getId()));
		l.setAuteur(getAuteur(l.getAuteur().getId()));
		livres.put(l.getId(), l);		
		return l;
	}

	@Override
	public List<Livre> listLivres() {
		return new ArrayList<Livre>(livres.values());
	}
	
	@Override
	public Livre getLivre(Long idLivre) {
		return livres.get(idLivre);
	}	

	@Override
	public Livre updateLivre(Livre l) {
		livres.put(l.getId(), l);
		return l;
	}

	@Override
	public boolean deleteLivre(Long idLivre) {
		if(livres.get(idLivre)!=null){
			livres.remove(idLivre);
			return true;
		}
		else throw new RuntimeException("Livre introuvable");
	}
	
	/************************************** Personnes ******************************************/
	
	@Override
	public Personne addPersonne(Personne p) {
		personnes.put(p.getId(), p);
		return p;
	}

	@Override
	public List<Personne> listPersonnes() {
		return new ArrayList<Personne>(personnes.values());
	}

	@Override
	public Personne getPersonne(Long idPersonne) {
		return personnes.get(idPersonne);
	}

	@Override
	public Personne updatePersonne(Personne p) {
		personnes.put(p.getId(), p);
		return p;
	}

	@Override
	public boolean deletePersonne(Long idPersonne) {
		if(personnes.get(idPersonne)!=null){
			personnes.remove(idPersonne);
			return true;
		}
		else throw new RuntimeException("Personne introuvable");
	}
	
	/************************************** Prêts ******************************************/
	
	@Override
	public Pret addPret(Pret p) {
		prets.put(p.getId(), p);
		return p;
	}

	@Override
	public List<Pret> listPret() {
		return new ArrayList<Pret>(prets.values());
	}

	@Override
	public Pret getPret(Long idPret) {
		return prets.get(idPret);
	}

	@Override
	public Pret updatePret(Pret p) {
		prets.put(p.getId(), p);
		return p;
	}

	@Override
	public boolean deletePret(Long idPret) {
		if(prets.get(idPret)!=null){
			prets.remove(idPret);
			return true;
		}
		else throw new RuntimeException("Pret non effectué");
	}
	
	/************************************** Utilisateurs ******************************************/
	
	@Override
	public Utilisateur addUtilisateur(Utilisateur u) {
		utilisateurs.put(u.getId(), u);
		return u;
	}

	@Override
	public List<Utilisateur> listUtilisateur() {
		return new ArrayList<Utilisateur>(utilisateurs.values());
	}

	@Override
	public Utilisateur getUtilisateur(Long idUtilisateur) {
		return utilisateurs.get(idUtilisateur);
	}

	@Override
	public Utilisateur updateUtilisateur(Utilisateur u) {
		utilisateurs.put(u.getId(), u);
		return u;
	}

	@Override
	public boolean deleteUtilisateur(Long idUtilisateur) {
		if(utilisateurs.get(idUtilisateur)!=null){
			prets.remove(idUtilisateur);
			return true;
		}
		else throw new RuntimeException("Utilisateur inconnu");
	}
	
	/************************************** Relations ******************************************/

	@Override
	public List<Livre> livresParCat(Long idCategorie) {
		List<Livre> books = new ArrayList<Livre>();
		
		for(Livre l:livres.values()){
			if(l.getCategorie().getId().equals(idCategorie))
				books.add(l);
		}
		return books;
	}
	
	@Override
	public List<Livre> livresParAut(Long idAuteur) {
		List<Livre> books = new ArrayList<Livre>();
		
		for(Livre l:livres.values()){
			if(l.getAuteur().getId().equals(idAuteur))
				books.add(l);
		}
		return books;
	}
	
	/**
	 * Initialise toutes les listes
	 */
	public void initialiserCatalogue(){
		//Initialisez toutes les listes grâce au Manager (un peu comme on faisait dans le main de YnovM ou de Zoo)
		Manager m = Manager.getInstance();
		
		for(Auteur a : m.getAuteurs()) {
			this.addAuteur(a);
		}
		
		for(Categorie c : m.getCategories()) {
			this.addCategorie(c);
		}
		
		for(Livre l : m.getLivres()) {
			this.addLivre(l);
		}
		
		for(Personne p : m.getPersonnes()) {
			this.addPersonne(p);
		}
		
		for(Pret p : m.getPrets()) {
			this.addPret(p);
		}
		
		for(Utilisateur u : m.getUtilisateurs()) {
			this.addUtilisateur(u);
		}
	}

}
