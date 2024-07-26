package com.leetcode.exercises.pascaltriangle118;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;

class SolutionTest {

    private static Stream<Arguments> inputProvider() {
        return Stream.of(
                Arguments.of(1, List.of(List.of(1))),
                Arguments.of(5, List.of(List.of(1), List.of(1, 1), List.of(1, 2, 1), List.of(1, 3, 3, 1), List.of(1, 4, 6, 4, 1)))
        );
    }

    @ParameterizedTest
    @MethodSource("inputProvider")
    public void test(int n, List<List<Integer>> expected) {
        var pascalTriangleGenerator = new Solution();
        var pascalTriangle = pascalTriangleGenerator.generate(n);

        assertEquals(expected.size(), pascalTriangle.size());
        for (int i = 0; i < n; i++) {
            assertIterableEquals(expected.get(i), pascalTriangle.get(i));
        }
    }

}