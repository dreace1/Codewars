package code.wars;

import java.util.ArrayList;
import java.util.List;

/**
 * https://www.codewars.com/kata/56743fd3a12043ffbb000049/train/java
 *
 * @author rosen
 *
 */

public class Robota {
	private final List<String> learnedWords = new ArrayList<String>();

	public Robota() {
		learnedWords.add("thank");
		learnedWords.add("you");
		learnedWords.add("for");
		learnedWords.add("teaching");
		learnedWords.add("me");
		learnedWords.add("i");
		learnedWords.add("do");
		learnedWords.add("not");
		learnedWords.add("understand");
		learnedWords.add("the");
		learnedWords.add("already");
		learnedWords.add("know");
		learnedWords.add("word");
		learnedWords.add("input");
	}

	public String learnWord(String word) {
		String output = "";
		final String lowerCaseWord = word.toLowerCase();

		if (learnedWords.contains(lowerCaseWord)) {
			output = "I already know the word " + word;
		} else if (!lowerCaseWord.matches("[a-z]+")) {
			output = "I do not understand the input";
		} else {
			learnedWords.add(lowerCaseWord);
			output = "Thank you for teaching me " + word;
		}

		return output;
	}

	public static void main(String[] args) {
		final Robota vicky = new Robota();

		System.out.println(vicky.learnWord("hello"));
		System.out.println(vicky.learnWord("world"));
		System.out.println(vicky.learnWord("goodbye"));
		System.out.println(vicky.learnWord("world"));
		System.out.println(vicky.learnWord("World"));
	}

}