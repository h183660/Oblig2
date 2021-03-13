
public class TowersOfHanoi {
	private int totalDisks;
	private int flyttinger = 0;

	public TowersOfHanoi(int disks) {
		totalDisks = disks;
	}

	public int solve() {
		return moveTower(totalDisks, 1, 3, 2);
	}

	private int moveTower(int numDisks, int start, int end, int temp) {

		if (numDisks == 1) {
			flyttinger++;
		} else {
			moveTower(numDisks - 1, start, temp, end);
			flyttinger++;
			moveTower(numDisks - 1, temp, end, start);
		}
		return flyttinger;
	}

	// Unødvendig etter endringer.
	private void moveOneDisk(int start, int end) {
		System.out.println("Move one disc from " + start + " to " + end);
	}
}
