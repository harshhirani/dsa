package BinaryTree;


public class BinaryTree4 {
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
    int  maxSum = Integer.MIN_VALUE;
    int  maxCount = 0;


//- Sum of Longest BloodLine:https://practice.geeksforgeeks.org/problems/sum-of-the-longest-bloodline-of-a-tree/1

    void sumOfRootNodes(Node node, int sum, int count){
        if(node == null){
         if(count>=maxCount){
             maxCount = count;
             maxSum = sum;
         }
           return;
        }

        sum += node.data;
        count+=1;
        sumOfRootNodes(node.left,sum,count);
        sumOfRootNodes(node.right,sum,count);
    }



//- LCA of Binary Tree:https://practice.geeksforgeeks.org/problems/lowest-common-ancestor-in-a-binary-tree/1

   Node findLCA(Node node, int n1, int n2) {

        if(node == null)
            return node;

        if(node.data == n1 || node.data ==n2)
           return node;


       Node left = findLCA(node.left,n1,n2);
       Node right = findLCA(node.right,n1,n2);

        if(left !=null && right == null)
            return left;
        else if(left == null && right!=null)
            return right;
        else if(left!=null && right!=null)
            return node;
        else return null;




        return node;

   }
//- K Sum paths:https://practice.geeksforgeeks.org/problems/k-sum-paths/1
//- Kth Ancestor:https://practice.geeksforgeeks.org/problems/kth-ancestor-in-a-tree/1
//- Max Sum of Non-Adjacent Nodes:https://practice.geeksforgeeks.org/problems/maximum-sum-of-non-adjacent-nodes/1


    public static void main(String[] args) {
        BinaryTree4 bt = new BinaryTree4();
        Node root = bt.new Node(1);
        root.left = bt.new Node(2);
        root.right = bt.new Node(3);
        root.left.left = bt.new Node(4);
        root.left.right = bt.new Node(5);
        root.right.left =bt.new Node(6);
        root.right.right =bt.new Node(7);
        root.left.right.left = bt.new Node(8);
        root.left.right.right = bt.new Node(9);
        bt.sumOfRootNodes(root,0,0);
        System.out.println(bt.maxSum);

    }
}
