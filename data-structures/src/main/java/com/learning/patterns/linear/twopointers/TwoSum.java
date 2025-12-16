package com.learning.patterns.linear.twopointers;

import com.learning.utils.ArrayHelper;

/**
 * Two-pointer Two Sum for sorted arrays.
 *
 * <p>Finds a pair of numbers in a sorted integer array that add up to the
 * specified target using the two-pointer technique. Because the input is
 * sorted we can scan from both ends and move pointers inward to locate the
 * pair without extra space.
 *
 * <p>Approach: start with `left` at the beginning and `right` at the end;
 * compute the sum and advance the appropriate pointer until the target is
 * found or the pointers cross.
 *
 * Time complexity: O(n).
 * Space complexity: O(1).
 */
public class TwoSum {

	/**
	 * Returns two indices i &lt; j such that {@code nums[i] + nums[j] == target}.
	 *
	 * @param nums sorted input array (ascending)
	 * @param target desired sum
	 * @return two-element {@code int[]} with indices [i, j], or {@code null}
	 *         if no qualifying pair exists
	 */
	public int[] twoSum(int[] nums, int target) {
		if (nums == null || nums.length < 2) {
            return null;
        }

		int left = 0;
		int right = nums.length - 1;

		while (left < right) {
			int sum = nums[left] + nums[right];
			if (sum == target) {
				return new int[]{left, right};
			}
			if (sum < target) {
				left++;
			} else {
				right--;
			}
		}
		return null;
	}

	public static void main(String[] args) {
		TwoSum solver = new TwoSum();

		int[] example1 = new int[]{1, 2, 3, 4, 6}; // 2 + 4 = 6 -> indices [1,3]
		System.out.print("Input: "); ArrayHelper.printArray(example1);
		System.out.println("Two-pointer result (target=6):");
        ArrayHelper.printArrayAtIndices(example1, solver.twoSum(example1, 6));

		int[] example2 = new int[]{2, 3, 5, 9}; // no pair sums to 20
		System.out.print("Input: "); ArrayHelper.printArray(example2);
		System.out.println("Two-pointer result (target=20):");
		ArrayHelper.printArrayAtIndices(example2, solver.twoSum(example2, 20));
	}
}
