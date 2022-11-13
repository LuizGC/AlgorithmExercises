package com.leetcode.exercises.sudoku;

import java.util.Arrays;
import java.util.List;

/**
Write a program to solve a Sudoku puzzle by filling the empty cells.

A sudoku solution must satisfy all of the following rules:

    Each of the digits 1-9 must occur exactly once in each row.
    Each of the digits 1-9 must occur exactly once in each column.
    Each of the digits 1-9 must occur exactly once in each of the 9 3x3 sub-boxes of the grid.

The '.' character indicates empty cells.

Constraints:

    board.length == 9
    board[i].length == 9
    board[i][j] is a digit or '.'.
    It is guaranteed that the input board has only one solution.

 **/
public class SudokuSolver {

    public char[][] solveSudoku(char[][] board) {
        print(board);
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
                if (board[i][j] == '.' && possibilities.size() == 1) {
                    board[i][j] = possibilities.get(0);
                    return solveSudoku(board);
                }
            }
        }
        return board;
    }

    int i = 0;
    void print(char[][] board) {
       
            System.out.println("--------------------------------");
            System.out.println("Interation " + i++);
            for (char[] row : board)
                System.out.println(Arrays.toString(row));
            System.out.println("--------------------------------");
            System.out.println("");
    }

    
}
