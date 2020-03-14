package com.company;

import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

public class ReverseLinkedList {
    /*
     * For your reference:
     *
     * SinglyLinkedListNode {
     *     int data;
     *     SinglyLinkedListNode next;
     * }
     *
     */
    static SinglyLinkedListNode head;
    public static class SinglyLinkedListNode {
        int data;
        SinglyLinkedListNode next;
        SinglyLinkedListNode(int d){
            this.data=d;
            next=null;
        }
    }
    static SinglyLinkedListNode insertNode(SinglyLinkedListNode head, int data){
        SinglyLinkedListNode node=new SinglyLinkedListNode(data);
        if(head == null){
           head =node;
           return head;
        }
        SinglyLinkedListNode curNode= head;
        while(curNode!=null){
            if(curNode.next==null){
                curNode.next=node;
                break;
            }
            curNode=curNode.next;
        }
        return head;
    }
    static boolean compareLists(SinglyLinkedListNode head1, SinglyLinkedListNode head2) {
        if(head1==null || head2==null){
            return false;
        }
        SinglyLinkedListNode cur1=head1;
        SinglyLinkedListNode cur2=head2;
        int count1=0;
        int count2=0;
        while(cur1!=null){
            count1++;
            cur1=cur1.next;
        }
        while(cur2!=null){
            count2++;
            cur2=cur2.next;
        }
        if(count1!=count2){
            return false;
        }
         cur1=head1;
         cur2=head2;
        while(cur1!=null){
            if(cur1.data!=cur2.data){
                return false;
            }
            cur1=cur1.next;
            cur2=cur2.next;
        }
        return true;
    }

    static void reversePrint(SinglyLinkedListNode listNode) {
        if(listNode==null){
            return;
        }
        SinglyLinkedListNode cur=listNode;
        SinglyLinkedListNode next=null;
        SinglyLinkedListNode prev=null;
        while(cur!=null){
            next=cur.next;
            cur.next=prev;
            prev=cur;
            cur=next;
        }
        SinglyLinkedListNode curNode=prev;

        while(curNode!=null){
            System.out.println(curNode.data);
            curNode=curNode.next;
        }
    }

    public static void main(String[] args) {
        SinglyLinkedListNode head1=null;
         head = insertNode(head1, 10);
        insertNode(head, 12);
        SinglyLinkedListNode singlyLinkedListNode = insertNode(head, 14);
        SinglyLinkedListNode head2=null;
        head =null;
        head = insertNode(head2, 11);
        insertNode(head, 12);
        SinglyLinkedListNode singlyLinkedListNode2= insertNode(head, 14);
        System.out.println(compareLists(singlyLinkedListNode,singlyLinkedListNode2));
        //reversePrint(singlyLinkedListNode);
        while(singlyLinkedListNode!=null){
       //     System.out.println(singlyLinkedListNode.data);
            singlyLinkedListNode=  singlyLinkedListNode.next;
        }

    }

}
