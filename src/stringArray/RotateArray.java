package stringArray;

import java.util.Arrays;

/**
 * PROBLEM: Rotate an array of n elts to the right by k steps. For, example,
 * with n=7 and k=3, the array is [1,2,3,4,5,6,7] and is rotated to
 * [5,6,7,1,2,3,4]. How many different ways can you solve this?
 * 
 * @author - Alina Rozenbaum
 * Date: 01/22/2016
 *
 */
public class RotateArray {

	public static void main(String[] args) {
		int[] array = { 1, 2, 3, 4, 5, 6, 7 };
		RotateArray shift = new RotateArray();

		System.out.println(Arrays.toString(shift.rotate(array, 10)));
		System.out.println(Arrays.toString(shift.rotate(array, 10)));
		System.out.println(Arrays.toString(shift.rotate(array, 10)));

	}

	/**
	 * SOLUTION 1: Straightforward Way, Space O(N), Time O(N) Create a new array
	 * and then copy elts to the new array. Then change the original array using
	 * System.arraycopy().
	 * 
	 * @param arr
	 *            - The original array
	 * @param k
	 *            - The number to shift the array by
	 */
	public int[] rotate(int[] arr, int k) {
		if (k > arr.length)// if k>n or (steps rotated)>(num of elts)
			k = k % arr.length;// then k is changed to k mod n

		// Create a new array of the same length
		int[] result = new int[arr.length];

		for (int i = 0; i < k; i++)
			result[i] = arr[arr.length - k + i];

		int j = 0;
		for (int i = k; i < arr.length; i++) {
			result[i] = arr[j];
			j++;
		}

		// Copy the shifted array into the original
		System.arraycopy(result, 0, arr, 0, arr.length);
		return arr;

	}

	/**
	 * SOLUTION 2: Bubble Rotate, Space O(1) and Time O(n^k) Think BubbleSort
	 * from before
	 * 
	 * @param arr
	 *            - The original array
	 * @param k
	 *            - The number to shift the array by
	 */
	public int[] rotate2(int[] arr, int k) {
		if (arr == null || k < 0)// handles exceptions
			throw new IllegalArgumentException("Illegal argument!");

		// Goes through entire array for each space shifted
		for (int i = 0; i < k; i++) {
			// Go through the array starting at the end
			for (int j = arr.length - 1; j > 0; j--) {

				// Shifts the value at the current index back one space:
				int temp = arr[j];
				arr[j] = arr[j - 1];
				arr[j - 1] = temp;
			} // end for loop
		} // end for loop

		return arr;

	}// end rotate2

	/**
	 * SOLUTION 3: Reversal, Space O(1) and Time O(N)
	 * 
	 * The basic idea is (for n=6, k=2): [1,2,3,4,5,6] 1. Divide the array into
	 * two parts: 1,2,3,4 and 5,6 2. Rotate the first part: 4,3,2,1,5,6 3.
	 * Rotate the second part: 4,3,2,1,6,5 4. Rotate entire array: 5,6,1,2,3,4
	 * 
	 * @param arr
	 *            - The original array
	 * @param k
	 *            - The number to shift the array by
	 */
	public int[] rotate3(int[] arr, int k) {
		k = k % arr.length;

		if (arr == null || k < 0)// handles exceptions
			throw new IllegalArgumentException("Illegal argument!");

		int a = arr.length - k;// length of the first part
		reverse(arr, 0, a - 1);// rotate the first part
		reverse(arr, a, arr.length - 1);// rotate the second part
		reverse(arr, 0, arr.length - 1);// rotate the whole array

		return arr;

	}

	public void reverse(int[] arr, int left, int right) {
		if (arr == null || arr.length == 1)// handles exceptions
			return;

		while (left < right) {// try for 0 < 3
			int temp = arr[left];// temp = arr[0],...=arr[1]
			arr[left] = arr[right];// arr[0] = arr[3], arr[1] = arr[2]
			arr[right] = temp;// arr[3] = arr[0], arr[2] = arr[1]

			left++;// 0->1, 1->2
			right--;// 3->2, 2->1...exit loop
		} // end while loop...two iterations total for first half
	}// end reverse

}
