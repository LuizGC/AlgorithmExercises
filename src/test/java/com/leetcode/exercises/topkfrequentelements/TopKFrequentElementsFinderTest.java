package com.leetcode.exercises.topkfrequentelements;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class TopKFrequentElementsFinderTest {

    @ParameterizedTest
    @MethodSource("inputProvider")
    void topKFrequent(int[] nums, int k,int[] expected) {
        // Given
        TopKFrequentElementsFinder topKFrequentElementsFinder = new TopKFrequentElementsFinder();

        // When
        int[] output = topKFrequentElementsFinder.topKFrequent(nums, k);

        // Then
        assertArrayEquals(expected, output);
    }

    private static Stream<Arguments> inputProvider() {
        return Stream.of(
                Arguments.of(new int[]{3, 0, 1, 0}, 1, new int[]{0}),
                Arguments.of(new int[]{1,1,1,2,2,3}, 2, new int[]{1, 2})
        );
    }
}