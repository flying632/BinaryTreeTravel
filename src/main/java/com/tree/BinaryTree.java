package com.tree;

import java.util.*;

class TreeNode<T> {
    T value;
    TreeNode<T> leftNode;
    TreeNode<T> rightNode;
    TreeNode(T value){
        this.value = value;
        leftNode = null;
        rightNode = null;
    }
}

public class BinaryTree<T> {
    TreeNode<T> headNode;

    public void addNode(TreeNode<T> node, Comparator<T> comparator) {
        if (node == null) {
            return;
        } else if (headNode == null) {
            headNode = node;
            return;
        } else {
            TreeNode<T> p = headNode;
            TreeNode<T> q = headNode;
            while (p != null) {
                q = p;
                if (comparator.compare(node.value, p.value) < 0) {
                    p = p.leftNode;
                } else {
                    p = p.rightNode;
                }
            }
            if (comparator.compare(node.value, q.value) > 0) {
                q.rightNode = node;
            } else {
                q.leftNode = node;
            }
        }
    }
    public void preTravel(){
        TreeNode node = headNode;
        Stack<TreeNode> stack = new Stack<>();
        while (node != null || !stack.isEmpty()) {
            while (node != null) {
                stack.push(node);
                System.out.println(node.value);
                node = node.leftNode;
            }
            if (node == null) {
                node = stack.peek();
                stack.pop();
                node = node.rightNode;
            }
        }
    }
    public void innerTravel(){
        TreeNode node = headNode;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode p = node;
        while (p != null || !stack.isEmpty()){
            while (p != null){
                stack.push(p);
                p = p.leftNode;
            }
            if (p == null){
                p = stack.peek();
                stack.pop();
                System.out.println(p.value);
                p = p.rightNode;
            }
        }
    }
    public void postTravel(){
        TreeNode node = headNode;
        Stack<TreeNode> stack = new Stack<>();
        Stack<TreeNode> output = new Stack<>();
        while (node != null || !stack.isEmpty()){
            if (node != null){
                output.push(node);
                stack.push(node);
                node = node.rightNode;
            }
            if (node == null){
                node = stack.pop();
                node = node.leftNode;
            }
        }
        while (!output.isEmpty()){
            System.out.println(output.pop().value);
        }
    }
    public void levelTravel(){
        TreeNode node = headNode;
        Queue<TreeNode> queue = new LinkedList<>();
        ArrayList<TreeNode> list = new ArrayList<>();
        ((LinkedList<TreeNode>) queue).add(node);
        while (!queue.isEmpty()){
            node = queue.poll();
            System.out.println(node.value);
            if (node.leftNode != null)
                ((LinkedList<TreeNode>) queue).add(node.leftNode);
            if (node.rightNode != null)
                ((LinkedList<TreeNode>) queue).add(node.rightNode);
        }
    }

    public static void main(String[] args){
        BinaryTree<Integer> binaryTree = new BinaryTree<>();
        Comparator<Integer> comparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        };
        binaryTree.addNode(new TreeNode<Integer>(5), comparator);
        binaryTree.addNode(new TreeNode<Integer>(6), comparator);
        binaryTree.addNode(new TreeNode<Integer>(12), comparator);
        binaryTree.addNode(new TreeNode<Integer>(3), comparator);
        binaryTree.addNode(new TreeNode<Integer>(4), comparator);

        binaryTree.preTravel();
        System.out.println();
        binaryTree.innerTravel();
        System.out.println();
        binaryTree.postTravel();
        System.out.println();
        binaryTree.levelTravel();
    }
}
