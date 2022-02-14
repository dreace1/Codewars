package code.wars;

public class Test {
	public static void main(String[] args) {
		final char[][] board = { { 'E', 'A', 'R', 'A' }, { 'N', 'L', 'E', 'C' }, { 'I', 'A', 'I', 'S' },
				{ 'B', 'Y', 'O', 'R' } };
		final String[] toCheck = { "C", "EAR", "EARS", "BAILER", "RSCAREIOYBAILNEA", "CEREAL", "ROBES" };

		final Boggle boggletest = new Boggle(board, "RSCAREIOYBAILNEA");

		System.out.println(boggletest.check());


	}

}
