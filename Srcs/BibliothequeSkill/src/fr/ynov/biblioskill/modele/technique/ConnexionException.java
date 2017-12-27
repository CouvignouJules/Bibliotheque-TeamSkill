package fr.ynov.biblioskill.modele.technique;

/**
 * 
 * @author adrien
 * G�re les exceptions relatives � la connexion
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
