package LinkedList;

public class DoublyLinkedList {

    class Node{
        int data;
        Node next;
        Node prev;

        Node(int data){
            this.data = data;
            this.prev = null;
            this.next = null;
        }

    }
    Node head;
    Node tail;

    public void insertAtHead(int data){
        Node nodeToInsert = new Node(data);

        if (head==null){
            tail = nodeToInsert;
        }
        else{
            nodeToInsert.next = head;
            head.prev = nodeToInsert;
        }

        head = nodeToInsert;



    }

    public void insertAtTail(int data){
        Node nodeToInsert = new Node(data);
        if(head == null){
            head = nodeToInsert;
        }
        else {
            nodeToInsert.prev = tail;
            tail.next = nodeToInsert;
        }
        tail = nodeToInsert;

    }

    public void insertAtPosition(int position, int data){
        Node nodeToInsert = new Node(data);
        int pointer = 0;
        Node temp = head;
        if(position==1){
            insertAtHead(data);
            return;
        }
        while(position>pointer+2){
            temp= temp.next;
            ++pointer;
        }
        nodeToInsert.prev = temp;
        nodeToInsert.next = temp.next;
        if(temp.next != null){
            temp.next = nodeToInsert;
            temp.next.prev = nodeToInsert;
        }


    }

    public void deleteNodeAtPosition(int position){
        Node temp  = head;
        int pointer = 0;
        while(position>pointer+1){
            ++pointer;
            temp=temp.next;
        }
        temp.next = temp.next.next;
        temp.next.next.prev = temp;
        temp.next.prev = null;
        temp.next.next = null;
    }

    public void printList(){
        Node temp = head;
        while(temp!=null){
            System.out.println(temp.data);
            temp = temp.next;
        }
    }


    public static void main(String[] args) {
        DoublyLinkedList list = new DoublyLinkedList();
        list.insertAtHead(5);
        list.insertAtHead(12);
        list.insertAtHead(7);
        list.insertAtHead(19);
        list.insertAtHead(3);
//        list.insertAtTail(1);
//        list.insertAtTail(22);
//        list.insertAtPosition(4,55);
//        list.insertAtPosition(8,22);
        list.deleteNodeAtPosition(2);



        list.printList();

    }
}
