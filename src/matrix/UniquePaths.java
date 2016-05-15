package matrix;

import java.util.Scanner;

/**
 * PROBLEM: A robot is located at the top left corner of a mxn matrix. It can
 * only move either down or right at any point in time. The robot is trying to
 * reach the bottom right corner of the grid. How many unique paths are there?
 * 
 * SOLUTION: Depth first search is straightforward, but the time is too
 * expensive. Dynamic programming is much more effective.
 * 
 * @author Alina Rozenbaum Date: 3/24/2016
 *
 */
public class UniquePaths {

	public static void main(String[] args) {
		UniquePaths program = new UniquePaths();
		program.run();
	}// end main

	protected void run() {
		Scanner input = new Scanner(System.in);
		System.out.println("What is the number of rows in the matrix?");
		int m = input.nextInt();
		System.out.println("What is the number of columns in the matrix?");
		int n = input.nextInt();
		int[][] matrix = generateMatrix(m, n);

		uniquePaths(m, n);

	}

	protected int[][] uniquePaths(int m, int n) {
		int[][] dp = new int[m][n];

		if (m == 0 || n == 0)
			return dp;
		if (m == 1 || n == 1) {
			dp[m - 1][n - 1] = 1;
			return dp;
		} // end if

		// Initialize first column
		for (int i = 0; i < m; i++)
			dp[i][0] = 1;
		// Initialize first row
		for (int j = 0; j < n; j++)
			dp[0][j] = 1;
		// Fill the rest of the table
		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
			} // end for
		} // end for

		print(dp);
		return dp;
	}// end uniquePaths

	/**
	 * Creates and fills a matrix with zeroes
	 * 
	 * @param m
	 *            --Number of rows
	 * @param n
	 *            --Number of columns
	 * @return -- The zero matrix
	 */
	protected int[][] generateMatrix(int m, int n) {
		int[][] matrix = new int[m][n];

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				matrix[i][j] = 0;
			} // end for
		} // end for

		print(matrix);
		return matrix;
	}

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
