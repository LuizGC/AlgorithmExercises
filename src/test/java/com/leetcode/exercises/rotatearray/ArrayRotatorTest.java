package com.leetcode.exercises.rotatearray;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class ArrayRotatorTest {

    @ParameterizedTest
    @MethodSource("inputProvider")
    void rotate(int[] array, int k, int[] expected) {
        // Given
        ArrayRotator rotator = new ArrayRotator(array);

        // when
        int[] rotatedArray = rotator.rotate(k);

        // then
        assertArrayEquals(expected, rotatedArray);
    }

    private static Stream<Arguments> inputProvider() {
        return Stream.of(
                Arguments.of(new int[]{-1,-100,3,99}, 2, new int[]{3, 99, -1, -100}),
                Arguments.of(new int[]{1,2}, 3, new int[]{2,1}),
                Arguments.of(new int[]{1,2}, 2, new int[]{1,2}),
                Arguments.of(new int[]{1,2,3,4,5,6,7}, 3, new int[]{5,6,7,1,2,3,4}),
                Arguments.of(new int[]{1}, 0, new int[]{1}),
                Arguments.of(new int[]{1,2,3}, 1, new int[]{3,1,2}),
                Arguments.of(new int[]{1,2,3}, 7, new int[]{3,1,2}),
                Arguments.of(new int[]{1,2,3}, 2, new int[]{2,3,1}),
                Arguments.of(new int[]{-1,-100,3,99}, 3, new int[]{-100,3,99,-1}),
                Arguments.of(new int[]{1,2,3,4,5,6}, 1, new int[]{6,1,2,3,4,5})
        );
    }
}