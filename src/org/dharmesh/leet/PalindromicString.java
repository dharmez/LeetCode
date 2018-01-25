package org.dharmesh.leet;

public class PalindromicString {
	private String longestPalindrome(String s) {
		if(s==null || s.length()<=0) return s;
		int maxStartIndex = 0, maxEndIndex = 0;
		boolean[][] isPalindrome = new boolean[s.length()][s.length()];
		for (int len = 1; len <= s.length(); len++) {
			for (int startIndex = 0; startIndex <= s.length() - len; startIndex++) {
				int endIndex = startIndex + len - 1;
				if (len == 1) {
					isPalindrome[startIndex][endIndex] = true;
				} else if (s.charAt(startIndex) == s.charAt(endIndex)) { 
					// len >= 2 && startChar == endChar
					isPalindrome[startIndex][endIndex] = len == 2 || isPalindrome[startIndex + 1][endIndex - 1];
				} else {
					isPalindrome[startIndex][endIndex] = false;
				}

				if (isPalindrome[startIndex][endIndex] && len > (maxEndIndex - maxStartIndex + 1)) {
					maxStartIndex = startIndex;
					maxEndIndex = endIndex;
				}
			}
		}
		return s.substring(maxStartIndex, maxEndIndex + 1);
	}
	
	public static void main(String[] args) {
		PalindromicString lp = new PalindromicString();
		//String str = "civilwartestingwhetherthatnaptionoranynartionsoconceivedandsodedicatedcanlongendureWeareqmetonagreatbattlefiemldoftzhatwarWehavecometodedicpateaportionofthatfieldasafinalrestingplaceforthosewhoheregavetheirlivesthatthatnationmightliveItisaltogetherfangandproperthatweshoulddothisButinalargersensewecannotdedicatewecannotconsecratewecannothallowthisgroundThebravelmenlivinganddeadwhostruggledherehaveconsecrateditfaraboveourpoorponwertoaddordetractTgheworldadswfilllittlenotlenorlongrememberwhatwesayherebutitcanneverforgetwhattheydidhereItisforusthelivingrathertobededicatedheretotheulnfinishedworkwhichtheywhofoughtherehavethusfarsonoblyadvancedItisratherforustobeherededicatedtothegreattdafskremainingbeforeusthatfromthesehonoreddeadwetakeincreaseddevotiontothatcauseforwhichtheygavethelastpfullmeasureofdevotionthatweherehighlyresolvethatthesedeadshallnothavediedinvainthatthisnationunsderGodshallhaveanewbirthoffreedomandthatgovernmentofthepeoplebythepeopleforthepeopleshallnotperishfromtheearth";
		//String str = "";
		//String str = null;
		String str = "lolaabbalolxa";
		long st = System.nanoTime();
		String p = lp.longestPalindrome(str);
		long et = System.nanoTime();
		long tt = et - st;
		System.out.println("compute time in ms: " + tt / 100);
		System.out.println("Longest palindrome: " + p);

	}
}
