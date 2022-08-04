package com.leetcode.exercises.wordbreak;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.HashSet;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class WordBreakerAllTest {


    @ParameterizedTest
    @MethodSource("inputProvider")
    void isBreakable(String[] dict, String text, List<String> expected) {
        // Given
        WordBreakerAll wordBreak = new WordBreakerAll(dict);

        // When
        List<String> sentences = wordBreak.isBreakable(text);

        // Then
        assertIterableEquals(new HashSet<>(expected), new HashSet<>(sentences));
    }

    private static Stream<Arguments> inputProvider() {
        return Stream.of(
                Arguments.of(new String[]{"cat","cats","and","sand","dog"}, "catsanddog", List.of("cats and dog","cat sand dog")),
                Arguments.of(new String[]{"apple","pen","applepen","pine","pineapple"}, "pineapplepenapple", List.of("pine apple pen apple","pineapple pen apple","pine applepen apple")),
                Arguments.of(new String[]{"cats","dog","sand","and","cat"}, "catsandog", List.of())
        );
    }
}
