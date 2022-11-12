package com.binarytrees;

import java.util.*;

public class BinaryTreeEx {
    public static class Node {
        int data;
        Node left;
        Node right;

        Node(int data, Node left, Node right){
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }

    public static class Pair {
        Node node;
        int state;

        Pair(Node node,int state){
            this.node = node;
            this.state = state;
        }
    }

    public static void construct(Integer[] arr,Node root){
        //create a root Pair
        Pair rp = new Pair(root,1);

        Stack<Pair> stack = new Stack<>();
        stack.push(rp);  //initially we will put the root pair into the stack
        int idx = 0;
        while(stack.size()>0){
            Pair tp = stack.peek();
            if(tp.state == 1){
                idx++;
                if(arr[idx]!=null){
                    Node n = new Node(arr[idx],null,null);
                    tp.node.left = n;
                    Pair p = new Pair(n,1);
                    stack.push(p);
                }else{
                    tp.node.left = null;
                }
                tp.state++;
            }else if(tp.state == 2){
                idx++;
                if(arr[idx]!=null){
                    Node n = new Node(arr[idx],null,null);
                    tp.node.right = n;
                    Pair p = new Pair(n,1);
                    stack.push(p);
                }else{
                    tp.node.right = null;
                }
                tp.state++;

            }else{
                stack.pop();
            }
        }
    }

    public static int sum(Node node){
        if(node == null){
            return 0;
        }
        int lsum = sum(node.left);
        int rsum = sum(node.right);
        int tsum = lsum + rsum + node.data;
        return  tsum;
    }
    public static int size(Node node){
        if(node == null){
            return 0;
        }
        int ls = size(node.left);
        int rs = size(node.right);
        int ts = ls +rs +1;
        return ts;

    }
    public static int max(Node node){
        if(node == null){
            return Integer.MIN_VALUE;
        }
        int lmax = max(node.left);
        int rmax = max(node.right);
        int fmax = Math.max(node.data, Math.max(lmax,rmax));

        return fmax;

    }

    public static int height(Node root){
        if(root == null){
            return -1; //-1 for edges and zero for nodes
        }

        int lh = height(root.left);
        int rh = height(root.right);
        int th = Math.max(lh,rh) + 1;
        return th;
    }

    //pre-traversal means :- Left->Root->Right
    public static void treeTraversal(Node node){
        if (node == null){
            return;
        }
        System.out.println(node.data+" in preorder"); // euler left ->pre
        treeTraversal(node.left);
        System.out.println(node.data+" in inorder"); // euler between ->in

        treeTraversal(node.right);
        System.out.println(node.data+" in postorder"); // euler right ->post

    }
    //inorder-traversal means :- Root->Left->Right
    public static void preOrderTraversal(Node node){
        if (node == null){
            return;
        }
        System.out.println(node.data);

        inOrderTraversal(node.left);

        inOrderTraversal(node.right);
    }

    //inorder-traversal means :- Left->Root->Right
    public static void inOrderTraversal(Node node){
        if (node == null){
            return;
        }
        inOrderTraversal(node.left);
        System.out.println(node.data);
        inOrderTraversal(node.right);
    }

    //inorder-traversal means :- Left->Right->Root
    public static void postOrderTraversal(Node node){
        if (node == null){
            return;
        }
        inOrderTraversal(node.left);
        inOrderTraversal(node.right);
        System.out.println(node.data);
    }

    public static void display(Node node){
        //for root node,print the data
        if(node == null){
            return;
        }
        String str = "";
        str+= node.left == null ? "." : node.left.data + "";
        str+= " <- "+node.data + " -> ";
        str+= node.right == null ? "." : node.right.data +"";

        System.out.println(str);
        display(node.left);
        display(node.right);

    }

    public static void levelOrderTraversal(BinaryTreeEx.Node node){
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(node);
        while (queue.size()>0){
            int n = queue.size();
            for(int i=0; i<n; i++){
                Node rn = queue.remove(); //Remove
                System.out.print(rn.data+" "); //Print
                if(rn.left!=null){          //Add Child
                    queue.add(rn.left);
                }

                if(rn.right!=null){
                    queue.add(rn.right);
                }
            }
            System.out.println();
        }
    }

    static List<Integer> pathList;
    public static boolean

    findNodesToRootPath(Node node, int data){
        if(node == null){
            return false;
        }
        if(node.data == data){
            pathList.add(node.data);
            return true;
        }

        boolean filc = findNodesToRootPath(node.left,data);
        if(filc){
            pathList.add(node.data);
            return true;
        }

        boolean firc = findNodesToRootPath(node.right,data);
        if(firc){
            pathList.add(node.data);
            return true;
        }

        return false;
    }

