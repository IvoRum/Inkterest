package com.dxc.ghp.recessive.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import java.util.function.IntToLongFunction;
import org.junit.jupiter.api.Test;

import com.dxc.ghp.recessive.Factorial;

final class FactorialTest {
	/*
	 * @FunctionalInterface private static interface IntToLongFunction { long
	 * applyAsLong(int n); }
	 */
	/*
	 * OOP Example private static class RecursiveFunction implements
	 * IntToLongFunction {
	 * 
	 * @Override public long applyAsLong(int n) { return Factorial.recursion(n); }
	 * 
	 * }
	 */
	/*
	 * private static class IterativeFunction implements IntToLongFunction {
	 * 
	 * @Override public long applyAsLong(int n) { return Factorial.iterative(n); }
	 * 
	 * }
	 */

	// lambda exaple
	@Test
	void testIterativeNormal() {
		checkNormalFactorial(Factorial::iterative);
	}

	@Test
	void testRecursionNormal() {
		checkNormalFactorial((int n) -> {
			return Factorial.recursion(n);
		});
	}

	private void checkNormalFactorial(IntToLongFunction function) {
		long[] expectedFactorials = { 1, 2, 6, 24, 120, 720, 5_040, 40_320, 362_880, 3_628_800, 39_916_800, 479_001_600,
				6_227_020_800L, 87_178_291_200L, 1_307_674_368_000L, 20_922_789_888_000L, 355_687_428_096_000L,
				6_402_373_705_728_000L, 121_645_100_408_832_000L, 2_432_902_008_176_640_000L };
		for (int i = 0; i < expectedFactorials.length; i++) {
			assertEquals(expectedFactorials[i], function.applyAsLong(i + 1));
		}
	}
	/////////////////////////////////////////////////////////////////////////////////////////////

	@Test
	void testRecursionWhitZeroWillReturnOne() {
		checkWhitZeroWillReturnOne(Factorial::recursion);
	}

	@Test
	void testIterativeWhitZeroWillReturnOne() {
		checkWhitZeroWillReturnOne(Factorial::iterative);
	}

	private void checkWhitZeroWillReturnOne(IntToLongFunction function) {
		assertEquals(1, function.applyAsLong(0));
	}

	///////////////////////////////////////////////
	@Test
	void testRecursionWillWhitNegativeArgumentMustThroew() {
		checkWillInvalidArgumentThrows(Factorial::recursion, -1);
	}

	@Test
	void testIterativeWillWhitNegativeArgumentMustThroew() {
		checkWillInvalidArgumentThrows(Factorial::iterative, -1);
	}

	private void checkWillInvalidArgumentThrows(IntToLongFunction function, int n) {
		Exception exception =
		assertThrows(IllegalArgumentException.class, () -> function.applyAsLong(n));
		assertEquals("Argument "+n+" must be in [0, 20]", exception.getMessage());
	}

	////////////////////////////////////////////

	@Test
	void testRecursionBigArgumentMustThrow() {
		checkWillInvalidArgumentThrows(Factorial::recursion, 21);
	}

	@Test
	void checkBigArgumentMustTrwo() {
		checkWillInvalidArgumentThrows(Factorial::iterative, 21);
	}
	/*
	 * private void checkBigArgumentMustTrwo(IntToLongFunction function) { Exception
	 * exception = assertThrows(IllegalArgumentException.class, () ->
	 * function.applyAsLong(21)); assertEquals("Argument 21 must be in [0, 20]",
	 * exception.getMessage()); }
	 */

}
