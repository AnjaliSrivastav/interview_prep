package com.stack;

import java.util.Arrays;
import java.util.Stack;

public class SlidingWindowMax {
    public static void main(String[] args) {
        int[]nums = {1,3,-1,-3,5,3,6,7};
        int k = 3;
        maxSlidingWindow(nums,k);
    }

    public static int[] maxSlidingWindow(int[] nums, int k) {
        int[] nge = nextGreater(nums);

        System.out.println("Array : "+ Arrays.toString(nums));
        System.out.println("Next Greater Array : "+ Arrays.toString(nge));
        int n = nums.length;
        int[] res = new int[n-k+1];
        int j=0;
        for(int i=0; i<=n-k; i++){
            if(j<i){
                j = i;
            }
            while(nge[j] < i+k){
                j = nge[j];
            }
            res[i] = nums[j];
        }
        System.out.println("Result Arrary : "+Arrays.toString(res));
        return res;
    }

    public static int[] nextGreater(int[] nums){
        int[] nge = new int[nums.length];
        int n = nums.length;
        nge[nums.length-1] = n;
        Stack<Integer> st = new Stack<>();
        st.push(n-1);

        for(int i=n-2;i>=0;i--){
            while(st.size()>0 && nums[i]>=nums[st.peek()]){
                st.pop();
            }

            if(st.size() == 0){
                nge[i] = n;
            }else{
                nge[i] = st.peek();
            }

            st.push(i);

        }
        return nge;
    }
}
