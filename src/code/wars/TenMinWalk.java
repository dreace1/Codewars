package code.wars;


public class TenMinWalk {

	public static boolean isValid(char[] walk) {

		if (walk.length == 10) {
			int northSouth = 0;
			int eastWest = 0;

			for (int i = 0; i < walk.length; i++) {
				if (walk[i] == 'n') {
					northSouth++;
				} else if (walk[i] == 's') {
					northSouth--;
				} else if (walk[i] == 'e') {
					eastWest++;
				} else if (walk[i] == 'w') {
					eastWest--;
				}
			}

			return northSouth == 0 && eastWest == 0;
		}

		return false;
	}

	public static boolean isShortAndValid(char[] walk) {
		return walk.length == 10 && directionsEqualZero('n', 's', walk) && directionsEqualZero('e', 'w', walk);
	}

	public static boolean directionsEqualZero(char direction1, char direction2, char[] walk) {

		int directionCounter = 0;
		for (int i = 0; i < walk.length; i++) {
			if (walk[i] == direction1) {
				directionCounter++;
			} else if (walk[i] == direction2) {
				directionCounter--;
			}
		}
		return directionCounter == 0;
	}
}