    /*iterative traversal --> Pre-Order/In-Order/Post-Order traversal. */
    public static void iterativeTraversal(Node root){
        Stack<Pair> st = new Stack<>();
        Pair rp = new Pair(root,1);
        st.push(rp);
        String pre = "";
        String in = "";
        String post = "";
        while (st.size()>0){
            Pair tp = st.peek();
            if(tp.state == 1){
                pre+= tp.node.data+ " ";
                tp.state++;
                if(tp.node.left!=null){
                    Pair lp = new Pair(tp.node.left,1);
                    st.push(lp);
                }
            }else if(tp.state == 2){
                in+= tp.node.data+ " ";
                tp.state++;
                if(tp.node.right!=null){
                    Pair rightp = new Pair(tp.node.right,1);
                    st.push(rightp);
                }
            }else{ //tp.state == 3
                post+= tp.node.data+ " ";
                st.pop();
            }
        }

        System.out.println("Pre-Order : "+pre);
        System.out.println("In-Order : "+in);
        System.out.println("Post-Order : "+post);

    }

    public static void printKLevelDown(Node node,int k){

        if(node == null || k < 0){
            return;
        }
        if(k == 0){
            System.out.println("==Node Data=="+node.data);
        }
        printKLevelDown(node.left,k-1);
        printKLevelDown(node.right,k-1);
    }

    static List<Node> path;
    private static boolean findPath(Node node,Node target){
        if(node == null){
            return false;
        }
        if(node == target){
            path.add(node);
            return true;
        }

        boolean filc = findPath(node.left,target);
        if(filc){
            path.add(node);
            return true;
        }

        boolean firc = findPath(node.right,target);
        if(firc){
            path.add(node);
            return true;
        }

        return false;
    }

    private static void rootToLeafPath(Node node,String path){
        if(node == null){
            return;
        }

        if(node.left == null && node.right == null){
            path+= " -> " + node.data;
            System.out.println("Path : "+path);
        }

        path = (path!=null && path.length()>0)? (path + " -> " + node.data) : node.data+"";
        rootToLeafPath(node.left,path);
        rootToLeafPath(node.right,path);

    }

    public static void main(String[] args) {
        Integer[] arr = {50,25,12,null,null,37,30,null,null,40,null,null,75,62,60,null,null,70,null,null,87,null,null};
        //create a root node
        /* Node root = new Node(arr[0],null,null);
         construct(arr,root);
        display(root);
        System.out.println("Size of a binary tree : "+size(root));
        System.out.println("Total sum of all node's data in binary tree :"+sum(root));
        System.out.println("Max of Binary Tree : "+max(root));
        System.out.println("Height of a Binary Tree : "+height(root));
        System.out.println("========================================================================");
        treeTraversal(root);*/

        //Integer[] nums = {50,25,12,37,30,40,75,62,60,70,57};
        Node root = new Node(arr[0],null,null);
        construct(arr,root);
        // levelOrderTraversal(root);
        //System.out.println("Size of a binary tree : "+size(root));

        iterativeTraversal(root);

        pathList = new ArrayList<>();
        findNodesToRootPath(root,40);
        System.out.println("Node to Root Path : "+pathList);
        printKLevelDown(root,3);

        Integer[] nums = {3,5,6,null,null,2,7,null,null,4,null,null,1,0,null,null,8,null,null};
        Node rn = new Node(nums[0],null,null);
        construct(nums,rn);
        //System.out.println("===Root Node Left==="+rn.left+"==Data=="+rn.left.data);

        path = new ArrayList<>();
        findPath(rn,rn.left);
        // path.stream().map(i -> i.data).forEach(System.out::println);

        Integer[] array = {1,2,null,5,null,null,3,null,null};
        Node rootNode = new Node(array[0],null,null);
        construct(array,rootNode);
        //rootToLeafPath(rootNode,"");

        binaryTreePaths(rootNode);

    }


    public static List<String> binaryTreePaths(Node node) {
        List<String> paths = new LinkedList<>();
        if(node == null){
            return paths;
        }

        if(node.left == null && node.right == null){
            paths.add(node.data+"");
            return paths;
        }

        for(String path : binaryTreePaths(node.left)){
            paths.add(node.data+"->"+path);
        }

        for(String path : binaryTreePaths(node.right)){
            paths.add(node.data+"->"+path);
        }

        return paths;

    }
    /*public static List<String> binaryTreePaths(Node root) {
        List<String> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        helper(res, root, sb);
        return res;
    }*/

    private static void helper(List<String> res, Node root, StringBuilder sb) {
        if(root == null) {
            return;
        }
        int len = sb.length();
        sb.append(root.data);
        if(root.left == null && root.right == null) {
            res.add(sb.toString());
        } else {
            sb.append("->");
            helper(res, root.left, sb);
            helper(res, root.right, sb);
        }
        sb.setLength(len);
    }


}
