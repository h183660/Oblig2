
public class Oppgave2 {

	public static void main(String[] args) {
		DobbelKjedetListe<Integer> liste =
		new DobbelKjedetListe<Integer>(-1, 100000);

		liste.visListe();

		liste.leggTil(8);
		liste.leggTil(3);
		liste.leggTil(20);
		liste.leggTil(8);
		liste.leggTil(20);
		System.out.println(liste.fins(20));

		liste.leggTil(2);
		System.out.println(liste.fins(2));

		liste.visListe();
		liste.fjern(2);
		System.out.println(!liste.fins(2));

		liste.visListe();
	}

}
