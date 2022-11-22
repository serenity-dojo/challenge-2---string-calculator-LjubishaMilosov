package com.serenitydojo.calculator;

public class Calculator {
    public int evaluate(String expression) throws IllegalMathOperatorException{

        int left = 0;
        if (!expression.isEmpty()) {
            String[] components = expression.split(" ");

            int right;
            String operator = "+";

            for (String component : components) {
                try {
                    right = Integer.parseUnsignedInt(component);
                    left = calculate(left, operator, right);
                } catch (NumberFormatException e) {
                    operator = component;
                }
            }
        }
        return left;
    }

    private int calculate(int left, String operation, int right) throws IllegalMathOperatorException {
        int result;
        switch (operation) {
            case "+": {
                result = left + right;
                break;
            }
            case "-": {
                result = left - right;
                break;
            }
            case "*": {
                result = left * right;
                break;
            }
            default: {
                throw new IllegalMathOperatorException("Operation " + operation);
            }
        }
        return result;
    }
}
