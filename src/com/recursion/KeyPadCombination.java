package com.recursion;

/*Given : To each number(from 0 to 9), some words are assigned. Now, in i/p if some number is given, we need to return the
list of all words possible from the combination of these words. */
//Given String []codes = {".;", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tu", "vwx", "yz"};
//eg:- I/P : 678
// O/P :- [ptu, ptw, ptx, puv, puw, pux,
//         qtu, qtw, qtx, quv, quw, qux,
//         rtu, rtw, rtx, ruv, ruw, rux,
//         stu, stw, stx, suv, suw, sux,]

import java.util.ArrayList;
import java.util.List;

public class KeyPadCombination {
    public static void main(String[] args) {
        List<String> list = getKPC("678");
        System.out.println("list Size : "+list.size());
        System.out.println("KeyPad Combination List : "+list);
    }

    /*get KeyPad Combination*/
    static String []codes = {".;", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tu", "vwx", "yz"};
    public static List<String> getKPC(String str){  //str ->678
        //base case
        if(str.length() == 0){
            ArrayList<String> bres = new ArrayList<>();
            bres.add("");
            return  bres;
        }
        char ch = str.charAt(0); // '6'
        String ros = str.substring(1); //ros -> rest of String ->78
        List<String> rres = getKPC(ros); // [tu, tw, tx, uv, uw, ux]

        String codeforch = codes[ch - '0']; // (ch - '0') -> will convert ch('6') into 6(int value)
        //codeforch is "pqrs"

        ArrayList<String> myList = new ArrayList<>();
        for(int i=0; i<codeforch.length();i++){
            char chcode = codeforch.charAt(i);
            for(String rstr : rres){  // [tu, tw, tx, uv, uw, ux]
                myList.add(chcode + rstr);
            }
        }

        return myList;
    }
}
