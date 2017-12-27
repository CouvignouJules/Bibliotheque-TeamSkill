package fr.ynov.biblioskill.metier;

import java.util.List;

import fr.ynov.biblioskill.metier.entities.Categorie;
import fr.ynov.biblioskill.metier.entities.Livre;

/**
 * 
 * @author adrien
 *
 */
public interface ICatalogueMetier {
	public Categorie addCategorie(Categorie c);
	public Livre addLivre(Livre p);
	public List<Categorie> listCategories();
	public List<Livre> listLivres();
	public List<Livre> livresParCat(Long idCategorie);
	public Categorie getCategorie(Long idCategorie);
	public Livre getLivre(Long idLivre);	
	public List<Livre> livresParAut(Long idAuteur);
	public Categorie updateCategorie(Categorie c);
	public Livre updateLivre(Livre p);
	public boolean deleteLivre(Long idLivre);	
}
