package linkedList;

import java.util.Scanner;

/**
 * PROBLEM: Given a sorted linked list, delete all nodes that have duplicate
 * numbers, leaving only distinct numbers from the original list. 1->1->1->2->3
 * return 2->3.
 * 
 * @author Alina Rozenbaum Date: 5/2/2016
 *
 */
public class RemoveDuplicates2 {

	public static void main(String[] args) {
		RemoveDuplicates2 program = new RemoveDuplicates2();
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
		Node t = new Node(0);
		t.next = head;
		Node p = t;

		while (p.next != null && p.next.next != null) {
			if (p.next.val == p.next.next.val) {
				int dup = p.next.val;
				while (p.next != null && p.next.val == dup) {
					p.next = p.next.next;
				} // end while
			} else {
				p = p.next;
			} // if-else
		} // end while
		return t.next;
	}// end deleteDuplicates

}// end class RemoveDuplicates2
