/**
 * You are given two non-empty linked lists representing two non-negative integers. 
 * The digits are stored in reverse order and each of their nodes contain a single digit.
 * Add the two numbers and return it as a linked list.
 *  
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 * 
 * Example:
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 * Explanation: 342 + 465 = 807.
 */

package org.dharmesh.leet;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

public class ListNodeWithBigInt {
	int val;
	ListNodeWithBigInt next;

	ListNodeWithBigInt(int x) {
		this.val = x;
	}

	// private static ArrayList<Integer> toList(ListNode l){
	// ArrayList<Integer> list = new ArrayList<>();
	// while(l.next !=null){
	// list.add(l.val);
	// l=l.next;
	// }
	// list.add(l.val);
	// list.trimToSize();
	// return list;
	// }

	public String toString() {
		StringBuffer ll = new StringBuffer();
		ListNodeWithBigInt ln = this;
		while (ln != null) {
			ll.append(ln.val);
			if (ln.next != null)
				ll.append(" -> ");
			ln = ln.next;
		}
		return ll.toString();
	}

	private static Map<Integer, Integer> toMap(ListNodeWithBigInt aList) {
		Map<Integer, Integer> map = new HashMap<>();
		ListNodeWithBigInt ln = aList;
		int i = 0;
		while (ln != null) {
			map.put(i, ln.val);
			ln = ln.next;
			i = i + 1;
		}
		return map;
	}

	public static ListNodeWithBigInt addTwoNumbers(ListNodeWithBigInt l1,
			ListNodeWithBigInt l2) {
		ListNodeWithBigInt result = null;
		Map<Integer, Integer> map1 = toMap(l1);
		Map<Integer, Integer> map2 = toMap(l2);
		StringBuffer str1 = new StringBuffer();
		for (int i = map1.size() - 1; i >= 0; i--) {
			int val = (int) (map1.get(i));
			str1.append(val);
		}
		str1.trimToSize();
		// System.out.println("number 1:"+str1.toString());
		BigInteger num1 = new BigInteger(str1.toString());

		StringBuffer str2 = new StringBuffer();
		for (int i = map2.size() - 1; i >= 0; i--) {
			int val = (int) (map2.get(i));
			str2.append(val);
		}
		// System.out.println("number 2:"+str2.toString());
		str2.trimToSize();
		BigInteger num2 = new BigInteger(str2.toString());

		BigInteger sum = num1.add(num2);
		StringBuffer sumStr = new StringBuffer(String.valueOf(sum));
		sumStr.reverse();
		String sumString = sumStr.toString();
		Map<Integer, ListNodeWithBigInt> map = new HashMap<>();
		for (int i = 0; i < sumString.length(); i++) {
			String val = sumString.substring(i, i + 1);
			map.put(i, new ListNodeWithBigInt(Integer.parseInt(val)));
		}

		for (int z = 0; z < map.size(); z++) {
			if (z == 0) {
				result = map.get(0);
				result.next = null;
			} else {
				map.get(z - 1).next = map.get(z);
			}
		}
		return result;

	}

	public static void main(String[] args) {
		ListNodeWithBigInt one = new ListNodeWithBigInt(9);
		one.next = new ListNodeWithBigInt(9);
		one.next.next = new ListNodeWithBigInt(9);
		one.next.next.next = new ListNodeWithBigInt(9);
		one.next.next.next.next = new ListNodeWithBigInt(9);
		one.next.next.next.next.next = new ListNodeWithBigInt(9);
		one.next.next.next.next.next.next = new ListNodeWithBigInt(9);
		one.next.next.next.next.next.next.next = new ListNodeWithBigInt(9);
		one.next.next.next.next.next.next.next.next = new ListNodeWithBigInt(9);
		one.next.next.next.next.next.next.next.next.next = new ListNodeWithBigInt(
				9);
		System.out.println(one.toString());
		System.out.println("+");
		ListNodeWithBigInt two = new ListNodeWithBigInt(9);
		two.next = new ListNodeWithBigInt(9);
		two.next.next = new ListNodeWithBigInt(9);
		two.next.next.next = new ListNodeWithBigInt(9);
		two.next.next.next.next = new ListNodeWithBigInt(9);
		two.next.next.next.next.next = new ListNodeWithBigInt(9);
		two.next.next.next.next.next.next = new ListNodeWithBigInt(9);
		two.next.next.next.next.next.next.next = new ListNodeWithBigInt(9);
		two.next.next.next.next.next.next.next.next = new ListNodeWithBigInt(9);
		two.next.next.next.next.next.next.next.next.next = new ListNodeWithBigInt(
				9);
		System.out.println(two.toString());
		System.out.println("=");
		ListNodeWithBigInt result = addTwoNumbers(one, two);
		System.out.println(result.toString());

	}

}
