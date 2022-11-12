package com.pepcoding.linkedlistproblems;

public class LinkedListImpl {
    public static class LinkedList {
       Node head;
       Node tail;
       int size;

       //add at first index
       public void addFirst(int data){
           Node firstNode = new Node();
           firstNode.data = data;
           firstNode.next = head;
           head = firstNode;

           if(size == 0){
               tail = firstNode;
           }
           size++;
       }

       //add at last index
       public void addLast(int data){
           Node lastNode = new Node();
           lastNode.data = data;
           lastNode.next = null;
           if(size == 0){
              head = tail = lastNode;
           }else{
               tail.next = lastNode;
               tail = lastNode;
           }
           size++;
       }

       //add at index (idx)
      public void addAt(int data,int index){

          if(index < 0 || index >size) {
              System.out.println("Invalid Argument");
          }else if(index == 0){
              addFirst(data);
          }else if(index == size){
              addLast(data);
          }else{
              Node temp = head;
              for(int i=0;i<index-1;i++){
                   temp = temp.next;
              }
              Node new_node = new Node();
              new_node.data = data;
              new_node.next = temp.next;
              temp.next = new_node;
              size++;
          }

      }
       public void removeFirstNode(){
           if(size == 0){
               System.out.println("List is empty");
           }else if(size == 1){
               head = tail = null;
               size = 0;
           }else{
               head = head.next;
               size--;
           }

       }

       public void removeLastNode(){
           if(size == 0){
               System.out.println("List is empty");
           }else if(size == 1){
               head = tail = null;
               size = 0;
           }else{
               Node temp = head;
               while(temp.next.next!=null){ // we cam use for loop -> for(int i=0;i<size-2;i++)
                   temp = temp.next;
               }
               tail = temp;
               temp.next = null;
               size--;
           }

       }

       //remove the element at index idx
        public void removeAt(int idx){
           if(idx < 0 || idx >=size){
               System.out.println("Illegal Arguments");
           }else if(idx == 0){
                removeFirstNode();
           }else if(idx == size-1){
               removeLastNode();
           }else{
               Node temp = head;
               for(int i =0;i<idx-1;i++){
                   temp = temp.next;
               }
               temp.next = temp.next.next;
               size--;
           }
        }

       //to get the element at first index
       public int getFirst(){
           if(size == 0){
               System.out.println("List is empty");
               return -1;
           }else{
               return head.data;
           }
       }

       //to get the element at last index
       public int getLast(){
           if(size == 0){
               System.out.println("List is empty");
               return -1;
           }else{
               return tail.data;
           }
       }

       //to get the element at some index
       public int getAt(int index){
           if(size == 0){
               System.out.println("List is empty");
               return -1;
           }else if(index < 0 || index >=size){
               System.out.println("Invalid Argument");
               return -1;
           }else{
               Node temp = head;
               for(int i=0;i<index;i++){
                  temp = temp.next;
               }
               return temp.data;
           }

       }

       private Node getNodeAt(int idx){
           Node temp = head;
           for(int i = 0; i < idx; i++){
               temp = temp.next;
           }
           return temp;
       }
        public int size(){
            return size;
        }

        public void display(){
           Node temp = head;
           while (temp!=null){
               System.out.print(temp.data+" ");
               temp = temp.next;
           }
            System.out.println();
        }

        /*reverse a linkedlist*/
        public void reverseList(){
            int li = 0;
            int ri = size - 1;
            while (li <ri){
                Node left = getNodeAt(li);
                Node right = getNodeAt(ri);

                int val = left.data;
                left.data = right.data;
                right.data = val;

                li++;
                ri--;
            }
        }

        //return the kth element from last without using size/size() directly or indirectly
        public int kthFromLast(int k){
            /*we will use slow-fast pointer approach for that*/
            Node slow = head;
            Node fast = head;
            for(int i = 0; i < k; i++){
                fast = fast.next;
            }

            while(fast!=tail){
                fast = fast.next;
                slow = slow.next;
            }
            return slow.data;
        }

