package com.leetcode.exercises.sudoku;

import static org.junit.jupiter.api.Assertions.assertIterableEquals;

import java.util.List;

import org.junit.jupiter.api.Test;

public class PossibilitiesMapperTest {

    @Test
    void getPossibilitiesHorizontally() {
        // Given
        char[][] board = new char[9][9];
        int x = 4, y = 7;
        populateBoardWithEmptyCharacter(board);
        board[x][6] = '5';
        board[x][4] = '1';
        PossibilitiesMapper finder = new PossibilitiesMapper();

        // when
        List<Character> result = finder.getPossibilitiesHorizontally(x, y, board);

        // Then
        List<Character> expected = List.of('2', '3', '4', '6', '7', '8', '9');
        assertIterableEquals(expected, result);
    }

    @Test
    void getPossibilitiesVertically() {
        // Given
        char[][] board = new char[9][9];
        int x = 4, y = 7;
        populateBoardWithEmptyCharacter(board);
        board[3][y] = '5';
        board[5][y] = '1';
        PossibilitiesMapper finder = new PossibilitiesMapper();

        // when
        List<Character> result = finder.getPossibilitiesVertically(x, y, board);

        // Then
        List<Character> expected = List.of('2', '3', '4', '6', '7', '8', '9');
        assertIterableEquals(expected, result);
    }

    @Test
    void getPossibilitiesBox(){
        // Given
        char[][] board = new char[9][9];
        int x = 4, y = 7;
        populateBoardWithEmptyCharacter(board);
        board[3][6] = '5';
        board[5][8] = '1';
        PossibilitiesMapper finder = new PossibilitiesMapper();

        // when
        List<Character> result = finder.getPossibilitiesBox(x, y, board);

        // Then
        List<Character> expected = List.of('2', '3', '4', '6', '7', '8', '9');
        assertIterableEquals(expected, result);
    }

    @Test
    void whenSpotHasNumberShouldReturnListContainsOnlyTheNumber() {
        // Given
        char[][] board = new char[9][9];
        int x = 4, y = 7;
        board[x][y] = '6';
        PossibilitiesMapper finder = new PossibilitiesMapper();

        // when
        List<Character> result = finder.mapPossibilities(x, y, board);

        // Then
        assertIterableEquals(List.of('6'), result);
    }

    @Test
    void getPossibilities() {
        // Given
        char[][] board = new char[9][9];
        int x = 4, y = 7;
        populateBoardWithEmptyCharacter(board);
        board[5][y] = '1';
        board[x][6] = '2';
        board[5][8] = '3';
        board[3][y] = '5';
        board[3][6] = '7';
        board[x][4] = '8';
        PossibilitiesMapper finder = new PossibilitiesMapper();

        // when
        List<Character> result = finder.mapPossibilities(x, y, board);

        // Then
        List<Character> expected = List.of( '4', '6', '9');
        assertIterableEquals(expected, result);
    }

    private void populateBoardWithEmptyCharacter(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                board[i][j] = '.';
            }
        }
    }
}
