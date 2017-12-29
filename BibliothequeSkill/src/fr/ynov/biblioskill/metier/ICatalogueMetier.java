package fr.ynov.biblioskill.metier;

import java.util.List;

import fr.ynov.biblioskill.metier.entities.Auteur;
import fr.ynov.biblioskill.metier.entities.Categorie;
import fr.ynov.biblioskill.metier.entities.Livre;
import fr.ynov.biblioskill.metier.entities.Personne;
import fr.ynov.biblioskill.metier.entities.Pret;
import fr.ynov.biblioskill.metier.entities.Utilisateur;

/**
 * 
 * @author adrien
 * Thomas => Vu le nombre de méthodes, j'ai effectué une petite réorganisation (Ce commentaire s'auto-détruira d'ici quelques jours)
 *
 */
public interface ICatalogueMetier {
	public Auteur addAuteur(Auteur a);
	public List<Auteur> listAuteurs();
	public Auteur getAuteur(Long idAuteur);
	public Auteur updateAuteur(Auteur a);
	public boolean deleteAuteur(Long idAuteur);
	
	public Categorie addCategorie(Categorie c);
	public List<Categorie> listCategories();
	public Categorie getCategorie(Long idCategorie);
	public Categorie updateCategorie(Categorie c);
	public boolean deleteCategorie(Long idCategorie);
	
	public Livre addLivre(Livre l);
	public List<Livre> listLivres();
	public Livre getLivre(Long idLivre);
	public Livre updateLivre(Livre l);
	public boolean deleteLivre(Long idLivre);
	
	public Personne addPersonne(Personne p);
	public List<Personne> listPersonnes();
	public Personne getPersonne(Long idPersonne);
	public Personne updatePersonne(Personne p);
	public boolean deletePersonne(Long idPersonne);
	
	public Pret addPret(Pret p);
	public List<Pret> listPret();
	public Pret getPret(Long idPret);
	public Pret updatePret(Pret p);
	public boolean deletePret(Long idPret);
	
	public Utilisateur addUtilisateur(Utilisateur u);
	public List<Utilisateur> listUtilisateur();
	public Utilisateur getUtilisateur(Long idUtilisateur);
	public Utilisateur updateUtilisateur(Utilisateur u);
	public boolean deleteUtilisateur(Long idUtilisateur);
	
	
	public List<Livre> livresParCat(Long idCategorie);
	public List<Livre> livresParAut(Long idAuteur);
	
	
	
}
