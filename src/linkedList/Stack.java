package linkedList;

/**
 * PROBLEM: Implement a stack using an array. The requirements of the stack are:
 * 1) it has a constructor which accepts a number to initialize its size, 2) the
 * stack can hold any type of element, 3) the stack has a push() and pop()
 * method
 * 
 * @author Alina Rozenbaum Date: 4/1/2016
 *
 * @param <E>
 *            -- Any type
 */
public class Stack<E> {

	private E[] arr = null;
	private int CAP, top = -1, size = 0;

	@SuppressWarnings("unchecked")

	public static void main(String[] args) {
		Stack<String> stack = new Stack<String>(11);
		stack.push("hello");
		stack.push("world");

		System.out.println(stack);

		stack.pop();
		System.out.println(stack);

		stack.pop();
		System.out.println(stack);

		Stack<Integer> age = new Stack<Integer>(10);
		age.push(5);
		age.push(100);
		age.push(27);
		System.out.println(age);

		age.pop();
		System.out.println(age);

		age.pop();
		System.out.println(age);

	}// end main

	/**
	 * Constructor for the stack
	 * 
	 * @param cap
	 *            -- Maximum elements allowed in the stack
	 */
	protected Stack(int cap) {
		this.CAP = cap;
		this.arr = (E[]) new Object[cap];
	}// end constructor

	/**
	 * Removes the top element from the stack
	 * 
	 * @return -- The removed element
	 */
	protected E pop() {
		if (this.size == 0)
			return null;
		this.size--;
		E result = this.arr[top];
		this.arr[top] = null;
		this.top--;
		return result;
	}// end pop

	/**
	 * Pushes an element to the top of the stack
	 * 
	 * @param e
	 *            -- The element to push onto the stack
	 */
	protected void push(E e) {
		if (isFull())
			return;
		this.size++;
		this.arr[++top] = e;
	}// end push

	/**
	 * Checks if the array is full or not
	 * 
	 * @return --True if full, false if not
	 */
	protected boolean isFull() {
		if (this.size == this.CAP)
			return true;
		return false;
	}// end isFull

	/**
	 * Overwrites print method to be able to print the stack
	 */
	public String toString() {
		if (this.size == 0)
			return null;
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < this.size; i++)
			sb.append(this.arr[i] + ", ");
		sb.setLength(sb.length() - 2);
		return sb.toString();
	}// end toString

}// end class Stack<E>
