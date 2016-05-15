package stringArray;

import java.util.HashMap;
import java.util.Map;

public class IsomorphicStrings {

	public static void main(String[] args) {
		String s = "fork", t = "soon";
		IsomorphicStrings string = new IsomorphicStrings();
		boolean r = string.isIsomorphic(s, t);

		System.out.printf("Are strings '%s' and '%s' isomorphic?: %s ", s, t, r == true ? "yes" : "no");

	}

	public boolean isIsomorphic(String s, String t) {
		if (s == null || t == null)// Checks that both 's't and 't' exist
			return false;
		if (s.length() != t.length())// Checks 's' and 't' are equal length
			return false;
		if (s.length() == 0 && t.length() == 0)
			// if both lengths are '0', then isomorphic
			return true;

		// Created HashMap with default initial capacity (16) and default load
		// factor(.75)
		HashMap<Character, Character> map = new HashMap<Character, Character>();

		for (int i = 0; i < s.length(); i++) {
			char c1 = s.charAt(i);// char at the current index in string 's'
			char c2 = t.charAt(i);// char at current index in string 't'
			System.out.printf("Char at %s in string '%s' is '%s'	", i, s, c1);
			System.out.printf("Char at %s in string '%s' is '%s'\n", i, t, c2);

			Character c = getKey(map, c2);
			System.out.printf("The key of Character '%s' is %s\n", c2, c);

			if (c != null && c != c1) {
				// if the index of char c2 from string 't' is not null and it doesn't equal
				// char c1 from string 's'
				return false;
			} else if (map.containsKey(c1)) {
				// map.get(c1) returns value to which char in string 's' is
				// mapped
				if (c2 != map.get(c1))
					// If the char c2 from string 't' is not equal to the value
					// at index c1 from string 's', then return false
					return false;
			} else {
				// Else puts the value of c2 from string 't' into the index
				// c1 from string 's'
				map.put(c1, c2);
				
				System.out.printf("The current HashMap is: %s\n", map.toString());
				// c1 = key and c2 = value, associates the two. If the table
				// previous contained a mapping for the key, the old value is
				// replaced
				
			} // end if-else if-else
		} // end for loop
		return true;
	}// end isIsomorphic

	/**
	 * Retrieves the key of a target value from the Hash table
	 * 
	 * @param map
	 *            - Hash table to look into
	 * @param target
	 *            - Value of key to be retrieved
	 * @return - Key of target value
	 */
	public Character getKey(HashMap<Character, Character> map, Character target) {
		for (Map.Entry<Character, Character> entry : map.entrySet()) {
			if (entry.getValue().equals(target))
				return entry.getKey();
		} // end for loop
		return null;
	}// end getKey

}
