package no.hvl.dat102.oppgave2;

import java.util.Scanner;

public class Tekstgrensenitt {
	// Klasse for inn/ut terminal
	// Hvis du vil lage meny kan du også legge det inn i Tekstgrensesnitt

	// leser opplysningene om et medlem fra tastatur
	public static Medlem lesMedlem() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Hva er navnet på medlemmet?");
		String navn = scan.nextLine();
		Medlem medlem = new Medlem(navn);
		System.out.println("Medlem Lest");
		return medlem;
	}

	public static void start() {
		Scanner scan = new Scanner(System.in);
		boolean run = true;
		Datakontakt medlemer = new Datakontakt();
		do {

			System.out.println("-------------------");
			System.out.println("|Hva vil du gjøre?|");
			System.out.println("-------------------");

			System.out.println("1: Legge til et nytt medlem.");
			System.out.println("2: Legg en hobby til et medlem.");
			System.out.println("3: Skriv ut et medlem sin hobbyliste.");
			System.out.println("4: Finne en partner til et medlem.");
			System.out.println("5: Skriv ut en liste over alle par.");
			System.out.println("6: Skriv ut alle medlemer.");
			System.out.println("7: Tilbakestill et medlem sin statusindeks.");
			System.out.println("0: Exit.");

			int valg = scan.nextInt();
			switch (valg) {
			case 1:
				System.out.println("Legger til et nytt medlem:");
				medlemer.leggTilMedlem(lesMedlem());
				break;

			case 2:
				System.out.println("Legger en hobby til et medlem:");
				MedlemKlient.klientLeggTilHobby(getMedlem(medlemer));
				break;

			case 3:
				System.out.println("Skriver ut et medlem sin hobbyliste:");
				skrivHobbyListe(getMedlem(medlemer));
				break;

			case 4:
				System.out.println("Finner en partner til et medlem.");
				medlemer.finnPartnerFor(getMedlem(medlemer).getNavn());
				break;

			case 5:
				System.out.println("Skrive ut en liste over alle par.");
				skrivParListe(medlemer);
				break;
			case 6:
				System.out.println("Skriver ut alle medlemmer.");
				medlemer.skrivUt();
				break;
			case 7:
				System.out.println("Tilbakestiller Statusindeks.");
				medlemer.tilbakestillStausIndeks(getMedlem(medlemer).getNavn());
				break;

			case 0:
				System.out.println("Closing program");
				run = false;
				break;

			default:
				System.out.println("Ukjent komando prøv igjen.");
			}
		} while (run);
		scan.close();
	}

	// Skriver ut hobbylisten for et medlem
	public static void skrivHobbyListe(Medlem medlem) {
		System.out.println("Alle hobbyene ");
		System.out.println(medlem.getHobbyer().toString());
	}

	public static void skrivParListe(Datakontakt arkiv) {
		int antallParFunnet = 0;
		/*
		 * skriver ut på skjermen en oversikt over medlemmer som er koblet til hverandre
		 * i medlemstabellen til enhver tid. Et slikt par skal kun vises én gang på
		 * utskriftlisten. Metoden skriver også ut antall par som er funnet
		 */
		Medlem[] tab = arkiv.hentMedlemsTabell();
		for (int i = 0; i < arkiv.antallMedlemmer; i++) {
			if (tab[i].getstatusIndeks() != -1 && i < tab[i].getstatusIndeks()) {
				antallParFunnet++;
				System.out.println(tab[i].getNavn() + " er i par med " + tab[tab[i].getstatusIndeks()].getNavn());
			}
		}
		System.out.println("Antall par funnet: " + antallParFunnet);
	}

	public static Medlem getMedlem(Datakontakt arkiv) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Hva er navnet på medlemmet?");
		String navn = scan.nextLine();
		int indeks = arkiv.finnMedlemsIndeks(navn);
		Medlem[] tab = arkiv.hentMedlemsTabell();
		return tab[indeks];
	}
}