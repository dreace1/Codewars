package code.wars;

import java.util.ArrayList;
import java.util.List;

//https://www.codewars.com/kata/5941c545f5c394fef900000c/train/java
public class Warrior {
	private int level;
	private int experience;
	private String rank;
	private final List<String> achievements = new ArrayList<>();
	private final ArrayList<String> ranks = new ArrayList<>();

	public Warrior() {
		fillRanks(ranks);
		this.level = 1;
		this.experience = 100;
	}

	public void fillRanks(ArrayList<String> ranks) {
		ranks.add("Pushover");
		ranks.add("Novice");
		ranks.add("Fighter");
		ranks.add("Warrior");
		ranks.add("Veteran");
		ranks.add("Sage");
		ranks.add("Elite");
		ranks.add("Conqueror");
		ranks.add("Champion");
		ranks.add("Master");
		ranks.add("Greatest");
	}

	public int level() {
		level = experience / 100;
		return level;
	}

	public int experience() {
		return experience;
	}

	public String rank() {

		return ranks.get(level / 10);
	}

	public List<String> achievements() {
		return achievements;
	}

	public String training(String descirbtion, int exp, int minLevel) {
		if (level < minLevel) {
			return "Not strong enough";
		}

		achievements.add(descirbtion);
		experience += exp;
		level = exp / 100;

		System.out.println("training");
		System.out.println(level);
		System.out.println(rank);
		System.out.println("----------------");

		return descirbtion;
	}

	public String battle(int oponentLevel) {
		String output = "";
		if (oponentLevel < 1 || oponentLevel > 100) {
			return "Invalid level";
		}

		System.out.println("battle");
		System.out.println("me" + level);
		System.out.println("me " + rank);
		System.out.println(oponentLevel);
		System.out.println("----------------");

		if (level == oponentLevel) {
			experience += 10;
			output = "A good fight";
		} else if (level - oponentLevel == 1 && oponentLevel < level) {
			experience += 5;
			output = "A good fight";
		} else if (level - oponentLevel <= -5 && oponentLevel / 10 > level / 10) {
			output = "You've been defeated";
		} else if (level < oponentLevel) {
			experience += 20 * (oponentLevel - level) * (oponentLevel - level);
			output = "An intense fight";
		} else {
			output = "Easy fight";
		}

		level = experience / 100;

		return output;
	}



}
