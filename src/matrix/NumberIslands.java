package matrix;

import java.util.Random;
import java.util.Scanner;

/**
 * PROBLEM: Given a 2D grid map of 1s (land) and 0s (water), count the number of
 * islands. An island is surrounded by water and is formed by connectedng
 * adjacent lands horizontally or vertically. You may assume all four edges of
 * the grid are surrounded by water.
 * 
 * SOLUTION: The basic idea of the following solution is merging adjacent lands,
 * and the merging should be done recursively.
 * 
 * @author Alina Rozenbaum Date: 3/27/2016
 *
 */
public class NumberIslands {

	public static void main(String[] args) {
		NumberIslands program = new NumberIslands();
		program.run();

	}//end main

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

		System.out.printf("The number of islands in the given matrix is: %s", numIslands(matrix));
		input.close();
	}//end run

	/**
	 * Counts the number of 'islands' on the grid
	 * 
	 * @param grid
	 * @return
	 */
	protected int numIslands(int[][] grid) {
		if (grid == null || grid.length == 0 || grid[0].length == 0)
			return 0;
		int count = 0;
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] == 1) {
					count++;
					merge(grid, i, j);
				} // end if
			} // end for
		} // end for
		return count;
	}// end numIslands

	/**
	 * Merges the pieces of land into larger islands
	 * 
	 * @param grid
	 * 
	 * @param i
	 *            - The x coordinates
	 * @param j
	 *            - The y coordinates
	 */
	public void merge(int[][] grid, int i, int j) {
		// Validity checking - if it goes out of bounds
		if (i < 0 || j < 0 || i > grid.length - 1 || j > grid[0].length - 1)
			return;
		// If current cell is water or visited
		if (grid[i][j] != 1)
			return;
		// Set cell to 0
		grid[i][j] = 0;
		// Merge adjacent land
		merge(grid, i - 1, j);
		merge(grid, i + 1, j);
		merge(grid, i, j - 1);
		merge(grid, i, j + 1);
	}// end merge

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

		// Fixes so the program doesn't immediately exit
		matrix[0][0] = 0;
		matrix[m - 1][n - 1] = 0;

		print(matrix);
		return matrix;
	}// end generateMatrix

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

}// end numberIslands
