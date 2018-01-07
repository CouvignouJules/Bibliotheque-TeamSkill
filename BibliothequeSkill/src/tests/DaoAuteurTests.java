package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

import fr.ynov.biblioskill.metier.entities.Auteur;
import fr.ynov.biblioskill.service.DaoAuteur;
import fr.ynov.biblioskill.utilitaire.TypeAuteur;

class DaoAuteurTests {
	private DaoAuteur jpa;

	public DaoAuteurTests() {
		jpa = new DaoAuteur();
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
		List<Auteur> res = null;
		res = jpa.lireTous();
		assertEquals(1, res.size());
		
		// INSERER
		Auteur tmp = new Auteur(2L, "test", "test", TypeAuteur.PRINCIPAL);
		jpa.inserer(tmp);
		res = jpa.lireTous();
		assertEquals(2, res.size());		
		// UPDATE
		tmp = jpa.lire(2L);
		tmp.setNationalite("test1");
		jpa.update(2L, tmp);
		res = jpa.lireTous();
		assertEquals(2, res.size());
		assertEquals("test", res.get(1).getNationalite());
		
		// EFFACER
		jpa.effacer(2L);
		res = jpa.lireTous();
		assertEquals(1, res.size());
	}

}
