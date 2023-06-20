package com.dxc.ghp.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;
import java.util.function.IntFunction;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.dxc.ghp.Factorial;

final class FactorialTest {

	private static final Map<Integer, BigInteger> factorialTestData 
	= Map.of(50, new BigInteger("30414093201713378043612608166064768844377641568960512000000000000"));
	
	static {
		factorialTestData.put(50, new BigInteger("30414093201713378043612608166064768844377641568960512000000000000"));
		factorialTestData.put(100, new BigInteger("93326215443944152681699238856266700490715968264381621468592963895217599993229915608941463976156518286253697920827223758251185210916864000000000000000000000000"));
	}
	/*
	 * long[] expectedFactorials = { 1, 2, 6, 24, 120, 720, 5_040, 40_320, 362_880,
	 * 3_628_800, 39_916_800, 479_001_600, 6_227_020_800L, 87_178_291_200L,
	 * 1_307_674_368_000L, 20_922_789_888_000L, 355_687_428_096_000L,
	 * 6_402_373_705_728_000L, 121_645_100_408_832_000L, 2_432_902_008_176_640_000L
	 * }; for (int i = 0; i < expectedFactorials.length; i++) {
	 * assertEquals(BigInteger.valueOf( expectedFactorials[i]), function.apply(i +
	 * 1)); }
	 */

	@Test
	void testIterativeNormal() {
		checkNormalFactorial((int n) -> {
			return Factorial.iterative(n);
		});
		checkNormalFactorial(Factorial::iterative);
	}

	@Test
	void testIterativeWhitZeroWillReturnOne() {
		checkWhitZeroWillReturnOne(Factorial::iterative);
	}

	@Test
	void testIterativeWillWhitNegativeArgumentMustThroew() {
		checkWillInvalidArgumentThrows(Factorial::iterative, -1);
	}

	@Test
	void testRecursionNormal() {
		checkNormalFactorial((int n) -> {
			return Factorial.recursion(n);
		});
	}

	@Test
	void testRecursionWhitZeroWillReturnOne() {
		checkWhitZeroWillReturnOne(Factorial::recursion);
	}

	@Test
	void testRecursionWillWhitNegativeArgumentMustThroew() {
		checkWillInvalidArgumentThrows(Factorial::recursion, -1);
	}

	private void checkNormalFactorial(IntFunction<BigInteger> function) {

		// factorialTestData.entrySet().forEach(entry->Assertions.assertEquals(entry.getValue(),
		// function.apply(entry.getKey())));
		factorialTestData
				.forEach((n, expectedFactorial) -> Assertions.assertEquals(expectedFactorial, function.apply(n)));
	}

	private void checkWhitZeroWillReturnOne(IntFunction<BigInteger> function) {
		assertEquals(BigInteger.ONE, function.apply(0));
	}

	private void checkWillInvalidArgumentThrows(IntFunction<BigInteger> function, int n) {
		Exception exception = assertThrows(IllegalArgumentException.class, () -> function.apply(n));
		assertEquals("Argument " + n + " must be in [0, 20]", exception.getMessage());
	}
}
