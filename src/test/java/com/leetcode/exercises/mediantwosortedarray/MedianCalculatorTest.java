package com.leetcode.exercises.mediantwosortedarray;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MedianCalculatorTest {

    @ParameterizedTest
    @MethodSource("inputProvider")
    void findMedianSortedArrays(int[] nums1, int[] nums2, double expected) {
        // Given
        MedianCalculator calculator = new MedianCalculator();

        // When
        double result = calculator.findMedianSortedArrays(nums1, nums2);

        // Then
        assertEquals(expected, result);
    }

    private static Stream<Arguments> inputProvider() {
        return Stream.of(
                Arguments.of(new int[]{1,3}, new int[]{2}, 2),
                Arguments.of(new int[]{1,2}, new int[]{3,4  }, 2.5)
        );
    }
}