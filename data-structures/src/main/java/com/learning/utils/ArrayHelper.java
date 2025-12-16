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
			System.out.println("null");
			return;
		}
		System.out.print("[");
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]);
			if (i + 1 < arr.length) System.out.print(", ");
		}
		System.out.println("]");
	}
}
