package matrix;

import java.util.Scanner;

/**
 * PROBLEM: You are given an nxn matrix representing an image. Rotate the image
 * by 90 deg. (clockwise). Follow up: could you do this 'in situ'?
 * 
 * SOLUTION: You could create a new 2D array to store the rotated matrix, and
 * the result is assigned to the matrix at the end. The problem is Java is pass
 * by VALUE not REFERENCE. 'matrix' is just a reference to a 2D array. If
 * 'matrix' is assigned to a new 2D array in the method, the original array does
 * not change. Therefore, there should be another loop to assign each element to
 * the array referenced by 'matrix.'
 * 
 * @author Alina Rozenbaum Date: 3/24/2016
 *
 */
public class RotateImage {

	public static void main(String[] args) {
		RotateImage program = new RotateImage();
		program.run();
	}

	/**
	 * Runs the program
	 */
	protected void run() {
		rotate(generateMatrix());
		rotateInSitu(generateMatrix());
	}// end run

	/**
	 * Generates a star image
	 * 
	 * @return
	 */
	protected char[][] generateMatrix() {
		Scanner input = new Scanner(System.in);
		System.out.printf("Please enter an odd-number of output-lines: ");
		int n = input.nextInt();
		char[][] pic = new char[n][n];

		if (n % 2 == 1) {
			for (int i = 0; i < n; i++) {
				if (i <= n / 2) {
					for (int j = i; j < n - i; j++) {
						pic[i][j] = '*';
					} // end for
				} else {
					for (int j = n - 1 - i; j <= i; j++) {
						pic[i][j] = '*';
					} // end for
				} // end if-else
			} // end for

			print(pic);
			return pic;
		} else {
			System.out.print("Program exited");
			return null;
		} // end if-else

	}// end generateMatrix

	/**
	 * Rotates the image 90 deg clockwise
	 * 
	 * @param matrix
	 */
	protected void rotate(char[][] matrix) {
		if (matrix == null || matrix.length == 0)
			return;
		int m = matrix.length;
		char[][] result = new char[m][m];

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < m; j++) {
				result[j][m - 1 - i] = matrix[i][j];
			} // end for
		} // end for
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < m; j++) {
				matrix[i][j] = result[i][j];
			} // end for
		} // end for
		System.out.println("The 90 degree rotated pic (clockwise):\n");
		print(matrix);
	}

	/**
	 * Rotates the char image 'in place'
	 * 
	 * @param matrix
	 *            - The grid to be rotated
	 */
	protected void rotateInSitu(char[][] matrix) {
		int n = matrix.length;
		for (int i = 0; i < n / 2; i++) {
			for (int j = 0; j < Math.ceil((double) n / 2.); j++) {
				char temp = matrix[i][j];
				matrix[i][j] = matrix[n - 1 - j][i];
				matrix[n - 1 - j][i] = matrix[n - 1 - i][n - 1 - j];
				matrix[n - 1 - i][n - 1 - j] = matrix[j][n - 1 - i];
				matrix[j][n - 1 - i] = temp;
			} // end for
		} // end for

		System.out.println("The 90 degree rotated pic (clockwise)'in situ':\n");
		print(matrix);

	}// end rotateinSitu

	/**
	 * Prints a 2D array
	 * 
	 * @param matrix
	 */
	protected void print(char[][] matrix) {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				System.out.printf("%s ", matrix[i][j]);
			} // end for
			System.out.println();
		} // end for
		System.out.println();
	}// end print
}
