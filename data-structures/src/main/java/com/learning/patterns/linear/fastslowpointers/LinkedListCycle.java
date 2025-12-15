package com.learning.patterns.linear.fastslowpointers;

import com.learning.model.Node;
import com.learning.utils.LinkedListHelper;

/**
 * Detects whether a singly linked list contains a cycle using Floyd's
 * Tortoise and Hare algorithm (fast & slow pointers).
 *
 * <p>Algorithm summary:
 * <ul>
 *   <li>Advance <em>slow</em> by one step and <em>fast</em> by two steps.</li>
 *   <li>If the list has a cycle, the two pointers will eventually meet.</li>
 *   <li>If the list terminates (null encountered), there is no cycle.</li>
 * </ul>
 *
 * Time complexity: O(n) — each pointer advances through the list at most a
 * constant multiple of n.
 * Space complexity: O(1).
 *
 * <p>Common use: this is the standard approach for problems like LeetCode
 * "Linked List Cycle" (141).
 */
public class LinkedListCycle {

    /**
     * Determines whether {@code head} contains a cycle using two pointers.
     *
     * @param head the head of the linked list to inspect; may be {@code null}
     * @return {@code true} if a cycle exists in the list, {@code false} otherwise
     *
     * @implNote This method runs in O(n) time and O(1) extra space. It is
     * safe when {@code head} is {@code null} (returns {@code false}).
     */
    public boolean hasCycle(final Node head) {
        if (head == null || head.getNext() == null) {
            return false;
        }
        Node slow = head;
        Node fast = head.getNext();

        while (fast != null && fast.getNext() != null) {
            slow = slow.getNext();
            fast = fast.getNext().getNext();

            if (slow == fast) {
                return true;
            }
        }
        return false;
    }

    /**
     * Demonstrates usage with a small acyclic list and a manually created
     * cyclic list (tail linked back into the list). Prints the input and
     * whether a cycle was detected for each example.
     *
     * @param args ignored
     */
    public static void main(String[] args) {
        final LinkedListCycle solver = new LinkedListCycle();

        // Example 1: acyclic list
        Node acyclic = LinkedListHelper.fromArray(new int[]{1, 2, 3, 4});
        System.out.print("Input (acyclic): ");
        LinkedListHelper.printList(acyclic);
        System.out.println("Has cycle: " + solver.hasCycle(acyclic));

        // Example 2: create a cycle (tail -> node at index 1)
        Node cyclic = LinkedListHelper.fromArray(new int[]{10, 20, 30, 40, 50});
        // find tail
        Node tail = cyclic;
        while (tail.getNext() != null) {
            tail = tail.getNext();
        }
        // link tail back to second node (value 20)
        tail.setNext(cyclic.getNext());

        System.out.println("Created a cycle (tail -> node with value 20)");
        System.out.println("Has cycle: " + solver.hasCycle(cyclic));
    }
}
