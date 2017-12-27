package fr.ynov.biblioskill.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;

import fr.ynov.biblioskill.metier.entities.Utilisateur;
import fr.ynov.biblioskill.service.Dao;

/**
 * 
 * @author adrien
 * Permet de récupérer les données des utilisateurs en BDD
 */
public class DaoUtilisateur implements Dao<Utilisateur> {

	@PersistenceContext(unitName="biblioskill")
	
	/**
	 * Utilisé pour la persistence
	 */
	private EntityManager em;
	
	/**
	 * ctor
	 * Initialisation de l'attribut EntityManager
	 */
	public DaoUtilisateur() {
		em = Persistence.createEntityManagerFactory("biblioskill").createEntityManager();
	}
	
	/**
	 * Récupère tous les éléments en base
	 * @return la liste des Utilisateur
	 */
	@Override
	public List<Utilisateur> lireTous() {
		return em.createNamedQuery("lireUtilisateurs",Utilisateur.class).getResultList();
	}
	
	/**
	 * Récupère un seul élément en base en fonction de l'id
	 * @param cle
	 * @return le Utilisateur
	 */
	@Override
	public Utilisateur lire(int cle) {
		return em.find(Utilisateur.class, cle);
	}
	
	/**
	 * Insère un utilisateur en base
	 * @param elt
	 */
	@Override
	public void inserer(Utilisateur elt) {
		em.getTransaction().begin();
		em.persist(elt);
		em.getTransaction().commit();
	}
	
	/**
	 * Supprime un utilisateur en base en fonction de l'id
	 * @param cle
	 */
	@Override
	public void effacer(int cle) {
		Utilisateur tmp = null;
		em.getTransaction().begin();
		tmp = em.find(Utilisateur.class, cle);
		em.remove(tmp);
		em.getTransaction().commit();
	}
	
	/**
	 * Met à jour un utilisateur en base en fonction de son id
	 * @param index
	 * @param obj
	 */
	@Override
	public void update(int index, Utilisateur obj) {
		em.getTransaction().begin();
		update(obj);
		em.getTransaction().commit();
	}
	
	/**
	 * Met à jour un utilisateur en base
	 * @param obj
	 */
	@Override
	public void update(Utilisateur obj) {
		em.merge(obj);
	}

}
