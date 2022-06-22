package model.Expression;

import model.Interpreter.SymbolTable;
import model.Interpreter.Variable;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ExpressionEvaluator {
    public static double evaluate(String exp) {
        Stack<Expression> s = new Stack<>();

        Queue<String> q = infixToPostfix(exp);

        for (String token : q) {
            if (isDouble(token)) {
                s.push(new Number(Double.parseDouble(token)));
            } else {
                Expression right = s.pop();
                Expression left = s.pop();

                switch (token) {
                    case "+":
                        s.push(new Plus(left, right));
                        break;
                    case "-":
                        s.push(new Minus(left, right));
                        break;
                    case "*":
                        s.push(new Mul(left, right));
                        break;
                    case "/":
                        s.push(new Div(left, right));
                        break;
                }
            }
        }

        return Math.floor(s.pop().calculate() * 1000) / 1000;
    }

    private static Queue<String> infixToPostfix(String exp) {
        Queue<String> q = new LinkedList<>();
        Stack<String> s = new Stack<>();

        exp = exp.replaceAll("\\s+", "");
        exp = exp.replaceAll("--", "+");
        exp = exp.replaceAll("(^-)|((?<=[(])-)", "0-");




        String[] tokens = exp.split("(?<=[-+*/()])|(?=[-+*/()])");

        for (String token : tokens) {
            if (isDouble(token)) {
                q.add(token);
            } else {
                switch (token) {
                    case "*":
                    case "/":
                        while (!s.empty() && s.peek().matches("^[*/]$")) {
                            q.add(s.pop());
                        }
                        s.push(token);
                        break;
                    case "(":
                        s.push(token);
                        break;
                    case "+":
                    case "-":
                        while (!s.empty() && !s.peek().equals("(")) {
                            q.add(s.pop());
                        }
                        s.push(token);
                        break;
                    case ")":
                        while (!s.empty() && !s.peek().equals("(")) {
                            q.add(s.pop());
                        }
                        s.pop();
                        break;
                }
            }
        }

        while (!s.empty()) {
            q.add(s.pop());
        }

        return q;
    }

    public static Double tryEvaluate(String exp) {
        try {
            double res = evaluate(exp);
            return res;
        } catch (Exception e) {
            return null;
        }
    }

    public static boolean isDouble(String s) {
        try {
            Double.parseDouble(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static boolean isExpression(String exp) {
        return exp.matches("^[-+*/()0-9.]+$");
    }

    public static String replaceVarWithVal(String exp, SymbolTable symbolTable) {
        for(Variable var : symbolTable.getVariables()) {
            exp = exp.replaceAll(var.getName(), Double.toString(var.getValue()));
        }
        return exp;
    }


    public static void main(String[] args) {
        System.out.println(evaluate("(1+2)*3") == 9);
        System.out.println(evaluate("1+2*3") == 7);
        System.out.println(evaluate("1+2*3+4") == 11);
        System.out.println(evaluate("1+2*3+4*5") == 27);
        System.out.println(evaluate("1+2*3+4*5+6") == (1+6+20+6));
        System.out.println(evaluate("1--1") == 2);
        System.out.println(evaluate("(1+2*3+4)*5+6*7") == (55 + 42));

    }
}
