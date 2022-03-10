package code.wars;

public class AntBridge {
	public static String antBridge(String ants, String terrain) {

		if (!containsGab(terrain)) {
			return ants;
		}
		System.out.println(ants + "\n" + terrain);

		final StringBuilder antsAsBridge = new StringBuilder();
		StringBuilder movingAnts = new StringBuilder(ants);
		String antOrder = "";
		int antIndex = ants.length() - 1;

		for (int i = 0; i < terrain.length(); i++) {

			if (i < terrain.length() - 1 && isSolidGround(terrain.charAt(i)) && isGap(terrain.charAt(i + 1))) {
				// System.out.println("if1");
				antsAsBridge.append(ants.charAt(antIndex));
				movingAnts.deleteCharAt(antIndex);
				antIndex--;


			} else if (isGap(terrain.charAt(i))) {
				// System.out.println("if2");

				antsAsBridge.append(ants.charAt(antIndex));
				movingAnts.deleteCharAt(antIndex);
				antIndex--;


			} else if (i > 0 && isGap(terrain.charAt(i - 1)) && isSolidGround(terrain.charAt(i))) {
				// System.out.println("if3");

				antsAsBridge.append(ants.charAt(antIndex));
				movingAnts.deleteCharAt(antIndex);
				antIndex--;

				System.out.println("moving " + movingAnts.toString());
				antsAsBridge.reverse();
				System.out.println("bridgeAnt " + antsAsBridge.toString());

				antOrder = antsAsBridge.toString() + movingAnts.toString();
				System.out.println("newOrder " + antsAsBridge + "\n");

				movingAnts = new StringBuilder(antOrder);
				antsAsBridge.delete(0, antsAsBridge.length());
				System.out.println("deleted: " + antsAsBridge);
				antIndex = movingAnts.length() - 1;

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
		System.out.println(antBridge("GFEDCBA", "------------...-----------"));
	}

}
