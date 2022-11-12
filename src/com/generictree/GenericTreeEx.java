package com.generictree;

import com.binarytrees.BinaryTreeEx;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.Stack;
public class GenericTreeEx {
    //Each Node has data/value and some children node.
    static class Node {
        int data;
        ArrayList<Node> children = new ArrayList<>();

    }

    public static void display(Node node){
        String str = node.data + " -> ";
        for(Node child : node.children){
            str+= child.data + ",";
        }
        str+= ".";
        System.out.println(str); //this str have root node and it's child data
        //to print other child nodes data
        for(Node child : node.children){
            display(child);
        }

    }

    public static int size(Node node){
        int size = 0; // for the node argument
        for(Node child : node.children){
           int cs = size(child);
           size+=cs;
        }
        size+=1;

        return size;
    }

    public static int max(Node node){
        int max = -1;
        return -1;
    }
    public static void main(String[] args) {
        //Euler Path
        int[]arr = {10,20,50,-1,60,-1,-1,30,70,-1,80,110,-1,120,-1,-1,90,-1,-1,40,100,-1,-1,-1};

        //Create a Stack of Node, and push/pop elements of the Euler array using this stack.
        Stack<Node> stack = new Stack<>();
        Node root = null;
        //1. traverse the Euler Path array
         for(int i = 0; i < arr.length; i++ ){
             if(arr[i] == -1){
                 stack.pop();
             }else {
                 //create a Node
                 Node t = new Node();
                 t.data = arr[i];

                 //if stack's size is not zero, then
                 if(stack.size() > 0){
                     stack.peek().children.add(t);
                 }else{
                     root = t;
                 }

                 stack.push(t);

             }
         }

        display(root);
        System.out.println("Size of the tree : "+size(root));
    }

}
