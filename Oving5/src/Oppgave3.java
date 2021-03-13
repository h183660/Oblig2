
public class Oppgave3 {

	public static void main(String[] args) {
		int[] tab = { 2, 4, 5, 7, 8, 10, 12, 15, 18, 21, 23, 27, 29, 30, 31 };
		System.out.println("b, søk etter tallet 8: " + binaerSoek(tab, 0, tab.length - 1, 8));
		System.out.println("c, søk etter tallet 16: " + binaerSoek(tab, 0, tab.length - 1, 16));
	}

	public static int binaerSoek(int[] tab, int min, int max, int soek) {
		int midtpunkt = (min + max) / 2;
		System.out.println(tab[midtpunkt]);
		if (tab[midtpunkt] == soek) {
			return midtpunkt;
		} else if (tab[midtpunkt] > soek) {
			if (min <= midtpunkt - 1) {
				return binaerSoek(tab, min, midtpunkt - 1, soek);
			}
		} else if (tab[midtpunkt] < soek) {
			return binaerSoek(tab, midtpunkt + 1, max, soek);
		}
		return -1;
	}

}
