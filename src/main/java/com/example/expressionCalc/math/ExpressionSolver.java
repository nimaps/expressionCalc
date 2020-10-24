package com.example.expressionCalc.math;


public interface ExpressionSolver {
    String infixToPostfix(String expression);
    int postfixEvaluate(String expression);
}
