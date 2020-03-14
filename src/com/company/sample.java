package com.company;// Java program to print left view of binary tree

/* Class containing left and right child of current
node and key value*/
 class TNode {
    int data;
    TNode left, right;

    public TNode(int item)
    {
        data = item;
        left = right = null;
    }
}

/* Class to print the left view */
class BinaryTree {
    TNode root;
    static int max_level = 0;

    // recursive function to print left view
    void leftViewUtil(TNode TNode, int level)
    {
        // Base Case
        if (TNode == null)
            return;

        // If this is the first node of its level
        if (max_level < level) {
            System.out.print(" " + TNode.data);
            max_level = level;
        }

        // Recur for left and right subtrees
        leftViewUtil(TNode.left, level + 1);
        leftViewUtil(TNode.right, level + 1);
    }

    void righLevelView(TNode TNode, int level)
    {
        // Base Case
        if (TNode == null)
            return;

        // If this is the first node of its level
        if (max_level < level) {
            System.out.print(" " + TNode.data);
            max_level = level;
        }

        // Recur for left and right subtrees
        righLevelView(TNode.right, level + 1);
        righLevelView(TNode.left, level + 1);
    }

    // A wrapper over leftViewUtil()
    void leftView()
    {
        leftViewUtil(root, 1);
    }
    void rightView()
    {
        righLevelView(root, 1);
    }
    /* testing for example nodes */
    public static void main(String args[])
    {
        /* creating a binary tree and entering the nodes */
        BinaryTree tree = new BinaryTree();
        tree.root = new TNode(12);
        tree.root.left = new TNode(10);
        tree.root.right = new TNode(30);
        tree.root.right.left = new TNode(25);
        tree.root.right.right = new TNode(40);
        tree.rightView();
        max_level=0;
        tree.leftView();
    }
}