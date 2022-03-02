package code.wars;

import java.util.Arrays;

/**
 * https://www.codewars.com/kata/5c2fd9188e358f301f5f7a7b/train/java
 *
 * @author rosen
 *
 */
public class BirdByTheRiver {
	static char[][] modTerrain;
	static int currentHeight;

	public static int[] dryGround(char[][] terrain) {

		modTerrain = checkTerrain(terrain);
		final int[] numberOfLandingSpots = new int[currentHeight + 1];
		final char height = Character.forDigit(currentHeight, 10);
		char flooding = '1';

		System.out.println(height);
		System.out.println(toString(modTerrain));

		while (!everythingFlooded(terrain)) {
			for (int row = 0; row < terrain.length; row++) {
				for (int col = 0; col < terrain[row].length; col++) {
					if (getsFlooded(terrain, row, col, flooding)) {
						modTerrain[row][col] = '-';
					}
				}
			}
			flooding++;
			System.out.println(toString(modTerrain));
			System.out.println(flooding);

		}




		return new int[] { 0, 0, 0, 0 };

	}

	public static boolean everythingFlooded(char[][] terrain) {
		for (int row = 0; row < terrain.length; row++) {
			for (int col = 0; col < terrain[row].length; col++) {
				if (terrain[row][col] != '-') {
					return false;
				}
			}
		}

		return true;
	}


	public static boolean checkIfinBounds(char[][] terrain, int row, int col) {
		return row >= 0 && col >= 0 && row < terrain.length && col < terrain[0].length;
	}

	public static boolean getsFlooded(char[][] terrain, int row, int col, char flooding) {
		return (flooding == '1') ? terrain[row][col] == ' ' : terrain[row][col] == flooding - 1;
	}

	public static int countLandingSpots(char[][] terrain) {
		return 0;
	}

	public static char[][] checkTerrain(char[][] terrain) {
		char flightPath = '1';
		int height = 0;
		boolean mountainsRemaining = montainsRemaining(terrain);

		while (mountainsRemaining) {

			for (int row = 0; row < terrain.length; row++) {
				for (int col = 0; col < terrain[row].length; col++) {

					if ((isEdge(terrain, row, col + 1, flightPath) && isMountain(terrain, row, col))
							|| (isEdge(terrain, row, col - 1, flightPath) && isMountain(terrain, row, col))
							|| (isEdge(terrain, row + 1, col, flightPath) && isMountain(terrain, row, col))
							|| (isEdge(terrain, row - 1, col, flightPath) && isMountain(terrain, row, col))) {
						terrain[row][col] = flightPath;
					}
				}
			}
			flightPath++;
			height++;

			mountainsRemaining = montainsRemaining(terrain);
		}

		currentHeight = height;

		return terrain;
	}

	public static boolean isMountain(char[][] mountain, int row, int col) {
		return mountain[row][col] == '^';
	}

	public static boolean isEdge(char[][] mountain, int row, int col, char flightPath) {
		final boolean checkIfInBounds = row >= 0 && col >= 0 && row < mountain.length && col < mountain[0].length;

		if (!checkIfInBounds) {
			return true;
		}

		if (isTopOrBottom(mountain, row)) {
			return true;
		}

		if (isLeftOrRight(mountain, col)) {
			return true;
		}

		return (flightPath == '1') ? mountain[row][col] == ' ' || mountain[row][col] == '-'
				: mountain[row][col] == flightPath - 1 || mountain[row][col] == '-';
	}

	public static boolean isTopOrBottom(char[][] mountain, int row) {
		return row == -1 || row == mountain.length;
	}

	public static boolean isLeftOrRight(char[][] mountain, int col) {
		return col == -1 || col == mountain[0].length;
	}

	public static boolean montainsRemaining(char[][] mountain) {

		for (int row = 0; row < mountain.length; row++) {
			for (int col = 0; col < mountain[row].length; col++) {
				if (isMountain(mountain, row, col)) {
					return true;
				}
			}
		}
		return false;
	}

	public static String toString(char[][] mountain) {
		String str = "";
		for (final char[] c : mountain) {
			str += Arrays.toString(c).replace(",", "").replace("[", "").replace("]", "") + "\n";
		}

		return str;
	}

	public static void main(String[] args) {
		final char[][] terrain = { "  ^^^^^^             ".toCharArray(), "^^^^^^^^       ^^^   ".toCharArray(),
				"^^^^^^^  ^^^         ".toCharArray(), "^^^^^^^  ^^^         ".toCharArray(),
				"^^^^^^^  ^^^         ".toCharArray(), "---------------------".toCharArray(),
				"^^^^^                ".toCharArray(), "   ^^^^^^^^  ^^^^^^^ ".toCharArray(),
				"^^^^^^^^     ^     ^ ".toCharArray(), "^^^^^        ^^^^^^^ ".toCharArray() };

		dryGround(terrain);
	}

}
