package com.leetcode.exercises.rotatearray;

/*
1 Rotate Array in Java

You may have been using Java for a while. Do you think a simple Java array question
can be a challenge? Let’s use the following problem to test.
Problem: Rotate an array of n elements to the right by k steps. For example, with n
= 7 and k = 3, the array [1,2,3,4,5,6,7] is rotated to [5,6,7,1,2,3,4].
How many different ways do you know to solve this problem?
*/
public class ArrayRotator {

    private final int[] array;

    public ArrayRotator(int[] array) {
        this.array = array;
    }

    public int[] rotate(int k) {
        if (k > array.length) {
            k = k - (array.length*(k/array.length));
        }
        if (k == array.length || k == 0) {
            return array;
        }
        int[] rotatedArray = new int[array.length];
        System.arraycopy(array, array.length-k, rotatedArray, 0, k);
        System.arraycopy(array, 0, rotatedArray, k, array.length-k);
        return rotatedArray;
    }
}
