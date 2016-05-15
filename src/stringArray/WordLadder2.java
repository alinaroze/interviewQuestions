package stringArray;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * PROBLEM: Given two words (start and end) and a dictionary, find ALL shortest
 * transformation sequence(s) from start to end, such that: 1) only one letter
 * can changed at a time, 2) each intermediate word must exist in the
 * dictionary. For example, given: start = "hit", end = "cog", and dict =
 * ["hot","dot","dog","lot","log"], return:
 * 
 * [ ["hit","hot","dot","dog","cog"], ["hit","hot","lot","log","cog"] ]
 * 
 * @author -- Alina Rozenbaum Date: February 1, 2016
 *
 */
public class WordLadder2 {

	public static void main(String[] args) {
		WordLadder2 ladder = new WordLadder2();
		String begin = "hit";
		String end = "cog";
		String[] dict = new String[] { "hot", "dot", "dog", "lot", "log" };
		Set<String> dictionary = new HashSet<String>(Arrays.asList(dict));

		List<List<String>> ladders = ladder.findLadders(begin, end, dictionary);

		System.out.printf("The following is all the possible answers for '%s' to '%s': %s ", begin, end, ladders);

	}

	/**
	 * SOLUTION: This is an extension of WordLadder. The idea id the same. To
	 * track the actual ladder, we need to add a pointer that points to the
	 * previous node in the WordNode class. In addition, the used word can not
	 * be directly removed from the dictionary. The used word is only removed
	 * when steps change.
	 * 
	 * @param start
	 *            -- The first word (the one to be manipulated)
	 * @param end
	 *            -- The target word to change the begWord to
	 * @param dict
	 *            -- Dictionary of possible words/iterations to be used
	 * @return -- Returns the list of word lists of the various solutions
	 */
	public List<List<String>> findLadders(String start, String end, Set<String> dict) {

		// List of lists that holds the answer
		List<List<String>> result = new ArrayList<List<String>>();
		// Linked list of WordNodes
		LinkedList<WordNode> list = new LinkedList<WordNode>();

		list.add(new WordNode(start, 1, null));// Adds to the end

		dict.add(end);// Adds the goal word to the dictionary
		int minStep = 0;

		// All visited words in dictionary
		HashSet<String> visited = new HashSet<String>();
		// All unvisited words in the dictionary
		HashSet<String> unvisited = new HashSet<String>();
		// All words in dictionary are intalized to unvisited
		unvisited.addAll(dict);

		// Number of steps from previous loop through
		int preNumSteps = 0;

		while (!list.isEmpty()) {// While Linked list is NOT empty
			WordNode top = list.remove();// Retrieves and removes the head elt
			String word = top.word;// Retrieves 'word' attribute from WordNode
			// The current number of steps is retrieved from the top/head
			// WordNode
			int currNumSteps = top.numSteps;

			if (word.equals(end)) {
				// If the current word is the same as the goal word and the min
				// steps is 0, set minStep to the current number of steps
				if (minStep == 0)
					minStep = top.numSteps;

				// However if the min and current num of steps is the same and
				// NOT 0...
				if (top.numSteps == minStep && minStep != 0) {
					// Create dynamic array t
					ArrayList<String> t = new ArrayList<String>();
					t.add(top.word);// Add current word
					// While previous WordNode exists
					while (top.previous != null) {
						// Then add its word to the start of the array
						t.add(0, top.previous.word);
						// Now the top/current is the previous WordNode...shifts
						// the head pointer
						top = top.previous;
					} // end while
						// Adds the array of words to the result to be returned
						// as
						// one of the possible answers
					result.add(t);
					continue;
				} // end if
			} // end if

			// If the num of steps from the prev loop through is less than
			// the num of steps from the current loop through...
			if (preNumSteps < currNumSteps)
				// Remove all words in the visited list from the unvisited list
				unvisited.removeAll(visited);

			// Change the prev to the current
			preNumSteps = currNumSteps;

			// Split current word in to chars
			char[] arr = word.toCharArray();
			// Loop through its chars
			for (int i = 0; i < arr.length; i++) {
				// Loop through alphabet
				for (char c = 'a'; c <= 'z'; c++) {
					// Set char in current position to temp var
					char temp = arr[i];
					// Check is the same as current letter of alphabet, if not
					// change it so it is
					if (arr[i] != c)
						arr[i] = c;

					// Change it back to a string
					String newWord = new String(arr);
					// If the current new word has yet to be visited, add it to
					// the linked list
					if (unvisited.contains(newWord)) {
						list.add(new WordNode(newWord, top.numSteps + 1, top));
						visited.add(newWord);
					} // end if
					arr[i] = temp;// Change the char back to the original
				} // end for loop through the alphabet
			} // end for loop through the current word
		} // end while
		return result;
	}// end findLadders
}// end class WordLadder2
