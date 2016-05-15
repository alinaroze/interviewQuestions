package matrix;

import java.util.Random;
import java.util.Scanner;

/**
 * PROBLEM: Given an mxn grid filled with non-negative numbers, find a path from
 * top left to bottom right which minimizes the sum of all numbers along the
 * path.
 * 
 * SOLUTION: Depth first search is straightforward, but the time is too
 * expensive. Dynamic programming is much more effective.
 * 
 * @author Alina Rozenbaum 3/24/2016
 *
 */
public class MinPathSum {

	public static void main(String[] args) {
		MinPathSum program = new MinPathSum();
		program.run();

	}

	protected void run() {
		Scanner input = new Scanner(System.in);
		System.out.println("What is the number of rows in the matrix?");
		int m = input.nextInt();
		System.out.println("What is the number of columns in the matrix?");
		int n = input.nextInt();
		int[][] matrix = generateMatrix(m, n);
		int[][] sum = minPathSum(matrix);
		System.out.println("The minimum path sum matrix is:\n");
		print(sum);
		input.close();

	}

	/**
	 * Finds the sum matrix showing the min sum path
	 * 
	 * @param grid
	 *            -- matrix where the min sum path is searched for
	 * @return -- Min sum matrix
	 */
	protected int[][] minPathSum(int[][] grid) {
		if (grid == null || grid.length == 0)
			return grid;

		int m = grid.length;
		int n = grid[0].length;

		int[][] dp = new int[m][n];
		dp[0][0] = grid[0][0];

		/// Initializes first row
		for (int i = 1; i < n; i++) {
			dp[0][i] = dp[0][i - 1] + grid[0][i];
		} // end for

		// Initializes first column
		for (int j = 1; j < m; j++) {
			dp[j][0] = dp[j - 1][0] + grid[j][0];
		} // end for

		for (int i = 1; i < n; i++) {
			for (int j = 1; j < m; j++) {
				// if the top if greater than the left
				if (dp[i - 1][j] > dp[i][j - 1]) {
					dp[i][j] = dp[i][j - 1] + grid[i][j];
				} else {
					dp[i][j] = dp[i - 1][j] + grid[i][j];
				} // end of-else
			} // end for
		} // end for
		return dp;

	}// end minPathSum

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
	 * Generates a matrix to given specifications of random numbers within the
	 * given range
	 * 
	 * @param m
	 *            -- The number of rows
	 * @param n
	 *            -- The number of columns
	 * @return -- The generated matrix
	 */
	protected int[][] generateMatrix(int m, int n) {
		int[][] matrix = new int[m][n];
		Random num = new Random();

		int min = 0, max = 50;// Starting
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				// The range of each number
				matrix[i][j] = num.nextInt((max - min) + 1) + min;
			} // end for
		} // end for

		/*
		 * So, you can actually generate a table with unique numbers, just add
		 * each # generated successfully to a HashMap with the same index (no
		 * fear of collision this way, since all #s are unique), and when trying
		 * to generate the next element to the table, check is
		 * hashMap.contain(#) and if it does, try again.
		 */

		print(matrix);
		return matrix;
	}

	/**
	 * Prints a 2D array
	 * 
	 * @param matrix
	 *            --Matrix to be printed
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
