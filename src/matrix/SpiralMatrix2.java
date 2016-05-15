package matrix;

import java.util.Scanner;

/**
 * PROBLEM: Given an integer n, generate a square matrix filled with elements
 * from 1 to n^2 in spiral order. For example, given n = 4, [1 2 3 4][12 13 14
 * 5][11 16 15 6][10 9 8 7].
 * 
 * @author Alina Rozenbaum Date: 3/21/2016
 *
 */
public class SpiralMatrix2 {

	public static void main(String[] args) {
		SpiralMatrix2 program = new SpiralMatrix2();
		program.run();
	}// end main

	/**
	 * Runs the program
	 */
	protected void run() {
		SpiralMatrix2 program = new SpiralMatrix2();
		Scanner input = new Scanner(System.in);
		System.out.println("How big are the sides of the square matrix?");

		int[][] matrix = program.generateMatrix(input.nextInt());
		program.print(matrix);
		input.close();
	}// end run

	/**
	 * Generates an n*n matrix and fills it in spiral order with elements from 1
	 * to n*n.
	 * 
	 * @param n
	 *            -- The length of the sides
	 * @return -- The filled spiral matrix
	 */
	protected int[][] generateMatrix(int n) {
		int total = n * n;
		int[][] result = new int[n][n];
		int x = 0, y = 0, step = 0;

		for (int i = 0; i < total;) {
			while (y + step < n) {
				i++;
				result[x][y] = i;
				y++;
			} // end while

			y--;
			x++;
			while (x + step < n) {
				i++;
				result[x][y] = i;
				x++;
			} // end while
			x--;
			y--;
			while (y >= 0 + step) {
				i++;
				result[x][y] = i;
				y--;
			} // end while
			y++;
			x--;
			step++;

			while (x >= 0 + step) {
				i++;
				result[x][y] = i;
				x--;
			} // end while
			x++;
			y++;
		} // end for
		return result;
	}// end generateMatrix

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

}// end class SpiralMatrix2
