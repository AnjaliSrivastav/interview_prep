package com.sorting;

import java.util.Arrays;

public class SelectionSortEx {
    public static void main(String[] args) {
       int []arr = {64,25,12,22,11}; //1- {25,64,12,22,11} | 2-> {12,64,25,22,11}. 3-> {11,64,25,22,12}
        selectionSort(arr);
    }

    public static void selectionSort(int []arr){
          int min_idx = 0;  //initialize the min value to location zero
           for(int i=1;i<arr.length;i++){
               if(i+1<arr.length  && arr[i]<arr[i+1]){
                   int temp = arr[min_idx];
                   arr[min_idx] = arr[i];
                   arr[i] = temp;
               }
           }

        System.out.println(Arrays.toString(arr));

    }
}
