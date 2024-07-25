package com.leetcode.exercises.coutingbits338;


/**
 * Given an integer n, return an array ans of length n + 1 such that for each i (0 <= i <= n),
 * ans[i] is the number of 1's in the binary representation of i.
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: n = 2
 * Output: [0,1,1]
 * Explanation:
 * 0 --> 0
 * 1 --> 1
 * 2 --> 10
 * Example 2:
 * <p>
 * Input: n = 5
 * Output: [0,1,1,2,1,2]
 * Explanation:
 * 0 --> 0
 * 1 --> 1
 * 2 --> 10
 * 3 --> 11
 * 4 --> 100
 * 5 --> 101
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 0 <= n <= 105
 */
class Solution {

    public int[] countBits(int n) {
        if (n == 0) {
            return new int[1];
        }
        int[] bitNumbers = new int[n + 1];
        bitNumbers[1] = 1;
        for (int i = bitNumbers.length - 1; i > 1; i--) {
            bitNumbers[i] = countBits(i, bitNumbers);
        }
        return bitNumbers;
    }

    private int countBits(int n, int[] bitNumbers) {
        if (n == 1) {
            return 1;
        }
        if (bitNumbers[n] > 0) {
            return bitNumbers[n];
        }
        int remainder = n % 2;
        int quotient = n / 2;
        bitNumbers[n] = remainder + countBits(quotient, bitNumbers);
        return bitNumbers[n];
    }
}
