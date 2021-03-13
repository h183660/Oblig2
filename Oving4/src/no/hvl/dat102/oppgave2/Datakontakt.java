package no.hvl.dat102.oppgave2;

import no.hvl.dat102.exception.EmptyCollectionException;

public class Datakontakt {
	int antallMedlemmer;
	Medlem[] medlemsTab = new Medlem[10];

	public void leggTilMedlem(Medlem person) {
		if (antallMedlemmer == medlemsTab.length) {
			utvidKapasitet();
		}

		medlemsTab[antallMedlemmer++] = person;
		medlemsTab = trimTab(medlemsTab, antallMedlemmer);
	}

	public int getAntall() {
		return antallMedlemmer;
	}

	public int finnMedlemsIndeks(String medlemsnavn) {
		if (antallMedlemmer == 0) {
			throw new EmptyCollectionException("Datakontakt");
		}
		for (int i = 0; i < antallMedlemmer; i++)
			if (medlemsTab[i].getNavn().equals(medlemsnavn)) {
				return i;
			}
		return -1;
	}

	public Medlem[] hentMedlemsTabell() {
		return medlemsTab;
	}

	// Algoritme for å finne en passende partner til et medlem
	public int finnPartnerFor(String medlemsnavn) {
		if (antallMedlemmer == 0) {
			throw new EmptyCollectionException("Datakontakt");
		}
		int medlemsIndeks = finnMedlemsIndeks(medlemsnavn);

		if (medlemsIndeks == -1) {
			System.out.println("Medlem eksisterer ikke.");
			return -1;
		}

		for (int i = 0; i < medlemsTab.length; i++) {
			if (medlemsTab[medlemsIndeks].passerTil(medlemsTab[i]) && medlemsTab[i].getstatusIndeks() == -1 && !medlemsTab[medlemsIndeks].equals(medlemsTab[i])) {
				medlemsTab[medlemsIndeks].setStatusIndeks(i);
				medlemsTab[i].setStatusIndeks(medlemsIndeks);
				return i;
			}
		}

		System.out.println("Kompatibel partner ikke funnet.");
		return -1;
	}

	// Tilbakestiller statusindeksen til -1.
	public void tilbakestillStausIndeks(String medlemsnavn) {
		if (antallMedlemmer == 0) {
			throw new EmptyCollectionException("Datakontakt");
		}
		int medlemsIndeks = finnMedlemsIndeks(medlemsnavn);
		int partnerMedlemsIndeks = medlemsTab[medlemsIndeks].getstatusIndeks();

		if (medlemsIndeks == -1) {
			System.out.println("Medlem eksisterer ikke.");
		} else {
			if (partnerMedlemsIndeks == -1) {
				System.out.println("Medlem er ikke koblet til et annet medlem.");
			} else {
				medlemsTab[medlemsIndeks].setStatusIndeks(-1);
				medlemsTab[partnerMedlemsIndeks].setStatusIndeks(-1);
			}
		}

	}

	// Korter ned tabellen sann det ikke er plass til overs.
	private Medlem[] trimTab(Medlem[] tab, int n) {
		Medlem[] medlemTab2 = new Medlem[n];
		int i = 0;
		while (i < n) {
			medlemTab2[i] = tab[i];
			i++;
		}
		return medlemTab2;
	}

	// Utvider tabellen.
	private void utvidKapasitet() {
		Medlem[] hjelpetabell = new Medlem[2 * antallMedlemmer];

		for (int i = 0; i < antallMedlemmer; i++) {
			hjelpetabell[i] = medlemsTab[i];
		}
		medlemsTab = hjelpetabell;
	}

	// Skriver ut hvert medlem i tabellen.
	public void skrivUt() {
		if (antallMedlemmer == 0) {
			throw new EmptyCollectionException("Datakontakt");
		}
		for (Medlem medlem : medlemsTab) {
			System.out.println(medlem.toString());
		}
	}
}
