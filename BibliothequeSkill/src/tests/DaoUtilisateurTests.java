package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

import fr.ynov.biblioskill.metier.entities.Utilisateur;
import fr.ynov.biblioskill.service.DaoUtilisateur;

class DaoUtilisateurTests {
	private DaoUtilisateur jpa;

	public DaoUtilisateurTests() {
		jpa = new DaoUtilisateur();
	}

	@Test
	void testLireTous() {
		assertEquals(1, jpa.lireTous().size());
	}

	@Test
	void testLire() {
		assertTrue(true);
	}

	@Test
	void testInsererUpdateEffacer() {
		List<Utilisateur> res = null;
		res = jpa.lireTous();
		assertEquals(1, res.size());
		
		// INSERER
		Utilisateur tmp = new Utilisateur(2L, "test", null, null, null);
		jpa.inserer(tmp);
		res = jpa.lireTous();
		assertEquals(2, res.size());
		
		// UPDATE
		tmp = jpa.lire(2L);
		tmp.setNomUtilisateur("test1");
		jpa.update(2L, tmp);
		res = jpa.lireTous();
		assertEquals(2, res.size());
		assertEquals("test1", res.get(1).getNomUtilisateur());
		
		// EFFACER
		jpa.effacer(2L);
		res = jpa.lireTous();
		assertEquals(1, res.size());
	}

}
