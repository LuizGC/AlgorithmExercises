package com.leetcode.exercises.coutingbits338;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
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

    private static int summingBit(int[] binary) {
        return Arrays.stream(binary)
                .sum();
    }

    @ParameterizedTest
    @MethodSource("inputProvider")
    void testCountBits(int n, int[] expected) {
        var countBits = new Solution();

        var result = countBits.countBits(n);

        assertArrayEquals(expected, result);
    }

    @Test
    void testIncrement() {
        var countBits = new Solution();
        int[] binary = new int[100];
        for (int i = 1; i <= 1000; i++) {
            countBits.incrementBinary(binary);
            assertEquals(Integer.bitCount(i), summingBit(binary));
        }
    }

    @Test
    void testCountBitsInArray() {
        var countBits = new Solution();
        int[] binary = new int[7];
        for (int i = 1; i <= 105; i++) {
            countBits.incrementBinary(binary);
            assertEquals(Integer.bitCount(i), countBits.countBitsIn(binary));
        }
    }

}