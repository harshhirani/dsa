package LinkedList;

public class CircularSinglyLinkedList {
    public  class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }
    Node tail;

    public void insertNode(int element, int data) {
        Node temp = tail;
        Node nodeToInsert = new Node(data);
        if(tail==null){
            tail = nodeToInsert;
            nodeToInsert.next = tail;
            return;
        }
        while (element!=temp.data) {
                temp = temp.next;
        }
        nodeToInsert.next =  temp.next;
        temp.next = nodeToInsert;

    }
    public void printList(){
        Node temp = tail;
        System.out.println(temp.data);
        while(temp.next!=tail){
            temp = temp.next;
            System.out.println(temp.data);
        }


    }

        public static void main(String[] args) {
            CircularSinglyLinkedList list = new CircularSinglyLinkedList();
            list.insertNode(0,1);
            list.insertNode(1,6);
            list.insertNode(1,2);
            list.insertNode(2,4);
            list.insertNode(6,9);
            list.printList();

        }

}
