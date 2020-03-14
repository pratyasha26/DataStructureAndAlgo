package com.company;

import java.util.*;

public class LevelOrderTraversal {
    static class Node
    {
        int data;
        Node left, right;
        public Node(int item)
        {
            data = item;
            left = right = null;
        }
    }

    private static class BinaryTree
    {
        // Root of the Binary Tree
        static Node root;

        public BinaryTree()
        {
            root = null;
        }

        /* function to print level order traversal of tree*/
        void printLevelOrder()
        {
            int h = height(root);
            int i;
            for (i=1; i<=h; i++)
                printGivenLevel(root, i);
        }

        /* Compute the "height" of a tree -- the number of
        nodes along the longest path from the root node
        down to the farthest leaf node.*/
        int height(Node root)
        {
            if (root == null)
                return 0;
            else
            {
                /* compute  height of each subtree */
                int lheight = height(root.left);
                int rheight = height(root.right);

                /* use the larger one */
                if (lheight > rheight)
                    return(lheight+1);
                else return(rheight+1);
            }
        }

        /* Print nodes at the given level */
        void printGivenLevel (Node root ,int level)
        {
            if (root == null)
                return;
            if (level == 1)
                System.out.print(root.data + " ");
            else if (level > 1)
            {
                printGivenLevel(root.left, level-1);
                printGivenLevel(root.right, level-1);
            }
        }
        static  void usingQueue(BinaryTree tree){
            Node curr=tree.root;

            HashMap<Integer, Vector<Integer>> hashMap=new HashMap<>();
            Queue<Node> q=new LinkedList<>();
            Queue<Integer> q2=new LinkedList<>();
            int hd=0;
            q.add(curr);
            Vector<Integer> vector=new Vector<>();
            vector.add(curr.data);
            hashMap.put(hd,vector);
            q2.add(hd);
            while(!q.isEmpty()){
                Node poll = q.poll();
                if(poll!=null) {
                    if (poll.left != null) {
                        Node left = poll.left;
                        q.add(left);
                        if(!hashMap.containsKey(q2.peek()-1)){
//                            Vector<Integer> vector2 = hashMap.get(q2.peek()-1);
//                            vector2.add(left.data);
//                            hashMap.put(q2.peek()-1,vector2);

                            Vector<Integer> vector1=new Vector<>();
                            vector1.add(left.data);
                            hashMap.put(q2.peek()-1,vector1);
                        }
                        q2.add(q2.peek()-1);
                    }
                    if (poll.right != null) {
                        Node right = poll.right;
                        q.add(right);
                        if(hashMap.containsKey(q2.peek()+1)){
//                            Vector<Integer> vector2 = hashMap.get(q2.peek()+1);
//                            vector2.add(right.data);
//                            hashMap.put(q2.peek()+1,vector2);


                            Vector<Integer> vector1=new Vector<>();
                            vector1.add(right.data);
                            hashMap.put(q2.peek()+1,vector1);
                        }

                        q2.add(q2.poll()+1);
                    }
                }
            }
            System.out.println(hashMap);
           for( Vector i:hashMap.values()){
                System.out.print(i.get(0));
               }
    }


    }
    /* Driver program to test above functions */
    public static void main(String args[])
    {
        BinaryTree tree = new BinaryTree();
        tree.root= new Node(1);
        tree.root.left= new Node(2);
        tree.root.right= new Node(3);
        tree.root.left.left= new Node(4);
        tree.root.left.right= new Node(5);

        System.out.println("Level order traversal of binary tree is ");
        tree.usingQueue(tree);
    //    tree.printLevelOrder();
    }
}
