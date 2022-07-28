package com.algorithm.exercises.reversepolishnotation;

import java.util.Collection;
import java.util.Map;
import java.util.Stack;
import java.util.function.BiFunction;

/*
2 Evaluate Reverse Polish Notation

Evaluate the value of an arithmetic expression in Reverse Polish Notation.
Valid operators are +, -, *, /. Each operand may be an integer or another
expression.
Some examples:
["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6
 */
public class PolishNotationCalculator {

    private static final Map<String, BiFunction<Integer, Integer, Integer>> OPERATIONS = Map.of(
            "+", Integer::sum,
            "-", (a, b) -> a - b,
            "*", (a, b) -> a * b,
            "/", (a, b) -> a / b
    );

    private static final Collection<String> ALLOWED_OPERATION = OPERATIONS.keySet();
    private final String[] expresion;

    public PolishNotationCalculator(String... expresion) {
        this.expresion = expresion;
    }

    public int evaluate() {
        Stack<Integer> stack = new Stack<>();
        for (String operation : expresion) {
            if(ALLOWED_OPERATION.contains(operation)) {
                int b = stack.pop();
                int a = stack.pop();
                int result = OPERATIONS.get(operation).apply(a, b);
                stack.push(result);
            } else {
                stack.push(Integer.valueOf(operation));
            }
        }
        if (stack.size() > 1) {
            throw new IllegalStateException();
        }
        return stack.pop();
    }

    public String toAlgebraic() {
        Stack<Integer> stack = new Stack<>();
        StringBuilder builder = new StringBuilder();
        for (String operation : expresion) {
            if(ALLOWED_OPERATION.contains(operation)) {
                if (stack.size() > 1) {
                    int b = stack.pop();
                    int a = stack.pop();
                    if (expresion.length > 3) {
                        builder.append("(");
                    }
                    builder.append(a);
                    addOperation(builder, operation);
                    builder.append(b);
                    if (expresion.length > 3) {
                        builder.append(")");
                    }
                } else {
                    addOperation(builder, operation);
                    int a = stack.pop();
                    builder.append(a);
                }
            } else {
                stack.push(Integer.valueOf(operation));
            }
        }
        if(builder.length() == 0) {
            builder.append(stack.pop());
        }
        return builder.append(" = ")
                .append(evaluate())
                .toString();
    }

    private void addOperation(StringBuilder builder, String operation) {
        builder.append(" ")
                .append(operation)
                .append(" ");
    }
}
