package stringArray;

import java.util.Arrays;

/**
 * PROBLEM: There are two sorted arrays A and B of size m and n respectively.
 * Find the mdeian of the two sorted arrays, The overall run time complexity
 * should be O(log(m+n)).
 * 
 * @author - Alina Rozenbaum Date: 2/15/2016
 *
 */
public class FindMedian {

	public static void main(String[] args) {
		int A[] = { 1, 2, 3, 4, 5, 6 };
		int B[] = { 7, 8, 9, 10, 11 };
		FindMedian object = new FindMedian();

		System.out.printf("\n The median of arrays %s and %s is %s", Arrays.toString(A), Arrays.toString(B),
				object.findMedianSortedArrays(A, B));

	}

	/**
	 * SOLUTION 1: If we see log(n) we should think about using binary. This
	 * problem can be converted to the problem of finding the kth element, k is
	 * (A's length + B's length)/2. If any of the two arrays is empty, then the
	 * kth element is the non empty array's kth element if k==0, the kth element
	 * is the first element of A or B. For normal (all other) cases, we need to
	 * move the pointer at the pace of half an array length to get log(n) time.
	 *
	 * The actual method that finds the median.
	 * 
	 * @param A
	 *            - First of the two arrays
	 * @param B
	 *            - Second of the two arrays
	 * @return - The median value
	 */
	public double findMedianSortedArrays(int A[], int B[]) {
		int m = A.length;// =6
		int n = B.length;// =5

		// (6+5)%2 = 1
		if ((m + n) % 2 != 0)// odd
			return (double) findKth(A, B, (m + n) / 2, 0, m - 1, 0, n - 1);// findKth(A,B,(6+5)/2=5,0,5,0,4)
		else {
			return (findKth(A, B, (m + n) / 2, 0, m - 1, 0, n - 1) + findKth(A, B, (m + n) / 2 - 1, 0, m - 1, 0, n - 1))
					* 0.5;
		} // end if-else
	}// end findMedianSortedArrays

	/**
	 * Finds the kth element, in this case, continuously finds the value at half
	 * the array length. The kth element is the pointer.
	 * 
	 * @param A
	 *            - First array
	 * @param B
	 *            - Second array
	 * @param k
	 *            - Kth element or pointer
	 * @param aStart
	 *            - Beginning of segment from array A
	 * @param aEnd
	 *            - End of segment from array A
	 * @param bStart
	 *            - Beginning of segment from array B
	 * @param bEnd
	 *            - End of segment from array B
	 * @return - The kth element, or median element
	 */
	public int findKth(int A[], int B[], int k, int aStart, int aEnd, int bStart, int bEnd) {
		int aLen = aEnd - aStart + 1;// =6, =3, =1
		int bLen = bEnd - bStart + 1;// =5, =3, =1
		System.out.printf("\n Length of A is %s and B is %s", aLen, bLen);

		// Handle special cases
		if (aLen == 0)// If the array A is empty
			return B[bStart + k];// kth element is kth element of array B
		if (bLen == 0)// If the array B is emptty
			return A[aStart + k];// kth element is kth element of array A
		if (k == 0)// If k==0, then kth element is first element of array A or
					// B. => True
			// A[5]=6>B[0]=7 ? 6: 7 => Return 6.0 and END.
			return A[aStart] < B[bStart] ? A[aStart] : B[bStart];
		// aMid = aLen/2 and k = (aLen+bLen)/2, so aMid = aLen*k/(ALen+bLen),
		// because solution is O(log(n+m))
		int aMid = aLen * k / (aLen + bLen);// =2, =1
		int bMid = k - aMid - 1;// =2, =0
		System.out.printf("\n Mid point of array A is %s and B is %s", aMid, bMid);

		// Make aMid and bMid to be array index
		aMid += aStart;// = 2, =4
		bMid += bStart;// = 2, =0
		System.out.printf("\n Array index of midpoint A is %s and B is %s", aMid, bMid);

		if (A[aMid] > B[bMid]) {// => False, => False
			k = k - (bMid - bStart + 1);
			aEnd = aMid;
			bStart = bMid + 1;
		} else {
			k = k - (aMid - aStart + 1);// =2, =0
			bEnd = bMid;// =2, =0
			aStart = aMid + 1;// =3 ,=5
		} // end f-else
		System.out.printf("\n kth: %s, aStart: %s, aEnd: %s, bStart: %s, bEnd: %s", k, aStart, aEnd, bStart, bEnd);
		// findKth(A.B.2.3.5.0.2)
		// findKth(A,B,0,5,5,0,0)
		return findKth(A, B, k, aStart, aEnd, bStart, bEnd);
	}// end findKth

	/*
	 * SOLUTION 2: We can also come up with a simpler solution which only finds
	 * the median of two sorted arrays for this particular problem. Description
	 * of the algorithm is as follows:
	 * 
	 * 1. Calculate medians m1 and m2 of ar1[] and ar2[] respectively 2. If m1
	 * or m2 are both equal then we are done, and return m1 (or m2) 3. If m1>m2,
	 * median is present in one of two subarrays below: a. From 1st element of
	 * ar1 to m1 (ar1[0...|_n/2_|]) b. From m2 to last element of ar2
	 * (ar2[|_n/2_|...n-1]) 4. If m2>m1, median is present in one of two
	 * subarrays below: a. From m1 to last element of ar1 (ar1[|_n/2_|...n-1])
	 * b. From 1st element of ar2 to m2 (ar2[0...|_n/2_|]) 5. Repeat the above
	 * process until size of both subarrays becomes 2. 6. If size of the two
	 * arrays is 2 then use the formula below to get the median:
	 * 
	 * Median = (max(ar1[0],ar2[0])+ min(ar1[1],ar2[1]))/2
	 */

}// end class FindMedian
