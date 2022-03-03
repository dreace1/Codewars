package code.wars;

public class FindOdd {
	public static int findIt(int[] numbers) {
		int oddNumber = 0;

		for (final int number : numbers) {
			if (countOccurences(numbers, number) % 2 != 0) {
				oddNumber = number;
			}
		}
		return oddNumber;
	}

	public static int countOccurences(int[] numbers, int number) {
		int count = 0;

		for (int i = 0; i < numbers.length; i++) {
			if (numbers[i] == number) {
				count++;
			}
		}
		return count;
	}

	public static void main(String[] args) {
		System.out.println(findIt(new int[] { 20, 1, -1, 2, -2, 3, 3, 5, 5, 1, 2, 4, 20, 4, -1, -2, 5 }));
	}

}
