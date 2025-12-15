package com.learning.patterns.linear.fastslowpointers;

import com.learning.model.Node;
import com.learning.utils.LinkedListHelper;

/**
 * Reorders a singly linked list in-place to follow the pattern:
 * L0 -> Ln -> L1 -> Ln-1 -> L2 -> Ln-2 -> ...
 *
 * <p>Algorithm summary:
 * <ul>
 *   <li>Find the middle of the list using fast/slow pointers and split there.</li>
 *   <li>Reverse the second half of the list in-place.</li>
 *   <li>Merge the two halves by alternating nodes from each half.</li>
 * </ul>
 *
 * Time complexity: O(n). Space complexity: O(1).
 */
public class ReorderList {

	/**
	 * Reorders the given list in-place. If {@code head} is {@code null} or the
	 * list has fewer than three nodes, the list is left unchanged.
	 *
	 * @param head the head of the singly linked list; may be {@code null}
	 */
	public void reorderList(final Node head) {
		if (head == null || head.getNext() == null || head.getNext().getNext() == null) {
			return;
		}

		// 1. Find middle (end of first half)
		Node slow = head;
		Node fast = head;
		while (fast.getNext() != null && fast.getNext().getNext() != null) {
			slow = slow.getNext();
			fast = fast.getNext().getNext();
		}

		// 2. Split and reverse second half
		Node second = slow.getNext();
		slow.setNext(null); // terminate first half
		Node secondReversed = reverse(second);

		// 3. Merge alternately
		Node first = head;
		Node secondPtr = secondReversed;
		while (secondPtr != null) {
			Node tmp1 = first.getNext();
			Node tmp2 = secondPtr.getNext();

			first.setNext(secondPtr);
			secondPtr.setNext(tmp1);

			first = tmp1 == null ? first : tmp1;
			secondPtr = tmp2;
		}
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
	 * Demonstrates usage by reordering sample lists and printing the results.
	 */
	public static void main(String[] args) {
		ReorderList solver = new ReorderList();

		Node head1 = LinkedListHelper.fromArray(new int[]{1, 2, 3, 4, 5});
		System.out.print("Input: "); LinkedListHelper.printList(head1);
		solver.reorderList(head1);
		System.out.print("Reordered: "); LinkedListHelper.printList(head1);

		Node head2 = LinkedListHelper.fromArray(new int[]{1, 2, 3, 4});
		System.out.print("Input: "); LinkedListHelper.printList(head2);
		solver.reorderList(head2);
		System.out.print("Reordered: "); LinkedListHelper.printList(head2);
	}
}
