package com.learning.patterns.linear.fastslowpointers;

import com.learning.model.Node;
import com.learning.utils.LinkedListHelper;

/**
 * Checks whether a singly linked list is a palindrome using the fast-and-slow
 * pointer technique and in-place reversal of the second half.
 *
 * <p>Algorithm summary:
 * <ul>
 *   <li>Use fast/slow pointers to find the list middle.</li>
 *   <li>Reverse the second half of the list in-place.</li>
 *   <li>Compare the first half and the reversed second half node-by-node.</li>
 *   <li>Restore the list to its original order.</li>
 * </ul>
 *
 * Time complexity: O(n).
 * Space complexity: O(1).
 */
public class PalindromeLinkedList {

	/**
	 * Returns {@code true} if the list is a palindrome (reads the same forwards
	 * and backwards). An empty list is considered a palindrome. This method
	 * runs in O(n) time and uses O(1) extra space by reversing the second half
	 * of the list in-place.
	 *
	 * @param head the head of the singly linked list; may be {@code null}
	 * @return {@code true} if the list is a palindrome, otherwise {@code false}
	 */
	public boolean isPalindrome(final Node head) {
		if (head == null) {
			return true;
		}

		Node fast = head;
		Node slow = head;
		Node prevSlow = null;

		// Find middle (slow will point to middle for odd, start of second half for even)
		while (fast != null && fast.getNext() != null) {
			fast = fast.getNext().getNext();
			prevSlow = slow;
			slow = slow.getNext();
		}

		// Determine start of second half
		Node secondStart = (fast != null) ? slow.getNext() : slow; // skip middle for odd length

		// Reverse second half
		Node secondReversed = reverse(secondStart);

		// Compare first half and reversed second half
		Node p1 = head;
		Node p2 = secondReversed;
		boolean palindrome = true;
		while (p2 != null) {
			if (p1.getData() != p2.getData()) {
				palindrome = false;
				break;
			}
			p1 = p1.getNext();
			p2 = p2.getNext();
		}

		// Restore the list (reverse second half again and reattach)
		Node restored = reverse(secondReversed);
		if (fast != null) { // odd length, reattach after the middle node 'slow'
			slow.setNext(restored);
		} else { // even length, reattach after prevSlow
			if (prevSlow != null) {
				prevSlow.setNext(restored);
			}
		}

		return palindrome;
	}

	private Node reverse(Node head) {
		Node prev = null;
		Node curr = head;
		while (curr != null) {
			Node next = curr.getNext();
			curr.setNext(prev);
			prev = curr;
			curr = next;
		}
		return prev;
	}

	/**
	 * Demonstration of usage. Prints input lists and whether each is a
	 * palindrome.
	 */
	public static void main(String[] args) {
		PalindromeLinkedList checker = new PalindromeLinkedList();

		Node a = LinkedListHelper.fromArray(new int[]{1, 2, 3, 2, 1});
		System.out.print("Input: "); LinkedListHelper.printList(a);
		System.out.println("Is palindrome: " + checker.isPalindrome(a));

		Node b = LinkedListHelper.fromArray(new int[]{1, 2, 2, 1});
		System.out.print("Input: "); LinkedListHelper.printList(b);
		System.out.println("Is palindrome: " + checker.isPalindrome(b));

		Node c = LinkedListHelper.fromArray(new int[]{1, 2, 3});
		System.out.print("Input: "); LinkedListHelper.printList(c);
		System.out.println("Is palindrome: " + checker.isPalindrome(c));
	}
}
