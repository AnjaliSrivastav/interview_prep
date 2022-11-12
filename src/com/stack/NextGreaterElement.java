package com.stack;

import java.util.Arrays;
import java.util.Stack;

public class NextGreaterElement {
    public static void main(String[] args) {
        int[] arr = {2,5,9,3,1,12,6,8,7};
        System.out.println(Arrays.toString(solve(arr)));
        int []ans = nextSmallerElement(arr);
        System.out.println("Arrays : "+Arrays.toString(ans));

    }

    //TC : O(n) /*next greater element on the right*/
    public static int[] solve(int []arr){
        int[] ans = new int[arr.length];
        Stack<Integer> st = new Stack<>();
        st.push(arr[arr.length - 1]); //push the last element to the stack
        ans[ans.length - 1] = -1; //bcz no element is present to the right of the last element
        for(int i = arr.length-2; i>=0; i--){
            //pop the stack till element present in the stack is less than arr[i] and stack is not empty
            while(st.size()>0 && arr[i] >= st.peek()){
                st.pop();
            }

            if(st.size() == 0){
                ans[i] = -1;
            }else {
                ans[i] = st.peek();
            }

            st.push(arr[i]);
        }
        return ans;
    }

    //TC : O(n) /*next smaller element on the right*/
    public static int []nextSmallerElement(int []arr){
        int[] ans = new int[arr.length];
        Stack<Integer> st = new Stack<>();
        st.push(0);
        for(int i=1; i<arr.length;i++){
            while(st.size() > 0 && arr[i] < arr[st.peek()]){
                int pos = st.peek();
                ans[pos] = arr[i];
                st.pop();
            }
            st.push(i);
        }

        while (st.size()>0){
           int pos = st.peek();
           ans[pos] = -1;
           st.pop();
        }
        return ans;
    }


}
