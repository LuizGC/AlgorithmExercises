package com.leetcode.exercises.sudoku;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class SudokuSolverTest {

    @ParameterizedTest
    @MethodSource("inputProvider")
    void testSolveSudoku(char[][] input, char[][] expected) {
        // Given
        SudokuSolver solver = new SudokuSolver();

        // When
        char[][] output = solver.solveSudoku(input);

        // Then
        assertArrayEquals(expected, output);
    }

    private static Stream<Arguments> inputProvider() {
        return Stream.of(
                Arguments.of(
                        new char[][] {
                                { '5', '3', '.', '.', '7', '.', '.', '.', '.' },
                                { '6', '.', '.', '1', '9', '5', '.', '.', '.' },
                                { '.', '9', '8', '.', '.', '.', '.', '6', '.' },
                                { '8', '.', '.', '.', '6', '.', '.', '.', '3' },
                                { '4', '.', '.', '8', '.', '3', '.', '.', '1' },
                                { '7', '.', '.', '.', '2', '.', '.', '.', '6' },
                                { '.', '6', '.', '.', '.', '.', '2', '8', '.' },
                                { '.', '.', '.', '4', '1', '9', '.', '.', '5' },
                                { '.', '.', '.', '.', '8', '.', '.', '7', '9' }
                        },
                        new char[][] {
                                { '5', '3', '4', '6', '7', '8', '9', '1', '2' },
                                { '6', '7', '2', '1', '9', '5', '3', '4', '8' },
                                { '1', '9', '8', '3', '4', '2', '5', '6', '7' },
                                { '8', '5', '9', '7', '6', '1', '4', '2', '3' },
                                { '4', '2', '6', '8', '5', '3', '7', '9', '1' },
                                { '7', '1', '3', '9', '2', '4', '8', '5', '6' },
                                { '9', '6', '1', '5', '3', '7', '2', '8', '4' },
                                { '2', '8', '7', '4', '1', '9', '6', '3', '5' },
                                { '3', '4', '5', '2', '8', '6', '1', '7', '9' }
                        }));
    }
}
