package com.leetcode.exercises.validparenthesis;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class ParenthesisValidatorTest {

    @ParameterizedTest
    @ValueSource(strings = {"{}", "[]", "()", "{}[]()", "{([])}", "{()[]}"})
    void isValid(String text) {
        // Given
        ParenthesisValidator validator = new ParenthesisValidator(text);

        // When
        boolean result = validator.isValid();

        // Then
        assertTrue(result);
    }

    @ParameterizedTest
    @ValueSource(strings = {"{(}", "{)}", "{(})", "]"})
    void isNotValid(String text) {
        // Given
        ParenthesisValidator validator = new ParenthesisValidator(text);

        // When
        boolean result = validator.isValid();

        // Then
        assertFalse(result);
    }

    @ParameterizedTest
    @ValueSource(strings = {"!", "a", "7", "{}1()", ""})
    void illegalParameters(String text) {
        // Then
        assertThrowsExactly(IllegalArgumentException.class, () -> new ParenthesisValidator(text));
    }
}