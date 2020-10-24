package com.example.expressionCalc.service;

import com.example.expressionCalc.math.ExpressionSolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class ExpressionService {
    private final ExpressionSolver expressionsolver;

    @Autowired
    public ExpressionService(@Qualifier("expressionSolverV1") ExpressionSolver expressionsolver) {
        this.expressionsolver = expressionsolver;
    }
    public String infixToPostfix(String expression){
        return expressionsolver.infixToPostfix(expression);
    }
    public int postfixEvaluate(String expression){
        return expressionsolver.postfixEvaluate(expression);
    }

}
