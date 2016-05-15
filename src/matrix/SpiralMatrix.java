package matrix;

import java.util.*;

/**
 * PROBLEM: Given a matrix of m*n elements (m rows, n columns), return all
 * elements of the matrix in spiral order. For example, given:
 * 
 * [ 1 2 3 ] [ 4 5 6 ] [ 7 8 9 ]
 * 
 * You should return:[1,2,3,6,9,8,7,4,5]
 * 
 * SOLUTION: If more than one row and column left, it can form a circle and we
 * process the circle. Otherwise, if only one row or column left, we process
 * that column or row ONLY.
 * 
 * @author Alina Rozenbaum Date: 03/21/2016
 */
public class SpiralMatrix {

	public static void main(String[] args) {
		SpiralMatrix program = new SpiralMatrix();
		program.run();
	}

	/**
	 * Runs the entire program
	 */
	protected void run() {
		Scanner input = new Scanner(System.in);
		System.out.println("What is the number of rows in the matrix?");
		int m = input.nextInt();
		System.out.println("What is the number of columns in the matrix?");
		int n = input.nextInt();

		int[][] matrix = generateMatrix(m, n);

		System.out.println("Your spiral order matrix:" + spiralOrder(matrix));
		input.close();

	}// end run

	/**
	 * Arranges the given matrix in spiral order and returns it.
	 * 
	 * @param matrix
	 *            -- The given matrix
	 * @return -- The new matrix in spiral order
	 */
	protected ArrayList<Integer> spiralOrder(int[][] matrix) {
		ArrayList<Integer> result = new ArrayList<Integer>();

		if (matrix == null || matrix.length == 0)
			return result;

		int m = matrix.length;
		int n = matrix[0].length;

		int x = 0;
		int y = 0;

		while (m > 0 && n > 0) {
			// if one row/col left no circle can be formed
			if (m == 1) {// if one row
				for (int i = 0; i < n; i++) {
					result.add(matrix[x][y++]);
				} // end for
				break;
			} else if (n == 1) {// if one col
				for (int i = 0; i < m; i++) {
					result.add(matrix[x++][y]);
				} // end for
				break;
			} // end if-else-if

			// Below process a circle

			// Top --> move right
			for (int i = 0; i < n - 1; i++) {
				result.add(matrix[x][y++]);
			} // end for
			System.out.println("Top --> move right\n" + result);

			// Right --> move down
			for (int i = 0; i < m - 1; i++) {
				result.add(matrix[x++][y]);
			} // end for
			System.out.println("Right --> move down\n" + result);

			// Bottom --> move left
			for (int i = 0; i < n - 1; i++) {
				result.add(matrix[x][y--]);
			} // end for
			System.out.println("Bottom --> move left\n" + result);

			// Left --> move up
			for (int i = 0; i < m - 1; i++) {
				result.add(matrix[x--][y]);
			} // end for
			System.out.println("Left --> move up\n" + result + "\n");

			x++;
			y++;
			m = m - 2;
			n = n - 2;
		} // end while
		return result;
	}// end spiralOrder

	/**
	 * Generates a matrix in sequential order, given the number of rows and
	 * columns
	 * 
	 * @param m
	 *            -- Number of rows
	 * @param n
	 *            -- Number of columns
	 * @return -- A filled matrix
	 */
	protected int[][] generateMatrix(int m, int n) {
		int[][] matrix = new int[m][n];
		int x = 1;

		// Fills a matrix to specifications
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				matrix[i][j] = x;
				x++;
			} // end for
		} // end for

		// Prints the matrix
		System.out.println("Your matrix is: ");
		print(matrix);

		return matrix;
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
	}

}// end SpiralMatrix class
