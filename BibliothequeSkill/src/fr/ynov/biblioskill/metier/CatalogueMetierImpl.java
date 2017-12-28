package fr.ynov.biblioskill.metier;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import fr.ynov.biblioskill.metier.entities.Categorie;
import fr.ynov.biblioskill.metier.entities.Livre;

/**
 * 
 * @author adrien
 *
 */
public class CatalogueMetierImpl implements ICatalogueMetier{
	private Map<Long, Categorie> categories = new HashMap<Long, Categorie>();
	private Map<Long, Livre> livres = new HashMap<Long, Livre>(); 
	//TODO: exemple : Map<Long, Auteur> auteur = new HashMap<Long, Auteur>() 
	//      -> rajouter les méthodes qu'il faut sur toutes les entités métiers :D
	//      (ajoutez-les aussi dans ICatalogueMetier, hein... je vous voir venir)
	
	@Override
	public Categorie addCategorie(Categorie c) {
		categories.put(c.getId(), c);		
		return c;
	}

	@Override
	public Livre addLivre(Livre p) {
		p.setCategorie(getCategorie(p.getCategorie().getId()));
		livres.put(p.getId(), p);		
		return p;
	}

	@Override
	public List<Categorie> listCategories() {
		return new ArrayList<Categorie>(categories.values());
	}

	@Override
	public List<Livre> listLivres() {
		return new ArrayList<Livre>(livres.values());
	}

	@Override
	public List<Livre> livresParCat(Long idCategorie) {
		List<Livre> books = new ArrayList<Livre>();
		
		for(Livre p:livres.values()){
			if(p.getCategorie().getId().equals(idCategorie))
				books.add(p);
		}
		return books;
	}

	@Override
	public Categorie getCategorie(Long idCategorie) {
		return categories.get(idCategorie);
	}

	@Override
	public Livre getLivre(Long idLivre) {
		return livres.get(idLivre);
	}

	@Override
	public List<Livre> livresParAut(Long idAuteur) {
		List<Livre> books = new ArrayList<Livre>();
		
		for(Livre p:livres.values()){
			if(p.getAuteur().getId().equals(idAuteur))
				books.add(p);
		}
		return books;
	}

	@Override
	public Categorie updateCategorie(Categorie c) {
		categories.put(c.getId(), c);
		return c;
	}

	@Override
	public Livre updateLivre(Livre p) {
		livres.put(p.getId(), p);
		return p;
	}

	@Override
	public boolean deleteLivre(Long idLivre) {
		if(livres.get(idLivre)!=null){
			livres.remove(idLivre);
			return true;
		}
		else throw new RuntimeException("Livre introuvable");
	}
	

	
	public void initialiserCatalogue(){
		//Initialisez toutes les listes grâce au Manager (un peu comme on faisait dans le main de YnovM ou de Zoo)
	}
}
