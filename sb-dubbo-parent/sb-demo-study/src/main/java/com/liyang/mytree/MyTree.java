package com.liyang.mytree;


import java.util.HashMap;
import java.util.Map;

class Tree{

    private Node root = null;
    public boolean insert(int data){
        Node node = new Node(data);
        if(root ==null){
            root = node;
            return true;
        }else{
            Node current = root;
            Node parent = null;
            while (current != null){
                parent = current;
                if(data > current.getData()){
                    current = current.getLeft();
                    if (current==null){
                        parent.setLeft(node);
                        return true;
                    }
                }else{
                    current = current.getRight();
                    if(current!=null){
                        parent.setRight(node);
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public Node find(int key){
        Node current = root;
       while (current!=null){
           if(key>current.getData()){
               current = current.getLeft();
           }else if (key<current.getData()){
               current = current.getRight();
           }else{
               return current;
           }
       }
       return null;
    }

    public Node getMax(){
        Node current = root;
        while (current.getLeft()!= null){
            current = current.getLeft();
        }
        return current;
    }
}
public class MyTree {
    public static void main(String [] args){
        Tree tree = new Tree();
        tree.insert(1);
        tree.insert(2);
        tree.insert(3);
        tree.insert(4);
        tree.insert(6);
        System.out.println(tree.find(2).getData());
        System.out.println(tree.getMax().getData());
        Map map = new HashMap();
        map.get("1");

    }
}
