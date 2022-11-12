package com.pepcoding.linkedlistproblems;

import java.util.LinkedList;

/*implement a stack using LinkedList*/
public class ListToStackAdapter {
    LinkedList<Integer> list;
    ListToStackAdapter(){
        list = new LinkedList<>();
    }

    public int size(){
        return list.size();
    }

    public void push(int data){
        list.addFirst(data);
    }

    public int pop(){
        if(size() == 0){
            System.out.println(" Stack underflow");
            return -1;
        }else{
            return list.removeFirst();
        }
    }

    public int top(){
        if(size() == 0){
            System.out.println(" Stack underflow");
            return -1;
        }else{
            return list.getFirst();
        }
    }

    public void display(){
        for(Integer i : list){
            System.out.print(i+" ");
        }
    }



}

class Test{
    public static void main(String[] args) {
         //create a stack using linkedList
        ListToStackAdapter stack = new ListToStackAdapter();
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);
        stack.push(50);

        stack.display();
        System.out.println("Top Element: "+stack.top());
        System.out.println("Pop Element: "+stack.pop());
        System.out.println("==========After POP=====");
        stack.display();

    }
}
