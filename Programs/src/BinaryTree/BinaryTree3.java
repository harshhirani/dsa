package BinaryTree;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class BinaryTree3 {

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

    class Pair {
        Node first;
        int second;

        Pair(Node first, int second){
            this.first = first;
            this.second = second;
        }
    }


    //- ZigZag Traversal: https://practice.geeksforgeeks.org/problems/zigzag-tree-traversal/1
    List<List<Integer>> zigzagTraversalNodes = new ArrayList<>();
    boolean leftToRight = true;
    void zigzagTraversal(Node node){

        if(node==null)
            return;

        Queue<Node> queue = new LinkedList<>();
        queue.add(node);

        while(!queue.isEmpty()){
            List<Integer>ans = new ArrayList<>();
            int size = queue.size();
            for(int i =0; i<size; ++i) {
                Node temp = queue.poll();
                ans.add(temp.data);
                if (temp.left != null)
                    queue.add(temp.left);
                if (temp.right != null)
                    queue.add(temp.right);
                if(!leftToRight)
                    Collections.reverse(ans);
            }
            leftToRight=!leftToRight;
            zigzagTraversalNodes.add(ans);

        }

    }

    //- Boundary Traversal:https://practice.geeksforgeeks.org/problems/boundary-traversal-of-binary-tree/1

    List<Integer> boundaryTraversal(Node node ){

        if(node ==null)
            return new ArrayList<>();

        //adding root node
        List<Integer> ans = new ArrayList<>();
        ans.add(node.data);

        //Left Nodes Traversal
        if(node.left!=null)
            leftTraversal(node.left,ans);
        else
            leftTraversal(node.right,ans);

        //Leaf Nodes Traversal
        leafTraversal(node.left,ans);
        leafTraversal(node.right,ans);

        //Right Nodes Traversal
        if(node.right!=null)
            rightTraversal(node.right,ans);
        else
            rightTraversal(node.left,ans);

        return ans;

    }

    void leftTraversal(Node node, List<Integer> ans){
        if(node == null || (node.left == null && node.right ==null))
            return;

        //adding value and traversing for left
        ans.add(node.data);
        if(node.left !=null)
            leftTraversal(node.left,ans);
        else
            leftTraversal(node.right,ans);

    }

    void leafTraversal(Node node,List<Integer> ans){
        if(node == null)
            return;
        if(node.left == null && node.right ==null)
            ans.add(node.data);
        if(node.left !=null)
            leafTraversal(node.left,ans);
        if(node.right!=null)
            leafTraversal(node.right,ans);
    }

    void rightTraversal(Node node, List<Integer> ans){
        if(node == null || (node.left == null && node.right ==null))
            return;

        if(node.right !=null)
            rightTraversal(node.right,ans);
        else
            rightTraversal(node.left,ans);

        //adding value from bottom to top
        ans.add(node.data);

    }

    //- Vertical Order Traversal:https://practice.geeksforgeeks.org/problems/print-a-binary-tree-in-vertical-order/1
    List<Integer> verticalOrderTraversal(Node node){
        if(node == null)
            return new ArrayList<>();

        Queue<Pair>queue = new LinkedList<>();
        Map<Integer,List<Integer>> results = new TreeMap<>();
        queue.add(new Pair(node,0));
        while(!queue.isEmpty()){
            Pair temp = queue.poll();
            Node data = temp.first;
            int hd = temp.second;
            List<Integer> nodeDataList = new ArrayList<>();
            if(results.containsKey(hd))
                nodeDataList = results.get(hd);

            nodeDataList.add(data.data);
            results.put(hd,nodeDataList);
            if(data.left!=null)
                queue.add(new Pair(data.left,hd-1));

            if(data.right!=null)
                queue.add(new Pair(data.right,hd+1));

        }
        return results.values().stream().flatMap(Collection::stream).collect(Collectors.toList());

    }

    //- Top View:https://practice.geeksforgeeks.org/problems/top-view-of-binary-tree/1

    List<Integer> topView(Node node){
       if(node == null)
           return new ArrayList<>();

       Map<Integer,Integer>results = new TreeMap<>();
       Queue<Pair> queue = new LinkedList<>();
       queue.add(new Pair(node,0));
       while (!queue.isEmpty()){
           Pair temp = queue.poll();
           Node tempNode = temp.first;
           int hd = temp.second;

           if(!results.containsKey(hd))
               results.put(hd,tempNode.data);

           if(tempNode.left!=null)
               queue.add(new Pair(tempNode.left,hd-1));

           if(tempNode.right!=null)
               queue.add(new Pair(tempNode.right,hd+1));

       }
        return results.values().stream().collect(Collectors.toList());

    }
    //- Bottom View:https://practice.geeksforgeeks.org/problems/bottom-view-of-binary-tree/1

    List<Integer> bottomView(Node node){
        if(node == null)
            return new ArrayList<>();

        Map<Integer,Integer>results = new TreeMap<>();
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(node,0));
        while (!queue.isEmpty()){
            Pair temp = queue.poll();
            Node tempNode = temp.first;
            int hd = temp.second;

            results.put(hd,tempNode.data);

            if(tempNode.left!=null)
                queue.add(new Pair(tempNode.left,hd-1));

            if(tempNode.right!=null)
                queue.add(new Pair(tempNode.right,hd+1));

        }
        return results.values().stream().collect(Collectors.toList());

    }

    //- Right View:https://practice.geeksforgeeks.org/problems/right-view-of-binary-tree/1

    List<Integer> rightView(Node node,int level, List<Integer> ans){
        if(node ==null)
            return new ArrayList<>();
        if(level == ans.size())
            ans.add(node.data);

        rightView(node.right,level+1,ans);
        rightView(node.left,level+1,ans);


        return ans;
    }
    //- Left View:https://practice.geeksforgeeks.org/problems/left-view-of-binary-tree/1

    List<Integer> leftView(Node node,int level, List<Integer> ans){
        if(node ==null)
            return new ArrayList<>();
        if(level == ans.size())
            ans.add(node.data);

        leftView(node.left,level+1,ans);
        leftView(node.right,level+1,ans);

        return ans;
    }
    //- Diagonal Traversal:https://practice.geeksforgeeks.org/problems/diagonal-traversal-of-binary-tree/1

    List<Integer>diagonalTraversal(Node node, int slope, Map<Integer,List<Integer>> ans){
        if(node == null)
            return new ArrayList<>();

        List<Integer>list = new ArrayList<>();
        if(ans.containsKey(slope))
            list = ans.get(slope);
        list.add(node.data);
        ans.put(slope,list);

        diagonalTraversal(node.left,slope+1,ans);
        diagonalTraversal(node.right,slope,ans);
        return ans.values().stream().flatMap(Collection::stream).collect(Collectors.toList());
    }

    public static void main(String[] args) {
        BinaryTree3 bt = new BinaryTree3();
        Node root = bt.new Node(1);
        root.left = bt.new Node(2);
        root.right = bt.new Node(3);
        root.left.left = bt.new Node(4);
        root.left.right = bt.new Node(5);
        root.right.left =bt.new Node(6);
        root.right.right =bt.new Node(7);
        root.left.right.left = bt.new Node(8);
        root.left.right.right = bt.new Node(9);
        bt.zigzagTraversal(root);
        System.out.println("ZigZag Traversal " + bt.zigzagTraversalNodes);
        System.out.println("Boundary Traversal "+ bt.boundaryTraversal(root));
        System.out.println("Vertical order Traversal " + bt.verticalOrderTraversal(root));
        System.out.println("Top View "+ bt.topView(root));
        System.out.println("Bottom View "+bt.bottomView(root));
        System.out.println("Left View "+ bt.leftView(root,0,new ArrayList<>()));
        System.out.println("Right View "+ bt.rightView(root,0,new ArrayList<>()));
        System.out.println("Diagonal Traversal "+bt.diagonalTraversal(root,0,new TreeMap<>()));
    }

}
