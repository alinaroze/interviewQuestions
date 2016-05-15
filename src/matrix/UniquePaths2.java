package matrix;

import java.util.Random;
import java.util.Scanner;

/**
 * PROBLEM: Now consider if some obstacles are added to the grids. How many
 * unique paths would there be? An obstacle and empty space is marked as 1 and 0
 * respectively in the grid.
 * 
 * For example, there is one obstacle in the middle of a 3x3 grid as illustrated
 * (has 2 unique paths): [0,0,0][0,1,0][0,0,0]
 * 
 * @author Alina Rozenbaum Date: 3/25/2016
 *
 */
public class UniquePaths2 {

	public static void main(String[] args) {
		UniquePaths2 program = new UniquePaths2();
		program.run();

	}// end main

	/**
	 * Runs the program
	 */
	protected void run() {
		Scanner input = new Scanner(System.in);
		System.out.println("What is the number of rows in the matrix?");
		int m = input.nextInt();
		System.out.println("What is the number of columns in the matrix?");
		int n = input.nextInt();
		int[][] matrix = generateMatrix(m, n);

		uniquePathWithObstacles(matrix);
		input.close();
	}//end run

	/**
	 * Finds all the unique paths in the given matrix while avoiding the
	 * obstacles (aka '0')
	 * 
	 * @param grid
	 *            -- The grid to be analyzed
	 * @return -- The collection of all the various paths with the total number
	 *         of unique paths located in dp[m-1][n-1]
	 */
	protected int[][] uniquePathWithObstacles(int[][] grid) {
		int m = grid.length;
		int n = grid[0].length;
		
		if (grid[0][0] == 1 || grid[m - 1][n - 1] == 1||grid==null||m==0) {
			System.out.println("There are no unique paths.");
			return null;
		}//end if

		int[][] dp = new int[m][n];
		dp[0][0] = 1;

		// Left column filled
		for (int i = 1; i < m; i++) {
			if (grid[i][0] == 1) {
				dp[i][0] = 0;
			} else {
				dp[i][0] = dp[i - 1][0];
			} // end if-else
		} // end for

		// Top row filled
		for (int j = 1; j < n; j++) {
			if (grid[0][j] == 1) {
				dp[0][j] = 0;
			} else {
				dp[0][j] = dp[0][j - 1];
			} // end if-else
		} // end for

		// Rest of matrix filled
		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				if (grid[i][j] == 1) {
					dp[i][j] = 0;
				} else {
					dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
				} // end if-else
			} // end for
		} // end for
		print(dp);
		return dp;
	}// end uniquePathsWIthObstacles

	/**
	 * Creates and fills a matrix with zeroes or ones
	 * 
	 * @param m
	 *            --Number of rows
	 * @param n
	 *            --Number of columns
	 * @return -- The obstacle matrix
	 */
	protected int[][] generateMatrix(int m, int n) {
		int[][] matrix = new int[m][n];
		Random ran = new Random();

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				matrix[i][j] = ran.nextInt(2);
			} // end for
		} // end for
		
		//Fixes so the program doesn't immediately exit
		matrix[0][0]=0;
		matrix[m-1][n-1]=0;

		print(matrix);
		return matrix;
	}//end generateMatrix

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
//end UniquePaths2
}
