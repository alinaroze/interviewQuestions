package stringArray;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

/**
 * PROBLEM: Given two words (start and end/target), and a dictionary, find the
 * length of the shortest transformation sequence from start to end, such that
 * only one letter can be changed at a time and each intermediate word must
 * exist in the dictionary For example, given:
 * 
 * start = "hit" end = "cog" dict=["hot","dot","dog","lot","log"]
 * 
 * One shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog". 
 * The program should return its length (5).
 * 
 * @author -- Alina Rozenbaum
 * Date: January, 29, 2016
 *
 */
public class WordLadder {

	public static void main(String[] args) {
		WordLadder ladder = new WordLadder();
		String begin = "hit";
		String end = "cog";
		String[] dict = new String[] { "hot", "dot", "dog", "lot", "log" };
		Set<String> dictionary = new HashSet<String>(Arrays.asList(dict));

		int stepNum = ladder.ladderLength(begin, end, dictionary);

		System.out.printf("The number of steps from '%s' to '%s' is %s ", begin, end, stepNum);

	}

	/**
	 * Algorithm to find the ladder length of the iteration from the first word
	 * through to the target word
	 * 
	 * @param begWord
	 *            -- The first word (the one to be manipulated)
	 * @param endWord
	 *            -- The target word to change the begWord to
	 * @param wordDict
	 *            -- Dictionary of possible words/iterations to be used
	 * @return -- The number of iterations it took to reach the endWord
	 */
	public int ladderLength(String begWord, String endWord, Set<String> wordDict) {
		// Linked list made up of word nodes
		LinkedList<WordNode> list = new LinkedList<WordNode>();
		list.add(new WordNode(begWord, 1));// Add the first word to the list
		wordDict.add(endWord);// Add the target word to the dictionary

		while (!list.isEmpty()) {// While the list is NOT empty
			WordNode top = list.remove();// Retrieves and removes the head elt
			String word = top.word;

			// If the word is the same as the final result, return the number of
			// steps attached to the current head
			if (word.equals(endWord))
				return top.numSteps;

			char[] arr = word.toCharArray();// Split the word/string into chars
			for (int i = 0; i < arr.length; i++) {// Got through every char
				// Check char at pos i against ever char in the alphabet
				for (char c = 'a'; c <= 'z'; c++) {
					char temp = arr[i];// Save char at pos i in temp var
					// If not the same as the char checked against change it
					if (arr[i] != c) {
						arr[i] = c;
					} // end if

					// Change the array of chars back into a string
					String newWord = new String(arr);
					if (wordDict.contains(newWord)) {
						// If the word is in the 'dictionary' add it to the list
						// of iterations and remove it from the dictionary so
						// you don't accidentally use it again
						list.add(new WordNode(newWord, top.numSteps + 1));
						wordDict.remove(newWord);
					} // end if
					arr[i] = temp;// Change char back to the original
				} // end for loop (through a-z)
			} // end for loop (through char array)
		} // end while loop
			// If no solution was found
		return 0;
	}// end ladderLength

}// end class WordLadder
