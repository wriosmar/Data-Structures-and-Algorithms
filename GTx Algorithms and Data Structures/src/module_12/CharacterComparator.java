package module_12;

import java.util.Comparator;

public class CharacterComparator implements Comparator<Character> {
	
	private int comparisonCount;

	@Override
	public int compare(Character a, Character b) {
		comparisonCount++;
		return a - b;
	}
	
	public int getComparisonCount() {
		return comparisonCount;
	}

}
