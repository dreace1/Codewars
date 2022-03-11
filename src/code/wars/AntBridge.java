package code.wars;

public class AntBridge {
	public static String antBridge(String ants, String terrain) {

		if (!containsGab(terrain)) {
			return ants;
		}
		System.out.println(ants + "\n" + terrain + "\n");

		StringBuilder antsAsBridge = new StringBuilder();
		StringBuilder movingAnts = new StringBuilder(ants);
		String antOrder = "";
		int antIndex = ants.length() - 1;

		for (int i = 0; i < terrain.length(); i++) {
			System.out.println("terrain_index " + i);

			if (movingAnts.length() == 0 && (i < terrain.length() && i > 0 && isGap(terrain.charAt(i - 1))
					&& isSolidGround(terrain.charAt(i)) && isGap(terrain.charAt(i + 1)) || isGap(terrain.charAt(i)))) {
				movingAnts = antsAsBridge.reverse();
				antsAsBridge = new StringBuilder();
				antIndex = movingAnts.toString().trim().length() - 1;
				antsAsBridge.reverse();

				antOrder = antsAsBridge.toString() + movingAnts.toString();

				movingAnts = new StringBuilder(antOrder);
				antsAsBridge = new StringBuilder();
				antIndex = antOrder.length() - 1;

				System.out.println("huhu");

			}

			if (i < terrain.length() - 1 && isSolidGround(terrain.charAt(i)) && isGap(terrain.charAt(i + 1))) {
				if (movingAnts.length() == 0) {
					continue;
				}

				if (movingAnts.length() > 0) {
					antsAsBridge.append(movingAnts.charAt(antIndex));
					movingAnts.deleteCharAt(antIndex);
					antIndex--;
				}
				System.out.println("1 bridgeAnt " + antsAsBridge);
				System.out.println("1 moving " + movingAnts);
				System.out.println(terrain);


			} else if (isGap(terrain.charAt(i))) {
				// System.out.println("if2");
				if (movingAnts.length() == 0) {
					continue;
				}

				if (movingAnts.length() > 0) {
					antsAsBridge.append(movingAnts.charAt(antIndex));
					movingAnts.deleteCharAt(antIndex);
					antIndex--;
					// } else if (movingAnts.length() == 0) {
					// movingAnts = antsAsBridge.reverse();
					// antsAsBridge = new StringBuilder();
					// antIndex = movingAnts.toString().trim().length();
					// System.out.println("HELLO 2");

					// antsAsBridge.append(movingAnts.charAt(antIndex));
					// movingAnts.deleteCharAt(antIndex);
					// antIndex--;

				}

				System.out.println("2 bridgeAnt " + antsAsBridge);
				System.out.println("2 moving " + movingAnts);
				System.out.println(terrain);



			} else if (i > 0 && isGap(terrain.charAt(i - 1)) && isSolidGround(terrain.charAt(i))
					&& !isGap(terrain.charAt(i + 1))) {
				// System.out.println("if3");
				if (movingAnts.length() > 0) {
					antsAsBridge.append(movingAnts.charAt(antIndex));
					movingAnts.deleteCharAt(antIndex);
					antIndex--;

					antsAsBridge.reverse();
					System.out.println("3 rev bridgeAnt " + antsAsBridge.toString());
					System.out.println("3 moving " + movingAnts.toString());

					antOrder = antsAsBridge.toString() + movingAnts.toString();
					System.out.println("newOrder " + antOrder + "\n");
					System.out.println("############################\n");

					// movingAnts.append(antsAsBridge.toString());
					movingAnts = new StringBuilder(antOrder);
					System.out.println(movingAnts.toString());
					antsAsBridge = new StringBuilder();
					antIndex = antOrder.length() - 1;
					System.out.println(antIndex);
				} else if (movingAnts.length() == 0) {
					movingAnts = antsAsBridge.reverse();
					antsAsBridge = new StringBuilder();
					antIndex = movingAnts.toString().trim().length() - 1;
					System.out.println("Hello 3");

					// antsAsBridge.append(movingAnts.charAt(antIndex));
					// movingAnts.deleteCharAt(antIndex);
					// antIndex--;
					System.out.println("3 rev bridgeAnt " + antsAsBridge.toString());
					System.out.println("3 moving " + movingAnts.toString());


					antOrder = movingAnts.toString();
					System.out.println("newOrder " + antOrder + "\n");
					System.out.println("############################\n");


					// movingAnts.append(antsAsBridge.toString());
					System.out.println(movingAnts.toString());
					antIndex = antOrder.length() - 1;
					System.out.println(antIndex);

				}



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
		System.out.println(antBridge("EDCBA", "--..---...-..-...----..-----"));
	}

}
