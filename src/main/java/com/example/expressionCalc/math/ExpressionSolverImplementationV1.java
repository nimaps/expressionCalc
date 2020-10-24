package com.example.expressionCalc.math;


import org.springframework.stereotype.Repository;

import java.util.Stack;

@Repository("expressionSolverV1")
public class ExpressionSolverImplementationV1 implements ExpressionSolver{

    public int priority(char ch)
    {
        switch (ch)
        {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return 3;
        }
        return -1;
    }

    @Override
    public String infixToPostfix(String exp) {
        String result = new String("");
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i<exp.length(); ++i)
        {
            char c = exp.charAt(i);
            if (Character.isLetterOrDigit(c))
                result += c;
            else if (c == '(')
                stack.push(c);
            else if (c == ')') {
                while (!stack.isEmpty() && stack.peek() != '(')
                    result += stack.pop();

                if (!stack.isEmpty() && stack.peek() != '(')
                    return null;
                else
                    stack.pop();
            }
            else
            {
                while (!stack.isEmpty() && priority(c) <= priority(stack.peek())){
                    if(stack.peek() == '(')
                        return null;
                    result += stack.pop();
                }
                stack.push(c);
            }

        }
        while (!stack.isEmpty()){
            if(stack.peek() == '(')
                return null;
            result += stack.pop();
        }
        return result;
    }

    @Override
    public int postfixEvaluate(String exp) {
            Stack<Integer> stack = new Stack<>();

            for(int i = 0; i < exp.length(); i++)
            {
                char c = exp.charAt(i);
                if(c == ' ')
                    continue;
                else if(Character.isDigit(c))
                {
                    int n = 0;
                    while(Character.isDigit(c))
                    {
                        n = n*10 + (int)(c-'0');
                        i++;
                        c = exp.charAt(i);
                    }
                    i--;
                    stack.push(n);
                }
                else
                {
                    int val1 = stack.pop();
                    int val2 = stack.pop();
                    switch(c)
                    {
                        case '+':
                            stack.push(val2+val1);
                            break;
                        case '-':
                            stack.push(val2- val1);
                            break;
                        case '/':
                            stack.push(val2/val1);
                            break;
                        case '*':
                            stack.push(val2*val1);
                            break;
                    }
                }
            }
            return stack.pop();
    }
}
