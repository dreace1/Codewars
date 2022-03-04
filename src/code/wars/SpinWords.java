package code.wars;

/**
 * https://www.codewars.com/kata/5264d2b162488dc400000001/train/java
 *
 * @author rosen
 *
 */
public class SpinWords {

	public static String spinWords(String sentence) {
		final String[] words = sentence.split(" ");
		final StringBuilder wordReversed = new StringBuilder();
		String reversedSentence = "";

		for (int i = 0; i < words.length; i++) {
			if (words[i].length() >= 5) {
				wordReversed.append(words[i]).reverse();
				reversedSentence += wordReversed.toString() + " ";
				wordReversed.delete(0, wordReversed.length());
			} else {
				reversedSentence += words[i] + " ";
			}

		}

		return reversedSentence.trim();
	}

	public static void main(String[] args) {
		System.out.println(spinWords("Welcome"));
		System.out.println(spinWords("Hey fellow warriors"));
	}

}
