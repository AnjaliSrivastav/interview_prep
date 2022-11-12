package com.stack;

import java.util.Scanner;
import java.util.Stack;

public class BalancedBrackets {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(ch == '(' || ch == '{' || ch == '['){
                st.push(ch);
            }else if(ch == ')'){
                boolean val = handleClosingBracket(st,'(');
                if(val == false){ return false;}

            }else if(ch == '}'){
                boolean val = handleClosingBracket(st,'{');
                if(val == false){ return false;}
            }else if(ch == ']'){
                boolean val = handleClosingBracket(st,'[');
                if(val == false){ return false;}
            }else{

            }
        }

        if(st.size() == 0){
            return true;
        }else{
            return false;
        }
    }

    public boolean handleClosingBracket(Stack<Character> st,char corrOpeningBr){
        if(st.size() == 0){
            return false;
        }else if(st.peek()!= corrOpeningBr){
            return false;
        }else{
            st.pop();
            return true;
        }
    }

    public static void main(String[] args) {

    }
}
