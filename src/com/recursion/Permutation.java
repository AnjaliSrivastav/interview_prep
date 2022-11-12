package com.recursion;

public class Permutation {
    public static void main(String[] args) {
        printPermutation("abc","");
    }
    public static void printPermutation(String str,String asf){
        //base case
        if(str.length() == 0){
            System.out.println(asf);
        }
        for(int i=0;i<str.length();i++){
           char ch = str.charAt(i);
           String qlpart = str.substring(0,i);
           String qrpart = str.substring(i + 1);
           String roq = qlpart + qrpart;
           printPermutation(roq,asf + ch);

        }
    }
}
