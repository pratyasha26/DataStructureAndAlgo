package com.company;

import org.omg.CORBA.SystemException;

class Node {
    int data;
    Node left;
    Node right;

}


    public  class BST {
        static Node root;
        public Node initializeNode(int data){
            Node node=new Node();
            node.data = data;
            node.left = null;
            node.right = null;
            return node;
        }
        public Node createBST(Node node, int data) {
            if(node == null){
                return  initializeNode(data);
            }
            else{
                if(node.data > data ){
                    node.left =createBST(node.left,data);
                }
                else{
                   node.right= createBST(node.right,data);
                }
            }
            return node;
        }
        public static Node delete(Node head,int item){
                if(head==null){
                    return null;
                }
            if(head.data >item){
               head.left= delete(head.left,item);
            }
            else if(head.data<item){
                head.right=delete(head.right,item);
            }
            else{
                if( head.left==null && head.right==null){
                    System.out.println("Deleting node : " +head.data);
                        head=null;
                    return head;
                }
                if(head.left!=null && head.right== null){
                    System.out.println("Deleting node : " +head.data);
                    head=head.left;
                }
                if(head.right!=null && head.left== null){
                    System.out.println("Deleting node : " +head.data);
                    head=head.right;
                }
                if(head.right!=null && head.left!= null){
                  Node temp= minInRightSubtree(head.right);
                        head.data=temp.data;
                      head.right=  delete(head.right,temp.data);
                    System.out.println("Deleting node : " +head.data);


                }
            }
            return head;
        }

        private static Node minInRightSubtree(Node right) {
            if(right.left==null ){
                return right;
            }
            return minInRightSubtree(right.left);
        }

        public static void main(String args[]){
            BST bst=new BST();
            Node head=null;
            int ar[]={2,4,6,1,3,8,5};
            for(int i=0;i<ar.length;i++){
                 root = bst.createBST(root, ar[i]);
            }
       //     inOrderTraversal(head);
            delete(root, 6);
            inOrderTraversal(root);
            int searchItem=8;
           // Node node = searchNode(root, searchItem);
         //   System.out.print("Search Node : " +node.data);


        }

        private static Node searchNode(Node head, int searchItem) {
            if(head == null|| head.data==searchItem)
                return head;
             if(head.data>searchItem){
                   head= searchNode(head.left,searchItem);
                }
                else if(head.data<searchItem){
                    head=searchNode(head.right,searchItem);
                }
               return  head;
        }

        private static void inOrderTraversal(Node head) {
            if(head == null){
                return;
            }
            inOrderTraversal(head.left);
            System.out.print(head.data);
            inOrderTraversal(head.right);
        }


    }
