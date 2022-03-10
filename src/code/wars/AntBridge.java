package code.wars;

public class AntBridge {
	public static String antBridge(String ants, String terrain) {

		if (!containsGab(terrain)) {
			return ants;
		}
		System.out.println(ants + "\n" + terrain);

		StringBuilder antsAsBridge = new StringBuilder();
		StringBuilder movingAnts = new StringBuilder(ants);
		String antOrder = "";
		int antIndex = ants.length() - 1;

		for (int i = 0; i < terrain.length(); i++) {

			if (i < terrain.length() - 1 && isSolidGround(terrain.charAt(i)) && isGap(terrain.charAt(i + 1))) {
				antsAsBridge.append(movingAnts.charAt(antIndex));
				movingAnts.deleteCharAt(antIndex);
				antIndex--;
				System.out.println("1 moving " + antsAsBridge);
				System.out.println("1 bridgeAnt " + movingAnts);


			} else if (isGap(terrain.charAt(i))) {
				// System.out.println("if2");

				antsAsBridge.append(movingAnts.charAt(antIndex));
				movingAnts.deleteCharAt(antIndex);
				antIndex--;

				System.out.println("2 moving " + antsAsBridge);
				System.out.println("2 bridgeAnt " + movingAnts);



			} else if (i > 0 && isGap(terrain.charAt(i - 1)) && isSolidGround(terrain.charAt(i))) {
				// System.out.println("if3");

				antsAsBridge.append(movingAnts.charAt(antIndex));
				movingAnts.deleteCharAt(antIndex);
				antIndex--;

				System.out.println("3 moving " + movingAnts.toString());
				antsAsBridge.reverse();
				System.out.println("3 rev bridgeAnt " + antsAsBridge.toString());

				antOrder = antsAsBridge.toString() + movingAnts.toString();
				System.out.println("newOrder " + antOrder + "\n");

				// movingAnts.append(antsAsBridge.toString());
				movingAnts = new StringBuilder(antOrder);
				System.out.println(movingAnts.toString());
				antsAsBridge = new StringBuilder();
				antIndex = antOrder.length() - 1;
				System.out.println(antIndex);

			}

		}

		return antOrder;
	}

	public static boolean isGap(char gap) {
		return gap == '.';
	}

	public static boolean isSolidGround(char ground) {
		return ground == '-';
	}

	public static boolean containsGab(String terrain) {
		return terrain.contains(".");
	}


	public static void main(String[] args) {
		System.out.println(antBridge("GFEDCBA", "------------...-----..----"));
	}

}
