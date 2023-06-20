package com.dxc.ghp.recessive;

public final class Factorial {
	private static final int MAX_VALID_ARGUMENT = 20;

	public static long recursion(int n) {
		checkNInRange(n, 0, MAX_VALID_ARGUMENT);
		
		if (n == 0) {
			return 1;
		} else {
			return (n * recursion(n - 1));
		}
	}

	public static long iterative(int n) {
		checkNInRange(n, 0, MAX_VALID_ARGUMENT);
		
		long fact = 1;
		for (int i = 1; i <= n; i++) {
			fact = fact * i;
		}

		return fact;
	}

	private static void checkNInRange(int n, int min, int max) {
		if (n < min || n > max) {
			throw new IllegalArgumentException(String.format("Argument %d must be in [%d, %d]", n, min, max));
		}
	}

}
