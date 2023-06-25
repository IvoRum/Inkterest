package com.dxc.ghp.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import java.math.BigInteger;
import java.util.stream.Stream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import com.dxc.ghp.Factorial;

abstract class BaseFactorialTest {

	@ParameterizedTest(name = "{0}! ={1}")
	@MethodSource("testData")
	void testIterativeNormal(final int n, final BigInteger expectedFactorial) {
		final Factorial factorial = createTestFactorial();
		Assertions.assertEquals(expectedFactorial, factorial.calculate(n));
	}

	@Test
	void testIterativeWhitZeroWillReturnOne() {
		final Factorial factorial = createTestFactorial();
		assertEquals(BigInteger.ONE, factorial.calculate(0));
	}

	@SuppressWarnings("nls")
	@ParameterizedTest(name = "{0}! =")
	@ValueSource(ints = { -1, -2, -3, Integer.MIN_VALUE })
	void testIterativeWillWhitNegativeArgumentMustThroew(final int n) {
		final Factorial factorial = createTestFactorial();
		final Exception exception = assertThrows(IllegalArgumentException.class, () -> factorial.calculate(n));
		assertEquals(String.format("Argument %d must be in [0, 20]", Integer.valueOf(n)), exception.getMessage());
	}

	private static Stream<Arguments> testData() {
		return Stream.of(arguments(Integer.valueOf(1), BigInteger.ONE), arguments(Integer.valueOf(2), BigInteger.TWO),
				arguments(Integer.valueOf(20), BigInteger.valueOf(2_432_902_008_176_640_000L)));
	}

	abstract Factorial createTestFactorial();
}


////Implementation
package com.dxc.ghp.tests;

import com.dxc.ghp.Factorial;
import com.dxc.ghp.FactorialRecursion;

final class RecursionTest extends BaseFactorialTest {

	@Override
	Factorial createTestFactorial() {
		final Factorial factorial = new FactorialRecursion();
		return factorial;
	}
}
