package linkedList;

/**
 * PROBLEM: Given a singly linked list L: L0->L1->...->Ln-1->Ln reorder it to:
 * L0->Ln->L1->Ln-1->L2->Ln-2...For example, given [1,2,3,4}, reorder it to
 * {1,4,2,3}. You must do this in Situ without altering nodes' values. This
 * means you can only change their pointers, not create a new list.
 * 
 * SOLUTION This problem can be solved by doing the following. 1. Break list in
 * the middle to two lists (use fast and slow pointers) 2. Reverse the order of
 * the second list. 3. Merge the two lists back together.
 * 
 * NOTE: We implement using a queue data structure
 * 
 * @author Alina Rozenbaum Date: 4/7/2016
 *
 */
public class ReorderList {

	public static void main(String[] args) {
		ReorderList program = new ReorderList();
		program.run();
	}// end main

	/**
	 * Runs the program
	 */
	protected void run() {
		QueueLinkedList list = new QueueLinkedList();
		System.out.println("Add a number to the queue");
		Node head = list.makeQueue();

		list.printQueue(reorderList(head));
	}// end run

	/**
	 * Reorders the list to the proper sequence
	 * 
	 * @param head
	 *            -- The head of the list to be reordered
	 * @return - The new reordered list
	 */
	protected Node reorderList(Node head) {
		if (head != null && head.next != null) {
			Node slow = head;
			Node fast = head;
			// Use fast and slow pointer to break link in two parts
			while (fast != null && fast.next != null && fast.next.next != null) {
				// Why need third/second condition?
				System.out.println("pre slow " + slow.val + " pre fast " + fast.val);
				slow = slow.next;
				fast = fast.next.next;
				System.out.println("after slow " + slow.val + " after fast " + fast.val);
			} // end while

			Node second = slow.next;
			slow.next = null;
			// Now should have two lists: head and fast
			// Reverse order for the second part
			second = reverseOrder(second);
			Node p1 = head;
			Node p2 = second;

			// Merges two Linked Lists together
			while (p2 != null) {
				Node temp1 = p1.next;
				Node temp2 = p2.next;
				p1.next = p2;
				p2.next = temp1;
				p1 = temp1;
				p2 = temp2;
			} // end while
		} // end if
		return head;
	}// end reorderList

	/**
	 * Reverses the order of a linked list
	 * 
	 * @param head
	 *            - The head of the list to be reversed
	 * @return -- The reversed list
	 */
	protected Node reverseOrder(Node head) {
		if (head == null || head.next == null)
			return head;

		Node pre = head;
		Node curr = head.next;
		while (curr != null) {
			Node temp = curr.next;
			curr.next = pre;
			pre = curr;
			curr = temp;
		} // end while
			// Sets head node's next
		head.next = null;
		return pre;
	}// end reverseOrder

}// end class ReorderList
