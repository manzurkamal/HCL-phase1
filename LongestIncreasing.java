package Projects;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class LongestIncreasing {
	
	public static void main(String[] args) {

		int n = 99;

		ArrayList<Integer> sequence = new ArrayList<Integer>();
		for (int i = 0; i < n; i++) {
			sequence.add(ThreadLocalRandom.current().nextInt(0, n + 1));
		}
		System.out.println("Sequence: " + "\n" + sequence);

		ArrayList<Integer> breakingPoints = new ArrayList<Integer>();
		breakingPoints.add(0);
		for (int i = 0; i < sequence.size() - 1; i++) {
			if (sequence.get(i) > sequence.get(i+1)) {
				breakingPoints.add(i);
			}
		}
		int longestSize = 0;
		int start = 0;
		int end = 0;

		for (int j = 0; j < breakingPoints.size(); j++) {
			if (j + 1 < breakingPoints.size()) {
				if (breakingPoints.get(j + 1) - breakingPoints.get(j) > longestSize) {
					longestSize = breakingPoints.get(j + 1) - breakingPoints.get(j);
					start = breakingPoints.get(j);
					end = breakingPoints.get(j + 1);
				}
			}
		}
		//LIS - Longest Increasing Subsequence
		System.out.println("Length of LIS: " + longestSize);
		List<Integer> result = sequence.subList(start+1, end+1); 
		System.out.println("LIS result: " + "\n" + result);
	}
}
