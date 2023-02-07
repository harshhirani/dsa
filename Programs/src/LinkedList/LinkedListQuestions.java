package LinkedList;

import java.util.Objects;

public class LinkedListQuestions {

    class Node {
        int data;
        Node next;

        Node(int data){
            this.data = data;
            this.next = null;
        }
    }

    Node head = null;

    public void insertAtHead(int data){

        Node temp = new Node(data);
        temp.next = head;
        head = temp;

    }

    public void reverseList(){
        // If list is empty or it has only one element
        if (head == null || head.next == null){
            return;
        }
        Node currentNode = head;
        Node previousNode = null;
        Node forwardNode = null;
        while(currentNode!=null){
            forwardNode = currentNode.next;
            currentNode.next = previousNode;
            previousNode = currentNode;
            currentNode = forwardNode;
        }

        //to point head to original head position
        head = previousNode;

    }
    public void reverseListRecursion(Node curr, Node prev){

        if(curr== null){
            head = prev;
            return;
        }
        reverseListRecursion(curr.next,curr);
        curr.next = prev;
    }



    public Node reverseListInKGroupsRecursion(Node head, int k){

        if (head==null){
            return null;
        }
        Node currentNode = head;
        Node previousNode = null;
        Node forwardNode = null;
        int count = 0;
        while(currentNode!=null && count<k ){
            forwardNode = currentNode.next;
            currentNode.next = previousNode;
            previousNode = currentNode;
            currentNode = forwardNode;
            ++count;
        }

        //recursion
        if(forwardNode!=null)
            head.next = reverseListInKGroupsRecursion(forwardNode,k);

        //return head of previous list
        return  previousNode;
    }



    public Node findMiddleElement(){

        Node fastPointer = head.next;
        Node slowPointer = head;

        if(head==null || head.next ==null){
            return head;
        }

        while (fastPointer!=null){
            fastPointer = fastPointer.next;
            if(!Objects.isNull(fastPointer))
                fastPointer = fastPointer.next;
            slowPointer = slowPointer.next;
        }

        return slowPointer;
    }


    public void printListWithHead(){
        Node temp = head;
        while(temp!=null){
            System.out.println(temp.data);
            temp = temp.next;
        }
    }


    public static void main(String[] args) {
        LinkedListQuestions list = new LinkedListQuestions();
        for(int i=1;i<=5;++i){
            list.insertAtHead(2*i);
        }
//        System.out.println("Before reversing list");
//        list.printListWithHead();
//        list.reverseList();
//        System.out.println("After reversing list");
//        list.printListWithHead();

//        Node middleElement = list.findMiddleElement();
//        if(!Objects.isNull(middleElement))
//            System.out.println("Middle Element " + middleElement.data);
        System.out.println("list before reverse");
        list.printListWithHead();
        list.reverseListRecursion(list.head, null);
        System.out.println("list after reverse");
        list.printListWithHead();

        list.reverseListInKGroupsRecursion(list.head, 2);
        System.out.println("list after reverse in 2 groups" );
        list.printListWithHead();




    }
}
