package matrix;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.Scanner;

/**
 * PROBLEM: Given a 2D board containing 'X' and 'O', capture all regions
 * surrounded by 'X'. A region is captured by flipping all 'O's into 'X's in
 * that surrounded region.
 * 
 * SOLUTION: This problem is similar to Number of Islands. In this problem, only
 * the cells on the borders can not be surrounded. So, we can first merge those
 * O's on the borders, like in Number of Islands and replace O's with #, and
 * then scan the board and replace all O's left (if any).
 * 
 * Depth first search causes java.lang.StackOverflowError, because for a large
 * board, too many method calls are pushed to the stack and causes overflow.
 * Instead we use a queue to do a breadth first search
 * 
 * @author Alina Rozenbaum Date: 3/31/2016
 *
 */
public class SurroundedRegions {

	private Queue<Integer> queue = new LinkedList<Integer>();

	public static void main(String[] args) {
		SurroundedRegions program = new SurroundedRegions();
		program.run();

	}// end main

	/**
	 * Runs the program
	 */
	protected void run() {

		// Test case
		char[][] test = { { 'X', 'X', 'X', 'X' }, { 'X', 'O', 'O', 'X' }, { 'X', 'X', 'O', 'X' },
				{ 'X', 'O', 'X', 'X' } };
		print(test);
		System.out.printf("Test case surrounded 'O' regions:\n");
		solve(test);

		// User input generated matrix
		Scanner input = new Scanner(System.in);
		System.out.println("What is the number of rows in the matrix?");
		int m = input.nextInt();
		System.out.println("What is the number of columns in the matrix?");
		int n = input.nextInt();

		char[][] board = generateXoMatrix(m, n);
		solve(board);
		input.close();
	}// end run

	/**
	 * Solves the problem of converting 'surrounded regions' into Xs
	 * 
	 * @param board
	 *            -- The array to be solved
	 */
	protected void solve(char[][] board) {
		int m = board.length;
		int n = (m == 0 ? 0 : board[0].length);

		// merge O's on left and right border
		for (int i = 0; i < m; i++) {
			if (board[i][0] == 'O')
				bfs(board, i, 0);
			if (board[i][n - 1] == 'O')
				bfs(board, i, n - 1);
		} // end for

		// merge O's on top and bottom border
		for (int j = 0; j < n; j++) {
			if (board[0][j] == 'O')
				bfs(board, 0, j);
			if (board[m - 1][j] == 'O')
				bfs(board, m - 1, j);
		} // end for

		// process the board
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (board[i][j] == 'O') {
					board[i][j] = 'X';
				} else if (board[i][j] == '#') {
					board[i][j] = 'O';
				} // end if else if
			} // end for
		} // end for

		print(board);
	}// end solve

	/**
	 * Does a breadth first search using a queue of whether of not a cell should
	 * be converted
	 * 
	 * @param board
	 *            --Board to be converted
	 * @param i
	 *            -- The x coordinate
	 * @param j
	 *            -- The y coordinate
	 */
	protected void bfs(char[][] board, int i, int j) {
		int n = board[0].length;
		fillCell(board, i, j);
		while (!queue.isEmpty()) {
			int curr = queue.poll();
			int x = curr / n;
			int y = curr % n;

			fillCell(board, x - 1, y);
			fillCell(board, x + 1, y);
			fillCell(board, x, y - 1);
			fillCell(board, x, y + 1);

		} // end while
	}// end bfs

	/**
	 * Marks whether a cell is to be converted or not
	 * 
	 * @param board
	 *            --Board to be converted
	 * @param i
	 *            -- The x coordinate
	 * @param j
	 *            -- The y coordinate
	 */
	protected void fillCell(char[][] board, int i, int j) {
		int m = board.length;
		int n = board[0].length;
		if (i < 0 || j < 0 || i >= m || j >= n || board[i][j] != 'O')
			return;

		// Add current cell to queue then process its neighbors in bfs
		queue.offer(i * n + j);
		board[i][j] = '#';
	}// end fillCell

	/**
	 * Generates a matrix of X's and O's
	 * 
	 * @param m
	 *            -- Number of rows
	 * @param n
	 *            -- Number of columns
	 * @return -- The generated matrix
	 */
	protected char[][] generateXoMatrix(int m, int n) {
		char[][] board = new char[m][n];
		Random num = new Random();
		char[] xo = { 'X', 'O' };

		// Fills a matrix to specifications with 'X' and 'O'
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				board[i][j] = xo[num.nextInt(2)];
			} // end for
		} // end for

		print(board);
		return board;
	}// end generateXoMatrix

	/**
	 * Prints out a matrix
	 * 
	 * @param board
	 *            -- The 2D array to be displayed
	 */
	protected void print(char[][] board) {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				System.out.printf("[%s]\t", board[i][j]);
			} // end for
			System.out.println();
		} // end for
		System.out.println();
	}// end print

}
