package com;

public class Test {
    public static void main(String[] args) {
        int i=0;
        int num=0;
        while (i<4) {

            num = (i++ * 5);
            System.out.println(num);
        }

        boolean ans = false;
        if (ans = true) {
            System.out.println("Done");
        } else {
            System.out.println("Fail");
        }

        String s = "welcome";
        for(int j = s.length()-1;j>=0;j--){
            System.out.print(s.charAt(j)+" ");
        }
    }
}
