package linkedList;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.InputMismatchException;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * PROBLEM: Merge k sorted linked lists and return it as one sorted list. Time:
 * log(k)*n. Where k=# of lists and n=total # of elements.
 * 
 * SOLUTION: Simplest is using a priority queue. The elements of the priority
 * queue are ordered according to their natural ordering, or by a comparator
 * provided at the construction time (in this case).
 * 
 * @author Alina Rozenbaum Date: 4/29/2016
 *
 */
public class MergeKSortedLists {

	public static void main(String[] args) {
		MergeKSortedLists program = new MergeKSortedLists();
		program.run();

	}// end main

	/**
	 * Runs the program
	 */
	protected void run() {
		System.out.println("How many sorted lists would you like to create?");
		Scanner input = new Scanner(System.in);

		QueueLinkedList m = new QueueLinkedList();
		ArrayList<Node> lists = new ArrayList<>();
		int size = input.nextInt();

		for (int i = 0; i < size; i++) {
			try {
				QueueLinkedList q = new QueueLinkedList();
				System.out.printf("\nWhat is the first number of list %s?\n", i);
				Node n = q.makeQueue();
				lists.add(n);
			} catch (InputMismatchException e) {
				System.out.println("Not a valid input, try again.");
				run();
			} // end try catch
		} // end for

		m.printQueue(mergeKLists(lists));

	}// end run

	/**
	 * Merges all the sorted lists given using a priority queue
	 * 
	 * @param lists
	 *            - The array of linked lists
	 * @return - The single sorted linked list
	 */
	protected Node mergeKLists(ArrayList<Node> lists) {
		if (lists.size() == 0)
			return null;

		// Sorts into ascending order
		Comparator<Node> comp = new Comparator<Node>() {
			public int compare(Node a, Node b) {
				if (a.val > b.val) {
					return 1;
				} else if (a.val == b.val) {
					return 0;
				} else {
					return -1;
				} // end if else if else
			}// end compare

		};

		// PriorityQueue is a sorted queue
		PriorityQueue<Node> q = new PriorityQueue<Node>(lists.size(), comp);

		// Add first node of each list to the queue
		for (Node list : lists) {
			if (list != null)
				q.add(list);
		} // end for

		Node head = new Node(0);
		Node p = head;// Serves as pointer/cursor

		while (q.size() > 0) {
			Node temp = q.poll();
			// Poll() retrieves and removes the head of the queue - q
			p.next = temp;
			// Keep adding next element of each list
			if (temp.next != null)
				q.add(temp.next);
			p = p.next;
		} // end while
		return head.next;
	}// end mergeKLists

}// end class MergeKSortedLists
