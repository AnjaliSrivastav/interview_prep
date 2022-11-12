package com.stack;

import java.util.Stack;

public class PostFixConversion {
    public static void main(String[] args) {
        String expr = "264*8/+3-";
        conversion(expr);
    }

    /*conversion of postfix to infix and prefix*/
    public static void conversion(String expr){
        Stack<Integer> vs = new Stack<>(); //store the integer values
        Stack<String> infix = new Stack<>();
        Stack<String> prefix = new Stack<>();

        for(int i=0; i<expr.length(); i++){
            char ch = expr.charAt(i);

            if(ch == '+' || ch == '-' || ch == '*' || ch == '/'){ //if operator comes
                //pop the values from the value stack
                int v2 = vs.pop();
                int v1 = vs.pop();
                int val = operation(ch,v1,v2);
                vs.push(val);

                String inv2 = infix.pop();
                String inv1 = infix.pop();

                String inval = "(" + inv1 + ch + inv2 +")";
                infix.push(inval);

                String prev2 = prefix.pop();
                String prev1 = prefix.pop();

                String preval = ch + prev1 + prev2;
                prefix.push(preval);

            }else{ //if operand comes
                vs.push(ch - '0');
                infix.push(ch + "");
                prefix.push(ch + "");
            }
        }

        System.out.println("Value Stack : "+vs.pop());
        System.out.println("Infix val : "+infix.pop());
        System.out.println("prefix val : "+prefix.pop());
    }

    public static int operation(char ch, int val1, int val2){
        if(ch == '+'){
            return val1 + val2;
        }else if(ch == '-'){
            return val1 - val2;
        }else if(ch == '*'){
            return val1 * val2;
        }else{
            return val1/val2;
        }
    }
}
