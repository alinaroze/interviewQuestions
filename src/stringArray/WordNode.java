package stringArray;

public class WordNode {
	String word;
	int numSteps;
	WordNode previous;

	/**
	 * Constructor for the WordNode
	 * 
	 * @param word
	 *            -- Word attached to the node
	 * @param numSteps
	 *            -- Number of iterations attached to the word
	 */
	public WordNode(String word, int numSteps) {
		this.word = word;
		this.numSteps = numSteps;
	}
	
	public WordNode(String word, int numSteps, WordNode previous) {
		this.word = word;
		this.numSteps = numSteps;
		this.previous = previous;
	}
}
