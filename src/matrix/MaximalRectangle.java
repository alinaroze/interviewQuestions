package matrix;

import java.util.Random;
import java.util.Scanner;
import java.util.Stack;

/**
 * PROBLEM: Given a 2D binary matrix filled with 0's and 1's, find the largest
 * rectangle containing all ones and return its area. This can be converted to
 * the "Largest Rectangle Histogram" problem.
 * 
 * @author Alina Rozenbaum Date: 3/31/2016
 *
 */
public class MaximalRectangle {

	public static void main(String[] args) {
		MaximalRectangle program = new MaximalRectangle();
		program.run();

	}// end main

	protected void run() {
		// Test case
		int[][] test = { { 0, 1, 1, 1 }, { 1, 1, 1, 1 }, { 1, 1, 0, 1 } };
		print(test);

		maxRectangle(test);

		// User input generated matrix
		Scanner input = new Scanner(System.in);
		System.out.println("What is the number of rows in the matrix?");
		int m = input.nextInt();
		System.out.println("What is the number of columns in the matrix?");
		int n = input.nextInt();

		int[][] matrix = generateZeroMatrix(m, n);
		maxRectangle(matrix);
		input.close();
	}// end run

	/**
	 * Compares each retrieved area and largest rectangle of ones
	 * 
	 * @param board
	 *            -- The matrix to be searched
	 * @return -- The largest rectangular area of ones
	 */
	protected void maxRectangle(int board[][]) {
		int m = board.length;
		int n = (m == 0 ? 0 : board[0].length);
		int[][] height = new int[m][n + 1];
		int maxArea = 0;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (board[i][j] == 0) {
					height[i][j] = 0;
				} else {
					height[i][j] = (i == 0 ? 1 : height[i - 1][j] + 1);
				} // end if else
			} // end for
		} // end for

		for (int i = 0; i < m; i++) {
			int area = maxAreaInHist(height[i]);
			if (area > maxArea)
				maxArea = area;
		} // end for
		System.out.printf("The max area of a rectangle of 1s in this matrix is: %s\n", maxArea);
	}// end maxRectangle

	/**
	 * Finds the area of a rectangle of ones
	 * 
	 * @param height
	 *            -- The height of
	 * 
	 * @return -- The max area
	 */
	protected int maxAreaInHist(int[] height) {
		Stack<Integer> stack = new Stack<Integer>();
		int i = 0;
		int max = 0;
		while (i < height.length) {
			if (stack.isEmpty() || height[stack.peek()] <= height[i]) {
				stack.push(i++);
			} else {
				int t = stack.pop();
				max = Math.max(max, height[t] * (stack.isEmpty() ? i : i - stack.peek() - 1));
			} // end if-else
		} // end while
		return max;
	}// end maxAreaInHist

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

}
