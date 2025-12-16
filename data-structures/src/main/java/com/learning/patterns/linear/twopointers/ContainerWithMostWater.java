package com.learning.patterns.linear.twopointers;

import com.learning.utils.ArrayHelper;

/**
 * Container With Most Water (two-pointer solution).
 *
 * <p>Given an array of non-negative integers where each element represents
 * the height of a vertical line on the x-axis, finds the two lines that
 * together with the x-axis form a container holding the most water.
 *
 * <p>Approach: use two pointers `left` and `right` starting at the ends of
 * the array. At each step compute the area formed by the two lines and move
 * the pointer at the shorter line inward — this is optimal because moving
 * the taller line cannot increase area when the shorter line limits height.
 *
 * Time complexity: O(n).
 * Space complexity: O(1).
 */
public class ContainerWithMostWater {

	/**
	 * Computes the maximum area of water that can be contained.
	 *
	 * @param height array of non-negative heights
	 * @return maximum area (0 if {@code height} is null or has fewer than 2 elements)
	 */
	public int maxArea(int[] height) {
		if (height == null || height.length < 2) {
            return 0;
        }

		int left = 0;
		int right = height.length - 1;
		int max = 0;

		while (left < right) {
			int h = Math.min(height[left], height[right]);
			int area = h * (right - left);
			if (area > max) max = area;

			if (height[left] < height[right]) {
				left++;
			} else {
				right--;
			}
		}

		return max;
	}

	public static void main(String[] args) {
		ContainerWithMostWater solver = new ContainerWithMostWater();

		int[] expected1 = new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}; // expected 49
		System.out.print("Input: "); ArrayHelper.printArray(expected1);
		System.out.println("Max area: " + solver.maxArea(expected1));

		int[] expected2 = new int[]{1, 1}; // expected 1
		System.out.print("Input: "); ArrayHelper.printArray(expected2);
		System.out.println("Max area: " + solver.maxArea(expected2));
	}
}
