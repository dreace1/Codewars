package code.wars;

import java.util.Arrays;

/**
 * https://www.codewars.com/kata/6138ee916cb50f00227648d9/train/java
 *
 * @author rosen
 *
 */
public class Jousting {
	public static String[] joust(String[] listField, int vKnightLeft, int vKnightRight) {
		if (getJoustingIndexLeft(listField[0]) == getJoustingIndexRight(listField[1])
				|| getJoustingIndexLeft(listField[0]) > getJoustingIndexRight(listField[1])
				|| vKnightLeft == 0 && vKnightRight == 0) {
			System.out.println(Arrays.toString(listField));

			return listField;
		}

		System.out.println("length: " + listField[0].length() + " leftV: " + vKnightLeft + " rightV: " + vKnightRight);
		System.out.println("|" + listField[0] + "|" + "\n");
		System.out.println("|" + listField[1] + "|" + "\n\n");
		while (getJoustingIndexLeft(listField[0]) < getJoustingIndexRight(listField[1])) {
			listField[0] = addStepsLeft(listField[0], vKnightLeft);
			listField[1] = addStepsRight(listField[1], vKnightRight);
			System.out.println("|" + listField[0] + "|" + "\n");
			System.out.println("|" + listField[1] + "|" + "\n\n");

		}


		return listField;

	}

	public static void main(String[] args) {
		joust(new String[] { "$->              ", "              <-P" }, 1, 1);
	}

	public static int getJoustingIndexLeft(String leftKnight) {
		return leftKnight.indexOf('>');
	}

	public static int getJoustingIndexRight(String rightKnight) {
		return rightKnight.indexOf('<');
	}

	public static String addStepsLeft(String knight, int vKnight) {
		final StringBuilder steps = new StringBuilder();

		for (int i = 0; i < vKnight; i++) {
			steps.append(' ');
		}

		steps.append(knight);
		steps.delete(steps.length() - vKnight, steps.length());
		return steps.toString();
	}

	public static String addStepsRight(String knight, int vKnight) {
		final StringBuilder steps = new StringBuilder(knight);

		for (int i = 0; i < vKnight; i++) {
			steps.append(' ');
		}

		steps.delete(0, vKnight);
		return steps.toString();
	}

}

