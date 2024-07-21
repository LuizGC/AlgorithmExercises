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
        int[] binary = new int[7];
        int[] bitNumbers = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            incrementBinary(binary);
            bitNumbers[i] = countBitsIn(binary);
        }
        for (int i : bitNumbers) {
            System.out.print(i);
        }
        return bitNumbers;
    }

    public void incrementBinary(int[] binary) {
        int incNexBit = 1;
        for (int i = 0; i < binary.length; i++) {
            int bit = binary[i];
            bit = bit + incNexBit;
            if (bit == 2) {
                bit = 0;
                incNexBit = 1;
            } else {
                incNexBit = 0;
            }
            binary[i] = bit;
        }
    }

    public int countBitsIn(int[] binary) {
        int numberBits = 0;
        for (var bit : binary) {
            numberBits += bit;
        }
        return numberBits;
    }
}
