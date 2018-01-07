package fr.ynov.biblioskill.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;

import fr.ynov.biblioskill.metier.entities.Pret;
import fr.ynov.biblioskill.service.Dao;

/**
 * 
 * @author TeamSkill
 * Permet de r�cup�rer les donn�es des prets en BDD
 */
public class DaoPret implements Dao<Pret> {

	@PersistenceContext(unitName="biblioskill")
	
	/**
	 * Utilis� pour la persistence
	 */
	private EntityManager em;
	
	/**
	 * ctor
	 * Initialisation de l'attribut EntityManager
	 */
	public DaoPret() {
		em = Persistence.createEntityManagerFactory("biblioskill").createEntityManager();
	}
	
	/**
	 * R�cup�re tous les �l�ments en base
	 * @return la liste des Pret
	 */
	@Override
	public List<Pret> lireTous() {
		return em.createNamedQuery("lirePrets",Pret.class).getResultList();
	}
	
	/**
	 * R�cup�re un seul �l�ment en base en fonction de l'id
	 * @param cle
	 * @return le Pret
	 */
	@Override
	public Pret lire(Long cle) {
		return em.find(Pret.class, cle);
	}
	
	/**
	 * Ins�re un pret en base
	 * @param elt
	 */
	@Override
	public void inserer(Pret elt) {
		em.getTransaction().begin();
		em.persist(elt);
		em.getTransaction().commit();
	}
	
	/**
	 * Supprime un pret en base en fonction de l'id
	 * @param cle
	 */
	@Override
	public void effacer(Long cle) {
		Pret tmp = null;
		em.getTransaction().begin();
		tmp = em.find(Pret.class, cle);
		em.remove(tmp);
		em.getTransaction().commit();
	}
	
	/**
	 * Met � jour un pret en base en fonction de son id
	 * @param index
	 * @param obj
	 */
	@Override
	public void update(Long index, Pret obj) {
		em.getTransaction().begin();
		update(obj);
		em.getTransaction().commit();
	}
	
	/**
	 * Met � jour un pret en base
	 * @param obj
	 */
	@Override
	public void update(Pret obj) {
		em.merge(obj);
	}

}
