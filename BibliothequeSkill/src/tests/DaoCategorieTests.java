package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

import fr.ynov.biblioskill.metier.entities.Categorie;
import fr.ynov.biblioskill.service.DaoCategorie;

class DaoCategorieTests {
	private DaoCategorie jpa;

	public DaoCategorieTests() {
		jpa = new DaoCategorie();
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
		List<Categorie> res = null;
		res = jpa.lireTous();
		assertEquals(1, res.size());
		
		// INSERER
		Categorie tmp = new Categorie(2L, "test", "test");
		jpa.inserer(tmp);
		res = jpa.lireTous();
		assertEquals(2, res.size());
		
		// UPDATE
		tmp = jpa.lire(2L);
		tmp.setDescription("test1");
		jpa.update(2L, tmp);
		res = jpa.lireTous();
		assertEquals(2, res.size());
		assertEquals("test1", res.get(1).getDescription());
		
		// EFFACER
		jpa.effacer(2L);
		res = jpa.lireTous();
		assertEquals(1, res.size());
	}

}
