package com.leetcode.exercises.sudoku;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class PossibilitiesFinder {

    private static final char EMPTY_MARKER = '.';

    List<Character> getPossibilities(int x, int y, char[][] board) {
        char c = board[x][y];
        if (c != EMPTY_MARKER) {
            return List.of(c);
        }
        List<Character> horizontal = getPossibilitiesHorizontally(x, y, board);
        List<Character> vertically = getPossibilitiesVertically(x, y, board);
        List<Character> box = getPossibilitiesBox(x, y, board);
        return createPossibilitiesList()
                .stream()
                .filter(horizontal::contains)
                .filter(vertically::contains)
                .filter(box::contains)
                .toList();
    }


    List<Character> getPossibilitiesHorizontally(int x, int y, char[][] board) {
        List<Character> possibilities = createPossibilitiesList();

        for (int yi = 0; yi < board.length; yi++) {
            char yc = board[x][yi];
            if (yc != EMPTY_MARKER) {
                possibilities.remove(Character.valueOf(yc));
            }
        }

        return possibilities;
    }

    List<Character> getPossibilitiesVertically(int x, int y, char[][] board) {
        List<Character> possibilities = createPossibilitiesList();

        for (int xi = 0; xi < board.length; xi++) {
            char xc = board[xi][y];
            if (xc != EMPTY_MARKER) {
                possibilities.remove(Character.valueOf(xc));
            }
        }

        return possibilities;
    }

    List<Character> getPossibilitiesBox(int x, int y, char[][] board){
        List<Character> possibilities = createPossibilitiesList();
        int projectedX = project(x);
        int projectedY = project(y);
        for (int i = projectedX; i < projectedX + 3; i++){
            for (int j = projectedY; j < projectedY + 3; j++){
                char xc = board[i][j];
                if (xc != EMPTY_MARKER) {
                    possibilities.remove(Character.valueOf(xc));
                }
            }   
        }
        return possibilities;
    }

    private int project(int position) {
        double i = position/3;
        if (i < 1) return 0;
        if (i < 2) return 3;
        return 6;
    }


    private ArrayList<Character> createPossibilitiesList() {
        return IntStream.range(1, 10)
                .boxed()
                .map(i -> Character.forDigit(i, 10))
                .collect(Collectors.toCollection(ArrayList::new));
    }

}




/**
 * 00 01 02 03 04 05 06 07 08
 * 10 11 12 13 14 15 16 17 18
 * 20 21 22 23 24 25 26 27 28
 * 30 31 32 33 34 35 36 37 38
 * 40 41 42 43 44 45 46 47 48 
 * 50 51 52 53 54 55 56 57 58
 * 60 61 62 63 64 65 66 67 68
 * 70 71 72 73 74 75 76 77 78 
 * 80 81 82 83 84 85 86 87 88
 */