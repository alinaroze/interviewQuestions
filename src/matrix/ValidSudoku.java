package matrix;

import java.util.Random;

/**
 * PROBLEM: Determine if a Sudoku is valid. The sudoku board could be partially
 * filled, where empty cells are filled with the char '.'
 * 
 * NOTE: Could also change this program to generate valid sudoku rather than
 * check if it is valid.
 * 
 * @author Alina Rozenbaum Date: 3/25/2016
 *
 */
public class ValidSudoku {
	public static void main(String[] args) {
		ValidSudoku program = new ValidSudoku();
		program.run();
	}// end main

	protected void run() {
		char[][] sudoku = generateSudoku();
		char[][] test = { { '5', '3', '.', '.', '7', '.', '.', '.', '.' },
				{ '6', '.', '.', '1', '9', '5', '.', '.', '.' }, { '.', '9', '8', '.', '.', '.', '.', '6', '.' },
				{ '8', '.', '.', '.', '6', '.', '.', '.', '3' }, { '4', '.', '.', '8', '.', '3', '.', '.', '1' },
				{ '7', '.', '.', '.', '2', '.', '.', '.', '6' }, { '.', '6', '.', '.', '.', '.', '2', '8', '.' },
				{ '.', '.', '.', '4', '1', '9', '.', '.', '5' }, { '.', '.', '.', '.', '8', '.', '.', '7', '9' } };
		
		System.out.printf("Is it a valid sudoku puzzle? %s\n", isValidSudoku(sudoku));
		System.out.println("The 'valid' sudoku:");
		print(test);
		System.out.printf("The test case is: %s\n", isValidSudoku(test));
		
	

	}// end run

	protected boolean isValidSudoku(char[][] board) {
		if (board == null || board.length != 9 || board[0].length != 9)
			return false;
		// Check each column
		for (int i = 0; i < 9; i++) {
			boolean[] m = new boolean[9];
			for (int j = 0; j < 9; j++) {
				if (board[i][j] != '.') {
					if (m[(int) (board[i][j] - '1')] == true)
						return false;
					m[(int) (board[i][j] - '1')] = true;
				} // end if
			} // end for
		} // end for

		// Check each row
		for (int j = 0; j < 9; j++) {
			boolean[] m = new boolean[9];
			for (int i = 0; i < 9; i++) {
				if (board[i][j] != '.') {
					if (m[(int) (board[i][j] - '1')] == true)
						return false;
					m[(int) (board[i][j] - '1')] = true;
				} // end if
			} // end for
		} // end for

		// Check each 3x3 matrix
		for (int block = 0; block < 9; block++) {
			boolean[] m = new boolean[9];
			for (int i = block / 3 * 3; i < block / 3 * 3 + 3; i++) {
				for (int j = block % 3 * 3; j < block % 3 * 3 + 3; j++) {
					if (board[i][j] != '.') {
						if (m[(int) (board[i][j] - '1')] == true)
							return false;
						m[(int) (board[i][j] - '1')] = true;
					} // end if
				} // end for
			} // end for
		} // end for
		return true;
	}// end isValidSudoku

	/**
	 * Generates a sudoku puzzle (may or may not be valid)
	 * 
	 * @return --The geenerated puzzle
	 */
	protected char[][] generateSudoku() {
		char[][] sudoku = new char[9][9];
		char[] c = { '1', '2', '3', '4', '5', '6', '7', '8', '9', '.' };
		Random num = new Random();

		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				sudoku[i][j] = c[num.nextInt(10)];
			} // end for
		} // end for
		System.out.println("The 'Sudoku' puzzle is:\n");
		print(sudoku);
		return sudoku;
	}// end generateSudoku

	/**
	 * Prints a 2D array
	 * 
	 * @param matrix
	 *            --Matrix to be printed
	 */
	protected void print(char[][] matrix) {
		for (int i = 0; i < matrix.length; i++) {
			if(i%3==0)
				System.out.println();
			for (int j = 0; j < matrix[0].length; j++) {
				if(j%3==0)
					System.out.print("\t");
				System.out.printf("[%s]", matrix[i][j]);
			} // end for
			System.out.println();
		} // end for
		System.out.println();
	}// end print
}
