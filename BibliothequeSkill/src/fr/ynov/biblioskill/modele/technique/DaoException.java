package fr.ynov.biblioskill.modele.technique;

/**
 * 
 * @author adrien
 * Gère les exceptions relatives au DAO
 */
public class DaoException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * ctor
	 */
	public DaoException()
	{
		super("Dao introuvable.");
	}
	/**
	 * ctor
	 * @param msg
	 */
	public DaoException(String msg)
	{
		super(msg);
	}
}
