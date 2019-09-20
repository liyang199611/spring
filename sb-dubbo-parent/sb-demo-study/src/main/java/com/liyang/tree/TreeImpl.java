package com.liyang.tree;

public class TreeImpl implements Tree{
    private Node  root = null;// 表示根节点
    @Override
    public Node find(int key) {
        Node current = root; // 表示根节点
        while (current!=null){
            if(current.getData()>key) {// 当前值比查找值大，搜索左子数
                current = current.getLeftChild();
            }else if (current.getData()<key){
                current = current.getRightChild();
            }else {
                return current;
            }
        }
        return null;
    }

    @Override
    public boolean insert(int data) {
        Node newNode = new Node(data); // 构造新加入的节点
        if(root == null){ // 当前树为null，没有任何节点
            root = newNode;
            return true;
        }else{
            Node current = root;
            Node parentNode = null;
            while (current!=null){ // 这个地方表明，根节点不为null,
                parentNode = current;
                if(current.getData()>data){
                    current = current.getLeftChild();
                    if(current==null){
                        parentNode.setLeftChild(newNode);
                        return true;
                    }
                }else{
                    current = current.getRightChild();
                    if(current==null){
                        parentNode.setRightChild(newNode);
                        return true;
                    }
                }
            }

        }
        return false;
    }


    @Override
    public boolean delete(int key) {
        Node current = root; // 定义当前节点为root

        return false;
    }

    //后序遍历
    public  void postOrder(Node current){
        if(current != null){
            postOrder(current.getLeftChild());
            postOrder(current.getRightChild());
            System.out.print(current.getData()+" ");
        }
    }

    // 查询最大值
    public Node getMax(){
        Node current = root;
        Node maxNode = current;
        while (current!=null){
            maxNode = current;
            current = current.getRightChild();
        }
        return maxNode;
    }
    public static void main(String [] args){
        TreeImpl tree = new TreeImpl();
        tree.insert(12);
        tree.insert(13);
        tree.insert(14);
        tree.insert(3);
        Node node = tree.find(13);
        System.out.println(node);
        node.display();
        tree.postOrder(tree.root);
        tree.getMax().display();
    }
}
