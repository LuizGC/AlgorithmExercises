package com.leetcode.exercises.topkfrequentelements;


import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.stream.Collectors;

/*
  Given an integer array nums and an integer k, return the k most frequent elements. You may return the answer in any order.



  Example 1:

  Input: nums = [1,1,1,2,2,3], k = 2
  Output: [1,2]
  Example 2:
  Input: nums = [1], k = 1
  Output: [1]

  Constraints:

  1 <= nums.length <= 105
  -104 <= nums[i] <= 104
  k is in the range [1, the number of unique elements in the array].
  It is guaranteed that the answer is unique.


  Follow up: Your algorithm's time complexity must be better than O(n log n), where n is the array's size.
 */
public class TopKFrequentElementsFinder {

    public int[] topKFrequent(int[] nums, int k) {
        return Arrays.stream(nums)
                .boxed()
                .collect(Collectors.groupingBy(value -> value, Collectors.summingInt(value -> 1)))
                .entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .limit(k)
                .map(Map.Entry::getKey)
                .mapToInt(a -> a)
                .toArray();
    }

}
