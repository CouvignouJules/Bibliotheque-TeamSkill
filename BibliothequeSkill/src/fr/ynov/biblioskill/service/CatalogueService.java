package fr.ynov.biblioskill.service;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.sun.jersey.spi.resource.Singleton;

import fr.ynov.biblioskill.metier.CatalogueMetierImpl;
import fr.ynov.biblioskill.metier.entities.Auteur;
import fr.ynov.biblioskill.metier.entities.Categorie;
import fr.ynov.biblioskill.metier.entities.Livre;
import fr.ynov.biblioskill.metier.entities.Personne;
import fr.ynov.biblioskill.metier.entities.Pret;
import fr.ynov.biblioskill.metier.entities.Utilisateur;

/**
 * 
 * @author adrien
 *
 */
@Singleton
@Path("/catalogue")
@WebService(name="catalogue")
public class CatalogueService {
	private CatalogueMetierImpl metier;
	//TODO: Ce qu'il reste à faire ici pour le service REST, c'est rajouter tout ce qui aura été rajouté dans CatalogueMetierImpl
	// 		Il reste aussi à créer le client REST (c'est-à-dire un autre projet Java)
	//		Ensuite, il faudra faire le SAOP en accord avec le sujet du prof
	
	public CatalogueService(){
		metier = new CatalogueMetierImpl();
		metier.initialiserCatalogue();
	}
	
	/******************************/
	
	@GET
	@Path("/auteurs")
	@Produces(MediaType.APPLICATION_JSON+";charset=utf-8")
	@WebMethod
	public List<Auteur> consulterAuteurs(){
		return metier.listAuteurs();
	}
	
	@PUT
	@Path("/auteurs")
	@Produces(MediaType.APPLICATION_JSON)
	@WebMethod
	public Auteur updateAuteur(Auteur a){
		return metier.updateAuteur(a);
	}
	
	@GET
	@Path("/auteurs/{idAut}")
	@Produces(MediaType.APPLICATION_JSON)
	@WebMethod
	public Auteur getAuteur(@PathParam(value="idAut") @WebParam(name="idAut") Long idAuteur){
		return metier.getAuteur(idAuteur);		
	}
	
	@POST
	@Path("/auteurs")
	@Consumes(MediaType.APPLICATION_JSON)
	@WebMethod
	public Auteur saveAuteur(Auteur a){
		return metier.addAuteur(a);
	}
	
	@DELETE
	@Path("/auteurs")
	@Produces(MediaType.APPLICATION_JSON)
	@WebMethod
	public boolean auteurs(@FormParam(value="idAut") @WebParam(name="idAut") Long idAuteur){
		return metier.deleteAuteur(idAuteur);
	}
	
	/******************************/
	
	@GET
	@Path("/categories")
	@Produces(MediaType.APPLICATION_JSON+";charset=utf-8")
	@WebMethod
	public List<Categorie> consulterCategories(){
		return metier.listCategories();
	}
	
	@PUT
	@Path("/categories")
	@Produces(MediaType.APPLICATION_JSON)
	@WebMethod
	public Categorie updateCategorie(Categorie c){
		return metier.updateCategorie(c);
	}
	
	@GET
	@Path("/categories/{idCat}")
	@Produces(MediaType.APPLICATION_JSON)
	@WebMethod
	public Categorie getCategorie(@PathParam(value="idCat") @WebParam(name="idCat") Long idCategorie){
		return metier.getCategorie(idCategorie);		
	}
	
	@POST
	@Path("/categories")
	@Consumes(MediaType.APPLICATION_JSON)
	@WebMethod
	public Categorie saveCategorie(Categorie c){
		return metier.addCategorie(c);
	}
	
	@DELETE
	@Path("/categories")
	@Produces(MediaType.APPLICATION_JSON)
	@WebMethod
	public boolean categories(@FormParam(value="idCat") @WebParam(name="idCat") Long idCategorie){
		return metier.deleteCategorie(idCategorie);
	}
	
	/******************************/
	
	@GET
	@Path("/livres")
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	@WebMethod
	public List<Livre> consulterLivres(){
		return metier.listLivres();
	}
	
	@GET
	@Path("/livres/{idLivre}")
	@Produces(MediaType.APPLICATION_JSON)
	@WebMethod
	public Livre getLivre(@PathParam(value="idLivre") @WebParam(name="idLivre") Long idLivre){
		return metier.getLivre(idLivre);
	}
	
	@PUT
	@Path("/livres")
	@Produces(MediaType.APPLICATION_JSON)
	@WebMethod
	public Livre updateLivre(Livre p){
		return metier.updateLivre(p);
	}
	
	@POST
	@Path("/livres")
	@Consumes(MediaType.APPLICATION_JSON)
	@WebMethod
	public Livre saveLivre(Livre p){
		return metier.addLivre(p);
	}
	
