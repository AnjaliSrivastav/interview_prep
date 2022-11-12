package com.stack;

import java.util.Stack;

public class InfixEvaluation {
    public static void main(String[] args) {
        String str = "2+(5-3*6/2)";
        evaluate(str);
    }

    public static void evaluate(String expr){
        Stack<Integer> oprndStack = new Stack<>();
        Stack<Character> oprtorStack = new Stack<>();
        for(int i=0; i<expr.length(); i++){
            char ch = expr.charAt(i);
            if(Character.isDigit(ch)){
                oprndStack.push(ch - '0'); //char to int conversion
            }else if(ch == '+' || ch == '-' || ch == '*' || ch == '/'){
                //ch is wanting higher priority to solve first
                while (oprtorStack.isEmpty()!=true && oprtorStack.size() > 0 && oprtorStack.peek()!='(' && precedence(ch)<=precedence(oprtorStack.peek())){
                    char oprtr = oprtorStack.pop();
                    int val2 = oprndStack.pop();
                    int val1 = oprndStack.pop();
                    int opval = operation(val1,val2,oprtr);
                    oprndStack.push(opval);
                }
                //ch is pushing itself now
                oprtorStack.push(ch);
            }else if(ch == '('){
                oprtorStack.push(ch);
            }else if(ch == ')'){
                while (oprtorStack.peek()!='('){
                    char oprnd = oprtorStack.pop();
                    int val2 = oprndStack.pop();
                    int val1 = oprndStack.pop();
                    int opval = operation(val1,val2,oprnd);
                    oprndStack.push(opval);
                }
                oprtorStack.pop(); //popped the opening bracket
            }
        }

        while (oprtorStack.size()!=0){
            char oprnd = oprtorStack.pop();
            int val2 = oprndStack.pop();
            int val1 = oprndStack.pop();
            int opval = operation(val1,val2,oprnd);
            oprndStack.push(opval);
        }
        System.out.println("Value==="+oprndStack.peek());


    }

    public static int operation(int val1,int val2,char ch){
        if(ch == '+'){
            return val1 + val2;
        }else if(ch == '-'){
            return val1 - val2;
        }else if(ch == '*'){
            return val1*val2;
        }else{
            return val1/val2;
        }
    }
    public static int precedence(char ch){
        if(ch == '+' || ch == '-'){
            return 1;
        }else if(ch == '*' || ch == '/'){
            return 2;
        }else {
            return 0;
        }
    }
}
