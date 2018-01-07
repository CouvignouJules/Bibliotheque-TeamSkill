package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

import fr.ynov.biblioskill.metier.entities.Personne;
import fr.ynov.biblioskill.service.DaoPersonne;

class DaoPersonneTests {
	private DaoPersonne jpa;

	public DaoPersonneTests() {
		jpa = new DaoPersonne();
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
		List<Personne> res = null;
		res = jpa.lireTous();
		assertEquals(1, res.size());
		
		// INSERER
		Personne tmp = new Personne(2L, "test", null, null, null, null, null);
		jpa.inserer(tmp);
		res = jpa.lireTous();
		assertEquals(2, res.size());
		
		// UPDATE
		tmp = jpa.lire(2L);
		tmp.setNom("test1");
		jpa.update(2L, tmp);
		res = jpa.lireTous();
		assertEquals(2, res.size());
		assertEquals("test1", res.get(1).getNom());
		
		// EFFACER
		jpa.effacer(2L);
		res = jpa.lireTous();
		assertEquals(1, res.size());
	}

}
