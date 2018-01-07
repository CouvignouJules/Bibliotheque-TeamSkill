package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

import fr.ynov.biblioskill.metier.entities.Livre;
import fr.ynov.biblioskill.service.DaoLivre;

class DaoLivreTests {
	private DaoLivre jpa;

	public DaoLivreTests() {
		jpa = new DaoLivre();
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
		List<Livre> res = null;
		res = jpa.lireTous();
		assertEquals(1, res.size());
		
		// INSERER
		Livre tmp = new Livre(2L, "test", "test", 0, null, null, null);
		jpa.inserer(tmp);
		res = jpa.lireTous();
		assertEquals(2, res.size());
		
		// UPDATE
		tmp = jpa.lire(2L);
		tmp.setPhoto("test1");
		jpa.update(2L, tmp);
		res = jpa.lireTous();
		assertEquals(2, res.size());
		assertEquals("test1", res.get(1).getPhoto());
		
		// EFFACER
		jpa.effacer(2L);
		res = jpa.lireTous();
		assertEquals(1, res.size());
	}

}
