package fr.ynov.biblioskill.serveur;

import javax.xml.ws.Endpoint;

import fr.ynov.biblioskill.service.CatalogueService;

/**
 * 
 * @author Tomafa06
 *	Serveur sur lequel est publié le Web Service (SOAP)
 */
public class ServeurWS {

	public ServeurWS() {
		// TODO Auto-generated constructor stub
	}
	
	public static void main(String[] args) {
		// Déclaration des points d'accès sur le serveur
		String port = "4269";
		String url="http://localhost:" + port;
		
		// Publication du WebService SOAP
		Endpoint.publish(url, new CatalogueService());
		
		// Affiche de l'url pour tester si ça fonctionne
		System.out.println(url);
	}

}
