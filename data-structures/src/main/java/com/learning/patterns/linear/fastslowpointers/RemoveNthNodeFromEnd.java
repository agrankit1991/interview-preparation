package com.learning.patterns.linear.fastslowpointers;

import com.learning.model.Node;
import com.learning.utils.LinkedListHelper;

/**
 * Removes the N-th node from the end of a singly linked list.
 *
 * <p>Algorithm summary:
 * <ul>
 *   <li>Use a dummy node to simplify removing the head.</li>
 *   <li>Advance the <em>fast</em> pointer {@code n} steps ahead of <em>slow</em>.</li>
 *   <li>Then advance both pointers until <em>fast</em> reaches the tail; <em>slow</em>
 *   will be positioned right before the node to remove.</li>
 * </ul>
 *
 * Time complexity: O(n).
 * Space complexity: O(1).
 */
public class RemoveNthNodeFromEnd {

	/**
	 * Removes the n-th node from the end of the list and returns the new head.
	 * If {@code head} is {@code null} or {@code n} is invalid (<= 0), the
	 * original head is returned unchanged. If {@code n} is greater than the
	 * length of the list, the method returns the original head.
	 *
	 * @param head the head of the singly linked list; may be {@code null}
	 * @param n the 1-based index from the end of the node to remove
	 * @return the head of the modified list (may be different if the original
	 *         head was removed)
	 */
	public Node removeNthFromEnd(final Node head, final int n) {
		if (head == null || n <= 0) {
			return head;
		}

		final Node dummy = new Node(0);
		dummy.setNext(head);

		Node fast = dummy;
		Node slow = dummy;

		// Move fast n steps ahead. If n is larger than the list length,
		// return original head unchanged.
		for (int i = 0; i < n; i++) {
			fast = fast.getNext();
			if (fast == null) {
				return dummy.getNext();
			}
		}

		// Move both until fast reaches the last node
		while (fast.getNext() != null) {
			fast = fast.getNext();
			slow = slow.getNext();
		}

		// slow.getNext() is the node to remove
		final Node toRemove = slow.getNext();
		if (toRemove != null) {
			slow.setNext(toRemove.getNext());
		}

		return dummy.getNext();
	}

	/**
	 * Simple demonstration: builds a list, removes an element, and prints
	 * before/after results.
	 */
	public static void main(String[] args) {
		RemoveNthNodeFromEnd solver = new RemoveNthNodeFromEnd();

		Node head = LinkedListHelper.fromArray(new int[]{1, 2, 3, 4, 5});

		System.out.print("Input: ");
		LinkedListHelper.printList(head);

		int n = 2; // remove 2nd from end -> removes '4'
		Node newHead = solver.removeNthFromEnd(head, n);

		System.out.print("After removing " + n + "-th from end: ");
		LinkedListHelper.printList(newHead);
	}
}
