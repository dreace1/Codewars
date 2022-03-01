package code.wars;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

/**
 * https://www.codewars.com/kata/55c45be3b2079eccff00010f/train/java
 *
 * @author rosen
 *
 */
public class Order {
	public static String order(String words) {
		if (words.length() == 0) {
			return "";
		}

		final List<Character> numbers = initializeArrayListWithNumbersOneToNine();

		final StringBuilder wordInOrder = new StringBuilder();
		final StringTokenizer stringTokens = new StringTokenizer(words);
		final String[] wordArray = new String[stringTokens.countTokens()];
		String tmp = "";

		while (stringTokens.hasMoreTokens()) {
			tmp = stringTokens.nextToken();
			for (int i = 0; i < tmp.length(); i++) {
				if (numbers.contains(tmp.charAt(i))) {
					wordArray[numbers.indexOf(tmp.charAt(i))] = tmp;
				}
			}
		}

		for (final String string : wordArray) {
			wordInOrder.append(string + " ");
		}

		return wordInOrder.toString().trim();

	}

	public static ArrayList<Character> initializeArrayListWithNumbersOneToNine() {
		return new ArrayList<>(Arrays.asList('1', '2', '3', '4', '5', '6', '7', '8', '9'));
	}

	public static void main(String[] args) {
		order("is2 Thi1s T4est 3a");
	}

}
