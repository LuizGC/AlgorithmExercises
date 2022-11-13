package com.leetcode.exercises.sudoku;

import java.util.Arrays;
import java.util.List;

/**
 * Write a program to solve a Sudoku puzzle by filling the empty cells.
 * 
 * A sudoku solution must satisfy all of the following rules:
 * 
 * Each of the digits 1-9 must occur exactly once in each row.
 * Each of the digits 1-9 must occur exactly once in each column.
 * Each of the digits 1-9 must occur exactly once in each of the 9 3x3 sub-boxes
 * of the grid.
 * 
 * The '.' character indicates empty cells.
 * 
 * Constraints:
 * 
 * board.length == 9
 * board[i].length == 9
 * board[i][j] is a digit or '.'.
 * It is guaranteed that the input board has only one solution.
 * 
 **/
public class SudokuSolver {

    public char[][] solveSudoku(char[][] board) {
        //print(board);
        PossibilitiesMapper mapper = new PossibilitiesMapper();
        PossibilitiesReducer reducer = new PossibilitiesReducer();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                List<Character> possibilities = mapper.mapPossibilities(i, j, board);
                reducer.add(i, j, possibilities);
            }
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                List<Character> possibilities = reducer.reduce(i, j);
                if (isEmpty(board, i, j) && possibilities.size() == 1) {
                    board[i][j] = possibilities.get(0);
                    return solveSudoku(board);
                }
            }
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (isEmpty(board, i, j)) {
                    for (Character character : reducer.get(i, j)) {
                        char[][] board2 = deepCopy(board);
                        board2[i][j] = character;
                        board2 = solveSudoku(board2);
                        if (!hasEmptySpot(board2)) {
                            return board2;
                        }
                    }

                }
            }
        }
        return board;
    }

    private boolean isEmpty(char[][] board, int i, int j) {
        return board[i][j] == '.';
    }

    private boolean hasEmptySpot(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (isEmpty(board, i, j)) {
                    return true;
                }
            }
        }
        return false;
    }

    // private int i = 0;

    // private void print(char[][] board) {
    //     System.out.println("--------------------------------");
    //     System.out.println("Interation " + i++);
    //     for (char[] row : board)
    //         System.out.println(Arrays.toString(row));
    //     System.out.println("--------------------------------");
    //     System.out.println("");
    // }

    public static char[][] deepCopy(char[][] original) {
        if (original == null) {
            return null;
        }
        final char[][] result = new char[original.length][];
        for (int i = 0; i < original.length; i++) {
            result[i] = Arrays.copyOf(original[i], original[i].length);
        }
        return result;
    }

}
