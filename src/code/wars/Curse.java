package code.wars;

import java.util.Arrays;

public class Curse {

	public static String translate(String speech, String[] vocabulary) {

		final String[] speechArray = speech.split("[^a-z*]");
		System.out.println("array: " + Arrays.toString(speechArray));

		for (int i = 0; i < speechArray.length; i++) {
			System.out.println("replace: " + speechArray[i]);
			System.out.println("decode: " + decodeWord(speechArray[i], vocabulary));
			speech = speech.replace(speechArray[i], decodeWord(speechArray[i], vocabulary));

		}

		return speech;
	}

	public static String decodeWord(String wordToDecode, String[] vocabulary) {

		wordToDecode = wordToDecode.replaceAll("[^a-z]", ".");
		// System.out.println(wordToDecode);

		for (final String word : vocabulary) {
			if (word.matches(wordToDecode)) {
				// System.out.println(word);
				return word;
			}
		}
		return "";
	}

	public static void main(String[] args) {
		final String result = "qow qqqovq qpqq ooqqu oqqqy ptqqq. sqopq. qropoo, qpx";
		final String sp = "*ow ****v* **** ****u oq**y *t***. s*opq. qro***, q*x";
		final String[] voc = new String[] { "ooqqu", "ptqqq", "qqqovq", "qpqq", "qpx", "oqqqy", "qropoo", "sqopq",
				"qow" };
		System.out.println(translate(sp, voc));
	}
}
