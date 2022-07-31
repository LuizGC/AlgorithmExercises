package com.leetcode.exercises.longestpalindromicsubstring;

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
        if (text.length() == 2) {
            return String.valueOf(text.charAt(0));
        }
        char[][] palindromeMatrix = new char[text.length()][text.length()];
        for (int i = 0; i < text.length(); i++) {
            for (int j = 0; j < text.length(); j++) {
                palindromeMatrix[i][j] = text.charAt(i) == text.charAt(text.length() - j - 1) ? text.charAt(i) : '-';
            }
        }
        return findLongestPalindrome(text.length(), palindromeMatrix);
    }

    private static String findLongestPalindrome(int textLength, char[][] palindrome) {
        String longestPalindrome = "";
        for (int iteration = textLength - 1; iteration >= 0; iteration--) {
            int maxSize = textLength - iteration;
            StringBuilder left = new StringBuilder();
            StringBuilder right = new StringBuilder();
            for (int j = 0; j < maxSize; j++) {
                left = checkPalindrome(left, palindrome[j][iteration + j]);
                right = checkPalindrome(right, palindrome[iteration + j][j]);
                longestPalindrome = checkLongest(longestPalindrome, left.toString());
                longestPalindrome = checkLongest(longestPalindrome, right.toString());
            }
        }
        return longestPalindrome;
    }

    private static String checkLongest(String longestPalindrome, String newPalindrome) {
        if (longestPalindrome.length() < newPalindrome.length() && isPalindrome(newPalindrome)) {
            return newPalindrome;
        } else {
            return longestPalindrome;
        }
    }

    private static boolean isPalindrome(String text) {
        return new StringBuilder(text).reverse().toString().equals(text);
    }

    private static StringBuilder checkPalindrome(StringBuilder builder, char charTmp) {
        if (charTmp == '-') {
            return new StringBuilder();
        } else {
            return builder.append(charTmp);
        }
    }
}
