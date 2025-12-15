package com.learning.patterns.linear.fastslowpointers;

import com.learning.model.Node;
import com.learning.utils.LinkedListHelper;

/**
 * Computes the length of a cycle in a singly linked list (if present).
 *
 * <p>Approach: use Floyd's Tortoise and Hare to detect a meeting point. If
 * a cycle exists, advance a pointer around the loop counting steps until it
 * returns to the meeting point; that count is the cycle length.
 *
 * Time complexity: O(n) — detection and counting traverse nodes at most a
 * constant multiple of n.
 * Space complexity: O(1).
 */
public class FindCycleLength {

	/**
	 * Returns the length of the cycle in {@code head}, or {@code 0} if there is no cycle.
	 *
	 * @implNote Runs in O(n) time and O(1) extra space. Returns {@code 0} for
	 * {@code null} or acyclic lists.
	 */
	public int findCycleLength(final Node head) {
		if (head == null || head.getNext() == null) {
			return 0;
		}

		Node slow = head;
		Node fast = head;

		// Detect cycle using Floyd's algorithm
		while (fast != null && fast.getNext() != null) {
			slow = slow.getNext();
			fast = fast.getNext().getNext();

			if (slow == fast) {
				// Count the cycle length
				int length = 1;
				Node current = slow.getNext();
				while (current != slow) {
					length++;
					current = current.getNext();
				}
				return length;
			}
		}
		return 0; // no cycle
	}

	public static void main(String[] args) {
		final FindCycleLength solver = new FindCycleLength();

		// Acyclic example
		Node acyclic = LinkedListHelper.fromArray(new int[]{1, 2, 3, 4});
		System.out.print("Input (acyclic): ");
		LinkedListHelper.printList(acyclic);
		System.out.println("Cycle length: " + solver.findCycleLength(acyclic));

		// Cyclic example: tail -> node at index 1 (value 20)
		Node cyclic = LinkedListHelper.fromArray(new int[]{10, 20, 30, 40, 50});
		Node tail = cyclic;
		while (tail.getNext() != null) {
			tail = tail.getNext();
		}
		tail.setNext(cyclic.getNext());

		System.out.println("Created a cycle (tail -> node with value 20)");
		System.out.println("Cycle length: " + solver.findCycleLength(cyclic));
	}
}
