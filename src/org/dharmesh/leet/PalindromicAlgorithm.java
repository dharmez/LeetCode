
/*
 * Given a string s, find the longest palindromic substring in s. 
 * You may assume that the maximum length of s is 1000.
 * Example:
 * 	Input: "babad"
 *  Output: "bab"
 *  Note: "aba" is also a valid answer.
 * Example:
 * 	Input: "cbbd"
 *  Output: "bb"
 *  
 *  This solution was accepted.
 *  This class implement Manacher's Algorithm http://articles.leetcode.com/longest-palindromic-substring-part-ii/
 */
package org.dharmesh.leet;

public class PalindromicAlgorithm {

	private String preProcess(String s) {
		int n = s.length();
		if (n == 0)
			return "^$";
		String ret = "^";
		for (int i = 0; i < n; i++)
			ret += "#" + s.substring(i, i + 1);

		ret += "#$";
		return ret;
	}

	public String longestPalindrome(String s) {
		String T = preProcess(s);
		int n = T.length();
		int[] P = new int[n];
		int C = 0, R = 0;
		for (int i = 1; i < n - 1; i++) {
			int i_mirror = 2 * C - i; // equals to i' = C - (i-C)

			P[i] = (R > i) ? Math.min(R - i, P[i_mirror]) : 0;

			// Attempt to expand palindrome centered at i
			while (T.charAt(i + 1 + P[i]) == T.charAt(i - 1 - P[i]))
				P[i]++;

			// If palindrome centered at i expand past R,
			// adjust center based on expanded palindrome.
			if (i + P[i] > R) {
				C = i;
				R = i + P[i];
			}
		}

		// Find the maximum element in P.
		int maxLen = 0;
		int centerIndex = 0;
		for (int i = 1; i < n - 1; i++) {
			if (P[i] > maxLen) {
				maxLen = P[i];
				centerIndex = i;
			}
		}
		P = null;
		int i1 = (centerIndex - 1 - maxLen) / 2;
		int i2 = maxLen;
		return s.substring(i1,i1+i2);
	}

	public static void main(String[] args) {
		PalindromicAlgorithm lp = new PalindromicAlgorithm();
		//String str = "civilwartestingwhetherthatnaptionoranynartionsoconceivedandsodedicatedcanlongendureWeareqmetonagreatbattlefiemldoftzhatwarWehavecometodedicpateaportionofthatfieldasafinalrestingplaceforthosewhoheregavetheirlivesthatthatnationmightliveItisaltogetherfangandproperthatweshoulddothisButinalargersensewecannotdedicatewecannotconsecratewecannothallowthisgroundThebravelmenlivinganddeadwhostruggledherehaveconsecrateditfaraboveourpoorponwertoaddordetractTgheworldadswfilllittlenotlenorlongrememberwhatwesayherebutitcanneverforgetwhattheydidhereItisforusthelivingrathertobededicatedheretotheulnfinishedworkwhichtheywhofoughtherehavethusfarsonoblyadvancedItisratherforustobeherededicatedtothegreattdafskremainingbeforeusthatfromthesehonoreddeadwetakeincreaseddevotiontothatcauseforwhichtheygavethelastpfullmeasureofdevotionthatweherehighlyresolvethatthesedeadshallnothavediedinvainthatthisnationunsderGodshallhaveanewbirthoffreedomandthatgovernmentofthepeoplebythepeopleforthepeopleshallnotperishfromtheearth";
		String str = "sosachihcas";
		
		//String str = "hello";
		// System.out.println(str+" is palindrome? "+ lp.isPalindrome(str));
		long st = System.nanoTime();
		String p = lp.longestPalindrome(str);
		long et = System.nanoTime();
		long tt = et - st;
		System.out.println("compute time in ms: " + tt / 100);
		System.out.println("Longest palindrome: " + p);
	}
}
