package com.learning.patterns.linear.fastslowpointers;

import com.learning.utils.ArrayHelper;

/**
 * Finds the duplicate number in an array of n+1 integers where each integer
 * is between 1 and n (inclusive).
 *
 * <p>Approach: interpret the array as a linked-list-like mapping from index
 * to value and use Floyd's Tortoise and Hare cycle detection to find the
 * entry point of the cycle which corresponds to the duplicate value.
 *
 * Time complexity: O(n). Space complexity: O(1).
 *
 * <p>Solution walkthrough (video): https://youtu.be/_n5MR8IxR6c?si=ZAgt-756vDhw4kTI&t=617
 */
public class FindDuplicateNumber {

	/**
	 * Returns any duplicate value found in {@code nums} or {@code -1} if input
	 * is invalid. Assumes array length >= 2 and values in the range [1, n].
	 */
	public int findDuplicate(final int[] nums) {
		if (nums == null || nums.length < 2) {
			return -1;
		}

		// Phase 1: find intersection point of two runners.
		int slow = nums[0];
		int fast = nums[0];
		do {
			slow = nums[slow];
			fast = nums[nums[fast]];
		} while (slow != fast);

		// Phase 2: find the entrance to the cycle.
		int finder = nums[0];
		while (finder != slow) {
			finder = nums[finder];
			slow = nums[slow];
		}
		return finder;
	}

	public static void main(String[] args) {
		final FindDuplicateNumber solver = new FindDuplicateNumber();

		int[] example1 = new int[]{1, 3, 4, 2, 2};
		System.out.print("Input: ");
		ArrayHelper.printArray(example1);
		System.out.println("Duplicate: " + solver.findDuplicate(example1));

		int[] example2 = new int[]{3, 1, 3, 4, 2};
		System.out.print("Input: ");
		ArrayHelper.printArray(example2);
		System.out.println("Duplicate: " + solver.findDuplicate(example2));
	}
}
