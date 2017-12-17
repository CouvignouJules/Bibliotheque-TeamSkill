package fr.ynov.biblioskill.service;

import java.util.List;

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
import fr.ynov.biblioskill.metier.entities.Categorie;
import fr.ynov.biblioskill.metier.entities.Livre;

/**
 * 
 * @author adrien
 *
 */
@Singleton
@Path("/catalogue")
public class CatalogueService {
	private CatalogueMetierImpl metier;
	//TODO: Ce qu'il reste à faire ici pour le service REST, c'est rajouter tout ce qui aura été rajouté dans CatalogueMetierImpl
	// 		Il reste aussi à créer le client REST (c'est-à-dire un autre projet Java)
	//		Ensuite, il faudra faire le SAOP en accord avec le sujet du prof
	
	public CatalogueService(){
		metier = new CatalogueMetierImpl();
		metier.initialiserCatalogue();
	}
	
	@GET
	@Path("/categories")
	@Produces(MediaType.APPLICATION_JSON+";charset=utf-8")
	public List<Categorie> consulterCategories(){
		return metier.listCategories();
	}
	
	@GET
	@Path("/livres")
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public List<Livre> consulterLivres(){
		return metier.listLivres();
	}
	
	@GET
	@Path("/categories/{idCat}/livres")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Livre> livresParCat(@PathParam(value="idCat") Long idCategorie){
		return metier.livresParCat(idCategorie);
	}
	
	@GET
	@Path("/livresAut")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Livre> livresParMC(@QueryParam(value="idAut")Long idAut){
		return metier.livresParAut(idAut);
	}
	
	@GET
	@Path("/categories/{idCat}")
	@Produces(MediaType.APPLICATION_JSON)
	public Categorie getCategorie(@PathParam(value="idCat") Long idCategorie){
		return metier.getCategorie(idCategorie);		
	}
	
	@GET
	@Path("/livres/{idProd}")
	@Produces(MediaType.APPLICATION_JSON)
	public Livre getLivre(@PathParam(value="idProd") Long idLivre){
		return metier.getLivre(idLivre);
	}
	
	@POST
	@Path("/categories")
	@Consumes(MediaType.APPLICATION_JSON)
	public Categorie saveCategorie(Categorie c){
		return metier.addCategorie(c);
	}
	
	@POST
	@Path("/livres")
	@Consumes(MediaType.APPLICATION_JSON)
	public Livre saveLivre(Livre p){
		return metier.addLivre(p);
	}
	
	@DELETE
	@Path("/livres")
	@Produces(MediaType.APPLICATION_JSON)
	public boolean deleteLivre(@FormParam(value="idProd") Long idLivre){
		return metier.deleteLivre(idLivre);
	}
	
	@PUT
	@Path("/livres")
	@Produces(MediaType.APPLICATION_JSON)
	public Livre updateLivre(Livre p){
		return metier.updateLivre(p);
	}
	
	@PUT
	@Path("/categories")
	@Produces(MediaType.APPLICATION_JSON)
	public Categorie updateCategorie(Categorie c){
		return metier.updateCategorie(c);
	}	
}
