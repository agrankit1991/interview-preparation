package com.learning.patterns.linear.fastslowpointers;

import com.learning.model.Node;
import com.learning.utils.LinkedListHelper;

/**
 * Finds the middle element of a singly linked list using the fast-and-slow
 * pointer technique.
 */
public class MiddleOfLinkedList {

    /**
     * Returns the data value of the middle node in the given singly linked list.
     * If the list has an even number of nodes, this method returns the second
     * of the two middle nodes (i.e., the one closer to the tail).
     *
     * @param head the head node of the linked list; may be {@code null}
     * @return the data value of the middle node, or {@code -1} if {@code head} is {@code null}
     */
    public int getMiddle(final Node head) {
        if (head == null) {
            return -1;
        }

        Node fast = head;
        Node slow = head;

        while (fast != null && fast.getNext() != null) {
            fast = fast.getNext().getNext();
            slow = slow.getNext();
        }
        return slow.getData();
    }

    /**
     * Demonstrates usage by constructing a small linked list, printing the
     * list, and printing its middle element to standard output. For the
     * sample list [1, 2, 3], the output is:
     * <pre>
     * Input: 1 2 3
     * Middle: 2
     * </pre>
     *
     * @param args command-line arguments (ignored)
     */
    public static void main(String[] args) {
        MiddleOfLinkedList solver = new MiddleOfLinkedList();

        // 1. Create data using the Helper
        Node head = LinkedListHelper.fromArray(new int[]{1, 2, 3});

        // 2. Visualize the input
        System.out.print("Input: ");
        LinkedListHelper.printList(head);

        // 3. Run logic
        System.out.println("Middle: " + solver.getMiddle(head));
    }
}
