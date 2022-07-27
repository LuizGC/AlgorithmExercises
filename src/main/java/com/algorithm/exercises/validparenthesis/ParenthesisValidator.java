package com.algorithm.exercises.validparenthesis;

import java.util.Collection;
import java.util.Map;
import java.util.Optional;
import java.util.Stack;

public final class ParenthesisValidator {

    private static final Map<Character, Character> PARENTHESIS_GROUP = Map
            .of(')', '(', '}', '{', ']', '[');
    private static final Collection<Character> KEYS = PARENTHESIS_GROUP.keySet();

    private final String text;

    public ParenthesisValidator(final String text) {
        this.text = Optional.ofNullable(text).orElse("").strip();
        if (!this.text.replaceAll("[\\[\\](){}]", "").isEmpty()) {
            throw new IllegalArgumentException("Only '[', ']', '(', ')', '{' and '}' are valid input!");
        }
    }

    public boolean isValid() {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            if (KEYS.contains(c)) {
                char stackItem = stack.pop();
                char openParenthesisEquivalent = PARENTHESIS_GROUP.get(c);
                if (openParenthesisEquivalent != stackItem) {
                    return false;
                }
            } else {
                stack.push(c);
            }
        }
        return stack.empty();
    }

}
