package linkedList;

import java.util.Scanner;

/**
 * Creates a node to build a linked list. Has the option of creating a node with
 * two pointers one of which is randomly generated.
 * 
 * @author Alina Rozenbaum
 *
 */
class Node {

	int val;
	Node next, random;

	/**
	 * Creates a node that contains an int value and point to the next node and
	 * a random node, intialized at null
	 * 
	 * @param label
	 *            -- The value that this node contains
	 */
	Node(int label) {
		this.val = label;
		this.next = this.random = null;
	}// end Node

}// end class Node

/**
 * Implements a stack data structure using linked list. Stack is last in first
 * out.
 * 
 * @author Alina Rozenbaum Date: 4/1/2016
 *
 */
class StackLinkedList {

	Node top;

	/**
	 * Looks at the top node on the stack, but DOES NOT REMOVE
	 * 
	 * @return -- The top node on the stack
	 */
	protected Node peek() {

		if (top != null)
			return top;
		return null;
	}// end peek

	/**
	 * Pops a node off the top of the stack
	 * 
	 * @return -- The node that was removed from the top
	 */
	protected Node pop() {

		if (top == null) {
			return null;
		} else {
			Node temp = new Node(top.val);
			top = top.next;
			return temp;
		} // end if else
	}// end pop

	/**
	 * Pushes a node onto the top of the stack
	 * 
	 * @param n
	 *            -- The node to be pushed
	 */
	protected void push(Node n) {

		if (n != null) {
			n.next = top;
			top = n;
		} // end if
	}// end push

	/**
	 * Prints the stack starting at a certain point
	 * 
	 * @param n
	 *            - First node in the stack to be printed
	 */
	protected void printStack(Node n) {
		while (n != null) {
			System.out.printf("%s, ", n.val);
			n = n.next;
		} // end while
		System.out.println();
	}// end printStack

	/**
	 * Creates an int stack from user input
	 */
	protected Node makeStack() {
		Scanner input = new Scanner(System.in);
		int num = input.nextInt();
		while (num != -1) {
			Node n = new Node(num);
			push(n);
			System.out.println("Would you like to add another number to the stack?");
			System.out.println("If not type '-1'");
			num = input.nextInt();
		} // end while
		input.close();
		printStack(top);
		return top;
	}// end makesStack

	/**
	 * Creates an integer stack based on an inputed string
	 * 
	 * @return - The head of the stack linked list created
	 */
	protected Node strToStack(String s) {
		int[] numArr = new int[s.length()];

		for (int i = 0; i < s.length(); i++) {
			numArr[i] = s.charAt(i) - '0';
			Node n = new Node(numArr[i]);
			push(n);
		} // end for

		printStack(top);
		return top;
	}// end getStack
}// end class StackLinkedList

/**
 * Creates a queue data structure using linked list. Queue is first in first out
 * 
 * @author Alina Rozenbaum Date: 4/1/2016
 *
 */
class QueueLinkedList {

	Node first, last;

	/**
	 * Looks at the first node in the queue, but DOES NOT REMOVE
	 * 
	 * @return -- The first node in the queue
	 */
	protected Node peek() {

		if (first != null)
			return first;
		return null;
	}// end peek

	/**
	 * Adds a node to the end of the queue.
	 * 
	 * @param n
	 *            -- The node to be added
	 */
	protected void enqueue(Node n) {

		if (first == null) {
			first = n;
			last = first;
		} else {
			last.next = n;
			last = n;

		} // end if else
	}// end enqueue

	/**
	 * Removes the first node from the queue
	 * 
	 * @return -- The removed first node
	 */
	protected Node dequeue() {

		if (first == null) {
			return null;
		} else {
			Node temp = new Node(first.val);
			first = first.next;
			return temp;
		} // end if else
	}// end dequeue

	/**
	 * Prints a queue starting at a certain number
	 * 
	 * @param n
	 *            - The number where it begins to print the queue
	 */
	protected void printQueue(Node n) {
		while (n != null) {
			System.out.printf("%s, ", n.val);
			n = n.next;
		} // end while
		System.out.println();
	}// end printQueue

	/**
	 * Creates an int queue from user input, with no set length
	 * 
	 * @return - the linked list that's created
	 */
	protected Node makeQueue() {
		Scanner input = new Scanner(System.in);
		int num = input.nextInt();
		while (num != -1) {
			Node n = new Node(num);
			enqueue(n);
			System.out.println("Would you like to add another number to the queue?");
			System.out.println("If not type '-1'");
			num = input.nextInt();
		} // end while

		printQueue(first);
		return first;
	}// end makesQueue

	/**
	 * Converts string number into a linked list using a queue data structure
	 * 
	 * @return - The head of the linked list created
	 */
	protected Node strToQueue(String s) {

		int[] numArr = new int[s.length()];

		for (int i = 0; i < s.length(); i++) {
			numArr[i] = s.charAt(i) - '0';
			Node n = new Node(numArr[i]);
			enqueue(n);
		} // end for

		printQueue(first);
		return first;
	}// end strToQueue
}// end class Queue
