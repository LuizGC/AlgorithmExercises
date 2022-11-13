package com.leetcode.exercises.sudoku;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Stream;

public class PossibilitiesReducer {

    private Map<String, List<Character>> possibilities = new HashMap<>();

    List<Character> get(int x, int y) {
        return this.possibilities.getOrDefault(calculateMapKey(x, y), List.of());
    }

    void add(int x, int y, List<Character> possibilities) {
        this.possibilities.put(calculateMapKey(x, y), possibilities);
    }

    List<Character> reduceHorizontally(int x, int y) {
        List<Character> currentSpot = this.possibilities.get(calculateMapKey(x, y));
        if (currentSpot.size() == 1) {
            return List.copyOf(currentSpot);
        }
        Set<Character> otherSpotPossibilities = new HashSet<>();
        for (int i = 0; i < 9; i++) {
            if (i != y) {
                List<Character> spot = get(x, i);
                otherSpotPossibilities.addAll(spot);
            }
        }
        return currentSpot
                .stream()
                .filter(c -> !otherSpotPossibilities.contains(c))
                .toList();
    }

    List<Character> reduceVertically(int x, int y) {
        List<Character> currentSpot = this.possibilities.get(calculateMapKey(x, y));
        if (currentSpot.size() == 1) {
            return List.copyOf(currentSpot);
        }
        Set<Character> otherSpotPossibilities = new HashSet<>();
        for (int i = 0; i < 9; i++) {
            if (i != x) {
                List<Character> spot = get(i, y);
                otherSpotPossibilities.addAll(spot);
            }
        }
        return currentSpot
                .stream()
                .filter(c -> !otherSpotPossibilities.contains(c))
                .toList();
    }

    List<Character> reduceBox(int x, int y) {
        List<Character> currentSpot = get(x, y);
        if (currentSpot.size() == 1) {
            return List.copyOf(currentSpot);
        }
        Set<Character> otherSpotPossibilities = new HashSet<>();
        int projectedX = project(x);
        int projectedY = project(y);
        for (int i = projectedX; i < projectedX + 3; i++) {
            for (int j = projectedY; j < projectedY + 3; j++) {
                if (x != i || y != j) {
                    List<Character> spot = this.possibilities.getOrDefault(calculateMapKey(i, j), List.of());
                    otherSpotPossibilities.addAll(spot);
                }
            }
        }
        return currentSpot
                .stream()
                .filter(c -> !otherSpotPossibilities.contains(c))
                .toList();
    }

    List<Character> reduce(int x, int y) {
        List<Character> currentSpot = this.possibilities.get(calculateMapKey(x, y));
        if (currentSpot.size() == 1) {
            return List.copyOf(currentSpot);
        }
        return Stream.of(
                reduceHorizontally(x, y),
                reduceVertically(x, y),
                reduceBox(x, y))
                .flatMap(Collection::stream)
                .distinct()
                .toList();
    }

    private int project(int position) {
        double i = position / 3;
        if (i < 1)
            return 0;
        if (i < 2)
            return 3;
        return 6;
    }

    private String calculateMapKey(int x, int y) {
        return x + "" + y;
    }



}
