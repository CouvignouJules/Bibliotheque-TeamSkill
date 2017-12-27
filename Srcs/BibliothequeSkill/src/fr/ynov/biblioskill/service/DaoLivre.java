package fr.ynov.biblioskill.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;

import fr.ynov.biblioskill.metier.entities.Livre;
import fr.ynov.biblioskill.service.Dao;

/**
 * 
 * @author adrien
 * Permet de récupérer les données des livres en BDD
 */
public class DaoLivre implements Dao<Livre> {

	@PersistenceContext(unitName="biblioskill")
	
	/**
	 * Utilisé pour la persistence
	 */
	private EntityManager em;
	
	/**
	 * ctor
	 * Initialisation de l'attribut EntityManager
	 */
	public DaoLivre() {
		em = Persistence.createEntityManagerFactory("biblioskill").createEntityManager();
	}
	
	/**
	 * Récupère tous les éléments en base
	 * @return la liste des Livre
	 */
	@Override
	public List<Livre> lireTous() {
		return em.createNamedQuery("lireLivres",Livre.class).getResultList();
	}
	
	/**
	 * Récupère un seul élément en base en fonction de l'id
	 * @param cle
	 * @return le Livre
	 */
	@Override
	public Livre lire(int cle) {
		return em.find(Livre.class, cle);
	}
	
	/**
	 * Insère un livre en base
	 * @param elt
	 */
	@Override
	public void inserer(Livre elt) {
		em.getTransaction().begin();
		em.persist(elt);
		em.getTransaction().commit();
	}
	
	/**
	 * Supprime un livre en base en fonction de l'id
	 * @param cle
	 */
	@Override
	public void effacer(int cle) {
		Livre tmp = null;
		em.getTransaction().begin();
		tmp = em.find(Livre.class, cle);
		em.remove(tmp);
		em.getTransaction().commit();
	}
	
	/**
	 * Met à jour un livre en base en fonction de son id
	 * @param index
	 * @param obj
	 */
	@Override
	public void update(int index, Livre obj) {
		em.getTransaction().begin();
		update(obj);
		em.getTransaction().commit();
	}
	
	/**
	 * Met à jour un livre en base
	 * @param obj
	 */
	@Override
	public void update(Livre obj) {
		em.merge(obj);
	}

}
