
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
 *  This solution was not accepted because it timed out.
 *  
 */
package org.dharmesh.leet;

public class PalindromicBruteForce {

	public boolean isPalindrome(String s) {
		int len = s.length();
		if (len == 1)
			return true;
		for (int i = 0; i < len / 2; i++) {
			int i2 = len - i - 1;
			char ch1 = s.charAt(i);
			char ch2 = s.charAt(i2);
			if (ch1 != ch2)
				return false;
		}
		return true;
	}

	public String longestPalindrome(String s) {
		String palindrome = "";
		int maxLen = 0;
		if (isPalindrome(s) || s.length() < 1) {
			return s;
		}
		for (int i = 0; i < s.length(); i++) {
			char cc = s.charAt(i);
			String potential = cc + "";
			for (int j = i; j < s.length(); j++) {
				if (cc == s.charAt(j)) {
					potential = s.substring(i, j + 1);
					// System.out.println("Checking potential: "+potential);
					if (isPalindrome(potential) && maxLen < potential.length()) {
						maxLen = potential.length();
						palindrome = potential;
					}
				}
			}
		}
		return palindrome;
	}

	public static void main(String[] args) {
		PalindromicBruteForce lp = new PalindromicBruteForce();
		String str = "civilwartestingwhetherthatnaptionoranynartionsoconceivedandsodedicatedcanlongendureWeareqmetonagreatbattlefiemldoftzhatwarWehavecometodedicpateaportionofthatfieldasafinalrestingplaceforthosewhoheregavetheirlivesthatthatnationmightliveItisaltogetherfangandproperthatweshoulddothisButinalargersensewecannotdedicatewecannotconsecratewecannothallowthisgroundThebravelmenlivinganddeadwhostruggledherehaveconsecrateditfaraboveourpoorponwertoaddordetractTgheworldadswfilllittlenotlenorlongrememberwhatwesayherebutitcanneverforgetwhattheydidhereItisforusthelivingrathertobededicatedheretotheulnfinishedworkwhichtheywhofoughtherehavethusfarsonoblyadvancedItisratherforustobeherededicatedtothegreattdafskremainingbeforeusthatfromthesehonoreddeadwetakeincreaseddevotiontothatcauseforwhichtheygavethelastpfullmeasureofdevotionthatweherehighlyresolvethatthesedeadshallnothavediedinvainthatthisnationunsderGodshallhaveanewbirthoffreedomandthatgovernmentofthepeoplebythepeopleforthepeopleshallnotperishfromtheearth";
		// System.out.println(str+" is palindrome? "+ lp.isPalindrome(str));
		long st = System.nanoTime();
		String p = lp.longestPalindrome(str);
		long et = System.nanoTime();
		long tt = et - st;
		System.out.println("compute time in ms: " + tt / 100);
		System.out.println("Longest palindrome: " + p);

	}

}
