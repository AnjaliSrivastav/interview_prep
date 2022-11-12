package com.recursion;

import java.util.ArrayList;
import java.util.List;

public class SubSequenceOfString {
    public static void main(String[] args) {
        String s = "abc";
       List<String> res = getSubSequence(s);
        System.out.println("SubSequence List : "+res+"---Size---"+res.size());
    }

    public static List<String> getSubSequence(String s){
        //base case
        if(s.length() == 0){
            List<String> res = new ArrayList<>();
            res.add("");
            return res;
        }
        char ch = s.charAt(0);
        String s2 = s.substring(1);
        List<String> smsubseq = getSubSequence(s2);
        List<String> res = new ArrayList<>();
        for(String seq : smsubseq){
            res.add("" +seq);
            res.add(ch+seq);

        }

        return res;
    }


}
