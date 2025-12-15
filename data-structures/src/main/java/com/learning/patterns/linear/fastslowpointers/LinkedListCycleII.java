package com.learning.patterns.linear.fastslowpointers;

import com.learning.model.Node;
import com.learning.utils.LinkedListHelper;

/**
 * Finds the node where a cycle begins in a singly linked list (if any)
 * using Floyd's Tortoise and Hare (fast & slow) algorithm.
 *
 * <p>Algorithm summary:
 * <ul>
 *   <li>Use two pointers: <em>slow</em> advances by one and <em>fast</em> by two.</li>
 *   <li>If they meet, a cycle exists; otherwise the list terminates and there is no cycle.</li>
 *   <li>When a meeting point is found, move one pointer to {@code head} and
 *       advance both one step at a time until they meet at the cycle entry.</li>
 * </ul>
 *
 * Time complexity: O(n).
 * Space complexity: O(1).
 *
 */
public class LinkedListCycleII {

	/**
	 * Returns the node where the cycle begins, or {@code null} if there is no cycle.
	 *
	 * @param head head of the linked list (may be {@code null})
	 * @return node at the start of the cycle or {@code null} when none exists
	 *
	 * @implNote Runs in O(n) time and uses O(1) extra space. Safe when {@code head}
	 * is {@code null} (returns {@code null}).
	 */
	public Node findCycleStart(final Node head) {
		if (head == null || head.getNext() == null) {
			return null;
		}

		Node slow = head;
		Node fast = head;

		// First: determine if a cycle exists
		while (fast != null && fast.getNext() != null) {
			slow = slow.getNext();
			fast = fast.getNext().getNext();

			if (slow == fast) {
				// Cycle detected; find entry point
				Node ptr1 = head;
				Node ptr2 = slow;
				while (ptr1 != ptr2) {
					ptr1 = ptr1.getNext();
					ptr2 = ptr2.getNext();
				}
				return ptr1; // start of cycle
			}
		}
		return null; // no cycle
	}

	public static void main(String[] args) {
		final LinkedListCycleII solver = new LinkedListCycleII();

		// Example 1: acyclic list
		Node acyclic = LinkedListHelper.fromArray(new int[]{1, 2, 3, 4});
		System.out.print("Input (acyclic): ");
		LinkedListHelper.printList(acyclic);
		System.out.println("Cycle start: " + solver.findCycleStart(acyclic));

		// Example 2: create a cycle (tail -> node at index 1)
		Node cyclic = LinkedListHelper.fromArray(new int[]{10, 20, 30, 40, 50});
		// find tail
		Node tail = cyclic;
		while (tail.getNext() != null) {
			tail = tail.getNext();
		}
		// link tail back to second node (value 20)
		tail.setNext(cyclic.getNext());

		Node cycleStart = solver.findCycleStart(cyclic);
		System.out.println("Created a cycle (tail -> node with value 20)");
		System.out.println("Cycle start data: " + (cycleStart == null ? "null" : cycleStart.getData()));
	}
}
