package fr.ynov.biblioskill.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;

import fr.ynov.biblioskill.metier.entities.Personne;
import fr.ynov.biblioskill.service.Dao;

/**
 * 
 * @author adrien
 * Permet de récupérer les données des personnes en BDD
 */
public class DaoPersonne implements Dao<Personne> {

	@PersistenceContext(unitName="biblioskill")
	
	/**
	 * Utilisé pour la persistence
	 */
	private EntityManager em;
	
	/**
	 * ctor
	 * Initialisation de l'attribut EntityManager
	 */
	public DaoPersonne() {
		em = Persistence.createEntityManagerFactory("biblioskill").createEntityManager();
	}
	
	/**
	 * Récupère tous les éléments en base
	 * @return la liste des Personne
	 */
	@Override
	public List<Personne> lireTous() {
		return em.createNamedQuery("lirePersonnes",Personne.class).getResultList();
	}
	
	/**
	 * Récupère un seul élément en base en fonction de l'id
	 * @param cle
	 * @return la Personne
	 */
	@Override
	public Personne lire(Long cle) {
		return em.find(Personne.class, cle);
	}
	
	/**
	 * Insère une personne en base
	 * @param elt
	 */
	@Override
	public void inserer(Personne elt) {
		em.getTransaction().begin();
		em.persist(elt);
		em.getTransaction().commit();
	}
	
	/**
	 * Supprime une personne en base en fonction de l'id
	 * @param cle
	 */
	@Override
	public void effacer(Long cle) {
		Personne tmp = null;
		em.getTransaction().begin();
		tmp = em.find(Personne.class, cle);
		em.remove(tmp);
		em.getTransaction().commit();
	}
	
	/**
	 * Met à jour une personne en base en fonction de son id
	 * @param index
	 * @param obj
	 */
	@Override
	public void update(Long index, Personne obj) {
		em.getTransaction().begin();
		update(obj);
		em.getTransaction().commit();
	}
	
	/**
	 * Met à jour une personne en base
	 * @param obj
	 */
	@Override
	public void update(Personne obj) {
		em.merge(obj);
	}

}
