package linkedList;

import java.util.Scanner;

/**
 * PROBLEM: Given a sorted linked list delete all duplicates such that each
 * element appears only once. For example, Given 1->1->2, return 1->2 and given
 * 1->1->2->3->3, return 1->2->3
 * 
 * SOLUTION: The key to this problem is using the right loop condition. And
 * change what is necessary in each loop. You can use different iteration
 * conditions like the following two solutions.
 * 
 * @author Alina Rozenbaum Date: 5/2/2016
 *
 */
public class RemoveDuplicates {

	public static void main(String[] args) {
		RemoveDuplicates program = new RemoveDuplicates();
		program.run();

	}// end main;

	/**
	 * Runs the program
	 */
	protected void run() {
		System.out.println("What is the first element of the sorted list?");
		Scanner input = new Scanner(System.in);
		QueueLinkedList list = new QueueLinkedList();

		Node n = list.makeQueue();
		System.out.println("Our new list, with duplicates removed: ");
		list.printQueue(deleteDuplicates(n));
		input.close();
	}// end run

	/**
	 * Deletes the duplicates from a linked list through use of if-else
	 * 
	 * @param head
	 *            - Linked list to delete duplicates from
	 * @return - Linked lists without duplicates
	 */
	protected Node deleteDuplicates(Node head) {
		if (head == null || head.next == null)
			return head;
		Node prev = head;
		Node p = head.next;

		while (p != null) {
			if (p.val == prev.val) {
				prev.next = p.next;
				p = p.next;
			} else {
				prev = p;
				p = p.next;
			} // end if-else
		} // end while
		return head;
	}// end deleteDuplicates

	/**
	 * Second solution, slightly different use of looping
	 * 
	 * @param head
	 *            - Linked list to delete duplicates from
	 * @return - Linked lists without duplicates
	 */
	protected Node deleteDuplicates2(Node head) {
		if (head == null || head.next == null)
			return head;

		Node p = head;
		while (p != null && p.next != null) {
			if (p.val == p.next.val) {
				p.next = p.next.next;
			} else {
				p = p.next;
			} // end if-else
		} // end while
		return head;
	}// end deleteDuplicates2

}// end class RemoveDuplicates
