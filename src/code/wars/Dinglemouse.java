package code.wars;

import java.util.Arrays;

public class Dinglemouse {

	public static int peakHeight(char[][] mountain) {
		char flightPath = '1';
		int height = 0;
		boolean mountainsLeft = true;
		System.out.println(toString(mountain));

		if (mountain.length == 0 && mountain[0].length == 0) {
			return 0;
		}


		while (mountainsLeft) {

			for (int row = 0; row < mountain.length; row++) {
				for (int col = 0; col < mountain[row].length; col++) {


					if ((isEdge(mountain, row, col + 1, flightPath) && isMountain(mountain, row, col))
							|| (isEdge(mountain, row, col - 1, flightPath) && isMountain(mountain, row, col))
							|| (isEdge(mountain, row + 1, col, flightPath) && isMountain(mountain, row, col))
							|| (isEdge(mountain, row - 1, col, flightPath) && isMountain(mountain, row, col))) {
						mountain[row][col] = flightPath;

					}
				}
			}
			flightPath++;
			height++;
			System.out.println(toString(mountain));

			mountainsLeft = mountainsLeft(mountain);
		}


		return height;
	}

	public static boolean isMountain(char[][] mountain, int row, int col) {
		return mountain[row][col] == '^';
	}

	public static boolean isEdge(char[][] mountain, int row, int col, char flightPath) {
		final boolean checkIfInBounds = row >= 0 && col >= 0 && row < mountain.length && col < mountain[0].length;

		if(!checkIfInBounds) {
			return true;
		}

		if (isTopOrBottom(mountain, row)) {
			return true;
		}

		if (isLeftOrRight(mountain, col)) {
			return true;
		}



		return (flightPath == '1') ? mountain[row][col] == ' ' : mountain[row][col] == flightPath - 1;
	}



	public static boolean isTopOrBottom(char[][] mountain, int row) {
		return row == -1 || row == mountain.length;
	}

	public static boolean isLeftOrRight(char[][] mountain, int col) {
		return col == -1 || col == mountain[0].length;
	}

	public static boolean mountainsLeft(char[][] mountain) {

		for (int row = 0; row < mountain.length; row++) {
			for (int col = 0; col < mountain[row].length; col++) {
				if (isMountain(mountain, row, col)) {
					return true;
				}
			}
		}

		return false;
	}


	public static void main(String[] args) {
		final char[][] mountain = {
				"^^^^^^^^^^^^^^^^^^^^^".toCharArray(), "^^^^^^^^^^^^^^^^^^^^^".toCharArray(),
				"^^^^^^^^^^^^^^^^^^^^^".toCharArray(), "^^^^^^^^^^^^^^^^^^^^^".toCharArray(),
				"^^^^^^^^^^^^^^^^^^^^^".toCharArray(), "^^^^^^^^^^^^^^^^^^^^^".toCharArray(),
				"^^^^^^^^^^^^^^^^^^^^^".toCharArray(), "^^^^^^^^^^^^^^^^^^^^^".toCharArray(),
				"^^^^^^^^^^^^^^^^^^^^^".toCharArray(), "^^^^^^^^^^^^^^^^^^^^^".toCharArray(),
				"^^^^^^^^^^^^^^^^^^^^^".toCharArray(), "^^^^^^^^^^^^^^^^^^^^^".toCharArray(),
				"^^^^^^^^^^^^^^^^^^^^^".toCharArray(), "^^^^^^^^^^^^^^^^^^^^^".toCharArray(),
				"^^^^^^^^^^^^^^^^^^^^^".toCharArray(), "^^^^^^^^^^^^^^^^^^^^^".toCharArray(),
				"^^^^^^^^^^^^^^^^^^^^^".toCharArray(), "^^^^^^^^^^^^^^^^^^^^^".toCharArray(),
				"^^^^^^^^^^^^^^^^^^^^^".toCharArray(), "^^^^^^^^^^^^^^^^^^^^^".toCharArray(),
				"^^^^^^^^^^^^^^^^^^^^^".toCharArray(),

		};
		System.out.println(peakHeight(mountain));

	}



	public static String toString(char[][] mountain) {
		String str = "";
		for (final char[] c : mountain) {
			str += Arrays.toString(c).replace(",", "").replace("[", "").replace("]", "") + "\n";
		}

		return str;
	}
}
