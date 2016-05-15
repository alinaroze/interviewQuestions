package linkedList;

import java.util.InputMismatchException;

/**
 * PROBLEM: Given a singly linked list, group all odd nodes together followed by
 * the even node. Note that we are talking about node number, not the value in
 * the node. Should run in O(1) space complexity and O(nodes) time complexity.
 * 
 * SOLUTION: Solve using two pointers. Iterate over the list and more the two
 * pointers.
 * 
 * @author Alina Rozenbaum Date: 5/3/2016
 *
 */
public class OddEven {

	public static void main(String[] args) {
		OddEven program = new OddEven();
		program.run();

	}// end main

	/**
	 * Runs the program
	 */
	protected void run() {
		System.out.println("What is the first element of the list?");
		QueueLinkedList list = new QueueLinkedList();
		Node n = new Node(0);
		try {
			n = list.makeQueue();
		} catch (InputMismatchException e) {
			System.out.println("Not a valid input, try again.");
			run();
		} // end try catch
		list.printQueue(oddEvenList(n));
	}// end run

	/**
	 * Separates the list into odd ordered node and even ordered nodes
	 * 
	 * @param head
	 *            - Linked list to be separated
	 * @return - The odd-even linked list
	 */
	protected Node oddEvenList(Node head) {
		if (head == null)
			return head;
		Node result = head;
		Node p1 = head;
		Node p2 = head.next;
		Node connectNode = head.next; // The first node of the list of evens

		while (p1 != null && p2 != null && p2.next != null) {
			p1.next = p2.next;// Connect to next odd node
			p1 = p1.next;// Move odd pointer
			p2.next = p1.next;// Connect to next even node
			p2 = p2.next;// Move even pointer
		} // end while
		p1.next = connectNode;// Connect evens to odds
		return result;
	}// end oddEvenList

}// end class OddEven
