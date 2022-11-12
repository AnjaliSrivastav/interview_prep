package com.recursion;

import java.util.Arrays;

/*An array is given. return the max value present in an array using recursion.*/
public class MaxOfArray {
    public static void main(String[] args) {
        int []arr = {22,33,4,19,7};
        int max = findMax(arr,0);
        System.out.println("Max Value : "+max);
        int []arr1 = {2,3,6,9,8,3,2,3,6,4};
       int[]iarr = findIndices(arr1,0,3,0);
        System.out.println("Index Array : "+ Arrays.toString(iarr));
    }

    public static int findMax(int[] arr,int idx){
        //base case
        if(idx == arr.length-1){
            return arr[idx];
        }
        int a = findMax(arr,idx + 1);
        int b = arr[idx];
        return Math.max(a,b);

    }

    /*find all indices where (x) is present and return in an array*/
    public static int[] findIndices(int[] arr,int idx,int x,int fsf){
        //base case
        if(idx == arr.length){
            return  new int[fsf];
        }
        /*If arr[idx] is equal to x then, we move to next index and increment the fsf count(it stores the no. of times x occur)*/
        if(arr[idx] == x){
            int[] iarr = findIndices(arr,idx+1,x,fsf+1);
            iarr[fsf] = idx;
            return iarr;
        }else {
            int[] iarr = findIndices(arr,idx+1,x,fsf);
            return iarr;
        }

    }
}
