package com.dxc.ghp.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.math.BigInteger;
import java.util.Map;
import java.util.function.IntFunction;
import java.util.stream.Stream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import com.dxc.ghp.Factorial;

final class FactorialTest {

	private static final Map<Integer, BigInteger> factorialTestData = Map.of(50,
			new BigInteger("30414093201713378043612608166064768844377641568960512000000000000"), 100,
			new BigInteger(
					"9332621544394415268169923885626670049071596826438162146859296389521759999322991560894146397615651"
							+ "8286253697920827223758251185210916864000000000000000000000000"),
			1, BigInteger.ONE, 2, BigInteger.TWO, 20, BigInteger.valueOf(2_432_902_008_176_640_000L));

	@ParameterizedTest
	@MethodSource("testData")
	void testIterativeNormal(Map<Integer, BigInteger> fTestData) {
		checkNormalFactorial(fTestData, (int n) -> {
			return Factorial.iterative(n);
		});
	}

	@Test
	void testIterativeWhitZeroWillReturnOne() {
		checkWhitZeroWillReturnOne(Factorial::iterative);
	}

	@ParameterizedTest
	@ValueSource(ints = { -1, -2, -3, Integer.MIN_VALUE })
	void testIterativeWillWhitNegativeArgumentMustThroew(int n) {
		checkWillInvalidArgumentThrows(Factorial::iterative, n);
	}

	@ParameterizedTest
	@MethodSource("testData")
	void testRecursionNormal(Map<Integer, BigInteger> fTestData) {
		checkNormalFactorial(fTestData, (int n) -> {
			return Factorial.recursion(n);
		});
	}

	private static Stream<Map<Integer, BigInteger>> testData() {
		return Stream.of(Map.of(1, BigInteger.ONE), Map.of(2, BigInteger.TWO),
				Map.of(20, BigInteger.valueOf(2_432_902_008_176_640_000L)));
	}

	@Test
	void testRecursionWhitZeroWillReturnOne() {
		checkWhitZeroWillReturnOne(Factorial::recursion);
	}

	@ParameterizedTest
	@ValueSource(ints = { -1, -2, -3, Integer.MIN_VALUE })
	void testRecursionWillWhitNegativeArgumentMustThroew(int n) {
		checkWillInvalidArgumentThrows(Factorial::recursion, n);
	}

	private void checkNormalFactorial(Map<Integer, BigInteger> fTestData, IntFunction<BigInteger> function) {

		// factorialTestData.entrySet().forEach(entry->Assertions.assertEquals(entry.getValue(),
		// function.apply(entry.getKey())));
		// factorialTestData
		// .forEach((n, expectedFactorial) -> Assertions.assertEquals(expectedFactorial,
		// function.apply(n)));
		fTestData.forEach((n, expectedFactorial) -> Assertions.assertEquals(expectedFactorial, function.apply(n)));
	}

	private void checkWhitZeroWillReturnOne(IntFunction<BigInteger> function) {
		assertEquals(BigInteger.ONE, function.apply(0));
	}

	private void checkWillInvalidArgumentThrows(IntFunction<BigInteger> function, int n) {
		Exception exception = assertThrows(IllegalArgumentException.class, () -> function.apply(n));
		assertEquals("Argument " + n + " must be in [0, 20]", exception.getMessage());
	}
}
