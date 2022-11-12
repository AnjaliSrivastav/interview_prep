package com.pepcoding.linkedlistproblems;

import java.util.LinkedList;

//Find the kth element from the end in the linkedList
//Constraints: (i) without using size() method either directly or indirectly
//             (ii) Using iteration and single traversal
public class KthElement {
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();

        list.addLast(10);
        list.addLast(20);
        list.addLast(30);
        list.addLast(40);
        list.addLast(50);

        LinkedList<Integer> l1 = new LinkedList<>();
        l1.add(1);l1.add(0);l1.add(0);l1.add(0);l1.add(1);l1.add(0);l1.add(1);l1.add(1);
        System.out.println("List==="+l1);
        arrangeZeroOnes(l1);

        //System.out.println("kth element from the last : "+kthFromLast(4,list));
    }
    public static int kthFromLast(int k,LinkedList<Integer> list ){
        int slow = 0;
        int fast = k;

        int elmAtfast = list.get(fast);
        int elmAtslow = list.get(slow);
        while(elmAtfast!=list.getLast()){
            fast++;
            slow++;
            elmAtfast = list.get(fast);

        }

        return list.get(slow);
    }

    public static void arrangeZeroOnes(LinkedList<Integer> l1){
        LinkedList<Integer> zero = new LinkedList<>();
        LinkedList<Integer> one = new LinkedList<>();
        while(l1.size()>0){
            int val = l1.getFirst();
            l1.removeFirst();
            if(val == 0){
                zero.addLast(val);
            }else if(val == 1){
                one.addLast(val);
            }
        }

        if(one.size()>0 && zero.size()>0){
           for(Integer i : one){
               zero.addLast(i);
           }
        }else if(one.size()>0){
            //if there is no zero in l1
        }else if(zero.size()>0){
            //if there is no one in l1
        }
        System.out.println("Zero List==="+zero);

    }
}
