package no.hvl.dat102;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import no.hvl.dat102.mengde.adt.MengdeADT;
import no.hvl.dat102.mengde.kjedet.KjedetMengde;
import no.hvl.dat102.mengde.tabell.TabellMengde;

class FellesElementerTest {

	// Bytte Mellom KjedetMengde og TabellMengde
	MengdeADT<Integer> m1 = new KjedetMengde<>();
	MengdeADT<Integer> m2 = new KjedetMengde<>();
	MengdeADT<Integer> m3 = new KjedetMengde<>();

	/**
	 * Legger til elementer før hver test
	 */
	@BeforeEach
	public void setup() {
		m1.leggTil(1);
		m1.leggTil(2);
		m1.leggTil(3);
		m1.leggTil(4);
		m1.leggTil(5);

		m2.leggTil(1);
		m2.leggTil(2);
		m2.leggTil(3);
		m2.leggTil(4);
		m2.leggTil(5);
	}

	/**
	 * Tester at m1 er lit m2.
	 */
	@Test
	public void equalsTest() {
		assertTrue(m1.equals(m2));
	}

	/**
	 * Tester union
	 */
	@Test
	public void unionTest() {
		assertEquals(m1.union(m2), m1);
	}

	/**
	 * Tester snitt
	 */
	@Test
	public void snittTest() {
		assertEquals(m1.snitt(m2), m1);
	}

	/**
	 * Tester differanse
	 */
	@Test
	public void differensTest() {
		assertEquals(m1.differens(m2), m3);
	}

	/**
	 * Tester undermengde
	 */
	@Test
	public void undermengdeTest() {
		assertTrue(m1.undermengde(m2));
	}
}
