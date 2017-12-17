package fr.ynov.biblioskill.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;

import fr.ynov.biblioskill.metier.entities.Categorie;
import fr.ynov.biblioskill.service.Dao;

/**
 * 
 * @author adrien
 * Permet de r�cup�rer les donn�es des categories en BDD
 */
public class DaoCategorie implements Dao<Categorie> {

	@PersistenceContext(unitName="biblioskill")
	
	/**
	 * Utilis� pour la persistence
	 */
	private EntityManager em;
	
	/**
	 * ctor
	 * Initialisation de l'attribut EntityManager
	 */
	public DaoCategorie() {
		em = Persistence.createEntityManagerFactory("biblioskill").createEntityManager();
	}
	
	/**
	 * R�cup�re tous les �l�ments en base
	 * @return la liste des Categorie
	 */
	@Override
	public List<Categorie> lireTous() {
		return em.createNamedQuery("lireCategories",Categorie.class).getResultList();
	}
	
	/**
	 * R�cup�re un seul �l�ment en base en fonction de l'id
	 * @param cle
	 * @return la Categorie
	 */
	@Override
	public Categorie lire(int cle) {
		return em.find(Categorie.class, cle);
	}
	
	/**
	 * Ins�re une categorie en base
	 * @param elt
	 */
	@Override
	public void inserer(Categorie elt) {
		em.getTransaction().begin();
		em.persist(elt);
		em.getTransaction().commit();
	}
	
	/**
	 * Supprime une categorie en base en fonction de l'id
	 * @param cle
	 */
	@Override
	public void effacer(int cle) {
		Categorie tmp = null;
		em.getTransaction().begin();
		tmp = em.find(Categorie.class, cle);
		em.remove(tmp);
		em.getTransaction().commit();
	}
	
	/**
	 * Met � jour une categorie en base en fonction de son id
	 * @param index
	 * @param obj
	 */
	@Override
	public void update(int index, Categorie obj) {
		em.getTransaction().begin();
		update(obj);
		em.getTransaction().commit();
	}
	
	/**
	 * Met � jour une categorie en base
	 * @param obj
	 */
	@Override
	public void update(Categorie obj) {
		em.merge(obj);
	}

}
