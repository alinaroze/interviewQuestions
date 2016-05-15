package stringArray;

import java.util.Stack;

/**
 * PROBLEM: Evaluate the value of arithmetic expression in Postfix Notation.
 * Valid operators are +, -, *, /. Each operand may be an integer or another
 * expressions. For example:
 * 
 * ["2","1","+","3","*"]-> ((2+1)*3)-> 9 
 * ["4","13","5","/","+"]-> (4+(13/5))-> 6
 * 
 * @author - Alina Rozenbaum 
 * Date: 01/22/2016
 *
 */

public class PostfixNotation {

	public static void main(String[] args) {
		String[] equation = new String[] { "2", "1", "+", "3", "*" };
		PostfixNotation eq = new PostfixNotation();

		System.out.println(eq.evalPostfix(equation));
		System.out.println(eq.evalPostfix2(equation));
	}

	/**
	 * SOLUTION 1: Naive Approach
	 * 
	 * This problem can be solved using a stack. We can loop through each elt in
	 * the given array. When it is a number, push it to the stack. When it is
	 * and operator, pop two numbers, do the stack. When it is an operator, pop
	 * two numbers, do the calculation, and push back the result.
	 * 
	 * @param tokens
	 *            - The equation to be solved
	 * @return - The answer to the equation
	 */
	public int evalPostfix(String[] tokens) {
		int returnVal = 0;
		String operators = "+-*/";
		Stack<String> stack = new Stack<String>();

		for (String t : tokens) {
			if (!operators.contains(t)) {
				stack.push(t);
			} else {
				int a = Integer.valueOf(stack.pop());
				int b = Integer.valueOf(stack.pop());
				switch (t) {
				case "+":
					stack.push(String.valueOf(a + b));
					break;
				case "-":
					stack.push(String.valueOf(b - a));
					break;
				case "*":
					stack.push(String.valueOf(a * b));
					break;
				case "/":
					stack.push(String.valueOf(b / a));
					break;
				}// end switch
			} // end if-else
		} // end for loop

		returnVal = Integer.valueOf(stack.pop());
		return returnVal;
	}// end evalPostfix

	/**
	 * SOLUTION 2: Accepted Solution
	 * 
	 * If you want to use switch statement, you can convert the above by using
	 * the following code which uses the index of a string " + - * /". *
	 * 
	 * @param tokens
	 *            - The equation to be solved
	 * @return - The answer to the equation
	 */
	public int evalPostfix2(String[] tokens) {
		int returnVal = 0;
		String operators = "+-*/";
		Stack<String> stack = new Stack<String>();

		for (String t : tokens) {
			if (!operators.contains(t)) {
				stack.push(t);
			} else {
				int a = Integer.valueOf(stack.pop());
				int b = Integer.valueOf(stack.pop());
				int indx = operators.indexOf(t);
				switch (indx) {
				case 0:
					stack.push(String.valueOf(a + b));
					break;
				case 1:
					stack.push(String.valueOf(b - a));
					break;
				case 2:
					stack.push(String.valueOf(a * b));
					break;
				case 3:
					stack.push(String.valueOf(b / a));
					break;
				}// end switch
			} // end if-else
		} // end for loop

		returnVal = Integer.valueOf(stack.pop());
		return returnVal;
	}// end evalPostfix2

}// end class PostfixNotation
