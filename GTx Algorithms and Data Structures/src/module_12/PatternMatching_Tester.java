package module_12;

import java.util.List;

public class PatternMatching_Tester {

	public static void main(String[] args) {
		String text = "I am Willy and this is a test for patterns.";
		String pattern = " ";
		
		List<Integer> results = PatternMatching.rabinKarp(pattern, text);
		
		// print(results);
		
		String patt = "AABAAACABAABBCAABA";
		int[] patternF = PatternMatching.buildFailureTable(patt);
		
		for(int i = 0; i < patternF.length; i++) {
			System.out.print(patternF[i] + " ");
		}
	}
	
	public static void print(List<Integer> list) {
		System.out.print("Pattern found in indices: ");
		int check = 0;
		
		for(Integer indx : list) {
			if(check == list.size() - 1) {
				System.out.print(indx);
			} else {
				System.out.print(indx + ",");
			}
			check++;
		}
	}

}
