import java.util.Random;

public class Oppgave4 {

	public static void main(String[] args) {
//		// Skjekker at metodene funket med en liten tabell.
//		Integer[] tab = { 5, 12, -63, 32, 12, -84, 26, 1, 66, 32 };
//
//		System.out.println("Usortert: ");
//		for (Integer tall : tab) {
//			System.out.print(tall + ",");
//		}
//
//		kvikkSortNy(tab);
//
//		System.out.println("\nSortert: ");
//		for (Integer tall : tab) {
//			System.out.print(tall + ",");
//		}
//		System.out.println();
//
		// Oppgave 4a
		Random tilfeldig = new Random();
		int n = 32000;
		int antal = 10;
		Integer[][] a = new Integer[antal][n];
		// set inn tilfeldige heiltal i alle rekker
		for (int i = 0; i < antal; i++) {
			for (int j = 0; j < n; j++) {
				a[i][j] = tilfeldig.nextInt();
			}
		}
		
		System.out.println(System.nanoTime());
		for (int i = 0; i < antal; i++) {
			utvalgssortering(a[i]); // blir ein eindimensjonal tabell
		}
		System.out.println(System.nanoTime());

//		// Oppgave 4b
//		Random tilfeldig = new Random();
//		int n = 32000;
//		int antal = 100;
//		Integer[][] a = new Integer[antal][n];
//		// set inn tilfeldige heiltal i alle rekker
//		for (int i = 0; i < antal; i++) {
//			for (int j = 0; j < n; j++) {
//				a[i][j] = tilfeldig.nextInt();
//			}
//		}
//		System.out.println(System.nanoTime());
//		for (int i = 0; i < antal; i++) {
//			kvikkSortNy(a[i]); // blir ein eindimensjonal tabell
//		}
//		System.out.println(System.nanoTime());
//
//		// Oppgave 4c
//		int n = 20000;
//		int antal = 10;
//		Integer[][] a = new Integer[antal][n];
//		// set inn tilfeldige heiltal i alle rekker
//		for (int i = 0; i < antal; i++) {
//			for (int j = 0; j < n; j++) {
//				a[i][j] = 34;
//			}
//		}
//		
//		System.out.println(System.nanoTime());
//		for (int i = 0; i < antal; i++) {
//			quickSort(a[i]); // blir ein eindimensjonal tabell
//		}
//		System.out.println(System.nanoTime());

	}

	public static <T extends Comparable<T>> void kvikkSortNy(T[] data) {
		kvikkSortNy(data, 0, data.length - 1);
		sorteringVedInsetting(data);
	}

	public static <T extends Comparable<T>> void kvikkSortNy(T[] data, int min, int maks) {
		final int MIN = 1000;
		int posPartisjon;
		if (maks - min + 1 > MIN) {// antall elementer > MIN ?
			posPartisjon = finnPartisjon(data, min, maks);
			kvikkSortNy(data, min, posPartisjon - 1);
			kvikkSortNy(data, posPartisjon + 1, maks);
		}
	}// metode

	public static <T extends Comparable<T>> void quickSort(T[] data) {
		quickSort(data, 0, data.length - 1);
	}

	public static <T extends Comparable<T>> void quickSort(T[] data, int min, int maks) {
		if (min < maks) {
			int indexofpartition = finnPartisjon(data, min, maks);
			quickSort(data, min, indexofpartition - 1);
			quickSort(data, indexofpartition + 1, maks);
		}
	}

	public static <T extends Comparable<T>> void mergeSort(T[] data) {
		mergeSort(data, 0, data.length - 1);
	}

	public static <T extends Comparable<T>> void mergeSort(T[] data, int min, int maks) {
		if (min < maks) {
			int mid = (min + maks) / 2;
			mergeSort(data, min, mid);
			mergeSort(data, mid + 1, maks);
			merge(data, min, mid, maks);
		}
	}

	@SuppressWarnings("unchecked")
	public static <T extends Comparable<T>> void merge(T[] data, int first, int mid, int last) {
		T[] temp = (T[]) (new Comparable[data.length]);

		int first1 = first, last1 = mid;
		int first2 = mid + 1, last2 = last;
		int index = first1;

		while (first1 <= last1 && first2 <= last2) {
			if (data[first1].compareTo(data[first2]) < 0) {
				temp[index] = data[first1];
				first1++;
			} else {
				temp[index] = data[first2];
				first2++;
			}
			index++;
		}
		while (first1 <= last1) {
			temp[index] = data[first1];
			first1++;
			index++;
		}
		while (first2 <= last2) {
			temp[index] = data[first2];
			first2++;
			index++;
		}
		for (index = first; index <= last; index++) {
			data[index] = temp[index];
		}
	}

	// full tabell
	public static <T extends Comparable<T>> void utvalgssortering(T[] data) {
		int minste;
		T temp;

		for (int neste = 0; neste < data.length - 1; neste++) {
			minste = neste;
			for (int sok = neste + 1; sok < data.length; sok++) {

				if (data[sok].compareTo(data[minste]) < 0) {
					minste = sok;
				}

			} /** Bytt verdiene */
			temp = data[minste];
			data[minste] = data[neste];
			data[neste] = temp;
		} // ytre
	}// metode

	public static <T extends Comparable<T>> void bobleSort(T[] data) {

		T temp;

		for (int p = data.length - 1; p >= 0; p--) {
			for (int sok = 0; sok <= p - 1; sok++) {
				if (data[sok].compareTo(data[sok + 1]) > 0) {
					// Bytt verdiene
					temp = data[sok];
					data[sok] = data[sok + 1];
					data[sok + 1] = temp;
				}
			} // indre løkke
		} // ytre løkke
	}// metode

	public static <T extends Comparable<T>> void sorteringVedInsetting(T[] data) {

		for (int indeks = 1; indeks < data.length; indeks++) {

			T nokkel = data[indeks];
			int p = indeks;
			// Forskyv større verdier mot hoyre
			while (p > 0 && nokkel.compareTo(data[p - 1]) < 0) {
				data[p] = data[p - 1];
				p--;
			}
			data[p] = nokkel;
		} // ytre

	}// metode

	public static <T extends Comparable<T>> int finnPartisjon(T[] data, int min, int maks) {
		T partitionelement;
		int left, right;
		int middle = (min + maks) / 2;

		partitionelement = data[middle];
		swap(data, middle, min);
		left = min;
		right = maks;
		while (left < right) {
			while (left < right && data[left].compareTo(partitionelement) <= 0) {
				left++;
			}
			while (data[right].compareTo(partitionelement) > 0) {
				right--;
			}
			if (left < right) {
				swap(data, left, right);
			}
		}
		swap(data, min, right);
		return right;
	}

	public static <T extends Comparable<T>> void swap(T[] data, int index1, int index2) {
		T temp = data[index1];
		data[index1] = data[index2];
		data[index2] = temp;
	}
}
