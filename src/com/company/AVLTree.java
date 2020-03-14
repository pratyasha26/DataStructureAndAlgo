package com.company;

class AVlNode {
    int data;
    AVlNode left;
    AVlNode right;

    AVlNode(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

public class AVLTree {
    static AVlNode root;
    static AVlNode deleteNode(AVlNode node,int item){
        if (node==null){
            return null;
        }
        if(node.data<item){
            node.right=deleteNode(node.right,item);
        }
        else if(node.data>item){
            node.left=deleteNode(node.left,item);
        }
        else{
            if(node.left==null && node.right==null){
                node=null;

            }
            else if(node.left!=null && node.right==null){
                node=node.left;

            }
            else if(node.right!=null && node.left==null){
                node=node.right;

            }
            else{
                AVlNode temp=node;
                temp= minimumInRightSubtree(node.right);
                node.data=temp.data;
               node=deleteNode(node,temp.data);
            }
        }
        if(node!=null) {
            int balance = getBalance(node.left, node.right);
            if (balance < -1) {
                if (getHeight(node.right.right) >= getHeight(node.right.left)) {
                    //right rotation
                    node = leftRotation(node);
                } else {
                    //left right rotation
                    node.right = righRotation(node.right);
                    node = leftRotation(node);
                }
            } else if (balance > 1) {
                if (getHeight(node.left.left) >= getHeight(node.left.right)) {
                    //left rotation
                    node = righRotation(node);
                } else {
                    node.left = leftRotation(node.left);
                    node = righRotation(node);
                    //right left rotation
                }
            }
        }
        return node;
    }

    private static AVlNode minimumInRightSubtree(AVlNode right) {
        if(right.left==null){
            return right;
        }
        return minimumInRightSubtree(right.left);
    }

    static AVlNode insertNode(AVlNode node, int data) {

        if (node == null) {
            return new AVlNode(data);
        }

        if (data < node.data) {
            node.left = insertNode(node.left, data);
        } else {
            node.right = insertNode(node.right, data);
        }
        int balance = getBalance(node.left, node.right);
            if(balance<-1){
                    if(getHeight(node.right.right)>=getHeight(node.right.left)){
                        //right rotation
                        node= leftRotation(node);
                    }
                    else{
                        //left right rotation
                        node.right= righRotation(node.right);
                        node= leftRotation(node);
                    }
            }
            else if (balance>1) {
                    if(getHeight(node.left.left)>=getHeight(node.left.right)){
                        //left rotation
                        node= righRotation(node);
                    }
                    else{
                        node.left= leftRotation(node.left);
                       node= righRotation(node);
                        //right left rotation
                }
            }
            else{

            }
        return node;
    }

    private static AVlNode righRotation(AVlNode root) {
        AVlNode newNode=root.left;
        root.right=newNode.right;
        root.left=null;
        newNode.right=root;
        return newNode;
    }
    private static AVlNode leftRotation(AVlNode root) {
        AVlNode newNode=root.right;
        root.left=newNode.left;
        root.right=null;
        newNode.left=root;
        return newNode;
    }

    private static int getBalance(AVlNode left, AVlNode right) {
        return getHeight(left)-getHeight(right);
    }

    public static void main(String[] args) {
        int[] ar = {50,40,60,30,45,55,10};
        for (int i = 0; i < ar.length; i++) {
            root = insertNode(root, ar[i]);
        }
    //    int height = getHeight(root);
      //  System.out.println("Height : "+height);
        //inorderTraversal(root);
       root = deleteNode(root, 55);
        inorderTraversal(root);
    }

    private static void inorderTraversal(AVlNode root) {
        if (root == null) {
            return;
        }
        inorderTraversal(root.left);
        System.out.print(root.data + " ");
        inorderTraversal(root.right);

    }

    public static int getHeight(AVlNode node) {
        if (node == null) {
            return 0;
        }
        int left = getHeight(node.left);
        int right = getHeight(node.right);
        if (left > right) {
            left = left + 1;
            return left;
        } else {
            right = right + 1;
            return right;
        }

    }
}
