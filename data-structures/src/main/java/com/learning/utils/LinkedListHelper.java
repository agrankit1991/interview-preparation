package com.learning.utils;

import com.learning.model.Node;

import java.util.Random;

public class LinkedListHelper {

    /**
     * Creates a linked list from a specific array of integers.
     * Usage: Node head = LinkedListHelper.fromArray(new int[]{1, 2, 3});
     */
    public static Node fromArray(final int[] values) {
        if (values == null || values.length == 0) {
            return null;
        }

        final Node head = new Node(values[0]);
        Node current = head;

        for (int i = 1; i < values.length; i++) {
            final Node newNode = new Node(values[i]);
            current.setNext(newNode);
            current = newNode;
        }
        return head;
    }

    /**
     * Generates a linked list of a specific length with random numbers (0-100).
     * Usage: Node head = LinkedListHelper.generateRandom(5);
     */
    public static Node generateRandom(final int length) {
        if (length <= 0) {
            return null;
        }

        final Random rand = new Random();
        final Node head = new Node(rand.nextInt(100)); // Random data 0-99
        Node current = head;

        for (int i = 1; i < length; i++) {
            final Node newNode = new Node(rand.nextInt(100));
            current.setNext(newNode);
            current = newNode;
        }
        return head;
    }

    /**
     * Prints the list in a readable format: 1 -> 2 -> 3 -> NULL
     */
    public static void printList(final Node head) {
        Node current = head;
        while (current != null) {
            System.out.print(current.getData() + " -> ");
            current = current.getNext();
        }
        System.out.println("NULL");
    }
}
