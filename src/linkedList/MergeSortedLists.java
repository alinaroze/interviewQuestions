package linkedList;

import java.util.InputMismatchException;

/**
 * PROBLEM: Merge two sorted lists and return it as a new list. The new list
 * should be made by splicing together the nodes of the first two lists.
 * 
 * SOLUTION: The key to solve the problem is definitely a fake head. Then
 * compare the first elements from each list. Add the smaller one to the merged
 * list. Finally, when one of them is empty, simply append it to the merged
 * list, since it is already sorted.
 * 
 * NOTE: For input could create a sorted linked list from random user input by
 * taking in input as a list or array first, sorting, then converting to a
 * linked list
 * 
 * @author Alina Rozenbaum Date: 4/29/2016
 *
 */
public class MergeSortedLists {

	public static void main(String[] args) {
		MergeSortedLists program = new MergeSortedLists();
		program.run();
	}// end main

	/**
	 * Runs the program
	 * 
	 * @throws InputMismatchException
	 *             - If anything other than an int is used
	 */
	protected void run() throws InputMismatchException {
		QueueLinkedList q1 = new QueueLinkedList();
		QueueLinkedList q2 = new QueueLinkedList();
		QueueLinkedList q3 = new QueueLinkedList();

		Node l1 = new Node(0);
		Node l2 = new Node(0);
		try {
			System.out.println("What is the first number of the first list? ");
			l1 = q1.makeQueue();
			System.out.println("What is the first number of the first list? ");
			l2 = q2.makeQueue();
		} catch (InputMismatchException e) {
			System.out.println("Not a valid input, try again.");
			run();
		} // end try-catch block

		System.out.println("The two lists merged together: ");
		q3.printQueue(mergeTwoLists(l1, l2));

	}// end run

	/**
	 * Merges two SORTED lists together into one sorted list
	 * 
	 * @param l1
	 *            - First list
	 * @param l2
	 *            - Second list
	 * 
	 * @return - The merged sorted list
	 */
	protected Node mergeTwoLists(Node l1, Node l2) {
		Node p1 = l1;
		Node p2 = l2;
		Node fakeHead = new Node(0);
		Node p = fakeHead;

		while (p1 != null && p2 != null) {
			if (p1.val <= p2.val) {
				p.next = p1;
				p1 = p1.next;
			} else {
				p.next = p2;
				p2 = p2.next;
			} // end if-else
			p = p.next;
		} // end while

		if (p1 != null)
			p.next = p1;
		if (p2 != null)
			p.next = p2;

		return fakeHead.next;
	}// end mergeTwoLists

}// end MergeSortedLists
