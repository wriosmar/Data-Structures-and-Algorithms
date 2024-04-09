package module_12;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class PatternMatching {
	
	public static List<Integer> boyerMoore(CharSequence pattern, CharSequence text){
		// List to be returned. 
		List<Integer> foundIndx = new LinkedList<Integer>();
		
		// Last Table
		Map<Character, Integer> last = buildLastTable(pattern);
		int n = text.length();
		int m = pattern.length();
		
		int i = 0;
		
		while(i <= n - m) {
			int j = m - 1;
			while(j >= 0 && pattern.charAt(j) == text.charAt(i + j)) {
				j--;
			}
			if(j == -1) {
				foundIndx.add(i);
				i++;
			} else {
				int shift = last.getOrDefault(text.charAt(i + j), -1);
				if(shift < j) {
					i = i + j - shift;
				} else {
					i = i + 1;
				}
			}
		}
		
		return foundIndx;
	}
	
	// Homework assignment. Uses Homework formatting. 
	public static List<Integer> boyerMoore(CharSequence pattern, CharSequence text, CharacterComparator comparator) {
		List<Integer> foundIndx = new LinkedList<Integer>();
		
		Map<Character, Integer> last = buildLastTable(pattern);
		int n = text.length();
		int m = pattern.length();
		
		int i = 0;
		
		while(i <= n - m) {
			int j = m - 1;
			while(j >= 0 && comparator.compare(pattern.charAt(j), text.charAt(i + j)) == 0) {
				j--;
			}
			if(j == -1) {
				foundIndx.add(i);
				i++;
			} else {
				int shift = last.getOrDefault(text.charAt(i + j), -1);
				if(shift < j) {
					i = i + j - shift;
				} else {
					i = i + 1;
				}
			}
		}
		
		return foundIndx;
	}
	
	public static Map<Character, Integer> buildLastTable(CharSequence pattern) {
		int m = pattern.length();
		
		HashMap<Character, Integer> last = new HashMap<Character, Integer>();
		
		for(int i = 0; i < m; i++) {
			last.put(pattern.charAt(i), i);
		}
		
		return last;
	}
	
	public static List<Integer> knuthMorrisPratt(CharSequence pattern, CharSequence text) {
		
		return null;
	}
	
	public static Map<Character, Integer> buildFailureTable(CharSequence text) {
		
		return null;
	}
	
	public static List<Integer> rabinKarp(CharSequence pattern, CharSequence text) {
		// List to be returned.
		List<Integer> foundIndx = new LinkedList<Integer>();
		
		int BASE = 1;
		int n = text.length();
		int m = pattern.length();
		
		int patternHash = createHash(pattern, BASE);
		int mTextHash = createHash(text.subSequence(0, m), BASE);
		
		for(int i = 0; i <= n - m; i++) {
			if(mTextHash != patternHash && i < n - m) {
				// update rolling Hash.
				mTextHash = rollingHash(text, i, i + m, mTextHash, m, BASE);
			} else {
				// compare m text to pattern
				if(isEqual(pattern, text.subSequence(i, i + m))) {
					foundIndx.add(i);
				}
			}
		}
		
		return foundIndx;
	}
	
	public static int createHash(CharSequence pattern, int BASE) {
		int hash = 0;
		
		for(int i = 0; i < pattern.length(); i++) {
			hash += pattern.charAt(i) * Math.pow(BASE, i);
		}
		
		return hash;
	}
	
	public static int rollingHash(CharSequence text, int oldIndx, int newIndx, int oldHash, int m, int BASE) {
		int newHash = (int) ((oldHash - text.charAt(oldIndx) * Math.pow(BASE, m - 1)) * BASE + text.charAt(newIndx));
		
		return newHash;
	}
	
	public static boolean isEqual(CharSequence char1, CharSequence char2) {
		for(int i = 0; i < char1.length(); i++) {
			if(char1.charAt(i) != char2.charAt(i)) {
				return false;
			}
		}
		return true;
	}

}
