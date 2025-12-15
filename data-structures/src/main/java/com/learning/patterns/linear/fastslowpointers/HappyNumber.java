package com.learning.patterns.linear.fastslowpointers;

/**
 * Determines whether a number is "happy" using Floyd's cycle-finding
 * algorithm applied to the repeated sum-of-squares-of-digits function.
 *
 * <p>Algorithm summary:
 * <ul>
 *   <li>Define f(x) = sum of squares of digits of x.</li>
 *   <li>Use two pointers (slow and fast) advancing by f(x) and f(f(x)).</li>
 *   <li>If they meet at 1 the number is happy; if they meet elsewhere,
 *   a cycle exists and the number is not happy.</li>
 * </ul>
 *
 * Time complexity: O(log n * t) where t is number of iterations until cycle,
 * since each f(x) operates on digits. Space complexity: O(1).
 */
public class HappyNumber {

	/**
	 * Returns {@code true} if {@code n} is a happy number.
	 *
		* <p>Example:
		* <pre>
		* Input: n = 19
		* Output: true
		* Explanation:
		* 1^2 + 9^2 = 82
		* 8^2 + 2^2 = 68
		* 6^2 + 8^2 = 100
		* 1^2 + 0^2 + 0^2 = 1
		* </pre>
		*
	 * @param n a positive integer to test
	 * @return {@code true} when the repeated sum-of-squares sequence reaches 1,
	 *         otherwise {@code false}
	 */
	public boolean isHappy(int n) {
		if (n <= 0) {
			return false;
		}

		int slow = n;
		int fast = n;

		do {
			slow = next(slow);
			fast = next(next(fast));
		} while (slow != fast);

		return slow == 1;
	}

	private int next(int x) {
		int sum = 0;
		while (x > 0) {
			int d = x % 10;
			sum += d * d;
			x /= 10;
		}
		return sum;
	}

	/**
	 * Simple demonstration: checks a few numbers and prints results.
	 */
	public static void main(String[] args) {
		HappyNumber checker = new HappyNumber();
		int[] samples = {19, 2, 7, 20};
		for (int s : samples) {
			System.out.println(s + " is happy? " + checker.isHappy(s));
		}
	}
}
