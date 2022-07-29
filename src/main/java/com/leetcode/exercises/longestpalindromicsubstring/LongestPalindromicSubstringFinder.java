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
        if (text.length() == 1) {
            return text;
        }
        char[] chars = text.toCharArray();
        char[][] palindrome = new char[chars.length][chars.length];
        for (int i = 0; i < chars.length; i++) {
            for (int j = 0; j < chars.length; j++) {
                palindrome[i][j] = chars[i] == chars[chars.length - j - 1] ? chars[i] : '-';
            }
        }
        String longest = "";
        for (int i = chars.length-1; i >= 0; i--) {
            StringBuilder builder = new StringBuilder();
            for (int j = 0; j < chars.length-i; j++) {
                char charTmp = palindrome[i+j][j];
                if (charTmp == '-') {
                    builder = new StringBuilder();
                } else {
                    builder.append(charTmp);
                    if (builder.length() > longest.length()) {
                        if (builder.toString().equals(new StringBuilder(builder.toString()).reverse().toString())) {
                            longest = builder.toString();
                        }
                    }
                }
            }
        }
        for (int i = 1; i < chars.length; i++) {
            StringBuilder builder = new StringBuilder();
            for (int j = 0; j < chars.length-i; j++) {
                char charTmp = palindrome[j][j+i];
                if (charTmp == '-') {
                    builder = new StringBuilder();
                } else {
                    builder.append(charTmp);
                    if (builder.length() >= longest.length()) {
                        if (builder.toString().equals(new StringBuilder(builder.toString()).reverse().toString())) {
                            longest = builder.toString();
                        }
                    }
                }
            }
        }
        return longest;
    }
}
