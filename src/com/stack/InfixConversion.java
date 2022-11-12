package com.stack;

import java.util.Stack;

/*convert infix to postfix and prefix*/
public class InfixConversion {
    public static void main(String[] args) {
        convert("a * (b-c)/d + e");
    }

    /*convert infix to postfix and prefix*/
    public static void convert(String expr){
        Stack<String> post = new Stack<>(); //stack for postfix
        Stack<String> pre = new Stack<>(); //stack for prefix
        Stack<Character> ops = new Stack<>(); //stack for operators (+,-,*,/,),(,)

        for(int i=0; i<expr.length(); i++){
            char ch = expr.charAt(i);

            if(ch == '('){
                ops.push(ch);
            }else if((ch>='a' && ch<='z') || (ch >='A' && ch <= 'Z') || (ch >='0' && ch <='9')){
                post.push(ch +"");
                pre.push(ch +"");
            }else if(ch == ')'){
                while (ops.peek()!='('){
                    operation(post,pre,ops);
                }
                //pop the opening bracket also
                ops.pop();
            }else if(ch == '+' || ch == '-' || ch == '*' || ch == '/'){
                     while (ops.isEmpty()!=true && ops.size() > 0 && ops.peek()!='(' && precedence(ch) <= precedence(ops.peek())){
                         operation(post,pre,ops);
                     }
                     ops.push(ch); //push the character(operator) now.
            }
        }
        //after the expression(expr) is traversed,it is possible that the operator stack(ops)
        // may have some value left. Thus, we need to pop the elements from the ops till its size is not zero
        while (ops.isEmpty()!=true && ops.size() > 0){
            operation(post,pre,ops);
        }

        //finally pop out the result present pre/post stack
        System.out.println(pre.pop());
        System.out.println(post.pop());
    }

    public static void operation(Stack<String> post,Stack<String> pre,Stack<Character> ops){
        //pop the operator from the operator stack
        char op = ops.pop();
        String preval2 = pre.pop();
        String preval1 = pre.pop();
        String prev = op + preval1 + preval2;

        pre.push(prev);

        String postval2 = post.pop();
        String postval1 = post.pop();
        String postv = postval1 + postval2 + op;

        post.push(postv);
    }
    public static int precedence(char ch){
        if(ch == '+' || ch == '-'){
            return 1;
        }else if(ch == '*' || ch == '/'){
            return 2;
        }else{
            return 0;
        }
    }
}
