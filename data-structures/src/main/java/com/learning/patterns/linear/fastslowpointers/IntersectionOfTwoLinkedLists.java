package com.learning.patterns.linear.fastslowpointers;

import com.learning.model.Node;
import com.learning.utils.LinkedListHelper;

/**
 * Detects the intersection node of two singly linked lists (by reference).
 *
 * <p>Algorithm summary:
 * <ul>
 *   <li>Use two pointers starting at the heads of the lists.</li>
 *   <li>Advance each pointer; when a pointer reaches the end, redirect it to
 *       the head of the other list.</li>
 *   <li>If the lists intersect, the pointers will meet at the intersection
 *       node after at most 2 passes; otherwise both become {@code null}.</li>
 * </ul>
 *
 * Time complexity: O(m + n).
 * Space complexity: O(1).
 */
public class IntersectionOfTwoLinkedLists {

	/**
	 * Returns the node at which the two lists intersect by reference, or
	 * {@code null} if they do not intersect. Intersection is determined by
	 * reference equality (the same {@code Node} instance), not by node value.
	 * When there is no intersection the method returns {@code null}.
	 *
	 * @param headA head of the first list; may be {@code null}
	 * @param headB head of the second list; may be {@code null}
	 * @return the intersection node, or {@code null} when the lists do not intersect
	 */
	public Node getIntersectionNode(final Node headA, final Node headB) {
		if (headA == null || headB == null) {
			return null;
		}

		Node pointerA = headA;
		Node pointerB = headB;

		// Traverse both lists; when reaching the end switch to the other head.
		// If there is an intersection, pointerA == pointerB at that node; otherwise both
		// will eventually become null and the loop exits.
		while (pointerA != pointerB) {
			pointerA = (pointerA == null) ? headB : pointerA.getNext();
			pointerB = (pointerB == null) ? headA : pointerB.getNext();
		}
		return pointerA;
	}

	/**
	 * Demonstration: builds two lists with a shared tail and finds the
	 * intersection node.
	 */
	public static void main(String[] args) {
		IntersectionOfTwoLinkedLists solver = new IntersectionOfTwoLinkedLists();

		// Shared tail: 8 -> 4 -> 5
		Node shared = LinkedListHelper.fromArray(new int[]{8, 4, 5});

		// List A: 4 -> 1 -> [shared]
		Node a = LinkedListHelper.fromArray(new int[]{4, 1});
		Node tailA = a;
		while (tailA.getNext() != null) tailA = tailA.getNext();
		tailA.setNext(shared);

		// List B: 5 -> 6 -> 1 -> [shared]
		Node b = LinkedListHelper.fromArray(new int[]{5, 6, 1});
		Node tailB = b;
		while (tailB.getNext() != null) tailB = tailB.getNext();
		tailB.setNext(shared);

		System.out.print("List A: "); LinkedListHelper.printList(a);
		System.out.print("List B: "); LinkedListHelper.printList(b);

		Node inter = solver.getIntersectionNode(a, b);
		System.out.println("Intersection: " + (inter == null ? "None" : inter.getData()));
	}
}
