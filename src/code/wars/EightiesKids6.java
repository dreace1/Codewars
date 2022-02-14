package code.wars;

import java.util.Map;
/**
 * <a href="https://www.codewars.com/kata/566b490c8b164e03f8000002/train/java">EightiesKids6</a>
 * @author rosen
 *
 */
public class EightiesKids6 {
	public static String fight(Robot robot1, Robot robot2, Map<String, Integer> tactics) {
		final String[] robot1Tactics = robot1.getTactics();
		final String[] robot2Tactics = robot2.getTactics();
		int robot1Health = robot1.getHealth();
		int robot2Health = robot2.getHealth();
		int robot1Index = 0;
		int robot2Index = 0;
		String winnerMsg = "";
		boolean fighting = true;
		int fightIndex = determineFightIndex(robot1.getSpeed(), robot2.getSpeed());



		while (fighting) {

			if (fightIndex % 2 != 0 && robot1Index < robot1Tactics.length) {
				robot2Health -= tactics.get(robot1Tactics[robot1Index]);
				robot1Index++;
			} else if (robot2Index < robot2Tactics.length) {
				robot1Health -= tactics.get(robot2Tactics[robot2Index]);
				robot2Index++;
			}

			fightIndex++;

			fighting = checkIfGameOver(robot1Index, robot1Tactics.length, robot2Index, robot1Tactics.length,
					robot1Health, robot2Health);
		}


		if (robot1Health == robot2Health) {
	        winnerMsg = "The fight was a draw.";
		} else if (robot1Health > robot2Health) {
	        winnerMsg = robot1.getName() + " has won the fight.";
	    }else{
	        winnerMsg = robot2.getName() + " has won the fight.";
	    }

		return winnerMsg;
	}

	public static int determineFightIndex(int robot1Speed, int robot2Speed) {
		int fightIndex = 1;

		if (robot2Speed > robot1Speed) {
			fightIndex = 2;
		}

		return fightIndex;
	}

	public static boolean checkIfGameOver(int robot1Index, int robot1TacticsLength, int robot2Index,
			int robot2TacticsLength, int robot1Health, int robot2Health) {
		return robot1Index >= robot1TacticsLength && robot2Index >= robot2TacticsLength || robot1Health <= 0
				|| robot2Health <= 0;
	}







}
