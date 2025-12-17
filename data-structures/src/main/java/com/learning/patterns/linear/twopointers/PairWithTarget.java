package com.learning.patterns.linear.twopointers;

import com.learning.utils.ArrayHelper;
import java.util.Arrays;

/**
 * Pair With Target using sort + two-pointers.
 *
 * <p>Finds two numbers in an (unsorted) integer array that add up to the
 * specified target by first creating a sorted copy of the input and then
 * applying the two-pointer technique on the sorted array.
 *
 * <p>Approach: copy and sort the array, use `left` and `right` pointers to
 * scan inward computing sums; when the sum is too small advance `left`, when
 * too large decrement `right` until a matching pair is found.
 *
 * Time complexity: O(n log n) due to sorting.
 * Space complexity: O(n) for the copied array.
 */
public class PairWithTarget {

	/**
	 * Returns two values [a, b] (a <= b) such that a + b == target, or
	 * {@code null} if no such pair exists.
	 *
	 * @param nums input array (may be unsorted)
	 * @param target desired sum
	 * @return two-element array of values or {@code null}
	 */
	public int[] pairWithTarget(int[] nums, int target) {
		if (nums == null || nums.length < 2) {
			return null;
		}

		int[] copy = Arrays.copyOf(nums, nums.length);
		Arrays.sort(copy);

		int left = 0, right = copy.length - 1;
		while (left < right) {
			int sum = copy[left] + copy[right];
			if (sum == target) {
				return new int[]{copy[left], copy[right]};
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
		PairWithTarget solver = new PairWithTarget();

		int[] ex1 = new int[]{4, 1, 2, 3, 6}; // 2 + 4 = 6
		System.out.print("Input: "); ArrayHelper.printArray(ex1);
		System.out.println("Pair result (target=6):");
		ArrayHelper.printArray(solver.pairWithTarget(ex1, 6));

		int[] ex2 = new int[]{5, 7, 1, 2}; // 5 + 7 = 12
		System.out.print("Input: "); ArrayHelper.printArray(ex2);
		System.out.println("Pair result (target=12):");
		ArrayHelper.printArray(solver.pairWithTarget(ex2, 12));
	}
}
