package stringArray;

/**
 * PROBLEM: Given two strings where the first string may contain wild character
 * and the second string is a normal sting. Write a function that returns true
 * if the two strings match. The following are allowed wild card characters in
 * the first string:
 * 
 * '*' --> Matches with 0 or more instances of any char or set of chars
 * 
 * '?' --> Matches with any ONE char
 * 
 * i.e. 'g*ks' matches with 'geeks' and 'ge?ks*' matches with 'geeksforgeeks'
 * 
 * @author - Alina Rozenbaum Date: 3/13/2016
 *
 */
public class WildcardMatching {

	private String p;
	private String s;

	public static void main(String[] args) {

		WildcardMatching string = new WildcardMatching();
		string.run();
		
	}
	
	private void run(){
		s = "ge?ks*";
		p = "geeksforgeeks";

		boolean flag = isMatch(p, s);

		System.out.printf("Does '%s' match with '%s'?: %s ", p, s, flag == true ? "Yes" : "No");
	}

	/**
	 * Checks if the wild characters create a match between the two strings.
	 * 
	 * @param p
	 *            -- First string with wild chars
	 * @param s
	 *            -- Second normal string
	 * @return
	 */
	public boolean isMatch(String p, String s) {
		swap(p,s);
		
		int i = 0;
		int j = 0;
		int starIndex = -1;// index mark for '*'
		int iIndex = -1;// index mark for

		while (i < s.length()) {
			// If j < length of 'p' AND EITHER char at index j in 'p' OR char at
			// index j in 'p' is equal to char at index i in 's', go on to the
			// next chars in 'p' and 's'
			if (j < p.length() && (p.charAt(j) == '?' || p.charAt(j) == s.charAt(i))) {
				++i;
				++j;
			} else if (j < p.length() && p.charAt(j) == '*') {
				// Otherwise if j < length of 'p' AND the char at index j in 'p'
				// is equal to '*', amrk the index where '*' would be in 's'.
				// Increment j to next index in 'p'.
				starIndex = j;
				iIndex = i;
				j++;
			} else if (starIndex != -1) {
				// If we've found a '*' then pick up the index for 'p' from the
				// first index after the star index. Do the same for the
				// corresponding index in 's', then increment it.
				j = starIndex + 1;
				i = iIndex + 1;
				iIndex++;
			} else {
				return false;
			} // end if-else if-else if-else
		} // end while

		// If j < length of 'p' is equal to '*' increment j to the next
		// index
		while (j < p.length() && p.charAt(j) == '*') {
			++j;
		} // end while
		return j == p.length();
	}// end isMatch

	private void swap(String a, String b){
		
		boolean flagA = false, flagB = false;
		
		for(int i = 0; i<a.length(); i++ ){
			if(a.charAt(i) == '*' || a.charAt(i)== '?'){
				flagA = true;
				System.out.println("A is the special string");
			}
		}
		
		for(int i = 0; i<b.length();i++){
			if(b.charAt(i) == '*' || b.charAt(i)== '?'){
				flagB = true;
				System.out.println("B is the special string");
			}
		}
		
		if(flagA == flagB){
			System.out.println("The inputs are invalid");
			System.exit(0);
		}else if(flagA == true && flagB == false){
			System.out.println("Swap A and B");
			p = a;
			s = b;
		}else{
			System.out.println("Swap B and A");
			p = b;
			s = a;
		}
		
	}

}
