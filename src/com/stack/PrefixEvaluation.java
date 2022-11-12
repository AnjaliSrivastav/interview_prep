package com.stack;

import java.util.Stack;

/*evaluate the given prefix expression, return a value.
* And convert the prefix expression into postfix and infix expression.*/
public class PrefixEvaluation {
    public static void main(String[] args) {
        String expr = "-+2/*6483";
        evaluateAndConvert(expr);
    }

    public static void evaluateAndConvert(String expr){
        Stack<Integer> vs = new Stack<>();
        Stack<String> is = new Stack<>();
        Stack<String> ps = new Stack<>();

        for(int i=expr.length()-1; i>=0; i--){
            char ch = expr.charAt(i);
            if(ch == '+' || ch == '-' || ch == '*' || ch == '/'){
                //evaluate the string
                int v1 = vs.pop();
                int v2 = vs.pop();
                int val = operation(v1,v2,ch);
                vs.push(val);

                //conversion to infix
                String inv1 = is.pop();
                String inv2 = is.pop();
                String inval = "(" +inv1 + ch + inv2 + ")";
                is.push(inval);

                //conversion to postfix
                String posv1 = ps.pop();
                String posv2 = ps.pop();
                String posval = posv1 + posv2 + ch;
                ps.push(posval);

            }else{     // if operand comes, push them into the vs as digit, and into is,ps as String
                vs.push(ch - '0');
                is.push(ch + "");
                ps.push(ch + "");
            }

        }

        System.out.println("Value : "+vs.pop());
        System.out.println("Infix : "+is.pop());
        System.out.println("Postfix : "+ps.pop());

    }

    public static int operation(int v1, int v2, char ch){
        if(ch == '+'){
            return v1+v2;
        }else if(ch == '-'){
            return v1-v2;
        }else if(ch == '*'){
            return v1*v2;
        }else {
            return v1/v2;
        }
    }
}