        private Node findMidNode(Node head,Node tail){
            Node slow = head;
            Node fast = head;
            //this while condition is good if we want to get last element of first half as mid-element(in case of even no. of nodes)
            while(fast!=tail && fast.next!=tail){
                fast = fast.next.next;
                slow = slow.next;
            }

            //this while condition is good if we want to get first element of 2nd half as mid-element(in case of even no. of nodes)
            //for odd no. of nodes, both loop will work fine
            /*while(fast!=null && fast.next!=null){
                fast = fast.next.next;
                slow = slow.next;
            }*/

            return slow;
        }
        public int findMidElement(LinkedList l1){
            /*we are using slow-fast pointer approach for that*/
            Node slow = l1.head;
            Node fast = l1.head;
            //this while condition is good if we want to get last element of first half as mid-element(in case of even no. of nodes)
            while(fast.next!=null && fast.next.next!=null){
                fast = fast.next.next;
                slow = slow.next;
            }

            //this while condition is good if we want to get first element of 2nd half as mid-element(in case of even no. of nodes)
            //for odd no. of nodes, both loop will work fine
            /*while(fast!=null && fast.next!=null){
                fast = fast.next.next;
                slow = slow.next;
            }*/

            return slow.data;

        }

        public LinkedList mergeSort(Node head,Node tail){
           //base condition
            if(head == tail){
               LinkedList list = new LinkedList();
                list.addLast(head.data);
               return list;
            }
            Node mid = findMidNode(head,tail);
            LinkedList fsh = mergeSort(head,mid); //fsh = first-sorted-half
            LinkedList ssh = mergeSort(mid.next,tail); //ssh = second-sorted-half

            LinkedList completeList = mergeSortTwoList(fsh,ssh);
            System.out.println("===Print completeList===");
            completeList.display();
            return completeList;
        }

        public LinkedList mergeSortTwoList(LinkedListImpl.LinkedList l1,LinkedListImpl.LinkedList l2){
            Node p = l1.head;
            Node q = l2.head;

            LinkedListImpl.LinkedList l3 =  new LinkedListImpl.LinkedList();
            while(p!=null && q!=null){
                if(p.data < q.data){
                    l3.addLast(p.data);
                    p = p.next;
                }else{
                   l3.addLast(q.data);
                   q = q.next;
                }
            }

            while(p!=null){
                if(p.next!=null && (p.data > p.next.data)){
                    int temp = p.data;
                    p.data = p.next.data;
                    p.next.data = temp;
                }
                    l3.addLast(p.data);
                    p = p.next;
            }

            while(q!=null){
                if(q.next!=null && (q.data > q.next.data)){
                    int temp = q.data;
                    q.data = q.next.data;
                    q.next.data = temp;
                }
                    l3.addLast(q.data);
                    q = q.next;
            }


            //to display
            System.out.println("=====l3 display===");
           l3.display();

           return l3;
        }

        /*remove duplicate elements from the LL in O(n)-> linear time complexity and constant space*/
        public void removeDuplicates(){
            LinkedList res = new LinkedList();
            while(this.size()>0){
                int val = this.getFirst();
                this.removeFirstNode();

                //add the removed element to the result list(res) if
                //res.size() is zero or res.tail.data!= val
                if(res.size() == 0 || res.tail.data!=val){
                    res.addLast(val);
                }
            }

            this.head = res.head;
            this.tail = res.tail;
            this.size =  res.size;
        }

        /*first all odds , then all evens*/
        public void oddEvenList(){
            LinkedList odd = new LinkedList();
            LinkedList even = new LinkedList();
            while(this.size()>0){
                int val = this.getFirst();
                this.removeFirstNode();
                if(val%2 == 0){
                    even.addLast(val);
                }else {
                    odd.addLast(val);
                }
            }

            if(odd.size()>0 && even.size()>0){ // the original list contains both even and odd no.'s
                odd.tail.next = even.head;
                this.head = odd.head;
                this.tail = even.tail;
                this.size = odd.size() + even.size();   //after removal of elements from (this) list, list size becomes zero. So we have to update it's size
            }else if(odd.size()>0){ //if the list contains only even no.'s
                this.head = odd.head;
                this.tail = odd.tail;
                this.size = odd.size();
            }else if(even.size()>0){ //if the list contains only odd no.'s
                this.head = even.head;
                this.tail = even.tail;
                this.size = even.size();
            }

        }

