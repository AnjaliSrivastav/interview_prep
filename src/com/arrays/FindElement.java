package com.arrays;

public class FindElement {
    public static void main(String[] args) {
        int[] arr = {1, 2, 4, 6, 7, 5};
        getElement(arr);
        print(arr);
    }

    /*second largest element -> 2 linear loops*/
    public static void getElement(int []nums){
        int large = Integer.MIN_VALUE;
        int second_large = Integer.MIN_VALUE;
        for(int i : nums){
            large = Math.max(i,large);
        }

        for(int i : nums){
            if (i > second_large && i!=large)
                second_large = i;
        }

        System.out.println("Second Large :"+second_large);

    }

    /*second largest element -> 1 linear loops*/
    static private int secondLargest(int[] arr, int n)
    {
        if(n<2)
            return -1;
        int large = Integer.MIN_VALUE;
        int second_large = Integer.MIN_VALUE;
        int i;
        for (i = 0; i < n; i++)
        {
            if (arr[i] > large)
            {
                second_large = large;
                large = arr[i];
            }

            else if (arr[i] > second_large && arr[i] != large)
            {
                second_large = arr[i];
            }
        }
        return second_large;
    }

    /*check is an array is sorted*/
    static boolean isSorted(int arr[], int n) {
        for (int i = 1; i < n; i++) {
            if (arr[i] < arr[i - 1])
                return false;
        }

        return true;
    }

    /*I/P : int arr[] = {1,1,2,2,2,3,3};*/
    static int removeDuplicates(int[] arr) {
        int i = 0;
        for (int j = 1; j < arr.length; j++) {
            if (arr[i] != arr[j]) {
                i++;
                arr[i] = arr[j];
            }
        }
        return i + 1;
    }

    /*/left-rotate-the-array-by-one/*/
    static void leftRotate(int arr[], int n) {
        int temp = arr[0]; // storing the first element of array in a variable
        for (int i = 0; i < n - 1; i++) {
            arr[i] = arr[i + 1];
        }
        arr[n - 1] = temp; // assigned the value of variable at the last index
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i]+" ");
        }


    }


    public static void print(int []arr){
            for(int i=1;i<arr.length;i=i*2){
                System.out.println("Val of i : "+i);
                System.out.println("==ABC===");
            }

    }
}
