package code.wars;

import java.util.Arrays;

/**
 * <a href="https://www.codewars.com/kata/57680d0128ed87c94f000bfd/train/java">
 * Boggle Word Checker </a>
 *
 * @author rosen
 *
 */
public class Boggle {

	private final char[][] board;
	private final String word;

	public Boggle(final char[][] board, final String word) {
		this.board = board;
		this.word = word;
	}

	public boolean check() {

		for (int row = 0; row < board.length; row++) {
			for (int col = 0; col < board[row].length; col++) {
				if (board[row][col] == word.charAt(0)
						&& containsNeighbors(row, col, 0)) {
					return true;
				}
			}
		}
		return false;
	}

	public boolean containsNeighbors(int row, int col, int currentWordIndex) {
		if (currentWordIndex == word.length()) {
			return true;
		}

		final char currentWordChar = word.charAt(currentWordIndex);

		if (row < 0 || row >= board.length || col < 0 || col >= board[row].length
				|| board[row][col] != currentWordChar) {
			return false;
		}

		showMatrixVisualisation(currentWordChar, row, col);

		board[row][col] = ' ';
		final boolean foundChar = containsNeighbors(row + 1, col, currentWordIndex + 1)
				|| containsNeighbors(row, col + 1, currentWordIndex + 1) || containsNeighbors(row - 1, col, currentWordIndex + 1)
				|| containsNeighbors(row, col - 1, currentWordIndex + 1) || containsNeighbors(row - 1, col + 1, currentWordIndex + 1)
				|| containsNeighbors(row + 1, col - 1, currentWordIndex + 1)
				|| containsNeighbors(row - 1, col - 1, currentWordIndex + 1)
				|| containsNeighbors(row + 1, col + 1, currentWordIndex + 1);

		board[row][col] = currentWordChar;

		return foundChar;

	}

	@Override
	public String toString() {
		String str = "";
		for (final char[] c : board) {
			str += Arrays.toString(c) + "\n";
		}
		return str;
	}

	private void showMatrixVisualisation(char currentWordChar, int row, int col) {

		System.out.println(word);
		System.out.println(this.toString());
		System.out.println(currentWordChar + " row: " + row + " col: " + col + "\n-----------------\n");
		try {
			Thread.sleep(1500);
		} catch (final Exception e) {
			// TODO: handle exception
		}

	}

}
