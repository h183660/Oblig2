package no.hvl.dat102;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import no.hvl.dat102.mengde.adt.MengdeADT;
import no.hvl.dat102.mengde.kjedet.KjedetMengde;
import no.hvl.dat102.mengde.tabell.TabellMengde;

class IkkeFellesElementerTest {

	MengdeADT<Integer> m1 = new KjedetMengde<>();
	MengdeADT<Integer> m2 = new KjedetMengde<>();
	MengdeADT<Integer> m3 = new KjedetMengde<>();
	MengdeADT<Integer> m4 = new KjedetMengde<>();

	/**
	 * Lager et nytt filmarkiv for hver test.
	 * 
	 * @return
	 */
	@BeforeEach
	public void setup() {
		m1.leggTil(1);
		m1.leggTil(2);
		m1.leggTil(3);
		m1.leggTil(4);
		m1.leggTil(5);

		m2.leggTil(6);
		m2.leggTil(7);
		m2.leggTil(8);
		m2.leggTil(9);
		m2.leggTil(10);

		m3.leggTil(1);
		m3.leggTil(2);
		m3.leggTil(3);
		m3.leggTil(4);
		m3.leggTil(5);
		m3.leggTil(6);
		m3.leggTil(7);
		m3.leggTil(8);
		m3.leggTil(9);
		m3.leggTil(10);
	}

	/**
	 * Tester at m1 er ulik m2.
	 */
	@Test
	public void equalsTest() {
		assertFalse(m1.equals(m2));
	}

	/**
	 * Tester union
	 */
	@Test
	public void unionTest() {
		assertEquals(m1.union(m2), m3);
	}

	/**
	 * Tester snitt
	 */
	@Test
	public void snittTest() {
		assertEquals(m1.snitt(m2), m4);
	}

	/**
	 * Tester differens
	 */
	@Test
	public void differensTest() {
		assertEquals(m1.differens(m2), m1);
	}

}
