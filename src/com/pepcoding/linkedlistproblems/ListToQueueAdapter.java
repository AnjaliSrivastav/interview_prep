package com.pepcoding.linkedlistproblems;

import java.util.LinkedList;

public class ListToQueueAdapter {
    LinkedList<Integer> list;

    ListToQueueAdapter(){
        list = new LinkedList<>();
    }

    public int size(){
        return list.size();
    }
    public void add(int data){
        //add to last
        list.addLast(data);
    }

    public int remove(){
       if(size() == 0){
           System.out.println("Queue underflow");
           return -1;
       }else{
           //remove from first
           return list.removeFirst();
       }
    }

    public int peek(){
        if(size() == 0){
            System.out.println("Queue underflow");
            return -1;
        }else{
            //remove from first
            return list.getFirst();
        }
    }

    public void display(){
        for(Integer i : list){
            System.out.print(i+" ");
        }
    }
}

  class QueueTest{
    public static void main(String[] args) {
        //create a stack using linkedList
        ListToQueueAdapter queue = new ListToQueueAdapter();
        queue.add(10);
        queue.add(20);
        queue.add(30);
        queue.add(40);
        queue.add(50);

        queue.display();
        System.out.println("First Element: "+queue.peek()+ " And size=="+queue.size());
        System.out.println("Remove Element: "+queue.remove());
        System.out.println("==========After Removal=====");
        queue.display();

    }
}
