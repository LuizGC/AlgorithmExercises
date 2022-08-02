package com.leetcode.exercises.wordbreak;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class WordBreakerTest {


    @ParameterizedTest
    @MethodSource("inputProvider")
    void isBreakable(String[] dict, String text, boolean expected) {
        // Given
        WordBreaker wordBreak = new WordBreaker(dict);

        // When
        boolean isBreakable = wordBreak.isBreakable(text);

        // Then
        assertEquals(expected, isBreakable);

    }

    private static Stream<Arguments> inputProvider() {
        return Stream.of(
                Arguments.of(new String[]{"leet", "code"}, "leetcode", true),
                Arguments.of(new String[]{"apple","pen"}, "applepenapple", true),
                Arguments.of(new String[]{"cats","dog","sand","and","cat"}, "catsandog", false),
                Arguments.of(new String[]{"aaaa","aaa"}, "aaaaaaa", true),
                Arguments.of(new String[]{"a","abc","b","cd"}, "abcd", true),
                Arguments.of(new String[]{"bc","ca"}, "cbca", false),
                Arguments.of(new String[]{"cc","ac"}, "ccaccc", true),
                Arguments.of(new String[]{"cats","dog","sand","and","cat","an"}, "catsandogcat", true),
                Arguments.of(new String[]{"cbc","bcda","adb","ddca","bad","bbb","dad","dac","ba","aa","bd","abab","bb","dbda","cb","caccc","d","dd","aadb","cc","b","bcc","bcd","cd","cbca","bbd","ddd","dabb","ab","acd","a","bbcc","cdcbd","cada","dbca","ac","abacd","cba","cdb","dbac","aada","cdcda","cdc","dbc","dbcb","bdb","ddbdd","cadaa","ddbc","babb"}, "bccdbacdbdacddabbaaaadababadad", true),
                Arguments.of(new String[]{"a","b","bbb","bbbb"}, "bb", true),
                Arguments.of(new String[]{"cats","cat","dog","ski"}, "catskicatcats", true),
                Arguments.of(new String[]{"a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa"}, "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab", false)
                );
    }
}
