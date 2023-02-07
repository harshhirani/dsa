package BinaryTree;

import java.util.LinkedList;
import java.util.Queue;


public class BinaryTree2 {
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

     class Pair{
            int first;
            int second;

            Pair(int first, int second){
                this.first = first;
                this.second = second;
            }
     }
    class Pair1{
        boolean first;
        int second;

        Pair1(boolean first, int second){
            this.first = first;
            this.second = second;
        }
    }
    void levelOrderTraversal(Node node) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);
        //adding separator for identifying end of level
        queue.add(null);
        while (!queue.isEmpty()) {
            Node temp = queue.poll();
            //checking if end is reached
            if (temp == null) {
                if (!queue.isEmpty()) {
                    //adding new separator for next level
                    queue.add(null);
                    System.out.println();
                }
            } else {

                if (temp.left != null)
                    queue.add(temp.left);
                if (temp.right != null)
                    queue.add(temp.right);
                System.out.print(temp.data + " ");
            }
        }
    }

    // Height of Tree: https://practice.geeksforgeeks.org/problems/height-of-binary-tree/1
    int heightOfBinaryTree(Node node){

        if(node == null)
            return 0;

        int leftHeight = heightOfBinaryTree(node.left);
        int rightHeight = heightOfBinaryTree(node.right);

        return Integer.max(leftHeight,rightHeight) + 1;
    }

    //  Diameter of Tree: https://practice.geeksforgeeks.org/problems/diameter-of-binary-tree/1
    //  Approach 1 T(n) = O(n^2)
    int diameterOfTree(Node node){
        if(node == null)
            return 0;
        int leftDiameter = diameterOfTree(node.left);
        int rightDiameter = diameterOfTree(node.right);

        int mixedDiameter = heightOfBinaryTree(node.left) + heightOfBinaryTree(node.right) + 1;

        int finalDiameter = Integer.max(Integer.max(leftDiameter,rightDiameter),mixedDiameter);

        return finalDiameter;
    }

    //Approach 2  T(n) = O(n)
    Pair diameterOfTree2(Node node){
        if(node == null)
            return new Pair(0,0);

        Pair leftDiameterPair = diameterOfTree2(node.left);
        Pair rightDiameterPair = diameterOfTree2(node.right);
        int leftDiameter =  leftDiameterPair.first;
        int rightDiameter = rightDiameterPair.first;
        int mixedDiameter = leftDiameterPair.second + rightDiameterPair.second + 1;
        int finalDiameter = Integer.max(Integer.max(leftDiameter,rightDiameter),mixedDiameter);
        int finalHeight = Integer.max(leftDiameterPair.second,rightDiameterPair.second) + 1;
        return  new Pair(finalDiameter,finalHeight);

    }

//    Balanced Tree or Not: https://practice.geeksforgeeks.org/problems/check-for-balanced-tree/1

    //Approach 1
     boolean checkBalanced(Node node){

        if(node == null)
            return true;

        boolean isLeftBalanced = checkBalanced(node.left);
        boolean isRightBalanced = checkBalanced(node.right);
        int leftHeight = heightOfBinaryTree(node.left);
        int rightHeight = heightOfBinaryTree(node.right);
        int heightDif = Math.abs(leftHeight -rightHeight);
        return (heightDif <= 1) && isLeftBalanced && isRightBalanced;
     }

     Pair1 checkBalanced1(Node node){
        if(node == null)
            return new Pair1(true,0);

        Pair1 isLeftBalancedPair = checkBalanced1(node.left);
        Pair1 isRightBalancedPair = checkBalanced1(node.right);
        boolean isLeftBalanced = isLeftBalancedPair.first;
        boolean isRightBalanced = isRightBalancedPair.first;

        int heightDif = Math.abs(isLeftBalancedPair.second -isRightBalancedPair.second);
        int height = Integer.max(isLeftBalancedPair.second,isRightBalancedPair.second);


        return new Pair1((isLeftBalanced&&isRightBalanced&&(heightDif <= 1)),height);

     }

//    Tree Identical or Not:https://practice.geeksforgeeks.org/problems/determine-if-two-trees-are-identical/1

    boolean isIdentical(Node node1, Node node2){
        /*1. both empty */
        if(node1 == null && node2 == null)
            return true;

        /* 2. both non-empty -> compare them */
    if(node1!=null && node2!=null){
        boolean isLeftIdentical = isIdentical(node1.left,node2.left);
        boolean isRightIdentical = isIdentical(node1.right,node2.right);
        boolean isValueSame = node1.data == node2.data;
        return isLeftIdentical&&isRightIdentical&&isValueSame;
    }
        /* 3. one empty, one not -> false */
     return false;
    }


//    Sum Tree or Not:https://practice.geeksforgeeks.org/problems/sum-tree/1

    Pair1 isSumTree(Node node){
        if(node == null)
            return new Pair1(true,0);
        if(node.left == null && node.right == null)
            return new Pair1(true,node.data);
        Pair1 isLeftSumTreePair = isSumTree(node.left);
        Pair1 isRightSumTreePair = isSumTree(node.right);
        boolean isLeftSumTree = isLeftSumTreePair.first;
        boolean isRightSumTree = isRightSumTreePair.first;
        int sum =  isLeftSumTreePair.second + isRightSumTreePair.second;
        boolean isSum = node.data == sum;

        return new Pair1(isLeftSumTree && isRightSumTree && isSum,sum);

    }

        public static void main(String[] args) {
        BinaryTree2 bt = new BinaryTree2();
        Node root = bt.new Node(1);

        root.left = bt.new Node(2);
        root.right = bt.new Node(3);
        root.left.left = bt.new Node(4);
        root.left.right = bt.new Node(5);
        bt.levelOrderTraversal(root);
        System.out.println();
        System.out.println("Height of Binary Tree " + bt.heightOfBinaryTree(root));
        System.out.println("Diameter of Binary Tree " + bt.diameterOfTree(root));
        System.out.println("Diameter of Binary Tree " + bt.diameterOfTree2(root).first);
        System.out.println("Is Tree Balanced " + bt.checkBalanced(root));
        System.out.println("Is Tree Balanced " + bt.checkBalanced1(root).first);
        System.out.println("Is Sum Tree " + bt.isSumTree(root).first);




    }
}
