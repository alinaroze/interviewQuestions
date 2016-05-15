package linkedList;

/**
 * PROBLEM: A linked list is given such that each node contains an additional
 * random pointer which would point to any node in the list or null. Return a
 * deep copy of the list.
 * 
 * SOLUTION: We can solve by doing the following steps: 1. Copy every node,
 * i.e., duplicate every node, and insert it into the list. 2. Copy random
 * pointers for all newly created nodes. 3. Break the list in two.
 * 
 * Can also use a HashMap (simpler)
 * 
 * @author Alina Rozenbaum Date: 4/27/2016
 *
 */
public class CopyRandomList {

	public static void main(String[] args) {
		CopyRandomList program = new CopyRandomList();
		program.run();

	}// end main

	protected void run() {
		QueueLinkedList list = new QueueLinkedList();
		list.enqueue(new Node(1));
		list.enqueue(new Node(2));
		list.enqueue(new Node(3));
		list.enqueue(new Node(4));
		list.enqueue(new Node(5));

		Node head = list.peek();
		head.random = head.next.next;
		head.next.random = head.next.next.next.next;
		head.next.next.random = head.next;
		head.next.next.next.random = head.next;
		head.next.next.next.next.random = head.next.next;

		System.out.println("The original list: ");
		printRandom(head);
		System.out.println("The deep copy of the list: ");
		printRandom(copyRandomList(head));

	}// end run

	/**
	 * Prints all data in linked list, including all random pointers
	 * 
	 * @param head
	 *            - The list to be printed
	 */
	protected void printRandom(Node head) {

		Node temp = head;
		while (temp != null) {
			Node random = temp.random;
			int randomData = (random != null) ? random.val : -1;
			System.out.println("Data = " + temp.val + ", Random data = " + randomData);
			temp = temp.next;
		} // end while

	}// end printRandom

	/**
	 * Copies nodes, inserts into the existing linked list, copies all random
	 * pointers from the original and finally breaks the two lists apart.
	 * 
	 * @param head
	 *            - The original list with random pointers to be copied
	 * @return - The deep copy of list with same random pointers.
	 */
	protected Node copyRandomList(Node head) {
		if (head == null)
			return head;
		Node p = head;
		// Copy every node and insert into list
		while (p != null) {
			// Create new node with same data as p (deep copy)
			Node copy = new Node(p.val);
			copy.next = p.next; // Point new node to next original node
			p.next = copy; // Point p to new node
			p = copy.next; // Move p pointer to next original node
		} // end while

		// Copy random pointer for each new node
		p = head; // Bring p back to the front
		while (p != null) {
			if (p.random != null)
				// Make random pointer of copy of p and go to copy of p.random
				p.next.random = p.random.next;
			p = p.next.next; // Move pointer to next original node
		} // end while

		// Break list into two (the copy and the original)
		p = head; // Bring p back to the front
		Node newHead = head.next;
		while (p != null) {
			Node temp = p.next; // Create pointer to copy of p
			p.next = temp.next; // Connect p to the next original node
			if (temp.next != null)
				temp.next = temp.next.next; // Connect copy of p to the next
											// copied node
			p = p.next; // Move p pointer to the next original node
		} // end while
		return newHead;// returns the copy
	}// end copyRandomList
}// end class CopyRandomList
