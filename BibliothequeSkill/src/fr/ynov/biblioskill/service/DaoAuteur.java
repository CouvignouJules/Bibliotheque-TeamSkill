package fr.ynov.biblioskill.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;

import fr.ynov.biblioskill.metier.entities.Auteur;
import fr.ynov.biblioskill.service.Dao;

/**
 * 
 * @author TeamSkill
 * Permet de récupérer les données des auteurs en BDD
 */
public class DaoAuteur implements Dao<Auteur> {

	@PersistenceContext(unitName="biblioskill")
	
	/**
	 * Utilisé pour la persistence
	 */
	private EntityManager em;
	
	/**
	 * ctor
	 * Initialisation de l'attribut EntityManager
	 */
	public DaoAuteur() {
		em = Persistence.createEntityManagerFactory("biblioskill").createEntityManager();
	}
	
	/**
	 * Récupère tous les éléments en base
	 * @return la liste des Auteur
	 */
	@Override
	public List<Auteur> lireTous() {
		return em.createNamedQuery("lireAuteurs",Auteur.class).getResultList();
	}
	
	/**
	 * Récupère un seul élément en base en fonction de l'id
	 * @param cle
	 * @return le Auteur
	 */
	@Override
	public Auteur lire(Long cle) {
		return em.find(Auteur.class, cle);
	}
	
	/**
	 * Insère un auteur en base
	 * @param elt
	 */
	@Override
	public void inserer(Auteur elt) {
		em.getTransaction().begin();
		em.persist(elt);
		em.getTransaction().commit();
	}
	
	/**
	 * Supprime un auteur en base en fonction de l'id
	 * @param cle
	 */
	@Override
	public void effacer(Long cle) {
		Auteur tmp = null;
		em.getTransaction().begin();
		tmp = em.find(Auteur.class, cle);
		em.remove(tmp);
		em.getTransaction().commit();
	}
	
	/**
	 * Met à jour un auteur en base en fonction de son id
	 * @param index
	 * @param obj
	 */
	@Override
	public void update(Long index, Auteur obj) {
		em.getTransaction().begin();
		update(obj);
		em.getTransaction().commit();
	}
	
	/**
	 * Met à jour un auteur en base
	 * @param obj
	 */
	@Override
	public void update(Auteur obj) {
		em.merge(obj);
	}

}
