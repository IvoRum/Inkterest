package com.dxc.ghp.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.math.BigInteger;
import java.util.Map;
import java.util.function.IntFunction;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.dxc.ghp.Factorial;

final class FactorialTest {

	private static final Map<Integer, BigInteger> factorialTestData = Map.of(50,
			new BigInteger("30414093201713378043612608166064768844377641568960512000000000000"), 100, new BigInteger(
					"93326215443944152681699238856266700490715968264381621468592963895217599993229915608941463976156518286253697920827223758251185210916864000000000000000000000000"));

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