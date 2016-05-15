package linkedList;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * PROBLEM: You are given two linked lists representing two non-negative number.
 * The digits are stored in reverse order and each of their nodes contains a
 * single digit. Add the two numbers and return it as a linked list. Input:
 * (2->4->3)+(5->6->4) output: 7->0->8
 * 
 * NOTE: We implement using a stack data structure
 * 
 * @author Alina Rozenbaum Date: 4/4/2016
 *
 */
public class AddTwoNumbers {

	public static void main(String[] args) {
		AddTwoNumbers program = new AddTwoNumbers();
		program.run();
	}// end main

	/**
	 * Runs the program
	 */
	protected void run() throws InputMismatchException {
		System.out.println("NOTE: Inputed numbers must have digits typed in reverse order.");
		Scanner input = new Scanner(System.in);
		StackLinkedList stack1 = new StackLinkedList();
		StackLinkedList stack2 = new StackLinkedList();
		StackLinkedList stack3 = new StackLinkedList();

		Node num1 = new Node(0);
		Node num2 = new Node(0);

		try {
			System.out.println("What is the first number?");
			num1 = stack1.strToStack(input.next());
			System.out.println("What is the second number?");
			num2 = stack2.strToStack(input.next());
		} catch (InputMismatchException e) {
			System.out.println("Not a valid input, try again.");
			run();
		}

		System.out.println("\nThe sum of the two numbers is: ");
		stack3.printStack(addTwoNums(num1, num2));
		input.close();
	}// end run

	/**
	 * Adds two numbers together in reverse order
	 * 
	 * @param l1
	 *            - Head Node of first number
	 * @param l2
	 *            - Head Node of second number
	 * @return - The Stack
	 */
	protected Node addTwoNums(Node l1, Node l2) {
		Node head = new Node(0);
		Node p1 = l1, p2 = l2, p3 = head;
		int carry = 0;

		while (p1 != null || p2 != null) {
			if (p1 != null) {
				carry += p1.val;
				p1 = p1.next;
			} // end if

			if (p2 != null) {
				carry += p2.val;
				p2 = p2.next;
			} // end if

			p3.next = new Node(carry % 10);
			p3 = p3.next;
			carry /= 10;
		} // end while
		if (carry == 1)
			p3.next = new Node(1);
		return head.next;
	}// end addTwoNum

}// end AddTwoNumbers class
