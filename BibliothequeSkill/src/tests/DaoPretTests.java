package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

import fr.ynov.biblioskill.metier.entities.Pret;
import fr.ynov.biblioskill.service.DaoPret;

class DaoPretTests {
	private DaoPret jpa;

	public DaoPretTests() {
		jpa = new DaoPret();
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
		List<Pret> res = null;
		res = jpa.lireTous();
		assertEquals(1, res.size());
		
		// INSERER
		Pret tmp = new Pret(2L, null, 0);
		jpa.inserer(tmp);
		res = jpa.lireTous();
		assertEquals(2, res.size());
		
		// EFFACER
		jpa.effacer(2L);
		res = jpa.lireTous();
		assertEquals(1, res.size());
	}

}
