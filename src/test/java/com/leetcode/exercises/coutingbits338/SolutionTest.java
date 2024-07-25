package com.leetcode.exercises.coutingbits338;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    private static Stream<Arguments> inputProvider() {
        return Stream.of(
                Arguments.of(2, new int[]{0, 1, 1}),
                Arguments.of(5, new int[]{0, 1, 1, 2, 1, 2})
        );
    }

    @ParameterizedTest
    @MethodSource("inputProvider")
    void testCountBits(int n, int[] expected) {
        var countBits = new Solution();

        var result = countBits.countBits(n);

        assertArrayEquals(expected, result);
    }

    @Test
    void testCountBitsInArray() {
        var countBits = new Solution();
        for (int i = 0; i <= 1000; i++) {
            int[] bitNumbers = countBits.countBits(i);
            for (int j = 0; j < bitNumbers.length; j++) {
                assertEquals(Integer.bitCount(j), bitNumbers[j]);
            }
        }
    }

}