	@DELETE
	@Path("/livres")
	@Produces(MediaType.APPLICATION_JSON)
	@WebMethod
	public boolean deleteLivre(@FormParam(value="idLivre") @WebParam(name="idLivre") Long idLivre){
		return metier.deleteLivre(idLivre);
	}
	
	@GET
	@Path("/livresAut")
	@Produces(MediaType.APPLICATION_JSON)
	@WebMethod
	public List<Livre> livresParMC(@QueryParam(value="idAut") @WebParam(name="idAut") Long idAut){
		return metier.livresParAut(idAut);
	}
	
	@GET
	@Path("/categories/{idCat}/livres")
	@Produces(MediaType.APPLICATION_JSON)
	@WebMethod
	public List<Livre> livresParCat(@PathParam(value="idCat") @WebParam(name="idCat") Long idCategorie){
		return metier.livresParCat(idCategorie);
	}
	
	/******************************/
	
	@GET
	@Path("/personnes")
	@Produces(MediaType.APPLICATION_JSON+";charset=utf-8")
	@WebMethod
	public List<Personne> consulterPersonnes(){
		return metier.listPersonnes();
	}
	
	@PUT
	@Path("/personnes")
	@Produces(MediaType.APPLICATION_JSON)
	@WebMethod
	public Personne updatePersonne(Personne p){
		return metier.updatePersonne(p);
	}
	
	@GET
	@Path("/personnes/{idPers}")
	@Produces(MediaType.APPLICATION_JSON)
	@WebMethod
	public Personne getPersonne(@PathParam(value="idPers") @WebParam(name="idPers") Long idPersonne){
		return metier.getPersonne(idPersonne);		
	}
	
	@POST
	@Path("/personnes")
	@Consumes(MediaType.APPLICATION_JSON)
	@WebMethod
	public Personne savePersonne(Personne p){
		return metier.addPersonne(p);
	}
	
	@DELETE
	@Path("/personnes")
	@Produces(MediaType.APPLICATION_JSON)
	@WebMethod
	public boolean personnes(@FormParam(value="idPers") @WebParam(name="idPers") Long idPersonne){
		return metier.deletePersonne(idPersonne);
	}
	
	/******************************/
	
	@GET
	@Path("/prets")
	@Produces(MediaType.APPLICATION_JSON+";charset=utf-8")
	@WebMethod
	public List<Pret> consulterPret(){
		return metier.listPret();
	}
	
	@PUT
	@Path("/prets")
	@Produces(MediaType.APPLICATION_JSON)
	@WebMethod
	public Pret updatePret(Pret p){
		return metier.updatePret(p);
	}
	
	@GET
	@Path("/prets/{idPret}")
	@Produces(MediaType.APPLICATION_JSON)
	@WebMethod
	public Pret getPret(@PathParam(value="idPret") @WebParam(name="idPret") Long idPret){
		return metier.getPret(idPret);		
	}
	
	@POST
	@Path("/prets")
	@Consumes(MediaType.APPLICATION_JSON)
	@WebMethod
	public Pret savePret(Pret p){
		return metier.addPret(p);
	}
	
	@DELETE
	@Path("/prets")
	@Produces(MediaType.APPLICATION_JSON)
	@WebMethod
	public boolean prets(@FormParam(value="idPret") @WebParam(name="idPret") Long idPret){
		return metier.deletePret(idPret);
	}
	
	/******************************/
	
	@GET
	@Path("/utilisateurs")
	@Produces(MediaType.APPLICATION_JSON+";charset=utf-8")
	@WebMethod
	public List<Utilisateur> consulterUtilisateur(){
		return metier.listUtilisateur();
	}
	
	@PUT
	@Path("/utilisateurs")
	@Produces(MediaType.APPLICATION_JSON)
	@WebMethod
	public Utilisateur updateUtilisateur(Utilisateur u){
		return metier.updateUtilisateur(u);
	}
	
	@GET
	@Path("/utilisateurs/{idUtil}")
	@Produces(MediaType.APPLICATION_JSON)
	@WebMethod
	public Utilisateur getUtilisateur(@PathParam(value="idUtil") @WebParam(name="idUtil") Long idUtilisateur){
		return metier.getUtilisateur(idUtilisateur);		
	}
	
	@POST
	@Path("/utilisateurs")
	@Consumes(MediaType.APPLICATION_JSON)
	@WebMethod
	public Utilisateur saveUtilisateur(Utilisateur u){
		return metier.addUtilisateur(u);
	}
	
	@DELETE
	@Path("/utilisateurs")
	@Produces(MediaType.APPLICATION_JSON)
	@WebMethod
	public boolean utilisateurs(@FormParam(value="idUtil") @WebParam(name="idUtil") Long idUtilisateur){
		return metier.deleteUtilisateur(idUtilisateur);
	}
}
