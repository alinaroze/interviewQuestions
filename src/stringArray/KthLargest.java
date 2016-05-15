package stringArray;

import java.util.Arrays;

/**
 * Find the kth largest element in an unsorted array. Note that it is the kth
 * largest element in the sorted order, not the kth distinct element.
 * 
 * For example: given [3,2,1,5,6,4] and k = 2, return 5. Note: You may assume k
 * is always valid, 1<=k<=array's length
 * 
 * @author - Alina Rozenbaum Date: 02/18/2016
 *
 */
public class KthLargest {

	public static void main(String[] args) {
		int[] arr = { 3, 2, 1, 5, 6, 4 };
		int k = 2;
		KthLargest obj = new KthLargest();

		System.out.printf("SOLUTION 1: The %s nd/th largest number in array %s is: %s", k, Arrays.toString(arr),
				obj.kthLargest(arr, k));
		/*System.out.printf("SOLUTION 2: The %s nd/th largest number in array %s is: %s", k, Arrays.toString(arr),
				obj.findKthLargest(arr, k));*/

	}

	/**
	 * SOLUTION 1: O(nlog(n)) Finds the kth largest element after sorting the
	 * array.
	 * 
	 * @param nums
	 *            - Array that we are looking at
	 * @param k
	 *            - Specifies which largest element we're finding
	 * @return - The element retrieved form the array
	 */
	public int kthLargest(int[] nums, int k) {
		Arrays.sort(nums);
		return nums[nums.length - k];
	}

	/**
	 * SOLUTION 2: Can also be solved using Quickselect approach, similar to
	 * Quicksort. Best: O(n) Worst: O(n^2)
	 * 
	 * @param nums
	 *            - Array to be searched
	 * @param k
	 *            - Specifies which largest element we're finding
	 * @return - Kth largest element
	 */
	public int findKthLargest(int[] nums, int k) {
		if (k < 1 || nums == null)
			return 0;
		return getKth(nums.length - k + 1, nums, 0, nums.length - 1);
	}// end findKthLargest

	/**
	 * Finds the kth largest element in the array using Quickselect
	 * 
	 * @param k
	 *            - Which largest element we're looking for
	 * @param nums
	 *            - Array we're searching in
	 * @param start
	 *            - Beginning of the array
	 * @param end
	 *            - End of the array
	 * @return - Kth largest element
	 */
	public int getKth(int k, int[] nums, int start, int end) {
		int pivot = nums[end];// Pivot set to last element in array

		int left = start;// Sets left bound
		int right = end;// Sets right bound

		// Loop runs until meets the condition for left == right
		while (true) {
			while (nums[left] < pivot && left < right) {
				left++;
				System.out.printf("Left is: %s \n", left);
			} // end while
			while (nums[right] >= pivot && right > left) {
				right--;
				System.out.printf("Right is: %s \n", right);
			} // end while
			if (left == right)
				break;
			swap(nums, left, right);
			System.out.println("We flipped the right and left: " + Arrays.toString(nums));
		} // end while

		swap(nums, left, end);
		System.out.println("We flipped the left and end: " + Arrays.toString(nums));

		if (k == left + 1) {
			return pivot;
		} else if (k < left + 1) {
			return getKth(k, nums, start, left - 1);
		} else {
			return getKth(k, nums, left + 1, end);
		} // end if-else-if-else
	}// end getKth

	/**
	 * Swaps the two numbers in the array
	 * 
	 * @param nums
	 *            - Array where the numbers are
	 * @param n1
	 *            - Index of first number
	 * @param n2
	 *            - Index of second number
	 */
	public void swap(int[] nums, int n1, int n2) {
		int temp = nums[n1];
		nums[n1] = nums[2];
		nums[2] = temp;
	}// end swap

}
