package com.learning.patterns.linear.fastslowpointers;

import com.learning.utils.ArrayHelper;

/**
 * Detects whether a circular loop exists in an integer array under the
 * constraint that all steps in the loop must follow the same direction
 * (all forward or all backward) and the loop length must be greater than 1.
 *
 * <p>Approach: treat indices as nodes and values as jumps. For each index
 * use Floyd's Tortoise and Hare (fast/slow pointers) but only follow
 * transitions that preserve the starting direction. To avoid revisiting
 * processed indices we zero them out when the search from that index fails.
 *
 * Time complexity: O(n). Space complexity: O(1).
 */
public class CircularArrayLoop {

	/**
	 * Returns {@code true} if {@code nums} contains a valid circular loop as
	 * defined above, otherwise {@code false}.
	 */
	public boolean circularArrayLoop(int[] nums) {
		if (nums == null || nums.length < 2) return false;

		final int n = nums.length;
		for (int i = 0; i < n; i++) {
			if (nums[i] == 0) {
                continue; // already visited or zeroed out
            }

			boolean direction = nums[i] > 0; // true = forward, false = backward
			int slow = i, fast = i;

			while (true) {
				slow = nextIndex(nums, slow, direction);
				fast = nextIndex(nums, fast, direction);
				if (fast != -1) {
                    fast = nextIndex(nums, fast, direction);
                }

				if (slow == -1 || fast == -1) {
                    break;
                }
				if (slow == fast) {
                    return true; // found a cycle
                }
			}

			// mark all nodes along this traversal as visited (set to 0)
			int j = i;
			while (true) {
				int next = nextIndex(nums, j, nums[j] > 0);
				if (next == -1) {
                    break;
                }
				nums[j] = 0;
				j = next;
			}
			nums[j] = 0;
		}
		return false;
	}

	/**
	 * Returns the next index to move to from {@code idx} if the movement
	 * preserves direction {@code direction} and isn't a single-element loop. Returns
	 * {@code -1} if the move is invalid.
	 */
	private int nextIndex(int[] nums, int idx, boolean direction) {
		if (nums[idx] == 0) {
            return -1;
        }
		boolean nextDirection = nums[idx] > 0;
		if (direction != nextDirection) {
            return -1;
        }
		int n = nums.length;
		int next = ((idx + nums[idx]) % n + n) % n; // handle negative jumps
		if (next == idx) {
            return -1; // single-element loop not allowed
        }
		return next;
	}

	public static void main(String[] args) {
		CircularArrayLoop solver = new CircularArrayLoop();

		int[] ex1 = new int[]{2, -1, 1, 2, 2}; // true
		System.out.print("Input: "); ArrayHelper.printArray(ex1);
		System.out.println("Has loop: " + solver.circularArrayLoop(ex1));

		int[] ex2 = new int[]{-1, 2}; // false
		System.out.print("Input: "); ArrayHelper.printArray(ex2);
		System.out.println("Has loop: " + solver.circularArrayLoop(ex2));

		int[] ex3 = new int[]{-2, 1, -1, -2, -2}; // false
		System.out.print("Input: "); ArrayHelper.printArray(ex3);
		System.out.println("Has loop: " + solver.circularArrayLoop(ex3));
	}
}
