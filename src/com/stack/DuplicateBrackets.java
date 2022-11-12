package com.stack;

import java.util.Scanner;
import java.util.Stack;

public class DuplicateBrackets {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        Stack<Character> stack = new Stack<>();
        for(int i=0;i<str.length();i++){
            char ch = str.charAt(i);
             if(ch == ')'){
                 if(stack.peek() == '('){
                     System.out.println("true : the string contain duplicate brackets");
                     return;
                 }else{
                     while(stack.peek()!='('){ //pop the characters till the top element is '('
                         stack.pop();
                     }
                     stack.pop(); //pop the opening bracket also.
                 }
             }else{
                 stack.push(ch);
             }
        }

        System.out.println("false : the string doesn't contains duplicate brackets.");
    }
}
