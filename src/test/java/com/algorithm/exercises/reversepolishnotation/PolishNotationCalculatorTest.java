package com.algorithm.exercises.reversepolishnotation;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.EmptyStackException;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrowsExactly;

class PolishNotationCalculatorTest {

    @ParameterizedTest
    @MethodSource("operationProvider")
    void correctEvaluation(String[] operation, int expected) {
        // Given
        PolishNotationCalculator calculator = new PolishNotationCalculator(operation);

        // When
        double result = calculator.evaluate();

        // Then
        assertEquals(expected, result);
    }

    @ParameterizedTest
    @MethodSource("algebraicOperationProvider")
    void correctNormalization(String[] operation, String expected) {
        // Given
        PolishNotationCalculator calculator = new PolishNotationCalculator(operation);

        // When
        String result = calculator.toAlgebraic();

        // Then
        assertEquals(expected, result);
    }

    @ParameterizedTest
    @MethodSource("invalidOperationProvider")
    void invalidEvaluation(String[] operation, Class<Throwable> exception) {
        // Given
        PolishNotationCalculator calculator = new PolishNotationCalculator(operation);

        // Then
        assertThrowsExactly(exception, calculator::evaluate);
    }

    @ParameterizedTest
    @MethodSource("invalidOperationProvider")
    void invalidNormalize(String[] operation, Class<Throwable> exception) {
        // Given
        PolishNotationCalculator calculator = new PolishNotationCalculator(operation);

        // Then
        assertThrowsExactly(exception, calculator::toAlgebraic);
    }

    private static Stream<Arguments> operationProvider() {
        return Stream.of(
                Arguments.of(new String[]{"2", "1", "+", "3", "*"}, 9),
                Arguments.of(new String[]{"4", "13", "5", "/", "+"}, 6),
                Arguments.of(new String[]{"4"}, 4)
        );
    }

    private static Stream<Arguments> algebraicOperationProvider() {
        return Stream.of(
                Arguments.of(new String[]{"2", "1", "+", "3", "*"}, "(2 + 1) * 3 = 9"),
                Arguments.of(new String[]{"4", "13", "5", "/", "+"}, "(13 / 5) + 4 = 6"),
                Arguments.of(new String[]{"4"}, "4 = 4")
        );
    }

    private static Stream<Arguments> invalidOperationProvider() {
        return Stream.of(
                Arguments.of(new String[] {"1", "0", "a"}, NumberFormatException.class),
                Arguments.of(new String[]{"1", "0", "/"}, ArithmeticException.class),
                Arguments.of(new String[]{}, EmptyStackException.class),
                Arguments.of(new String[]{"1", "2", "3", "+"}, IllegalStateException.class)
        );
    }
}