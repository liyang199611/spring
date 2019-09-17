package com.liyang.mytree;

public class Node {
    private int data;
    private Node left;
    private Node right;

    Node(int data){
        this.data = data;
    }
    public int getData() {
        return data;
    }

    public Node getLeft() {
        return left;
    }

    public Node getRight() {
        return right;
    }

    public void setData(int data) {
        this.data = data;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public void setRight(Node right) {
        this.right = right;
    }
}
