package com.leetcode.exercises.mediantwosortedarray;

import java.util.*;
/*
7 Median of Two Sorted Arrays Java

There are two sorted arrays A and B of size m and n respectively. Find the median of the
two sorted arrays. The overall run time complexity should be O(log (m+n)).
 */
public class MedianCalculator {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] mergedArray = new int[nums1.length + nums2.length];

        System.arraycopy(nums1, 0, mergedArray, 0, nums1.length);
        System.arraycopy(nums2, 0, mergedArray, nums1.length, nums2.length);

        Arrays.sort(mergedArray);

        if (mergedArray.length%2 == 0) {
            int index1 = mergedArray.length/2;
            return ((double)mergedArray[index1] + mergedArray[index1-1]) / 2;
        } else {
            int index = mergedArray.length/2;
            return mergedArray[index];
        }
    }

}
