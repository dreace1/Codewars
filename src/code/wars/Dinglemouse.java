package code.wars;

import java.util.Arrays;

public class Dinglemouse {

	public static int peakHeight(char[][] mountain) {
		int height = 0;
		char flightPath = '1';
		boolean mountainsLeft = true;
		System.out.println(toString(mountain));

		while (mountainsLeft) {
			height++;
			for (int row = 0; row < mountain.length; row++) {
				for (int col = 0; col < mountain[row].length; col++) {

					if (isTopOrBottom(mountain, row) && isMountain(mountain, row, col)) {
						mountain[row][col] = flightPath;
					} else if (isEdge(mountain, row, col + 1, flightPath) && isMountain(mountain, row, col)) {
						mountain[row][col] = flightPath;
					} else if (isEdge(mountain, row, col - 1, flightPath) && isMountain(mountain, row, col)) {
						mountain[row][col] = flightPath;
					} else if (isEdge(mountain, row + 1, col, flightPath) && isMountain(mountain, row, col)) {
						mountain[row][col] = flightPath;
					} else if (isEdge(mountain, row - 1, col, flightPath) && isMountain(mountain, row, col)) {
						mountain[row][col] = flightPath;
					}

				}
			}
			flightPath++;
			System.out.println(toString(mountain));

			mountainsLeft = mountainsLeft(mountain);

		}





		return 1;
	}

	public static boolean isMountain(char[][] mountain, int row, int col) {
		return mountain[row][col] == '^';
	}

	public static boolean isEdge(char[][] mountain, int row, int col, char flightPath) {
		final boolean checkIfOutOfBounds = row >= 0 && col >= 0 && row < mountain.length && col < mountain[0].length;

		return checkIfOutOfBounds && (mountain[row][col] == ' ' || mountain[row][col] == flightPath);
	}

	public static boolean isTopOrBottom(char[][] mountain, int row) {
		return row == 0 || row == mountain.length - 1;
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
			      "^^^^^^        ".toCharArray(),
			      " ^^^^^^^^     ".toCharArray(),
			      "  ^^^^^^^     ".toCharArray(),
			      "  ^^^^^       ".toCharArray(),
			      "  ^^^^^^^^^^^ ".toCharArray(),
			      "  ^^^^^^      ".toCharArray(),
				"  ^^^^        ".toCharArray() };
		System.out.println(peakHeight(mountain));


	}

	/*
	 * if (row == 0 && isMountain(mountain, row, col)) { height++;
	 * mountain[row][col] = '1'; } else if (isMountain(mountain, row, col) &&
	 * mountain[row - 1][col] != '1') { height++; mountain[row][col] = '1'; } else
	 * if (isMountain(mountain, row, col) && mountain[row][col - 1] == ' ') {
	 * mountain[row][col] = '1';
	 *
	 * }
	 *
	 */

	public static String toString(char[][] mountain) {
		String str = "";
		for (final char[] c : mountain) {
			str += Arrays.toString(c).replace(",", "").replace("[", "").replace("]", "") + "\n";
		}

		return str;
	}
}
