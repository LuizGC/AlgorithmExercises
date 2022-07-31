package com.leetcode.exercises.longestpalindromicsubstring;

import java.util.function.Function;

/*
3 Solution of Longest Palindromic Substring in Java
*/
public class LongestPalindromicSubstringFinder {

    private final String text;

    public LongestPalindromicSubstringFinder(String text) {
        this.text = text;
    }

    public String search() {
        if (isPalindrome(text)) {
            return text;
        }
        char[] chars = text.toCharArray();
        char[][] palindrome = new char[chars.length][chars.length];
        for (int i = 0; i < chars.length; i++) {
            for (int j = 0; j < chars.length; j++) {
                palindrome[i][j] = chars[i] == chars[chars.length - j - 1] ? chars[i] : '-';
            }
        }
        String longestPalindrome = "";
        for (int i = chars.length-1; i >= 0; i--) {
            final int iteration = i;
            final int maxSize = chars.length - i;
            longestPalindrome = findLongest(maxSize, longestPalindrome, (j) -> palindrome[j][iteration + j]);
            longestPalindrome = findLongest(maxSize, longestPalindrome, (j) -> palindrome[iteration + j][j]);
        }
        return longestPalindrome;
    }

    private static boolean isPalindrome(String text) {
        return new StringBuilder(text).reverse().toString().equals(text);
    }

    private static String findLongest(int maxSize, String longest, Function<Integer, Character> getChar) {
        StringBuilder builder = new StringBuilder();
        for (int j = 0; j < maxSize; j++) {
            char charTmp = getChar.apply(j);
            if (charTmp == '-') {
                builder = new StringBuilder();
            } else {
                builder.append(charTmp);
                if (isPalindrome(builder.toString())) {
                    if (builder.length() > longest.length()) {
                        longest = builder.toString();
                    }
                }
            }
        }
        return longest;
    }
}
