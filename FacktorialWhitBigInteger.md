package com.dxc.ghp;

import java.math.BigInteger;

public final class Factorial {
	private static final BigInteger MAX_VALID_ARGUMENT = new BigInteger("20");

	public static BigInteger recursion(int n) {
		checkNInRange(n, BigInteger.ZERO, MAX_VALID_ARGUMENT);

		if (n==0) {
			return BigInteger.ONE;
		} else {
			return BigInteger.valueOf(n).multiply(recursion(n-1));
		}
	}

	public static BigInteger iterative(int n) {
		checkNInRange(n, BigInteger.ZERO, MAX_VALID_ARGUMENT);

		BigInteger fact = BigInteger.ONE;
		for (int i = 1; i <= n; i++) {
			fact = fact.multiply(BigInteger.valueOf(i));
		}

		return fact;
	}

	private static void checkNInRange(int n, BigInteger min, BigInteger max) {
		if (n < min.intValue() || n > max.intValue()) {
			throw new IllegalArgumentException(String.format("Argument %d must be in [%d, %d]", n, min, max));
		}
	}
}
