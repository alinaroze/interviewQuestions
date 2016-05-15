package matrix;

import java.util.Random;
import java.util.Scanner;

/**
 * PROBLEM: Given an m*n matrix, if an element is 0, set its entire row and
 * column to 0. Do it "in situ" (in place).
 * 
 * SOLUTION: This problem should be solved in place, i.e., no other array should
 * be used. We can use the first column and row to track if a row/column should
 * be set to 0. Since we used the first row and column to mark the zero
 * row/column, the original values are changed.
 * 
 * @author Alina Rozenbaum Date: 03/21/2016
 *
 */
public class SetMatrixZeroes {

	public static void main(String[] args) {
		SetMatrixZeroes program = new SetMatrixZeroes();
		program.run();
	}

	/**
	 * Runs the program
	 */
	protected void run() {
		// Test case
		int[][] test = { { 0, 1, 1, 1 }, { 1, 1, 1, 1 }, { 1, 1, 0, 1 } };
		print(test);

		System.out.printf("Test case set zero matrix:\n");
		setZeroes(test);

		// User input generated matrix
		Scanner input = new Scanner(System.in);
		System.out.println("What is the number of rows in the matrix?");
		int m = input.nextInt();
		System.out.println("What is the number of columns in the matrix?");
		int n = input.nextInt();

		int[][] matrix = generateZeroMatrix(m, n);
		
		System.out.printf("Your set zero matrix:\n");
		setZeroes(matrix);
		input.close();

	}

	/**
	 * Sets the column and row of a '0' cell to all zeroes 'in Situ'
	 * 
	 * @param matrix
	 *            -- Matrix to be analyzed
	 * @return -- Returns the reset zero matrix
	 */
	protected void setZeroes(int[][] matrix) {
		boolean firstRowZero = false, firstColZero = false;
		int m = matrix.length;// Number of rows
		int n = matrix[0].length;// Number of columns

		// Set first row and column zero or not
		for (int i = 0; i < m; i++) {
			if (matrix[i][0] == 0) {// Is there a zero in the first column?
				firstColZero = true;
				break;
			} // end if
		} // end for
		for (int i = 0; i < n; i++) {
			if (matrix[0][i] == 0) {// Is there a zero in the first row?
				firstRowZero = true;
				break;
			} // end if
		} // end for

		// Mark zeroes on first row and column
		for (int i = 1; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (matrix[i][j] == 0) {
					matrix[i][0] = 0;// Mark that row
					matrix[0][j] = 0;// Mark that column
				} // end if
			} // end for
		} // end for

		// Use mark to set elements
		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				if (matrix[i][0] == 0 || matrix[0][j] == 0)
					matrix[i][j] = 0;
			} // end for
		} // end for

		// Set first column and row
		if (firstColZero) {
			for (int i = 0; i < m; i++) {
				matrix[i][0] = 0;
			} // end for
		} // end if
		if (firstRowZero) {
			for (int i = 0; i < n; i++) {
				matrix[0][i] = 0;
			} // end for
		} // end if

		print(matrix);
	}// end setZeeroes

	/**
	 * Generates a matrix of zeroes and ones
	 * 
	 * @param m
	 *            -- Number of rows
	 * @param n
	 *            -- Number of columns
	 * @return -- The generated matrix
	 */
	protected int[][] generateZeroMatrix(int m, int n) {
		int[][] matrix = new int[m][n];
		Random num = new Random();

		// Fills a matrix to specifications
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				matrix[i][j] = num.nextInt(2);
			} // end for
		} // end for

		print(matrix);
		return matrix;
	}// end generateZeroMatrix

	/**
	 * Prints out a matrix
	 * 
	 * @param matrix
	 *            -- The 2D array to be displayed
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

}// end SetMatrixZeroes
