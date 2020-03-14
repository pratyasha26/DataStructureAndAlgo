package com.company;


import java.util.LinkedList;
import java.util.Queue;

class NodeP {
    NodeP left, right;
    int data;

    NodeP(int data) {
        this.data = data;
    }
}

class BinaryTreeP {
    NodeP root;

    BinaryTreeP() {
        root = null;
    }
    void readPreOrder(NodeP root){
        if(root==null){
            return;
        }
        System.out.println(root.data);
        readPreOrder(root.left);
        readPreOrder(root.right);
    }




    void readlevelOrderRecursion( Queue<NodeP> queue) {
        //root null then return
        if (queue.peek() == null) {
            return;
        }
        NodeP temp = queue.poll();
        if (temp.left != null) {
            queue.add(temp.left);
        }
        if (temp.right != null) {
            queue.add(temp.right);
        }
        System.out.println(temp.data);
        readlevelOrderRecursion(queue);

        //to queue add left and right child
        //then pop first print it

    }

    void readlevelOrder(NodeP root) {
        //root null then return
        if (root == null) {
            return;
        }
        Queue<NodeP> queue = new LinkedList<>();
        queue.add(root);
        int l=0;
        while (!queue.isEmpty()) {
            NodeP temp = queue.poll();
            if (temp.left != null) {
                queue.add(temp.left);
                if(l==0){
                    System.out.println(temp.left.data);
                    l++;
                }

            }
            if (temp.right != null) {
                queue.add(temp.right);
            }

        }
        //to queue add left and right child
        //then pop first print it

    }
}

public class BFS {

    public static void main(String args[]) {
        BinaryTreeP bt = new BinaryTreeP();
        bt.root = new NodeP(1);
        bt.root.left = new NodeP(2);
        bt.root.right = new NodeP(3);
       // bt.root.left.left = new NodeP(4);
        bt.root.left.right = new NodeP(5);
        bt.root.right.left = new NodeP(12);
        bt.root.right.right = new NodeP(15);
        Queue<NodeP> queue = new LinkedList<>();
        queue.add(bt.root);
        bt.readlevelOrderRecursion(queue);
        bt.readPreOrder(bt.root);
       // bt.readlevelOrder(bt.root);

    }
}
