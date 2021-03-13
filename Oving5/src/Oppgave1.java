public class Oppgave1 {

	public static void main(String[] args) {
		TowersOfHanoi tower1 = new TowersOfHanoi(10);
		TowersOfHanoi tower2 = new TowersOfHanoi(30);
		TowersOfHanoi tower3 = new TowersOfHanoi(31);
		System.out.println("a(100): " + a(100));
		System.out.println("b(1): " + b(1));
		System.out.println("b(2): " + b(2));
		System.out.println("b(3): " + b(3));
		System.out.println("b(4): " + b(4));
		System.out.println("b(5): " + b(5));
		System.out.println("b(6): " + b(6));
		System.out.println("b(7): " + b(7));
		System.out.println("b(8): " + b(8));
		System.out.println("b(9): " + b(9));
		System.out.println("b(10): " + b(10));
		System.out.println("nanoTime: " + System.nanoTime());
		System.out.println("Steg for å løse med 10 brikker: " + tower1.solve());
		System.out.println("nanoTime: " + System.nanoTime());
		System.out.println("Steg for å løse med 30 brikker: " + tower2.solve());
		System.out.println("nanoTime: " + System.nanoTime());
		System.out.println("Steg for å løse med 31 brikker: " + tower3.solve());
		System.out.println("nanoTime: " + System.nanoTime());

	}

	public static int a(int tall) {
		if (tall == 1) {
			return tall;
		}

		int svar = tall + a(tall - 1);

		return svar;
	}

	public static int b(int tall) {
		if (tall == 0) {
			return 2;
		} else if (tall == 1) {
			return 5;
		}

		int svar = 5 * b(tall - 1) - 6 * b(tall - 2) + 2;
		return svar;
	}

	public static int c(int tall) {
		if (tall == 1) {
			return 1;
		}

		int svar = 2 * c(tall - 1) + 1;
		return svar;
	}
}
