package com.leetcode.exercises.longestpalindromicsubstring;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LongestPalindromicSubstringFinderTest {

    @ParameterizedTest
    @CsvSource(value = {
            "abcba,abcba",
            "abab, aba",
            "cbbd, bb",
            "a, a",
            "bb, bb",
            "ac, a",
            "abb, bb",
            "aacabdkacaa, aca"
    })
    void search(String input, String expected) {
        // Given
        LongestPalindromicSubstringFinder finder = new LongestPalindromicSubstringFinder(input);

        // When
        String palindrome = finder.search();

        //Then
        assertEquals(expected, palindrome);
    }
}