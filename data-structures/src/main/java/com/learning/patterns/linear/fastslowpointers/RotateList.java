package com.learning.patterns.linear.fastslowpointers;

import com.learning.model.Node;
import com.learning.utils.LinkedListHelper;

/**
 * Rotates a singly linked list to the right by {@code k} places.
 *
 * <p>Algorithm summary:
 * <ul>
 *   <li>Compute the length and locate the tail.</li>
 *   <li>Connect tail to head to form a circular list.</li>
 *   <li>Break the circle at the appropriate position to obtain the new head.</li>
 * </ul>
 *
 * Time complexity: O(n).
 * Space complexity: O(1).
 */
public class RotateList {

	/**
	 * Rotates the list to the right by {@code k} positions and returns the
	 * new head. If {@code head} is {@code null} or {@code k} is non-positive,
	 * the original head is returned.
	 *
	 * @param head the head of the list; may be {@code null}
	 * @param k number of right rotations to perform
	 * @return the new head after rotation
	 */
	public Node rotateRight(final Node head, final int k) {
		if (head == null || k <= 0) {
			return head;
		}

		// compute length and find tail
		int length = 1;
		Node tail = head;
		while (tail.getNext() != null) {
			tail = tail.getNext();
			length++;
		}

		// Reduce k modulo length because rotating by the list length
		// (or any multiple) results in the original list; this handles
		// cases where k is greater than the list size.
		int rotations = k % length;
		if (rotations == 0) {
			return head;
		}

		// make circular
		tail.setNext(head);

		// find new tail: (length - rotations)th node
		int stepsToNewTail = length - rotations;
		Node newTail = head;
		for (int i = 1; i < stepsToNewTail; i++) {
			newTail = newTail.getNext();
		}

		Node newHead = newTail.getNext();
		newTail.setNext(null);

		return newHead;
	}

	/**
	 * Demo: rotate sample lists and print results.
	 */
	public static void main(String[] args) {
		RotateList solver = new RotateList();

		Node head = LinkedListHelper.fromArray(new int[]{1, 2, 3, 4, 5});
		System.out.print("Input: "); LinkedListHelper.printList(head);
		Node r = solver.rotateRight(head, 2);
		System.out.print("Rotated by 2: "); LinkedListHelper.printList(r);

		Node head2 = LinkedListHelper.fromArray(new int[]{0, 1, 2});
		System.out.print("Input: "); LinkedListHelper.printList(head2);
		Node r2 = solver.rotateRight(head2, 4);
		System.out.print("Rotated by 4: "); LinkedListHelper.printList(r2);
	}
}
