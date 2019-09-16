package com.liyang.tree;

public class Node {
    private int data; //  节点数据
    private Node leftChild; // 左节点数据
    private Node RightChild; // 又节点数据

    public Node getLeftChild() {
        return leftChild;
    }

    public Node getRightChild() {
        return RightChild;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public void setRightChild(Node rightChild) {
        RightChild = rightChild;
    }

    public void setLeftChild(Node leftChild) {
        this.leftChild = leftChild;
    }

    public Node(int data){
        this.data=data;
    }
    // 打印节点内容
    public void display(){
        System.out.println(data);
    }
}
