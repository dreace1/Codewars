package code.wars;

import java.util.HashMap;
import java.util.Map;

public class PangramChecker {
	public boolean check(String sentence) {

		final Map<Character, Boolean> alphabetMap = createAlphabetMap();
		final String sentenceLowerCase = sentence.toLowerCase();

		for (int i = 0; i < sentenceLowerCase.length(); i++) {
			if (sentenceLowerCase.charAt(i) >= 'a' && sentenceLowerCase.charAt(i) <= 'z') {
				alphabetMap.put(sentenceLowerCase.charAt(i), true);
			}
		}

		return containsEveryAlphabeticChar(alphabetMap);
	}

	public Map<Character, Boolean> createAlphabetMap() {
		final Map<Character, Boolean> alphabetMap = new HashMap<>();
		for (Character ch = 'a'; ch <= 'z'; ch++) {
			alphabetMap.put(ch, false);
		}

		return alphabetMap;
	}

	public boolean containsEveryAlphabeticChar(Map<Character, Boolean> alphabetMap) {
		for (final Map.Entry<Character, Boolean> entry : alphabetMap.entrySet()) {
			if (entry.getValue() == false) {
				return false;
			}
		}
		return true;
	}
}