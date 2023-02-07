package BinaryTree;


import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


public class BinaryTree1 {
    class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            left = null;
            right = null;
        }
    }

        Node buildTree(Node node){
        System.out.println("Enter value of node");
        Scanner sc = new Scanner(System.in);
        int data = sc.nextInt();
        node = new Node(data);

        if(node.data == -1)
            return null;

        System.out.println("Enter left child of " + data);
        node.left = buildTree(node);
        System.out.println("Enter right child of " + data);
        node.right =  buildTree(node);
        return  node;

        }

        // L R N
        void inOrderTraversal(Node node){
        if(node == null)
            return;

        inOrderTraversal(node.left);
        System.out.print(node.data + " ");
        inOrderTraversal(node.right);
        }

        // PostOrder Traversal L R N
        // PreOrder Traversal N L R


        //Important
        void levelOrderTraversal(Node node){
            Queue<Node> queue = new LinkedList<>();
            queue.add(node);
            //adding separator for identifying end of level
            queue.add(null);
            while (!queue.isEmpty()){
                 Node temp = queue.poll();
                 //checking if end is reached
                 if(temp==null){
                     if(!queue.isEmpty()){
                         //adding new separator for next level
                         queue.add(null);
                         System.out.println();
                     }
                 }
                 else {

                     if(temp.left!=null)
                         queue.add(temp.left);
                     if(temp.right!=null)
                         queue.add(temp.right);
                     System.out.print(temp.data + " ");
                 }
            }
        }



        public static void main(String[] args) {
            BinaryTree1 bt = new BinaryTree1();
            Node root = bt.buildTree(null);
            System.out.println("Inorder traversal");
            bt.inOrderTraversal(root);
            System.out.println();
            System.out.println("Level Order Traversal");
            bt.levelOrderTraversal(root);


            }

        }

