package org.dharmesh.leet;

import java.util.HashSet;
import java.util.Set;

public class FindFactors {

	public static int[] findFactors(int n, int[] b) {
		int[] factors = {-1,-1};
		if (b != null && b.length > 1) {
			Set<Integer> visitedNums = new HashSet<>();
			for (int i = 0; i < b.length; i++) {
				if (b[i] == 0 && n == 0) {
					int j = i >0 ? i-1 : i + 1;
					return new int[] { b[i], b[j] };
				} else if (b[i] != 0) {
					int a = n % b[i];
					int fb = n / b[i];
					if (a == 0 && visitedNums.contains(fb)) {
						return new int[] { b[i], fb };
					}
				}
				visitedNums.add(b[i]);
			}
			return factors;
		}
		throw new RuntimeException("Invalid input to 'findFactors()'");
	}

	public static void main(String[] args) {
		int[] b = {1, 0};
		int[] result = findFactors(1, b);
		System.out.println(result[0] + " " + result[1]);

	}

}
