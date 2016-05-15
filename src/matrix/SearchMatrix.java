package matrix;

import java.util.Random;
import java.util.Scanner;

/**
 * 
 * @author alinaroze
 *
 */
public class SearchMatrix {

	public static void main(String[] args) {
		SearchMatrix program = new SearchMatrix();
		program.run();

	}// end main

	/**
	 * Runs the program to search the matrix
	 */
	protected void run() {
		Scanner input = new Scanner(System.in);
		System.out.println("What is the number of rows in the matrix?");
		int m = input.nextInt();
		System.out.println("What is the number of columns in the matrix?");
		int n = input.nextInt();
		int[][] matrix = generateSortedMatrix(m, n);

		System.out.println("Would you like to search for a number?");
		String ans = input.next();
		while (ans.equalsIgnoreCase("yes")) {

			System.out.println("What number would you like to search for?");
			int num = input.nextInt();

			System.out.println("Is your number within the matrix?: " + searchMatrix(matrix, num));
			System.out.println("\nWould you like to search for another number?");
			ans = input.next();
		} // end while
		System.out.println("Ok, have a nice day.");
		input.close();
	}// end run

	/**
	 * Searches the given matrix for the necessary target value
	 * 
	 * @param matrix
	 *            -- Matrix to be searched
	 * @param target
	 *            -- Target value to be searched for
	 * @return -- Whether found or not: boolean.
	 */
	protected boolean searchMatrix(int[][] matrix, int target) {
		int m = matrix.length;
		int n = matrix[0].length;
		if (matrix == null || m == 0 || n == 0)
			return false;

		int start = 0;
		int end = m * n - 1;

		while (start <= end) {
			int mid = (start + end) / 2;
			int midX = mid / n;
			int midY = mid % n;

			if (matrix[midX][midY] == target)
				return true;

			if (matrix[midX][midY] < target) {
				start = mid + 1;
			} else {
				end = mid - 1;
			} // end if-else
		} // end while
		return false;
	}// end searchMatrix

	/**
	 * Generates a sorted matrix to specifications
	 * 
	 * @param m
	 *            -- Number of rows
	 * @param n
	 *            -- Number of columns
	 * @return -- The filled and sorted matrix
	 */
	protected int[][] generateSortedMatrix(int m, int n) {
		int[][] matrix = new int[m][n];
		Random num = new Random();

		int min = 0, max = 10;// Starting
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				// The range of each number
				matrix[i][j] = num.nextInt((max - min) + 1) + min;
				// Makes sure the next number is greater than the previous
				min = matrix[i][j] + 1;
				// Makes the numbers less random and more staggered
				max += 10;
			} // end for
		} // end for

		print(matrix);
		return matrix;
	}// end generateSortedMatrix

	/**
	 * Prints a 2D array
	 * 
	 * @param matrix
	 */
	protected void print(int[][] matrix) {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				System.out.printf("[%s]\t", matrix[i][j]);
			} // end for
			System.out.println();
		} // end for
		System.out.println();
	}// end print

}
