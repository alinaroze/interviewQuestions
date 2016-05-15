package linkedList;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * PROBLEM: Given a linked list and a value x, partition it such that all nodes
 * less than x come before nodes greater than or equal to x. You should preserve
 * the original relative order of the nodes in each of the two partitions. For
 * example, given 1->4->3->2->5->2 and x=3, return 1->2->2->4->3->5.
 * 
 * @author Alina Rozenbaum Date: 5/9/2016
 *
 */
public class PartitionList {

	public static void main(String[] args) {
		PartitionList program = new PartitionList();
		program.run();

	}// end main

	/**
	 * Runs the program
	 */
	protected void run() {
		System.out.println("What is the first element of the list?");
		QueueLinkedList list = new QueueLinkedList();
		Node n;
		int x;

		try {
			n = list.makeQueue();
			Scanner input = new Scanner(System.in);
			System.out.println("Where do you want to parition the list?");
			x = input.nextInt();
		} catch (InputMismatchException e) {
			System.out.println("Not a valid input, try again.");
			run();
		} // end try catch

		list.printQueue(partition(n, x));
	}// end run

	protected Node partition(Node head, int x) {
		if (head == null)
			return head;
		Node fakeHead1 = new Node(0);
		Node fakeHead2 = new Node(0);
		fakeHead1.next = head;
		Node p = head;
		Node prev = fakeHead1;
		Node p2 = fakeHead2;

		while (p != null) {
			if (p.val < x) {
				p = p.next;
				prev = prev.next;
			} else {
				p2.next = p;
				prev.next = p.next;
				p = prev.next;
				p2 = p2.next;
			} // end if-else
		} // end while

		// Close the list
		p2.next = null;
		prev.next = fakeHead2.next;
		return fakeHead1.next;
	}// end partition

}// end class PartitionList
