package com.stack;

import java.util.Stack;

public class CelebrityPrblm {
    public static void main(String[] args) {
        int[][] arr = {{1,1,0},{0,1,0},{1,1,1}};
        findCelebrity(arr);
    }

    public static void findCelebrity(int[][] arr){
        Stack<Integer> st = new Stack<>();
        //push all peoples (o to n-1) into the stack
        for(int i=0; i<arr.length; i++){
            st.push(i);
        }

        //At a time, we need two people to check whether they knows each other or not Or we can say that to find
        //a celebrity. So, we run a loop till stack size is greater tan or equal to 2.
        while (st.size()>=2){
            int i = st.pop();
            int j = st.pop();

            if(arr[i][j] == 1){
                // i knows j -> i is not a celebrity.
                st.push(j);
            }else{
                //i doesn't knows j, thus j is not a celebrity.
                st.push(i);
            }
        }

        //Now, stack contains one person, pop it out.
        int pot = st.pop(); //he is potential candidate of being a celebrity. bcz everybody knows him.But we are not sure about it.

        //We need to verify that he doen't know anybody (0 ton (n-1) people.)
       for(int i=0; i<arr.length; i++){
           if(i!=pot) {
               if (arr[i][pot] == 0 || arr[pot][i] == 1) {
                   System.out.println("There is no celebrity");
                   return;
               }
           }
       }

        System.out.println(pot+ " is the celebrity.");
    }
}
