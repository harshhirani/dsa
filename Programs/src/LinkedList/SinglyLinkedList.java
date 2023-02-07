package LinkedList;

public class SinglyLinkedList {

     class Node{
         int data;
         Node next;
         Node(int data){
             this.data = data;
         }
     }

     Node head;
     Node tail;

     public void insertAtHead(int data){

         Node temp = new Node(data);
             temp.next = head;
             head = temp;
             tail = temp;

     }

    public void insertAtTail(int data){

        Node temp = new Node(data);
        if(tail==null){
            head = temp;
            tail = temp;
        } else{
            tail.next = temp;
            tail = temp;
        }
    }

    public void insertAtNthPosition(int position, int data){

        Node temp = new Node(data);
        Node traversingPointer = head;
        if(position ==1){
            head = temp;
            return;
        }
        int counter = 1;
//        while(traversingPointer!=null) {
//            ++counter;
//            if(counter+1==position){
//                temp.next=traversingPointer.next;
//                traversingPointer.next=temp;
//                break;
//            }
//            traversingPointer = traversingPointer.next;
//        }

        while (counter<position-1){
            traversingPointer = traversingPointer.next;
            ++counter;
        }

        temp.next = traversingPointer.next;
        traversingPointer.next= temp;

    }

    public void deleteAtHead(){
         head = head.next;
    }

    public void deleteNthNode(int position)
    {
        Node traversingPointer = head;
        int counter = 1;
//        while(traversingPointer!=null) {
//            ++counter;
//            if(counter+1==position){
//                traversingPointer.next= traversingPointer.next.next;
//                break;
//            }
//            traversingPointer = traversingPointer.next;
//        }

        while (counter<position-1){
            traversingPointer = traversingPointer.next;
            ++counter;
        }
        traversingPointer.next = traversingPointer.next.next;
    }

     public void printListWithHead(){
         Node temp = head;
         while(temp!=null){
             System.out.println(temp.data);
             temp = temp.next;
         }
     }


    public static void main(String[] args) {
         SinglyLinkedList list = new SinglyLinkedList();
         list.insertAtHead(5);
         list.insertAtHead(8);
         list.insertAtHead(1);
         list.insertAtHead(4);
         list.insertAtHead(3);
//        list.insertAtTail(5);
//        list.insertAtTail(8);
//        list.insertAtTail(1);
//        list.insertAtTail(4);
//        list.insertAtTail(3);
        System.out.println("before nth insert");
        list.printListWithHead();

        list.insertAtNthPosition(4,2);
//        list.deleteNthNode(3);
//        list.deleteAtHead();
        list.insertAtNthPosition(1,9);
//        list.insertAtNPosition(6,14);
        list.printListWithHead();


    }
}
