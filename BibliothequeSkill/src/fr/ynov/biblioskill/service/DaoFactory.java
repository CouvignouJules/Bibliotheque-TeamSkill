package fr.ynov.biblioskill.service;

import fr.ynov.biblioskill.modele.technique.DaoException;
import fr.ynov.biblioskill.utilitaire.DaoEnum;

/**
 * 
 * @author adrien Singleton Factory de la DAO
 */
public class DaoFactory {

	/**
	 * Fichier de properties
	 */
	public final static String FICHIER = "acces.properties";

	/**
	 * Instance de la factory
	 */
	private static DaoFactory instance = null;

	/**
	 * ctor privé
	 */
	private DaoFactory() {
	}

	/**
	 * Distribue l'instance de la factory
	 * @return l'instance de la factory
	 */
	public static DaoFactory getInstance() {
		if (instance == null) {
			instance = new DaoFactory();
		}
		return instance;
	}

	/**
	 * 
	 * @return la DAO
	 * @throws DaoException
	 */
	public Dao<?> getDao(DaoEnum dao) throws DaoException {
		switch (dao) {
		case AUTEUR:
			return new DaoAuteur();
		case CATEGORIE:
			return new DaoCategorie();
		case LIVRE:
			return new DaoLivre();
		case PERSONNE:
			return new DaoPersonne();
		case PRET:
			return new DaoPret();
		case UTILISATEUR:
			return new DaoUtilisateur();
		default:
			throw new DaoException();
		}
	}
}