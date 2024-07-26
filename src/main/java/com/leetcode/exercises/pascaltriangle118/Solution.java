package com.leetcode.exercises.pascaltriangle118;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> generate(int numRows) {
        var trianglePascal = new ArrayList<List<Integer>>();
        trianglePascal.add(List.of(1));
        generate(numRows - 1, trianglePascal);
        return trianglePascal;
    }

    private void generate(int numRows, ArrayList<List<Integer>> trianglePascal) {
        if (numRows <= 0) {
            return;
        }
        generate(numRows - 1, trianglePascal);
        var row = new ArrayList<Integer>();
        var previousRow = trianglePascal.get(numRows - 1);
        row.add(1);
        for (int i = 1; i < numRows; i++) {
            var a = previousRow.get(i - 1);
            var b = previousRow.get(i);
            row.add(a + b);
        }
        row.add(1);
        trianglePascal.add(row);
    }
}
