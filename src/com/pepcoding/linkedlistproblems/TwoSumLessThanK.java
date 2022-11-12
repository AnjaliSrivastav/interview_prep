package com.pepcoding.linkedlistproblems;

import java.util.ArrayList;
import java.util.Arrays;

public class TwoSumLessThanK {
    public static void main(String[] args) {
            int []arr = {2,3,4,6,8,10};
        ArrayList<Integer> list = max_Sum(arr,arr.length,10);
       int s = twoSumLessThanK(arr,10);
        System.out.println("list==="+list+ " and the sum is : "+s);

    }

    /*return the max sum of the array which is less than k*/
    public static int twoSumLessThanK(int[] A, int K) {
        int res = -1;
        if(A == null || A.length == 0){
            return res;
        }

        Arrays.sort(A);
        int l = 0;
        int r  = A.length-1;
        while(l<r){
            int sum = A[l] + A[r];
            if(sum < K){
                res = Math.max(res, sum);
                l++;
            }else{
                r--;
            }
        }

        return res;
    }


    /*return a pair of indexes whose sum is less than k*/
    static ArrayList<Integer> max_Sum(int[] arr, int n, int k) {

        if(arr == null || arr.length == 0 || arr.length == 1){
            return new ArrayList<Integer>();
        }


        Arrays.sort(arr);
        int []res = new int[2];

        int i=0;
        int j = arr.length -1;

        while(i<j){

            if(arr[j] > k){
                j--;

            }

            int sum = arr[i] + arr[j];

            if(sum < k){
                res[0] = i;
                res[1] = j;
                i++;
            }if(sum >= k){
                j--;
            }

        }


        ArrayList<Integer> result = new ArrayList<Integer>();
        for(int val : res){
            result.add(val);
        }
        return result;




    }
}
