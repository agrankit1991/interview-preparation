package com.learning.utils;

/**
 * Utility helpers for working with arrays in examples and demos.
 *
 * <p>This class contains small, reusable helpers used by sample programs
 * in the repository (printing, quick formatting etc.). Methods here are
 * intentionally minimal to avoid pulling external dependencies into
 * algorithm examples.
 */
public class ArrayHelper {

	/**
	 * Prints the provided integer array in a compact form, e.g. [1, 2, 3].
	 *
	 * @param arr array to print; if {@code null} prints {@code null}
	 */
	public static void printArray(int[] arr) {
		if (arr == null) {
			System.out.println("[ ]");
			return;
		}
		System.out.print("[");
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]);
			if (i + 1 < arr.length) System.out.print(", ");
		}
		System.out.println("]");
	}

	/**
	 * Prints values from {@code arr} at the given {@code indices} in a compact
	 * array form (e.g. [a, b]). If {@code arr} or {@code indices} is {@code null}
	 * or any index is out of bounds the method prints {@code []}.
	 *
	 * @param arr source array to read values from
	 * @param indices indices to pick from {@code arr}
	 */
	public static void printArrayAtIndices(int[] arr, int[] indices) {
		if (arr == null || indices == null) {
			System.out.println("[ ]");
			return;
		}

		for (int idx : indices) {
			if (idx < 0 || idx >= arr.length) {
				System.out.println("null");
				return;
			}
		}

		System.out.print("[");
		for (int i = 0; i < indices.length; i++) {
			System.out.print(arr[indices[i]]);
			if (i + 1 < indices.length) System.out.print(", ");
		}
		System.out.println("]");
	}
}
