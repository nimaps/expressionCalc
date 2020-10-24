package com.example.expressionCalc.api;


import com.example.expressionCalc.service.ExpressionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RequestMapping("/api/expressionsolver")
@RestController
public class ExpressionController {
    private final ExpressionService expressionservice;

    @Autowired
    public ExpressionController(ExpressionService expressionservice) {
        this.expressionservice = expressionservice;
    }

    @GetMapping(path="/infixtopostfix")
    public String infixToPostfix(@RequestParam(name="infix") String expressionString){
        return expressionservice.infixToPostfix(expressionString);
    }
    @GetMapping(path="/evaluate")
    public int postfixEvaluate(@RequestParam(name="postfix") String expressionString){
        return expressionservice.postfixEvaluate(expressionString);
    }
}