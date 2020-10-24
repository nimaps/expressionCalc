package com.example.firsttest.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Expression {
    private String infix, postfix, toEvaluate;

    public Expression(String infix) {
        this.infix = infix;
    }

    public Expression(@JsonProperty("infix") String infix, @JsonProperty("postfix") String postfix) {
        this.infix = infix;
        this.postfix = postfix;
    }

    public String getInfix() {
        return infix;
    }

    public void setInfix(String infix) {
        this.infix = infix;
    }

    public String getPostfix() {
        return postfix;
    }

    public String getToEvaluate() {
        return toEvaluate;
    }

    public void setToEvaluate(String toEvaluate) {
        this.toEvaluate = toEvaluate;
    }

    public void setPostfix(String postfix) {
        this.postfix = postfix;
    }
}
