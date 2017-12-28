package fr.ynov.biblioskill.modele.technique;

/**
 * 
 * @author adrien
 * Gère les exceptions relatives à la connexion
 */
public class ConnexionException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * ctor
	 */
	public ConnexionException()
	{
		super("Erreur de connexion.");
	}
	/**
	 * ctor
	 * @param msg
	 */
	public ConnexionException(String msg)
	{
		super(msg);
	}
}
