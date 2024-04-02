package module_12;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class PatternMatching {
	
	public static List<Integer> boyerMoore(CharSequence pattern, CharSequence text){
		List<Integer> foundIndx = new LinkedList<Integer>();
		
		Map<Character, Integer> last = buildLastTable(pattern);
		int n = text.length();
		int m = pattern.length();
		
		int i = 0;
		
		while(i <= n - m) {
			int j = m - 1;
			while(j >= 0 && pattern.charAt(j) == text.charAt(i + j)) {
				j--;
			}
			if(j < 0) {
				foundIndx.add(i);
				i++;
			} else {
				int shift = j - last.getOrDefault(text.charAt(i + j), -1);
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

}
