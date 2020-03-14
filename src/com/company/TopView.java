package com.company;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;
import java.util.Vector;

class TreeNode {
    int data;
    TreeNode left, right;

    public TreeNode(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

class TopView {
    TreeNode root;

    TopView() {
        root = null;
    }

    static class Pair {
        TreeNode node;
        int hd;

        public Pair(TreeNode node, int hd) {
            this.node = node;
            this.hd = hd;
        }
    }

    public static void getTopViewOfTheTree(TreeNode node) {

        Queue<Pair> q = new LinkedList<>();
        Map<Integer, TreeNode> map = new TreeMap<>();
        if (node == null) {
            return;
        } else {
            q.add(new Pair(node, 0));
            map.put(0, node);
        }
        while (!q.isEmpty()) {
            Pair poll = q.poll();
            if (poll.node.left != null) {
                if (!map.containsKey(poll.hd - 1)) {
                    TreeNode leftNode = poll.node;

                    map.put(poll.hd - 1, leftNode.left);
                }
                q.add(new Pair(poll.node.left, poll.hd - 1));
            }
            if (poll.node.right != null) {
                if (!map.containsKey(poll.hd + 1)) {
                    TreeNode rightNode = poll.node;
                    if (rightNode.right != null) {
                        map.put(poll.hd + 1, rightNode.right);
                    }
                }
                q.add(new Pair(poll.node.right, poll.hd + 1));
            }
        }
        for (Map.Entry<Integer, TreeNode> entry : map.entrySet()) {
            System.out.print(entry.getValue().data);
        }
    }

    public static void getBottomViewOfTheTree(TreeNode node) {

        Queue<Pair> q = new LinkedList<>();
        Map<Integer, TreeNode> map = new TreeMap<>();
        if (node == null) {
            return;
        } else {
            q.add(new Pair(node, 0));
            map.put(0, node);
        }
        while (!q.isEmpty()) {
            Pair poll = q.poll();
            if (poll.node.left != null) {
                //  if(!map.containsKey(poll.hd-1)){
                TreeNode leftNode = poll.node;

                map.put(poll.hd - 1, leftNode.left);
                //   }
                q.add(new Pair(poll.node.left, poll.hd - 1));
            }
            if (poll.node.right != null) {
                //   if (!map.containsKey(poll.hd+1)) {
                TreeNode rightNode = poll.node;
                if (rightNode.right != null) {
                    map.put(poll.hd + 1, rightNode.right);
                }
                //    }
                q.add(new Pair(poll.node.right, poll.hd + 1));
            }
        }
        for (Map.Entry<Integer, TreeNode> entry : map.entrySet()) {
            System.out.print(entry.getValue().data);
        }
    }


    public static void getRightSideViewOfTree(TreeNode node) {
        Queue<Pair> q = new LinkedList<>();
        Map<Integer, TreeNode> map = new TreeMap<>();
        if (node == null) {
            return;
        } else {
            map.put(0, node);
            q.add(new Pair(node, 0));
            q.add(null);
        }
        while (!q.isEmpty()) {
            Pair poll = q.poll();
            while (!q.isEmpty()) {
                if (poll.node.right != null) {
                    map.put(poll.hd + 1, poll.node.right);
                    q.add(new Pair(poll.node.right, poll.hd + 1));
                }
            }
            if (poll.node.right != null) {
                map.put(poll.hd + 1, poll.node.right);
                q.add(new Pair(poll.node.right, poll.hd + 1));
            }
        }
        for (Map.Entry<Integer, TreeNode> m : map.entrySet()) {
            System.out.print(m.getValue().data + " ");
        }
    }


    public static void main(String args[]) {
        TopView tree = new TopView();
        tree.root = new TreeNode(1);
        tree.root.left = new TreeNode(2);
        tree.root.right = new TreeNode(3);
        tree.root.left.left = new TreeNode(4);
        tree.root.left.right = new TreeNode(5);
        Map<Integer, Vector<Integer>> map = new HashMap<>();
        Vector<Integer> v=new Vector<>();
        v.add(tree.root.data);
        map.put(0,v );
            topViewPractice(tree.root, map, 0);
        for (Map.Entry<Integer, Vector<Integer>> entry : map.entrySet()) {
            Vector<Integer> value = entry.getValue();
            for(Integer treeNode:value) {
                System.out.print("HD :" +entry.getKey() + " : "+treeNode + " ");
            }
            System.out.println();
        }
        // getTopViewOfTheTree(tree.root);
        //  getRightSideViewOfTree(tree.root);
    }

    //wrong

    private static void topViewPractice(TreeNode root, Map<Integer, Vector<Integer>> map, int hd) {


        int leftHd = hd - 1;
        int rightHd = hd + 1;
        if(root==null){
            return;
        }
                if(root.left!=null ) {

                    if (map.containsKey(leftHd)) {
                        Vector<Integer> treeNodes = map.get(leftHd);
                        treeNodes.add(root.left.data);
                        map.put(leftHd, treeNodes);
                    } else {
                        Vector<Integer> v = new Vector<>();
                        v.add(root.left.data);
                        map.put(leftHd, v);
                    }
                }
                if(root.right!=null) {
                    if (map.containsKey(rightHd)) {
                        Vector<Integer> treeNodes = map.get(rightHd);
                        treeNodes.add(root.right.data);
                        map.put(rightHd, treeNodes);
                    } else {
                        Vector<Integer> v = new Vector<>();
                        v.add(root.right.data);
                        map.put(rightHd, v);
                    }
                }
        topViewPractice(root.left, map, leftHd);
            topViewPractice(root.right, map, rightHd);



    }
}
