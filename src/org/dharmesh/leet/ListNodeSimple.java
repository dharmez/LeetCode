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

public class ListNodeSimple {

	class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			this.val = x;
		}

		public String toString() {
			StringBuffer ll = new StringBuffer();
			ListNode ln = this;
			while (ln != null) {
				ll.append(ln.val);
				if (ln.next != null)
					ll.append(" -> ");
				ln = ln.next;
			}
			return ll.toString();
		}
	}

	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode dummyHead = new ListNode(0);
		ListNode p = l1, q = l2, curr = dummyHead;
		int carry = 0;
		while (p != null || q != null) {
			int x = (p != null) ? p.val : 0;
			int y = (q != null) ? q.val : 0;
			int sum = carry + x + y;
			carry = sum / 10;
			curr.next = new ListNode(sum % 10);
			curr = curr.next;
			if (p != null)
				p = p.next;
			if (q != null)
				q = q.next;
		}
		if (carry > 0) {
			curr.next = new ListNode(carry);
		}
		return dummyHead.next;
	}

	public static void main(String[] args) {
		ListNodeSimple lns = new ListNodeSimple();
		ListNode one = lns.new ListNode(9);
		one.next = lns.new ListNode(9);
		one.next.next = lns.new ListNode(9);
		one.next.next.next = lns.new ListNode(9);
		one.next.next.next.next = lns.new ListNode(9);
		one.next.next.next.next.next = lns.new ListNode(9);
		one.next.next.next.next.next.next = lns.new ListNode(9);
		one.next.next.next.next.next.next.next = lns.new ListNode(9);
		one.next.next.next.next.next.next.next.next = lns.new ListNode(9);
		one.next.next.next.next.next.next.next.next.next = lns.new ListNode(9);
		System.out.println(one.toString());
		System.out.println("+");
		ListNode two = lns.new ListNode(9);
		two.next = lns.new ListNode(9);
		two.next.next = lns.new ListNode(9);
		two.next.next.next = lns.new ListNode(9);
		two.next.next.next.next = lns.new ListNode(9);
		two.next.next.next.next.next = lns.new ListNode(9);
		two.next.next.next.next.next.next = lns.new ListNode(9);
		two.next.next.next.next.next.next.next = lns.new ListNode(9);
		two.next.next.next.next.next.next.next.next = lns.new ListNode(9);
		two.next.next.next.next.next.next.next.next.next = lns.new ListNode(9);
		System.out.println(two.toString());
		System.out.println("=");
		ListNode result = lns.addTwoNumbers(one, two);
		System.out.println(result.toString());

	}

}