        public LinkedList kReverseInList(int k){
            LinkedList prev = new LinkedList();
                while(this.size()>0){
                    LinkedList curr = new LinkedList();
                    if(this.size()>=k){
                        for(int i = 0; i < k; i++){
                            int val = this.getFirst();
                            this.removeFirstNode();
                            curr.addFirst(val);
                        }
                    }else{
                        int val = this.getFirst();
                        this.removeFirstNode();
                        curr.addLast(val);
                    }

                    if(prev.size() == 0){
                        prev = curr;
                    }else{
                        prev.tail.next = curr.head;
                        prev.tail = curr.tail;
                        prev.size+= curr.size;
                    }


                }

                return prev;

        }


    }


    public static class Node {
        int data;
        Node next;
    }

    public static void main(String[] args) {
       // LinkedListImpl l = new LinkedListImpl();
        LinkedListImpl.LinkedList list = new LinkedList();
        list.addLast(10);
        list.addLast(20);
        list.addLast(30);
        list.addLast(40);
        list.addLast(50);


        list.addAt(60,2);
        //list.removeAt(1);
       // System.out.println("List Size == "+list.size());
       // System.out.println("===== List Data ====");

        //list.reverseList();
        //list.display();

       /* list.removeFirstNode();

        System.out.println("===== List Data == After == Removal==");
        list.display();
        System.out.println("List Size == "+list.size());*/

        LinkedListImpl.LinkedList l1 = new LinkedListImpl.LinkedList();
        LinkedListImpl.LinkedList l2 = new LinkedListImpl.LinkedList();
        /*l1.addLast(10);l1.addLast(20);l1.addLast(30);l1.addLast(55);l1.addLast(68);
        l2.addLast(7);l2.addLast(9);l2.addLast(25);l2.addLast(50);l2.addLast(70);l2.addLast(69);l2.addLast(78);*/

       /* l1.addLast(10);l1.addLast(20);l1.addLast(30);l1.addLast(40);l1.addLast(50);
        l2.addLast(7);l2.addLast(9);l2.addLast(12);l2.addLast(35);l2.addLast(58);l2.addLast(60);*/

        /*l1.display();
        System.out.println("===L2==Display==");
        l2.display();*/

        LinkedListImpl.LinkedList l4 = new LinkedListImpl.LinkedList();
        l4.addLast(2);l4.addLast(8);l4.addLast(1);l4.addLast(7);l4.addLast(10);l4.addLast(6);l4.addLast(5);l4.addLast(3);
        list.mergeSort(l4.head,l4.tail);

       // System.out.println("kth element from the last : "+list.kthFromLast(3));

        System.out.println("==Remove Duplicates from the Linked List====");
        LinkedListImpl.LinkedList l5 = new LinkedListImpl.LinkedList();
        l5.addLast(2);l5.addLast(2);l5.addLast(2);l5.addLast(3);l5.addLast(3);l5.addLast(4);l5.addLast(5);
        l5.addLast(5);l5.addLast(5);l5.addLast(5);

        l5.removeDuplicates();
        System.out.println("==After removing Duplicates==");
        l5.display();

        System.out.println("==Arrange the elements in the list in such a way that all odds come first then all evens====");
        LinkedList l6 = new LinkedList();
        l6.addLast(2);l6.addLast(9);l6.addLast(7);l6.addLast(8);l6.addLast(1);l6.addLast(6);l6.addLast(5);l6.addLast(4);

        l6.display();
        l6.oddEvenList();
        System.out.println("====After Arrangement===");
        l6.display();

        System.out.println("k reverse in the LinkedList");
        LinkedList l7 = new LinkedList();
        l7.addLast(1);l7.addLast(2);l7.addLast(3);l7.addLast(4);l7.addLast(5);l7.addLast(6);l7.addLast(10);l7.addLast(11);
        l7.display();
        System.out.println("===After k reverse===");
        LinkedList kReverseInList= l7.kReverseInList(3);
        kReverseInList.display();




    }
}

